/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Lists.*;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmTypeReferencesValidator extends AbstractDeclarativeValidator {
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private Primitives primitives;
	
	@Inject
	private IJvmModelAssociations jvmModelAssociations;
	
	@Override
	protected List<EPackage> getEPackages() {
		return newArrayList(TypesPackage.eINSTANCE, XtypePackage.eINSTANCE);
	}
	
	@Check
	public void checkTypeArgumentsNotPrimitive(JvmParameterizedTypeReference typeRef) {
		EList<JvmTypeReference> arguments = typeRef.getArguments();
		for (int i=0;i<arguments.size();i++) {
			JvmTypeReference jvmTypeReference = arguments.get(i);
			checkNotPrimitive(jvmTypeReference);
		}
	}
	
	@Check
	public void checkTypeArgsAgainstTypeParameters(JvmParameterizedTypeReference typeRef) {
		if(typeRef.getType() instanceof JvmGenericType) {
			int numTypeParameters = ((JvmGenericType) typeRef.getType()).getTypeParameters().size();
			if(typeRef.getArguments().size() > 0) {
				if(numTypeParameters != typeRef.getArguments().size()) 
					error("Incorrect number of arguments for type " 
							+ getTypeSignature(typeRef.getType()) 
							+ "; it cannot be parameterized with arguments " 
							+ getTypeArguments(typeRef),
						IssueCodes.INVALID_NUMBER_OF_TYPE_ARGUMENTS, typeRef);
			} else {
				if(numTypeParameters > 0) 
					warning(typeRef.getType().getSimpleName() 
							+ " is a raw type. References to generic type " 
							+ getTypeSignature(typeRef.getType()) 
							+ " should be parameterized", IssueCodes.RAW_TYPE, typeRef);
			}
		}
	}
	
	protected void warning(String message, String issueCode, JvmParameterizedTypeReference typeReference) {
		EObject rootContainer = EcoreUtil.getRootContainer(typeReference);
		Resource resource = rootContainer.eResource();
		if (resource.getContents().get(0) == rootContainer) {
			super.warning(message, typeReference, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, -1, issueCode);
		} else {
			EObject container = typeReference;
			EObject sourceElement = jvmModelAssociations.getPrimarySourceElement(container);
			container = container.eContainer();
			while(sourceElement == null && container != null) {
				sourceElement = jvmModelAssociations.getPrimarySourceElement(container);
				container = container.eContainer();
			}
			if (sourceElement != null) {
				warning(message, sourceElement, sourceElement.eClass().getEStructuralFeature("name"), -1, issueCode);
			} else {
				super.warning(message, typeReference, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, -1, issueCode);
			}
		}
	}
	
	protected void error(String message, String issueCode, JvmParameterizedTypeReference typeReference) {
		EObject rootContainer = EcoreUtil.getRootContainer(typeReference);
		Resource resource = rootContainer.eResource();
		if (resource.getContents().get(0) == rootContainer) {
			super.error(message, typeReference, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, -1, issueCode);
		} else {
			EObject container = typeReference;
			EObject sourceElement = jvmModelAssociations.getPrimarySourceElement(container);
			container = container.eContainer();
			while(sourceElement == null && container != null) {
				sourceElement = jvmModelAssociations.getPrimarySourceElement(container);
				container = container.eContainer();
			}
			if (sourceElement != null) {
				error(message, sourceElement, sourceElement.eClass().getEStructuralFeature("name"), -1, issueCode);
			} else {
				super.error(message, typeReference, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, -1, issueCode);
			}
		}
	}
	
	protected String getTypeSignature(JvmType type) {
		StringBuffer b = new StringBuffer(type.getSimpleName());
		if(type instanceof JvmTypeParameterDeclarator) {
			b.append("<");
			for(Iterator<JvmTypeParameter> i =  ((JvmTypeParameterDeclarator)type).getTypeParameters().iterator(); i.hasNext();) {
				b.append(i.next().getName());
				if(i.hasNext())
					b.append(",");
			}
			b.append(">");
		}
		return b.toString();
	}
	
	protected String getTypeArguments(JvmParameterizedTypeReference typeRef) {
		StringBuffer b = new StringBuffer();
		b.append("<");
		for(Iterator<JvmTypeReference> i = typeRef.getArguments().iterator(); i.hasNext();) {
			b.append(i.next().getSimpleName());
			if(i.hasNext()) 
				b.append(",");
		}
		b.append(">");
		return b.toString();
	}
	
	@Check
	public void checkTypeArgumentsNotPrimitive(JvmTypeConstraint typeRef) {
		checkNotPrimitive(typeRef.getTypeReference());
	}
	
	protected void checkNotPrimitive(JvmTypeReference jvmTypeReference) {
		if (primitives.isPrimitive(jvmTypeReference)) {
			error("The primitive '"+jvmTypeReference.getQualifiedName('.')+"' cannot be a type argument", jvmTypeReference, null, IssueCodes.INVALID_USE_OF_TYPE);
		}
	}
	
	@Check
	public void checkJvmFormalParameterNotPrimitiveVoid(JvmFormalParameter param) {
		if (typeReferences.is(param.getParameterType(), Void.TYPE)) {
			error("The primitive 'void' cannot be the type of a parameter", param.getParameterType(), null, IssueCodes.INVALID_USE_OF_TYPE);
		}
	}
}
