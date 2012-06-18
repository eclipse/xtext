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
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.util.AbstractXtypeReferenceVisitorWithParameter;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class TypeParameterSubstitutor extends AbstractXtypeReferenceVisitorWithParameter<Set<JvmTypeParameter>, JvmTypeReference> {
		
	private final Map<JvmTypeParameter, MergedBoundTypeArgument> typeParameterMapping;
	private final CommonTypeComputationServices services;

	public TypeParameterSubstitutor(Map<JvmTypeParameter, MergedBoundTypeArgument> typeParameterMapping, CommonTypeComputationServices services) {
		this.services = services;
		this.typeParameterMapping = Maps.newLinkedHashMap(typeParameterMapping);
	}
	
	protected Map<JvmTypeParameter, MergedBoundTypeArgument> getTypeParameterMapping() {
		return typeParameterMapping;
	}
	
	protected CommonTypeComputationServices getServices() {
		return services;
	}
	
	@Override
	protected JvmTypeReference handleNullReference(Set<JvmTypeParameter> visiting) {
		return null;
	}
	
	public void enhanceMapping(Map<JvmTypeParameter, MergedBoundTypeArgument> typeParameterMapping) {
		this.typeParameterMapping.putAll(typeParameterMapping);
	}
	
	@Override
	public JvmTypeReference doVisitFunctionTypeReference(XFunctionTypeRef reference, Set<JvmTypeParameter> visiting) {
		XFunctionTypeRef result = services.getXtypeFactory().createXFunctionTypeRef();
		JvmTypeReference equivalent = (JvmTypeReference) reference.eGet(TypesPackage.Literals.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT, false);
		if (equivalent != null)
			result.setEquivalent(visit(equivalent, visiting));
		result.setType(reference.getType());
		result.setInstanceContext(reference.isInstanceContext());
		for(JvmTypeReference paramType: reference.getParamTypes()) {
			result.getParamTypes().add(visit(paramType, visiting));
		}
		result.setReturnType(visit(reference.getReturnType(), visiting));
		return result;
	}
	
	@Override
	public JvmTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, Set<JvmTypeParameter> visiting) {
		JvmType type = reference.getType();
		if (type instanceof JvmTypeParameter) {
			MergedBoundTypeArgument boundTypeArgument = typeParameterMapping.get(type);
			if (boundTypeArgument != null && boundTypeArgument.getTypeReference() != reference) {
				JvmTypeReference result = visit(boundTypeArgument.getTypeReference(), visiting);
				if (result != null) {
					return result;
				}
			}
		}
		JvmParameterizedTypeReference result = services.getTypesFactory().createJvmParameterizedTypeReference();
		result.setType(type);
		for(JvmTypeReference argument: reference.getArguments()) {
			JvmTypeReference copiedArgument = visit(argument, visiting);
			result.getArguments().add(copiedArgument);
		}
		return result;
	}

	protected JvmTypeReference getBoundTypeArgument(JvmParameterizedTypeReference reference, JvmTypeParameter type,
			Set<JvmTypeParameter> visiting) {
		MergedBoundTypeArgument boundTypeArgument = typeParameterMapping.get(type);
		if (boundTypeArgument != null && boundTypeArgument.getTypeReference() != reference) {
			JvmTypeReference result = visit(boundTypeArgument.getTypeReference(), visiting);
			if (result != null) {
				return result;
			}
		}
		return null;
	}
		
	@Override
	public JvmTypeReference doVisitWildcardTypeReference(JvmWildcardTypeReference reference, Set<JvmTypeParameter> visiting) {
		JvmWildcardTypeReference result = services.getTypesFactory().createJvmWildcardTypeReference();
		for (JvmTypeConstraint constraint : reference.getConstraints()) {
			JvmTypeReference copiedConstraintReference = visit(constraint.getTypeReference(), visiting);
			JvmTypeConstraint copiedConstraint = (JvmTypeConstraint) EcoreUtil.create(constraint.eClass());
			copiedConstraint.setTypeReference(copiedConstraintReference);
			result.getConstraints().add(copiedConstraint);
		}
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