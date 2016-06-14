/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.performance.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;

import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

/**
 * Creates a list of files that are contained in a given directory.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CreateFileList implements IWorkflowComponent {

	private String path;
	private String fileName = "files.list";
	
	@Override
	public void preInvoke() {
	}

	@Override
	public void invoke(IWorkflowContext ctx) {
		try {
			File directory = new File(path);
			if (!directory.exists())
				throw new RuntimeException(path);
			Writer writer = null;
			try {
				File list = new File(directory, fileName);
				if (!list.exists())
					list.createNewFile();
				writer = new BufferedWriter(new FileWriter(list));
				for(File contained: directory.listFiles()) {
					if (contained.isDirectory()) {
						appendFilesTo(contained, writer, directory.toURI());
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
	
	private void appendFilesTo(File directory, Writer writer, URI base) throws IOException {
		for(File file: directory.listFiles()) {
			if (file.isDirectory()) {
				appendFilesTo(file, writer, base);
			} else {
				writer.write('/');
				writer.write(base.relativize(file.toURI()).getPath());
				writer.write("\n");
			}
		}
	}

	@Override
	public void postInvoke() {
	}

	@Mandatory
	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
