/*******************************************************************************
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.validation

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration
import org.eclipse.xtext.example.domainmodel.domainmodel.Property
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.ValidationMessageAcceptor
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.typesystem.^override.OverrideHelper

import static org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage.Literals.*
import static org.eclipse.xtext.example.domainmodel.validation.IssueCodes.*

import static extension java.lang.Character.isLowerCase
import static extension java.lang.Character.isUpperCase

/**
 * This class contains custom validation rules.
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class DomainmodelValidator extends AbstractDomainmodelValidator {

	@Inject extension IJvmModelAssociations
	@Inject extension OverrideHelper

	@Check def void checkTypeNameStartsWithCapital(Entity entity) {
		if (!entity.name.charAt(0).isUpperCase) {
			warning("Name should start with a capital", ABSTRACT_ELEMENT__NAME,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_TYPE_NAME, entity.name)
		}
	}

	@Check def void checkFeatureNameStartsWithLowercase(Feature feature) {
		if (!feature.name.charAt(0).isLowerCase) {
			warning("Name should start with a lowercase", FEATURE__NAME,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_FEATURE_NAME, feature.name)
		}
	}

	@Check def void checkPackage(PackageDeclaration packages) {
		if (Strings.isEmpty(packages.name)) {
			error("Name cannot be empty", ABSTRACT_ELEMENT__NAME)
		}
		if (packages.name == "java") {
			error("Invalid package name", ABSTRACT_ELEMENT__NAME)
		}
	}

	@Check def void checkPropertyNamesAreUnique(Entity entity) {
		val Multimap<String, Property> name2properties = HashMultimap.create

		entity.features.filter(Property).filter[!name.nullOrEmpty].forEach[
			name2properties.put(name, it)
		]

		name2properties.asMap.values.forEach[properties|
			if (properties.size > 1) {
				properties.forEach[
					error("Duplicate property " + name, it, FEATURE__NAME, DUPLICATE_PROPERTY)
				]
			}
		]
	}

	@Check def void checkOperationNamesAreUnique(Entity entity) {
		// takes into consideration overloading and type erasure
		val inferredJavaClass = entity.jvmElements.filter(JvmGenericType).head
		val methods = inferredJavaClass.getResolvedFeatures.declaredOperations
		val Multimap<String, JvmOperation> signature2Declarations = HashMultimap.create

		methods.forEach[
			signature2Declarations.put(resolvedErasureSignature, declaration)
		]

		signature2Declarations.asMap.values.forEach[jvmOperations|
			if (jvmOperations.size > 1) {
				val operations = jvmOperations.map[primarySourceElement].filter(Operation)
				operations.forEach[
					error("Duplicate operation " + name, it, FEATURE__NAME, DUPLICATE_OPERATION)
				]
			}
		]
	}
}
