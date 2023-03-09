/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

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
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class ForwardingTypeComputationState implements ITypeComputationState {

	private ITypeComputationState delegate;
	
	public ForwardingTypeComputationState(ITypeComputationState delegate) {
		this.delegate = delegate;
	}
	
	protected ITypeComputationState getDelegate() {
		return delegate;
	}
	
	protected abstract ForwardingTypeComputationState newForwardingTypeComputationState(ITypeComputationState delegate);

	@Override
	public ITypeComputationState withExpectation(LightweightTypeReference expectation) {
		return newForwardingTypeComputationState(delegate.withExpectation(expectation));
	}

	@Override
	public void refineExpectedType(XExpression expression, LightweightTypeReference expectation) {
		delegate.refineExpectedType(expression, expectation);
	}

	@Override
	public ITypeComputationState withRootExpectation(LightweightTypeReference expectation) {
		return newForwardingTypeComputationState(delegate.withRootExpectation(expectation));
	}

	@Override
	public ITypeComputationState withoutRootExpectation() {
		return newForwardingTypeComputationState(delegate.withoutRootExpectation());
	}

	@Override
	public ITypeComputationState withNonVoidExpectation() {
		return newForwardingTypeComputationState(delegate.withNonVoidExpectation());
	}

	@Override
	public ITypeComputationState withReturnExpectation() {
		return newForwardingTypeComputationState(delegate.withReturnExpectation());
	}

	@Override
	public ITypeComputationState withoutExpectation() {
		return newForwardingTypeComputationState(delegate.withoutExpectation());
	}

	@Override
	public ITypeComputationState withTypeCheckpoint(/* @Nullable */ EObject context) {
		return newForwardingTypeComputationState(delegate.withTypeCheckpoint(context));
	}

	@Override
	public ITypeComputationState withExpectedExceptions(List<LightweightTypeReference> declaredExceptionTypes) {
		return newForwardingTypeComputationState(delegate.withExpectedExceptions(declaredExceptionTypes));
	}

	@Override
	public List<LightweightTypeReference> getExpectedExceptions() {
		return delegate.getExpectedExceptions();
	}

	@Override
	public ITypeComputationResult computeTypes(/* @Nullable */ XExpression expression) {
		return delegate.computeTypes(expression);
	}

	@Override
	public ITypeComputationState assignType(JvmIdentifiableElement element, /* @Nullable */ LightweightTypeReference type) {
		return newForwardingTypeComputationState(delegate.assignType(element, type));
	}

	@Override
	public ITypeComputationState assignType(JvmIdentifiableElement element, /* @Nullable */ LightweightTypeReference type, boolean addToChildScope) {
		return newForwardingTypeComputationState(delegate.assignType(element, type, addToChildScope));
	}

	@Override
	public ITypeAssigner assignTypes() {
		final ITypeAssigner result = delegate.assignTypes();
		return new ITypeAssigner() {

			@Override
			public void assignType(JvmIdentifiableElement element, /* @Nullable */ LightweightTypeReference actualType) {
				result.assignType(element, actualType);
			}

			@Override
			public ITypeComputationState getForkedState() {
				return newForwardingTypeComputationState(result.getForkedState());
			}

			@Override
			public ITypeReferenceOwner getReferenceOwner() {
				return result.getReferenceOwner();
			}

			@Override
			public LightweightTypeReference toLightweightTypeReference(JvmTypeReference reference) {
				return result.toLightweightTypeReference(reference);
			}
			
		};
	}

	@Override
	public void addLocalToCurrentScope(JvmIdentifiableElement element) {
		delegate.addLocalToCurrentScope(element);
	}

	@Override
	public void addExtensionToCurrentScope(JvmIdentifiableElement extensionProvider) {
		delegate.addExtensionToCurrentScope(extensionProvider);
	}
	
	@Override
	public void addTypeToStaticImportScope(JvmDeclaredType type) {
		delegate.addTypeToStaticImportScope(type);
	}
	
	@Override
	public void addTypeToStaticExtensionImportScope(JvmDeclaredType type) {
		delegate.addTypeToStaticExtensionImportScope(type);
	}

	@Override
	public void addImports(ITypeImporter.Client importer) {
		delegate.addImports(importer);
	}

	@Override
	public void addExtensionsToCurrentScope(List<? extends JvmIdentifiableElement> extensionProviders) {
		delegate.addExtensionsToCurrentScope(extensionProviders);
	}

	@Override
	public void assignType(QualifiedName name, JvmType rawType, LightweightTypeReference actualType) {
		delegate.assignType(name, rawType, actualType);
	}

	@Override
	public void addDiagnostic(AbstractDiagnostic diagnostic) {
		delegate.addDiagnostic(diagnostic);
	}

	@Override
	public List<? extends ITypeExpectation> getExpectations() {
		return delegate.getExpectations();
	}

	@Override
	public List<? extends IConstructorLinkingCandidate> getLinkingCandidates(XConstructorCall constructorCall) {
		return delegate.getLinkingCandidates(constructorCall);
	}

	@Override
	public List<? extends IFeatureLinkingCandidate> getLinkingCandidates(XAbstractFeatureCall featureCall) {
		return delegate.getLinkingCandidates(featureCall);
	}

	@Override
	public void acceptActualType(LightweightTypeReference type) {
		delegate.acceptActualType(type);
	}

	@Override
	public void acceptActualType(LightweightTypeReference type, int flags) {
		delegate.acceptActualType(type, flags);
	}

	@Override
	public void reassignType(JvmIdentifiableElement refinable, LightweightTypeReference type) {
		delegate.reassignType(refinable, type);
	}

	@Override
	public void discardReassignedTypes(JvmIdentifiableElement refinable) {
		delegate.discardReassignedTypes(refinable);
	}

	@Override
	public ITypeReferenceOwner getReferenceOwner() {
		return delegate.getReferenceOwner();
	}

	@Override
	public UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter typeParameter) {
		return delegate.createUnboundTypeReference(expression, typeParameter);
	}

	@Override
	public Severity getSeverity(String issueCode) {
		return delegate.getSeverity(issueCode);
	}

	@Override
	public boolean isIgnored(String issueCode) {
		return delegate.isIgnored(issueCode);
	}
	
	@Override
	public void withinScope(EObject context) {
		delegate.withinScope(context);
	}
	
	@Override
	public void afterScope(EObject context) {
		delegate.afterScope(context);
	}
	
	@Override
	public void rewriteScope(EObject context) {
		delegate.rewriteScope(context);
	}
	
}
