/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard;

/**
 * @author Karsten Thoms - Initial contribution and API
 */
public enum LanguageServer {
	NONE("None"),
	APP("Regular"),
	FATJAR("Fat Jar");
	
	private String humanReadableName;
	
	private LanguageServer(String humanReadableName) {
		this.humanReadableName = humanReadableName;
	}
	public String toString() {
		return humanReadableName;
	}
}
