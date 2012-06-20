/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class BaseResolvedTypes implements LightweightResolvedTypes, TypeReferenceOwner {

	private final OwnedConverter converter;

	protected BaseResolvedTypes() {
		this.converter = new OwnedConverter(this);
	}
	
	protected OwnedConverter getConverter() {
		return converter;
	}
	
	public final JvmTypeReference getActualType(XExpression expression) {
		LightweightTypeReference result = internalGetActualType(expression);
		if (result != null)
			return result.toTypeReference();
		return null;
	}

	public final JvmTypeReference getActualType(JvmIdentifiableElement identifiable) {
		LightweightTypeReference result = internalGetActualType(identifiable);
		if (result != null)
			return result.toTypeReference();
		return null;
	}

	public final JvmTypeReference getExpectedType(XExpression expression) {
		LightweightTypeReference result = internalGetExpectedType(expression);
		if (result != null)
			return result.toTypeReference();
		return null;
	}

	public final List<JvmTypeReference> getActualTypeArguments(XExpression expression) {
		return Lists.transform(internalGetActualTypeArguments(expression), ToJvmTypeReference.INSTANCE);
	}
	
}
