/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmUnknownTypeReference
import org.eclipse.xtext.common.types.JvmUpperBound
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.compiler.ISourceAppender
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices

/** 
 * @author Jan Koehnlein
 */
abstract class AbstractCodeBuilder implements ICodeBuilder {

	@Accessors Object ownerSource
	@Accessors JvmDeclaredType owner
	@Accessors JvmVisibility visibility
	@Accessors EObject context
	
	@Inject extension IJavaElementFinder
	
	@Inject CommonTypeComputationServices services
	
	override isValid() {
		val javaElement = owner.findElementFor
		return (javaElement === null || !javaElement.readOnly) 
			&& ownerSource !== null && owner !== null && context !== null
	}
	
	override getPreview() {
		val appendable = new StringBuilderBasedAppendable
		appendable.append('...').newLine.build.newLine.append('...')
		appendable.toString
	}
	
	def protected appendVisibility(ISourceAppender appendable, JvmVisibility visibility, JvmVisibility skippableDefault) {
		appendable.append(
			switch visibility {
				case skippableDefault: ''
				case JvmVisibility.PRIVATE: 'private '
				case JvmVisibility.PROTECTED: 'protected '
				case JvmVisibility.PUBLIC: 'public '
				default: ''
			})
	}
	
	def protected <T extends EObject> T findByFragment(XtextResource resource, T object) {
		val myResource = object.eResource
		if (myResource == resource) {
			return object
		}
		val fragment = myResource.getURIFragment(object)
		val result = resource.getEObject(fragment) as T
		return result
	}

	def protected appendType(ISourceAppender appendable, LightweightTypeReference typeRef, String surrogate) {
		if (typeRef === null) {
			appendable.append(surrogate)
		} else {
			appendable.append(typeRef)
		}
		appendable
	}
	
	def protected appendTypeParameters(ISourceAppender appendable, List<JvmTypeParameter> typeParameters) {
		val iterator = typeParameters.iterator
		if(iterator.hasNext()) {
			appendable.append("<")
			do {
				val typeParameter = iterator.next()
				appendable.append(typeParameter.name)
				val upperBounds = typeParameter.constraints.filter(JvmUpperBound).filter[typeReference.identifier != 'java.lang.Object']
				if(!upperBounds.empty) {
					appendable.append(" extends ");
					var isFirst = true
					val owner = new StandardTypeReferenceOwner(services, context)
					for(upperBound: upperBounds) {
						if(!isFirst)
							appendable.append(" & ")
						isFirst = false
						appendable.appendType(owner.toLightweightTypeReference(upperBound.typeReference), "Object")
					}
				}
				if (iterator.hasNext())
					appendable.append(",")
			} while (iterator.hasNext())
			appendable.append("> ")
		}
		appendable
	}
	
	def protected getIdentifierOrObject(JvmTypeReference typeReference) {
		switch(typeReference) {
			JvmUnknownTypeReference: "java.lang.Object"
			default: typeReference.identifier
		}
	}

	def protected isInterface(JvmType t) {
		switch t {
			JvmGenericType: t.interface
			default: false
		}
	}
	
}

