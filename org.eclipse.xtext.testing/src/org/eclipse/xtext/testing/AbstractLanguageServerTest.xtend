/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testing

import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.Inject
import io.typefox.lsapi.CompletionItem
import io.typefox.lsapi.Diagnostic
import io.typefox.lsapi.FileChangeType
import io.typefox.lsapi.Hover
import io.typefox.lsapi.InitializeResult
import io.typefox.lsapi.Location
import io.typefox.lsapi.MarkedString
import io.typefox.lsapi.Position
import io.typefox.lsapi.PublishDiagnosticsParams
import io.typefox.lsapi.Range
import io.typefox.lsapi.SignatureHelp
import io.typefox.lsapi.SymbolInformation
import io.typefox.lsapi.TextEdit
import io.typefox.lsapi.builders.DidChangeWatchedFilesParamsBuilder
import io.typefox.lsapi.builders.DidCloseTextDocumentParamsBuilder
import io.typefox.lsapi.builders.DidOpenTextDocumentParamsBuilder
import io.typefox.lsapi.builders.DocumentFormattingParamsBuilder
import io.typefox.lsapi.builders.DocumentRangeFormattingParamsBuilder
import io.typefox.lsapi.builders.InitializeParamsBuilder
import io.typefox.lsapi.builders.ReferenceParamsBuilder
import io.typefox.lsapi.builders.TextDocumentPositionParamsBuilder
import io.typefox.lsapi.impl.DocumentSymbolParamsImpl
import io.typefox.lsapi.impl.InitializeParamsImpl
import io.typefox.lsapi.impl.PositionImpl
import io.typefox.lsapi.impl.RangeImpl
import io.typefox.lsapi.impl.TextDocumentIdentifierImpl
import io.typefox.lsapi.impl.WorkspaceSymbolParamsImpl
import java.io.File
import java.io.FileWriter
import java.net.URI
import java.nio.file.Path
import java.nio.file.Paths
import java.util.List
import java.util.Map
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.LanguageInfo
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.LanguageServerImpl
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.xtext.ide.server.UriExtensions
import org.eclipse.xtext.ide.server.concurrent.RequestManager
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.Files
import org.eclipse.xtext.util.Modules2
import org.junit.Assert
import org.junit.Before
import io.typefox.lsapi.DocumentHighlight
import io.typefox.lsapi.DocumentHighlightKind

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@FinalFieldsConstructor
abstract class AbstractLanguageServerTest implements Consumer<PublishDiagnosticsParams> {

    @Accessors
    protected val String fileExtension

    @Before
    def void setup() {
        val module = Modules2.mixin(new ServerModule, new AbstractModule() {

            override protected configure() {
                bind(RequestManager).toInstance(new RequestManager() {

                    override runWrite((CancelIndicator)=>void writeRequest, CancelIndicator cancelIndicator) {
                        writeRequest.apply(cancelIndicator)
                        return CompletableFuture.completedFuture(null)
                    }

                    override <V> runRead((CancelIndicator)=>V readRequest, CancelIndicator cancelIndicator) {
                        return CompletableFuture.completedFuture(readRequest.apply(cancelIndicator))
                    }

                })
            }

        })

        val injector = Guice.createInjector(module)
        injector.injectMembers(this)

        val resourceServiceProvider = resourceServerProviderRegistry.extensionToFactoryMap.get(fileExtension)
        if (resourceServiceProvider instanceof IResourceServiceProvider)
            languageInfo = resourceServiceProvider.get(LanguageInfo)

        // register notification callbacks
        languageServer.getTextDocumentService().onPublishDiagnostics(this)

        // create workingdir
        root = new File("./test-data/test-project")
        if (!root.mkdirs) {
            Files.cleanFolder(root, null, true, false)
        }
        root.deleteOnExit
    }

    @Inject
    protected IResourceServiceProvider.Registry resourceServerProviderRegistry

    @Inject extension UriExtensions
    @Inject protected LanguageServerImpl languageServer
    protected Map<String, List<? extends Diagnostic>> diagnostics = newHashMap()

    protected File root
    protected LanguageInfo languageInfo

    protected def Path getRootPath() {
        root.toPath().toAbsolutePath().normalize()
    }

    protected def Path relativize(String uri) {
        val path = Paths.get(new URI(uri))
        rootPath.relativize(path)
    }

