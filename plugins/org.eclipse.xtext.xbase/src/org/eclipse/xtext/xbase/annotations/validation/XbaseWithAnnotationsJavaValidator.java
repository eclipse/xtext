/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.validation;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.typing.XAnnotationUtil;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;

import com.google.inject.Inject;
 
public class XbaseWithAnnotationsJavaValidator extends XbaseJavaValidator {
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Inject
	private TypeConformanceComputer conformanceComputer;
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private XAnnotationUtil annotationUtil;
	
	@Override
	protected List<EPackage> getEPackages() {
		final List<EPackage> ePackages = newArrayList(super.getEPackages());
		ePackages.add(XAnnotationsPackage.eINSTANCE);
		return ePackages;
	}
	
	@Check
	public void checkTypeConformance(XAnnotationElementValuePair annotation) throws Exception {
		JvmTypeReference type = typeProvider.getType(annotation.getValue());
		final JvmTypeReference returnType = annotation.getElement().getReturnType();
		checkAnnotationValueConformance(annotation.getValue(), returnType, type);
	}

	protected void checkAnnotationValueConformance(XExpression expression, final JvmTypeReference expectedType, JvmTypeReference actualType) {
		if (conformanceComputer.isConformant(expectedType, actualType)) {
			return;
		}
		if (typeReferences.isArray(expectedType) && !typeReferences.isArray(actualType)) {
			if (expectedType instanceof JvmGenericArrayTypeReference) {
				JvmTypeReference componentType = ((JvmGenericArrayTypeReference) expectedType).getComponentType();
				if (conformanceComputer.isConformant(componentType, actualType))
					return;
			} else {
				JvmType componentType = ((JvmArrayType)expectedType.getType()).getComponentType();
				if (conformanceComputer.isConformant(typeReferences.createTypeRef(componentType), actualType))
					return;
			}
		}
		error("Incompatible types. Expected " + getNameOfTypes(expectedType) + " but was "
				+ canonicalName(actualType), expression, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
				INCOMPATIBLE_TYPES);
	}
	
	@Check
	public void checkTypeConformance(XAnnotation annotation) throws Exception {
		if (annotation.getValue()==null)
			return;
		JvmAnnotationType type = annotation.getAnnotationType();
		JvmOperation value = annotationUtil.findSingleValueAttribute(type);
		if (value == null) {
			error("The attribute 'value' is undefined for the annotation '"+type.getIdentifier()+"'", annotation.getValue(), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					ANNOTATIONS_NO_VALUE_ATTRIBUTE);
		} else {
			JvmTypeReference actualType = typeProvider.getType(annotation.getValue());
			checkAnnotationValueConformance(annotation.getValue(), value.getReturnType(), actualType);
		}
	}

	@Check
	public void checkAllAttributesConfigured(XAnnotation annotation) {
		JvmAnnotationType annotationType = annotation.getAnnotationType();
		Iterable<JvmOperation> attributes = annotationType.getDeclaredOperations();
		for (JvmOperation jvmOperation : attributes) {
			XExpression value = annotationUtil.findValue(annotation, jvmOperation);
			if (value == null && jvmOperation.getDefaultValue() == null) {
				error("The annotation must define the attribute '"+jvmOperation.getSimpleName()+"'.", annotation, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ANNOTATIONS_MISSING_ATTRIBUTE_DEFINITION);
			}
		}
	}

	/*
	 * validations :
	 * - check @Target
	 * - check elements 
	 * 		- are all elements without default values configured
	 * 		- check whether referenced fields can be evaluated by the compiler, or more generally all expressions need to be static literals
	 */
}
