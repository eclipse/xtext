/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.Inject
import java.io.File
import java.io.FileWriter
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.ide.server.IWorkspaceConfigFactory
import org.eclipse.xtext.ide.server.MultiProjectWorkspaceConfigFactory
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.xtext.ide.server.WorkspaceManager
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.Files
import org.eclipse.xtext.util.Modules2
import org.eclipse.xtext.validation.Issue
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class MultiProjectTest {
    
    File project0
    File project1
    Map<URI, List<Issue>> diagnostics = newHashMap
    
    @Inject WorkspaceManager workspaceManager
    
    @Test
    def void testCrossProjectLink() {
        val foo = createFile(project0, 'Foo.testlang', '''
            type Foo {
                Bar bar
            }
        ''')
        val bar = createFile(project1, 'Bar.testlang', '''
            type Bar {
            }
        ''')
        workspaceManager.doBuild(#[foo, bar], emptyList, CancelIndicator.NullImpl)
        assertEquals(2, diagnostics.size)
        assertEquals(1, diagnostics.get(foo).size)
        assertEquals(Diagnostic.LINKING_DIAGNOSTIC, diagnostics.get(foo).head.code)
        assertTrue(diagnostics.get(bar).empty)
        
        // add a dependency from project0 to project1
        diagnostics.clear
        workspaceManager.getProjectManager(project0.name).projectDescription.dependencies += project1.name
        workspaceManager.doBuild(#[foo, bar], emptyList, CancelIndicator.NullImpl)
        assertEquals(2, diagnostics.size)
        assertTrue(diagnostics.get(foo).empty)
        assertTrue(diagnostics.get(bar).empty)
    }
    
    @Before
    def void setup() {
        val injector = Guice.createInjector(Modules2.mixin(new ServerModule, new AbstractModule() {
            override protected configure() {
                bind(IWorkspaceConfigFactory).to(MultiProjectWorkspaceConfigFactory)
            }
        }))
        injector.injectMembers(this)
        val workspaceRoot = getRoot("test-data")
        project0 = new File(workspaceRoot, "test-project0")
        project1 = new File(workspaceRoot, "test-project1")
        project0.mkdir
        project1.mkdir
        workspaceManager.initialize(URI.createFileURI(workspaceRoot.absolutePath), [diagnostics.put($0, $1.toList)], null)
    }
    
    protected def getRoot(String path) {
        val root = new File(path)
        if (!root.mkdirs) {
            Files.cleanFolder(root, null, true, false)
        }
        root.deleteOnExit
        root       
    }
    
    def URI createFile(File root, String path, CharSequence contents) {
        val file = new File(root, path)
        file.parentFile.mkdirs
        file.createNewFile
        new FileWriter(file) => [
            write(contents.toString)
            close
        ]
        return URI.createFileURI(file.absolutePath)
    }
    
}
