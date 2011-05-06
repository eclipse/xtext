/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.typing;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationValueArray;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;

import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class XbaseWithAnnotationsTypeProvider extends XbaseTypeProvider {

	protected JvmTypeReference _expectedType(XAnnotation annotation, EReference reference, int index,
			boolean rawType) {
		return null;
	}
	
	protected JvmTypeReference _expectedType(XAnnotationElementValuePair annotation, EReference reference, int index,
			boolean rawType) {
		return null;
	}
	
	protected JvmTypeReference _expectedType(XAnnotationElementValueBinaryOperation binaryOp, EReference reference, int index,
			boolean rawType) {
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
		return null;
	}
	
	protected JvmTypeReference _type(XAnnotationValueArray annotation, boolean rawType) {
		return null;
	}
}
