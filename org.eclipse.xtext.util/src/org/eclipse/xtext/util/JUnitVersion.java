/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * @author Karsten Thoms (karsten.thoms@itemis.de) - Initial contribution and API
 * @since 2.14
 */
public enum JUnitVersion {
	JUNIT_4 (4), JUNIT_5 (5);
	
	private int version;
	
	private JUnitVersion (int version) {
		this.version = version;
	}
	
	public int getVersion () {
		return version;
	}
	
	public static JUnitVersion fromString (String version) {
		switch (Integer.parseInt(version)) {
		case 4: return JUNIT_4;
		case 5: return JUNIT_5;
		}
		throw new IllegalArgumentException(version);
	}
}
