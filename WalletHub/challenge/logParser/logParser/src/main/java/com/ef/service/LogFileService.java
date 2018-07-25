package com.ef.service;

import java.io.File;
import java.util.Map;

public interface LogFileService {

	public File loadLogFile(Map<String, String> paramsMap);
	
	public void parseLog(File fileToParse);
}
