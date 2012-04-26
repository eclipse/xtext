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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;

import com.google.common.collect.Multimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class DelegatingTypeResolution extends StackedTypeResolution {
	public DelegatingTypeResolution(TypeResolution parent) {
		super(parent);
	}

	@Override
	protected Multimap<XExpression, TypeData> ensureExpressionTypesMapExists() {
		return getParent().ensureExpressionTypesMapExists();
	}

	@Override
	protected Map<XExpression, ILinkingCandidate> ensureLinkingMapExists() {
		return getParent().ensureLinkingMapExists();
	}

	@Override
	protected Map<JvmIdentifiableElement, JvmTypeReference> ensureTypesMapExists() {
		return getParent().ensureTypesMapExists();
	}

	@Override
	public void acceptType(XExpression expression, AbstractTypeExpectation expectation, JvmTypeReference type,
			ConformanceHint conformanceHint, boolean returnType) {
		getParent().acceptType(expression, expectation, type, conformanceHint, returnType);
	}
}