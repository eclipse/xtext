/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Iterables.*;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typing.IXExpressionTypeProvider;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * UI presentable string representation of Xbase elements.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class UIStrings {

	@Inject
	private IXExpressionTypeProvider typeProvider;

	public String parameters(JvmIdentifiableElement element) {
		if (element instanceof JvmExecutable) {
			return "(" + parameterTypes(((JvmExecutable)element).getParameters()) + ")";
		}
		return "";
	}

	public String arguments(XAbstractFeatureCall featureCall) {
		return "(" + expressionTypes(featureCall.getActualArguments()) + ")";
	}

	public String arguments(XConstructorCall constructorCall) {
		return "(" + expressionTypes(constructorCall.getArguments()) + ")";
	}

	public String typeParameters(JvmIdentifiableElement element) {
		if (element instanceof JvmTypeParameterDeclarator) {
			return "<" + toString(((JvmTypeParameterDeclarator) element).getTypeParameters()) + ">";
		}
		return "";
	}
	
	public String typeArguments(XAbstractFeatureCall featureCall) {
		return "<" + toString(featureCall.getTypeArguments()) + ">";
	}

	public String typeArguments(XConstructorCall constructorCall) {
		return "<" + toString(constructorCall.getTypeArguments()) + ">";
	}

	protected String toString(Iterable<? extends JvmIdentifiableElement> elements) {
		StringBuilder buffer = new StringBuilder();
		boolean needsSeparator = false;
		for (JvmIdentifiableElement typeRef : elements) {
			if (needsSeparator)
				buffer.append(", ");
			needsSeparator = true;
			if(typeRef != null)
				buffer.append(typeRef.getCanonicalName());
			else 
				buffer.append("[null]");
		}
		return buffer.toString();
	}

	protected String expressionTypes(Iterable<XExpression> expressions) {
		return toString(transform(expressions, new Function<XExpression, JvmIdentifiableElement>() {
			public JvmTypeReference apply(XExpression from) {
				return typeProvider.getConvertedType(from);
			}
		}));
	}

	protected String parameterTypes(Iterable<JvmFormalParameter> parameters) {
		return toString(transform(parameters, new Function<JvmFormalParameter, JvmIdentifiableElement>() {
			public JvmTypeReference apply(JvmFormalParameter from) {
				return from.getParameterType();
			}
		}));
	}
	
}
