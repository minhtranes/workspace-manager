package vn.minhtran.study.wsm.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import vn.minhtran.study.wsm.config.FileManagementProperties;
import vn.minhtran.study.wsm.model.SuspectedFile;

@Component
@Slf4j
public class FileManagementScheduler {

	@Autowired
	private FileManagementProperties props;
	@Value("${file-management.reporter.enabled}")
	private boolean enabled;

	private Map<String, Long> store = new ConcurrentHashMap<>();

	@Scheduled(cron = "${file-management.reporter.schedule}")
	public void scan() {
		if (!enabled) {
			log.info("File schedule was disabled");
			return;
		}

		props.getFiles().parallelStream().forEach(this::scanDirectory);
	}

	private void scanDirectory(File f) {
		if (f.isDirectory()) {
			Arrays.stream(f.listFiles()).forEach(this::scanDirectory);
		} else {
			if (!store.containsKey(f.getAbsolutePath())) {
				try {
					store.put(f.getAbsolutePath(), System.currentTimeMillis());
					if (f.getName().endsWith("jar")) {
						SuspectedFile vf = inspectFile(f);
						log.info("Inspected file {} - violated: {}",
						        f.getAbsolutePath(), vf.isViolated());

						if (vf.isViolated()) {
							processViolatedFile(vf);
						}
					}

				} catch (Exception e) {
					log.warn("Failed to scan file {}", f.getAbsolutePath());
				}
			}

		}
	}

	private void processViolatedFile(SuspectedFile vf) {

	}

	@Autowired
	private ValidationManager validationManager;

	private SuspectedFile inspectFile(File f) throws IOException {
		SuspectedFile sf = new SuspectedFile();
		sf.setFile(f);
		sf.setSize(Files.size(f.toPath()));
		sf.setLastModified(f.lastModified());
		sf.setViolated(validationManager.validate(sf));

		return sf;
	}
}
