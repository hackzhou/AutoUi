package com.jdd.game.android.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	
	/**
	 * 读取文件内容
	 * @param pathFile
	 * @return
	 */
	public String readFile(String pathFile){
		File file = new File(pathFile);
	    if (file.exists() && file.isFile()) {
	    	BufferedReader reader = null;
			try {
				StringBuffer sb = new StringBuffer();
				reader = new BufferedReader(new FileReader(file));
				String tempString = null;
				while ((tempString = reader.readLine()) != null) {
					sb.append(tempString + "\r\n");
				}
				return sb.toString();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(reader != null){
						reader.close();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
	    }
		return null;
	}
	
	/**
	 * 内容写入文件
	 * @param pathFile
	 * @param source
	 * @return
	 */
	public boolean writeFile(String pathFile, String text){
		BufferedWriter bw = null;
		try {
			File file = new File(pathFile);
		    if(file.exists() && file.isFile()) {
		    	bw = new BufferedWriter(new FileWriter(file));
				bw.write(text);
				bw.flush();
				return true;
		    }
		    return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(bw != null){
					bw.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * 判断文件夹是否存在
	 * @param destDirName
	 * @return
	 */
	public boolean existsDir(String destDir) {
        File dir = new File(destDir);
        if (dir.exists() && dir.isDirectory()) {
            return true;
        } else {
        	return false;
        }
    }
	
	/**
	 * 创建文件夹
	 * @param destDirName
	 * @return
	 */
	public boolean createDir(String destDir) {
        File dir = new File(destDir);
        if (!destDir.endsWith(File.separator)) {
        	destDir = destDir + File.separator;
        }
        if (dir.mkdirs()) {
            return true;
        } else {
            return false;
        }
    }
	
	/**
	 * 删除文件
	 * @param pathFile
	 * @return
	 */
	public boolean deleteFile(String pathFile) {
		File file = new File(pathFile);
	    if (file.isFile() && file.exists()) {
	        file.delete();
	        return true;
	    }
	    return false;
	}

}
