package com.ef.service;

import java.io.File;
import java.util.Map;

public interface LogFileLoaderService {
	
	public File loadLogFile(Map<String, String> paramsMap);

}
