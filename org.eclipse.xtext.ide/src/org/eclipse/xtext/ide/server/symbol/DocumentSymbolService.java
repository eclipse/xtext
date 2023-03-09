/**
 * Copyright (c) 2016, 2022 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.symbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.lsp4j.DefinitionParams;
import org.eclipse.lsp4j.DocumentSymbol;
import org.eclipse.lsp4j.DocumentSymbolParams;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.ReferenceParams;
import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.lsp4j.SymbolKind;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.ReferenceAcceptor;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.util.CancelIndicatorProgressMonitor;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.collect.Lists;
import com.google.common.graph.Traverser;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author kosyakov - Initial contribution and API
 *
 * Contributors: 
 *   Rubén Porras Campo (Avaloq Evolution AG) 
 *     - Do not return definitions for elements without identifiers.
 *     - Use the language specific DocumentExtentions depending on the URI of the particular symbol.
 *
 * @since 2.11
 */
@Singleton
public class DocumentSymbolService implements IDocumentSymbolService {
	@Inject
	private UriExtensions uriExtensions;

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private IReferenceFinder referenceFinder;

	@Inject
	private TargetURICollector targetURICollector;

	@Inject
	private Provider<TargetURIs> targetURIProvider;

	@Inject
	private OperationCanceledManager operationCanceledManager;

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	@Inject
	private HierarchicalDocumentSymbolService hierarchicalDocumentSymbolService;

	/**
	 * @since 2.21
	 */
	public List<? extends Location> getDefinitions(Document document, XtextResource resource, DefinitionParams params,
			IReferenceFinder.IResourceAccess resourceAccess, CancelIndicator cancelIndicator) {
		int offset = document.getOffSet(params.getPosition());
		return getDefinitions(resource, offset, resourceAccess, cancelIndicator);
	}

	public List<? extends Location> getDefinitions(XtextResource resource, int offset,
			IReferenceFinder.IResourceAccess resourceAccess, CancelIndicator cancelIndicator) {
		EObject element = eObjectAtOffsetHelper.getElementWithNameAt(resource, offset);
		if (element == null) {
			return Collections.emptyList();
		}
		
		List<Location> locations = new ArrayList<>();
		TargetURIs targetURIs = collectTargetURIs(element);
		for (URI targetURI : targetURIs) {
			operationCanceledManager.checkCanceled(cancelIndicator);
			doRead(resourceAccess, targetURI, (EObject obj) -> {
				Location location = getDocumentExtensions(targetURI).newLocation(obj);
				if (location != null) {
					locations.add(location);
				}
			});
		}
		return locations;
	}

	public List<? extends Location> getReferences(Document document, XtextResource resource, ReferenceParams params,
			IReferenceFinder.IResourceAccess resourceAccess, IResourceDescriptions indexData,
			CancelIndicator cancelIndicator) {
		int offset = document.getOffSet(params.getPosition());
		List<? extends Location> definitions = Collections.emptyList();
		if (params.getContext().isIncludeDeclaration()) {
			definitions = getDefinitions(resource, offset, resourceAccess, cancelIndicator);
		}
		List<? extends Location> references = getReferences(resource, offset, resourceAccess, indexData,
				cancelIndicator);
		List<Location> result = new ArrayList<>();
		result.addAll(definitions);
		result.addAll(references);
		return result;
	}

	public List<? extends Location> getReferences(XtextResource resource, int offset,
			IReferenceFinder.IResourceAccess resourceAccess, IResourceDescriptions indexData,
			CancelIndicator cancelIndicator) {
		EObject element = eObjectAtOffsetHelper.resolveElementAt(resource, offset);
		if (element == null) {
			return Collections.emptyList();
		}
		List<Location> locations = new ArrayList<>();
		TargetURIs targetURIs = collectTargetURIs(element);
		referenceFinder.findAllReferences(targetURIs, resourceAccess, indexData,
				new ReferenceAcceptor(resourceServiceProviderRegistry, (IReferenceDescription reference) -> {
					URI sourceEObjectUri = reference.getSourceEObjectUri();
					doRead(resourceAccess, sourceEObjectUri, (EObject obj) -> {
						Location location = getDocumentExtensions(sourceEObjectUri).newLocation(obj, reference.getEReference(),
								reference.getIndexInList());
						if (location != null) {
							locations.add(location);
						}
					});
				}), new CancelIndicatorProgressMonitor(cancelIndicator));
		return locations;
	}

	protected TargetURIs collectTargetURIs(EObject targetObject) {
		TargetURIs targetURIs = targetURIProvider.get();
		targetURICollector.add(targetObject, targetURIs);
		return targetURIs;
	}

	@Override
	public List<Either<SymbolInformation, DocumentSymbol>> getSymbols(Document document, XtextResource resource,
			DocumentSymbolParams params, CancelIndicator cancelIndicator) {
		return getSymbols(resource, cancelIndicator);
	}

