/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.model.annotations.IClassAnnotation

/**
 * A specialized Java file generator used for classes in the 'src-gen' folder.
 */
class GeneratedJavaFileAccess extends JavaFileAccess {
	
	CharSequence typeComment
	
	@Accessors
	val List<IClassAnnotation> annotations = newArrayList
	
	protected new(TypeReference typeRef, CodeConfig codeConfig) {
		super(typeRef, codeConfig)
	}
	
	override isMarkedAsGenerated() {
		return true
	}
	
	override setMarkedAsGenerated(boolean markedAsGenerated) {
		if (!markedAsGenerated)
			throw new IllegalArgumentException("It's always generated");
	}
	
	def void setTypeComment(StringConcatenationClient javaContent) {
		val javaStringConcat = new JavaTypeAwareStringConcatenation(this)
		javaStringConcat.append(javaContent)
		this.typeComment = javaStringConcat
	}
	
	/**
	 * Prepends the addition of required imports of the employed annotations.
	 * Since the 'typeComment' is a {@link JavaFileAccess.JavaTypeAwareStringConcatenation}
	 * any optionally required imports are already processed and tracked in {@link #imports}.
	 */
	override getContent() {
		classAnnotations.forEach[
			importType(annotationImport)
		]
		super.getContent()
	}
	
	private def getClassAnnotations() {
		(annotations + codeConfig.classAnnotations.filter[appliesTo(this)]).toSet
	}
	
	override getInternalContent() '''
		«typeComment»
		«FOR annot : classAnnotations»
			«annot.generate()»
		«ENDFOR»	
		«super.getInternalContent»
	'''
	
}