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
 */
@SuppressWarnings("restriction")
public abstract class AbstractBinarySignature {

	protected final char[] chars;
	protected final int offset;
	protected final int length;
	private int hashCode;
	
	AbstractBinarySignature(char[] chars) {
		this(chars, 0, chars.length);
	}

	AbstractBinarySignature(char[] chars, int offset, int length) {
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

        for (int i=offset, j = other.offset, max = offset + length; i<max; i++, j++)
            if (chars[i] != other.chars[j])
                return false;

        return true;
	}
	
	public List<BinaryTypeParameter> getTypeParameters() {
		return Collections.emptyList();
	}
	
	protected List<BinaryTypeParameter> doGetTypeParameters() {
		try {
			int length = this.length;
			if (length == 0) return Collections.emptyList();
			if (chars[offset] != Signature.C_GENERIC_START) return Collections.emptyList();

			List<BinaryTypeParameter> result = Lists.newArrayListWithCapacity(2);
			int paramStart = offset + 1, i = offset + 1;  // start after leading '<'
			while (i < length) {
				if (chars[i] == Signature.C_GENERIC_END) {
					return result;
				}
				i = CharOperation.indexOf(Signature.C_COLON, chars, i);
				if (i < 0 || i >= length)
					throw new IllegalArgumentException();
				// iterate over bounds
				while (chars[i] == ':') {
					i++; // skip colon
					switch (chars[i]) {
						case ':':
							// no class bound
							break;
						case Signature.C_GENERIC_END:
							break;
						case Signature.C_RESOLVED:
						case Signature.C_ARRAY:
						case Signature.C_TYPE_VARIABLE:
							try {
								i = Util.scanTypeSignature(chars, i);
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
            result = 31 * result + chars[i];

        return result;
    }

	@Override
	public String toString() {
		return String.format("%s: %s", getClass().getSimpleName(), String.valueOf(chars, offset, length));
	}
	
	public int getLength() {
		return length;
	}
	
	public char getChar(int offset) {
		return chars[offset + this.offset];
	}
	
	public boolean isEqualToSignature(char[] signature) {
		if (signature.length != length)
			return false;
		for(int i = 0; i < length; i++) {
			if (signature[i] != chars[i + offset]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isEqualToSignature(String signature) {
		return String.valueOf(chars, offset, length).equals(signature);
	}
}
