package vn.minhtran.study.workspacemanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import vn.minhtran.study.wsm.controller.ValidationManager;
import vn.minhtran.study.wsm.model.SuspectedFile;

@SpringBootTest
class ValidationManagerTests {

	ValidationManager vm = new ValidationManager();

	@Test
	void contextLoads() {
		SuspectedFile sf = new SuspectedFile();
		sf.setFile(null);
		sf.setSize(5000L);
		sf.setLastModified(34000000000L);
		vm.validate(sf);
	}

}