    protected def InitializeResult initialize() {
        return initialize(null)
    }

    protected def InitializeResult initialize((InitializeParamsImpl)=>void initializer) {
        val params = new InitializeParamsBuilder[
        	processId(1)
        	rootPath(rootPath.toString)
    	].build
        initializer?.apply(params as InitializeParamsImpl)
        return languageServer.initialize(params).get
    }

    protected def void open(String fileUri, String model) {
        open(fileUri, languageInfo.languageName, model)
    }

    protected def void open(String fileUri, String langaugeId, String model) {
        languageServer.didOpen(new DidOpenTextDocumentParamsBuilder[
        	uri(fileUri)
        	textDocument[
        		uri(fileUri)
        		languageId(langaugeId)
        		version(1)
        		text(model)
    		]
        ].build)
    }
    
    protected def void didCreateWatchedFiles(String ... fileUris) {
        languageServer.didChangeWatchedFiles(new DidChangeWatchedFilesParamsBuilder[
            for (fileUri : fileUris) {
                change[
                    uri(fileUri)
                    it.type(FileChangeType.Created)    
                ]
            }
        ].build)
    }

    protected def void close(String fileUri) {
        languageServer.didClose(new DidCloseTextDocumentParamsBuilder[
        	textDocument(fileUri)
        ].build)
    }

    def String writeFile(String path, CharSequence contents) {
        val file = new File(root, path)
        file.parentFile.mkdirs
        file.createNewFile

        val writer = new FileWriter(file)
        writer.write(contents.toString)
        writer.close

        return file.toURI.normalize.toPath
    }
    
    def String getVirtualFile(String path) {
        val file = new File(root, path)
        return file.toURI.normalize.toPath
    }

    override accept(PublishDiagnosticsParams t) {
        diagnostics.put(t.uri, t.diagnostics)
    }

    protected def dispatch String toExpectation(List<?> elements) '''
        «FOR element : elements»
            «element.toExpectation»
        «ENDFOR»
    '''

    protected def dispatch String toExpectation(Void it) { '' }

    protected def dispatch String toExpectation(Location it) '''«uri.relativize» «range.toExpectation»'''

    protected def dispatch String toExpectation(Range it) '''[«start.toExpectation» .. «end.toExpectation»]'''

    protected def dispatch String toExpectation(Position it) '''[«line», «character»]'''

    protected def dispatch String toExpectation(SymbolInformation it) '''
        symbol "«name»" {
            kind: «kind.value»
            location: «location.toExpectation»
            «IF !containerName.nullOrEmpty»
                container: "«containerName»"
            «ENDIF»
        }
    '''

    protected def dispatch String toExpectation(
        CompletionItem it) '''
        «label»«IF !detail.nullOrEmpty» («detail»)«ENDIF»«IF textEdit !== null» -> «textEdit.toExpectation»«ELSEIF insertText !== null && insertText != label» -> «insertText»«ENDIF»
    '''

    protected dispatch def String toExpectation(TextEdit it) '''
        «newText» «range.toExpectation»
    '''

    protected dispatch def String toExpectation(Hover it) '''
        «range.toExpectation»
        «FOR content : contents»
            «content.toExpectation»
        «ENDFOR»
    '''

    protected dispatch def String toExpectation(
        MarkedString it
    ) '''«IF !language.nullOrEmpty»«language» -> «ENDIF»«value»'''
    
    protected dispatch def String toExpectation(SignatureHelp it) {
        if (signatures.size === 0) {
            Assert.assertNull('''Signature index is expected to be null when no signatures are available. Was: «activeSignature».''', activeSignature);
            return '<empty>';
        }
        Assert.assertNotNull('Active signature index must not be null when signatures are available.', activeSignature);
        val param = if (activeParameter === null) '<empty>' else signatures.get(activeSignature).parameters.get(activeParameter).label;
        '''«signatures.map[label].join(' | ')» | «param»''';
    }
    
    protected dispatch def String toExpectation(DocumentHighlight it) {
    	val rangeString = '''«IF range === null»[NaN, NaN]:[NaN, NaN]«ELSE»«range.toExpectation»«ENDIF»''';
    	'''«IF kind === null»NaN«ELSE»«kind.toExpectation»«ENDIF» «rangeString»'''
    }
    
    protected dispatch def String toExpectation(DocumentHighlightKind it) {
    	it.toString.substring(0, 1).toUpperCase
    }

