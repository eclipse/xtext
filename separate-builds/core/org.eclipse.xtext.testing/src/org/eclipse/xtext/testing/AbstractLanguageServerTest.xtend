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
import io.typefox.lsapi.Hover
import io.typefox.lsapi.InitializeParamsImpl
import io.typefox.lsapi.InitializeResult
import io.typefox.lsapi.Location
import io.typefox.lsapi.MarkedString
import io.typefox.lsapi.Position
import io.typefox.lsapi.PublishDiagnosticsParams
import io.typefox.lsapi.Range
import io.typefox.lsapi.ReferenceContextImpl
import io.typefox.lsapi.SymbolInformation
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
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.LanguageInfo
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

import static extension io.typefox.lsapi.util.LsapiFactories.*

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
        val params = newInitializeParams(1, rootPath.toString)
        initializer?.apply(params)
        return languageServer.initialize(params).get
    }

    protected def void open(String fileUri, String model) {
        open(fileUri, languageInfo.languageName, model)
    }

    protected def void open(String fileUri, String langaugeId, String model) {
        languageServer.didOpen(newDidOpenTextDocumentParams(fileUri, langaugeId, 1, model))
    }

    protected def void close(String fileUri) {
        languageServer.didClose(newDidCloseTextDocumentParams(fileUri))
    }

    def String ->(String path, CharSequence contents) {
        val file = new File(root, path)
        file.parentFile.mkdirs
        file.createNewFile

        val writer = new FileWriter(file)
        writer.write(contents.toString)
        writer.close

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
            kind: «kind»
            location: «location.toExpectation»
            «IF !container.nullOrEmpty»
                container: "«container»"
            «ENDIF»
        }
    '''

    protected def dispatch String toExpectation(CompletionItem it) '''
        «label»«IF !detail.nullOrEmpty» («detail»)«ENDIF»«IF insertText != label» -> «insertText»«ENDIF»
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

    protected def void testCompletion((TestCompletionConfiguration)=>void configurator) {
        val extension configuration = new TestCompletionConfiguration
        configuration.filePath = 'MyModel.' + fileExtension
        configurator.apply(configuration)

        val fileUri = filePath -> model

        initialize
        open(fileUri, model)

        val completionItems = languageServer.completion(newTextDocumentPositionParams(fileUri, line, column))

        val actualCompletionItems = completionItems.get.items.toExpectation
        assertEquals(expectedCompletionItems, actualCompletionItems)
    }
    
    protected def void testDefinition((DefinitionTestConfiguration)=>void configurator) {
        val extension configuration = new DefinitionTestConfiguration
        configuration.filePath = 'MyModel.' + fileExtension
        configurator.apply(configuration)

        val fileUri = filePath -> model

        initialize
        open(fileUri, model)

        val definitions = languageServer.definition(newTextDocumentPositionParams(fileUri, line, column))
        val actualDefinitions = definitions.get.toExpectation
        assertEquals(expectedDefinitions, actualDefinitions)
    }

    protected def void testHover((HoverTestConfiguration)=>void configurator) {
        val extension configuration = new HoverTestConfiguration
        configuration.filePath = 'MyModel.' + fileExtension
        configurator.apply(configuration)

        val fileUri = filePath -> model

        initialize
        open(fileUri, model)

        val hover = languageServer.hover(newTextDocumentPositionParams(fileUri, line, column))
        val actualHover = hover.get.toExpectation
        assertEquals(expectedHover, actualHover)
    }

    protected def void testDocumentSymbol((DocumentSymbolConfiguraiton)=>void configurator) {
        val extension configuration = new DocumentSymbolConfiguraiton
        configuration.filePath = 'MyModel.' + fileExtension
        configurator.apply(configuration)
        val fileUri = filePath -> model

        initialize
        open(fileUri, model)

        val symbols = languageServer.documentSymbol(fileUri.newDocumentSymbolParams)
        val String actualSymbols = symbols.get.toExpectation
        assertEquals(expectedSymbols, actualSymbols)
    }

    protected def void testSymbol((WorkspaceSymbolConfiguraiton)=>void configurator) {
        val extension configuration = new WorkspaceSymbolConfiguraiton
        configuration.filePath = 'MyModel.' + fileExtension
        configurator.apply(configuration)
        val fileUri = filePath -> model

        initialize
        open(fileUri, model)

        val symbols = languageServer.symbol(query.newWorkspaceSymbolParams).get
        val String actualSymbols = symbols.toExpectation
        assertEquals(expectedSymbols, actualSymbols)
    }

    protected def void testReferences((ReferenceTestConfiguration)=>void configurator) {
        val extension configuration = new ReferenceTestConfiguration
        configuration.filePath = 'MyModel.' + fileExtension
        configurator.apply(configuration)

        val fileUri = filePath -> model

        initialize
        open(fileUri, model)

        val referenceContext = new ReferenceContextImpl
        referenceContext.includeDeclaration = includeDeclaration
        val definitions = languageServer.references(newReferenceParams(fileUri, line, column, referenceContext))
        val actualDefinitions = definitions.get.toExpectation
        assertEquals(expectedReferences, actualDefinitions)
    }
    
    def void assertEquals(String expected, String actual) {
        Assert.assertEquals(expected.replace('\t','    '), actual)
    }

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
    String model = ''
    String filePath
}
