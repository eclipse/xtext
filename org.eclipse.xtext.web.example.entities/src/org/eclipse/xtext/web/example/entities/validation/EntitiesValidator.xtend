/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.entities.validation

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.ValidationMessageAcceptor
import org.eclipse.xtext.web.example.entities.domainmodel.Entity
import org.eclipse.xtext.web.example.entities.domainmodel.Feature
import org.eclipse.xtext.web.example.entities.domainmodel.PackageDeclaration
import org.eclipse.xtext.web.example.entities.domainmodel.Property

import static org.eclipse.xtext.web.example.entities.domainmodel.DomainmodelPackage.Literals.*
import static org.eclipse.xtext.web.example.entities.validation.IssueCodes.*

import static extension java.lang.Character.isLowerCase
import static extension java.lang.Character.isUpperCase

/**
 * This class contains custom validation rules.
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class EntitiesValidator extends AbstractEntitiesValidator {

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
}
