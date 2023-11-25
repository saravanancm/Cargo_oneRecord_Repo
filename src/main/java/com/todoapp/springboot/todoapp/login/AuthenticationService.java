package com.todoapp.springboot.todoapp.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {
	public boolean validateUserDtls(String userName, String userPwd) {
		Map<String, String> users = new HashMap<String, String>();
		users.put("dhakagha", "dhakagha");
		users.put("dohagha", "dohagha");
		users.put("fragha", "fragha");
		boolean authMatch=false;
		if(userName != null && users.get(userName).equals(userPwd)) {
			authMatch=true;
		}
		return authMatch;
//		boolean userNameValidate = "dhakagha".equals(userName);
//		boolean userPwdValidate = "dhakagha".equals(userPwd);
//		return (userNameValidate && userPwdValidate);
	}
}
