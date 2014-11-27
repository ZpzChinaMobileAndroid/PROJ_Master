package com.zhongji.master.android.phone.net;

/**
 * @package com.suntime.microsearch.net
 * @description:
 * @version v1.0
 * @author JackieCheng
 * @email xiaming5368@163.com
 * @date 2014-7-23 下午4:21:46
 */
public class HttpAPI {

	public static final int HTTP_SUCCESS_CODE = 200;
	public static final int HTTP_TIME_OUT = 0;
	public static final int HTTP_NOT_FOUND_SERVICE = 404;
	public static final int HTTP_SERVER_ERROR = 500;
	public static final int HTTP_MISDAKE_CODE = 400;
	
	
	/** 用户根据账号密码登录 */
	public static final String USERS_LOGIN = "account/login";
	
	/** 注册 */
	public static final String USERS_REGISTER= "account/register2";
	
	/** 所有公司*/
	public static final String COMPANY_ALLNAME= "CompanyBaseInformation/GetCompanyBaseInformation";
	
}
