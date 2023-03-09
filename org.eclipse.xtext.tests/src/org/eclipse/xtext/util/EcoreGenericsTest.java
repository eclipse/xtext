/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.xtext.util.genericTest.GenericTestPackage;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EcoreGenericsTest extends Assert {

	@Test public void testReferenceType() throws Exception {
		EcoreGenericsUtil ecoreGenericsUtil = new EcoreGenericsUtil();
		EClassifier referenceType = ecoreGenericsUtil.getReferenceType(GenericTestPackage.Literals.A__SOME_REFERENCE,
				GenericTestPackage.Literals.D);
		assertEquals(GenericTestPackage.Literals.SOME_TYPE, referenceType);
		referenceType = ecoreGenericsUtil.getReferenceType(GenericTestPackage.Literals.A__SOME_REFERENCE1,
				GenericTestPackage.Literals.D);
		assertEquals(GenericTestPackage.Literals.SOME_TYPE, referenceType);
		referenceType = ecoreGenericsUtil.getReferenceType(GenericTestPackage.Literals.B__OTHER_REFERENCE,
				GenericTestPackage.Literals.D);
		assertEquals(GenericTestPackage.Literals.OTHER_TYPE, referenceType);
		referenceType = ecoreGenericsUtil.getReferenceType(GenericTestPackage.Literals.B__OTHER_REFERENCE1,
				GenericTestPackage.Literals.D);
		assertEquals(GenericTestPackage.Literals.A, referenceType);
	}

}
