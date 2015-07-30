/** 
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.linking

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.diagnostics.DiagnosticMessage
import org.eclipse.xtext.linking.impl.IllegalNodeException
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XAssignment
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.annotations.validation.UnresolvedAnnotationTypeAwareMessageProducer
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage
import org.eclipse.xtext.xbase.typesystem.internal.TypeAwareLinkingDiagnosticContext
import org.eclipse.xtext.xbase.util.FeatureCallAsTypeLiteralHelper

import static org.eclipse.xtend.core.validation.IssueCodes.FEATURECALL_LINKING_DIAGNOSTIC
import static org.eclipse.xtext.diagnostics.Diagnostic.LINKING_DIAGNOSTIC
import static org.eclipse.xtext.diagnostics.Severity.ERROR
import static org.eclipse.xtext.xbase.XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET

/** 
 * @author Holger Schill - Initial contribution and API
 */
class XtendLinkingDiagnosticMessageProvider extends UnresolvedAnnotationTypeAwareMessageProducer {
	/** 
	 * A user data entry that indicates a broken feature link which could also be
	 * a type literal, e.g. 'String::CASE_INSENSITIVE'.
	 */
	public static final String TYPE_LITERAL = "key:TypeLiteral"
	@Inject FeatureCallAsTypeLiteralHelper typeLiteralHelper

	override DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		if(isPropertyOfUnresolvedAnnotation(context)) return null
		var linkText = ""
		try {
			linkText = context.getLinkText()
		} catch (IllegalNodeException e) {
			linkText = e.getNode().getText()
		}
		if (linkText === null) {
			return null
		}
		var contextObject = context.getContext()
		if (isStaticMemberCallTarget(contextObject)) {
			return new DiagnosticMessage('''«linkText» cannot be resolved to a type.''', ERROR, LINKING_DIAGNOSTIC,
				TYPE_LITERAL)
		}
		if (contextObject instanceof XAbstractFeatureCall) {
			if (!contextObject.isOperation()) {
				var xtendType = EcoreUtil2.getContainerOfType(contextObject, XtendTypeDeclaration)
				if (xtendType !== null) {
					return handleUnresolvedFeatureCall(context, contextObject, linkText, xtendType.name)
				}
			}
		}
		var referenceType = context.reference.EReferenceType
		val msg = '''«linkText» cannot be resolved«referenceType.getTypeName(context.reference)».'''
		return new DiagnosticMessage(msg, ERROR, LINKING_DIAGNOSTIC, linkText)
	}

	def private DiagnosticMessage handleUnresolvedFeatureCall(ILinkingDiagnosticContext context,
		XAbstractFeatureCall featureCall, String linkText, String xtendType) {
		var recieverType = xtendType
		var explicitArguments = featureCall.getExplicitArguments()
		val orField = (explicitArguments.size() === 0 || featureCall instanceof XAssignment)
		var args = ""
		if (context instanceof TypeAwareLinkingDiagnosticContext) {
			val types = context.getResolvedTypes()
			if (featureCall.getActualReceiver() !== null) {
				var type = types.getActualType(featureCall.getActualReceiver())
				if(type !== null) recieverType = type.getHumanReadableName()
			}
			val arguments = featureCall.getActualArguments().map[types.getActualType(it)].join(", ", [
				if(it != null) humanReadableName else "Object"
			])
			if (!arguments.empty) {
				args = '''(«arguments»)'''
			}
		}
		val msg = '''The method«if(orField) " or field"» «linkText+args» is undefined for the type «recieverType»'''
		if (featureCall instanceof XFeatureCall && linkText.length() > 0 && Character.isUpperCase(linkText.charAt(0)) &&
			typeLiteralHelper.isPotentialTypeLiteral(featureCall, null)) {
			return new DiagnosticMessage(msg, ERROR, FEATURECALL_LINKING_DIAGNOSTIC, linkText, TYPE_LITERAL)
		}
		return new DiagnosticMessage(msg, ERROR, FEATURECALL_LINKING_DIAGNOSTIC, linkText)
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
							