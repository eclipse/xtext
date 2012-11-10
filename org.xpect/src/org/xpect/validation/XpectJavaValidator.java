/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.validation;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.xpect.XpectPackage;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectJavaValidator extends AbstractXpectJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
		return Collections.<EPackage> singletonList(XpectPackage.eINSTANCE);
	}

	// @Check
	// public void checkGreetingStartsWithCapital(Greeting greeting) {
	// if (!Character.isUpperCase(greeting.getName().charAt(0))) {
	// warning("Name should start with a capital",
	// MyDslPackage.Literals.GREETING__NAME);
	// }
	// }

}
