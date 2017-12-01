/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import com.google.inject.Guice
import com.google.inject.Inject
import java.io.File
import java.io.FileWriter
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.xtext.ide.server.WorkspaceManager
import org.eclipse.xtext.util.Files
import org.eclipse.xtext.validation.Issue
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.eclipse.xtext.ide.server.UriExtensions

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class WorkspaceManagerTest {

    @Test def void testDoRead() {
        val path = 'MyType1.testlang' -> '''
            type Test {
                string foo
            }
        '''
        
        workspaceManger.doBuild(#[path], emptyList, null)
        
        val String inMemContents = '''
            type Test {
                Test foo
            }
        '''
        
        workspaceManger.didOpen(path, 1, inMemContents).build(null)
        
        Assert.assertEquals(inMemContents, workspaceManger.doRead(path, [$0.contents]))
    }

    @Inject protected WorkspaceManager workspaceManger
    @Inject extension protected UriExtensions uriExtensions

    @Before
    def void setup() {
        val injector = Guice.createInjector(new ServerModule())
        injector.injectMembers(this)
        // register notification callbacks
        // create workingdir
        root = new File("./test-data/test-project")
        if (!root.mkdirs) {
            Files.cleanFolder(root, null, true, false)
        }
        root.deleteOnExit
        workspaceManger.initialize(URI.createFileURI(root.absolutePath).withEmptyAuthority, [diagnostics.put($0, $1.toList)], null)
    }

    protected Map<URI, List<Issue>> diagnostics = newHashMap()
    protected File root

    def URI ->(String path, CharSequence contents) {
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
