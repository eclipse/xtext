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

	public final static SimpleAttributeResolver<EObject, String> IMPORT_RESOLVER = SimpleAttributeResolver.newResolver(String.class, "importURI");
	
	private SimpleAttributeResolver<EObject, String> resolver;

	public ImportUriValidator() {
		resolver = IMPORT_RESOLVER;
	}
	
	public ImportUriValidator(SimpleAttributeResolver<EObject, String> resolver) {
		this.resolver = resolver;
	}

	@Check(value=CheckType.FAST)
	public void checkImportUriIsValid(EObject object) {
		String importURI = resolver.apply(object);
		if (importURI != null && !ImportUriUtil.isValid(object, importURI)) {
			error("Imported resource could not be found.", resolver.getAttribute(object).getFeatureID());
		}
	}

}
