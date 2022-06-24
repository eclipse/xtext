/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.jsonrpc.Endpoint;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * API for interacting with a running language server.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public interface ILanguageServerAccess {
	class Context {
		private final Resource resource;

		private final Document document;

		private final boolean isDocumentOpen;

		private final CancelIndicator cancelChecker;

		public Context(Resource resource, Document document, boolean isDocumentOpen, CancelIndicator cancelChecker) {
			this.resource = resource;
			this.document = document;
			this.isDocumentOpen = isDocumentOpen;
			this.cancelChecker = cancelChecker;
		}

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("resource", resource);
			b.add("document", document);
			b.add("isDocumentOpen", isDocumentOpen);
			b.add("cancelChecker", cancelChecker);
			return b.toString();
		}

		public Resource getResource() {
			return resource;
		}

		public Document getDocument() {
			return document;
		}

		public boolean isDocumentOpen() {
			return isDocumentOpen;
		}

		public CancelIndicator getCancelChecker() {
			return cancelChecker;
		}
	}

	class IndexContext {
		private final IResourceDescriptions index;

		private final CancelIndicator cancelChecker;

		public IndexContext(IResourceDescriptions index, CancelIndicator cancelChecker) {
			this.index = index;
			this.cancelChecker = cancelChecker;
		}

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("index", index);
			b.add("cancelChecker", cancelChecker);
			return b.toString();
		}

		public IResourceDescriptions getIndex() {
			return index;
		}

		public CancelIndicator getCancelChecker() {
			return cancelChecker;
		}
	}

	interface IBuildListener {
		void afterBuild(List<IResourceDescription.Delta> deltas);
	}

	/**
	 * Provides read access to a fully resolved resource and document.
	 */
	<T extends Object> CompletableFuture<T> doRead(String uri, Function<ILanguageServerAccess.Context, T> function);

	/**
	 * Provides access to a {@link WorkspaceManager}.
	 * 
	 * @since 2.28
	 */
	<T extends Object> T doSyncRead(String uri, Function<ILanguageServerAccess.Context, T> function);

	/**
	 * Provides read access to the Xtext index.
	 * 
	 * @since 2.18
	 */
	<T extends Object> CompletableFuture<T> doReadIndex(
			Function<? super ILanguageServerAccess.IndexContext, ? extends T> function);

	/**
	 * Registers a build listener on this language server
	 */
	void addBuildListener(ILanguageServerAccess.IBuildListener listener);
	
	/**
	 * Removes a build listener on this language server
	 */
	default void removeBuildListener(ILanguageServerAccess.IBuildListener listener) {
		
	}

	/**
	 * @return the language client facade. It usually also implements {@link Endpoint}, which can be used to call non-standard
	 *         extensions to LSP.
	 */
	LanguageClient getLanguageClient();

	/**
	 * Creates a new {@link ResourceSet} to be used with the {@link IChangeSerializer} API.
	 * 
	 * The {@link IChangeSerializer} allows to calculate text edits from model changes. In order not to mess up the
	 * originals, the respective models should be loaded into a new resource set which this method provides.
	 * 
	 * @param uri
	 *            a file {@link URI} used to detect the project to configure the scope of the resource set.
	 * @return a new empty resource set, configured with the project the <code>uri</code> belongs to and the
	 *         {@link ResourceDescriptionsProvider#LIVE_SCOPE} in order to reflect model changes immediately.
	 * @since 2.18
	 */
	ResourceSet newLiveScopeResourceSet(URI uri);

	/**
	 * @return the parameters as negotiated during client and server on initialization.
	 * @since 2.18
	 */
	InitializeParams getInitializeParams();

	/**
	 * Returns the {@link InitializeResult} of the language server.
	 * 
	 * @since 2.18
	 */
	InitializeResult getInitializeResult();
}
