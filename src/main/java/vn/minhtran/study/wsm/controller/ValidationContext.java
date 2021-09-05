package vn.minhtran.study.wsm.controller;

import lombok.Getter;
import lombok.Setter;
import vn.minhtran.study.wsm.model.SuspectedFile;

@Getter
@Setter
public class ValidationContext {

	private boolean isValid = true;
	private SuspectedFile suspectedFile;
}
