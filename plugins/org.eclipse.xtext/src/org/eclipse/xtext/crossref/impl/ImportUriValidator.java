/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validator.AbstractDeclarativeValidator;
import org.eclipse.xtext.validator.Check;
import org.eclipse.xtext.validator.CheckType;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ImportUriValidator extends AbstractDeclarativeValidator {

	public static final String IMPORT_URI = "importURI";

	private final SimpleAttributeResolver<String> resolver;

	public ImportUriValidator() {
		resolver = SimpleAttributeResolver.newResolver(String.class, IMPORT_URI);
	}

	@Check(value=CheckType.FAST)
	public void checkImportUriIsValid(EObject object) {
		String importURI = resolver.getValue(object);
		if (importURI != null && !ImportUriUtil.isValid(object, importURI)) {
			error("Imported resource could not be found.", resolver.getAttribute(object).getFeatureID());
		}
	}

}
