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
import java.io.FileNotFoundException;
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
	
	@Override
	public void preInvoke() {
	}

	@Override
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
				String packagePathInJar = packagePath + "/";
				for(File classFile: binDirectory.listFiles()) {
					if (classFile.isFile() && classFile.getName().endsWith(".class") && !classFile.getName().endsWith("$RemoveMe.class")) {
						addToJar(packagePathInJar, classFile, outputStream);
					}
				}
				File rootBindDirectoy = new File(binPath);
				File classFileWithoutPackage = new File(rootBindDirectoy, "ClassWithDefaultPackage.class");
				if (classFileWithoutPackage.isFile()) {
					addToJar("", classFileWithoutPackage, outputStream);
				}
			} finally {
				outputStream.close();
			}
		} catch(IOException ioe) {
			throw new RuntimeException(ioe);
		}
	}

	private void addToJar(String packagePathInJar, File classFile, JarOutputStream jar) throws FileNotFoundException,
			IOException {
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(classFile));
		try {
			ZipEntry entry = new ZipEntry(packagePathInJar + classFile.getName());
			jar.putNextEntry(entry);
			byte[] bytes = new byte[4096];
			int readBytes = -1;
			while((readBytes = inputStream.read(bytes)) != -1) {
				jar.write(bytes, 0, readBytes);
			}
		} finally {
			jar.closeEntry();
			inputStream.close();
		}
	}

	@Override
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
