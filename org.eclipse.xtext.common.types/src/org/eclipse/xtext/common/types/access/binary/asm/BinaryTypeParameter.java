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
public class BinaryTypeParameter extends AbstractBinarySignature {

	BinaryTypeParameter(String chars, int offset, int length) {
		super(chars, offset, length);
	}

	public String getName() {
		int p = chars.indexOf(':', offset);
		return chars.substring(offset, p);
	}

	public List<BinaryGenericTypeSignature> getBounds() {
		final int end = offset + length;
		int afterTypeParameterName = chars.indexOf(':', offset);
		if (afterTypeParameterName >= end) {
			throw new IllegalArgumentException();
		}
		if (afterTypeParameterName == chars.length() - 1) {
			return Collections.emptyList();
		}
		if (chars.charAt(afterTypeParameterName + 1) == ':') {
			// no class bound
			List<BinaryGenericTypeSignature> result = Lists.newArrayListWithCapacity(3);
			int nextInterface = afterTypeParameterName + 2;
			while(nextInterface <= end) {
				int afterInterfaceBound = SignatureUtil.scanTypeSignature(chars, nextInterface) + 1;
				BinaryGenericTypeSignature intf = new BinaryGenericTypeSignature(chars, nextInterface, afterInterfaceBound - nextInterface);
				result.add(intf);
				nextInterface = afterInterfaceBound + 1;
			}
			return result;
		} else {
			int afterClassBound = SignatureUtil.scanTypeSignature(chars, afterTypeParameterName + 1);
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

	private int scanTypeSignature(String chars, int i) {
		try {
			return SignatureUtil.scanTypeSignature(chars, i);
		} catch(IllegalArgumentException e) {
//			e.printStackTrace();
			throw e;
		}
	}

}
