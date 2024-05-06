/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.example.entities.validation;

import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.web.example.entities.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.web.example.entities.domainmodel.Entity;
import org.eclipse.xtext.web.example.entities.domainmodel.Feature;
import org.eclipse.xtext.web.example.entities.domainmodel.PackageDeclaration;
import org.eclipse.xtext.xbase.validation.JvmGenericTypeValidator;

/**
 * This class contains custom validation rules.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@ComposedChecks(validators = JvmGenericTypeValidator.class)
public class EntitiesValidator extends AbstractEntitiesValidator {

	@Check
	public void checkTypeNameStartsWithCapital(Entity entity) {
		if (!Character.isUpperCase(entity.getName().charAt(0))) {
			warning("Name should start with a capital", DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.INVALID_TYPE_NAME, entity.getName());
		}
	}

	@Check
	public void checkFeatureNameStartsWithLowercase(Feature feature) {
		if (!Character.isLowerCase(feature.getName().charAt(0))) {
			warning("Name should start with a lowercase", DomainmodelPackage.Literals.FEATURE__NAME,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.INVALID_FEATURE_NAME, feature.getName());
		}
	}

	@Check
	public void checkPackage(PackageDeclaration packages) {
		if (Strings.isEmpty(packages.getName())) {
			error("Name cannot be empty", DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME);
		}
		if ("java".equals(packages.getName())) {
			error("Invalid package name", DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME);
		}
	}

}
