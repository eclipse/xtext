/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class StackedResolvedTypes extends ResolvedTypes {

	private final ResolvedTypes parent;

	public StackedResolvedTypes(ResolvedTypes parent) {
		super(parent.getResolver());
		this.parent = parent;
	}
	
	public ResolvedTypes getParent() {
		return parent;
	}
	
	public ResolvedTypes mergeIntoParent() {
		ResolvedTypes parent = getParent();
		mergeInto(parent);
		return parent;
	}

	protected void mergeInto(ResolvedTypes parent) {
		parent.ensureExpressionTypesMapExists().putAll(ensureExpressionTypesMapExists());
		parent.ensureTypesMapExists().putAll(ensureTypesMapExists());
		parent.ensureLinkingMapExists().putAll(ensureLinkingMapExists());
	}
	
	@Override
	protected TypeData getTypeData(XExpression expression, boolean returnType) {
		TypeData result = super.getTypeData(expression, returnType);
		if (result == null) {
			return parent.getTypeData(expression, returnType);
		}
		return result;
	}
	
	@Override
	public JvmTypeReference getActualType(JvmIdentifiableElement identifiable) {
		JvmTypeReference result = super.getActualType(identifiable);
		if (result == null) {
			result = parent.getActualType(identifiable);
		}
		return result;
	}
	
	@Override
	public JvmTypeReference getActualType(XExpression expression) {
		JvmTypeReference result = super.getActualType(expression);
		if (result == null) {
			result = parent.getActualType(expression);
		}
		return result;
	}
	
	@Override
	public List<JvmTypeReference> getActualTypeArguments(XExpression expression) {
		List<JvmTypeReference> result = super.getActualTypeArguments(expression);
		if (result == null) {
			result = parent.getActualTypeArguments(expression);
		}
		return result;
	}
	
	@Override
	public IFeatureLinkingCandidate getFeature(XAbstractFeatureCall featureCall) {
		IFeatureLinkingCandidate result = super.getFeature(featureCall);
		if (result == null) {
			result = parent.getFeature(featureCall);
		}
		return result;
	}
	
	@Override
	public IConstructorLinkingCandidate getConstructor(XConstructorCall constructorCall) {
		IConstructorLinkingCandidate result = super.getConstructor(constructorCall);
		if (result == null) {
			result = parent.getConstructor(constructorCall);
		}
		return result;
	}
	
	@Override
	public JvmTypeReference getExpectedType(XExpression expression) {
		JvmTypeReference result = super.getExpectedType(expression);
		if (result == null) {
			result = parent.getExpectedType(expression);
		}
		return result;
	}
	
	@Override
	public void reassignType(JvmIdentifiableElement identifiable, JvmTypeReference reference) {
		super.reassignType(identifiable, reference);
		if (reference == null) {
			getParent().reassignType(identifiable, reference);
		}
	}
	
	@Override
	public List<Diagnostic> getQueuedDiagnostics() {
		List<Diagnostic> result = Lists.newArrayList(super.getQueuedDiagnostics());
		result.addAll(parent.getQueuedDiagnostics());
		return result;
	}

}
