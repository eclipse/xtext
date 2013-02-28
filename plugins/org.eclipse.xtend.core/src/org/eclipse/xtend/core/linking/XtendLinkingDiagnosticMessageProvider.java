/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.linking;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		if (isPropertyOfUnresolvedAnnotation(context))
			return null;
		String linkText = "";
		try {
			linkText = context.getLinkText();
		} catch (IllegalNodeException e){
			linkText = e.getNode().getText();
		}
		EObject contextObject = context.getContext();
		if(context.getReference() != XbasePackage.Literals.XFEATURE_CALL__DECLARING_TYPE && contextObject instanceof XAbstractFeatureCall && !(contextObject instanceof XBinaryOperation || contextObject instanceof XUnaryOperation)){
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall)contextObject;
			XtendTypeDeclaration xtendType = EcoreUtil2.getContainerOfType(featureCall, XtendTypeDeclaration.class);
			if(xtendType != null){
				String clazzName = xtendType.getName();
				@SuppressWarnings("deprecation")
				List<XExpression> explicitArguments = featureCall.getExplicitArguments();
				String firstPartOfMessage = "The method ";
				if(explicitArguments.size() == 0 || featureCall instanceof XAssignment)
					firstPartOfMessage += "or field ";
				return new DiagnosticMessage(firstPartOfMessage + linkText + " is undefined for the type " + clazzName, Severity.ERROR, IssueCodes.FEATURECALL_LINKING_DIAGNOSTIC, linkText);
			}
		}
		EClass referenceType = context.getReference().getEReferenceType();
		String msg = String.format("%s cannot be resolved%s.", linkText, getTypeName(referenceType));
		return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}
	
	protected boolean isPropertyOfUnresolvedAnnotation(ILinkingDiagnosticContext context) {
		EObject object = context.getContext();
		if (object instanceof XAnnotationElementValuePair && context.getReference() == XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT) {
			XAnnotation annotation = EcoreUtil2.getContainerOfType(object, XAnnotation.class);
			if (annotation != null) {
				JvmAnnotationType annotationType = annotation.getAnnotationType();
				if (annotationType == null || annotationType.eIsProxy())
					return true;
			}
		}
		return false;
	}

	@Nullable
	protected String getTypeName(EClass c) {
		if (c == TypesPackage.Literals.JVM_ENUMERATION_TYPE)
			return " to an enum type";
		if (c == TypesPackage.Literals.JVM_ANNOTATION_TYPE)
			return " to an annotation type";
		if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_TYPE, c))
			return " to a type";
		if (c == TypesPackage.Literals.JVM_OPERATION) {
			return " to an operation";
		}
		return "";
	}

}
