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
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class MultiGenMMTest extends AbstractGeneratorTest {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        XtextPackage.eINSTANCE.getAbstractElement(); // initialize EPackage
        with(MultiGenMMTestLanguageStandaloneSetup.class);
    }

    public void testStuff() throws Exception {
        EObject parse = getModel("foo 'bar'");
        assertWithXtend("'SimpleTest::Foo'", "metaType.name", parse);
        assertWithXtend("'OtherTest::FooBar'", "nameRefs.first().metaType.name", parse);
    }

}
