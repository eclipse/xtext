/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import io.typefox.lsapi.FileEvent
import org.junit.Test

import static org.junit.Assert.*

import static extension io.typefox.lsapi.util.LsapiFactories.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ServerTest extends AbstractTestLangLanguageServerTest {
    
    @Test
    def void testInitializeBuild() {
        'MyType1.testlang' -> '''
            type Test {
                string foo
            }
        '''
    	initialize
    	assertTrue(diagnostics.entrySet.join(','), diagnostics.values.head.empty)
    }
    
    @Test
    def void testInitializeBuildWithError() {
        'MyType1.testlang' -> '''
            type Test {
                NonExisting foo
            }
        '''
    	initialize
    	assertEquals("Couldn't resolve reference to TypeDeclaration 'NonExisting'.", diagnostics.values.head.head?.message)
    	assertEquals(1, diagnostics.values.head.head.range.start.line)
    	assertEquals(4, diagnostics.values.head.head.range.start.character)
    	assertEquals(1, diagnostics.values.head.head.range.end.line)
    	assertEquals(15, diagnostics.values.head.head.range.end.character)
    }
    
    @Test
    def void testIncrementalBuildWithError() {
        'MyType1.testlang' -> '''
            type Test {
                NonExisting foo
            }
        '''
    	initialize
    	assertEquals("Couldn't resolve reference to TypeDeclaration 'NonExisting'.", diagnostics.values.head.head.message)
    	
        val path = 'MyType2.testlang' -> '''
            type NonExisting {
            }
        '''
        
    	languageServer.getWorkspaceService.didChangeWatchedFiles(
    		#[newFileEvent(path, FileEvent.TYPE_CREATED)].newDidChangeWatchedFilesParams
    	)
    	assertNotNull(diagnostics.get(path))
    	assertTrue(diagnostics.values.join(','), diagnostics.values.forall[empty])
    }
    
    
    
}