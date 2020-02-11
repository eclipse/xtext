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
public class BinaryGenericTypeSignature extends BinaryTypeSignature {

	BinaryGenericTypeSignature(String chars) {
		super(chars);
//		checkInvariant();
	}
	
	BinaryGenericTypeSignature(String chars, int offset, int length) {
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
		StringBuilder result = new StringBuilder(chars.length());
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
		if (length < 2 || chars.charAt(offset+length-2) != '>')
			// cannot have type arguments otherwise signature would end by ">;"
			return Collections.emptyList();
		int count = 1; // start to count generic end/start peers
		int start = offset+length - 2;
		while (start >= offset && count > 0) {
			switch (chars.charAt(--start)) {
				case '<':
					count--;
					break;
				case '>':
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
			char c = chars.charAt(p);
			if (c == '>') {
				return result;
			}
			int end = SignatureUtil.scanTypeSignature(chars, p);
			result.add(new BinaryTypeArgumentSignature(chars, p, end + 1 - p));
			p = end + 1;
		}
	}
	
	@Override
	public BinaryTypeSignature getOuter() {
		int startFrom = offset;
		int end = -1;
		while(true) {
			int typeArgsIdx = chars.indexOf('<', startFrom);
			if (typeArgsIdx == -1 || typeArgsIdx > offset + length) {
				if (end == -1)
					return null;
				return new BinaryGenericTypeSignature(chars, offset, end - offset + 2);
			}
			int count = 1; // start to count generic start/end peers
			int i = typeArgsIdx;
			while (count > 0) {
				switch (chars.charAt(++i)) {
					case '<':
						count++;
						break;
					case '>':
						count--;
						break;
				}
			}
			if (i != offset + length - 2) {
				end = i;
			}
			startFrom = i;
		}
	}

	@Override
	public BinaryGenericTypeSignature getTypeErasure() {
		int end = chars.indexOf('<', offset);
		if (end == -1 || end > offset + length)
			return this;
		return new BinaryErasureTypeSignature(this, getArrayDimensions());
	}

	@Override
	public List<BinaryTypeParameter> getTypeParameters() {
		return doGetTypeParameters();
	}

	@Override
	public String getTypeVariableName() {
		if (chars.charAt(offset) == 'T') {
			return chars.substring(offset + 1, offset + length - 1);
		}
		return null;
	}

	public boolean isEqualToSignature(String string) {
		return chars.regionMatches(offset, string, 0, string.length());
	}

}
