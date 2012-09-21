/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.macro.lang.processing

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.xtend.macro.lang.macro.MacroAnnotation
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.linking.ILinkingService
import org.eclipse.xtext.linking.lazy.LazyURIEncoder
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations

import static org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage$Literals.*

class XAnnotationExtensions {
	
	@Inject extension IJvmModelAssociations associations
	@Inject LazyURIEncoder encoder
	@Inject ILinkingService linkingService
	
	/**
	 * Checks whether this annotation is pointing to a processed annotation, without resolving the proxy
	 */
	def isProcessed(XAnnotation it) {
		switch proxy : it.eGet(XANNOTATION__ANNOTATION_TYPE) {
			EObject case proxy.eIsProxy: {
				val uri = (proxy as InternalEObject).eProxyURI
				if (encoder.isCrossLinkFragment(eResource, uri.fragment)) {
					val triple = encoder.decode(eResource, uri.fragment)
					val candidates = linkingService.getLinkedObjects(triple.first, triple.second, triple.third)
					if (!candidates.isEmpty) {
						return (candidates.head as JvmAnnotationType).isProcessedAnnotation
					}
				}
			}
			JvmAnnotationType : {
				return proxy.processedAnnotation
			}
		}
		return false
	}
	
	def getMacroAnnotation(JvmAnnotationType it) {
		sourceElements.filter(typeof(MacroAnnotation)).head
	}
	
	def getMacroAnnotation(XAnnotation it) {
		switch proxy : it.eGet(XANNOTATION__ANNOTATION_TYPE) {
			EObject case proxy.eIsProxy: {
				val uri = (proxy as InternalEObject).eProxyURI
				// TODO get these services from the resource service provider to make sure they are the ones used in Xtend
				if (encoder.isCrossLinkFragment(eResource, uri.fragment)) {
					val triple = encoder.decode(eResource, uri.fragment)
					val candidates = linkingService.getLinkedObjects(triple.first, triple.second, triple.third)
					if (!candidates.isEmpty) {
						return (candidates.head as JvmAnnotationType).macroAnnotation
					}
				}
			}
			JvmAnnotationType : {
				return proxy.macroAnnotation
			}
		}
		return null
	}
	
	def protected isProcessedAnnotation(JvmAnnotationType annotationType) {
		associations.getSourceElements(annotationType).exists[ e |
			e instanceof MacroAnnotation
		]
	}
}