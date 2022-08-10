/**
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.example.entities.formatting2;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.web.example.entities.domainmodel.AbstractElement;
import org.eclipse.xtext.web.example.entities.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.web.example.entities.domainmodel.Entities;
import org.eclipse.xtext.web.example.entities.domainmodel.Entity;
import org.eclipse.xtext.web.example.entities.domainmodel.Feature;
import org.eclipse.xtext.web.example.entities.domainmodel.Operation;
import org.eclipse.xtext.web.example.entities.domainmodel.PackageDeclaration;
import org.eclipse.xtext.web.example.entities.domainmodel.Property;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter;
import org.eclipse.xtext.xbase.lib.Extension;

public class EntitiesFormatter extends XbaseFormatter {
	protected void _format(Entities entities, @Extension IFormattableDocument document) {
		document.append(document.prepend(entities, (IHiddenRegionFormatter it) -> {
			it.setNewLines(0, 0, 1);
			it.noSpace();
		}), IHiddenRegionFormatter::newLine);
		format(entities.getImportSection(), document);
		for (AbstractElement element : entities.getElements()) {
			format(element, document);
		}
	}

	protected void _format(PackageDeclaration pkg, @Extension IFormattableDocument document) {
		ISemanticRegion open = textRegionExtensions.regionFor(pkg).keyword("{");
		ISemanticRegion close = textRegionExtensions.regionFor(pkg).keyword("}");
		document.surround(
				textRegionExtensions.regionFor(pkg).feature(DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME),
				IHiddenRegionFormatter::oneSpace);
		document.append(open, IHiddenRegionFormatter::newLine);
		document.interior(open, close, IHiddenRegionFormatter::indent);
		for (AbstractElement element : pkg.getElements()) {
			document.format(element);
			document.append(element, (IHiddenRegionFormatter it) -> it.setNewLines(1, 1, 2));
		}
	}

	protected void _format(Entity entity, IFormattableDocument document) {
		ISemanticRegion open = textRegionExtensions.regionFor(entity).keyword("{");
		ISemanticRegion close = textRegionExtensions.regionFor(entity).keyword("}");
		document.surround(
				textRegionExtensions.regionFor(entity).feature(DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME),
				IHiddenRegionFormatter::oneSpace);
		document.surround(entity.getSuperType(), IHiddenRegionFormatter::oneSpace);
		document.append(open, IHiddenRegionFormatter::newLine);
		document.interior(open, close, IHiddenRegionFormatter::indent);
		this.format(entity.getSuperType(), document);
		for (Feature feature : entity.getFeatures()) {
			document.format(feature);
			document.append(feature, (IHiddenRegionFormatter it) -> it.setNewLines(1, 1, 2));
		}
	}

	protected void _format(Property property, IFormattableDocument document) {
		document.surround(textRegionExtensions.regionFor(property).keyword(":"), IHiddenRegionFormatter::noSpace);
		document.format(property.getType());
	}

	protected void _format(Operation operation, IFormattableDocument document) {
		document.append(textRegionExtensions.regionFor(operation).keyword("op"), IHiddenRegionFormatter::oneSpace);
		document.surround(textRegionExtensions.regionFor(operation).keyword("("), IHiddenRegionFormatter::noSpace);
		if (!operation.getParams().isEmpty()) {
			for (ISemanticRegion comma : textRegionExtensions.regionFor(operation).keywords(",")) {
				document.append(document.prepend(comma, IHiddenRegionFormatter::noSpace),
						IHiddenRegionFormatter::oneSpace);
			}
			for (JvmFormalParameter params : operation.getParams()) {
				document.format(params);
			}
			document.prepend(textRegionExtensions.regionFor(operation).keyword(")"), IHiddenRegionFormatter::noSpace);
		}
		if (operation.getType() != null) {
			document.append(textRegionExtensions.regionFor(operation).keyword(")"), IHiddenRegionFormatter::noSpace);
			document.append(document.prepend(operation.getType(), IHiddenRegionFormatter::noSpace),
					IHiddenRegionFormatter::oneSpace);
			document.format(operation.getType());
		} else {
			document.append(textRegionExtensions.regionFor(operation).keyword(")"), IHiddenRegionFormatter::oneSpace);
		}
		document.format(operation.getBody());
	}

	public void format(Object object, IFormattableDocument document) {
		if (object instanceof Entity) {
			_format((Entity) object, document);
			return;
		} else if (object instanceof Operation) {
			_format((Operation) object, document);
			return;
		} else if (object instanceof PackageDeclaration) {
			_format((PackageDeclaration) object, document);
			return;
		} else if (object instanceof Property) {
			_format((Property) object, document);
			return;
		} else {
			super.format(object, document);
		}
	}
}
