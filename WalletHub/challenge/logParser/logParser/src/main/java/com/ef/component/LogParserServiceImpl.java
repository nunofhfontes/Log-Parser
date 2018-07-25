package com.ef.component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.ef.common.Constant;
import com.ef.domain.LogEntry;
import com.ef.service.LogParserService;

@Component
public class LogParserServiceImpl implements LogParserService {

	@Override
	public void parseLog(File fileToParse) {
		
		if(Objects.isNull(fileToParse)) {
			System.out.println("No File gotten from LogFileService");
			return;
		}
		
		FileReader fileReader;
		
		try {
			fileReader = new FileReader(fileToParse);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Could not read file");
			return;
		}
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		bufferedReader.lines().forEach((eachLine) -> {
			String[] separatedLine = eachLine.split(Constant.SEPARATOR);
			
			if(separatedLine.length == Constant.LOG_PATTERN_LENGTH) {
				for(int i=0; i < separatedLine.length; i++) {
					System.out.println(separatedLine[i]);
				}
			}
			
			LogEntry newLogEntry = new LogEntry(separatedLine[Constant.IP_POS], 
			                             separatedLine[Constant.DATE_POS], 
			                             separatedLine[Constant.REQUEST_POS], 
			                             separatedLine[Constant.STATUS_POS], 
			                             separatedLine[Constant.STATUS_POS]);
			
		});
		
		try {
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			//Closed readers
		}
		
	}
	
}
