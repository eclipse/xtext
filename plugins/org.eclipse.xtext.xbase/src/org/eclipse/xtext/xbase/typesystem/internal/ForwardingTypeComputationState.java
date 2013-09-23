/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
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

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class ForwardingTypeComputationState implements ITypeComputationState {

	private ITypeComputationState delegate;
	
	public ForwardingTypeComputationState(ITypeComputationState delegate) {
		this.delegate = delegate;
	}
	
	protected ITypeComputationState getDelegate() {
		return delegate;
	}
	
	protected abstract ForwardingTypeComputationState newForwardingTypeComputationState(ITypeComputationState delegate);

	public ITypeComputationState withExpectation(LightweightTypeReference expectation) {
		return newForwardingTypeComputationState(delegate.withExpectation(expectation));
	}

	public void refineExpectedType(XExpression expression, LightweightTypeReference expectation) {
		delegate.refineExpectedType(expression, expectation);
	}

	public ITypeComputationState withRootExpectation(LightweightTypeReference expectation) {
		return newForwardingTypeComputationState(delegate.withRootExpectation(expectation));
	}

	public ITypeComputationState withoutRootExpectation() {
		return newForwardingTypeComputationState(delegate.withoutRootExpectation());
	}

	public ITypeComputationState withNonVoidExpectation() {
		return newForwardingTypeComputationState(delegate.withNonVoidExpectation());
	}

	public ITypeComputationState withReturnExpectation() {
		return newForwardingTypeComputationState(delegate.withReturnExpectation());
	}

	public ITypeComputationState withoutExpectation() {
		return newForwardingTypeComputationState(delegate.withoutExpectation());
	}

	public ITypeComputationState withTypeCheckpoint(@Nullable EObject context) {
		return newForwardingTypeComputationState(delegate.withTypeCheckpoint(context));
	}

	public ITypeComputationState withExpectedExceptions(List<LightweightTypeReference> declaredExceptionTypes) {
		return newForwardingTypeComputationState(delegate.withExpectedExceptions(declaredExceptionTypes));
	}

	public List<LightweightTypeReference> getExpectedExceptions() {
		return delegate.getExpectedExceptions();
	}

	public ITypeComputationResult computeTypes(@Nullable XExpression expression) {
		return delegate.computeTypes(expression);
	}

	public ITypeComputationState assignType(JvmIdentifiableElement element, @Nullable LightweightTypeReference type) {
		return newForwardingTypeComputationState(delegate.assignType(element, type));
	}

	public ITypeComputationState assignType(JvmIdentifiableElement element, @Nullable LightweightTypeReference type, boolean addToChildScope) {
		return newForwardingTypeComputationState(delegate.assignType(element, type, addToChildScope));
	}

	public ITypeAssigner assignTypes() {
		final ITypeAssigner result = delegate.assignTypes();
		return new ITypeAssigner() {

			public void assignType(JvmIdentifiableElement element, @Nullable LightweightTypeReference actualType) {
				result.assignType(element, actualType);
			}

			public ITypeComputationState getForkedState() {
				return newForwardingTypeComputationState(result.getForkedState());
			}

			public ITypeReferenceOwner getReferenceOwner() {
				return result.getReferenceOwner();
			}

			public LightweightTypeReference toLightweightTypeReference(JvmTypeReference reference) {
				return result.toLightweightTypeReference(reference);
			}
			
		};
	}

	public void addLocalToCurrentScope(JvmIdentifiableElement element) {
		delegate.addLocalToCurrentScope(element);
	}

	public void addExtensionToCurrentScope(JvmIdentifiableElement extensionProvider) {
		delegate.addExtensionToCurrentScope(extensionProvider);
	}
	
	public void addTypeToStaticImportScope(JvmDeclaredType type) {
		delegate.addTypeToStaticImportScope(type);
	}

	public void addExtensionsToCurrentScope(List<? extends JvmIdentifiableElement> extensionProviders) {
		delegate.addExtensionsToCurrentScope(extensionProviders);
	}

	public void assignType(QualifiedName name, JvmType rawType, LightweightTypeReference actualType) {
		delegate.assignType(name, rawType, actualType);
	}

	public void addDiagnostic(AbstractDiagnostic diagnostic) {
		delegate.addDiagnostic(diagnostic);
	}

	public List<? extends ITypeExpectation> getExpectations() {
		return delegate.getExpectations();
	}

	public List<? extends IConstructorLinkingCandidate> getLinkingCandidates(XConstructorCall constructorCall) {
		return delegate.getLinkingCandidates(constructorCall);
	}

	public List<? extends IFeatureLinkingCandidate> getLinkingCandidates(XAbstractFeatureCall featureCall) {
		return delegate.getLinkingCandidates(featureCall);
	}

	public void acceptActualType(LightweightTypeReference type) {
		delegate.acceptActualType(type);
	}

	public void acceptActualType(LightweightTypeReference type, ConformanceHint... hints) {
		delegate.acceptActualType(type, hints);
	}

	public void reassignType(JvmIdentifiableElement refinable, LightweightTypeReference type) {
		delegate.reassignType(refinable, type);
	}

	public void discardReassignedTypes(JvmIdentifiableElement refinable) {
		delegate.discardReassignedTypes(refinable);
	}

	public ITypeReferenceOwner getReferenceOwner() {
		return delegate.getReferenceOwner();
	}

	public OwnedConverter getConverter() {
		return delegate.getConverter();
	}

	public UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter typeParameter) {
		return delegate.createUnboundTypeReference(expression, typeParameter);
	}

	public Severity getSeverity(String issueCode) {
		return delegate.getSeverity(issueCode);
	}

	public boolean isIgnored(String issueCode) {
		return delegate.isIgnored(issueCode);
	}
	
}
