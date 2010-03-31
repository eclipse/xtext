/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.xtext.util.genericTest.GenericTestPackage;

/**
 * @author koehnlein - Initial contribution and API
 */
public class EcoreGenericsTest extends TestCase {

	public void testReferenceType() throws Exception {
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
