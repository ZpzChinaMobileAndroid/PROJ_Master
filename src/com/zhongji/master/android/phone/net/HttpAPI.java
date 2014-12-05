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
	
	/** 单个公司*/
	public static final String COMPANY_only= "CompanyBaseInformation/GetCompanyBaseInformation?CompanyBaseInformationId={CompanyBaseInformationId}";
	
	/** 搜索公司*/
	public static final String COMPANY_SEACH= "CompanyBaseInformation/GetCompanyBaseInformation?KeyWords=keyWords&pageIndex=0&pageSize=5";
	
	/** 获取我的公司*/
	public static final String COMPANY_MYSELF= "CompanyBaseInformation/GetMyCompany?PageIndex=0&PageSize=10";
	
	/** 获取公司员工*/
	public static final String COMPANY_GETSTAFF= "CompanyBaseInformation/GetCompanyEmployees?PageSize=0&PageIndex=10";

	/** 添加关注*/
	public static final String COMPANY_ATTENTION= "networking/addUserFocus";
	
	/** 取消关注*/
	public static final String COMPANY_CANCELATTENTION= "networking/DeleteFocus";
	
	/** 获取产品*/
	public static final String PROJUCT_ALL= "ProductInformation/ProductInformation?pageSize=5&pageIndex=0";
	
	/** 发布动态*/
	public static final String PUBLISH_DYNAMIC= "ActiveCenter/SendActives";
	
	/** 发布产品*/
	public static final String PUBLISH_PRODUCT= "ProductInformation/AddProductInformation";
	
	/** 动态列表*/
	public static final String DYNAMIC_LIST= "ActiveCenter/Actives";
	
	/** 添加公司申请认证*/
	public static final String COMPANY_APPLY= "CompanyBaseInformation/AddCompanyEmployees";
	
	
}
