/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtype.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
//import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
//import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xtype.XtypeFactory;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XFunctionTypeRefImplCustom extends XFunctionTypeRefImpl {
	
	// TODO should we update the type as soon as the number of argument types changes?  
	@Override
	public JvmType getType() {
		if (this.type == null) {
//			// make sure scoping has taken place and installed an IJvmTypeProvider
//			if (returnType != null)
//				returnType.getType();
			type = TypesFactory.eINSTANCE.createJvmVoid();
			((InternalEObject)type).eSetProxyURI(computeTypeUri());
		}
		return super.getType();
	}
	
	@Override
	public JvmTypeReference getEquivalent() {
		if (equivalent == null) {
			TypesFactory typesFactory = TypesFactory.eINSTANCE;
			JvmType rawType = getType();
			if (rawType != null && rawType instanceof JvmDeclaredType) {
				EList<JvmTypeReference> superTypesWithObject = ((JvmDeclaredType) rawType).getSuperTypes();
				JvmTypeReference objectReference = superTypesWithObject.get(0);
				JvmParameterizedTypeReference result = typesFactory.createJvmParameterizedTypeReference();
				result.setType(rawType);
				for(JvmTypeReference paramType: Lists.newArrayList(getParamTypes())) {
//					JvmWildcardTypeReference targetWildcard = typesFactory.createJvmWildcardTypeReference();
//					JvmLowerBound lowerBound = typesFactory.createJvmLowerBound();
					JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
					delegate.setDelegate(paramType);
//					lowerBound.setTypeReference(delegate);
//					JvmUpperBound upperBound = typesFactory.createJvmUpperBound();
//					XDelegateTypeReference objectDelegate = xtypeFactory.createXDelegateTypeReference();
//					objectDelegate.setDelegate(objectReference);
//					upperBound.setTypeReference(objectDelegate);
					
//					targetWildcard.getConstraints().add(upperBound);
//					targetWildcard.getConstraints().add(lowerBound);
//					result.getArguments().add(targetWildcard);
					result.getArguments().add(delegate);
				}
				{
//					JvmWildcardTypeReference returnType = typesFactory.createJvmWildcardTypeReference();
//					JvmUpperBound returnTypeBound = typesFactory.createJvmUpperBound();
					JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
					delegate.setDelegate(getReturnType());
//					returnTypeBound.setTypeReference(delegate);
//					returnType.getConstraints().add(returnTypeBound);
//					result.getArguments().add(returnType);
					result.getArguments().add(delegate);
				}
				equivalent = result;
			} else {
				equivalent = null;
			}
		}
		return equivalent;
	}
	
	protected URI computeTypeUri() {
		return URI.createURI("java:/Objects/"+Functions.class.getCanonicalName()+"#"+Functions.class.getCanonicalName()+"$Function"+getParamTypes().size());
	}
	
	@Override
	public String getIdentifier() {
		StringBuilder result = new StringBuilder("(");
		for (int i = 0;i< getParamTypes().size();i++) {
			JvmTypeReference reference = getParamTypes().get(i);
			result.append(reference.getIdentifier());
			if (i<getParamTypes().size()-1)
				result.append(", ");
		}
		result.append(") => ");
		if (getReturnType()!=null)
			result.append(getReturnType().getIdentifier());
		return result.toString();
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		StringBuilder result = new StringBuilder("(");
		for (int i = 0;i< getParamTypes().size();i++) {
			JvmTypeReference reference = getParamTypes().get(i);
			result.append(reference.getQualifiedName(innerClassDelimiter));
			if (i<getParamTypes().size()-1)
				result.append(", ");
		}
		result.append(") => ");
		if (getReturnType()!=null)
			result.append(getReturnType().getQualifiedName(innerClassDelimiter));
		return result.toString();
	}
	
	@Override
	public String getSimpleName() {
		StringBuilder result = new StringBuilder("(");
		for (int i = 0;i< getParamTypes().size();i++) {
			JvmTypeReference reference = getParamTypes().get(i);
			result.append(reference.getSimpleName());
			if (i<getParamTypes().size()-1)
				result.append(", ");
		}
		result.append(") => ");
		if (getReturnType()!=null)
			result.append(getReturnType().getSimpleName());
		return result.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(eClass().getName());
		result.append(": ");
		result.append(getIdentifier());
		return result.toString();
	}
}
