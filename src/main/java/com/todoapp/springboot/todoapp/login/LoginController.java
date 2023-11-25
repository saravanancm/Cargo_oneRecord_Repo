package com.todoapp.springboot.todoapp.login;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.todoapp.springboot.todoapp.todo.Todo;

@Controller
@SessionAttributes("userName")
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public static Map<String, String> userHomeMap = new HashMap<String, String>();
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping(value = "userLogin", method = RequestMethod.GET)
	public String userLogin() {
		logger.debug("Inside LoginController.goToLoginPage");
		return "userLogin";
	}
	
	@RequestMapping(value = "loginDoha", method = RequestMethod.GET)
	public String loginDoha() {
		logger.debug("Inside LoginController.goToLoginPage");
		return "loginDoha";
	}
	
	@RequestMapping(value = "userLoginOld", method = RequestMethod.POST)
	public String userLoginValidate(@RequestParam String userName, @RequestParam String userPwd, ModelMap model) {		
		if(authenticationService.validateUserDtls(userName, userPwd)) {
			System.out.println("authenticationService.validateUserDtls completed");
			model.put("userName", userName);
			return "redirect:userHome";
		} 
		return "redirect:loginError";
	}
	
	@RequestMapping(value = "userLogin", method = RequestMethod.POST)
	public String userLoginValidate(@RequestBody Todo loginInput, ModelMap model) {
		
		userHomeMap.put("dohagha", "dohaHome.html");
		userHomeMap.put("fragha", "fraHome.html");
		userHomeMap.put("dhakagha", "dhakaHome.html");
		
		System.out.println("authenticationService.validateUserDtls completed");
		String userName = String.valueOf(loginInput.getUserName());
		String userPwd  = String.valueOf(loginInput.getUserPwd());
		System.out.println("authenticationService.validateUserDtls completed");
		if(authenticationService.validateUserDtls(userName, userPwd)) {
			System.out.println("authenticationService.validateUserDtls completed");
			model.put("userName", userName);
			return userHomeMap.get(userName);
			//return "home.html";
		} 
		return "redirect:error.html";
	}

	
}
