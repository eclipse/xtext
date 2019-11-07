/**
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.validation;

import java.util.function.Consumer;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.example.domainmodel.jvmmodel.DomainmodelJvmModelHelper;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class DomainmodelValidator extends AbstractDomainmodelValidator {
	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	@Inject
	private DomainmodelJvmModelHelper domainmodelJvmModelHelper;

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
	public void checkPackage(PackageDeclaration pack) {
		if (Strings.isEmpty(pack.getName())) {
			error("Name cannot be empty", DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME);
		}
		if ("java".equals(pack.getName())) {
			error("Invalid package name", DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME);
		}
	}

	@Check
	public void checkPropertyNamesAreUnique(Entity entity) {
		Multimap<String, Property> name2properties = HashMultimap.create();
		IterableExtensions	
				.filter(Iterables.filter(entity.getFeatures(), Property.class),
						(it) -> !StringExtensions.isNullOrEmpty(it.getName()))
				.forEach((it) -> name2properties.put(it.getName(), it));
		name2properties.asMap().values().forEach((properties) -> {
			if (properties.size() > 1) {
				properties.forEach((it) -> {
					error("Duplicate property " + it.getName(), it, DomainmodelPackage.Literals.FEATURE__NAME,
							IssueCodes.DUPLICATE_PROPERTY);
				});
			}
		});
	}

	@Check
	public void checkOperationNamesAreUnique(Entity entity) {
		JvmGenericType inferredJavaClass = IterableExtensions
				.head(Iterables.filter(jvmModelAssociations.getJvmElements(entity), JvmGenericType.class));
		domainmodelJvmModelHelper.handleDuplicateJvmOperations(inferredJavaClass, (jvmOperations) -> {
			Iterable<Operation> operations = Iterables.filter(
					IterableExtensions.map(jvmOperations, (it) -> jvmModelAssociations.getPrimarySourceElement(it)),
					Operation.class);
			operations.forEach((Consumer<Operation>) (it) -> {
				error("Duplicate operation " + it.getName(), it, DomainmodelPackage.Literals.FEATURE__NAME, IssueCodes.DUPLICATE_OPERATION);
			});
		});
	}
}
