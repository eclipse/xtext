/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.performance.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

import com.google.common.collect.Lists;

/**
 * Collects "real world" Java and Xtend source from a list of packages
 * and copies them to text files of a target folder.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CopySourceToText implements IWorkflowComponent {

	private List<String> packages = Lists.newArrayList();
	private String sourceDirectory;
	private String targetDirectory;
	
	@Override
	public void preInvoke() {
	}

	@Override
	public void invoke(IWorkflowContext ctx) {
		try {
			for(String pack: packages) {
				String packagePath = pack.replace('.', '/');
				File sourcePackage = new File(new File(sourceDirectory), packagePath);
				if (!sourcePackage.exists())
					throw new RuntimeException(sourcePackage.getAbsolutePath());
				File targetPackage = new File(new File(targetDirectory), packagePath);
				if (!targetPackage.exists() && !targetPackage.mkdirs()) {
					throw new RuntimeException(targetPackage.getAbsolutePath());
				}
				for(File file: sourcePackage.listFiles()) {
					String fileName = file.getName();
					if (file.isFile() && (fileName.endsWith(".java") || fileName.endsWith(".xtend"))) {
						File target = new File(targetPackage, fileName + ".txt");
						if (!target.exists()) {
							target.createNewFile();
						}
						FileChannel javaInputChannel = null;
						FileChannel textOutputChannel = null;
						try {
							javaInputChannel = new FileInputStream(file).getChannel();
							textOutputChannel = new FileOutputStream(target).getChannel();
							textOutputChannel.transferFrom(javaInputChannel, 0, javaInputChannel.size());
						}
						finally {
							if (javaInputChannel != null) {
								javaInputChannel.close();
							}
							if (textOutputChannel != null) {
								textOutputChannel.close();
							}
						}
					}
				}
			}
		} catch(IOException ioe) {
			throw new RuntimeException(ioe);
		}
	}

	@Override
	public void postInvoke() {
	}

	@Mandatory
	public void addPackage(String pack) {
		this.packages.add(pack);
	}

	public String getSourceDirectory() {
		return sourceDirectory;
	}
	
	@Mandatory
	public void setSourceDirectory(String sourceDirectory) {
		this.sourceDirectory = sourceDirectory;
	}
	
	public String getTargetDirectory() {
		return targetDirectory;
	}
	
	@Mandatory
	public void setTargetDirectory(String targetDirectory) {
		this.targetDirectory = targetDirectory;
	}
}
