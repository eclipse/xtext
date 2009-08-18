/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.releng;

import static org.eclipse.xtext.releng.Helper.*;

import java.io.File;
import java.io.FileFilter;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class GetNonIpApprovedJars {

	/**
	 * 
	 * downloads, extracts and copies ant-contrib and ant4eclipse to org.eclipse.dash.common.releng/lib
	 * 
	 */
	public static void main(String[] args) throws Exception {
		try {
			
			String dash_lib = "./../org.eclipse.dash.common.releng/lib/";
			String dash_lib_temp = dash_lib+"temp/";
			
			File tempDir = new File(dash_lib_temp);
			delete(tempDir);
			ensureDirExists(tempDir);
			// antr contrib
			downloadFile(dash_lib_temp, "http://downloads.sourceforge.net/ant-contrib/ant-contrib-1.0b3-bin.zip");
			extract(dash_lib_temp + "ant-contrib-1.0b3-bin.zip", dash_lib_temp);
			String from = dash_lib_temp + "ant-contrib/ant-contrib-1.0b3.jar";
			String to = dash_lib + "ant-contrib.jar";
			rename(from, to);

			// antr contrib
			downloadFile(dash_lib_temp,
					"http://downloads.sourceforge.net/project/ant4eclipse/ant4eclipse/0.5.0.RC1/ant4eclipse-plugin-0.5.0.rc1a.tar.gz");
			try {
				extract(dash_lib_temp + "ant4eclipse-plugin-0.5.0.rc1a.tar.gz", dash_lib_temp);
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
			}
			String from2 = dash_lib_temp + "plugins/net.sf.ant4eclipse.plugin_0.5.0.rc1/lib/ant4eclipse-0.5.0.rc1.jar";
			String to2 = dash_lib + "ant4eclipse.jar";
			rename(from2, to2);

			delete(tempDir);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean rename(String from, String to) {
		return new File(from).renameTo(new File(to));
	}
}
