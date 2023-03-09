/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Map;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StandardTypeParameterSubstitutor extends TypeParameterSubstitutor<Object> {

	public StandardTypeParameterSubstitutor(
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping, ITypeReferenceOwner owner) {
		super(typeParameterMapping, owner);
	}

	@Override
	protected Object createVisiting() {
		return new Object();
	}

}
