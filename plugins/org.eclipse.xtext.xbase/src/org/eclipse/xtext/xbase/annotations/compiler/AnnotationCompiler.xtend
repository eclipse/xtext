/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.compiler

import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XIntLiteral
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationValueArray
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair
import org.eclipse.xtext.util.Strings

/**
 * 
 * compiler for the AST elements from XAnnotationPackage
 * 
 * @author Sven Efftinge
 */
class AnnotationCompiler {
	
	def dispatch void generate(XAnnotation annotation, IAppendable a) {
		a.append('@').append(annotation.annotationType)
		if (annotation.value != null) {
			a.append('(')
			annotation.value.generate(a)
			a.append(')')
		} else if (!annotation.elementValuePairs.isEmpty()) {
			a.append('(')
			val iter = annotation.elementValuePairs.iterator
			while (iter.hasNext) {
				iter.next.generate(a)
				if (iter.hasNext)
					a.append(',')
			}
			a.append(')')
		}
	}
	
	def dispatch void generate(XAnnotationElementValuePair binaryOp, IAppendable a) {
		a.append(binaryOp.getElement().simpleName).append(" = ")
		binaryOp.value.generate(a)
	}
	
	def dispatch void generate(XAnnotationElementValueBinaryOperation binaryOp, IAppendable a) {
		binaryOp.leftOperand.generate(a)
		a.append(" + ")
		binaryOp.rightOperand.generate(a)
	}
	
	def dispatch void generate(XAnnotationValueArray array, IAppendable a) {
		a.append('{')
		val iter = array.values.iterator
		while (iter.hasNext) {
			iter.next.generate(a)
			if (iter.hasNext)
				a.append(', ')
		}
		a.append('}')
	}
	
	def dispatch void generate(XFeatureCall featureCall, IAppendable a) {
		if (featureCall.declaringType != null) {
			a.append(featureCall.declaringType)
			a.append('.')			
		}
		a.append(featureCall.feature.simpleName)
	}
	
	def dispatch void generate(XStringLiteral stringLiteral, IAppendable a) {
		a.append('"').append(Strings::convertToJavaString(stringLiteral.value)).append('"')
	}
	
	def dispatch void generate(XBooleanLiteral booleanLiteral, IAppendable a) {
		a.append(booleanLiteral.isTrue)
	}
	
	def dispatch void generate(XIntLiteral intLiteral, IAppendable a) {
		a.append(intLiteral.value)
	}
	
	def dispatch void generate(XTypeLiteral typeLiteral, IAppendable a) {
		a.append(typeLiteral.type).append('.class')
	}
}