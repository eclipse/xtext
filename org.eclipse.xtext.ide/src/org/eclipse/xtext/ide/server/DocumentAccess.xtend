/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import java.util.concurrent.CompletableFuture
import java.util.function.Function
import java.util.function.Supplier
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.ide.server.concurrent.RequestManager
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author Sven Efftinge - Initial contribution and API
 */
interface DocumentAccess {

	@Data
	static class Context {
		Resource resource
		Document document
		CancelIndicator cancelChecker
	}

	def <T> CompletableFuture<T> doRead(String uri, Function<Context, T> function);

	def static DocumentAccess create(Supplier<RequestManager> requestManagerSupplier,
		Supplier<WorkspaceManager> workspaceManagerSupplier, (String)=>URI uriFactory) {
		return new DocumentAccess() {
			override <T> doRead(String uri, Function<Context, T> function) {
				requestManagerSupplier.get.runRead [ cancelIndicator |
					workspaceManagerSupplier.get.doRead(uriFactory.apply(uri)) [ document, resource |
						val ctx = new Context(resource, document, cancelIndicator)
						return function.apply(ctx)
					]
				]
			}
		}
	}
}
