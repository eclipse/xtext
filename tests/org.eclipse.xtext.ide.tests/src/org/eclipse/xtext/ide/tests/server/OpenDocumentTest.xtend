/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import io.typefox.lsapi.DidChangeTextDocumentParamsImpl
import io.typefox.lsapi.DidChangeWatchedFilesParamsImpl
import io.typefox.lsapi.DidCloseTextDocumentParamsImpl
import io.typefox.lsapi.DidOpenTextDocumentParamsImpl
import io.typefox.lsapi.FileEvent
import io.typefox.lsapi.FileEventImpl
import io.typefox.lsapi.PositionImpl
import io.typefox.lsapi.RangeImpl
import io.typefox.lsapi.TextDocumentContentChangeEventImpl
import io.typefox.lsapi.TextDocumentIdentifierImpl
import io.typefox.lsapi.TextDocumentItemImpl
import io.typefox.lsapi.VersionedTextDocumentIdentifierImpl
import org.junit.Test

import static org.junit.Assert.*

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
        languageServer.getWorkspaceService.didChangeWatchedFiles(new DidChangeWatchedFilesParamsImpl => [
            changes = newArrayList(new FileEventImpl => [
                uri = path
                type = FileEvent.TYPE_CREATED
            ])
        ])
        
        // still errorneous
        assertEquals("Couldn't resolve reference to TypeDeclaration 'NonExisting'.", diagnostics.get(firstFile).head.message)
        
        // let's open the document with a different content
        languageServer.didOpen(new DidOpenTextDocumentParamsImpl => [
            textDocument = new TextDocumentItemImpl => [
                uri = path
                version = 1
                text = '''
                    type NonExisting {
                    }
                '''
            ]
        ])
        assertNull(diagnostics.get(firstFile).head)
        
        // let's close again
        languageServer.didClose(new DidCloseTextDocumentParamsImpl => [
            textDocument = new TextDocumentIdentifierImpl => [
                uri = path
            ]
        ])
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
        
        languageServer.didOpen(new DidOpenTextDocumentParamsImpl => [
            textDocument = new TextDocumentItemImpl => [
                uri = firstFile
                version = 1
                text = '''
                    type Test {
                        NonExisting foo
                    }
                '''
            ]
        ])
        assertEquals("Couldn't resolve reference to TypeDeclaration 'NonExisting'.", diagnostics.get(firstFile).head.message)
        
        languageServer.didChange(new DidChangeTextDocumentParamsImpl => [
            textDocument = new VersionedTextDocumentIdentifierImpl => [
                uri = firstFile
                version = 2
            ]
            contentChanges = #[
                new TextDocumentContentChangeEventImpl => [
                    range = new RangeImpl => [
                        start = new PositionImpl => [
                            line = 1
                            character = 4
                        ]
                        end = new PositionImpl => [
                            line = 1
                            character = 15
                        ]
                    ]
                    text = "Test"
                ]
            ]
        ])
        assertNull(diagnostics.get(firstFile).head)
    }
}