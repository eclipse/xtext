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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.ITypeImporter;
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
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
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
	
	public ITypeComputationState withoutRootExpectation() {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withoutRootExpectation();
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

	public ITypeComputationState withTypeCheckpoint(/* @Nullable */ EObject context) {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withTypeCheckpoint(context);
		}
		return new CompoundTypeComputationState(owner, result);
	}

	public ITypeComputationResult computeTypes(/* @Nullable */ XExpression expression) {
		if (expression == null) {
			throw new IllegalArgumentException("XExpression may not be null");
		}
		StackedResolvedTypes resolvedTypes = components[0].doComputeTypes(expression);
		EnumSet<ConformanceHint> conformanceHints = resolvedTypes.getConformanceHints(expression, false);
		for(int i = 1; i < components.length; i++) {
			StackedResolvedTypes candidate = components[i].doComputeTypes(expression);
			EnumSet<ConformanceHint> candidateHints = candidate.getConformanceHints(expression, false);
			int compareResult = compareHints(conformanceHints, candidateHints);
			if (compareResult == 1) {
				resolvedTypes = candidate;
				conformanceHints = candidateHints;
			}
		}
		resolvedTypes.performMergeIntoParent();
		ResolutionBasedComputationResult result = new ResolutionBasedComputationResult(expression, resolvedTypes.getParent());
		return result;
	}
	
	private int compareHints(EnumSet<ConformanceHint> leftConformance, EnumSet<ConformanceHint> rightConformance) {
		if (leftConformance.equals(rightConformance)) {
			return 0;
		}
		int result = ConformanceHint.compareHints(leftConformance, rightConformance);
		if (result != 0) {
			return result;
		}
		if (leftConformance.contains(ConformanceHint.VAR_ARG) != rightConformance.contains(ConformanceHint.VAR_ARG)) {
			if (leftConformance.contains(ConformanceHint.VAR_ARG))
				return 1;
			return -1;
		}
		return 0;
	}

	public ITypeComputationState assignType(JvmIdentifiableElement element, /* @Nullable */ LightweightTypeReference type) {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].assignType(element, type);
		}
		return new CompoundTypeComputationState(owner, result);
	}
	
	public ITypeComputationState assignType(JvmIdentifiableElement element, /* @Nullable */ LightweightTypeReference type, boolean addToChildScope) {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].assignType(element, type, addToChildScope);
		}
		return new CompoundTypeComputationState(owner, result);
	}
	
	public void addExtensionToCurrentScope(JvmIdentifiableElement extensionProvider) {
		for (int i = 0; i < components.length; i++) {
			components[i].addExtensionToCurrentScope(extensionProvider);
		}
	}
	
	public void addTypeToStaticImportScope(JvmDeclaredType type) {
		for (int i = 0; i < components.length; i++) {
			components[i].addTypeToStaticImportScope(type);
		}
	}
	
	public void addImports(ITypeImporter.Client importer) {
		for (int i = 0; i < components.length; i++) {
			components[i].addImports(importer);
		}
	}
	
	public void addTypeToStaticExtensionImportScope(JvmDeclaredType type) {
		for (int i = 0; i < components.length; i++) {
			components[i].addTypeToStaticExtensionImportScope(type);
		}
	}
	
	public void addExtensionsToCurrentScope(List<? extends JvmIdentifiableElement> extensionProviders) {
		for (int i = 0; i < components.length; i++) {
			components[i].addExtensionsToCurrentScope(extensionProviders);
		}
	}

	public ITypeAssigner assignTypes() {
		TypeAssigner[] array = new TypeAssigner[components.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = components[i].assignTypes();
		}
		return new CompoundTypeAssigner(owner, array);
	}
	
	public void addDiagnostic(AbstractDiagnostic diagnostic) {
		for (int i = 0; i < components.length; i++) {
			components[i].addDiagnostic(diagnostic);
		}
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
	
	public void assignType(QualifiedName name, JvmType rawType, LightweightTypeReference actualType) {
		for (int i = 0; i < components.length; i++) {
			components[i].assignType(name, rawType, actualType);
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
	
	public void acceptActualType(LightweightTypeReference type, ConformanceHint... hints) {
		for (int i = 0; i < components.length; i++) {
			components[i].acceptActualType(type, hints);
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
	
	public UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter typeParameter) {
		throw new UnsupportedOperationException();
	}
	
	public List<LightweightTypeReference> getExpectedExceptions() {
		List<LightweightTypeReference> result = Lists.newArrayList();
		for (int i = 0; i < components.length; i++) {
			result.addAll(components[i].getExpectedExceptions());
		}
		return result;
	}
	
	public ITypeComputationState withExpectedExceptions(List<LightweightTypeReference> declaredExceptionTypes) {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withExpectedExceptions(declaredExceptionTypes);
		}
		return new CompoundTypeComputationState(owner, result);
	}
	
	public Severity getSeverity(String issueCode) {
		for (AbstractTypeComputationState state : components)
			return state.getSeverity(issueCode);
		throw new IllegalStateException("no components available.");
	}

	public boolean isIgnored(String issueCode) {
		for (AbstractTypeComputationState state : components)
			return state.isIgnored(issueCode);
		throw new IllegalStateException("no components available.");
	}
	
	public void withinScope(EObject context) {
		for (int i = 0; i < components.length; i++) {
			components[i].withinScope(context);
		}
	}
	
	public void afterScope(EObject context) {
		for (int i = 0; i < components.length; i++) {
			components[i].afterScope(context);
		}
	}
	
	public void rewriteScope(EObject context) {
		for (int i = 0; i < components.length; i++) {
			components[i].rewriteScope(context);
		}
	}
}
