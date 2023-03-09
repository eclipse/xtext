/**
 * Copyright (c) 2018, 2020 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.symbol;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.lsp4j.DocumentSymbol;
import org.eclipse.lsp4j.DocumentSymbolParams;
import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Document symbol service that is comply with the LSP
 * <a href="https://microsoft.github.io/language-server-protocol/specification#version_3_10_0">3.10.0</a> version.
 * Unlike the {@link DocumentSymbolService}, this service can provide hierarchical document symbols.
 */
@Beta
@Singleton
public class HierarchicalDocumentSymbolService implements IDocumentSymbolService {
	@Inject
	private DocumentSymbolMapper symbolMapper;

	@Inject
	private OperationCanceledManager operationCanceledManager;

	/**
	 * {@code false} if the argument is {@code null} or any of the {@link NonNull} properties are {@code null}.
	 * Otherwise, {@code true}.
	 */
	public static boolean isValid(DocumentSymbol symbol) {
		if (symbol != null) {
			for (Field field : DocumentSymbol.class.getDeclaredFields()) {
				for (Annotation annotation : field.getAnnotations()) {
					if (NonNull.class == annotation.annotationType()) {
						field.setAccessible(true);
						try {
							Object o = field.get(symbol);
							if (o == null) {
								return false;
							}
						} catch (Throwable e) {
							throw Exceptions.sneakyThrow(e);
						}
					}
				}
			}
			return true;
		}
		return false;

	}

	@Override
	public List<Either<SymbolInformation, DocumentSymbol>> getSymbols(Document document, XtextResource resource,
			DocumentSymbolParams params, CancelIndicator cancelIndicator) {
		return getSymbols(resource, cancelIndicator);
	}

	public List<Either<SymbolInformation, DocumentSymbol>> getSymbols(XtextResource resource,
			CancelIndicator cancelIndicator) {
		HashMap<EObject, DocumentSymbol> allSymbols = new HashMap<>();
		ArrayList<DocumentSymbol> rootSymbols = new ArrayList<>();
		Iterator<Object> itr = getAllContents(resource);
		while (itr.hasNext()) {
			operationCanceledManager.checkCanceled(cancelIndicator);
			Optional<EObject> next = toEObject(itr.next());
			if (next.isPresent()) {
				EObject object = next.get();
				DocumentSymbol symbol = symbolMapper.toDocumentSymbol(object);
				if (isValid(symbol)) {
					allSymbols.put(object, symbol);
					EObject parent = object.eContainer();
					if (parent == null) {
						rootSymbols.add(symbol);
					} else {
						DocumentSymbol parentSymbol = allSymbols.get(parent);
						while (parentSymbol == null && parent != null) {
							parent = parent.eContainer();
							parentSymbol = allSymbols.get(parent);
						}
						if (parentSymbol == null) {
							rootSymbols.add(symbol);
						} else {
							parentSymbol.getChildren().add(symbol);
						}
					}
				}
			}
		}
		return rootSymbols.stream().map(symbol -> Either.<SymbolInformation, DocumentSymbol>forRight(symbol))
				.collect(Collectors.toList());
	}

	protected Iterator<Object> getAllContents(Resource resource) {
		return EcoreUtil.getAllProperContents(resource, true);
	}

	protected Optional<EObject> toEObject(Object object) {
		if (object instanceof EObject) {
			return Optional.of((EObject) object);
		}
		return Optional.absent();
	}
}
