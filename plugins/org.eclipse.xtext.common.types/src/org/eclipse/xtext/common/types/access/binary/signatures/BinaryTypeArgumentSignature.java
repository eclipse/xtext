/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.signatures;

import org.eclipse.jdt.core.Signature;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class BinaryTypeArgumentSignature extends BinaryGenericTypeSignature {

	BinaryTypeArgumentSignature(char[] chars, int offset, int length) {
		super(chars, offset, length);
	}
	
	public boolean isWildcard() {
		switch(chars[offset]) {
			case Signature.C_STAR:
			case Signature.C_EXTENDS:
			case Signature.C_SUPER:
				return true;
		}
		return false;
	}
	
	public BinaryGenericTypeSignature getUpperBound() {
		if (chars[offset] == Signature.C_EXTENDS) {
			int end = JdtCompilerUtil.scanTypeSignature(chars, offset + 1);
			return new BinaryGenericTypeSignature(chars, offset + 1, end - offset);
		}
		return null;
	}
	
	public BinaryGenericTypeSignature getLowerBound() {
		if (chars[offset] == Signature.C_SUPER) {
			int end = JdtCompilerUtil.scanTypeSignature(chars, offset + 1);
			return new BinaryGenericTypeSignature(chars, offset + 1, end - offset);
		}
		return null;
	}

}
