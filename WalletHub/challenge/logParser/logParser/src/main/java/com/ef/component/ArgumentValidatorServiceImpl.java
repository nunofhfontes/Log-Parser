package com.ef.component;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.ef.common.Constant;
import com.ef.service.ArgumentValidatorService;

@Component
public class ArgumentValidatorServiceImpl implements ArgumentValidatorService {

	@Override
	public Boolean validateLogParserArguments(Map<String, String> paramsMap) {
		
		Boolean result = Boolean.TRUE;
		
		for(String tmpMandatoryParamName : Constant.MANDATORY_PARAMS) {
			if(!paramsMap.containsKey(tmpMandatoryParamName)) {
				System.out.println(tmpMandatoryParamName);
				return Boolean.FALSE;
			}
		}
		
		return result;
	}


}
