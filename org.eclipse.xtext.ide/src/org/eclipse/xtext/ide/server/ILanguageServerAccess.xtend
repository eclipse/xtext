/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import java.util.List
import java.util.concurrent.CompletableFuture
import java.util.function.Function
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.lsp4j.services.LanguageClient

/**
 * 
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

	/**
	 * provides read access to a fully resolved resource and Document.
	 */
	def <T> CompletableFuture<T> doRead(String uri, Function<Context, T> function)
	
	static interface IBuildListener {
		def void afterBuild(List<IResourceDescription.Delta> deltas)
	}

	/**
	 * registers a build listener on the this language server
	 */
	def void addBuildListener(IBuildListener listener)
	
	/**
	 * returns the language client facade. It usually also implements Endpoint, which can be used to
	 * call non-standard extensions to the LSP.
	 */
	def LanguageClient getLanguageClient();
}
