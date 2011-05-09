/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.typing;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationValueArray;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class XbaseWithAnnotationsTypeProvider extends XbaseTypeProvider {
	
	@Inject
	private XAnnotationUtil annotationUtil;
	
	protected JvmTypeReference _expectedType(XAnnotation annotation, EReference reference, int index,
			boolean rawType) {
		if (reference == XAnnotationsPackage.Literals.XANNOTATION__VALUE) {
			JvmOperation valueOperation = annotationUtil.findSingleValueAttribute(annotation.getAnnotationType());
			if (valueOperation==null)
				return null;
			return valueOperation.getReturnType();
		}
		return null;
	}
	
	protected JvmTypeReference _expectedType(XAnnotationElementValuePair annotation, EReference reference, int index,
			boolean rawType) {
		if (reference == XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__VALUE) {
			if (annotation.getElement() != null) {
				return annotation.getElement().getReturnType();
			}
		}
		return null;
	}
	
	protected JvmTypeReference _expectedType(XAnnotationElementValueBinaryOperation binaryOp, EReference reference, int index,
			boolean rawType) {
		if (reference == XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_BINARY_OPERATION__RIGHT_OPERAND) {
			return getType(binaryOp.getLeftOperand(), rawType);
		}
		return null;
	}
	
	protected JvmTypeReference _expectedType(XAnnotationValueArray array, EReference reference, int index,
			boolean rawType) {
		return getExpectedType(array, rawType);
	}

	protected JvmTypeReference _type(XAnnotation annotation, boolean rawType) {
		return getTypeReferences().createTypeRef(annotation.getAnnotationType());
	}
	
	protected JvmTypeReference _type(XAnnotationElementValueBinaryOperation annotation, boolean rawType) {
		return getType(annotation.getLeftOperand(), rawType);
	}
	
	protected JvmTypeReference _type(XAnnotationValueArray annotation, boolean rawType) {
		List<JvmTypeReference> references = newArrayList();
		for (XExpression expression : annotation.getValues()) {
			references.add(getType(expression,rawType));
		}
		JvmTypeReference commonType = getCommonType(references);
		return getTypeReferences().createArrayType(commonType);
	}
}
