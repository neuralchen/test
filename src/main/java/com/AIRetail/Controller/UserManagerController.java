package com.AIRetail.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.AIRetail.Service.LoginService;
import com.AIRetail.Service.UserManagerService;
import com.AIRetail.Service.Implement.LoginServiceImp;

@Controller
public class UserManagerController {
	private final Logger logger = LoggerFactory.getLogger(UserManagerController.class);
	@Autowired	
	private LoginService loginService;	
	
	@RequestMapping(value = "login")
	public String Login() {
		return "login";
	}
	
	@RequestMapping(value="dologin",method=RequestMethod.POST)
	public String doLogin(@ModelAttribute(value="userlabel") String userlabel,@ModelAttribute(value="passwd") String passwd,@ModelAttribute(value="rememberme") String rememberme,Model model) {
		logger.info("µÇÂ½ÐÅÏ¢£º"+userlabel+"-"+passwd);
		String info = loginService.doLogin(userlabel, passwd, (new Boolean(rememberme)).booleanValue());
        if (!"SUCC".equals(info)) {
            model.addAttribute("failMsg", "wrong user name or password!");
            return "login";
        } else {
            model.addAttribute("successMsg", "login Succ!");
            model.addAttribute("name", userlabel);
            return "customersstatistics";
        }
	}
	@RequestMapping(value="dologout")
	public String doLogout() {
		loginService.doLogout();
		return "login";
	}
}
