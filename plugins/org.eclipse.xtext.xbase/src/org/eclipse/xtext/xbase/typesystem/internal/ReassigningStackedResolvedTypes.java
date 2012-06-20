/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Map;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Multimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString - delegates to parent except for the reassigned types
 */
public class ReassigningStackedResolvedTypes extends StackedResolvedTypes {
	public ReassigningStackedResolvedTypes(ResolvedTypes parent) {
		super(parent);
	}

	@Override
	protected Multimap<XExpression, TypeData> ensureExpressionTypesMapExists() {
		return getParent().ensureExpressionTypesMapExists();
	}
	
	@Override
	protected Multimap<XExpression, TypeData> createExpressionTypesMap() {
		throw new UnsupportedOperationException();
	}

	@Override
	protected Map<XExpression, ILinkingCandidate<?>> ensureLinkingMapExists() {
		return getParent().ensureLinkingMapExists();
	}

	@Override
	protected Map<JvmIdentifiableElement, LightweightTypeReference> ensureTypesMapExists() {
		return getParent().ensureTypesMapExists();
	}
	
//	@Override
//	public LightweightTypeReference acceptType(XExpression expression, AbstractTypeExpectation expectation, LightweightTypeReference type,
//			ConformanceHint conformanceHint, boolean returnType) {
//		return getParent().acceptType(expression, expectation, type, conformanceHint, returnType);
//	}
}