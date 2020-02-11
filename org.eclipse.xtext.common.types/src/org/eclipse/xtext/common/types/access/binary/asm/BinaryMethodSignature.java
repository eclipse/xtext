/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.asm;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class BinaryMethodSignature extends AbstractBinarySignature {

	BinaryMethodSignature(String signature) {
		super(signature);
	}

	public BinaryGenericTypeSignature getReturnType() {
		int paren = chars.lastIndexOf(')');
		if (paren == -1) {
			throw new IllegalArgumentException();
		}
		// there could be thrown exceptions behind, thus scan one type exactly
		int last = SignatureUtil.scanTypeSignature(chars, paren+1);
		return new BinaryGenericTypeSignature(chars, paren + 1, last - paren);
	}
	
	public List<BinaryGenericTypeSignature> getExceptionTypes() {
		// skip type parameters
		int exceptionStart = chars.indexOf('^', offset);
		if (exceptionStart == -1) {
			int paren = chars.lastIndexOf(')');
			if (paren == -1) {
				throw new IllegalArgumentException();
			}
			// ignore return type
			exceptionStart = SignatureUtil.scanTypeSignature(chars, paren+1) + 1;
			int length = offset + this.length;
			if (exceptionStart == length) return Collections.emptyList();
		}
		
		int length = offset + this.length;
		int i = exceptionStart;
		List<BinaryGenericTypeSignature> result = Lists.newArrayListWithCapacity(2);
		while (i < length) {
			if (chars.charAt(i) == '^') {
				exceptionStart++;
				i++;
			} else {
				throw new IllegalArgumentException();
			}
			i = SignatureUtil.scanTypeSignature(chars, i) + 1;
			result.add(new BinaryGenericTypeSignature(chars, exceptionStart, i - exceptionStart));
			exceptionStart = i;
		}
		return result;
	}

	public List<BinaryGenericTypeSignature> getParameterTypes() {
		try {
			int i =  chars.indexOf('(', offset);
			if (i < 0) {
				throw new IllegalArgumentException();
			} else {
				i++;
			}
			if (chars.charAt(i) == ')') {
				return Collections.emptyList();
			}
			List<BinaryGenericTypeSignature> result = Lists.newArrayListWithExpectedSize(3);
			for (;;) {
				if (chars.charAt(i) == ')') {
					return result;
				}
				int e = SignatureUtil.scanTypeSignature(chars, i);
				if (e < 0) {
					throw new IllegalArgumentException();
				}
				result.add(new BinaryGenericTypeSignature(chars, i, e - i + 1));
				i = e + 1;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public List<BinaryTypeParameter> getTypeParameters() {
		return doGetTypeParameters();
	}

}