    protected def void testCompletion((TestCompletionConfiguration)=>void configurator) {
        val extension configuration = new TestCompletionConfiguration
        configuration.filePath = 'MyModel.' + fileExtension
        configurator.apply(configuration)

        val filePath = initializeContext(configuration).uri

        val completionItems = languageServer.completion(new TextDocumentPositionParamsBuilder[
        	textDocument(filePath)
        	position(line, column)
        ].build)
        
        // assert ordered by sortText
        val list = completionItems.get
        Assert.assertEquals(list.items, list.items.sortBy[sortText].toList)

        val actualCompletionItems = list.items.toExpectation
        assertEquals(expectedCompletionItems, actualCompletionItems)
    }
    
    protected def FileInfo initializeContext(TextDocumentConfiguration configuration) {
        initialize
        // create files on disk and notify languageServer
        if (!configuration.filesInScope.isEmpty) {
            val createdFiles = configuration.filesInScope.entrySet.map[key.writeFile(value.toString)]
            didCreateWatchedFiles(createdFiles)
            
            if (configuration.model === null) {
                return new FileInfo(createdFiles.head, configuration.filesInScope.entrySet.head.value.toString)
            }
        }
        Assert.assertNotNull(configuration.model)
        val filePath = configuration.filePath.writeFile(configuration.model)
        open(filePath, configuration.model)
        return new FileInfo(filePath, configuration.model)
    }

    protected def void testDefinition((DefinitionTestConfiguration)=>void configurator) {
        val extension configuration = new DefinitionTestConfiguration
        configuration.filePath = 'MyModel.' + fileExtension
        configurator.apply(configuration)

        val fileUri = initializeContext(configuration).uri

        val definitions = languageServer.definition(new TextDocumentPositionParamsBuilder[
        	textDocument(fileUri)
        	position(line, column)
        ].build)
        val actualDefinitions = definitions.get.toExpectation
        assertEquals(expectedDefinitions, actualDefinitions)
    }

    protected def void testHover((HoverTestConfiguration)=>void configurator) {
        val extension configuration = new HoverTestConfiguration
        configuration.filePath = 'MyModel.' + fileExtension
        configurator.apply(configuration)

        val fileUri = initializeContext(configuration).uri
        
        val hover = languageServer.hover(new TextDocumentPositionParamsBuilder[
        	textDocument(fileUri)
        	position(line, column)
        ].build)
        val actualHover = hover.get.toExpectation
        assertEquals(expectedHover, actualHover)
    }
    
    protected def testSignatureHelp((SignatureHelpConfiguration) => void configurator) {
        val extension configuration = new SignatureHelpConfiguration;
        configuration.filePath = 'MyModel.' + fileExtension;
        configurator.apply(configuration);
        
        val fileUri = initializeContext(configuration).uri
        
        val signatureHelps = languageServer.signatureHelp(new TextDocumentPositionParamsBuilder[
            textDocument(fileUri);
            position(line, column);
        ].build);
        
        val actualSignatureHelp = signatureHelps.get.toExpectation
        assertEquals(expectedSignatureHelp.trim, actualSignatureHelp.trim)
    }
    
    protected def testDocumentHighlight((DocumentHighlightConfiguration) => void configurator) {
    	val extension configuration = new DocumentHighlightConfiguration => [
    		filePath = '''MyModel.«fileExtension»''';
    	];
    	configurator.apply(configuration);
    	
    	val fileUri = initializeContext(configuration).uri;
    	val highlights = languageServer.documentHighlight(new TextDocumentPositionParamsBuilder[
    		textDocument(fileUri);
    		position(line, column);
    	].build);
    	
    	val actualDocumentHighlight = highlights.get.map[toExpectation].join(' | ');
    	assertEquals(expectedDocumentHighlight, actualDocumentHighlight);
    }

    protected def void testDocumentSymbol((DocumentSymbolConfiguraiton)=>void configurator) {
        val extension configuration = new DocumentSymbolConfiguraiton
        configuration.filePath = 'MyModel.' + fileExtension
        configurator.apply(configuration)
        
        val fileUri = initializeContext(configuration).uri

        val symbols = languageServer.documentSymbol(new DocumentSymbolParamsImpl(new TextDocumentIdentifierImpl(fileUri)))
        val String actualSymbols = symbols.get.toExpectation
        assertEquals(expectedSymbols, actualSymbols)
    }

