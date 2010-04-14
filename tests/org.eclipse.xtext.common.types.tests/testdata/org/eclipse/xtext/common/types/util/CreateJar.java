/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CreateJar implements IWorkflowComponent {
	
	private String binPath;
	
	private String targetDir;
	
	private String packagePath;
	
	public void preInvoke() {
	}

	public void invoke(IWorkflowContext ctx) {
		try {
			File binDirectory = new File(binPath + "/" + packagePath);
			if (!binDirectory.exists())
				throw new RuntimeException(binPath + "/" + packagePath);
			File targetDirectory = new File(targetDir);
			if (!targetDirectory.exists())
				throw new RuntimeException(targetDir);
			
			File zipFile = new File(targetDirectory, "testData.jar");
			if (!zipFile.exists())
				zipFile.createNewFile();
			JarOutputStream outputStream = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(zipFile)));
			try {
				for(File classFile: binDirectory.listFiles()) {
					if (classFile.isFile() && classFile.getName().endsWith(".class")) {
						BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(classFile));
						try {
							ZipEntry entry = new ZipEntry(packagePath + "/" + classFile.getName());
							outputStream.putNextEntry(entry);
							byte[] bytes = new byte[4096];
							int readBytes = -1;
							while((readBytes = inputStream.read(bytes)) != -1) {
								outputStream.write(bytes, 0, readBytes);
							}
						} finally {
							outputStream.closeEntry();
							inputStream.close();
						}
						
					}
				}
			} finally {
				outputStream.close();
			}
		} catch(IOException ioe) {
			throw new RuntimeException(ioe);
		}
	}

	public void postInvoke() {
	}

	@Mandatory
	public void setBinPath(String binPath) {
		this.binPath = binPath;
	}

	public String getBinPath() {
		return binPath;
	}

	@Mandatory
	public void setTargetDir(String targetDir) {
		this.targetDir = targetDir;
	}

	public String getTargetDir() {
		return targetDir;
	}

	@Mandatory
	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

	public String getPackagePath() {
		return packagePath;
	}
	
}
