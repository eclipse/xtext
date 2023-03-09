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

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class BinarySimpleMemberSignature extends AbstractBinarySignature {

	private final BinaryTypeSignature type;
	private boolean operation;

	BinarySimpleMemberSignature(BinaryTypeSignature type, String field, boolean operation) {
		super(field);
		this.type = type;
		this.operation = operation;
	}
	
	public URI getURI() {
		URI typeURI = type.getURI();
		String typeFragment = typeURI.fragment();
		if (operation) {
			return typeURI.appendFragment(typeFragment + "." + String.valueOf(chars) + "()");	
		}
		return typeURI.appendFragment(typeFragment + "." + String.valueOf(chars));
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && type.equals(((BinarySimpleMemberSignature)obj).type);
	}
	
	@Override
	public int hashCode() {
		return (super.hashCode() * 31) ^ type.hashCode();
	}
	
}
