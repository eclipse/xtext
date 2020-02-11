/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.asm;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class BinaryObjectTypeSignature extends BinaryTypeSignature {

	BinaryObjectTypeSignature(String internalName) {
		super(internalName);
	}
	
	@Override
	protected void toIdentifier(StringBuilder builder, int identifierFixup) {
		BinaryTypeSignature componentType = getArrayComponentType();
		if (componentType != this) {
			componentType.toIdentifier(builder, identifierFixup);
			int dim = getArrayDimensions();
			for(int i = 0; i < dim; i++) {
				builder.append("[]");
			}
		} else {
			for(int i = offset + identifierFixup, max = offset + length - identifierFixup; i < max; i++) {
				char c = chars.charAt(i);
				if (c == '/') {
					builder.append('.');
				} else {
					builder.append(c);
				}
			}
		}
	}
	
	@Override
	public URI getURI() {
		BinaryTypeSignature typeErasure = getArrayComponentType().getTypeErasure();
		String identifier = typeErasure.toIdentifier();
		URI result = URIHelperConstants.OBJECTS_URI.appendSegment(identifier).appendFragment(toIdentifier());
		return result;
	}

}
