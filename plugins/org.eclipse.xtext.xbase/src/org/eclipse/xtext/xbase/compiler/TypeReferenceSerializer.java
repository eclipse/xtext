/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeReferenceSerializer {
	
	@Inject
	private Primitives primitives;
	
	@Inject
	private TypeConformanceComputer typeConformanceComputer;
	
	@Inject 
	private ILogicalContainerProvider contextProvider;
	
	public boolean isLocalTypeParameter(EObject context, JvmTypeParameter parameter) {
		if (context == null)
			return false;
		if (context == parameter.getDeclarator()) 
			return true;
		JvmIdentifiableElement jvmElement = contextProvider.getLogicalContainer(context);
		if (jvmElement != null) {
			return isLocalTypeParameter(jvmElement, parameter);
		}
		return isLocalTypeParameter(context.eContainer(), parameter);
	}
	
	public void serialize(final JvmTypeReference type, EObject context, IAppendable appendable) {
		serialize(type, context, appendable, false, true);
	}
	public void serialize(final JvmTypeReference type, EObject context, IAppendable appendable, boolean withoutConstraints, boolean paramsToWildcard) {
		serialize(type, context, appendable, withoutConstraints, paramsToWildcard, false, true);
	}
	
	public void serialize(final JvmTypeReference type, EObject context, IAppendable appendable, boolean withoutConstraints, boolean paramsToWildcard, boolean paramsToObject, boolean allowPrimitives) {
		if (type instanceof JvmWildcardTypeReference) {
			JvmWildcardTypeReference wildcard = (JvmWildcardTypeReference) type;
			if (!withoutConstraints) {
				appendable.append("?");
			}
			if (!wildcard.getConstraints().isEmpty()) {
				for(JvmTypeConstraint constraint: wildcard.getConstraints()) {
					if (constraint instanceof JvmLowerBound) {
						if (!withoutConstraints)
							appendable.append(" super ");
						serialize(constraint.getTypeReference(), context, appendable, withoutConstraints, paramsToWildcard, paramsToObject, false);
						return;
					}
				}
				boolean first = true;
				for(JvmTypeConstraint constraint: wildcard.getConstraints()) {
					if (constraint instanceof JvmUpperBound) {
						if (first) {
							if (!withoutConstraints)
								appendable.append(" extends ");
							first = false;
						} else {
							if (withoutConstraints)
								throw new IllegalStateException("cannot have two upperbounds if type should be printed without constraints");
							appendable.append(" & ");
						}
						serialize(constraint.getTypeReference(), context, appendable, withoutConstraints, paramsToWildcard, paramsToObject, false);
					}
				}
			} else if (withoutConstraints) {
				appendable.append("Object");
			}
		} else if (type instanceof JvmGenericArrayTypeReference) {
			serialize(((JvmGenericArrayTypeReference) type).getComponentType(), context, appendable, withoutConstraints, paramsToWildcard, paramsToObject, true);
			appendable.append("[]");
		} else if (type instanceof JvmParameterizedTypeReference) {
			JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) type;
			if ((paramsToWildcard || paramsToObject) && parameterized.getType() instanceof JvmTypeParameter) {
				JvmTypeParameter parameter = (JvmTypeParameter) parameterized.getType();
				if (context == null)
					throw new IllegalArgumentException("argument may not be null if parameters have to be replaced by wildcards");
				if (!isLocalTypeParameter(context, parameter)) {
					if (paramsToWildcard)
						appendable.append("?");
					else
						appendable.append("Object");
					return;
				}
			}
			JvmType jvmType = allowPrimitives ? type.getType() : primitives.asWrapperTypeIfPrimitive(type).getType();
			appendable.append(jvmType);
			if (!parameterized.getArguments().isEmpty()) {
				appendable.append("<");
				for(int i = 0; i < parameterized.getArguments().size(); i++) {
					if (i != 0) {
						appendable.append(",");
					}
					serialize(parameterized.getArguments().get(i), context, appendable, withoutConstraints, paramsToWildcard, paramsToObject, false);
				}
				appendable.append(">");
			}
		} else if (type instanceof JvmAnyTypeReference) {
			appendable.append("Object");
		} else if (type instanceof JvmMultiTypeReference) {
			serialize(resolveMultiType(type), context, appendable, withoutConstraints, paramsToWildcard, paramsToObject, allowPrimitives);
		} else if (type instanceof JvmDelegateTypeReference) {
			serialize(((JvmDelegateTypeReference) type).getDelegate(), context, appendable, withoutConstraints, paramsToWildcard, paramsToObject, allowPrimitives);
		} else if (type instanceof JvmSpecializedTypeReference) {
			serialize(((JvmSpecializedTypeReference) type).getEquivalent(), context, appendable, withoutConstraints, paramsToWildcard, paramsToObject, allowPrimitives);
		} else {
			throw new IllegalArgumentException(String.valueOf(type));
		}
	}
	
	public JvmTypeReference resolveMultiType(JvmTypeReference reference) {
		if (reference instanceof JvmMultiTypeReference) {
			JvmTypeReference result = typeConformanceComputer.getCommonSuperType(((JvmMultiTypeReference) reference).getReferences());
			if (result instanceof JvmMultiTypeReference)
				return resolveMultiType(result);
			return result;
		}
		return reference;
	}
}
