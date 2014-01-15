/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.signatures;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BinarySignatures {

	/**
	 * @param name the binary type name, e.g. {@code java/lang/String}
	 */
	public static BinaryTypeSignature createTypeSignature(char[] name) {
		if (name[name.length - 1] != ';')
			return new BinaryTypeSignature(name);
		return new BinaryGenericTypeSignature(name);
	}

	public static BinaryMethodSignature createMethodSignature(char[] signature) {
		return new BinaryMethodSignature(signature);
	}

	public static BinarySuperTypeSignature createSuperTypeSignature(char[] signature) {
		return new BinarySuperTypeSignature(signature);
	}
	
}
