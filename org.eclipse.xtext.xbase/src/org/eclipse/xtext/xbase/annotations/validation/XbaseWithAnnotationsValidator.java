/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.validation;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.typing.XAnnotationUtil;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.validation.XbaseValidator;

import com.google.inject.Inject;

public class XbaseWithAnnotationsValidator extends XbaseValidator {
	
	@Inject
	private XAnnotationUtil annotationUtil;
	
	@Inject
	private AnnotationValueValidator annotationValueValidator;
	
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
				annotationValueValidator.validateAnnotationValue(value, this);
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
