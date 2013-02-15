/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.linking;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.EcoreUtil2;
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

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		String linkText = "";
		try {
			linkText = context.getLinkText();
		} catch (IllegalNodeException e){
			linkText = e.getNode().getText();
		}
		EObject contextObject = context.getContext();
		if(contextObject instanceof XAbstractFeatureCall && !(contextObject instanceof XBinaryOperation || contextObject instanceof XUnaryOperation)){
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall)contextObject;
			XtendTypeDeclaration xtendType = EcoreUtil2.getContainerOfType(featureCall, XtendTypeDeclaration.class);
			if(xtendType != null){
				String clazzName = xtendType.getName();
				EList<XExpression> explicitArguments = featureCall.getExplicitArguments();
				String firstPartOfMessage = "The method ";
				if(explicitArguments.size() == 0 || featureCall instanceof XAssignment)
					firstPartOfMessage += "or field ";
				return new DiagnosticMessage(firstPartOfMessage + linkText + " is undefined for the type " + clazzName, Severity.ERROR, IssueCodes.FEATURECALL_LINKING_DIAGNOSTIC, linkText);
			}
		}
		EClass referenceType = context.getReference().getEReferenceType();
		String msg = "Couldn't resolve reference to " + referenceType.getName() + " '" + linkText + "'.";
		return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}

}
