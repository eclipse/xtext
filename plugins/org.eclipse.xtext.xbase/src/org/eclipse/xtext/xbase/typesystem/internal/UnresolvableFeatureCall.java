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

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class UnresolvableFeatureCall extends AbstractUnresolvableReferenceWithNode implements IFeatureLinkingCandidate {

	public UnresolvableFeatureCall(XAbstractFeatureCall featureCall, INode node, String text, ExpressionTypeComputationState state) {
		super(featureCall, node, text, state);
	}

	public XAbstractFeatureCall getFeatureCall() {
		return (XAbstractFeatureCall) getExpression();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected List<XExpression> getArguments() {
		return getFeatureCall().getExplicitArguments();
	}

	public boolean isStatic() {
		return false;
	}

	public boolean isExtension() {
		return false;
	}
	
	public boolean isTypeLiteral() {
		return false;
	}
	
	public EReference getReference() {
		return XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
	}

	public List<LightweightTypeReference> getTypeArguments() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		List<JvmTypeReference> typeArguments = featureCall.getTypeArguments();
		if (typeArguments.isEmpty())
			return Collections.emptyList();
		List<LightweightTypeReference> result = Lists.newArrayList();
		for(JvmTypeReference typeArgument: typeArguments) {
			result.add(getConverter().toLightweightReference(typeArgument));
		}
		return result;
	}
	
	@Override
	protected Resource.Diagnostic createDiagnostic(DiagnosticMessage message) {
		String messageString = message.getMessage();
		String issueCode = message.getIssueCode();
		if (messageString.startsWith("Couldn't resolve reference to JvmIdentifiableElement")) {
			if (getFeatureCall().isExplicitOperationCallOrBuilderSyntax()) {
				List<XExpression> arguments = new FeatureLinkHelper().getSyntacticArguments(getFeatureCall());
				String argumentTypes = "";
				if (!arguments.isEmpty()) {
					IResolvedTypes resolvedTypes = getResolvedTypes();
					StringBuilder argumentTypesBuilder = new StringBuilder();
					for(XExpression argument: arguments) {
						if (argumentTypesBuilder.length() != 0) {
							argumentTypesBuilder.append(", ");
						}
						LightweightTypeReference argumentType = resolvedTypes.getActualType(argument);
						if (argumentType == null || argumentType.isAny()) {
							argumentTypesBuilder.append("Object");
						} else {
							argumentTypesBuilder.append(argumentType.getHumanReadableName());
						}
					}
					argumentTypes = argumentTypesBuilder.toString();
				}
				messageString = "The method " + getLinkText()  + "(" + argumentTypes + ") is undefined";
				issueCode = org.eclipse.xtext.diagnostics.Diagnostic.LINKING_DIAGNOSTIC;
			}
		}
		Diagnostic diagnostic = new XtextLinkingDiagnostic(
				getNode(), 
				messageString,
				issueCode,
				message.getIssueData());
		return diagnostic;
	}

	
	@Nullable
	protected XExpression getSyntacticReceiver() {
		return new FeatureLinkHelper().getSyntacticReceiver(getFeatureCall());
	}
}
