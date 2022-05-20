/*******************************************************************************
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.symbol;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.LinkedList;
import java.util.List;
import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.lsp4j.WorkspaceSymbol;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.findReferences.IReferenceFinder.IResourceAccess;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
public class WorkspaceSymbolService {

	@Inject
	private IResourceServiceProvider.Registry registry;

	@Inject
	private OperationCanceledManager operationCanceledManager;

	public Either<List<? extends SymbolInformation>, List<? extends WorkspaceSymbol>> getSymbols(
		String query,
		IResourceAccess resourceAccess,
		IResourceDescriptions indexData,
		CancelIndicator cancelIndicator
	) {
		List<SymbolInformation> result = new LinkedList<>();
		for (IResourceDescription resourceDescription : indexData.getAllResourceDescriptions()) {
			operationCanceledManager.checkCanceled(cancelIndicator);
			IResourceServiceProvider resourceServiceProvider = registry.getResourceServiceProvider(resourceDescription.getURI());
			if (resourceServiceProvider != null) {
				DocumentSymbolService documentSymbolService = resourceServiceProvider.get(DocumentSymbolService.class);
				if (documentSymbolService != null) {
					result.addAll(documentSymbolService.getSymbols(resourceDescription, query, resourceAccess, cancelIndicator));
				}
			}
		}
		return Either.forLeft(result);
	}

}
