package com.zhongji.master.android.phone.net;

/**
 *接口详情
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
	public static final String COMPANY_ALL= "CompanyBaseInformation/GetCompanyBaseInformation";
	
	/**添加公司*/
	public static final String COMPANY_ADD= "CompanyBaseInformation/AddCompanyBaseInformation";
	
	/** 搜索公司*/
	public static final String COMPANY_SEACH= "CompanyBaseInformation/SearchCompany?KeyWords={KeyWords}&PageIndex={PageIndex}&PageSize={PageSize}";
	
	/** 获取我的公司*/
	public static final String COMPANY_MYSELF= "CompanyBaseInformation/GetMyCompany?PageIndex={PageIndex}&PageSize={PageSize}";
	
	/** 获取公司员工*/
	public static final String COMPANY_GETSTAFF= "CompanyBaseInformation/GetCompanyEmployees?PageSize={PageSize}&PageIndex={PageIndex}";

	/** 添加关注*/
	public static final String COMPANY_ATTENTION= "networking/addUserFocus";
	
	/** 取消关注*/
	public static final String COMPANY_CANCELATTENTION= "networking/DeleteFocus";
	
	
	
}
