package vn.minhtran.study.wsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.minhtran.study.wsm.config.FileManagementProperties;

@Component
public class FileManagementScheduler {

	@Autowired
	private FileManagementProperties props;
	
	public void process() {
		
	}
}
