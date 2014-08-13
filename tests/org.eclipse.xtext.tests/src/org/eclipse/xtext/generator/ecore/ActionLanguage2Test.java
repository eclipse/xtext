/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.ecore;

import static org.junit.Assert.*;

import org.eclipse.xtext.testlanguages.actionLang2.ActionLang2Factory;
import org.eclipse.xtext.testlanguages.actionLang2.ORing;
import org.junit.Test;

/**
 * @author svenefftinge - Initial contribution and API
 */
public class ActionLanguage2Test {

	/**
	 * see bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=390326
	 */
	@Test public void testCorrectReferenceType() {
		ORing oRing = ActionLang2Factory.eINSTANCE.createORing();
		ORing oRing2 = ActionLang2Factory.eINSTANCE.createORing();
		oRing.getDisjuncts().add(oRing2);
		assertSame(oRing2, oRing.getDisjuncts().get(0));
	}
}
