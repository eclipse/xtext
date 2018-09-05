/*******************************************************************************
 * Copyright (c) 2018 TypeFox and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.symbol

import com.google.common.annotations.Beta
import com.google.common.base.Optional
import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.Iterator
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.lsp4j.DocumentSymbol
import org.eclipse.lsp4j.DocumentSymbolParams
import org.eclipse.lsp4j.SymbolInformation
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.lsp4j.jsonrpc.validation.NonNull
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator

/**
 * Document symbol service that is comply with the LSP <a href="https://microsoft.github.io/language-server-protocol/specification#version_3_10_0">3.10.0</a>
 * version. Unlike the {@link DocumentSymbolService}, this service can provide hierarchical document symbols.
 */
@Beta
@Singleton
class HierarchicalDocumentSymbolService implements IDocumentSymbolService {

	@Inject
	DocumentSymbolMapper symbolMapper;

	@Inject
	OperationCanceledManager operationCanceledManager;

	/**
	 * {@code false} if the argument is {@code null} or any of the {@link NonNull} properties
	 * are {@code null}. Otherwise, {@code true}.
	 */
	static def boolean isValid(DocumentSymbol symbol) {
		return symbol !== null && !DocumentSymbol.declaredFields
			.filter[annotations.exists[annotationType === NonNull]]
			.map[accessible = true; it]
			.map[get(symbol)]
			.exists[it === null];
	}

	override getSymbols(Document document, XtextResource resource, DocumentSymbolParams params,
		CancelIndicator cancelIndicator) {

		return getSymbols(resource, cancelIndicator);
	}

	def getSymbols(XtextResource resource, CancelIndicator cancelIndicator) {
		val allSymbols = newHashMap;
		val rootSymbols = newArrayList;
		val itr = getAllContents(resource);
		while (itr.hasNext) {
			operationCanceledManager.checkCanceled(cancelIndicator);
			val next = itr.next.toEObject;
			if (next.present) {
				val object = next.get;
				val symbol = symbolMapper.toDocumentSymbol(object);
				if (symbol.valid) {
					allSymbols.put(object, symbol);
					var parent = object.eContainer;
					if (parent === null) {
						rootSymbols.add(symbol);
					} else {
						var parentSymbol = allSymbols.get(parent);
						// Find the parent symbol and hook the current one to the parent.
						while (parentSymbol === null && parent !== null) {
							parent = parent.eContainer;
							parentSymbol = allSymbols.get(parent);
						}
						// If there parent cannot be found, it is a root.
						if (parentSymbol === null) {
							rootSymbols.add(symbol);
						} else {
							parentSymbol.children.add(symbol);
						}
					}
				}
			}
		}
		return rootSymbols.map[Either.<SymbolInformation, DocumentSymbol>forRight(it)];
	}

	protected def Iterator<Object> getAllContents(Resource resource) {
		return EcoreUtil.getAllProperContents(resource, true);
	}

	protected def Optional<EObject> toEObject(Object object) {
		if (object instanceof EObject) {
			return Optional.of(object);
		}
		return Optional.absent;
	}

}
