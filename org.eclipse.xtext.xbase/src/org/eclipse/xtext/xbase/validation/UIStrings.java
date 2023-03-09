/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.inject.Inject;

/**
 * UI presentable string representation of Xbase elements.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Stéphane Galland 
 */
public class UIStrings {

	@Inject
	private IBatchTypeResolver typeResolver;
	
	@Inject
	private CommonTypeComputationServices services;

	public String signature(JvmExecutable executable) {
		StringBuilder b = new StringBuilder(executable.getSimpleName());
		b.append(parameters(executable));
		if (executable instanceof JvmOperation)
			b.append(" : ").append(((JvmOperation) executable).getReturnType().getSimpleName());
		return b.toString();
	}

	public String parameters(JvmIdentifiableElement element) {
		if (element instanceof JvmExecutable) {
			return "(" + parameterTypes(((JvmExecutable) element).getParameters(), ((JvmExecutable) element).isVarArgs()) + ")";
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

	public String toString(Iterable<? extends JvmTypeParameter> elements) {
		StringBuilder buffer = new StringBuilder();
		boolean needsSeparator = false;
		for (JvmTypeParameter type : elements) {
			if (needsSeparator)
				buffer.append(", ");
			needsSeparator = true;
			if (type != null) {
				buffer.append(type.getSimpleName());
				List<String> upper = newArrayList();
				String lower = null;
				for (JvmTypeConstraint constr : type.getConstraints()) {
					String simpleName = constr.getTypeReference().getSimpleName();
					if (constr instanceof JvmUpperBound) {
						upper.add(simpleName);
					} else {
						lower = simpleName;
					}
				}
				if(!upper.isEmpty()) {
					buffer.append(" extends ");
					buffer.append(Strings.concat(" & ", upper));
				}
				if(lower!=null) {
					buffer.append(" super ");
					buffer.append(lower);
				}
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
		if (typeRef == null)
			return defaultLabel;
		
		if (typeRef.eResource() == null) {
			if (typeRef instanceof JvmAnyTypeReference) {
				return "Object";
			}
			return typeRef.getSimpleName();
		}
		
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, typeRef);
		LightweightTypeReference reference = owner.toLightweightTypeReference(typeRef);
		return referenceToString(reference);
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
			while (iterator.hasNext()) {
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
		return reference.getHumanReadableName();
	}
	
	protected String parametersToString(Iterable<? extends JvmFormalParameter> elements, boolean isVarArgs, boolean includeName) {
		StringBuilder result = new StringBuilder();
		boolean needsSeparator = false;
		Iterator<? extends JvmFormalParameter> iterator = elements.iterator();
		while (iterator.hasNext()) {
			JvmFormalParameter parameter = iterator.next();
			if (needsSeparator)
				result.append(", ");
			needsSeparator = true;
			JvmTypeReference typeRef = parameter.getParameterType();
			if (isVarArgs && !iterator.hasNext() && typeRef instanceof JvmGenericArrayTypeReference) {
				typeRef = ((JvmGenericArrayTypeReference) typeRef).getComponentType();
				result.append(referenceToString(typeRef, "[null]"));
				result.append("...");
			} else {
				result.append(referenceToString(typeRef, "[null]"));
			}
			if (includeName) {
				result.append(" " + parameter.getName());
			}
		}
		return result.toString();
	}

	protected String parameterTypes(Iterable<JvmFormalParameter> parameters, boolean isVarArgs) {
		return parametersToString(parameters, isVarArgs, false);
	}

}
