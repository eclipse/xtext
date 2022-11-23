/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EValidator.Registry;
import org.eclipse.emf.ecore.impl.EValidatorRegistryImpl;
import org.eclipse.emf.ecore.util.Diagnostician;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated(forRemoval = true, since = "2.30")
public class RegisteredValidatorTester extends AbstractValidatorTester {
	public static AssertableDiagnostics validateObj(EObject obj) {
		return new RegisteredValidatorTester().validate(obj);
	}

	public RegisteredValidatorTester() {
		diagnostician = Diagnostician.INSTANCE;
	}

	public RegisteredValidatorTester(Diagnostician diagnostician) {
		this.diagnostician = diagnostician;
	}

	public RegisteredValidatorTester(EPackage pkg, EValidator val) {
		Registry reg = new EValidatorRegistryImpl();
		reg.put(pkg, val);
		this.diagnostician = new Diagnostician(reg);
	}
}
