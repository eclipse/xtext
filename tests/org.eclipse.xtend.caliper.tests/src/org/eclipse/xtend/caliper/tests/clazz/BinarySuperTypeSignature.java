/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.clazz;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
class BinarySuperTypeSignature extends AbstractBinarySignature {

	BinarySuperTypeSignature(char[] chars) {
		super(chars);
	}

	public List<BinaryGenericTypeSignature> getSuperTypes() {
		int index = offset;
		if (chars[offset] == '<') {
			int count = 1;
			while (count > 0 && ++index < offset + length) {
				switch (chars[index]) {
					case '<':
						count++;
						break;
					case '>':
						count--;
						break;
				}
			}
			index++;
		}
		List<BinaryGenericTypeSignature> result = Lists.newArrayListWithCapacity(2);
		while(index != offset + length) {
			int end = JdtCompilerUtil.scanTypeSignature(chars, index) + 1;
			result.add(new BinaryGenericTypeSignature(chars, index, end - index));
			index = end;
		}
		return result;
	}

	@Override
	public List<BinaryTypeParameter> getTypeParameters() {
		return doGetTypeParameters();
	}
}
