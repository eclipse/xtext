/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.entities.validation;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.web.example.entities.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.web.example.entities.domainmodel.Entity;
import org.eclipse.xtext.web.example.entities.domainmodel.Feature;
import org.eclipse.xtext.web.example.entities.domainmodel.Operation;
import org.eclipse.xtext.web.example.entities.domainmodel.PackageDeclaration;
import org.eclipse.xtext.web.example.entities.domainmodel.Property;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * This class contains custom validation rules.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class EntitiesValidator extends AbstractEntitiesValidator {
	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	@Inject
	private OverrideHelper overrideHelper;

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

	@Check
	public void checkPropertyNamesAreUnique(Entity entity) {
		Multimap<String, Property> name2properties = HashMultimap.create();
		IterableExtensions
				.filter(Iterables.filter(entity.getFeatures(), Property.class),
						(f) -> !StringExtensions.isNullOrEmpty(f.getName()))
				.forEach((p) -> name2properties.put(p.getName(), p));
		name2properties.asMap().values().forEach((properties) -> {
			if (properties.size() > 1) {
				properties.forEach((p) -> {
					error("Duplicate property " + p.getName(), p, DomainmodelPackage.Literals.FEATURE__NAME,
							IssueCodes.DUPLICATE_PROPERTY);
				});
			}
		});
	}

	@Check
	public void checkOperationNamesAreUnique(Entity entity) {
		JvmGenericType inferredJavaClass = IterableExtensions
				.head(Iterables.filter(jvmModelAssociations.getJvmElements(entity), JvmGenericType.class));
		Multimap<String, JvmOperation> signature2Declarations = HashMultimap.create();
		overrideHelper.getResolvedFeatures(inferredJavaClass).getDeclaredOperations().forEach((it) -> {
			signature2Declarations.put(it.getResolvedErasureSignature(), it.getDeclaration());
		});
		signature2Declarations.asMap().values().forEach((jvmOperations) -> {
			if (jvmOperations.size() > 1) {
				Iterables
						.filter(IterableExtensions.map(jvmOperations,
								(op) -> jvmModelAssociations.getPrimarySourceElement(op)), Operation.class)
						.forEach((op) -> {
							error("Duplicate operation " + op.getName(), op, DomainmodelPackage.Literals.FEATURE__NAME, IssueCodes.DUPLICATE_OPERATION);
						});
			}
		});
	}
}
