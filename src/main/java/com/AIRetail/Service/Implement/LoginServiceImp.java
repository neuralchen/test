package com.AIRetail.Service.Implement;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.AIRetail.Service.LoginService;

@Service
@EnableTransactionManagement
public class LoginServiceImp implements LoginService {

	public String doLogin(String userlabel, String passwd, boolean remember) {
		UsernamePasswordToken token = new UsernamePasswordToken(userlabel, passwd, null);
        token.setRememberMe(remember);

        // shiro
        try {
            SecurityUtils.getSubject().login(token);
        } catch (UnknownAccountException ex) {
            return "User does not exist or password error!";
        } catch (IncorrectCredentialsException ex) {
            return "User does not exist or password error!";
        } catch (AuthenticationException ex) {
            ex.printStackTrace();
            return ex.getMessage(); // 
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Internal error, please try again!";
        }
        return "SUCC";
	}

	public void doLogout() {
		// TODO Auto-generated method stub
		SecurityUtils.getSubject().logout();
	}

}
