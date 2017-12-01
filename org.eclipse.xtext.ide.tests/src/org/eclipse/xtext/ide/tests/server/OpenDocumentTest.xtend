/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.lsp4j.DidChangeTextDocumentParams
import org.eclipse.lsp4j.DidChangeWatchedFilesParams
import org.eclipse.lsp4j.FileChangeType
import org.eclipse.lsp4j.FileEvent
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextDocumentContentChangeEvent
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class OpenDocumentTest extends AbstractTestLangLanguageServerTest {
    
    @Test
    def void testOpenedDocumentShadowsPersistedFile() {
        val firstFile = 'MyType1.testlang'.writeFile( '''
            type Test {
                NonExisting foo
            }
        ''')
        initialize
        
        assertEquals("Couldn't resolve reference to TypeDeclaration 'NonExisting'.", diagnostics.get(firstFile).head.message)
        
        val path = 'MyType2.testlang'.writeFile( '''
            type Foo {
            }
        ''')
        languageServer.getWorkspaceService.didChangeWatchedFiles(
			new DidChangeWatchedFilesParams(#[
				new FileEvent(path, FileChangeType.Created)
			])
		)
        
        // still erroneous
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
        val firstFile = 'MyType1.testlang'.writeFile( '''
            type Test {
                NonExisting foo
            }
        ''')
        initialize
        
        assertEquals("Couldn't resolve reference to TypeDeclaration 'NonExisting'.", diagnostics.get(firstFile).head.message)
        
        open(firstFile, '''
			type Test {
			    NonExisting foo
			}
		''')
        assertEquals("Couldn't resolve reference to TypeDeclaration 'NonExisting'.", diagnostics.get(firstFile).head.message)
        
        languageServer.didChange(new DidChangeTextDocumentParams => [
	        	textDocument = new VersionedTextDocumentIdentifier => [
	        		uri = firstFile
	        		version = 2
	        	]
	        	contentChanges = #[
	        		new TextDocumentContentChangeEvent => [
						range = new Range(new Position(1, 4), new Position(1, 15))
						text = "Test"
	        		]
			]
		])
        assertNull(diagnostics.get(firstFile).head)
    }

    @Test
    def void testDidClose() {
        val fileURI = 'Foo.testlang'.writeFile('')
        initialize
        
        val referencingFileURI = 'Bar.testlang'.virtualFile
        referencingFileURI.open('''
            type Bar {
                Foo foo
            }
        ''')
        assertFalse(diagnostics.get(referencingFileURI).empty)
        
        
        fileURI.open('type Foo {}')
        assertTrue(diagnostics.get(referencingFileURI).empty)
        
        close(fileURI);
        assertFalse(diagnostics.get(referencingFileURI).empty)
    }

    @Test
    def void testDidCloseInMemory() {
        initialize

        val fileURI = 'Foo.testlang'.virtualFile 
        fileURI.open('type Foo {}')
        
        val referencingFileURI = 'Bar.testlang'.virtualFile
        referencingFileURI.open('''
            type Bar {
                Foo foo
            }
        ''') 
        assertTrue(diagnostics.get(referencingFileURI).empty)
        
        close(fileURI);
        assertFalse(diagnostics.get(referencingFileURI).empty)
    }

    @Test
    def void testInMemory_GH_456() {
        initialize
        val uri = 'inmemory:/foo/bar.testlang';
        open(uri, '''
            type Foo { }
        ''');
        assertNotNull('''Diagnostics could be empty but never null.''', diagnostics.get(uri));
    }

}