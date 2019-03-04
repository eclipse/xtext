/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testing

import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Module
import java.io.File
import java.io.FileWriter
import java.net.URI
import java.nio.file.Path
import java.nio.file.Paths
import java.util.List
import java.util.Map
import java.util.concurrent.CompletableFuture
import org.eclipse.lsp4j.CodeAction
import org.eclipse.lsp4j.CodeActionContext
import org.eclipse.lsp4j.CodeActionParams
import org.eclipse.lsp4j.CodeLens
import org.eclipse.lsp4j.CodeLensParams
import org.eclipse.lsp4j.ColoringInformation
import org.eclipse.lsp4j.ColoringParams
import org.eclipse.lsp4j.Command
import org.eclipse.lsp4j.CompletionItem
import org.eclipse.lsp4j.CompletionList
import org.eclipse.lsp4j.CompletionParams
import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.DidChangeWatchedFilesParams
import org.eclipse.lsp4j.DidCloseTextDocumentParams
import org.eclipse.lsp4j.DidOpenTextDocumentParams
import org.eclipse.lsp4j.DocumentFormattingParams
import org.eclipse.lsp4j.DocumentHighlight
import org.eclipse.lsp4j.DocumentHighlightKind
import org.eclipse.lsp4j.DocumentRangeFormattingParams
import org.eclipse.lsp4j.DocumentSymbol
import org.eclipse.lsp4j.DocumentSymbolParams
import org.eclipse.lsp4j.FileChangeType
import org.eclipse.lsp4j.FileEvent
import org.eclipse.lsp4j.Hover
import org.eclipse.lsp4j.InitializeParams
import org.eclipse.lsp4j.InitializeResult
import org.eclipse.lsp4j.Location
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.PublishDiagnosticsParams
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.ReferenceContext
import org.eclipse.lsp4j.ReferenceParams
import org.eclipse.lsp4j.SemanticHighlightingInformation
import org.eclipse.lsp4j.SemanticHighlightingParams
import org.eclipse.lsp4j.SignatureHelp
import org.eclipse.lsp4j.SymbolInformation
import org.eclipse.lsp4j.TextDocumentIdentifier
import org.eclipse.lsp4j.TextDocumentItem
import org.eclipse.lsp4j.TextDocumentPositionParams
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.lsp4j.WorkspaceSymbolParams
import org.eclipse.lsp4j.jsonrpc.Endpoint
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.lsp4j.jsonrpc.services.ServiceEndpoints
import org.eclipse.lsp4j.services.LanguageClientExtensions
import org.eclipse.lsp4j.util.SemanticHighlightingTokens
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
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@FinalFieldsConstructor
abstract class AbstractLanguageServerTest implements Endpoint {

	@Accessors
	protected val String fileExtension

	protected static val TEST_PROJECT_PATH = "/test-data/test-project"

	@Before @BeforeEach
	def void setup() {
		val injector = Guice.createInjector(getServerModule())
		injector.injectMembers(this)

		val resourceServiceProvider = resourceServerProviderRegistry.extensionToFactoryMap.get(fileExtension)
		if (resourceServiceProvider instanceof IResourceServiceProvider)
			languageInfo = resourceServiceProvider.get(LanguageInfo)

		// register notification callbacks
		languageServer.connect(ServiceEndpoints.toServiceObject(this, LanguageClientExtensions))
		// initialize
		languageServer.supportedMethods()

		// create workingdir
		root = new File(new File("").absoluteFile, TEST_PROJECT_PATH)
	}

	@After @AfterEach
	def void cleanup() {
		if (root.exists) {
			Files.cleanFolder(root, null, true, true)
		}
	}

	protected def Module getServerModule() {
		Modules2.mixin(new ServerModule, [
			bind(RequestManager).toInstance(new RequestManager() {

				override <V> runRead((CancelIndicator)=>V request) {
					val result = new CompletableFuture()
					try {
						result.complete(request.apply [ false ])
					} catch (Throwable e) {
						result.completeExceptionally(e)
					}
					return result
				}

				override <U,V> runWrite(()=>U nonCancellable, (CancelIndicator, U)=>V request) {
					val result = new CompletableFuture()
					try {
						result.complete(request.apply([ false ], nonCancellable.apply()))
					} catch (Throwable e) {
						result.completeExceptionally(e)
					}
					return result
				}
			})
		])
	}

	@Inject
	protected IResourceServiceProvider.Registry resourceServerProviderRegistry

