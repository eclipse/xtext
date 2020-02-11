/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.asm;

/**
 * Facade to obtain instances of binary signatures from char arrays.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class BinarySignatures {

	private BinarySignatures() {
		throw new UnsupportedOperationException("only static utilities");
	}
	
	/**
	 * Creates a new {@link BinaryTypeSignature} that is backed by the given
	 * string.
	 * 
	 * @param signature the binary signature e.g {@code Ljava/lang/String;}, {@code TT;} or {@code [[[I}.
	 */
	public static BinaryTypeSignature createTypeSignature(String signature) {
//		if (!isSignature(signature)) {
//			throw new IllegalArgumentException(signature);
//		}
		if (signature.charAt(signature.length() - 1) != ';')
			return new BinaryTypeSignature(signature);
		return new BinaryGenericTypeSignature(signature);
	}

//	private static boolean isSignature(String signature) {
//		char first = signature.charAt(0);
//		if (signature.length() == 1) {
//			switch(first) {
//			case 'B':
//			case 'C':
//			case 'D':
//			case 'F':
//			case 'I':
//			case 'J':
//			case 'S':
//			case 'Z':
//			case 'V':
//				return true;
//			}
//			return false;
//		}
//		if (first != '[') {
//			if (first != 'L' && first != 'T') {
//				return false;
//			}
//			if (signature.charAt(signature.length() - 1) != ';') {
//				return false;
//			}
//		}
//		return true;
//	}

	/**
	 * Creates a new {@link BinaryTypeSignature} that is backed by the given
	 * string.
	 * 
	 * @param internalName the binary type name, e.g. {@code java/lang/String} or a binary signature
	 *  e.g {@code Ljava/lang/String;}
	 */
	public static BinaryTypeSignature createObjectTypeSignature(String internalName) {
		if (internalName.charAt(internalName.length() - 1) != ';')
			return new BinaryObjectTypeSignature(internalName);
		return new BinaryGenericTypeSignature(internalName);
	}

	/**
	 * Creates a new {@link BinaryMethodSignature} that is backed by the given
	 * string.
	 */
	public static BinaryMethodSignature createMethodSignature(String signature) {
		return new BinaryMethodSignature(signature);
	}

	/**
	 * Creates a new {@link BinarySuperTypeSignature} that is backed by the given
	 * string.
	 */
	public static BinarySuperTypeSignature createSuperTypeSignature(String signature) {
		return new BinarySuperTypeSignature(signature);
	}
	
}
