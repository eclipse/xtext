/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.quickfix

import javax.inject.Inject
import org.eclipse.xtend.ide.buildpath.Junit4LibClasspathAdder
import org.eclipse.xtend.ide.buildpath.Junit5LibClasspathAdder
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider
import org.eclipse.xtend.ide.tests.buildpath.AbstractJunitLibClasspathAdderTestCase
import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author vivien.jovet - Initial contribution and API
 */
@InjectWith(XtendIDEInjectorProvider)
@RunWith(XtextRunner)
class AddJunitLibToClasspathQuickfixTest extends AbstractJunitLibClasspathAdderTestCase {

    @Inject extension QuickfixTestBuilder builder
    
    @Before
    override void setUpProject() throws Exception {
        closeAllEditors(false)
        super.setUpProject
    }

    @Test
    def void addJUnit4LibToPluginProjectClasspath() {
        val content = '''
            import org.junit|.Test
            
            class FooTest {
                @Test
                def test() {}
            }
        '''
        create('FooTest.xtend', content)
            .assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
            .assertResolutionLabels('Add JUnit 4 lib to classpath')
            .assertModelAfterQuickfix(content.replace('|', ''))
        assertRequireBundles(#[Junit4LibClasspathAdder.BUNDLE_ID])
    }

    @Test
    def void addJUnit4LibToProjectClasspath() {
        removePluginNature
        val content = '''
            import org.junit|.Test
            
            class FooTest {
                @Test
                def test() {}
            }
        '''
        create('FooTest.xtend', content)
            .assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
            .assertResolutionLabels('Add JUnit 4 lib to classpath')
            .assertModelAfterQuickfix(content.replace('|', ''))
        assertClasspath(
            'classpath should contain a JUnit 4 container entry', 
            Junit4LibClasspathAdder.JUNIT4_LIBRARY_PATH
        )
    }

    @Test
    def void addJUnit5LibToPluginProjectClasspath() {
        val content = '''
            import org.junit.jupiter.api|.Test
            
            class FooTest2 {
                @Test
                def test() {}
            }
        '''
        create('FooTest2.xtend', content)
            .assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
            .assertResolutionLabels('Add JUnit 5 lib to classpath')
            .assertModelAfterQuickfix(content.replace('|', ''))
       assertRequireBundles(Junit5LibClasspathAdder.BUNDLE_IDS)
    }
    
    
    @Test
    def void addJUnit5LibToProjectClasspath() {
        removePluginNature
        val content = '''
            import org.junit.jupiter.api|.Test
            
            class FooTest {
                @Test
                def test() {}
            }
        '''
        create('FooTest.xtend', content)
            .assertIssueCodes(Diagnostic.LINKING_DIAGNOSTIC)
            .assertResolutionLabels('Add JUnit 5 lib to classpath')
            .assertModelAfterQuickfix(content.replace('|', ''))
        assertClasspath(
            'classpath should contain a JUnit 5 container entry', 
            Junit5LibClasspathAdder.JUNIT5_LIBRARY_PATH
        )
    }

}