	@Inject extension UriExtensions
	@Inject protected LanguageServerImpl languageServer

	protected List<Pair<String, Object>> notifications = newArrayList()
	protected File root
	protected LanguageInfo languageInfo
	protected boolean hierarchicalDocumentSymbolSupport = false;

	protected def Path getTestRootPath() {
		root.toPath().toAbsolutePath().normalize()
	}

	protected def Path relativize(String uri) {
		val path = Paths.get(new URI(uri))
		testRootPath.relativize(path)
	}

	protected def InitializeResult initialize() {
		return initialize(null)
	}

	protected def InitializeResult initialize((InitializeParams)=>void initializer) {
		initialize(initializer, true)
	}
	
	protected def InitializeResult initialize((InitializeParams)=>void initializer, boolean callInitialized) {
		val params = new InitializeParams => [
			processId = 1
			rootUri = root.toURI.normalize.toUriString
		]
		initializer?.apply(params)
		hierarchicalDocumentSymbolSupport = params.capabilities?.textDocument?.documentSymbol?.
			hierarchicalDocumentSymbolSupport ?: false;
		val result = languageServer.initialize(params).get
		if(callInitialized)
			languageServer.initialized(null)
		return result
	}

	protected def void open(String fileUri, String model) {
		open(fileUri, languageInfo.languageName, model)
	}

	protected def void open(String fileUri, String langaugeId, String model) {
		languageServer.didOpen(new DidOpenTextDocumentParams => [
			textDocument = new TextDocumentItem => [
				uri = fileUri
				languageId = langaugeId
				version = 1
				text = model
			]
		])
	}

	protected def void didCreateWatchedFiles(String ... fileUris) {
		languageServer.didChangeWatchedFiles(new DidChangeWatchedFilesParams => [
			for (fileUri : fileUris) {
				changes += new FileEvent => [
					uri = fileUri
					it.type = FileChangeType.Created
				]
			}
		])
	}

	protected def void close(String fileUri) {
		languageServer.didClose(new DidCloseTextDocumentParams => [
			textDocument = new TextDocumentIdentifier(fileUri)
		])
	}

	def String writeFile(String path, CharSequence contents) {
		val file = new File(root, path)
		file.parentFile.mkdirs
		file.createNewFile

		val writer = new FileWriter(file)
		writer.write(contents.toString)
		writer.close

		return file.toURI.normalize.toUriString
	}

	def void deleteFile(String path) {
		new File(root, path).delete
	}

	def String getVirtualFile(String path) {
		val file = new File(root, path)
		return file.toURI.normalize.toUriString
	}

	protected def dispatch String toExpectation(List<?> elements) '''
		«FOR element : elements»
			«element.toExpectation»
		«ENDFOR»
	'''
	protected def dispatch String toExpectation(String it) { it }
	
	protected def dispatch String toExpectation(Integer it) { '''«it»''' }
	
	protected def dispatch String toExpectation(Void it) { '' }

	protected dispatch def String toExpectation(Either<?, ?> either) '''
		«IF either.isLeft»
		«either.getLeft.toExpectation»
		«ELSE»
		«either.getRight.toExpectation»
		«ENDIF»
	'''

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

	/**
	 * @since 2.16
	 */
	protected def dispatch String toExpectation(DocumentSymbol it) {
		Assert.assertTrue('''selectionRange must be contained in the range: «it»''', range.contains(selectionRange))
	'''
		symbol "«name»" {
		    kind: «kind.value»
		    range: «range.toExpectation»
		    selectionRange: «selectionRange.toExpectation»
		    details: «detail»
		    deprecated: «deprecated»
		    «IF !children.nullOrEmpty»
		    children: [
		    	«FOR child : children SEPARATOR'\n'»«child.toExpectation»«ENDFOR»
		    ]
		    «ENDIF»
		}'''
	}

	protected def dispatch String toExpectation(CompletionItem it) '''
		«label»«IF !detail.nullOrEmpty» («detail»)«ENDIF»«IF textEdit !== null» -> «textEdit.toExpectation»«IF !additionalTextEdits.nullOrEmpty»   + «additionalTextEdits.map[toExpectation].join('   + ')»«ENDIF»«ELSEIF insertText !== null && insertText != label» -> «insertText»«ENDIF»
	'''

	protected dispatch def String toExpectation(TextEdit it) '''
		«newText» «range.toExpectation»
	'''

	protected dispatch def String toExpectation(Hover it) '''
		«range.toExpectation»
		«contents.toExpectation»
	'''

