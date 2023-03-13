/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import com.google.common.base.Preconditions
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference
import org.eclipse.xtend.lib.macro.declaration.Type
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceBuildContext
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceProvider
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmAnnotationValue
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1

import static extension org.eclipse.xtend.core.macro.ConditionUtils.*

/**
 * @author kosyakov - Initial contribution and API
 */
class AnnotationReferenceProviderImpl implements AnnotationReferenceProvider {

	extension CompilationUnitImpl compilationUnit

	new(CompilationUnitImpl compilationUnit) {
		this.compilationUnit = compilationUnit
	}

	override newAnnotationReference(String annotationTypeName) {
		annotationTypeName.newAnnotationReference[]
	}

	override newAnnotationReference(Type annotationTypeDelcaration) {
		annotationTypeDelcaration.newAnnotationReference []
	}

	override newAnnotationReference(Class<?> annotationClass) {
		annotationClass.newAnnotationReference []
	}

	override newAnnotationReference(AnnotationReference annotationReference) {
		annotationReference.newAnnotationReference[]
	}

	override newAnnotationReference(String annotationTypeName, Procedure1<AnnotationReferenceBuildContext> initializer) {
		checkCanceled
		Preconditions.checkArgument(annotationTypeName !== null, '''annotationTypeName cannot be null''')
		Preconditions.checkArgument(initializer !== null, '''initializer cannot be null''')
		val jvmAnnotationReference = typeReferences.findDeclaredType(annotationTypeName, xtendFile).createJvmAnnotationReference
		if (jvmAnnotationReference === null) {
			return null
		}
		val buildContext = new AnnotationReferenceBuildContextImpl => [
			delegate = jvmAnnotationReference
			it.compilationUnit = this.compilationUnit
		]
		initializer.apply(buildContext)
		jvmAnnotationReference.toAnnotationReference
	}

	override newAnnotationReference(Type annotationTypeDelcaration, Procedure1<AnnotationReferenceBuildContext> initializer) {
		checkCanceled
		Preconditions.checkArgument(annotationTypeDelcaration !== null, '''annotationTypeDelcaration cannot be null''')
		Preconditions.checkArgument(initializer !== null, '''initializer cannot be null''')
		val type = switch annotationTypeDelcaration {
			JvmAnnotationTypeDeclarationImpl: {
				annotationTypeDelcaration.delegate
			}
			XtendAnnotationTypeDeclarationImpl: {
				jvmModelAssociations.getInferredType(annotationTypeDelcaration.delegate)
			}
			default : {
				throw new IllegalArgumentException("couldn't construct type reference for type " + annotationTypeDelcaration)
			}
		}
		if (type instanceof JvmAnnotationType) {
			val newJvmAnnotationReference = type.createJvmAnnotationReference
			val buildContext = new AnnotationReferenceBuildContextImpl => [
				delegate = newJvmAnnotationReference
				it.compilationUnit = this.compilationUnit
			]
			initializer.apply(buildContext)
			return newJvmAnnotationReference.toAnnotationReference
		}
		null
	}

	override newAnnotationReference(Class<?> annotationClass, Procedure1<AnnotationReferenceBuildContext> initializer) {
		Preconditions.checkArgument(annotationClass !== null, '''annotationClass cannot be null''')
		annotationClass.name.newAnnotationReference(initializer)
	}

	override newAnnotationReference(AnnotationReference annotationReference, Procedure1<AnnotationReferenceBuildContext> initializer) {
		checkCanceled
		Preconditions.checkArgument(annotationReference !== null, '''annotationReference cannot be null''')
		Preconditions.checkArgument(initializer !== null, '''initializer cannot be null''')
		if (annotationReference instanceof JvmAnnotationReferenceImpl) {
			val baseJvmAnnotationReference = annotationReference.delegate
			baseJvmAnnotationReference.notRemoved("annotationReference")
			val newJvmAnnotationReference = baseJvmAnnotationReference.annotation.createJvmAnnotationReference
			val buildContext = new AnnotationReferenceBuildContextImpl => [
				delegate = newJvmAnnotationReference
				it.compilationUnit = this.compilationUnit
			]
			for (valueName : baseJvmAnnotationReference.getExplicitValues.map[valueName ?: "value"]) {
				val value = annotationReference.getValue(valueName)
				buildContext.set(valueName, value)
			}
			initializer.apply(buildContext)
			return newJvmAnnotationReference.toAnnotationReference
		}
		null
	}
	
	protected def isArrayOfAnnotations(JvmAnnotationValue annotationValue) {
		val returnType = annotationValue.operation.returnType
		if (returnType instanceof JvmGenericArrayTypeReference) {
			return returnType.componentType.type instanceof JvmAnnotationType
		}
		return false
	}

	protected def createJvmAnnotationReference(JvmType type) {
		switch type {
			JvmAnnotationType:
				TypesFactory.eINSTANCE.createJvmAnnotationReference => [
					annotation = type
				]
			default:
				null
		}
	}

}