	public List<Either<SymbolInformation, DocumentSymbol>> getSymbols(XtextResource resource,
			CancelIndicator cancelIndicator) {
		String uri = uriExtensions.toUriString(resource.getURI());
		ArrayList<SymbolInformation> infos = new ArrayList<>();
		List<DocumentSymbol> rootSymbols = Lists
				.transform(hierarchicalDocumentSymbolService.getSymbols(resource, cancelIndicator), Either::getRight);
		for (DocumentSymbol rootSymbol : rootSymbols) {
			Iterable<DocumentSymbol> symbols = Traverser.forTree(DocumentSymbol::getChildren)
					.depthFirstPreOrder(rootSymbol);
			Function1<? super DocumentSymbol, ? extends String> containerNameProvider = (DocumentSymbol symbol) -> {
				DocumentSymbol firstSymbol = IterableExtensions.findFirst(symbols, (DocumentSymbol it) -> {
					return it != symbol && !IterableExtensions.isNullOrEmpty(it.getChildren())
							&& it.getChildren().contains(symbol);
				});
				if (firstSymbol != null) {
					return firstSymbol.getName();
				}
				return null;
			};
			for (DocumentSymbol s : symbols) {
				infos.add(createSymbol(uri, s, containerNameProvider));
			}
		}
		return Lists.transform(infos, Either::forLeft);
	}

	protected EObject getContainer(EObject obj) {
		return obj.eContainer();
	}

	/**
	 * @since 2.16
	 */
	protected SymbolInformation createSymbol(String uri, DocumentSymbol symbol,
			Function1<? super DocumentSymbol, ? extends String> containerNameProvider) {
		SymbolInformation symbolInformation = new SymbolInformation();
		symbolInformation.setName(symbol.getName());
		symbolInformation.setKind(symbol.getKind());
		symbolInformation.setDeprecated(symbol.getDeprecated());
		Location location = new Location();
		location.setUri(uri);
		location.setRange(symbol.getSelectionRange());
		symbolInformation.setLocation(location);
		symbolInformation.setContainerName(containerNameProvider.apply(symbol));
		return symbolInformation;
	}

	protected SymbolInformation createSymbol(EObject object) {
		String name = getSymbolName(object);
		if (name == null) {
			return null;
		}
		SymbolKind kind = getSymbolKind(object);
		if (kind == null) {
			return null;
		}
		Location location = getSymbolLocation(object);
		if (location == null) {
			return null;
		}
		SymbolInformation symbol = new SymbolInformation();
		symbol.setName(name);
		symbol.setKind(kind);
		symbol.setLocation(location);
		return symbol;
	}

	protected String getSymbolName(EObject object) {
		return getSymbolName(qualifiedNameProvider.getFullyQualifiedName(object));
	}

	protected SymbolKind getSymbolKind(EObject object) {
		return getSymbolKind(object.eClass());
	}

	protected Location getSymbolLocation(EObject object) {
		return getDocumentExtensions(object.eResource().getURI()).newLocation(object);
	}

	public List<? extends SymbolInformation> getSymbols(IResourceDescription resourceDescription, String query,
			IReferenceFinder.IResourceAccess resourceAccess, CancelIndicator cancelIndicator) {
		List<SymbolInformation> symbols = new LinkedList<>();
		for (IEObjectDescription description : resourceDescription.getExportedObjects()) {
			operationCanceledManager.checkCanceled(cancelIndicator);
			if (filter(description, query)) {
				createSymbol(description, resourceAccess, (SymbolInformation symbol) -> {
					symbols.add(symbol);
				});
			}
		}
		return symbols;
	}

	protected boolean filter(IEObjectDescription description, String query) {
		return description.getQualifiedName().toLowerCase().toString().contains(query.toLowerCase());
	}

	protected void createSymbol(IEObjectDescription description, IReferenceFinder.IResourceAccess resourceAccess,
			Procedure1<? super SymbolInformation> acceptor) {
		String name = getSymbolName(description);
		if (name == null) {
			return;
		}
		SymbolKind kind = getSymbolKind(description);
		if (kind == null) {
			return;
		}
		getSymbolLocation(description, resourceAccess, (Location location) -> {
			SymbolInformation symbol = new SymbolInformation(name, kind, location);
			acceptor.apply(symbol);
		});
	}

	protected SymbolInformation createSymbol(IEObjectDescription description) {
		String symbolName = getSymbolName(description);
		if (symbolName == null) {
			return null;
		}
		SymbolKind symbolKind = getSymbolKind(description);
		if (symbolKind == null) {
			return null;
		}
		SymbolInformation symbol = new SymbolInformation();
		symbol.setName(symbolName);
		symbol.setKind(symbolKind);
		return symbol;
	}

	protected String getSymbolName(IEObjectDescription description) {
		return getSymbolName(description.getQualifiedName());
	}

	protected SymbolKind getSymbolKind(IEObjectDescription description) {
		return getSymbolKind(description.getEClass());
	}

	protected void getSymbolLocation(IEObjectDescription description, IReferenceFinder.IResourceAccess resourceAccess,
			Procedure1<? super Location> acceptor) {
		doRead(resourceAccess, description.getEObjectURI(), (EObject obj) -> {
			Location location = getSymbolLocation(obj);
			if (location != null) {
				acceptor.apply(location);
			}
		});
	}

	protected String getSymbolName(QualifiedName qualifiedName) {
		if (qualifiedName != null) {
			return qualifiedName.toString();
		}
		return null;
	}

	protected SymbolKind getSymbolKind(EClass type) {
		// TODO implement meaningful
		return SymbolKind.Property;
	}

	protected void doRead(IReferenceFinder.IResourceAccess resourceAccess, URI objectURI,
			Procedure1<? super EObject> acceptor) {
		resourceAccess.readOnly(objectURI, (ResourceSet resourceSet) -> {
			EObject object = resourceSet.getEObject(objectURI, true);
			if (object != null) {
				acceptor.apply(object);
			}
			return null;
		});
	}

	private DocumentExtensions getDocumentExtensions(final URI targetURI) {
		return resourceServiceProviderRegistry.getResourceServiceProvider(targetURI.trimFragment())
				.get(DocumentExtensions.class);
	}
}