	protected dispatch def String toExpectation(SignatureHelp it) {
		if (signatures.size === 0) {
			Assert.
				assertNull('''Signature index is expected to be null when no signatures are available. Was: «activeSignature».''',
					activeSignature);
			return '<empty>';
		}
		Assert.assertNotNull('Active signature index must not be null when signatures are available.', activeSignature);
		val param = if(activeParameter === null) '<empty>' else signatures.get(activeSignature).parameters.get(
				activeParameter).label.getLeft();
		'''«signatures.map[label].join(' | ')» | «param»''';
	}

	protected dispatch def String toExpectation(DocumentHighlight it) {
		val rangeString = '''«IF range === null»[NaN, NaN]:[NaN, NaN]«ELSE»«range.toExpectation»«ENDIF»''';
		'''«IF kind === null»NaN«ELSE»«kind.toExpectation»«ENDIF» «rangeString»'''
	}

	protected dispatch def String toExpectation(DocumentHighlightKind kind) {
		return kind.toString.substring(0, 1).toUpperCase;
	}
	
	protected dispatch def String toExpectation(Map<Object, Object> it) {
		val sb = new StringBuilder;
		entrySet.forEach[
			if (sb.length > 0) {
				sb.append('\n');
			}
			sb.append(key.toExpectation);
			sb.append(' ->');
			if (value instanceof Iterable<?>) {
				(value as Iterable<?>).forEach[
					sb.append('\n * ');
					sb.append(toExpectation);
				]
			} else {
				sb.append(' ');
				sb.append(value.toExpectation);
			}
 		];
		return sb.toString;
	}

	protected dispatch def String toExpectation(ColoringInformation it) {
		return '''«range.toExpectation» -> [«styles.join(', ')»]''';
	}

	protected dispatch def String toExpectation(Pair<SemanticHighlightingInformation, List<List<String>>> it) {
		val sb = new StringBuilder()
		val tokens = SemanticHighlightingTokens.decode(key.tokens).sort;
		for (token : tokens) {
			if (sb.length > 0) {
				sb.append(', ');
			}
			sb.append('''«token.character»:«token.length»:«value.get(token.scope)»''')
		}
		return '''«key.line» : [«sb.toString»]''';
	}

	protected dispatch def String toExpectation(CodeLens it) {
		return command.title + " " +range.toExpectation
	}

	@Accessors static class TestCodeLensConfiguration extends TextDocumentPositionConfiguration {
		String expectedCodeLensItems = ''
		(List<? extends CodeLens>)=>void assertCodeLenses = null
	}

	protected def void testCodeLens((TestCodeLensConfiguration)=>void configurator) {
		val extension configuration = new TestCodeLensConfiguration
		configuration.filePath = 'MyModel.' + fileExtension
		configurator.apply(configuration)
		val filePath = initializeContext(configuration).uri
		val codeLenses = languageServer.codeLens(new CodeLensParams=>[
			textDocument = new TextDocumentIdentifier(filePath)
		])
		val result = codeLenses.get.map[languageServer.resolveCodeLens(it).get].toList

		if (configuration.assertCodeLenses !== null) {
			configuration.assertCodeLenses.apply(result)
		} else {
			assertEquals(expectedCodeLensItems, result.toExpectation)
		}
	}

	protected dispatch def String toExpectation(Command it) '''
		command : «command»
		title : «title»
		args : 
			«arguments.join(',')[toExpectation]»
	'''

	protected dispatch def String toExpectation(WorkspaceEdit it) '''
		changes :
			«FOR entry : changes.entrySet»
				«org.eclipse.emf.common.util.URI.createURI(entry.key).lastSegment» : «entry.value.toExpectation»
			«ENDFOR» 
		documentChanges : 
			«documentChanges.toExpectation»
	'''
	
	protected dispatch def String toExpectation(CodeAction it)  '''
		title : «title»
		kind : «kind»
		command : «command»
		«IF !diagnostics.nullOrEmpty»codes : «diagnostics.map[code].join(',')»«ENDIF»
		edit : «edit.toExpectation»
	'''
	
	@Accessors static class TestCodeActionConfiguration extends TextDocumentPositionConfiguration {
		String expectedCodeActions = ''

		(List<Either<Command, CodeAction>>)=>void assertCodeActions= null
	}

