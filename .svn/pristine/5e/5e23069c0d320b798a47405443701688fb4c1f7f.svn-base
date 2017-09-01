package filter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class videoFilter extends FileFilter {
	// 可接收的文件类型,.mp3,.wav,.mid,.rm,.rmvb,.flv,.swf,.wmv  
	 private String[] accepts;  
	 
	 public void FileNameFilter(String[] accepts) {  
		  this.accepts = accepts;  
	}  
	@Override
	public boolean accept(File f) {
		boolean ok = false; 
		if (f.isFile()) {  
			for(String ext : accepts) {  
				if (f.getName().endsWith(ext)) {  
					ok = true;  
					break;  
				}  
			}     
		}else{  
			ok = true;  
		}  
		return ok;  
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
