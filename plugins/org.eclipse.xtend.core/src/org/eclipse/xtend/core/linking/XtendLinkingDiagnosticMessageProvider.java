/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.linking;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.impl.FeatureCallToJavaMapping;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {

	@Inject
	private FeatureCallToJavaMapping featureCallToJavaMapping;

	@Inject
	private ITypeProvider typeProvider;

	public static String FEATURECALL_LINKING_DIAGNOSTIC = "org.eclipse.xtend.core.linking.XtendLinkingDiagnosticMessageProvider.Linking";

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
			XtendClass xtendClazz = EcoreUtil2.getContainerOfType(featureCall, XtendClass.class);
			if(xtendClazz != null){
				String clazzName = xtendClazz.getSimpleName();
				EList<XExpression> explicitArguments = featureCall.getExplicitArguments();
				String argumentString = computeArguments(explicitArguments);
				if(argumentString == null)
					return null;
				String callText = linkText + argumentString;
				String firstPartOfMessage = "The method ";
				String fieldType = "Object";
				if(explicitArguments.size() == 0){
					firstPartOfMessage += "or field ";
					JvmTypeReference expectedType = typeProvider.getExpectedType(featureCall);
					if(expectedType != null && expectedType.getType() != null)
						fieldType = expectedType.getSimpleName();
				}
				return new DiagnosticMessage(firstPartOfMessage + callText + " is undefined for the type " + clazzName, Severity.ERROR,FEATURECALL_LINKING_DIAGNOSTIC, linkText, callText, fieldType);
			}
		}
		EClass referenceType = context.getReference().getEReferenceType();
		String msg = "Couldn't resolve reference to " + referenceType.getName() + " '" + linkText + "'.";
		return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
	}

	private String computeArguments(EList<XExpression> arguments){
		StringBuilder builder = new StringBuilder();
		Iterator<XExpression> iterator = arguments.iterator();
		if(arguments.size() > 0){
			builder.append("(");
			while(iterator.hasNext()){
				XExpression expr = iterator.next();
				JvmTypeReference type = typeProvider.getType(expr);
				if(type == null)
					return null;
				builder.append(type.getSimpleName());
				if(iterator.hasNext())
					builder.append(", ");
			}
			builder.append(")");
		}
		return builder.toString();
	}


}