    protected def void testSymbol((WorkspaceSymbolConfiguraiton)=>void configurator) {
        val extension configuration = new WorkspaceSymbolConfiguraiton
        configuration.filePath = 'MyModel.' + fileExtension
        configurator.apply(configuration)
        
        initializeContext(configuration)

        val symbols = languageServer.symbol(new WorkspaceSymbolParamsImpl(query)).get
        val String actualSymbols = symbols.toExpectation
        assertEquals(expectedSymbols, actualSymbols)
    }

    protected def void testReferences((ReferenceTestConfiguration)=>void configurator) {
        val extension configuration = new ReferenceTestConfiguration
        configuration.filePath = 'MyModel.' + fileExtension
        configurator.apply(configuration)

        val fileUri = initializeContext(configuration).uri

        val definitions = languageServer.references(new ReferenceParamsBuilder[
        	textDocument(fileUri)
        	position(line, column)
        	context(includeDeclaration)
    	].build)
        val actualDefinitions = definitions.get.toExpectation
        assertEquals(expectedReferences, actualDefinitions)
    }

    def void assertEquals(String expected, String actual) {
        Assert.assertEquals(expected.replace('\t', '    '), actual.replace('\t', '    '))
    }


    protected def testFormatting((FormattingConfiguration)=>void configurator) {
        val extension configuration = new FormattingConfiguration
        configuration.filePath = 'MyModel.' + fileExtension
        configurator.apply(configuration)

        val fileInfo = initializeContext(configuration)
        
        val changes = languageServer.formatting(new DocumentFormattingParamsBuilder [
            textDocument(fileInfo.uri)
        ].build)
        val result = new Document(1, fileInfo.contents).applyChanges(<TextEdit>newArrayList(changes.get()).reverse)
        assertEquals(configuration.expectedText, result.contents)

    }

    protected def testRangeFormatting((RangeFormattingConfiguration)=>void configurator) {
        val extension configuration = new RangeFormattingConfiguration
        configuration.filePath = 'MyModel.' + fileExtension
        configurator.apply(configuration)
        
        val fileInfo = initializeContext(configuration)
        
        val changes = languageServer.rangeFormatting(new DocumentRangeFormattingParamsBuilder [
            textDocument(fileInfo.uri)
            range(configuration.range)
        ].build)
        val result = new Document(1, fileInfo.contents).applyChanges(<TextEdit>newArrayList(changes.get()).reverse)
        assertEquals(configuration.expectedText, result.contents)
    }

}

@Data class FileInfo {
    String uri
    String contents
}

@Accessors
class TestCompletionConfiguration extends TextDocumentPositionConfiguration {
    String expectedCompletionItems = ''
}

@Accessors
class DefinitionTestConfiguration extends TextDocumentPositionConfiguration {
    String expectedDefinitions = ''
}

@Accessors
class HoverTestConfiguration extends TextDocumentPositionConfiguration {
    String expectedHover = ''
}

@Accessors
class SignatureHelpConfiguration extends TextDocumentPositionConfiguration {
    String expectedSignatureHelp = ''
}

@Accessors
class DocumentHighlightConfiguration extends TextDocumentPositionConfiguration {
	String expectedDocumentHighlight = ''
}

@Accessors
class DocumentSymbolConfiguraiton extends TextDocumentConfiguration {
    String expectedSymbols = ''
}

@Accessors
class ReferenceTestConfiguration extends TextDocumentPositionConfiguration {
    boolean includeDeclaration = false
    String expectedReferences = ''
}

@Accessors
class WorkspaceSymbolConfiguraiton extends TextDocumentConfiguration {
    String query = ''
    String expectedSymbols = ''
}

@Accessors
class TextDocumentPositionConfiguration extends TextDocumentConfiguration {
    int line = 0
    int column = 0
}

@Accessors
class TextDocumentConfiguration {
    Map<String,CharSequence> filesInScope = emptyMap
    String model
    String filePath
}

@Accessors
class FormattingConfiguration extends TextDocumentConfiguration {
    String expectedText = ''
}

@Accessors
class RangeFormattingConfiguration extends FormattingConfiguration {
    Range range = new RangeImpl=>[
        start = new PositionImpl(0,0)
        end = new PositionImpl(0,1)
    ]
}
