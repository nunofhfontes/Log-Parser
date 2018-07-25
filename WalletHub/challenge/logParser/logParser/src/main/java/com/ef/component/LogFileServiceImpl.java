package com.ef.component;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ef.service.LogFileLoaderService;
import com.ef.service.LogFileService;
import com.ef.service.LogParserService;

@Component
public class LogFileServiceImpl implements LogFileService {

	@Autowired
	private LogFileLoaderService logFileLoaderService;
	
	@Autowired
	private LogParserService logParserService;
	
	@Override
	public File loadLogFile(Map<String, String> paramsMap) {
		
		return logFileLoaderService.loadLogFile(paramsMap);
	}

	@Override
	public void parseLog(File fileToParse) {

		logParserService.parseLog(fileToParse);
	}

	
	
}
