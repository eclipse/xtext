/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
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
	private final List<StackedUnboundParameter> stackedUnboundParameters;

	public StackedResolvedTypes(ResolvedTypes parent) {
		super(parent.getResolver());
		this.parent = parent;
		this.stackedUnboundParameters = Lists.newArrayListWithCapacity(2);
	}
	
	public ResolvedTypes getParent() {
		return parent;
	}
	
	public ResolvedTypes mergeIntoParent() {
		for(StackedUnboundParameter unboundParameter: stackedUnboundParameters) {
			unboundParameter.mergeIntoParent();
		}
		ResolvedTypes parent = getParent();
		parent.ensureExpressionTypesMapExists().putAll(ensureExpressionTypesMapExists());
		parent.ensureTypesMapExists().putAll(ensureTypesMapExists());
		parent.ensureLinkingMapExists().putAll(ensureLinkingMapExists());
		parent.ensureTypeParameterMapExists().putAll(ensureTypeParameterMapExists());
		return parent;
	}

	@Override
	protected Collection<TypeData> doGetTypeData(XExpression expression) {
		Collection<TypeData> result = super.doGetTypeData(expression);
		if (result == null) {
			return parent.doGetTypeData(expression);
		}
		return result;
	}
	
	@Override
	protected TypeData mergeTypeData(XExpression expression, Collection<TypeData> allValues, boolean returnType) {
		// TODO copy the result and store it
		return super.mergeTypeData(expression, allValues, returnType);
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
	
	@Override
	@NonNull
	protected BaseUnboundTypeParameter getUnboundTypeParameter(@NonNull Object handle) {
		BaseUnboundTypeParameter result = super.ensureTypeParameterMapExists().get(handle);
		if (result == null) {
			return parent.getUnboundTypeParameter(handle);
		}
		return result;
	}

}
