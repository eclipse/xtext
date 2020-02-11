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

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class BinaryErasureTypeSignature extends BinaryGenericTypeSignature {

	BinaryErasureTypeSignature(BinaryGenericTypeSignature genericSignature, int arrayDimensions) {
		super(genericSignature.chars, genericSignature.offset + arrayDimensions, genericSignature.length - arrayDimensions);
		this.arrayDimensions = arrayDimensions;
	}
	
	@Override
	protected void toIdentifier(StringBuilder builder, int fixup) {
		BinaryGenericTypeSignature componentType = getArrayComponentType();
		if (componentType != this) {
			componentType.toIdentifier(builder, fixup);
			int dim = getArrayDimensions();
			for(int i = 0; i < dim; i++) {
				builder.append("[]");
			}
		} else {
			int depth = 0;
			boolean wasGenericEnd = false;
			for(int i = offset + fixup, max = offset + length - fixup; i < max; i++) {
				char c = chars.charAt(i);
				if (c == '<') {
					depth++;
				} else if (c == '>') {
					depth--;
					wasGenericEnd = true;
				} else if (depth == 0) {
					if (c == '/') {
						builder.append('.');
					} else if (c == '.' && wasGenericEnd) {
						builder.append('$');
					} else {
						builder.append(c);
					}	
				}
			}
		}
	}
	
	@Override
	public BinaryGenericTypeSignature getArrayComponentType() {
		return new BinaryErasureTypeSignature(this, 0) {
			@Override
			public BinaryGenericTypeSignature getArrayComponentType() {
				return this;
			}
		};
	}
	
	@Override
	public BinaryGenericTypeSignature getTypeErasure() {
		return this;
	}
	
	@Override
	public List<BinaryTypeArgumentSignature> getTypeArguments() {
		return Collections.emptyList();
	}

}
