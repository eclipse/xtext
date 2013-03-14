/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.validation;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;
import static org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage.Literals.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.typing.XAnnotationUtil;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
 
public class XbaseWithAnnotationsJavaValidator extends XbaseJavaValidator {
	
	@Inject
	private XAnnotationUtil annotationUtil;
	
	
	public static final List<EClass> expressionTypesAllowedAsValues = ImmutableList.<EClass>builder().add(
			XANNOTATION,
			XLIST_LITERAL,
			XSTRING_LITERAL,
			XBOOLEAN_LITERAL,
			XNUMBER_LITERAL,
			XTYPE_LITERAL,
			XFEATURE_CALL,
			XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION
		).build();
	
	
	@Override
	protected List<EPackage> getEPackages() {
		final List<EPackage> ePackages = newArrayList(super.getEPackages());
		ePackages.add(XAnnotationsPackage.eINSTANCE);
		return ePackages;
	}

	@Check
	public void checkAllAttributesConfigured(XAnnotation annotation) {
		JvmType annotationType = annotation.getAnnotationType();
		if (annotationType == null || annotationType.eIsProxy() || !(annotationType instanceof JvmAnnotationType))
			return;
		Iterable<JvmOperation> attributes = ((JvmAnnotationType) annotationType).getDeclaredOperations();
		for (JvmOperation jvmOperation : attributes) {
			XExpression value = annotationUtil.findValue(annotation, jvmOperation);
			if(value == null) {
				if (jvmOperation.getDefaultValue() == null) {
					error("The annotation must define the attribute '"+jvmOperation.getSimpleName()+"'.", annotation, null, 
							ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ANNOTATIONS_MISSING_ATTRIBUTE_DEFINITION);
				}
			} else 
				checkAllowedAnnotationValueExpression(value);
		}
	}
	
	protected void checkAllowedAnnotationValueExpression(EObject value) {
		for(EObject subExpression: EcoreUtil2.eAllContents(value)) {
			if(!expressionTypesAllowedAsValues.contains(subExpression.eClass())) 
				error("The value for an annotation attribute must be a constant expression", null, ANNOTATIONS_ILLEGAL_ATTRIBUTE);
		}
	}
	
	@Override
	protected boolean isImplicitReturn(XExpression expr) {
		if (expr instanceof XAnnotation)
			return false;
		return super.isImplicitReturn(expr);
	}

	/*
	 * validations :
	 * - check @Target
	 * - check elements 
	 * 		- are all elements without default values configured
	 * 		- check whether referenced fields can be evaluated by the compiler, or more generally all expressions need to be static literals
	 */
}
