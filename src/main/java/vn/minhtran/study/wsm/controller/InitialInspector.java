package vn.minhtran.study.wsm.controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InitialInspector extends AbstractInspector
        implements FileInspector {

	public InitialInspector(ValidationContext context,
	        FileInspector nextInspector) {
		super(context, nextInspector);
	}

	@Override
	protected void actualValidate() {
		log.info("Initial inspector is working...");
	}

}
