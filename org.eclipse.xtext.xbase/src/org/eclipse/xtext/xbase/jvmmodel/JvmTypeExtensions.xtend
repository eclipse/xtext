/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel

import com.google.inject.Inject
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter
import org.eclipse.xtext.xbase.compiler.CompilationTemplateAdapter
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.common.types.JvmAnnotationReference

/**
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * 
 * @since 2.7
 */
class JvmTypeExtensions {
	
	@Inject extension ILogicalContainerProvider 
	
	def (ITreeAppendable)=>void getCompilationStrategy(JvmIdentifiableElement it) {
		val adapter = eAdapters.filter(CompilationStrategyAdapter).head
		return adapter?.compilationStrategy
	}
	
	def StringConcatenationClient getCompilationTemplate(JvmIdentifiableElement it) {
		val adapter = eAdapters.filter(CompilationTemplateAdapter).head
		return adapter?.compilationTemplate
	}
	
	def isSingleSyntheticDefaultConstructor(JvmConstructor it) {
		return parameters.empty && 
			associatedExpression === null && 
			compilationStrategy === null && 
			compilationTemplate === null &&
			declaringType.members.filter(JvmConstructor).size == 1
	}
	
	def isSynthetic(JvmIdentifiableElement element) {
		element.metaData.synthetic
	}
	
	/**
	 * @since 2.8
	 */
	def isSynthetic(JvmAnnotationReference element) {
		element.metaData.synthetic
	}
	
	def void setSynthetic(JvmIdentifiableElement element, boolean isSynthetic) {
		element.metaData.synthetic = isSynthetic
	}
	
	/**
	 * @since 2.8
	 */
	def void setSynthetic(JvmAnnotationReference element, boolean isSynthetic) {
		element.metaData.synthetic = isSynthetic
	}
	
	/**
	 * @since 2.8
	 */
	def protected JvmIdentifiableMetaData getMetaData(EObject element) {
		var metaData = EcoreUtil.getAdapter(element.eAdapters, JvmIdentifiableMetaData) as JvmIdentifiableMetaData
		if (metaData === null) {
			metaData = new JvmIdentifiableMetaData
			element.eAdapters += metaData
		}
		return metaData
	}
	
}

/**
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noreference This class is not intended to be referenced by clients.
 * 
 * @since 2.7
 */
class JvmIdentifiableMetaData extends AdapterImpl {
	@Accessors boolean synthetic
	
	override isAdapterForType(Object type) {
		JvmIdentifiableMetaData == type
	}
	
}
