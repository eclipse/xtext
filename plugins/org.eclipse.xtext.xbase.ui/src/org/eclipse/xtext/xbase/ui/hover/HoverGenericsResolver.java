/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementLinks;
import org.eclipse.jdt.ui.JavaElementLabels;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.ui.hover.FeatureCallRequest.IFeatureCallRequestProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class HoverGenericsResolver {

	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;
	@Inject
	private IFeatureCallRequestProvider featureCallRequestProvider;
	@Inject
	private ITypeProvider typeProvider;

	public String resolveSignatureInHtml(XExpression call, IJavaElement javaElement, String html) {
		// Compute the signature to replace only here
		String signature = getJavaSignature(javaElement);
		String resolvedSignature = replaceGenerics(call, signature);
		return html.replace(signature, resolvedSignature);
	}

	public String replaceGenerics(XExpression call, String input) {
		String output = input;
		if (call != null) {
			JvmExecutable executable = null;
			if (call instanceof XAbstractFeatureCall) {
				XAbstractFeatureCall featureCall = (XAbstractFeatureCall) call;
				if (featureCall.getFeature() instanceof JvmExecutable)
					executable = (JvmExecutable) featureCall.getFeature();
			}
			if (call instanceof XConstructorCall) {
				XConstructorCall constructorCall = (XConstructorCall) call;
				executable = constructorCall.getConstructor();
			}
			if (executable != null)
				for (Pair<JvmTypeParameter, JvmTypeReference> pair : getBoundTypePairs(call, executable)) {
					JvmTypeParameter unresolvedType = pair.getFirst();
					JvmTypeReference resolvedType = pair.getSecond();
					if (unresolvedType != null && resolvedType != null) {
						String toBeReplaced = unresolvedType.getSimpleName();
						String with = resolvedType.getSimpleName();
						output = output.replaceAll("\\b" + Pattern.quote(toBeReplaced) + "\\b", with);
					}
				}

		}
		return output;
	}

	protected List<Pair<JvmTypeParameter, JvmTypeReference>> getBoundTypePairs(final XExpression call,
			final JvmExecutable executable) {
		ITypeArgumentContext typeArgumentContext = null;
		if (call instanceof XAbstractFeatureCall) {
			typeArgumentContext = typeArgumentContextProvider.getTypeArgumentContext(featureCallRequestProvider
					.get((XAbstractFeatureCall) call));
		} else if (call instanceof XConstructorCall) {
			XConstructorCall constructorCall = (XConstructorCall) call;
			typeArgumentContext = typeProvider
					.getTypeArgumentContext(constructorCall, constructorCall.getConstructor());
		}
		List<Pair<JvmTypeParameter, JvmTypeReference>> pairs = Lists.newArrayList();
		if (typeArgumentContext != null) {

			for (JvmTypeParameter jvmTypeParameter : executable.getTypeParameters()) {
				pairs.add(Tuples.create(jvmTypeParameter, typeArgumentContext.getBoundArgument(jvmTypeParameter)));
			}
			JvmTypeParameterDeclarator nearestDeclarator = EcoreUtil2.getContainerOfType(executable.eContainer(),
					JvmTypeParameterDeclarator.class);
			if (nearestDeclarator != null)
				for (JvmTypeParameter jvmTypeParameter : nearestDeclarator.getTypeParameters()) {
					pairs.add(Tuples.create(jvmTypeParameter, typeArgumentContext.getBoundArgument(jvmTypeParameter)));
				}
		}
		return pairs;
	}

	public String getJavaSignature(IJavaElement javaElement) {
		return JavaElementLinks.getElementLabel(javaElement, getHeaderFlags(javaElement));
	}

	// Copied from org.eclipse.jdt.internal.ui.text.java.hover.JavadocHover.getHeaderFlags(IJavaElement) due to visibility problems
	private static final long LABEL_FLAGS = JavaElementLabels.ALL_FULLY_QUALIFIED | JavaElementLabels.M_PRE_RETURNTYPE
			| JavaElementLabels.M_PARAMETER_TYPES | JavaElementLabels.M_PARAMETER_NAMES
			| JavaElementLabels.M_EXCEPTIONS | JavaElementLabels.F_PRE_TYPE_SIGNATURE
			| JavaElementLabels.M_PRE_TYPE_PARAMETERS | JavaElementLabels.T_TYPE_PARAMETERS
			| JavaElementLabels.USE_RESOLVED;
	private static final long LOCAL_VARIABLE_FLAGS = LABEL_FLAGS & ~JavaElementLabels.F_FULLY_QUALIFIED
			| JavaElementLabels.F_POST_QUALIFIED;
	private static final long TYPE_PARAMETER_FLAGS = LABEL_FLAGS | JavaElementLabels.TP_POST_QUALIFIED;

	private static long getHeaderFlags(IJavaElement element) {
		switch (element.getElementType()) {
			case IJavaElement.LOCAL_VARIABLE:
				return LOCAL_VARIABLE_FLAGS;
			case IJavaElement.TYPE_PARAMETER:
				return TYPE_PARAMETER_FLAGS;
			default:
				return LABEL_FLAGS;
		}
	}
}
