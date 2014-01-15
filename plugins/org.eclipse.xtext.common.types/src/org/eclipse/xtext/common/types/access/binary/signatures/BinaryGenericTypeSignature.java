/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.signatures;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.core.util.Util;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@SuppressWarnings("restriction")
public class BinaryGenericTypeSignature extends BinaryTypeSignature {

	BinaryGenericTypeSignature(char[] chars) {
		super(chars);
//		checkInvariant();
	}
	
	BinaryGenericTypeSignature(char[] chars, int offset, int length) {
		super(chars, offset, length);
//		checkInvariant();
	}

//	@Override
//	protected void checkInvariant() {
//		if (offset < 0 || offset > chars.length) {
//			throw new ArrayIndexOutOfBoundsException(offset);
//		}
//		if (offset + length == 0 || offset + length > chars.length) {
//			throw new ArrayIndexOutOfBoundsException(offset + length);
//		}
//		if (chars[offset + length - 1] != ';') {
//			switch(chars[offset]) {
//				case 'B':
//				case 'C':
//				case 'D':
//				case 'F':
//				case 'I':
//				case 'J':
//				case 'S':
//				case 'Z':
//				case 'V':
//				case '*':
//				case ';':
//				case '[':
//					break;
//				default:
//					throw new IllegalArgumentException(String.valueOf(chars, offset, length));
//			}
//		}
//	}
	
	@Override
	public String toIdentifier() {
		StringBuilder result = new StringBuilder(chars.length);
		toIdentifier(result, 1);
		return result.toString();
	}
	
	@Override
	public BinaryGenericTypeSignature getArrayComponentType() {
		int dimensions = getArrayDimensions();
		if (dimensions == 0) 
			return this;
		return new BinaryGenericTypeSignature(chars, offset + dimensions, length - dimensions);
	}
	
	@Override
	public List<BinaryTypeArgumentSignature> getTypeArguments() {
		if (length < 2 || chars[offset+length-2] != Signature.C_GENERIC_END)
			// cannot have type arguments otherwise signature would end by ">;"
			return Collections.emptyList();
		int count = 1; // start to count generic end/start peers
		int start = offset+length - 2;
		while (start >= offset && count > 0) {
			switch (chars[--start]) {
				case Signature.C_GENERIC_START:
					count--;
					break;
				case Signature.C_GENERIC_END:
					count++;
					break;
			}
		}
		if (start < 0) // invalid number of generic start/end
			throw new IllegalArgumentException(toString());
		List<BinaryTypeArgumentSignature> result = Lists.newArrayListWithExpectedSize(2);
		int p = start + 1;
		while (true) {
			if (p >= offset + length) {
				throw new IllegalArgumentException(toString());
			}
			char c = chars[p];
			if (c == Signature.C_GENERIC_END) {
				return result;
			}
			int end = Util.scanTypeSignature(chars, p);
			result.add(new BinaryTypeArgumentSignature(chars, p, end + 1 - p));
			p = end + 1;
		}
	}

	@Override
	public BinaryGenericTypeSignature getTypeErasure() {
		int end = CharOperation.indexOf(Signature.C_GENERIC_START, chars, offset, offset + length);
		if (end == -1)
			return this;
		return new BinaryErasureTypeSignature(this, getArrayDimensions());
	}

	@Override
	public List<BinaryTypeParameter> getTypeParameters() {
		return doGetTypeParameters();
	}

	@Override
	public String getTypeVariableName() {
		if (chars[offset] == 'T') {
			return String.valueOf(chars, offset + 1, length - 2);
		}
		return null;
	}

}
