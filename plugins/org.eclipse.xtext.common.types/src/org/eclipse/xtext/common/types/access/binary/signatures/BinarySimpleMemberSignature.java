/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.signatures;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BinarySimpleMemberSignature extends AbstractBinarySignature {

	private final BinaryTypeSignature type;
	private boolean operation;

	protected BinarySimpleMemberSignature(BinaryTypeSignature type, char[] field, boolean operation) {
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
