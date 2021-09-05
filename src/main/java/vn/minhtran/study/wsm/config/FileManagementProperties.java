package vn.minhtran.study.wsm.config;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.unit.DataSize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileManagementProperties {
	private Reporter reporter;
	private Map<String, Action> actions = new HashMap<>();
	private List<File> files = new ArrayList<File>();

	@Getter
	@Setter
	public static class Action {

		private String action;

	}

	@Getter
	@Setter
	private static class Reporter {
		private boolean enabled;
		private String schedule;
		private Map<String, Rule> rules = new HashMap<>();

	}

	public interface Rule {

	}

	@Getter
	@Setter
	public static class SizeRule implements Rule {
		private DataSize largerThan;
	}

	@Getter
	@Setter
	public static class ObsoletedRule implements Rule {
		private Duration olderThan;
	}
}
