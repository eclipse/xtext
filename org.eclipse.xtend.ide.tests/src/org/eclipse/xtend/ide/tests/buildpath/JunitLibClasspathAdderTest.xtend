/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.buildpath

import javax.inject.Inject
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend.ide.buildpath.Junit4LibClasspathAdder
import org.eclipse.xtend.ide.buildpath.Junit5LibClasspathAdder
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author vivien.jovet - Initial contribution and API
 */
@InjectWith(XtendIDEInjectorProvider)
@RunWith(XtextRunner)
class JunitLibClasspathAdderTest extends AbstractJunitLibClasspathAdderTestCase {

    @Inject Junit4LibClasspathAdder junit4LibAdder

    @Inject Junit5LibClasspathAdder junit5LibAdder

    @Test
    def void addJUnit4LibToPluginProjectClasspath() {
        junit4LibAdder.addLibsToClasspath(JavaCore.create(project), new NullProgressMonitor)
        JavaCore.create(project).rawClasspath.forEach[println(path)]
        assertRequireBundles(#[Junit4LibClasspathAdder.BUNDLE_ID])
    }

    @Test
    def void addJUnit4LibToProjectClasspath() {
        removePluginNature
        junit4LibAdder.addLibsToClasspath(JavaCore.create(project), new NullProgressMonitor)
        assertClasspath(
            'classpath should contain a JUnit 4 container entry',
            Junit4LibClasspathAdder.JUNIT4_LIBRARY_PATH
        )
    }

    @Test
    def void addJUnit5LibToPluginProjectClasspath() {
        junit5LibAdder.addLibsToClasspath(JavaCore.create(project), new NullProgressMonitor)
        assertRequireBundles(Junit5LibClasspathAdder.BUNDLE_IDS)
    }

    @Test
    def void addJUnit5LibToProjectClasspath() {
        removePluginNature
        junit5LibAdder.addLibsToClasspath(JavaCore.create(project), new NullProgressMonitor)
        assertClasspath(
            'classpath should contain a JUnit 5 container entry',
            Junit5LibClasspathAdder.JUNIT5_LIBRARY_PATH
        )
    }

}
