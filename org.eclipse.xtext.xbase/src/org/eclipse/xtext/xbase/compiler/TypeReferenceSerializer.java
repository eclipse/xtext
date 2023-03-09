/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeReferenceSerializer {
	
	@Inject
	private Primitives primitives;
	
	@Inject 
	private ILogicalContainerProvider contextProvider;
	
	@Inject
	private ILocationInFileProvider locationProvider;
	
	@Inject
	private CommonTypeComputationServices services;
	
	public boolean isLocalTypeParameter(EObject context, JvmTypeParameter parameter) {
		if (context == parameter.getDeclarator()) 
			return true;
		if (context instanceof JvmOperation && ((JvmOperation) context).isStatic())
			return false;
		if (context instanceof JvmDeclaredType && ((JvmDeclaredType) context).isStatic())
			return false;
		JvmIdentifiableElement jvmElement = contextProvider.getNearestLogicalContainer(context);
		if (jvmElement != null) {
			return isLocalTypeParameter(jvmElement, parameter);
		}
		EObject container = context.eContainer();
		if (container == null) {
			return false;
		}
		return isLocalTypeParameter(container, parameter);
	}
	
	public void serialize(final JvmTypeReference type, EObject context, IAppendable appendable) {
		serialize(type, context, appendable, false, true);
	}
	public void serialize(final JvmTypeReference type, EObject context, IAppendable appendable, boolean withoutConstraints, boolean paramsToWildcard) {
		serialize(type, context, appendable, withoutConstraints, paramsToWildcard, false, true);
	}
	
	public void serialize(final JvmTypeReference type, EObject context, IAppendable appendable, boolean withoutConstraints, boolean paramsToWildcard, boolean paramsToObject, boolean allowPrimitives) {
		IAppendable tracedAppendable = appendable;
		boolean tracing = false;
		if (appendable instanceof ITreeAppendable && type.eResource() == context.eResource()) {
			tracedAppendable = ((ITreeAppendable) appendable).trace(type);
			tracing = true;
		}
		if (type instanceof JvmWildcardTypeReference) {
			JvmWildcardTypeReference wildcard = (JvmWildcardTypeReference) type;
			if (!withoutConstraints) {
				tracedAppendable.append("?");
			}
			List<JvmTypeConstraint> constraints = wildcard.getConstraints();
			if (!constraints.isEmpty()) {
				for(JvmTypeConstraint constraint: constraints) {
					if (constraint instanceof JvmLowerBound) {
						if (!withoutConstraints)
							tracedAppendable.append(" super ");
						serialize(constraint.getTypeReference(), context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject, false);
						return;
					}
				}
				if (constraints.size() == 1) {
					if (Object.class.getName().equals(constraints.get(0).getTypeReference().getIdentifier())) {
						return;
					}
				}
				boolean first = true;
				for(JvmTypeConstraint constraint: constraints) {
					if (constraint instanceof JvmUpperBound) {
						if (first) {
							if (!withoutConstraints)
								tracedAppendable.append(" extends ");
							first = false;
						} else {
							if (withoutConstraints)
								throw new IllegalStateException("cannot have two upperbounds if type should be printed without constraints");
							tracedAppendable.append(" & ");
						}
						serialize(constraint.getTypeReference(), context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject, false);
					}
				}
			} else if (withoutConstraints) {
				tracedAppendable.append("Object");
			}
		} else if (type instanceof JvmGenericArrayTypeReference) {
			serialize(((JvmGenericArrayTypeReference) type).getComponentType(), context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject, true);
			tracedAppendable.append("[]");
		} else if (type instanceof JvmInnerTypeReference) {
			JvmInnerTypeReference casted = (JvmInnerTypeReference) type;
			JvmParameterizedTypeReference outer = casted.getOuter();
			serialize(outer, context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject, true);
			tracedAppendable.append(".");
			tracedAppendable.append(type.getType().getSimpleName());
			serializeTypeArguments(casted, context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject);
		} else if (type instanceof JvmParameterizedTypeReference) {
			JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) type;
			if ((paramsToWildcard || paramsToObject) && parameterized.getType() instanceof JvmTypeParameter) {
				JvmTypeParameter parameter = (JvmTypeParameter) parameterized.getType();
				if (!isLocalTypeParameter(context, parameter)) {
					if (paramsToWildcard)
						tracedAppendable.append("?");
					else
						tracedAppendable.append("Object");
					return;
				}
			}
			JvmType jvmType = allowPrimitives ? type.getType() : primitives.asWrapperTypeIfPrimitive(type).getType();
			if (tracing) {
				ITextRegion region = locationProvider.getFullTextRegion(type, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, 0);
				if (region instanceof ITextRegionWithLineInformation) {
					((ITreeAppendable) tracedAppendable).trace(new LocationData((ITextRegionWithLineInformation) region, null)).append(jvmType);
				} else {
					tracedAppendable.append(jvmType);
				}
			} else {
				tracedAppendable.append(jvmType);
			}
			serializeTypeArguments(parameterized, context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject);
		} else if (type instanceof JvmAnyTypeReference) {
			tracedAppendable.append("Object");
		} else if (type instanceof JvmMultiTypeReference) {
			serialize(resolveMultiType(type, context), context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject, allowPrimitives);
		} else if (type instanceof JvmDelegateTypeReference) {
			JvmTypeReference delegate = ((JvmDelegateTypeReference) type).getDelegate();
			if(delegate != null)
				serialize(delegate, context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject, allowPrimitives);
			else
				tracedAppendable.append("Object");
		} else if (type instanceof JvmSpecializedTypeReference) {
			serialize(((JvmSpecializedTypeReference) type).getEquivalent(), context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject, allowPrimitives);
		} else if (type instanceof JvmUnknownTypeReference) {
			if (type.eIsSet(TypesPackage.Literals.JVM_UNKNOWN_TYPE_REFERENCE__QUALIFIED_NAME)) {
				tracedAppendable.append(type.getQualifiedName());
			} else {
				tracedAppendable.append("Object");
			}
		} else {
			throw new IllegalArgumentException(String.valueOf(type));
		}
	}

	private void serializeTypeArguments(JvmParameterizedTypeReference reference, EObject context, IAppendable tracedAppendable, boolean withoutConstraints,
			boolean paramsToWildcard, boolean paramsToObject) {
		if (!reference.getArguments().isEmpty()) {
			tracedAppendable.append("<");
			for(int i = 0; i < reference.getArguments().size(); i++) {
				if (i != 0) {
					tracedAppendable.append(", ");
				}
				serialize(reference.getArguments().get(i), context, tracedAppendable, withoutConstraints, paramsToWildcard, paramsToObject, false);
			}
			tracedAppendable.append(">");
		}
	}
	
	public JvmTypeReference resolveMultiType(JvmTypeReference reference, EObject context) {
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, context.eResource().getResourceSet());
		return owner.toLightweightTypeReference(reference).toJavaCompliantTypeReference();
	}
}
