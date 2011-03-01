/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import static com.google.common.collect.Maps.*;

import java.util.Map;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractFileSystemAccess implements IFileSystemAccess {

	private Map<String, String> pathes = newHashMap();
	
	protected Map<String, String> getPathes() {
		return pathes;
	}
	
	public void setOutputPath(String outputName, String path) {
		getPathes().put(outputName, path);
	}
	
	public void setOutputPath(String path) {
		getPathes().put(DEFAULT_OUTPUT, path);
	}

	public void generateFile(String fileName, CharSequence contents) {
		generateFile(fileName, DEFAULT_OUTPUT, contents);
	}

}