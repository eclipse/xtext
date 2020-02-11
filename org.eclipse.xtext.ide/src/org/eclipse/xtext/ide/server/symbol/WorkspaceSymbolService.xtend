/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.symbol

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.lsp4j.SymbolInformation
import org.eclipse.xtext.findReferences.IReferenceFinder.IResourceAccess
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
class WorkspaceSymbolService {

	@Inject
	extension IResourceServiceProvider.Registry

	@Inject
	OperationCanceledManager operationCanceledManager

	def List<? extends SymbolInformation> getSymbols(
		String query,
		IResourceAccess resourceAccess,
		IResourceDescriptions indexData,
		CancelIndicator cancelIndicator
	) {
		val result = newLinkedList
		for (resourceDescription : indexData.allResourceDescriptions) {
			operationCanceledManager.checkCanceled(cancelIndicator)
			val resourceServiceProvider = resourceDescription.URI.resourceServiceProvider
			val documentSymbolService = resourceServiceProvider?.get(DocumentSymbolService)
			if (documentSymbolService !== null) {
				result += documentSymbolService.getSymbols(resourceDescription, query, resourceAccess, cancelIndicator)
			}
		}
		return result
	}

}
