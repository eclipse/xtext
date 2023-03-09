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
 */
public abstract class AbstractBinarySignature {

	protected final String chars;
	protected final int offset;
	protected final int length;
	private int hashCode;
	
	AbstractBinarySignature(String chars) {
		this(chars, 0, chars.length());
	}

	AbstractBinarySignature(String chars, int offset, int length) {
		this.chars = chars;
		this.offset = offset;
		this.length = length;
//		if (length + offset > chars.length || length == 0) {
//			throw new IllegalArgumentException();
//		}
	}
	
	@Override
	public int hashCode() {
		if (hashCode == 0) {
			return hashCode = computeHashCode();
		}
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
            return true;
        if (obj == null || !getClass().equals(obj.getClass()))
            return false;
        AbstractBinarySignature other = (AbstractBinarySignature) obj;
        if (length != other.length)
            return false;

        return chars.regionMatches(offset, other.chars, other.offset, length);
	}
	
	public List<BinaryTypeParameter> getTypeParameters() {
		return Collections.emptyList();
	}
	
	protected List<BinaryTypeParameter> doGetTypeParameters() {
		try {
			int length = this.length;
			if (length == 0) return Collections.emptyList();
			if (chars.charAt(offset) != '<') return Collections.emptyList();

			List<BinaryTypeParameter> result = Lists.newArrayListWithCapacity(2);
			int paramStart = offset + 1, i = offset + 1;  // start after leading '<'
			while (i < length) {
				if (chars.charAt(i) == '>') {
					return result;
				}
				i = chars.indexOf(':', i);
				if (i < 0 || i >= length)
					throw new IllegalArgumentException();
				// iterate over bounds
				while (chars.charAt(i) == ':') {
					i++; // skip colon
					switch (chars.charAt(i)) {
						case ':':
							// no class bound
							break;
						case '>':
							break;
						case 'L':
						case '[':
						case 'T':
							try {
								i = SignatureUtil.scanTypeSignature(chars, i);
								i++; // position at start of next param if any
							} catch (IllegalArgumentException e) {
								// not a class type signature -> it is a new type parameter
							}
							break;
						// default: another type parameter is starting
					}
				}
				result.add(new BinaryTypeParameter(chars, paramStart, i - paramStart));
				paramStart = i; // next param start from here
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// invalid signature, fall through
		}
		throw new IllegalArgumentException();
	}
	
	private int computeHashCode() {
        int result = 1;
        for (int i = offset, max = offset + length; i < max; i++)
            result = 31 * result + chars.charAt(i);

        return result;
    }

	@Override
	public String toString() {
		return String.format("%s: %s", getClass().getSimpleName(), chars.substring(offset, offset + length));
	}
	
	public int getLength() {
		return length;
	}
	
	public char getChar(int offset) {
		return chars.charAt(offset + this.offset);
	}
	
}
