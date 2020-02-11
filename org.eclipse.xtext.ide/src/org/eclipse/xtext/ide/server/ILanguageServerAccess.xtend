/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import java.util.List
import java.util.concurrent.CompletableFuture
import java.util.function.Function
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.lsp4j.InitializeParams
import org.eclipse.lsp4j.InitializeResult
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.util.CancelIndicator

/**
 * API for interacting with a running language server.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
interface ILanguageServerAccess {

	@Data
	static class Context {
		Resource resource
		Document document
		boolean isDocumentOpen
		CancelIndicator cancelChecker
	}

	@Data
	static class IndexContext {
		IResourceDescriptions index
		CancelIndicator cancelChecker
	}

	/**
	 * provides read access to a fully resolved resource and Document.
	 */
	def <T> CompletableFuture<T> doRead(String uri, Function<Context, T> function)

	/**
	 * Provides read access to the Xtext index.
	 * 
	 * @since 2.18
	 */
	def <T> CompletableFuture<T> doReadIndex(Function<? super IndexContext, ? extends T> function)

	static interface IBuildListener {
		def void afterBuild(List<IResourceDescription.Delta> deltas)
	}

	/**
	 * registers a build listener on the this language server
	 */
	def void addBuildListener(IBuildListener listener)
	
	/**
	 * @return the language client facade. It usually also implements Endpoint, which can be used to
	 * call non-standard extensions to the LSP.
	 */
	def LanguageClient getLanguageClient();
	
	/**
	 * Creates a new {@link ResourceSet} to be used with the {@link IChangeSerializer} API.
	 * 
	 * The {@link IChangeSerializer} allows to calculate text edits from model changes.
	 * In order not to mess up the originals, the resp. models should be loaded into a
	 * new resource set which this method provides.
	 * 
	 * @param uri a file URI used to detect the project to configure the scope of the resource set.
	 * @return a new empty resource set, configured with the project the <code>uri</code>
	 *   belongs to and the {@link ResourceDescriptionsProvider#LIVE_SCOPE} in order to
	 *   reflect model changes immediately.
	 * @since 2.18
	 */
	def ResourceSet newLiveScopeResourceSet(URI uri);
	
	/**
	 * @return the parameters as negotiated during client and server on initialization.
	 * @since 2.18
	 */
	def InitializeParams getInitializeParams();

	/**
	 * Returns with the {@link InitializeResult} of the LS.
	 * 
	 * @since 2.18
	 */
	def InitializeResult getInitializeResult();


}
