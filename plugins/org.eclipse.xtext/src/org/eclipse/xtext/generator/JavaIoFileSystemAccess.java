/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public class JavaIoFileSystemAccess extends AbstractFileSystemAccess {

	public void generateFile(String fileName, String outputConfigName, CharSequence contents) {
		File file = getFile(fileName, outputConfigName);
		try {
			createFolder(file.getParentFile());
			FileWriter writer = new FileWriter(file);
			writer.append(contents);
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @since 2.1
	 */
	protected File getFile(String fileName, String outputConfigName) {
		String outlet = getPathes().get(outputConfigName);
		if (outlet == null)
			throw new IllegalArgumentException("A slot with name '" + outputConfigName + "' has not been configured.");
		String pathName = toSystemFileName(outlet + "/" + fileName);
		File file = new File(pathName);
		return file;
	}

	protected void createFolder(File parent) {
		if (parent != null && !parent.exists()) {
			// TODO check return value
			parent.mkdirs();
		}
	}

	@Override
	public void deleteFile(String fileName,String outputConfiguration) {
		File file = getFile(fileName, outputConfiguration);
		if (file.exists())
			file.delete();
	}

	protected String toSystemFileName(String fileName) {
		return fileName.replace("/", File.separator);
	}
}
