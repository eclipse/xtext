/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.formatting2;

import org.eclipse.xtext.example.domainmodel.domainmodel.AbstractElement
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration
import org.eclipse.xtext.example.domainmodel.domainmodel.Property
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter

import static org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage.Literals.*

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
class DomainmodelFormatter extends XbaseFormatter {


	def dispatch void format(DomainModel domainmodel, extension IFormattableDocument document) {
		domainmodel.prepend[setNewLines(0, 0, 1); noSpace].append[newLine]
		format(domainmodel.getImportSection(), document);
		for (AbstractElement element : domainmodel.getElements()) {
			format(element, document);
		}
	}

	def dispatch void format(PackageDeclaration packagedeclaration, extension IFormattableDocument document) {
		packagedeclaration.regionForFeature(ABSTRACT_ELEMENT__NAME).surround[oneSpace]
		packagedeclaration.regionForKeyword("{").append[newLine; increaseIndentation]
		for (AbstractElement element : packagedeclaration.elements) {
			format(element, document);
			element.append[setNewLines(1, 1, 2)]
		}
		packagedeclaration.regionForKeyword("}").prepend[decreaseIndentation]
	}

	def dispatch void format(Entity entity, extension IFormattableDocument document) {
		entity.regionForFeature(ABSTRACT_ELEMENT__NAME).surround[oneSpace]
		entity.superType.surround[oneSpace]
		entity.regionForKeyword("{").append[newLine; increaseIndentation]
		format(entity.getSuperType(), document);
		for (Feature feature : entity.features) {
			format(feature, document);
			feature.append[setNewLines(1, 1, 2)]
		}
		entity.regionForKeyword("}").prepend[decreaseIndentation]
	}

	def dispatch void format(Property property, extension IFormattableDocument document) {
		property.regionForKeyword(":").surround[noSpace]
		format(property.type, document);
	}

	def dispatch void format(Operation operation, extension IFormattableDocument document) {
		operation.regionForKeyword("op").append[oneSpace]
		operation.regionForKeyword("(").surround[noSpace]
		if (!operation.params.isEmpty) {
			for (comma : operation.regionsForKeywords(","))
				comma.prepend[noSpace].append[oneSpace]
			for (params : operation.params)
				format(params, document);
			operation.regionForKeyword(")").prepend[noSpace]
		}
		if (operation.type != null) {
			operation.regionForKeyword(")").append[noSpace]
			operation.type.prepend[noSpace].append[oneSpace]
			format(operation.type, document);
		} else {
			operation.regionForKeyword(")").append[oneSpace]
		}
		format(operation.body, document);
	}
}
