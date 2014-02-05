/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Iterables.*;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * UI presentable string representation of Xbase elements.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class UIStrings {

	@Inject
	private LazyURIEncoder lazyURIEncoder;
	
	@Inject
	private IBatchTypeResolver typeResolver;
	
	public String signature(JvmExecutable executable) {
		StringBuilder b = new StringBuilder(executable.getSimpleName());
		b.append(parameters(executable));
		if(executable instanceof JvmOperation) 
			b.append(" : ").append(((JvmOperation) executable).getReturnType().getSimpleName());
		return b.toString();
	}
	
	public String parameters(JvmIdentifiableElement element) {
		if (element instanceof JvmExecutable) {
			return "(" + parameterTypes(((JvmExecutable)element).getParameters(), ((JvmExecutable)element).isVarArgs()) + ")";
		}
		return "";
	}

	public String arguments(XAbstractFeatureCall featureCall) {
		List<XExpression> arguments = featureCall.getActualArguments();
		return "(" + expressionTypes(arguments) + ")";
	}

	public String arguments(XConstructorCall constructorCall) {
		return "(" + expressionTypes(constructorCall.getArguments()) + ")";
	}

	public String typeParameters(Iterable<? extends JvmTypeParameter> typeParams) {
		if (!isEmpty(typeParams)) {
			return "<" + toString(typeParams) + ">";
		}
		return "";
	}
	
	public String typeParameters(JvmIdentifiableElement element) {
		if (element instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) element).getTypeParameters();
			return typeParameters(typeParameters);
		}
		return "";
	}
	
	public String typeArguments(XAbstractFeatureCall featureCall) {
		return "<" + referencesToString(featureCall.getTypeArguments()) + ">";
	}

	public String typeArguments(XConstructorCall constructorCall) {
		return "<" + referencesToString(constructorCall.getTypeArguments()) + ">";
	}

	protected String toString(Iterable<? extends JvmIdentifiableElement> elements) {
		StringBuilder buffer = new StringBuilder();
		boolean needsSeparator = false;
		for (JvmIdentifiableElement type : elements) {
			if (needsSeparator)
				buffer.append(", ");
			needsSeparator = true;
			if(type != null) {
				buffer.append(type.getSimpleName());
			} else 
				buffer.append("[null]");
		}
		return buffer.toString();
	}
	
	protected String referencesToString(Iterable<? extends JvmTypeReference> elements) {
		StringBuilder buffer = new StringBuilder();
		boolean needsSeparator = false;
		for (JvmTypeReference typeRef : elements) {
			if (needsSeparator)
				buffer.append(", ");
			needsSeparator = true;
			buffer.append(referenceToString(typeRef, "[null]"));
		}
		return buffer.toString();
	}
	
	/**
	 * @since 2.4
	 */
	public String referenceToString(JvmTypeReference typeRef, String defaultLabel) {
		if(typeRef != null) {
			if (typeRef instanceof JvmAnyTypeReference)
				return "Object";
			else {
				JvmType type = typeRef.getType();
				if (type != null && type.eIsProxy() && typeRef.eResource() != null) {
					URI proxyURI = EcoreUtil.getURI(type);
					String fragment = proxyURI.fragment();
					if (lazyURIEncoder.isCrossLinkFragment(typeRef.eResource(), fragment)) {
						Triple<EObject, EReference, INode> decoded = lazyURIEncoder.decode(typeRef.eResource(), fragment);
						INode node = decoded.getThird();
						if (node != null) {
							String text = node.getRootNode().getText();
							ITextRegion textRegion = node.getTextRegion();
							String result = text.substring(textRegion.getOffset(), textRegion.getLength() + textRegion.getOffset());
							return result;
						} else {
							return defaultLabel;
						}
					}
				} else {
					return typeRef.getSimpleName();
				}
			}
		}
		return defaultLabel;
	}

	protected String expressionTypes(Iterable<XExpression> expressions) {
		Iterator<XExpression> iterator = expressions.iterator();
		if (iterator.hasNext()) {
			XExpression expression = iterator.next();
			IResolvedTypes resolvedTypes = typeResolver.resolveTypes(expression);
			LightweightTypeReference reference = resolvedTypes.getActualType(expression);
			if (!iterator.hasNext()) {
				return referenceToString(reference);
			}
			StringBuilder result = new StringBuilder(reference.toString());
			while(iterator.hasNext()) {
				reference = resolvedTypes.getActualType(iterator.next());
				result.append(", ");
				result.append(referenceToString(reference));
			}
			return result.toString();
		} else {
			return "";
		}
	}

	protected String referenceToString(LightweightTypeReference reference) {
		if (reference == null) {
			return "[null]";
		}
		if (reference.isAny()) {
			return "Object";
		}
		return reference.getSimpleName();
	}

	protected String parameterTypes(Iterable<JvmFormalParameter> parameters, @SuppressWarnings("unused") boolean isVarArgs) {
		return referencesToString(transform(parameters, new Function<JvmFormalParameter, JvmTypeReference>() {
			public JvmTypeReference apply(JvmFormalParameter from) {
				return from.getParameterType();
			}
		}));
	}
	
}
