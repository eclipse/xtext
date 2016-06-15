/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover

import org.apache.log4j.Logger
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmAnnotationValue
import org.eclipse.xtext.ui.editor.hover.html.XtextElementLinks
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XListLiteral
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation

/**
 * Provides a html representation for JvmAnnotationReferences to be used in hovers.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
class JvmAnnotationReferencePrinter {
	
	static val Logger LOG = Logger.getLogger(JvmAnnotationReferencePrinter) 
	
	def String toHtmlString(JvmAnnotationReference reference) {
		try {
			internalToString(reference)
		} catch (RuntimeException e) {
			LOG.error(e.message, e)
			return reference?.annotation?.simpleName
		}
	}
	
	protected def dispatch String internalToString(JvmAnnotationReference reference) {
		val buffer = new StringBuilder
		buffer.append("@");
		val uri = EcoreUtil.getURI(reference.getAnnotation());
		buffer.append(createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, uri, reference.getAnnotation().getSimpleName()));
		
		val needsExplicitProperties = reference.explicitValues.size>1 || (reference.explicitValues.head?.operation != null && reference.explicitValues.head.operation.simpleName!="value")
		if (reference.getExplicitValues().size() > 0) {
			buffer.append("(");
			buffer.append(reference.getExplicitValues().map[
				val builder = new StringBuilder
				if (needsExplicitProperties) {
					val operation = it.operation?:reference.annotation.declaredOperations.findFirst[simpleName=="value"]
					val operationUri = EcoreUtil.getURI(operation);
					builder.append(createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, operationUri, operation.simpleName));
					builder.append("=")
				}
				builder.append(internalToString)
				return builder.toString
			].join(', '))
			buffer.append(")");
		}
		return buffer.toString
	}
	
	protected def dispatch String internalToString(XAnnotation reference) {
		val buffer = new StringBuilder
		buffer.append("@");
		val uri = EcoreUtil.getURI(reference.annotationType);
		buffer.append(createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, uri, reference.annotationType.getSimpleName()));
		if (reference.value != null) {
			buffer.append("(")
			buffer.append(reference.value)
			buffer.append(")");
		} else if (!reference.elementValuePairs.isEmpty) {
			buffer.append("(")
			buffer.append(reference.elementValuePairs.map[
				val builder = new StringBuilder
				val operation = it.element?:(reference.annotationType as JvmAnnotationType).declaredOperations.findFirst[simpleName=="value"]
				val operationUri = EcoreUtil.getURI(operation);
				builder.append(createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, operationUri, operation.simpleName));
				builder.append("=")
				builder.append(it.value.internalToString)
				return builder.toString
			].join(', '))
			buffer.append(")");
		}
		return buffer.toString
	}
	
	protected def dispatch String internalToString(JvmAnnotationValue it) {
		val ref = eClass.getEStructuralFeature('values')
		if (ref == null) {
			throw new IllegalStateException("Cannot handle "+it)
		}
		val EList<?> values = eGet(ref) as EList<?>
		if (values.size > 1) {
			return '''#[«values.map[internalToString(it)].join(', ')»]'''
		} else {
			return values.head.internalToString
		}
	}
	
	protected def dispatch String internalToString(Object o) {
		o.toString
	}
	
	protected def dispatch String internalToString(XTypeLiteral o) {
		val uri = EcoreUtil.getURI(o.type)
		val text = createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME,uri,o.type.simpleName)
		return text + o.arrayDimensions.join()
	}
	
	protected def dispatch String internalToString(XListLiteral o) {
		'#['+o.elements.map[internalToString].join(', ')+']'
	}
	
	protected def dispatch String internalToString(XBinaryOperation o) {
		o.leftOperand.internalToString+" "+o.concreteSyntaxFeatureName+" "+o.rightOperand.internalToString
	}
	
	protected def dispatch String internalToString(XStringLiteral o) {
		'"'+o.value+'"'
	}
	
	protected def dispatch String internalToString(XNumberLiteral o) {
		o.value
	}
	
	protected def dispatch String internalToString(XBooleanLiteral o) {
		o.isIsTrue.toString
	}
	
	protected def dispatch String internalToString(XMemberFeatureCall o) {
		if (o.isPackageFragment) {
			return null
		}
		val prefix = o.memberCallTarget.internalToString
		return internalHandleAbstractFeatureCall(prefix, o)
	}
	
	protected def dispatch String internalToString(XFeatureCall o) {
		if (o.isPackageFragment) {
			return null
		}
		return internalHandleAbstractFeatureCall(null, o)
	}
	
	protected def internalHandleAbstractFeatureCall(String prefix, XAbstractFeatureCall o) {
		val postfix = if (o.feature != null && ! o.feature.eIsProxy) {
			val uri = EcoreUtil.getURI(o.feature)
			createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME,uri,o.concreteSyntaxFeatureName) 
		} else {
			o.concreteSyntaxFeatureName
		}
		if (prefix == null) {
			return postfix
		} else {
			return prefix + '.' + postfix
		}
	}
	
	def protected String createLinkWithLabel(String scheme, URI uri, String label) {
		return HoverLinkHelper.createLinkWithLabel(scheme, uri, label)
	}
	
}