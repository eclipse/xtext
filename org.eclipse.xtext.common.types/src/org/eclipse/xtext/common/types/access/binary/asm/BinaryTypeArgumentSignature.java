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
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class BinaryTypeArgumentSignature extends BinaryGenericTypeSignature {

	BinaryTypeArgumentSignature(String chars, int offset, int length) {
		super(chars, offset, length);
	}
	
	public boolean isWildcard() {
		switch(chars.charAt(offset)) {
			case '*':
			case '+':
			case '-':
				return true;
		}
		return false;
	}
	
	public BinaryGenericTypeSignature getUpperBound() {
		if (chars.charAt(offset) == '+') {
			int end = SignatureUtil.scanTypeSignature(chars, offset + 1);
			return new BinaryGenericTypeSignature(chars, offset + 1, end - offset);
		}
		return null;
	}
	
	public BinaryGenericTypeSignature getLowerBound() {
		if (chars.charAt(offset) == '-') {
			int end = SignatureUtil.scanTypeSignature(chars, offset + 1);
			return new BinaryGenericTypeSignature(chars, offset + 1, end - offset);
		}
		return null;
	}

}
