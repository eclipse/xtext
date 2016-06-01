/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.Inject
import io.typefox.lsapi.Diagnostic
import io.typefox.lsapi.InitializeParamsImpl
import io.typefox.lsapi.InitializeResult
import io.typefox.lsapi.Location
import io.typefox.lsapi.Position
import io.typefox.lsapi.PublishDiagnosticsParams
import io.typefox.lsapi.Range
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
import org.eclipse.xtext.ide.server.LanguageServerImpl
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.xtext.ide.server.UriExtensions
import org.eclipse.xtext.ide.server.concurrent.RequestManager
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.Files
import org.eclipse.xtext.util.Modules2
import org.junit.Before

import static io.typefox.lsapi.util.LsapiFactories.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class AbstractLanguageServerTest implements Consumer<PublishDiagnosticsParams> {

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
		// register notification callbacks
		languageServer.getTextDocumentService().onPublishDiagnostics(this)

		// create workingdir
		root = new File("./test-data/test-project")
		if (!root.mkdirs) {
			Files.cleanFolder(root, null, true, false)
		}
		root.deleteOnExit
	}

	@Inject extension UriExtensions
	@Inject protected LanguageServerImpl languageServer
	protected Map<String, List<? extends Diagnostic>> diagnostics = newHashMap()

	protected File root

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
		languageServer.didOpen(newDidOpenTextDocumentParams(fileUri, "testlang", 1, model))
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

}
