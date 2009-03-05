/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.crossref.impl.ImportUriValidator;
import org.eclipse.xtext.example.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.validator.AbstractDeclarativeValidator;
import org.eclipse.xtext.validator.ComposedChecks;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ComposedChecks(validators= {ImportUriValidator.class})
public class DomainModelValidator extends AbstractDeclarativeValidator {

	@Inject
	public DomainModelValidator(EValidator.Registry registry) {
		registry.put(DomainmodelPackage.eINSTANCE, this);
	}

}
