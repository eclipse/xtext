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
 */
public class JavaIoFileSystemAccess extends AbstractFileSystemAccess {
	
	public void generateFile(String fileName, String slot, CharSequence contents) {
		String string = getPathes().get(slot);
		if (string==null)
			throw new IllegalArgumentException("A slot with name '"+slot+"' has not been configured.");
		File file = new File(string+fileName);
		try {
			FileWriter writer = new FileWriter(file);
			writer.append(contents);
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
