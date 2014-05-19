/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Collections;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RawTypeSubstitutor extends TypeParameterSubstitutor<Object> {
	public RawTypeSubstitutor(ITypeReferenceOwner owner) {
		super(Collections.<JvmTypeParameter,LightweightMergedBoundTypeArgument>emptyMap(), owner);
	}

	@Override
	public LightweightTypeReference substitute(LightweightTypeReference original) {
		return original.getRawTypeReference();
	}

	@Override
	protected Object createVisiting() {
		return new Object();
	}
}