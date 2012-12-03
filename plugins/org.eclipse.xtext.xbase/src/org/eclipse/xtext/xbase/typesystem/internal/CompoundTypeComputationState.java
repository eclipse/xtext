/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.EnumSet;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeAssigner;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class CompoundTypeComputationState implements ITypeComputationState {

	private AbstractTypeComputationState[] components;
	private ITypeReferenceOwner owner;

	public CompoundTypeComputationState(ITypeReferenceOwner owner, AbstractTypeComputationState... components) {
		this.owner = owner;
		this.components = components;
	}

	public List<? extends IConstructorLinkingCandidate> getLinkingCandidates(XConstructorCall constructorCall) {
		List<IConstructorLinkingCandidate> result = Lists.newArrayList();
		for (ITypeComputationState component : components) {
			result.addAll(component.getLinkingCandidates(constructorCall));
		}
		return result;
	}

	public List<? extends IFeatureLinkingCandidate> getLinkingCandidates(XAbstractFeatureCall featureCall) {
		List<IFeatureLinkingCandidate> result = Lists.newArrayList();
		for (ITypeComputationState component : components) {
			result.addAll(component.getLinkingCandidates(featureCall));
		}
		return result;
	}

	public ITypeComputationState withExpectation(LightweightTypeReference expectation) {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withExpectation(expectation);
		}
		return new CompoundTypeComputationState(owner, result);
	}
	
	public void refineExpectedType(XExpression expression, LightweightTypeReference expectation) {
		for (ITypeComputationState component : components) {
			component.refineExpectedType(expression, expectation);
		}
	}
	
	public ITypeComputationState withRootExpectation(LightweightTypeReference expectation) {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withRootExpectation(expectation);
		}
		return new CompoundTypeComputationState(owner, result);
	}

	public ITypeComputationState withNonVoidExpectation() {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withNonVoidExpectation();
		}
		return new CompoundTypeComputationState(owner, result);
	}

	public ITypeComputationState withReturnExpectation() {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withReturnExpectation();
		}
		return new CompoundTypeComputationState(owner, result);
	}

	public ITypeComputationState withoutExpectation() {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withoutExpectation();
		}
		return new CompoundTypeComputationState(owner, result);
	}

	public ITypeComputationState withTypeCheckpoint() {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withTypeCheckpoint();
		}
		return new CompoundTypeComputationState(owner, result);
	}

	public ITypeComputationResult computeTypes(@Nullable XExpression expression) {
		if (expression == null) {
			throw new IllegalArgumentException("XExpression may not be null");
		}
		StackedResolvedTypes resolvedTypes = components[0].doComputeTypes(expression);
		EnumSet<ConformanceHint> conformanceHints = resolvedTypes.getConformanceHints(expression);
		for(int i = 1; i < components.length; i++) {
			StackedResolvedTypes candidate = components[i].doComputeTypes(expression);
			EnumSet<ConformanceHint> candidateHints = candidate.getConformanceHints(expression);
			int compareResult = ConformanceHint.compareHints(conformanceHints, candidateHints);
			if (compareResult == 1) {
				resolvedTypes = candidate;
				conformanceHints = candidateHints;
			}
		}
		resolvedTypes.performMergeIntoParent();
		ResolutionBasedComputationResult result = new ResolutionBasedComputationResult(expression, resolvedTypes.getParent());
		return result;
	}

	public ITypeComputationState assignType(JvmIdentifiableElement element, LightweightTypeReference type) {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].assignType(element, type);
		}
		return new CompoundTypeComputationState(owner, result);
	}

	public ITypeAssigner assignTypes() {
		TypeAssigner[] array = new TypeAssigner[components.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = components[i].assignTypes();
		}
		return new CompoundTypeAssigner(owner, array);
	}

	public ITypeReferenceOwner getReferenceOwner() {
		return owner;
	}
	
	public OwnedConverter getConverter() {
		return new OwnedConverter(owner);
	}

	public LightweightTypeReference toLightweightTypeReference(JvmTypeReference reference) {
		return new OwnedConverter(owner).toLightweightReference(reference);
	}

	public void addLocalToCurrentScope(JvmIdentifiableElement element) {
		for (int i = 0; i < components.length; i++) {
			components[i].addLocalToCurrentScope(element);
		}
	}

	public List<? extends ITypeExpectation> getExpectations() {
		List<ITypeExpectation> result = Lists.newArrayList();
		for (int i = 0; i < components.length; i++) {
			result.addAll(components[i].getExpectations());
		}
		return result;
	}

	public void acceptActualType(LightweightTypeReference type) {
		for (int i = 0; i < components.length; i++) {
			components[i].acceptActualType(type);
		}
	}

	public void reassignType(JvmIdentifiableElement refinable, LightweightTypeReference type) {
		for (int i = 0; i < components.length; i++) {
			components[i].reassignType(refinable, type);
		}
	}

	public void discardReassignedTypes(JvmIdentifiableElement refinable) {
		for (int i = 0; i < components.length; i++) {
			components[i].discardReassignedTypes(refinable);
		}
	}
	
}
