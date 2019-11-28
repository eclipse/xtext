/** 
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.annotations.validation

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.diagnostics.DiagnosticMessage
import org.eclipse.xtext.linking.impl.IllegalNodeException
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage
import org.eclipse.xtext.xbase.typesystem.internal.FeatureLinkHelper
import org.eclipse.xtext.xbase.typesystem.internal.TypeAwareLinkingDiagnosticContext
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.util.FeatureCallAsTypeLiteralHelper

import static org.eclipse.xtext.diagnostics.Diagnostic.LINKING_DIAGNOSTIC
import static org.eclipse.xtext.diagnostics.Severity.ERROR
import static org.eclipse.xtext.xbase.XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET

/** 
 * @author Dennis Huebner - Initial contribution and API
 */
class UnresolvedFeatureCallTypeAwareMessageProvider extends LinkingDiagnosticMessageProvider {
	/** 
	 * A user data entry that indicates a broken feature link which could also be
	 * a type literal, e.g. 'String::CASE_INSENSITIVE'.
	 */
	public static final String TYPE_LITERAL = "key:TypeLiteral"

	public static final String FEATURE_CALL = "key:FeatureCall"

	@Inject FeatureCallAsTypeLiteralHelper typeLiteralHelper
	@Inject extension FeatureLinkHelper

	override DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		var linkText = try {
			context.getLinkText()
		} catch (IllegalNodeException e) {
			e.getNode().getText()
		}

		if(linkText === null) return null

		var contextObject = context.getContext()
		if (isStaticMemberCallTarget(contextObject)) {
			return new DiagnosticMessage('''«linkText» cannot be resolved to a type.''', ERROR, LINKING_DIAGNOSTIC,
				TYPE_LITERAL)
		}
		if (contextObject instanceof XAbstractFeatureCall) {
			if (!contextObject.isOperation()) {
				return handleUnresolvedFeatureCall(context, contextObject, linkText)
			}
		}
		var referenceType = context.reference.getEReferenceType
		val msg = '''«linkText» cannot be resolved«referenceType.getTypeName(context.reference)».'''
		return new DiagnosticMessage(msg, ERROR, LINKING_DIAGNOSTIC, linkText)
	}

	def private DiagnosticMessage handleUnresolvedFeatureCall(ILinkingDiagnosticContext context,
		XAbstractFeatureCall featureCall, String linkText) {
		var LightweightTypeReference receiverType = null
		var args = ""
		if (context instanceof TypeAwareLinkingDiagnosticContext) {
			val types = context.resolvedTypes
			if (featureCall.syntacticReceiver !== null) {
				receiverType = types.getActualType(featureCall.syntacticReceiver)
			}
			args = featureCall.syntacticArguments.map[types.getActualType(it)].join(", ", [
				if(it === null || any) "Object" else humanReadableName
			])
		}

		val orField = !featureCall.isExplicitOperationCallOrBuilderSyntax()

		var msg = '''The method «IF (orField)»or field «linkText»«ELSE»«linkText»(«args»)«ENDIF» is undefined'''
		if (receiverType !== null) {
			msg += ''' for the type «receiverType.humanReadableName»'''
		}
		if (featureCall instanceof XFeatureCall && linkText.length() > 0 && Character.isUpperCase(linkText.charAt(0)) &&
			typeLiteralHelper.isPotentialTypeLiteral(featureCall, null)) {
			return new DiagnosticMessage(msg, ERROR, LINKING_DIAGNOSTIC, linkText, TYPE_LITERAL)
		}
		return new DiagnosticMessage(msg, ERROR, LINKING_DIAGNOSTIC, linkText, FEATURE_CALL)
	}

	def protected boolean isStaticMemberCallTarget(EObject contextObject) {
		var boolean candidate = contextObject instanceof XFeatureCall && contextObject.eContainingFeature() ===
			XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET
		if (candidate) {
			var memberFeatureCall = contextObject.eContainer() as XMemberFeatureCall
			if (memberFeatureCall.isExplicitStatic()) {
				return true
			}
		}
		return false
	}

	/* @Nullable */
	def protected String getTypeName(EClass c, EStructuralFeature referingFeature) {
		if(referingFeature === XAnnotationsPackage.Literals.
			XANNOTATION__ANNOTATION_TYPE) return " to an annotation type"
		if(c === TypesPackage.Literals.JVM_ENUMERATION_TYPE) return " to an enum type"
		if(EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_TYPE, c)) return " to a type"
		if (c === TypesPackage.Literals.JVM_OPERATION) {
			return " to an operation"
		}
		return ""
	}

}
							
