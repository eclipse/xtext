/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.Foo;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

public class MetamodelRefTest extends AbstractXtextTests {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        with(new MetamodelRefTestLanguageStandaloneSetup());
    }

    @Test public void testStuff() throws Exception {
        Foo parse = (Foo) getModelAndExpect("foo bar", 1);
        assertEquals(1, parse.getNameRefs().size());
    }

}
