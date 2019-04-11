package YML;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

//import com.cs.baseapp.errorhandling.BaseAppException;
//import com.cs.baseapp.logger.LogManager;
//import com.cs.baseapp.utils.ConfigConstant;
import com.cs.log.logs.LogInfoMgr;
import com.cs.log.logs.bean.Logger;

public class Configuration {
	private Map<String, String> baseConfig = new HashMap<>();

	private Map<String, String> envConfig = new HashMap<>();

	private List<Map<String, Object>> filterConfig = new ArrayList<>();

	private Map<String, Object> authRulesConfig = new HashMap<>();

	private List<Map<String, Object>> mbSendersCondig = new ArrayList<>();

	private List<Map<String, Object>> mbReceiversConfig = new ArrayList<>();

	private List<Map<String, Object>> mbListenersConfig = new ArrayList<>();

	private List<Map<String, Object>> mbLoaclServicesConfig = new ArrayList<>();

	private List<Map<String, Object>> mbRemoteServicesConfig = new ArrayList<>();

	private List<Map<String, Object>> mbEventManagerConfig = new ArrayList<>();

	private Map<String, String> repositoryConfig = new HashMap<>();

//	private Logger logger = LogManager.getSystemLog();

	private String processKey = "";

	@SuppressWarnings("unchecked")
	public void load(InputStream is) {
		try {
			Yaml yamlConfig = new Yaml();
			Map<String, Object> m = yamlConfig.load(is);
			Map<String, Object> dtl = (Map<String, Object>) m.entrySet().iterator().next().getValue();
			//base
			this.processKey = ConfigConstant.BASE.getValue();
			//{name=eloanMS, version=v01, applicationId=eloan-web-ui, secret=244bedb3-9563-42de-8217-d13e4a1f7263}
			this.baseConfig = (Map<String, String>) dtl.get(ConfigConstant.BASE.getValue());
			
			this.processKey = ConfigConstant.ENV.getValue();
			//{KEY_1=VALUE_1, KEY_2=VALUE_2}
			this.envConfig = (Map<String, String>) dtl.get(ConfigConstant.ENV.getValue());
			
			this.processKey = ConfigConstant.AUTH_RULES.getValue();
			//{authToken=[{id=oauth2-Oidc-refreshToken, implementClass=com.cs.baseapp.api.auth.DefaultOauth2OidcRefreshTokenHandler, isDefault=true, parameters={token_endpoint=http://10.39.107.141:18080/auth/realms/CS/protocol/openid-connect/token, KEY_2=VALUE_2}}], rules=[{id=httpOauth2OidcAuth, authTokenId=oauth2-Oidc-refreshToken, clients=[{clientId=eloan-web-ui, roles=service, orgUnit, user, isAuth=true}], parameters={userinfo_endpoint=http://10.39.107.141:18080/auth/realms/CS/protocol/openid-connect/userinfo, KEY_2=Value_2}}]}
			this.authRulesConfig = (Map<String, Object>) dtl.get(ConfigConstant.AUTH_RULES.getValue());
			this.processKey = ConfigConstant.WEB_MESSAGE_FILTER.getValue();
			//[{id=filter1, implementClass=com.cs.baseapp.api.auth.DefaultOauth2OidcAuthMsgFilter, desc=AuthMsgFileter filter 1, urlPattern=/*, authRuleId=httpOauth2OidcAuth, parameters={KEY_1=value1, KEY_2=value2}}, 
			//{id=filter2, implementClass=com.cs.baseapp.api.filter.DefaultMsgProcWebFilter, desc=eloan filter 1, urlPattern=/*, parameters={KEY_1=value1, KEY_2=value2}}]
			this.filterConfig = (List<Map<String, Object>>) dtl.get(ConfigConstant.WEB_MESSAGE_FILTER.getValue());
			this.processKey = ConfigConstant.MESSAGE_BROKER.getValue();
			
			//{sender=[{id=rest-sender, desc=rest sender, implementClass=com.cs.baseapp.api.messagebroker.entity.DefaultRestSender, poolSize=-1, parameters={URI=http://10.39.107.141:18280/MSStandingDataWebApplication/, METHOD=POST}}], 
			//receiver=null, listener=null, events=[{name=TestHandler, handlerClass=com.cs.baseapp.api.messagebroker.event.TestEventHandler, parameters={KEY_1=V1, KEY_2=V2}}], services={local=[{id=eLOAN-TRANSACTION, 
			//implementClass=com.cs.product.eloan.service.TransactionService, parameters={KEY_1=value1, KEY_2=value2}}, {id=eLOAN-HOUSEKEEPING, implementClass=com.cs.product.eloan.service.HouseKeepingService, parameters={KEY_1=value1, KEY_2=value2}}, {id=eLOAN-RELEASE, implementClass=com.cs.product.eloan.service.ReleaseService, parameters={KEY_1=value1, KEY_2=value2}}, {id=eLOAN-BATCHDATA, implementClass=com.cs.product.eloan.service.GetBatchData, parameters={KEY_1=value1, KEY_2=value2}}, {id=eLOAN-STANDINGDATA, implementClass=com.cs.product.eloan.service.StandingDataService, parameters={KEY_1=value1, KEY_2=value2}}, {id=eLOAN-CATALOG, implementClass=com.cs.product.eloan.service.CatalogService, parameters={KEY_1=value1, KEY_2=value2}}, {id=eLOAN-GETDATA, implementClass=com.cs.product.eloan.service.GetDataService, parameters={KEY_1=value1, KEY_2=value2}}, {id=eLOAN-TRXDATA, implementClass=com.cs.product.eloan.service.TrxDataService, parameters={KEY_1=value1, KEY_2=value2}}, {id=eLOAN-AUTHINFO, implementClass=com.cs.product.eloan.service.AuthInfoService, parameters={KEY_1=value1, KEY_2=value2}}, {id=eLOAN-UNITINFO, implementClass=com.cs.product.eloan.service.UnitInfoService, parameters={KEY_1=value1, KEY_2=value2}}, {id=eLOAN-SECURITY, implementClass=com.cs.product.eloan.service.SecurityService, parameters={KEY_1=value1, KEY_2=value2}}, {id=eLOAN-INQUIRE, implementClass=com.cs.product.eloan.service.InquireService, parameters={KEY_1=value1, KEY_2=value2}}], remote=[{id=StandingData-COUNTRY, tranformClass=com.cs.baseapp.api.messagebroker.entity.DefaultTranslationMessage, senderId=rest-sender, receiverId=null, msgStore=false, parameters={K1=V1}}, {id=StandingData-CURRENCY, tranformClass=com.cs.baseapp.api.messagebroker.entity.DefaultTranslationMessage, senderId=rest-sender, receiverId=null, msgStore=false, parameters={K1=V1}}, {id=StandingData-HOLIDAY, tranformClass=com.cs.baseapp.api.messagebroker.entity.DefaultTranslationMessage, senderId=rest-sender, receiverId=null, msgStore=false, parameters={K1=V1}}, {id=StandingData-EXCHANRATE, tranformClass=com.cs.baseapp.api.messagebroker.entity.DefaultTranslationMessage, senderId=rest-sender, receiverId=null, msgStore=false, parameters={K1=V1}}, {id=StandingData-BUSINESSUNIT, tranformClass=com.cs.baseapp.api.messagebroker.entity.DefaultTranslationMessage, senderId=rest-sender, receiverId=null, msgStore=false, parameters={K1=V1}}, {id=StandingData-GETDATEFORMAT, tranformClass=com.cs.baseapp.api.messagebroker.entity.DefaultTranslationMessage, senderId=rest-sender, receiverId=null, msgStore=false, parameters={K1=V1}}, {id=StandingData-GETAMOUNTDELIMITER, tranformClass=com.cs.baseapp.api.messagebroker.entity.DefaultTranslationMessage, senderId=rest-sender, receiverId=null, msgStore=false, parameters={K1=V1}}, {id=StandingData-SECBUSINESSUNIT, tranformClass=com.cs.baseapp.api.messagebroker.entity.DefaultTranslationMessage, senderId=rest-sender, receiverId=null, msgStore=false, parameters={K1=V1}}, {id=StandingData-ACCOUNTNUMBER, tranformClass=com.cs.baseapp.api.messagebroker.entity.DefaultTranslationMessage, senderId=rest-sender, receiverId=null, msgStore=false, parameters={K1=V1}}]}, repository={parameters={K1=V1, K2=V2}}}
			Map<String, Object> mbConfig = (Map<String, Object>) dtl.get(ConfigConstant.MESSAGE_BROKER.getValue());
			this.processKey = ConfigConstant.SENDER.getValue();
			
			//[{id=rest-sender, desc=rest sender, implementClass=com.cs.baseapp.api.messagebroker.entity.DefaultRestSender, poolSize=-1, parameters={URI=http://10.39.107.141:18280/MSStandingDataWebApplication/, METHOD=POST}}]
			this.mbSendersCondig = (List<Map<String, Object>>) mbConfig.get(ConfigConstant.SENDER.getValue());
			this.processKey = ConfigConstant.RECRIVER.getValue();
			//null
			this.mbReceiversConfig = (List<Map<String, Object>>) mbConfig.get(ConfigConstant.RECRIVER.getValue());
			this.processKey = ConfigConstant.LISTENER.getValue();
			this.mbListenersConfig = (List<Map<String, Object>>) mbConfig.get(ConfigConstant.LISTENER.getValue());
			this.processKey = ConfigConstant.EVENTS.getValue();
			this.mbEventManagerConfig = (List<Map<String, Object>>) mbConfig.get(ConfigConstant.EVENTS.getValue());
			this.processKey = ConfigConstant.SERVICES.getValue();
			
			
			Map<String, Object> serviceConfig = (Map<String, Object>) mbConfig.get(ConfigConstant.SERVICES.getValue());
			this.processKey = ConfigConstant.LOACL_SERVICE.getValue();
			this.mbLoaclServicesConfig = (List<Map<String, Object>>) serviceConfig
					.get(ConfigConstant.LOACL_SERVICE.getValue());
			this.processKey = ConfigConstant.REMOTE_SERVICE.getValue();
			this.mbRemoteServicesConfig = (List<Map<String, Object>>) serviceConfig
					.get(ConfigConstant.REMOTE_SERVICE.getValue());
			this.processKey = ConfigConstant.REPOSITORY.getValue();
			Map<String, Object> repositoryConfigs = (Map<String, Object>) mbConfig
					.get(ConfigConstant.REPOSITORY.getValue());
			if (repositoryConfigs != null) {
				this.repositoryConfig = (Map<String, String>) repositoryConfigs
						.get(ConfigConstant.PARAMETERS.getValue());
			}
			
//			System.out.println();
		} catch (Exception e) {
//			logger.write(LogManager.getServiceLogKey(),
//					new BaseAppException(e, LogInfoMgr.getErrorInfo("ERR_0004", this.processKey)));
		}
	}

