/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard;

/**
 * @author Karsten Thoms (karsten.thoms@itemis.de)
 * @since 2.15
 */
public enum LineDelimiter {
	UNIX("Unix","\n"),
	WINDOWS("Windows","\r\n");
	
	private String humanReadableName;
	private String delimiter;
	
	private LineDelimiter(String humanReadableName, String delimiter) {
		this.humanReadableName = humanReadableName;
		this.delimiter = delimiter;
	}
	
	public String getValue () {
		return delimiter;
	}
	public String toString() {
		return humanReadableName;
	}
}
