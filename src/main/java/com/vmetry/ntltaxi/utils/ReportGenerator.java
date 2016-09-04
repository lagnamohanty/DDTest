package com.vmetry.ntltaxi.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.vmetry.ntltaxi.initializer.Initializer;

public class ReportGenerator extends Initializer {
	
	public static void archiveFile() throws IOException{
		
		if(isArchived){
		
		SimpleDateFormat df= new SimpleDateFormat("YYYY-MM-DD-HH-MM-SS-mm");
		String date=df.format(new Date());
		File src=new File("C:\\Users\\prachi\\Desktop\\DDFramework\\screenshot");
		File dst= new File("C:\\Users\\prachi\\Desktop\\DDFramework\\archiveFiles\\old_"+date);
		FileUtils.copyDirectory(src, dst);
		FileUtils.cleanDirectory(src);
		isArchived=false;
		}
	}

}
