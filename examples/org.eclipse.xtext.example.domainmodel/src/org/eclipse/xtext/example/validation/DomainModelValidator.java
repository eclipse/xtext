/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.validation;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.example.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ImportUriValidator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ComposedChecks(validators= {ImportUriValidator.class})
public class DomainModelValidator extends AbstractDeclarativeValidator {

	@Override
	protected List<? extends EPackage> getEPackages() {
		return Collections.singletonList(DomainmodelPackage.eINSTANCE);
	}

}
