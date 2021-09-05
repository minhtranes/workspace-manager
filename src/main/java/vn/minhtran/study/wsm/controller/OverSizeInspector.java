package vn.minhtran.study.wsm.controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OverSizeInspector extends AbstractInspector
        implements FileInspector {

	public OverSizeInspector(ValidationContext context,
	        FileInspector nextInspector) {
		super(context, nextInspector);
	}

	@Override
	protected void actualValidate() {
		log.info("Over size inspector is working...");
	}

}
