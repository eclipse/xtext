/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("deprecation")
@Singleton
public class XbaseWithAnnotationsTypeProvider extends XbaseTypeProvider {
	
	@Inject
	private XAnnotationUtil annotationUtil;
	
	@Override
	protected JvmTypeReference expectedType(EObject container, EReference reference, int index,
			boolean rawType) {
		if (container instanceof XAnnotation) {
			return _expectedType((XAnnotation)container, reference, index, rawType);
		} else if (container instanceof XAnnotationElementValuePair) {
			return _expectedType((XAnnotationElementValuePair)container, reference, index, rawType);
		} else {
			return super.expectedType(container, reference, index, rawType);
		}
	}
	
	/**
	 * @param index unused but required in dispatch signature 
	 * @param rawType unused but required in dispatch signature
	 */
	protected JvmTypeReference _expectedType(XAnnotation annotation, EReference reference, int index,
			boolean rawType) {
		if (reference == XAnnotationsPackage.Literals.XANNOTATION__VALUE) {
			JvmType annotationType = annotation.getAnnotationType();
			if (annotationType == null || annotationType.eIsProxy() || !(annotationType instanceof JvmAnnotationType))
				return null;
			JvmOperation valueOperation = annotationUtil.findSingleValueAttribute((JvmAnnotationType) annotationType);
			if (valueOperation==null)
				return null;
			return valueOperation.getReturnType();
		}
		return null;
	}
	
	/**
	 * @param index unused but required in dispatch signature 
	 * @param rawType unused but required in dispatch signature
	 */
	protected JvmTypeReference _expectedType(XAnnotationElementValuePair annotation, EReference reference, int index,
			boolean rawType) {
		if (reference == XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__VALUE) {
			if (annotation.getElement() != null) {
				return annotation.getElement().getReturnType();
			}
		}
		return null;
	}
	
	@Override
	protected JvmTypeReference type(XExpression expression, JvmTypeReference rawExpectation, boolean rawType) {
		if (expression instanceof XAnnotation) {
			return _type((XAnnotation)expression, rawExpectation, rawType);
		} else {
			return super.type(expression, rawExpectation, rawType);
		}
	}

	/**
	 * @param rawExpectation unused but required in dispatch signature 
	 * @param rawType unused but required in dispatch signature
	 */
	protected JvmTypeReference _type(XAnnotation annotation, JvmTypeReference rawExpectation, boolean rawType) {
		final JvmType annotationType = annotation.getAnnotationType();
		if (annotationType == null) {
			return null;
		}
		return getTypeReferences().createTypeRef(annotationType);
	}
	
}
