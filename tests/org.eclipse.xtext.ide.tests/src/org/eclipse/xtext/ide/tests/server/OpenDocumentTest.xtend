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
class OpenDocumentTest extends AbstractLanguageServerTest {
    
    @Test
    def void testOpenedDocumentShadowsPersistedFile() {
        val firstFile = 'MyType1.testlang' -> '''
            type Test {
                NonExisting foo
            }
        '''
        initialize
        
        assertEquals("Couldn't resolve reference to TypeDeclaration 'NonExisting'.", diagnostics.get(firstFile).head.message)
        
        val path = 'MyType2.testlang' -> '''
            type Foo {
            }
        '''
        languageServer.getWorkspaceService.didChangeWatchedFiles(
			#[
				newFileEvent(path, FileEvent.TYPE_CREATED)
			].newDidChangeWatchedFilesParams
		)
        
        // still errorneous
        assertEquals("Couldn't resolve reference to TypeDeclaration 'NonExisting'.", diagnostics.get(firstFile).head.message)
        
        // let's open the document with a different content
        open(path, '''
			type NonExisting {
			}
		''')
        assertNull(diagnostics.get(firstFile).head)
        
        // let's close again
        close(path)
        assertEquals("Couldn't resolve reference to TypeDeclaration 'NonExisting'.", diagnostics.get(firstFile).head.message)
    }
    
    
     @Test
    def void testDidChange() {
        val firstFile = 'MyType1.testlang' -> '''
            type Test {
                NonExisting foo
            }
        '''
        initialize
        
        assertEquals("Couldn't resolve reference to TypeDeclaration 'NonExisting'.", diagnostics.get(firstFile).head.message)
        
        open(firstFile, '''
			type Test {
			    NonExisting foo
			}
		''')
        assertEquals("Couldn't resolve reference to TypeDeclaration 'NonExisting'.", diagnostics.get(firstFile).head.message)
        
        languageServer.didChange(newDidChangeTextDocumentParamsImpl(firstFile, 2, #[
			newTextDocumentContentChangeEvent(newRange(newPosition(1, 4), newPosition(1, 15)), null, "Test")
		]))
        assertNull(diagnostics.get(firstFile).head)
    }
}