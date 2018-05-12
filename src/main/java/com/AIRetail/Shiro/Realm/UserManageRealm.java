package com.AIRetail.Shiro.Realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.AIRetail.Entity.UserEntity;
import com.AIRetail.Service.*;
import com.AIRetail.Service.Implement.*;


public class UserManageRealm extends AuthorizingRealm{
	
	public UserManagerService getUserService() {
		return userService;
	}

	public void setUserService(UserManagerService userService) {
		this.userService = userService;
	}

	private UserManagerService userService;
	
	//获得用户的授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Integer userid = (Integer)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.getRoles(userid));
        return authorizationInfo;
    }

    //验证用户
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String userlabel = (String)token.getPrincipal();

        UserEntity user = userService.findByUsername(userlabel);

        if(user == null) {
            throw new UnknownAccountException();//娌℃壘鍒板笎鍙�
        }

//        if(Boolean.TRUE.equals(user.getLocked())) {
//            throw new LockedAccountException(); //甯愬彿閿佸畾
//        }

        //浜ょ粰AuthenticatingRealm浣跨敤CredentialsMatcher杩涜瀵嗙爜鍖归厤锛屽鏋滆寰椾汉瀹剁殑涓嶅ソ鍙互鑷畾涔夊疄鐜�
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserlabel(), //鐢ㄦ埛鍚�
                user.getPasswd(),ByteSource.Util.bytes("cao"),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
