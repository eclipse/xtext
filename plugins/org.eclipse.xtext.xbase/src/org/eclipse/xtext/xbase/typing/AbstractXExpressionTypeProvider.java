/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractXExpressionTypeProvider implements IXExpressionTypeProvider {

	private final PolymorphicDispatcher<JvmTypeReference> expectedTypeDispatcher = PolymorphicDispatcher
			.createForSingleTarget("_expectedType", 3, 3, this);

	private final PolymorphicDispatcher<JvmTypeReference> typeDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_type",2,2, this);

	protected JvmTypeReference _expectedType(EObject container, EReference reference, int index) {
		return null;
	}

	protected JvmTypeReference _type(EObject stNode) {
		throw new IllegalArgumentException("Type computation is not implemented for " + stNode);
	}

	protected JvmTypeReference _type(Void stNode) {
		throw new NullPointerException("expression");
	}

	public JvmTypeReference getSelfContainedType(XExpression expression) {
		return getType(expression,true);
	}

	public JvmTypeReference getType(final XExpression expression) {
		return getType(expression, false);
	}
	
	public JvmTypeReference getType(final XExpression expression, boolean selfContained) {
		if (expression == null)
			return null;
		if (expression.eIsProxy())
			return null;
		final JvmTypeReference invoke = typeDispatcher.invoke(expression, selfContained);
		return invoke;
	}
	
	public JvmTypeReference getExpectedType(final XExpression expression) {
		Triple<EObject, EReference, Integer> triple = getContainingInfo(expression);
		if (triple == null)
			return null;
		return expectedTypeDispatcher.invoke(triple.getFirst(), triple.getSecond(), triple.getThird());
	}
	
	protected Triple<EObject, EReference, Integer> getContainingInfo(XExpression obj) {
		if (obj == null)
			return null;
		if (obj.eIsProxy())
			return null;
		EReference containmentReference = obj.eContainmentFeature();
		if (containmentReference == null)
			return null;
		EObject container = obj.eContainer();
		int index = (containmentReference.isMany()) ? ((List<?>) container.eGet(containmentReference)).indexOf(obj)
				: -1;
		Triple<EObject, EReference, Integer> triple = Tuples.create(container, containmentReference, index);
		return triple;
	}

	// TODO activate caching
	//	private IResourceScopeCache getCache(EObject astNode) {
	//		if (!(astNode.eResource() instanceof XtextResource))
	//			return null;
	//		return ((XtextResource) astNode.eResource()).getCache();
	//	}

}
