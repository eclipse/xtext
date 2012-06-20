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
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class StackedResolvedTypes extends ResolvedTypes {

	private final ResolvedTypes parent;
	private final Map<Object, StackedUnboundParameter> stackedUnboundParameters;
	private final Set<Object> createdParameters;

	protected StackedResolvedTypes(ResolvedTypes parent) {
		super(parent.getResolver());
		this.parent = parent;
		this.stackedUnboundParameters = Maps.newHashMap();
		this.createdParameters = Sets.newHashSet();
	}
	
	protected ResolvedTypes getParent() {
		return parent;
	}
	
	@Override
	@NonNull
	protected RootUnboundTypeParameter createUnboundTypeParameter(@NonNull XExpression expression,
			@NonNull JvmTypeParameter type) {
		RootUnboundTypeParameter result = super.createUnboundTypeParameter(expression, type);
		createdParameters.add(result.getHandle());
		return result;
	}
	
	protected void mergeIntoParent() {
		for(StackedUnboundParameter unboundParameter: stackedUnboundParameters.values()) {
			unboundParameter.mergeIntoParent();
		}
		ResolvedTypes parent = getParent();
		mergeInto(parent);
	}
	

	protected void mergeInto(ResolvedTypes parent) {
		mergeTypeParametersIntoParent(parent);
		parent.ensureExpressionTypesMapExists().putAll(ensureExpressionTypesMapExists());
		parent.ensureTypesMapExists().putAll(ensureTypesMapExists());
		parent.ensureLinkingMapExists().putAll(ensureLinkingMapExists());
	}

	protected void mergeTypeParametersIntoParent(ResolvedTypes parent) {
		Map<Object, BaseUnboundTypeParameter> parentMap = parent.ensureTypeParameterMapExists();
		for (Object handle: createdParameters) {
			getUnboundTypeParameter(handle).bindIfPossible();
		}
		for(BaseUnboundTypeParameter unbound: ensureTypeParameterMapExists().values()) {
			unbound.setResolvedTypes(parent);
			if (parentMap.put(unbound.getHandle(), unbound) != null) {
				throw new IllegalStateException("Parent had already a type parameter with key: " + unbound.getHandle());
			}
		}
	}

	@Override
	protected Collection<TypeData> doGetTypeData(XExpression expression) {
		Collection<TypeData> result = super.doGetTypeData(expression);
		if (result == null) {
			result = parent.doGetTypeData(expression);
		}
		return result;
	}
	
	@Override
	public LightweightTypeReference internalGetActualType(JvmIdentifiableElement identifiable) {
		LightweightTypeReference result = super.internalGetActualType(identifiable);
		if (result == null) {
			result = parent.internalGetActualType(identifiable);
		}
		return result;
	}
	
	@Override
	public List<LightweightTypeReference> internalGetActualTypeArguments(XExpression expression) {
		List<LightweightTypeReference> result = super.internalGetActualTypeArguments(expression);
		if (result == null) {
			result = parent.internalGetActualTypeArguments(expression);
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
	public void reassignType(JvmIdentifiableElement identifiable, LightweightTypeReference reference) {
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
			result = stackedUnboundParameters.get(handle);
			if (result == null) {
				result = parent.getUnboundTypeParameter(handle);
				StackedUnboundParameter stackedResult = new StackedUnboundParameter(result, this);
				stackedUnboundParameters.put(result.getHandle(), stackedResult);
				result = stackedResult;
			}
		}
		return result;
	}

	@Override
	protected void appendContent(StringBuilder result, String indentation) {
		super.appendContent(result, indentation);
		appendContent(stackedUnboundParameters, "stackedUnboundParameters", result, indentation);
		result.append("\n" + indentation + "parent: [");
		parent.appendContent(result, indentation + "  ");
		closeBracket(result);
	}
}
