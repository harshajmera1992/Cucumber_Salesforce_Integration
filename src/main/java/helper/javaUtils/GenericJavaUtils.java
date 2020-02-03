package helper.javaUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import constants.ApplicationConstants;

public class GenericJavaUtils {

	public static ArrayList<String> getFeatureFilesToExecute(){
		ArrayList<String> featuresList = new ArrayList<String>(); 
		List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>(); 
		dataList = ExcelDataReader.data(ApplicationConstants.SYSTEM_PATH+"//src//test//resources//testsToExecute//Test_To_Execute.xlsx", "Features");
		for(int i=0; i<dataList.size(); i++){
			if(dataList.get(i).get("Execute").equalsIgnoreCase("Yes")){
				featuresList.add(dataList.get(i).get("FeatureFileName"));
			}
		}
		return featuresList;
	}
	
}
