/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.entities.formatting2

import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.web.example.entities.domainmodel.AbstractElement
import org.eclipse.xtext.web.example.entities.domainmodel.Entities
import org.eclipse.xtext.web.example.entities.domainmodel.Entity
import org.eclipse.xtext.web.example.entities.domainmodel.Feature
import org.eclipse.xtext.web.example.entities.domainmodel.Operation
import org.eclipse.xtext.web.example.entities.domainmodel.PackageDeclaration
import org.eclipse.xtext.web.example.entities.domainmodel.Property
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter

import static org.eclipse.xtext.web.example.entities.domainmodel.DomainmodelPackage.Literals.*

class EntitiesFormatter extends XbaseFormatter {

	def dispatch void format(Entities entities, extension IFormattableDocument document) {
		entities.prepend[setNewLines(0, 0, 1); noSpace].append[newLine]
		format(entities.importSection, document)
		for (AbstractElement element : entities.elements) {
			format(element, document)
		}
	}

	def dispatch void format(PackageDeclaration pkg, extension IFormattableDocument document) {
		val open = pkg.regionFor.keyword("{")
		val close = pkg.regionFor.keyword("}")
		pkg.regionFor.feature(ABSTRACT_ELEMENT__NAME).surround[oneSpace]
		open.append[newLine]
		interior(open, close)[indent]
		for (AbstractElement element : pkg.elements) {
			element.format
			element.append[setNewLines(1, 1, 2)]
		}
	}

	def dispatch void format(Entity entity, extension IFormattableDocument document) {
		val open = entity.regionFor.keyword("{")
		val close = entity.regionFor.keyword("}")
		entity.regionFor.feature(ABSTRACT_ELEMENT__NAME).surround[oneSpace]
		entity.superType.surround[oneSpace]
		open.append[newLine]
		interior(open, close)[indent]
		format(entity.superType, document)
		for (Feature feature : entity.features) {
			feature.format
			feature.append[setNewLines(1, 1, 2)]
		}
	}

	def dispatch void format(Property property, extension IFormattableDocument document) {
		property.regionFor.keyword(":").surround[noSpace]
		property.type.format
	}

	def dispatch void format(Operation operation, extension IFormattableDocument document) {
		operation.regionFor.keyword("op").append[oneSpace]
		operation.regionFor.keyword("(").surround[noSpace]
		if (!operation.params.isEmpty) {
			for (comma : operation.regionFor.keywords(","))
				comma.prepend[noSpace].append[oneSpace]
			for (params : operation.params)
				params.format
			operation.regionFor.keyword(")").prepend[noSpace]
		}
		if (operation.type !== null) {
			operation.regionFor.keyword(")").append[noSpace]
			operation.type.prepend[noSpace].append[oneSpace]
			operation.type.format
		} else {
			operation.regionFor.keyword(")").append[oneSpace]
		}
		operation.body.format
	}
}
