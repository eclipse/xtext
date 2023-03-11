/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.macro

/**
 * @author dietrich - Initial contribution and API
 */
import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration
import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations.Annotation1
import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations.Annotation2
import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations.Annotation3
import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations.Annotation1Config
import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations.Annotation2Config
import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedAnnotations.Annotation3Config

interface AnnotationWithNestedAnnotations {
	@Target(ElementType.TYPE)
	@Active(AnnotationWithNestedAnnotationsProcessor)
	@Retention(RetentionPolicy.RUNTIME)
	annotation Annotation1 {
		Annotation2[] ann2 = #[]
	}
	
	@Target(ElementType.TYPE)
	@Active(AnnotationWithNestedAnnotationsProcessor)
	@Retention(RetentionPolicy.RUNTIME)
	annotation Annotation2 {
		Annotation3[] ann3 = #[]
	}
	
	@Target(ElementType.TYPE)
	@Active(AnnotationWithNestedAnnotationsProcessor)
	@Retention(RetentionPolicy.RUNTIME)
	annotation Annotation3 {
	}
	
	@ToString @Accessors
	static class Annotation1Config {
		val Annotation2Config[] ann2Configs

		new(AnnotationReference ann) {
			ann2Configs = ann.getAnnotationArrayValue("ann2").map[new Annotation2Config(it)]
		}
	}

	@ToString @Accessors
	static class Annotation2Config {
		val Annotation3Config[] ann3Configs

		new(AnnotationReference ann) {
			ann3Configs = ann.getAnnotationArrayValue("ann3").map[new Annotation3Config(it)]
		}
	}

	@ToString @Accessors
	static class Annotation3Config {
		new(AnnotationReference ann) {
		}
	}	
}

class AnnotationWithNestedAnnotationsProcessor implements RegisterGlobalsParticipant<TypeDeclaration>, TransformationParticipant<MutableTypeDeclaration> {
	override doRegisterGlobals(List<? extends TypeDeclaration> decls, extension RegisterGlobalsContext context) {
		decls.filter[it instanceof ClassDeclaration].map[it as ClassDeclaration].forEach[doRegisterGlobals(context)]
	}

	def doRegisterGlobals(TypeDeclaration decl, extension RegisterGlobalsContext context) {
		decl.readConfig
	}

	override doTransform(List<? extends MutableTypeDeclaration> decls, extension TransformationContext context) {
		decls.filter[!(it instanceof MutableClassDeclaration)].forEach[addError('''«simpleName» is not a class''')]
		decls.filter[it instanceof MutableClassDeclaration].map[it as MutableClassDeclaration].forEach [
			doTransform(context)
		]
	}

	def doTransform(extension MutableClassDeclaration clazz, extension TransformationContext context) {
		clazz.readConfig
	}

	def static void readConfig(TypeDeclaration clazz) {
		clazz.annotations.filter[annotationTypeDeclaration.qualifiedName == Annotation1.name].forEach [
			new Annotation1Config(it)
		]
		clazz.annotations.filter[annotationTypeDeclaration.qualifiedName == Annotation2.name].forEach [
			new Annotation2Config(it)
		]
		clazz.annotations.filter[annotationTypeDeclaration.qualifiedName == Annotation3.name].forEach [
			new Annotation3Config(it)
		]
	}
}
