package YML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.yaml.snakeyaml.Yaml;


public class ReadYml {
	public static void init(InputStream is) {
		String initProcessStep = "Check Status";
//		if(status )
		
//		Con
	}
	
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(new File("D:\\eloanFile\\baseConfig\\baseAppConfig.yml"));
//			init(fis);
			
			Configuration config = new Configuration();
			config.load(fis);
			
			Map<String , String> m = new HashMap(); 
			m.put("1", config.getBaseConfig().get(ConfigConstant.BASE_NAME.getValue()));
			
			
			List<Map<String, Object>> localServiceConfig = config.getMbLocalServicesConfig();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
