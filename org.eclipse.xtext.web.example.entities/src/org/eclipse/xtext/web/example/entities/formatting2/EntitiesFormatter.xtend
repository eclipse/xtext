/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.entities.formatting2

import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.web.example.entities.domainmodel.AbstractElement
import org.eclipse.xtext.web.example.entities.domainmodel.Entities
import org.eclipse.xtext.web.example.entities.domainmodel.PackageDeclaration
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter

class EntitiesFormatter extends XbaseFormatter {
	
	def dispatch void format(Entities entities, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		entities.getImportSection.format;
		for (AbstractElement elements : entities.getElements()) {
			elements.format;
		}
	}

	def dispatch void format(PackageDeclaration packageDeclaration, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (AbstractElement elements : packageDeclaration.getElements()) {
			elements.format;
		}
	}
	
	// TODO: implement for Entity, Property, Operation
}
