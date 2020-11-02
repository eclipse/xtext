/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.annotations.validation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.internal.FeatureLinkHelper;
import org.eclipse.xtext.xbase.typesystem.internal.TypeAwareLinkingDiagnosticContext;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.util.FeatureCallAsTypeLiteralHelper;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class UnresolvedFeatureCallTypeAwareMessageProvider extends LinkingDiagnosticMessageProvider {
	/**
	 * A user data entry that indicates a broken feature link which could also
	 * be a type literal, e.g. 'String::CASE_INSENSITIVE'.
	 */
	public static final String TYPE_LITERAL = "key:TypeLiteral";

	public static final String FEATURE_CALL = "key:FeatureCall";

	@Inject
	private FeatureCallAsTypeLiteralHelper typeLiteralHelper;

	@Inject
	@Extension
	private FeatureLinkHelper featureLinkHelper;

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(
			ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context) {
		String linkText = null;
		try {
			linkText = context.getLinkText();
		} catch (IllegalNodeException e) {
			linkText = e.getNode().getText();
		}
		if (linkText == null) {
			return null;
		}
		EObject contextObject = context.getContext();
		if (isStaticMemberCallTarget(contextObject)) {
			return new DiagnosticMessage(linkText + " cannot be resolved to a type.", Severity.ERROR,
					Diagnostic.LINKING_DIAGNOSTIC, UnresolvedFeatureCallTypeAwareMessageProvider.TYPE_LITERAL);
		}
		if (contextObject instanceof XAbstractFeatureCall) {
			if (!((XAbstractFeatureCall) contextObject).isOperation()) {
				return handleUnresolvedFeatureCall(context, ((XAbstractFeatureCall) contextObject), linkText);
			}
		}
		EClass referenceType = context.getReference().getEReferenceType();
		String msg = linkText + " cannot be resolved"+ getTypeName(referenceType, context.getReference()) + ".";
		return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC, linkText);
	}

	private DiagnosticMessage handleUnresolvedFeatureCall(
			ILinkingDiagnosticContext context,
			XAbstractFeatureCall featureCall, String linkText) {
		LightweightTypeReference receiverType = null;
		String args = "";
		if (context instanceof TypeAwareLinkingDiagnosticContext) {
			IResolvedTypes types = ((TypeAwareLinkingDiagnosticContext) context).getResolvedTypes();
			if (featureLinkHelper.getSyntacticReceiver(featureCall) != null) {
				receiverType = types.getActualType(featureLinkHelper.getSyntacticReceiver(featureCall));
			}
			args = IterableExtensions
					.join(
							Lists.transform(
									featureLinkHelper.getSyntacticArguments(featureCall), it -> types.getActualType(it)),
							", ", (LightweightTypeReference it) -> {
								if (it == null || it.isAny()) {
									return "Object";
								} else {
									return it.getHumanReadableName();
								}
							});
		}
		boolean orField = !featureCall.isExplicitOperationCallOrBuilderSyntax();
		String msg = "";
		if (orField) {
			msg = "The method or field " + linkText + " is undefined";
		} else {
			msg = "The method " + linkText + "("+ args + ") is undefined";
		}
		if (receiverType != null) {
			msg = msg+ " for the type " + receiverType.getHumanReadableName();
		}
		if (featureCall instanceof XFeatureCall && linkText.length() > 0
				&& Character.isUpperCase(linkText.charAt(0))
				&& typeLiteralHelper.isPotentialTypeLiteral(featureCall, null)) {
			return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC, linkText,
					UnresolvedFeatureCallTypeAwareMessageProvider.TYPE_LITERAL);
		}
		return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC, linkText,
				UnresolvedFeatureCallTypeAwareMessageProvider.FEATURE_CALL);
	}

	protected boolean isStaticMemberCallTarget(EObject contextObject) {
		boolean candidate = contextObject instanceof XFeatureCall && contextObject
				.eContainingFeature() == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET;
		if (candidate) {
			XMemberFeatureCall memberFeatureCall = (XMemberFeatureCall) contextObject.eContainer();
			if (memberFeatureCall.isExplicitStatic()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a part of the message that describes the nature of the requested object, including a leading space.
	 * The result is either empty or of the shape {@code " to <article> <type>"}.
	 */
	protected String getTypeName(EClass c, EStructuralFeature referingFeature) {
		if (referingFeature == XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE) {
			return " to an annotation type";
		}
		if (c == TypesPackage.Literals.JVM_ENUMERATION_TYPE) {
			return " to an enum type";
		}
		if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_TYPE, c)) {
			return " to a type";
		}
		if (c == TypesPackage.Literals.JVM_OPERATION) {
			return " to an operation";
		}
		return "";
	}
}
