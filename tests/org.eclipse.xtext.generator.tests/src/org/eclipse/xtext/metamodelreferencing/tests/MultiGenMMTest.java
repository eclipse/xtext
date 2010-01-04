/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class MultiGenMMTest extends AbstractGeneratorTest {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        with(new XtextStandaloneSetup());
        
        with(new MultiGenMMTestLanguageStandaloneSetup());
    }

    public void testStuff() throws Exception {
        EObject parse = getModel("foo 'bar'");
        assertWithXtend("'org::eclipse::xtext::metamodelreferencing::tests::simpleTest::impl::FooImpl'", "metaType.name", parse);
        assertWithXtend("'org::eclipse::xtext::metamodelreferencing::tests::otherTest::impl::FooBarImpl'", "nameRefs.first().metaType.name", parse);
    }

}
