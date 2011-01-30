/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractXExpressionTypeProvider implements IXExpressionTypeProvider {
	
	private ThreadLocal<Set<XExpression>> dontAskForExpectedType = new ThreadLocal<Set<XExpression>>();
	
	private ThreadLocal<Set<XExpression>> dontAskForType = new ThreadLocal<Set<XExpression>>();

	private final PolymorphicDispatcher<JvmTypeReference> expectedTypeDispatcher = PolymorphicDispatcher.createForSingleTarget("_expectedType", 3, 3, this);
	
	@Inject
	private TypeConverter typeConverter;
	
	private final PolymorphicDispatcher<JvmTypeReference> typeDispatcher = PolymorphicDispatcher.createForSingleTarget("_type",this);
	
	protected JvmTypeReference _expectedType(EObject container, EReference reference, int index) {
		return null;
	}
	
	protected JvmTypeReference _type(EObject stNode) {
		throw new IllegalArgumentException("Type computation is not implemented for " + stNode);
	}
	protected JvmTypeReference _type(Void stNode) {
		throw new NullPointerException("expression");
	}
	
	protected void checkInit() {
		if (dontAskForType.get() == null) {
			dontAskForType.set(new HashSet<XExpression>());
		}
		if (dontAskForExpectedType.get() == null) {
			dontAskForExpectedType.set(new HashSet<XExpression>());
		}
	}
	
	protected JvmTypeReference convert(JvmTypeReference toBeConverted, EObject context) {
		if (toBeConverted==null)
			return null;
		JvmTypeReference converted = typeConverter.convert(toBeConverted, context);
		return converted;
	}
	private IResourceScopeCache getCache(EObject astNode) {
		if (!(astNode.eResource() instanceof XtextResource))
			return null;
		return ((XtextResource) astNode.eResource()).getCache();
	}
	
	protected Triple<EObject, EReference, Integer> getContainingInfo(XExpression obj) {
		if (obj == null)
			return null;
		if (obj.eIsProxy())
			return null;
		EReference containmentReference = obj.eContainmentFeature();
		if(containmentReference == null)
			return null;
		EObject container = obj.eContainer();
		int index = (containmentReference.isMany()) ? ((List<?>)container.eGet(containmentReference)).indexOf(obj) : -1;
		Triple<EObject, EReference, Integer> triple = Tuples.create(container, containmentReference, index);
		return triple;
	}
	

	public JvmTypeReference getConvertedExpectedType(XExpression astNode) {
		JvmTypeReference type = getExpectedType(astNode);
		return convert(type, astNode);
	}


	public JvmTypeReference getConvertedType(XExpression astNode) {
		JvmTypeReference type = getType(astNode);
		return convert(type, astNode);
	}
	
	protected JvmTypeReference getExpectedType(final EObject obj, final EReference reference, final int index) {
		final Provider<JvmTypeReference> provider = new Provider<JvmTypeReference>() {
			public JvmTypeReference get() {
				final JvmTypeReference expectedType = internalGetExpectedType(obj, reference, index);
				return expectedType;
			}
		};
		final IResourceScopeCache cache = getCache(obj);
		if (cache == null)
			return provider.get();
		else
			return cache.get(Tuples.pair("expectedType", Tuples.create(obj,reference, index)), obj.eResource(), provider);
	}
	public JvmTypeReference getExpectedType(XExpression obj) {
		return internalGetExpectedType(obj);
	}
	
	public JvmTypeReference getType(final XExpression expression) {
		if (expression == null)
			return null;
		if (expression.eIsProxy())
			return null;
		final Provider<JvmTypeReference> provider = new Provider<JvmTypeReference>() {
			public JvmTypeReference get() {
				final JvmTypeReference type = internalGetType(expression);
				return type;
			}
		};
		final IResourceScopeCache cache = getCache(expression);
		if (cache == null)
			return provider.get();
		else
			return cache.get(Tuples.create(getClass(), expression), expression.eResource(), provider);
	}
	
	protected JvmTypeReference internalGetExpectedType(final EObject obj, final EReference reference,
			final int index) {
		return expectedTypeDispatcher.invoke(obj, reference, index);
	}

	
	protected JvmTypeReference internalGetExpectedType(final XExpression expression) {
		checkInit();
		if (dontAskForExpectedType.get().contains(expression)) 
			return null;
		try {
			dontAskForType.get().add(expression);
			Triple<EObject, EReference, Integer> triple = getContainingInfo(expression);
			if (triple==null)
				return null;
			return getExpectedType(triple.getFirst(),triple.getSecond(),triple.getThird());
		} finally {
			dontAskForType.get().remove(expression);
		}
	}
	protected JvmTypeReference internalGetType(final XExpression expression) {
		checkInit();
		if (dontAskForType.get().contains(expression)) 
			return null;
		try {
			dontAskForExpectedType.get().add(expression);
			final JvmTypeReference invoke = typeDispatcher.invoke(expression);
			return invoke;
		} finally {
			dontAskForExpectedType.get().remove(expression);
		}
	}
	
	public void setTypeConverter(TypeConverter typeConverter) {
		this.typeConverter = typeConverter;
	}
}