	public Map<String, String> getBaseConfig() {
		return this.baseConfig == null ? new HashMap<>() : this.baseConfig;
	}

	public Map<String, String> getEnvConfig() {
		return this.envConfig == null ? new HashMap<>() : this.envConfig;
	}

	public List<Map<String, Object>> getFilterConfig() {
		return this.filterConfig == null ? new ArrayList<>() : this.filterConfig;
	}

	public List<Map<String, Object>> getMbSendersConfig() {
		return this.mbSendersCondig == null ? new ArrayList<>() : this.mbSendersCondig;
	}

	public List<Map<String, Object>> getMbReceiversConfig() {
		return this.mbReceiversConfig == null ? new ArrayList<>() : this.mbReceiversConfig;
	}

	public List<Map<String, Object>> getMbListenersConfig() {
		return this.mbListenersConfig == null ? new ArrayList<>() : this.mbListenersConfig;
	}

	public List<Map<String, Object>> getMbLocalServicesConfig() {
		return this.mbLoaclServicesConfig == null ? new ArrayList<>() : this.mbLoaclServicesConfig;
	}

	public List<Map<String, Object>> getMbRemoteServicesConfig() {
		return this.mbRemoteServicesConfig == null ? new ArrayList<>() : this.mbRemoteServicesConfig;
	}

	public Map<String, String> getRepositoryConfig() {
		return this.repositoryConfig == null ? new HashMap<>() : this.repositoryConfig;
	}

	public Map<String, Object> getAuthRulesConfig() {
		return this.authRulesConfig == null ? new HashMap<>() : this.authRulesConfig;
	}

	public List<Map<String, Object>> getMbEventManagerConfig() {
		return this.mbEventManagerConfig;
	}
}
