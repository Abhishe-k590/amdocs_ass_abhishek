package genericUtilities;

public interface Pathconstants {
	
	/**
	 * 
	 * 
	 * @author abhishek
	 *
	 *
	 */
	public interface PathConstants {
			String currentproject = System.getProperty("user.dir");
			public int implicitelywait=20;
			public int explicitelywait=30;
			String excelPath=currentproject+"/excel/appdata.xlsx";
			String propertiespath=currentproject+"/file/testdata.properties";
			
	}

}