	protected def void testCodeAction((TestCodeActionConfiguration)=>void configurator) {
		val extension configuration = new TestCodeActionConfiguration
		configuration.filePath = 'MyModel.' + fileExtension
		configurator.apply(configuration)
		val filePath = initializeContext(configuration).uri
		val codeLenses = languageServer.codeAction(new CodeActionParams=>[
			textDocument = new TextDocumentIdentifier(filePath)
			range = new Range => [
				start = new Position(configuration.line, configuration.column)
				end = start
			]
			context = new CodeActionContext => [
				diagnostics = this.diagnostics.get(filePath)
			]
		])

		if (configuration.assertCodeActions !== null) {
			configuration.assertCodeActions.apply(codeLenses.get)
		} else {
			assertEquals(configuration.expectedCodeActions, codeLenses.get.toExpectation)
		}
	}

	protected def void testCompletion((TestCompletionConfiguration)=>void configurator) {
		val extension configuration = new TestCompletionConfiguration
		configuration.filePath = 'MyModel.' + fileExtension
		configurator.apply(configuration)
		val filePath = initializeContext(configuration).uri
		val completionItems = languageServer.completion(new CompletionParams => [
			textDocument = new TextDocumentIdentifier(filePath)
			position = new Position(line, column)
		])

		val result = completionItems.get
		val items = if (result.isLeft) result.getLeft else result.getRight.items
		// assert ordered by sortText
		Assert.assertEquals(items, items.sortBy[sortText].toList)
		if (configuration.assertCompletionList !== null) {
			configuration.assertCompletionList.apply(result.getRight)
		} else {
			val actualCompletionItems = items.toExpectation
			assertEquals(expectedCompletionItems, actualCompletionItems)
		}
	}

	protected def FileInfo initializeContext(TextDocumentConfiguration configuration) {
		initialize(configuration.initializer)
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
		val definitionsFuture = languageServer.definition(new TextDocumentPositionParams => [
			textDocument = new TextDocumentIdentifier(fileUri)
			position = new Position(line, column)
		])
		val definitions = definitionsFuture.get
		if (configuration.assertDefinitions !== null) {
			configuration.assertDefinitions.apply(definitions.getLeft())
		} else {
			val actualDefinitions = definitions.toExpectation
			assertEquals(expectedDefinitions, actualDefinitions)
		}
	}

	protected def void testHover((HoverTestConfiguration)=>void configurator) {
		val extension configuration = new HoverTestConfiguration
		configuration.filePath = 'MyModel.' + fileExtension
		configurator.apply(configuration)
		val fileUri = initializeContext(configuration).uri

		val hoverFuture = languageServer.hover(new TextDocumentPositionParams => [
			textDocument = new TextDocumentIdentifier(fileUri)
			position = new Position(line, column)
		])
		val hover = hoverFuture.get
		if (configuration.assertHover !== null) {
			configuration.assertHover.apply(hover)
		} else {
			val actualHover = hover.toExpectation
			assertEquals(expectedHover, actualHover)
		}
	}

	protected def testSignatureHelp((SignatureHelpConfiguration)=>void configurator) {
		val extension configuration = new SignatureHelpConfiguration;
		configuration.filePath = 'MyModel.' + fileExtension;
		configurator.apply(configuration);

		val fileUri = initializeContext(configuration).uri

		val signatureHelpFuture = languageServer.signatureHelp(new TextDocumentPositionParams => [
			textDocument = new TextDocumentIdentifier(fileUri)
			position = new Position(line, column)
		]);
		val signatureHelp = signatureHelpFuture.get
		if (configuration.assertSignatureHelp !== null) {
			configuration.assertSignatureHelp.apply(signatureHelp)
		} else {
			val actualSignatureHelp = signatureHelp.toExpectation
			assertEquals(expectedSignatureHelp.trim, actualSignatureHelp.trim)
		}
	}

	protected def testDocumentHighlight((DocumentHighlightConfiguration)=>void configurator) {
		val extension configuration = new DocumentHighlightConfiguration => [
			filePath = '''MyModel.«fileExtension»''';
		];
		configurator.apply(configuration);

		val fileUri = initializeContext(configuration).uri;
		val highlights = languageServer.documentHighlight(new TextDocumentPositionParams => [
			textDocument = new TextDocumentIdentifier(fileUri)
			position = new Position(line, column)
		]);

		val actualDocumentHighlight = highlights.get.map[toExpectation].join(' | ');
		assertEquals(expectedDocumentHighlight, actualDocumentHighlight);
	}

