/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.enumrules;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.enumrules.enums.EnumsPackage;
import org.eclipse.xtext.tests.AbstractXtextTests;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractEnumRulesTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		EnumsPackage pack = EnumsPackage.eINSTANCE;
		EPackage.Registry.INSTANCE.put(pack.getNsURI(), pack);
	}
	
}
