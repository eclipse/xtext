/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import java.util.List;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.util.XtypeReferenceVisitorWithParameter;

import com.google.inject.Singleton;

/**
 * Allows to append type references to an existing {@link StringBuilder}. If the type
 * reference contains an unresolved proxy, {@code null} is returned.
 * 
 * Clients should use {@link #visit(JvmTypeReference, StringBuilder)}, {@link #appendTypeSignature(JvmType, StringBuilder)},
 * or {@link #appendTypeArguments(JvmParameterizedTypeReference, StringBuilder)}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class ProxyAwareUIStrings implements XtypeReferenceVisitorWithParameter<StringBuilder, StringBuilder> {

	@Override
	public StringBuilder visit(JvmTypeReference reference, StringBuilder param) {
		if (reference == null)
			return null;
		return reference.accept(this, param);
	}
	
	/**
	 * Returns the signature of the given type. If the type declares type parameters, the type
	 * parameters are included but their bounds are omitted. That is, the type {@code X<T extends CharSequence>}
	 * will be returned as {@code X<T>}
	 *
	 */
	public StringBuilder appendTypeSignature(JvmType type, StringBuilder result) {
		result.append(type.getSimpleName());
		if(type instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) type).getTypeParameters();
			if (!typeParameters.isEmpty()) {
				result.append("<");
				for(int i = 0, size = typeParameters.size(); i < size; i++) {
					if (i != 0) {
						result.append(", ");
					}
					result.append(typeParameters.get(i).getName());
				}
				result.append(">");
			}
		}
		return result;
	}
	
	/**
	 * Returns the type arguments including the surrounding angular brackets.
	 * If the typeRef is invalid in the sense that it contains unresolved proxies,
	 * null is returned.
	 */
	/* @Nullable */
	public StringBuilder appendTypeArguments(JvmParameterizedTypeReference typeRef, StringBuilder result) {
		List<JvmTypeReference> typeArguments = typeRef.getArguments();
		if (typeArguments.isEmpty()) {
			throw new IllegalArgumentException("typeRef is not parameterized");
		}
		result.append("<");
		for(int i = 0, size = typeArguments.size(); i < size; i++) {
			if (i != 0) {
				result.append(", ");
			}
			result = visit(typeArguments.get(i), result);
			if (result == null)
				return null;
		}
		result.append(">");
		return result;
	}
	
	@Override
	public StringBuilder doVisitAnyTypeReference(JvmAnyTypeReference reference, StringBuilder param) {
		return doVisitTypeReference(reference, param);
	}
	
	@Override
	public StringBuilder doVisitDelegateTypeReference(JvmDelegateTypeReference reference, StringBuilder param) {
		return visit(reference.getDelegate(), param);
	}
	
	@Override
	public StringBuilder doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, StringBuilder param) {
		param = visit(reference.getComponentType(), param);
		if (param != null) {
			param.append("[]");
		}
		return param;
	}
	
	@Override
	public StringBuilder doVisitCompoundTypeReference(JvmCompoundTypeReference reference, StringBuilder param) {
		throw new IllegalStateException("Should never be called");
	}
	
	protected StringBuilder doVisitCompoundTypeReference(JvmCompoundTypeReference reference, StringBuilder param, String delim) {
		List<JvmTypeReference> references = reference.getReferences();
		for(int i = 0; i < references.size(); i++) {
			if (i != 0) {
				param.append(delim);
			}
			param = visit(references.get(i), param);
			if (param == null)
				return null;
		}
		return param;
	}
	
	@Override
	public StringBuilder doVisitMultiTypeReference(JvmMultiTypeReference reference, StringBuilder param) {
		return doVisitCompoundTypeReference(reference, param, " & ");
	}
	
	@Override
	public StringBuilder doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, StringBuilder param) {
		JvmType type = reference.getType();
		if (type == null || type.eIsProxy()) {
			return null;
		}
		param.append(type.getSimpleName());
		List<JvmTypeReference> typeArguments = reference.getArguments();
		if (typeArguments.isEmpty())
			return param;
		param.append("<");
		for(int i = 0, size = typeArguments.size(); i < size; i++) {
			if (i != 0) {
				param.append(", ");
			}
			param = visit(typeArguments.get(i), param);
			if (param == null) {
				return null;
			}
		}
		param.append(">");
		return param;
	}
	
	@Override
	public StringBuilder doVisitInnerTypeReference(JvmInnerTypeReference reference, StringBuilder param) {
		JvmType type = reference.getType();
		if (type == null || type.eIsProxy()) {
			return null;
		}
		param = reference.getOuter().accept(this, param);
		if (param == null)
			return null;
		param.append(".");
		return doVisitParameterizedTypeReference(reference, param);
	}
	
	@Override
	public StringBuilder doVisitSpecializedTypeReference(JvmSpecializedTypeReference reference, StringBuilder param) {
		return visit(reference.getEquivalent(), param);
	}
	
	@Override
	public StringBuilder doVisitSynonymTypeReference(JvmSynonymTypeReference reference, StringBuilder param) {
		return doVisitCompoundTypeReference(reference, param, " | ");
	}
	
	@Override
	public StringBuilder doVisitUnknownTypeReference(JvmUnknownTypeReference reference, StringBuilder param) {
		return doVisitTypeReference(reference, param);
	}
	
	@Override
	public StringBuilder doVisitWildcardTypeReference(JvmWildcardTypeReference reference, StringBuilder param) {
		param.append("? ");
		List<JvmTypeConstraint> constraints = reference.getConstraints();
		int size = constraints.size();
		for(int i = 0; i < size; i++) {
			JvmTypeConstraint constraint = constraints.get(i);
			if (constraint.eClass() == TypesPackage.Literals.JVM_LOWER_BOUND) {
				param.append("super ");
				return visit(constraint.getTypeReference(), param);
			}
		}
		boolean first = true;
		for(int i = 0; i < size; i++) {
			JvmTypeConstraint constraint = constraints.get(i);
			if (constraint.eClass() == TypesPackage.Literals.JVM_UPPER_BOUND) {
				if (first) {
					param.append("extends ");
				} else {
					param.append(" & ");
				}
				param = visit(constraint.getTypeReference(), param);
				if (param == null)
					return null;
			}
		}
		return param;
	}
	
	@Override
	public StringBuilder doVisitComputedTypeReference(XComputedTypeReference reference, StringBuilder param) {
		return doVisitSpecializedTypeReference(reference, param);
	}
	
	@Override
	public StringBuilder doVisitFunctionTypeReference(XFunctionTypeRef reference, StringBuilder param) {
		param.append("(");
		List<JvmTypeReference> paramTypes = reference.getParamTypes();
		for(int i = 0, size = paramTypes.size(); i < size; i++) {
			if (i != 0) {
				param.append(", ");
			}
			param = visit(paramTypes.get(i), param);
			if (param == null)
				return null;
		}
		param.append(")=>");
		return visit(reference.getReturnType(), param);
	}
	
	@Override
	public StringBuilder doVisitTypeReference(JvmTypeReference reference, StringBuilder param) {
		param.append(reference.getSimpleName());
		return param;
	}
	
}
