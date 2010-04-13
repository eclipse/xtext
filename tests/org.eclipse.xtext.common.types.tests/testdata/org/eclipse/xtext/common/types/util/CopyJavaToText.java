/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.channels.FileChannel;

import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CopyJavaToText implements IWorkflowComponent {

	private String path;
	
	public void preInvoke() {
	}

	public void invoke(IWorkflowContext ctx) {
		try {
			File directory = new File(path);
			if (!directory.exists())
				throw new RuntimeException(path);
			Writer writer = null;
			try {
				File list = new File(directory, "files.list");
				if (!list.exists())
					list.createNewFile();
				writer = new BufferedWriter(new FileWriter(list));
				for(File javaFile: directory.listFiles()) {
					if (javaFile.isFile() && javaFile.getName().endsWith(".java")) {
						File target = new File(javaFile.getAbsolutePath() + ".txt");
						writer.write(directory.toURI().relativize(target.toURI()).getPath());
						writer.write("\n");
						if (!target.exists()) {
							target.createNewFile();
						}
						FileChannel javaInputChannel = null;
						FileChannel textOutputChannel = null;
						try {
							javaInputChannel = new FileInputStream(javaFile).getChannel();
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
			} finally {
				if (writer != null)
					writer.close();
			}
		} catch(IOException ioe) {
			throw new RuntimeException(ioe);
		}
	}

	public void postInvoke() {
	}

	@Mandatory
	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

}
