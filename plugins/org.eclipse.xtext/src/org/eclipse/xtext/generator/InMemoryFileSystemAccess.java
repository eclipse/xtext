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
 * @since 2.0
 */
public class InMemoryFileSystemAccess extends AbstractFileSystemAccess {
	
	private Map<String, CharSequence> files = newHashMap();

	public void generateFile(String fileName, String slot, CharSequence contents) {
		files.put(fileName, contents);
	}

	public void deleteFile(String fileName) {
		files.remove(fileName);
	}
	
	public Map<String, CharSequence> getFiles() {
		return files;
	}
	
}
