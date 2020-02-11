/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.IGrammarAccess
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class UniqueClassNameValidator extends AbstractDeclarativeValidator {
	
	@Inject	ResourceDescriptionsProvider resourceDescriptionsProvider
	
	@Inject IQualifiedNameProvider qualifiedNameProvider
	
	@Inject IJvmModelAssociations associations
	
	override register(EValidatorRegistrar registrar) {
		// ignore
	}
	
	@Inject
	protected def void register(EValidatorRegistrar registrar, IGrammarAccess grammarAccess) {
		val entryRule = grammarAccess.grammar.rules.head
		if (entryRule instanceof ParserRule) {
			registrar.register(entryRule.type.classifier.EPackage, this)
		}
	}
	
	@Check
	def void checkUniqueName(EObject root) {
		if (root.eContainer === null) {
			val resource = root.eResource
			if (resource.contents.head == root) {
				resource.contents.filter(JvmDeclaredType).forEach[ doCheckUniqueName ]
			}
		}
	}
	
	protected def void doCheckUniqueName(JvmDeclaredType type) {
		if (type.eContainer === null) { // only check top-level types
			val name = qualifiedNameProvider.getFullyQualifiedName(type)
			if (name !== null) {
				doCheckUniqueName(name, type)
			}
		}
	}
	
	protected def doCheckUniqueName(QualifiedName name, JvmDeclaredType type) {
		val index = resourceDescriptionsProvider.getResourceDescriptions(type.eResource)
		val others = index.getExportedObjects(TypesPackage.Literals.JVM_DECLARED_TYPE, name, false)
		return checkUniqueInIndex(type, others)
	}
	
	protected def checkUniqueInIndex(JvmDeclaredType type, Iterable<IEObjectDescription> descriptions) {
		val resourceURIs = descriptions.map[EObjectURI.trimFragment].toSet
		if (resourceURIs.size > 1) {
			addIssue(type, resourceURIs.filter[it != type.eResource.URI].head.lastSegment)
			return false
		} else {
			// There is more than one description in one single file -> local duplication
			if(descriptions.size > 1){
				addIssue(type)
				return false
			}
		}
		return true
	}
	
	/**
	 * Marks a type as already defined.
	 * @since 2.15
	 */
	protected def void addIssue(JvmDeclaredType type){
		addIssue(type, null)
	}
	
	/**
	 * Marks a type as already defined.
	 * 
	 * @param type - the type to mark already defined.
	 * @param fileName - a file where the type is already defined.
	 * 					 If fileName is null this information will not be part of the message.
	 * 
	 */
	protected def void addIssue(JvmDeclaredType type, String fileName) {
		val message = '''The type «type.simpleName» is already defined«IF fileName !== null» in «fileName»«ENDIF».'''
		val sourceElement = associations.getPrimarySourceElement(type)
		if (sourceElement === null)
			addIssue(message, type, IssueCodes.DUPLICATE_TYPE)
		else {
			val feature = sourceElement.eClass.getEStructuralFeature('name')
			addIssue(message, sourceElement, feature, IssueCodes.DUPLICATE_TYPE)
		}
	}
}
