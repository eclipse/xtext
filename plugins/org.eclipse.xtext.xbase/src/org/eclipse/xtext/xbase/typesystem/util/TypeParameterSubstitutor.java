/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.AbstractTypeReferenceVisitorWithParameter;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class TypeParameterSubstitutor extends AbstractTypeReferenceVisitorWithParameter.InheritanceAware<Set<JvmTypeParameter>, JvmTypeReference> {
		
	private final Map<JvmTypeParameter, JvmTypeReference> typeParameterMapping;
	private final CommonTypeComputationServices services;

	public TypeParameterSubstitutor(Map<JvmTypeParameter, JvmTypeReference> typeParameterMapping, CommonTypeComputationServices services) {
		this.services = services;
		this.typeParameterMapping = Maps.newHashMap(typeParameterMapping);
	}
	
	protected Map<JvmTypeParameter, JvmTypeReference> getTypeParameterMapping() {
		return typeParameterMapping;
	}
	
	protected CommonTypeComputationServices getServices() {
		return services;
	}
	
	@Override
	protected JvmTypeReference handleNullReference(Set<JvmTypeParameter> visiting) {
		return null;
	}
	
	public void enhanceMapping(Map<JvmTypeParameter, JvmTypeReference> typeParameterMapping) {
		this.typeParameterMapping.putAll(typeParameterMapping);
	}
	
	@Override
	public JvmTypeReference doVisitSpecializedTypeReference(JvmSpecializedTypeReference reference, Set<JvmTypeParameter> visiting) {
		if (reference instanceof XFunctionTypeRef) {
			XFunctionTypeRef casted = (XFunctionTypeRef) reference;
			XFunctionTypeRef result = services.getXtypeFactory().createXFunctionTypeRef();
			result.setEquivalent(visit(reference.getEquivalent(), visiting));
			for(JvmTypeReference paramType: casted.getParamTypes()) {
				result.getParamTypes().add(visit(paramType, visiting));
			}
			result.setReturnType(visit(casted.getReturnType(), visiting));
			return result;
		} else {
			return super.doVisitSpecializedTypeReference(reference, visiting);
		}
	}
	
	@Override
	public JvmTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, Set<JvmTypeParameter> visiting) {
		JvmType type = reference.getType();
		if (type instanceof JvmTypeParameter) {
			JvmTypeReference mappedReference = typeParameterMapping.get(type);
			if (mappedReference != null && mappedReference != reference) {
				JvmTypeReference result = visit(mappedReference, visiting);
				if (result != null) {
					return result;
				}
			}
		}
//				
//				if (isRawTypeContext() || boundParameters.containsKey(type)) {
//					JvmTypeReference bound = getBoundArgument((JvmTypeParameter) type);
//					if (isRecursive(type, bound)) {
//						// TODO find the reason for this recursion
////						System.out.println("Recursion2");
//						return bound;
//					}
//					
//					return visit(bound, replaceWildcards);
//				}
		JvmParameterizedTypeReference result = services.getTypesFactory().createJvmParameterizedTypeReference();
		result.setType(type);
//			if (!isRawTypeContext()) {
			for(JvmTypeReference argument: reference.getArguments()) {
				JvmTypeReference copiedArgument = visit(argument, visiting);
//					if (copiedArgument == null) {
//						copy = typeReferences.getTypeForName(Object.class, type);
//					}
				result.getArguments().add(copiedArgument);
			}
//			}
		return result;
	}
		
//		protected boolean isRecursive(final JvmType type, JvmTypeReference reference) {
//			boolean result = new AbstractTypeReferenceVisitor.InheritanceAware<Boolean>() {
//				@Override
//				protected Boolean handleNullReference() {
//					return true;
//				}
//				@Override
//				public Boolean doVisitTypeReference(JvmTypeReference reference) {
//					return false;
//				}
//				@Override
//				public Boolean doVisitWildcardTypeReference(JvmWildcardTypeReference reference) {
//					for(JvmTypeConstraint constraint: reference.getConstraints()) {
//						if (visit(constraint.getTypeReference()))
//							return true;
//					}
//					return false;
//				}
//				@Override
//				public Boolean doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
//					if (type == reference.getType())
//						return true;
//					for(JvmTypeReference argument: reference.getArguments()) {
//						if (visit(argument))
//							return true;
//					}
//					return false;
//				}
//			}.visit(reference);
//			return result;
//		}
	
	@Override
	public JvmTypeReference doVisitWildcardTypeReference(JvmWildcardTypeReference reference, Set<JvmTypeParameter> visiting) {
		JvmWildcardTypeReference result = services.getTypesFactory().createJvmWildcardTypeReference();
		for(JvmTypeConstraint constraint: reference.getConstraints()) {
			JvmTypeReference copiedConstraintReference = visit(constraint.getTypeReference(), visiting);
//			if (bound instanceof JvmWildcardTypeReference) {
//				result.getConstraints().addAll(((JvmWildcardTypeReference) bound).getConstraints());
//			} else {
				JvmTypeConstraint copiedConstraint = (JvmTypeConstraint) EcoreUtil.create(constraint.eClass());
//				copiedConstraint.setTypeReference(primitives.asWrapperTypeIfPrimitive(bound));
				copiedConstraint.setTypeReference(copiedConstraintReference);
				result.getConstraints().add(copiedConstraint);
			}
//			}
		return result;
	}
	
	@Override
	public JvmTypeReference doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, Set<JvmTypeParameter> visiting) {
		JvmTypeReference copiedComponent = visit(reference.getComponentType(), visiting);
		JvmGenericArrayTypeReference result = services.getTypesFactory().createJvmGenericArrayTypeReference();
		result.setComponentType(copiedComponent);
		return result;
	}
	@Override
	public JvmTypeReference doVisitAnyTypeReference(JvmAnyTypeReference reference, Set<JvmTypeParameter> visiting) {
		return services.getTypesFactory().createJvmAnyTypeReference();
	}
	
	@Override
	public JvmTypeReference doVisitMultiTypeReference(JvmMultiTypeReference reference, Set<JvmTypeParameter> visiting) {
		JvmMultiTypeReference result = services.getTypesFactory().createJvmMultiTypeReference();
		for(JvmTypeReference component: reference.getReferences()) {
			result.getReferences().add(visit(component, visiting));
		}
		return result;
	}

	@Override
	public JvmTypeReference doVisitSynonymTypeReference(JvmSynonymTypeReference reference, Set<JvmTypeParameter> visiting) {
		JvmSynonymTypeReference result = services.getTypesFactory().createJvmSynonymTypeReference();
		for(JvmTypeReference component: reference.getReferences()) {
			result.getReferences().add(visit(component, visiting));
		}
		return result;
	}

	@Override
	public JvmTypeReference doVisitUnknownTypeReference(JvmUnknownTypeReference reference, Set<JvmTypeParameter> visiting) {
		return services.getTypesFactory().createJvmUnknownTypeReference();
	}
	
	public JvmTypeReference substitute(JvmTypeReference original) {
		if (typeParameterMapping.isEmpty())
			return original;
		JvmTypeReference result = visit(original, Sets.<JvmTypeParameter>newHashSet());
		return result;
	}
}