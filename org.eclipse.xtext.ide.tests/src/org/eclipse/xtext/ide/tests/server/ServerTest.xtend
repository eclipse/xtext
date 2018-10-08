/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import java.util.concurrent.ExecutionException
import org.eclipse.lsp4j.DidChangeWatchedFilesParams
import org.eclipse.lsp4j.FileChangeType
import org.eclipse.lsp4j.FileEvent
import org.eclipse.lsp4j.TextDocumentIdentifier
import org.eclipse.lsp4j.TextDocumentPositionParams
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException
import org.eclipse.lsp4j.jsonrpc.messages.ResponseErrorCode
import org.junit.Assert
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ServerTest extends AbstractTestLangLanguageServerTest {
    
    @Test
    def void testInitializeBuild() {
        'MyType1.testlang'.writeFile('''
            type Test {
                string foo
            }
        ''')
    	initialize
    	assertTrue(diagnostics.entrySet.join(','), diagnostics.values.head.empty)
    }
    
    @Test
    def void testInitializeBuildWithError() {
        'MyType1.testlang'.writeFile( '''
            type Test {
                NonExisting foo
            }
        ''')
    	initialize
    	assertEquals("Couldn't resolve reference to TypeDeclaration 'NonExisting'.", diagnostics.values.head.head?.message)
    	assertEquals(1, diagnostics.values.head.head.range.start.line)
    	assertEquals(4, diagnostics.values.head.head.range.start.character)
    	assertEquals(1, diagnostics.values.head.head.range.end.line)
    	assertEquals(15, diagnostics.values.head.head.range.end.character)
    }
    
    @Test
    def void testPublishDiagnosticsAfterInitialized() {
        'MyType1.testlang'.writeFile( '''
            type Test {
                NonExisting foo
            }
        ''')
    	initialize(null, false)
    	assertTrue("Diagnostics produced before 'initialized' was called", diagnostics.empty)
    }
    
    @Test
    def void testIncrementalBuildWithError() {
        'MyType1.testlang'.writeFile( '''
            type Test {
                NonExisting foo
            }
        ''')
    	initialize
    	assertEquals("Couldn't resolve reference to TypeDeclaration 'NonExisting'.", diagnostics.values.head.head.message)
    	
        val path = 'MyType2.testlang'.writeFile('''
            type NonExisting {
            }
        ''')
        
    	languageServer.getWorkspaceService.didChangeWatchedFiles(
    		new DidChangeWatchedFilesParams(#[new FileEvent(path, FileChangeType.Created)])
    	)
    	assertNotNull(diagnostics.get(path))
    	assertTrue(diagnostics.values.join(','), diagnostics.values.forall[empty])
    }
    
	@Test
	def void testIncrementalDeletion() {
		val path = 'MyType1.testlang'.writeFile( '''
			type Test {
			    NonExisting foo
			}
		''')
		initialize
		assertEquals("Couldn't resolve reference to TypeDeclaration 'NonExisting'.",
			diagnostics.values.head.head.message)
		'MyType1.testlang'.deleteFile
		languageServer.getWorkspaceService.didChangeWatchedFiles(
			new DidChangeWatchedFilesParams(#[new FileEvent(path, FileChangeType.Deleted)])
		)
		assertTrue(diagnostics.values.head.empty)
	}
    
    @Test
    def void testMissingInitialize() {
	    	try {
		    	languageServer.definition(new TextDocumentPositionParams => [
				textDocument = new TextDocumentIdentifier => [
					uri = 'file:/home/test/workspace/mydoc.testlang'
				]
			]).get
			Assert.fail("Expected a ResponseErrorException")
		} catch (ExecutionException exception) {
			Assert.assertEquals(ResponseErrorCode.serverNotInitialized.value, (exception.cause as ResponseErrorException).responseError.code)
		}
    }
    
}
