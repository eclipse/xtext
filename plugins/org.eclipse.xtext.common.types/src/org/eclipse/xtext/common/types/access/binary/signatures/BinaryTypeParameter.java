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
 */
@SuppressWarnings("restriction")
public class BinaryTypeParameter extends AbstractBinarySignature {

	protected BinaryTypeParameter(char[] chars, int offset, int length) {
		super(chars, offset, length);
	}

	public String getName() {
		int p = CharOperation.indexOf(Signature.C_COLON, chars, offset);
		return String.valueOf(chars, offset, p - offset);
	}

	public List<BinaryGenericTypeSignature> getBounds() {
		final int end = offset + length;
		int afterTypeParameterName = CharOperation.indexOf(Signature.C_COLON, chars, offset, end);
		if (afterTypeParameterName < 0) {
			throw new IllegalArgumentException();
		}
		if (afterTypeParameterName == chars.length - 1) {
			return Collections.emptyList();
		}
		if (chars[afterTypeParameterName + 1] == Signature.C_COLON) {
			// no class bound
			List<BinaryGenericTypeSignature> result = Lists.newArrayListWithCapacity(3);
			int nextInterface = afterTypeParameterName + 2;
			while(nextInterface <= end) {
				int afterInterfaceBound = Util.scanTypeSignature(chars, nextInterface) + 1;
				BinaryGenericTypeSignature intf = new BinaryGenericTypeSignature(chars, nextInterface, afterInterfaceBound - nextInterface);
				result.add(intf);
				nextInterface = afterInterfaceBound + 1;
			}
			return result;
		} else {
			int afterClassBound = Util.scanTypeSignature(chars, afterTypeParameterName + 1);
			BinaryGenericTypeSignature classBound = new BinaryGenericTypeSignature(chars, afterTypeParameterName + 1, afterClassBound - afterTypeParameterName);
			if (afterClassBound == end - 1) {
				return Collections.singletonList(classBound);
			}
			if (afterClassBound != end - 2) {
				int nextInterface = afterClassBound + 1;
				List<BinaryGenericTypeSignature> result = Lists.newArrayListWithCapacity(3);
				result.add(classBound);
				while(nextInterface != end) {
					int afterInterfaceBound = scanTypeSignature(chars, nextInterface + 1);
					BinaryGenericTypeSignature intf = new BinaryGenericTypeSignature(chars, nextInterface + 1, afterInterfaceBound - nextInterface);
					result.add(intf);
					nextInterface = afterInterfaceBound + 1;
				}
				return result;
			} else {
				return Collections.singletonList(classBound);
			}
		}
	}

	private int scanTypeSignature(char[] chars, int i) {
		try {
			return Util.scanTypeSignature(chars, i);
		} catch(IllegalArgumentException e) {
//			e.printStackTrace();
			throw e;
		}
	}

}
