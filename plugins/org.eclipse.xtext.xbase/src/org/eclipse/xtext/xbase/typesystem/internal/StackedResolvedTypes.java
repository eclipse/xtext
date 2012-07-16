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

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class StackedResolvedTypes extends ResolvedTypes {

	private final ResolvedTypes parent;

	protected StackedResolvedTypes(ResolvedTypes parent) {
		super(parent.getResolver());
		this.parent = parent;
	}
	
	protected ResolvedTypes getParent() {
		return parent;
	}
	
	protected void mergeIntoParent() {
		ResolvedTypes parent = getParent();
		mergeInto(parent);
	}

	protected void mergeInto(ResolvedTypes parent) {
		mergeTypeParametersIntoParent(parent);
		mergeExpressionTypesIntoParent(parent);
		mergeTypesIntoParent(parent);
		mergeLinkingCandidatesIntoParent(parent);
	}
	
	protected void mergeExpressionTypesIntoParent(ResolvedTypes parent) {
		for(Map.Entry<XExpression, Collection<TypeData>> entry: basicGetExpressionTypes().asMap().entrySet()) {
			for(TypeData typeData: entry.getValue()) {
				parent.acceptType(entry.getKey(), typeData.copyInto(parent.getReferenceOwner()));
			}
		}
	}
	
	protected void mergeLinkingCandidatesIntoParent(ResolvedTypes parent) {
		Map<XExpression, ILinkingCandidate<?>> linkingCandidates = basicGetLinkingCandidates();
		if (!linkingCandidates.isEmpty()) {
			for(Map.Entry<XExpression, ILinkingCandidate<?>> entry: linkingCandidates.entrySet()) {
				parent.acceptLinkingInformation(entry.getKey(), entry.getValue());
			}
		}
	}

	protected void mergeTypesIntoParent(ResolvedTypes parent) {
		Map<JvmIdentifiableElement, LightweightTypeReference> types = basicGetTypes();
		if (!types.isEmpty()) {
			for(Map.Entry<JvmIdentifiableElement, LightweightTypeReference> entry: types.entrySet()) {
				parent.setType(entry.getKey(), entry.getValue().copyInto(parent.getReferenceOwner()));
			}
		}
	}

	protected void mergeTypeParametersIntoParent(ResolvedTypes parent) {
		for(ExpressionAwareUnboundTypeReference unbound: basicGetTypeParameters().values()) {
			LightweightTypeReference reference = unbound.copyInto(parent.getReferenceOwner());
			if (reference instanceof ExpressionAwareUnboundTypeReference) {
				parent.acceptUnboundTypeReference(unbound.getHandle(), (ExpressionAwareUnboundTypeReference) reference);
			}
		}
		ListMultimap<Object, LightweightBoundTypeArgument> typeParameterHints = basicGetTypeParameterHints();
		for(Map.Entry<Object, LightweightBoundTypeArgument> hint: typeParameterHints.entries()) {
			LightweightBoundTypeArgument boundTypeArgument = hint.getValue();
			LightweightBoundTypeArgument copy = new LightweightBoundTypeArgument(
					boundTypeArgument.getTypeReference().copyInto(parent.getReferenceOwner()), 
					boundTypeArgument.getSource(), boundTypeArgument.getOrigin(), 
					boundTypeArgument.getDeclaredVariance(), 
					boundTypeArgument.getActualVariance());
			parent.acceptHint(hint.getKey(), copy);
		}
	}

	@Override
	@Nullable
	protected Collection<TypeData> doGetTypeData(XExpression expression) {
		Collection<TypeData> result = super.doGetTypeData(expression);
		if (result == null) {
			result = parent.doGetTypeData(expression);
		}
		return result;
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference doGetActualType(JvmIdentifiableElement identifiable) {
		LightweightTypeReference result = super.doGetActualType(identifiable);
		if (result == null) {
			result = parent.doGetActualType(identifiable);
		}
		return result;
	}
	
	@Override
	@Nullable
	protected List<LightweightTypeReference> doGetActualTypeArguments(XExpression expression) {
		List<LightweightTypeReference> result = super.doGetActualTypeArguments(expression);
		if (result == null) {
			result = parent.doGetActualTypeArguments(expression);
		}
		return result;
	}
	
	@Override
	@Nullable
	public IFeatureLinkingCandidate getFeature(XAbstractFeatureCall featureCall) {
		IFeatureLinkingCandidate result = super.getFeature(featureCall);
		if (result == null) {
			result = parent.getFeature(featureCall);
		}
		return result;
	}
	
	@Override
	@Nullable
	public IConstructorLinkingCandidate getConstructor(XConstructorCall constructorCall) {
		IConstructorLinkingCandidate result = super.getConstructor(constructorCall);
		if (result == null) {
			result = parent.getConstructor(constructorCall);
		}
		return result;
	}
	
	@Override
	public void reassignType(JvmIdentifiableElement identifiable, @Nullable LightweightTypeReference reference) {
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
	protected UnboundTypeReference getUnboundTypeReference(Object handle) {
		UnboundTypeReference result = basicGetTypeParameters().get(handle);
		if (result == null) {
			result = parent.getUnboundTypeReference(handle);
			if (result.internalIsResolved())
				throw new IllegalStateException("Cannot query unbound reference that was already resolved");
			return (UnboundTypeReference) result.copyInto(getReferenceOwner());
		}
		return result;
	}
	
	@Override
	public List<LightweightBoundTypeArgument> getAllHints(Object handle) {
		// TODO Auto-generated method stub
		return super.getAllHints(handle);
	}
	
	// TODO this is overly expensive - testFeatureCall_15_n degraded to 3 secs
	@Override
	protected List<LightweightBoundTypeArgument> getHints(Object handle) {
		List<LightweightBoundTypeArgument> result = super.getHints(handle);
		if (result.isEmpty()) {
			return getParent().getHints(handle);
		}
		List<LightweightBoundTypeArgument> parentHints = getParent().getHints(handle);
		List<LightweightBoundTypeArgument> withParentHints = Lists.newArrayListWithCapacity(parentHints.size() + result.size());
		for(LightweightBoundTypeArgument parentHint: parentHints) {
			LightweightBoundTypeArgument copy = new LightweightBoundTypeArgument(
					parentHint.getTypeReference().copyInto(getReferenceOwner()), 
					parentHint.getSource(), parentHint.getOrigin(), 
					parentHint.getDeclaredVariance(), 
					parentHint.getActualVariance());
			withParentHints.add(copy);
		}
		withParentHints.addAll(result);
		return withParentHints;
	}

	@Override
	protected void appendContent(StringBuilder result, String indentation) {
		super.appendContent(result, indentation);
		result.append("\n" + indentation + "parent: [");
		parent.appendContent(result, indentation + "  ");
		closeBracket(result, indentation);
	}
}
