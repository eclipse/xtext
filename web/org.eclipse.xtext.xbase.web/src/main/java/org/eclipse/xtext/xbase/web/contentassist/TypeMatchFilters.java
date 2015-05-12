/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.web.contentassist;

final class TypeMatchFilters {
	
	public static boolean isInternalClass(char[] simpleTypeName,
				char[][] enclosingTypeNames) {
		if (simpleTypeName[0] == '$')
			return true;
		if (enclosingTypeNames.length >= 1) {
			if (enclosingTypeNames[0][0] == '$')
				return true;
		}
		return false;
	}
	
	private static final int AccAbstract = 0x0400;
	
	public static boolean isAbstract(int flags) {
		return (flags & AccAbstract) != 0;
	}
	
	private static final int AccInterface = 0x0200;
	
	public static boolean isInterface(int flags) {
		return (flags & AccInterface) != 0;
	}

}