	protected def void testDocumentSymbol((DocumentSymbolConfiguraiton)=>void configurator) {
		val extension configuration = new DocumentSymbolConfiguraiton
		configuration.filePath = 'MyModel.' + fileExtension
		configurator.apply(configuration)

		val fileUri = initializeContext(configuration).uri
		val symbolsFuture = languageServer.documentSymbol(new DocumentSymbolParams(new TextDocumentIdentifier(fileUri)))
		val symbols = symbolsFuture.get
		if (configuration.assertSymbols !== null) {
			configuration.assertSymbols.apply(symbols)
		} else {
			val unwrappedSymbols = symbols.map[if(hierarchicalDocumentSymbolSupport) getRight else getLeft]
			val String actualSymbols = unwrappedSymbols.toExpectation
			assertEquals(expectedSymbols, actualSymbols)
		}
	}

	/**
	 * {@code true} if the {@code smaller} range is inside or equal to the {@code bigger} range.
	 * Otherwise, {@code false}.
	 */
	// `private` visibility because this should be in LSP4J: https://github.com/eclipse/lsp4j/issues/261
	private static def boolean contains(Range bigger, Range smaller) {
		return bigger.contains(smaller.start) && bigger.contains(smaller.end);
	}

	/**
	 * {@code true} if the position is either inside or on the border of the range.
	 * Otherwise, {@code false}.
	 */
	private static def boolean contains(Range range, Position position) {
		return (range.start == position || range.start.isBefore(position))
			&& (range.end == position || position.isBefore(range.end))
	}

	/**
	 * {@code true} if {@left} is strictly before than {@code right}.
	 * Otherwise, {@code false}.
	 * <p>
	 * If you want to allow equality, use {@link Position#equals}.
	 */
	private static def boolean isBefore(Position left, Position right) {
		if (left.line < right.line) {
			return true;
		}
		if (left.line > right.line) {
			return false;
		}
		return left.character < right.character;
	}

	protected def void testSymbol((WorkspaceSymbolConfiguration)=>void configurator) {
		val extension configuration = new WorkspaceSymbolConfiguration
		configuration.filePath = 'MyModel.' + fileExtension
		configurator.apply(configuration)

		initializeContext(configuration)
		val symbols = languageServer.symbol(new WorkspaceSymbolParams(query)).get
		if (configuration.assertSymbols !== null) {
			configuration.assertSymbols.apply(symbols)
		} else {
			val String actualSymbols = symbols.toExpectation
			assertEquals(expectedSymbols, actualSymbols)
		}
	}

	protected def void testReferences((ReferenceTestConfiguration)=>void configurator) {
		val extension configuration = new ReferenceTestConfiguration
		configuration.filePath = 'MyModel.' + fileExtension
		configurator.apply(configuration)
		val fileUri = initializeContext(configuration).uri
		val referencesFuture = languageServer.references(new ReferenceParams => [
			textDocument = new TextDocumentIdentifier(fileUri)
			position = new Position(line, column)
			context = new ReferenceContext(includeDeclaration)
		])
		val references = referencesFuture.get
		if (configuration.assertReferences !== null) {
			configuration.assertReferences.apply(references)
		} else {
			val actualReferences = references.toExpectation
			assertEquals(expectedReferences, actualReferences)
		}
	}

	def void assertEquals(String expected, String actual) {
		val expectedM = expected.replace(System.lineSeparator, '\n')
		val actualM = actual.replace(System.lineSeparator, '\n')
		Assert.assertEquals(expectedM.replace('\t', '    '), actualM.replace('\t', '    '))
	}

	def void assertEqualsStricter(String expected, String actual) {
		val expectedM = expected.replace(System.lineSeparator, '\n')
		val actualM = actual.replace(System.lineSeparator, '\n')
		Assert.assertEquals(expectedM, actualM)
	}

	protected def testFormatting((FormattingConfiguration)=>void configurator) {
		testFormatting(null, configurator)
	}

	protected def testFormatting((DocumentFormattingParams)=>void paramsConfigurator, (FormattingConfiguration)=>void configurator) {
		val extension configuration = new FormattingConfiguration
		configuration.filePath = 'MyModel.' + fileExtension
		configurator.apply(configuration)
		val fileInfo = initializeContext(configuration)

		val changes = languageServer.formatting(new DocumentFormattingParams => [
			textDocument = new TextDocumentIdentifier(fileInfo.uri)
			if (paramsConfigurator !== null) {
				paramsConfigurator.apply(it)
			}
		])
		val result = new Document(1, fileInfo.contents).applyChanges(<TextEdit>newArrayList(changes.get()).reverse)
		assertEqualsStricter(configuration.expectedText, result.contents)
	}

