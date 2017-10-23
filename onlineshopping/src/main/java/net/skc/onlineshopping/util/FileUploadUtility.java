package net.skc.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "D:\\Shivam\\1st-online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {

		// get the real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		logger.info(REAL_PATH);
		
		//make sure all the directories exists\
		//if not then create them 
		if(! new File(ABS_PATH).exists()) {
			// creating directories 
			new File(ABS_PATH).mkdirs(); // make the directories mkdirs will make sure all the directories are created
		}
		
		if(! new File(REAL_PATH).exists()) {
			// creating directories 
			new File(REAL_PATH).mkdirs(); // make the directories mkdirs will make sure all the directories are created
		}
		
		try{
			// server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			// file directory upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
			
		}
		catch(IOException e) {
			
		}
		
	}
}
