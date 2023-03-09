/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.xbase.typesystem.computation.IApplicableCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeAssigner;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
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

	@Override
	public List<? extends IConstructorLinkingCandidate> getLinkingCandidates(XConstructorCall constructorCall) {
		List<IConstructorLinkingCandidate> result = Lists.newArrayList();
		for (ITypeComputationState component : components) {
			result.addAll(component.getLinkingCandidates(constructorCall));
		}
		return result;
	}

	@Override
	public List<? extends IFeatureLinkingCandidate> getLinkingCandidates(XAbstractFeatureCall featureCall) {
		List<IFeatureLinkingCandidate> result = Lists.newArrayList();
		for (ITypeComputationState component : components) {
			result.addAll(component.getLinkingCandidates(featureCall));
		}
		return result;
	}

	@Override
	public ITypeComputationState withExpectation(LightweightTypeReference expectation) {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withExpectation(expectation);
		}
		return new CompoundTypeComputationState(owner, result);
	}
	
	@Override
	public void refineExpectedType(XExpression expression, LightweightTypeReference expectation) {
		for (ITypeComputationState component : components) {
			component.refineExpectedType(expression, expectation);
		}
	}
	
	@Override
	public ITypeComputationState withRootExpectation(LightweightTypeReference expectation) {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withRootExpectation(expectation);
		}
		return new CompoundTypeComputationState(owner, result);
	}
	
	@Override
	public ITypeComputationState withoutRootExpectation() {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withoutRootExpectation();
		}
		return new CompoundTypeComputationState(owner, result);
	}

	@Override
	public ITypeComputationState withNonVoidExpectation() {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withNonVoidExpectation();
		}
		return new CompoundTypeComputationState(owner, result);
	}

	@Override
	public ITypeComputationState withReturnExpectation() {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withReturnExpectation();
		}
		return new CompoundTypeComputationState(owner, result);
	}

	@Override
	public ITypeComputationState withoutExpectation() {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withoutExpectation();
		}
		return new CompoundTypeComputationState(owner, result);
	}

	@Override
	public ITypeComputationState withTypeCheckpoint(/* @Nullable */ EObject context) {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withTypeCheckpoint(context);
		}
		return new CompoundTypeComputationState(owner, result);
	}

	@Override
	public ITypeComputationResult computeTypes(/* @Nullable */ XExpression expression) {
		if (expression == null) {
			throw new IllegalArgumentException("XExpression may not be null");
		}
		StackedResolvedTypes resolvedTypes = components[0].doComputeTypes(expression);
		int flags = resolvedTypes.getConformanceFlags(expression, false);
		for(int i = 1; i < components.length; i++) {
			StackedResolvedTypes candidate = components[i].doComputeTypes(expression);
			int candidateFlags = candidate.getConformanceFlags(expression, false);
			int compareResult = compareFlags(flags, candidateFlags);
			if (compareResult == 1) {
				resolvedTypes = candidate;
				flags = candidateFlags;
			}
		}
		resolvedTypes.performMergeIntoParent();
		ResolutionBasedComputationResult result = new ResolutionBasedComputationResult(expression, resolvedTypes.getParent());
		return result;
	}
	
	private int compareFlags(int leftConformance, int rightConformance) {
		int result = ConformanceFlags.compareFlags(leftConformance, rightConformance);
		if (result != 0) {
			return result;
		}
		if ((leftConformance & ConformanceFlags.VAR_ARG) != (rightConformance & ConformanceFlags.VAR_ARG)) {
			if ((leftConformance & ConformanceFlags.VAR_ARG) != 0)
				return 1;
			return -1;
		}
		return 0;
	}

	@Override
	public ITypeComputationState assignType(JvmIdentifiableElement element, /* @Nullable */ LightweightTypeReference type) {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].assignType(element, type);
		}
		return new CompoundTypeComputationState(owner, result);
	}
	
	@Override
	public ITypeComputationState assignType(JvmIdentifiableElement element, /* @Nullable */ LightweightTypeReference type, boolean addToChildScope) {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].assignType(element, type, addToChildScope);
		}
		return new CompoundTypeComputationState(owner, result);
	}
	
	@Override
	public void addExtensionToCurrentScope(JvmIdentifiableElement extensionProvider) {
		for (int i = 0; i < components.length; i++) {
			components[i].addExtensionToCurrentScope(extensionProvider);
		}
	}
	
	@Override
	public void addTypeToStaticImportScope(JvmDeclaredType type) {
		for (int i = 0; i < components.length; i++) {
			components[i].addTypeToStaticImportScope(type);
		}
	}
	
	@Override
	public void addImports(ITypeImporter.Client importer) {
		for (int i = 0; i < components.length; i++) {
			components[i].addImports(importer);
		}
	}
	
	@Override
	public void addTypeToStaticExtensionImportScope(JvmDeclaredType type) {
		for (int i = 0; i < components.length; i++) {
			components[i].addTypeToStaticExtensionImportScope(type);
		}
	}
	
	@Override
	public void addExtensionsToCurrentScope(List<? extends JvmIdentifiableElement> extensionProviders) {
		for (int i = 0; i < components.length; i++) {
			components[i].addExtensionsToCurrentScope(extensionProviders);
		}
	}

	@Override
	public ITypeAssigner assignTypes() {
		TypeAssigner[] array = new TypeAssigner[components.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = components[i].assignTypes();
		}
		return new CompoundTypeAssigner(owner, array);
	}
	
	@Override
	public void addDiagnostic(AbstractDiagnostic diagnostic) {
		for (int i = 0; i < components.length; i++) {
			components[i].addDiagnostic(diagnostic);
		}
	}

	@Override
	public ITypeReferenceOwner getReferenceOwner() {
		return owner;
	}
	
	public LightweightTypeReference toLightweightTypeReference(JvmTypeReference reference) {
		return owner.toLightweightTypeReference(reference);
	}

	@Override
	public void addLocalToCurrentScope(JvmIdentifiableElement element) {
		for (int i = 0; i < components.length; i++) {
			components[i].addLocalToCurrentScope(element);
		}
	}
	
	@Override
	public void assignType(QualifiedName name, JvmType rawType, LightweightTypeReference actualType) {
		for (int i = 0; i < components.length; i++) {
			components[i].assignType(name, rawType, actualType);
		}
	}

	@Override
	public List<? extends ITypeExpectation> getExpectations() {
		List<ITypeExpectation> result = Lists.newArrayList();
		for (int i = 0; i < components.length; i++) {
			result.addAll(components[i].getExpectations());
		}
		return result;
	}
	
	@Override
	public void acceptCandidate(XExpression expression, IApplicableCandidate candidate) {
		for (int i = 0; i < components.length; i++) {
			components[i].acceptCandidate(expression, candidate);
		}
	}

	@Override
	public void acceptActualType(LightweightTypeReference type) {
		for (int i = 0; i < components.length; i++) {
			components[i].acceptActualType(type);
		}
	}
	
	@Override
	public void acceptActualType(LightweightTypeReference type, int flags) {
		for (int i = 0; i < components.length; i++) {
			components[i].acceptActualType(type, flags);
		}
	}
	
	@Override
	public void acceptActualType(LightweightTypeReference type, ConformanceHint... hints) {
		for (int i = 0; i < components.length; i++) {
			components[i].acceptActualType(type, hints);
		}
	}
	
	@Override
	public void acceptActualType(LightweightTypeReference type, EnumSet<ConformanceHint> hints) {
		for (int i = 0; i < components.length; i++) {
			components[i].acceptActualType(type, hints);
		}
	}

	@Override
	public void reassignType(JvmIdentifiableElement refinable, LightweightTypeReference type) {
		for (int i = 0; i < components.length; i++) {
			components[i].reassignType(refinable, type);
		}
	}

	@Override
	public void discardReassignedTypes(JvmIdentifiableElement refinable) {
		for (int i = 0; i < components.length; i++) {
			components[i].discardReassignedTypes(refinable);
		}
	}
	
	@Override
	public UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter typeParameter) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public List<LightweightTypeReference> getExpectedExceptions() {
		List<LightweightTypeReference> result = Lists.newArrayList();
		for (int i = 0; i < components.length; i++) {
			result.addAll(components[i].getExpectedExceptions());
		}
		return result;
	}
	
	@Override
	public ITypeComputationState withExpectedExceptions(List<LightweightTypeReference> declaredExceptionTypes) {
		AbstractTypeComputationState[] result = new AbstractTypeComputationState[components.length];
		for (int i = 0; i < components.length; i++) {
			result[i] = components[i].withExpectedExceptions(declaredExceptionTypes);
		}
		return new CompoundTypeComputationState(owner, result);
	}
	
	@Override
	public Severity getSeverity(String issueCode) {
		for (AbstractTypeComputationState state : components)
			return state.getSeverity(issueCode);
		throw new IllegalStateException("no components available.");
	}

	@Override
	public boolean isIgnored(String issueCode) {
		for (AbstractTypeComputationState state : components)
			return state.isIgnored(issueCode);
		throw new IllegalStateException("no components available.");
	}
	
	@Override
	public void withinScope(EObject context) {
		for (int i = 0; i < components.length; i++) {
			components[i].withinScope(context);
		}
	}
	
	@Override
	public void afterScope(EObject context) {
		for (int i = 0; i < components.length; i++) {
			components[i].afterScope(context);
		}
	}
	
	@Override
	public void rewriteScope(EObject context) {
		for (int i = 0; i < components.length; i++) {
			components[i].rewriteScope(context);
		}
	}
}
