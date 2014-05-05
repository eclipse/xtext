/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.validation.IssueCodes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class TypeLiteralLinkingCandidate extends AbstractPendingLinkingCandidate<XAbstractFeatureCall> implements ITypeLiteralLinkingCandidate {

	private TypeLiteralHelper helper;

	public TypeLiteralLinkingCandidate(
			XAbstractFeatureCall featureCall, 
			IIdentifiableElementDescription description,
			ITypeExpectation expectation, 
			final ExpressionTypeComputationState state) {
		super(featureCall, description, expectation, state, new TypeLiteralLinkingCandidateResolver(featureCall) {
			
			@Override
			protected IFeatureLinkingCandidate getLinkingCandidate(XExpression target) {
				return state.getResolvedTypes().getLinkingCandidate((XAbstractFeatureCall) target);
			}
			
		});
		if (featureCall.isExplicitOperationCallOrBuilderSyntax()) {
			throw new IllegalArgumentException("Cannot be a type literal: " + String.valueOf(featureCall));
		}
		this.helper = new TypeLiteralHelper(state);
	}
	
	@Override
	public void computeArgumentTypes() {
		// nothing to do
	}
	
	// TODO java.awt.List / java.util.List
	@Override
	protected ILinkingCandidate createAmbiguousLinkingCandidate(AbstractPendingLinkingCandidate<?> second) {
		return this;
	}

	/**
	 * Returns the actual arguments of the expression. These do not include the
	 * receiver.  
	 */
	@Override
	protected List<XExpression> getArguments() {
		return Collections.emptyList();
	}

	@Override
	protected String getFeatureTypeName() {
		return "type";
	}

	@Override
	public int getArityMismatch() {
		return 0;
	}
	
	@Override
	protected List<XExpression> getSyntacticArguments() {
		return Collections.emptyList();
	}
	
	@Override
	public boolean isExtension() {
		return false;
	}
	
	@Override
	protected boolean hasReceiver() {
		return false;
	}
	
	public boolean isStatic() {
		return false;
	}
	
	@Override
	public boolean isTypeLiteral() {
		return true;
	}

	public XAbstractFeatureCall getFeatureCall() {
		return getExpression();
	}
	
	@Override
	protected List<LightweightTypeReference> getSyntacticTypeArguments() {
		return Collections.emptyList();
	}
	
	@Override
	protected boolean validateTypeArity(IAcceptor<? super AbstractDiagnostic> result) {
		int numberOfTypeArgs = getFeatureCall().getTypeArguments().size();
		if (numberOfTypeArgs != 0) {
			String message = String.format("Invalid type %1$s. Type arguments cannot be applied to the type literal %2$s",
					numberOfTypeArgs == 1 ? "argument" : "arguments",
					getFeature().getSimpleName());
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
					Severity.ERROR, 
					IssueCodes.INVALID_TYPE_ARGUMENTS_ON_TYPE_LITERAL, 
					message, 
					getExpression(),
					XbasePackage.Literals.XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS,
					-1, null) {
				
				ICompositeNode node = NodeModelUtils.getNode(getFeatureCall());
				
				@Override
				public int getLength() {
					for(INode child: node.getChildren()) {
						EObject grammarElement = child.getGrammarElement();
						if (grammarElement instanceof Keyword) {
							if (">".equals(((Keyword) grammarElement).getValue())) {
								return child.getEndOffset() - getOffset();
							}
						}
					}
					return 0;
				}
				@Override
				public int getOffset() {
					for(INode child: node.getChildren()) {
						EObject grammarElement = child.getGrammarElement();
						if (grammarElement instanceof Keyword) {
							if ("<".equals(((Keyword) grammarElement).getValue())) {
								return child.getOffset();
							}
						}
					}
					return 0;
				}
				
				@Override
				public int getLine() {
					for(INode child: node.getChildren()) {
						EObject grammarElement = child.getGrammarElement();
						if (grammarElement instanceof Keyword) {
							if ("<".equals(((Keyword) grammarElement).getValue())) {
								return child.getStartLine();
							}
						}
					}
					return 0;
				}
			};
			result.accept(diagnostic);
			return false;
		}
		return true;
	}
	
	@Override
	protected LightweightTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		return helper.getAsClassLiteral(feature);
	}
	
	@Override
	protected List<JvmTypeParameter> getDeclaredTypeParameters() {
		return Collections.emptyList();
	}
	
	@Override
	public int getTypeArityMismatch() {
		return 0;
	}
	
	@Override
	protected int getTypeArgumentConformanceFailures(@Nullable IAcceptor<? super AbstractDiagnostic> acceptor) {
		return 0;
	}
	
	@Override
	public List<LightweightTypeReference> getTypeArguments() {
		return Collections.emptyList();
	}
	
	@Override
	protected void preApply() {
		helper.applyPackageFragment(getExpression(), getType());
	}
	
	public JvmType getType() {
		return (JvmType) getFeature();
	}
	
	public void applyToModel() {
		resolveLinkingProxy(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE);
	}

}
