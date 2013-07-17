/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.codebuilder

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.jdt.annotation.NonNullByDefault
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmUnknownTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer

/** 
 * @author Jan Koehnlein
 */
@NonNullByDefault
abstract class AbstractCodeBuilder implements ICodeBuilder {

	@Property Object ownerSource
	@Property JvmDeclaredType owner
	@Property JvmVisibility visibility
	@Property EObject context
	
	@Inject extension IJavaElementFinder
	
	override isValid() {
		val javaElement = owner.findElementFor
		return (javaElement == null || !javaElement.readOnly) 
			&& ownerSource != null && owner != null && context != null
	}
	
	override getPreview() {
		val appendable = new StringBuilderBasedAppendable
		appendable.append('...').newLine.build.newLine.append('...')
		appendable.toString
	}
	
	def protected appendVisibility(IAppendable appendable, JvmVisibility visibility, JvmVisibility skippableDefault) {
		appendable.append(
			switch visibility {
				case skippableDefault: ''
				case JvmVisibility.PRIVATE: 'private '
				case JvmVisibility.PROTECTED: 'protected '
				case JvmVisibility.PUBLIC: 'public '
				default: ''
			})
	}

	def protected appendType(IAppendable appendable, JvmTypeReference typeRef, String surrogate) {
		if (typeRef == null) {
			appendable.append(surrogate)
		} else {
			typeReferenceSerializer.serialize(typeRef, context, appendable)
		}
		appendable
	}
	
	def protected appendTypeParameters(IAppendable appendable, List<JvmTypeParameter> typeParameters) {
		val iterator = typeParameters.iterator
		if(iterator.hasNext()) {
			appendable.append("<")
			do {
				val typeParameter = iterator.next()
				if (typeParameter != null) {
					appendable.append(typeParameter.name)
					if(typeParameter.constraints != null) {
						// TODO
					}
				}
				if (iterator.hasNext())
					appendable.append(",")
			} while (iterator.hasNext())
			appendable.append("> ")
		}
		appendable
	}
	
	def protected TypeReferenceSerializer getTypeReferenceSerializer()
	
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