	protected def testRangeFormatting((RangeFormattingConfiguration)=>void configurator) {
		testRangeFormatting(null, configurator)
	}

	protected def testRangeFormatting((DocumentRangeFormattingParams)=>void paramsConfigurator, (RangeFormattingConfiguration)=>void configurator) {
		val extension configuration = new RangeFormattingConfiguration
		configuration.filePath = 'MyModel.' + fileExtension
		configurator.apply(configuration)

		val fileInfo = initializeContext(configuration)

		val changes = languageServer.rangeFormatting(new DocumentRangeFormattingParams => [
			textDocument = new TextDocumentIdentifier(fileInfo.uri)
			range = configuration.range
			if (paramsConfigurator !== null) {
				paramsConfigurator.apply(it)
			}
		])
		val result = new Document(1, fileInfo.contents).applyChanges(<TextEdit>newArrayList(changes.get()).reverse)
		assertEqualsStricter(configuration.expectedText, result.contents)
	}

	override notify(String method, Object parameter) {
		this.notifications.add(method -> parameter)
	}

	override request(String method, Object parameter) {
		return CompletableFuture.completedFuture(null)
	}

	protected def Map<String, List<Diagnostic>> getDiagnostics() {
		languageServer.requestManager.runRead[
			val result = <String, List<Diagnostic>>newHashMap
			for (diagnostic : notifications.map[value].filter(PublishDiagnosticsParams)) {
				result.put(diagnostic.uri, diagnostic.diagnostics)
			}
			return result 
		].get
	}

	protected def getColoringParams() {
		languageServer.requestManager.runRead[
			return notifications.map[value].filter(ColoringParams).toMap([uri], [infos]);
		].get
	}

	protected def getSemanticHighlightingParams() {
		languageServer.requestManager.runRead[
			return notifications.map[value].filter(SemanticHighlightingParams).toMap([textDocument], [lines]);
		].get
	}
}

@Data class FileInfo {
	String uri
	String contents
}

@Accessors
class TestCompletionConfiguration extends TextDocumentPositionConfiguration {
	String expectedCompletionItems = ''
	(CompletionList)=>void assertCompletionList = null
}

@Accessors
class DefinitionTestConfiguration extends TextDocumentPositionConfiguration {
	String expectedDefinitions = ''
	(List<? extends Location>)=>void assertDefinitions = null
}

@Accessors
class HoverTestConfiguration extends TextDocumentPositionConfiguration {
	String expectedHover = ''
	(Hover)=>void assertHover = null
}

@Accessors
class SignatureHelpConfiguration extends TextDocumentPositionConfiguration {
	String expectedSignatureHelp = ''
	(SignatureHelp)=>void assertSignatureHelp = null
}

@Accessors
class DocumentHighlightConfiguration extends TextDocumentPositionConfiguration {
	String expectedDocumentHighlight = ''
}

@Accessors
class DocumentSymbolConfiguraiton extends TextDocumentConfiguration {
	String expectedSymbols = ''
	(List<Either<SymbolInformation, DocumentSymbol>>)=>void assertSymbols = null
}

@Accessors
class ReferenceTestConfiguration extends TextDocumentPositionConfiguration {
	boolean includeDeclaration = false
	String expectedReferences = ''
	(List<? extends Location>)=>void assertReferences = null
}

@Accessors
class WorkspaceSymbolConfiguration extends TextDocumentConfiguration {
	String query = ''
	String expectedSymbols = ''
	(List<? extends SymbolInformation>)=>void assertSymbols = null
}

@Accessors
class TextDocumentPositionConfiguration extends TextDocumentConfiguration {
	int line = 0
	int column = 0
}

@Accessors
class TextDocumentConfiguration {
	Map<String, CharSequence> filesInScope = emptyMap
	String model
	String filePath
	(InitializeParams)=>void initializer
}

@Accessors
class FormattingConfiguration extends TextDocumentConfiguration {
	String expectedText = ''
}

@Accessors
class ColoringConfiguration extends TextDocumentConfiguration {
	String expectedColoredRangesWithStyles = '';
}

@Accessors
class RangeFormattingConfiguration extends FormattingConfiguration {
	Range range = new Range => [
		start = new Position(0, 0)
		end = new Position(0, 1)
	]
}
