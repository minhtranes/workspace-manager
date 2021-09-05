package vn.minhtran.study.wsm.model;

import java.io.File;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuspectedFile {
	private File file;
	private Long size;
	private long lastModified;
	private boolean isViolated;
}
