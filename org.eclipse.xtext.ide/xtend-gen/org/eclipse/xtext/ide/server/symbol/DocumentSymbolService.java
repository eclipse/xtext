/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.symbol;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.lsp4j.DocumentSymbol;
import org.eclipse.lsp4j.DocumentSymbolParams;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.ReferenceParams;
import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.lsp4j.SymbolKind;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.ReferenceAcceptor;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.DocumentExtensions;
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
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class DocumentSymbolService {
  @Inject
  @Extension
  private DocumentExtensions _documentExtensions;
  
  @Inject
  @Extension
  private EObjectAtOffsetHelper _eObjectAtOffsetHelper;
  
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
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
  
  public List<? extends Location> getDefinitions(final Document document, final XtextResource resource, final TextDocumentPositionParams params, final IReferenceFinder.IResourceAccess resourceAccess, final CancelIndicator cancelIndicator) {
    final int offset = document.getOffSet(params.getPosition());
    return this.getDefinitions(resource, offset, resourceAccess, cancelIndicator);
  }
  
  public List<? extends Location> getDefinitions(final XtextResource resource, final int offset, final IReferenceFinder.IResourceAccess resourceAccess, final CancelIndicator cancelIndicator) {
    final EObject element = this._eObjectAtOffsetHelper.resolveElementAt(resource, offset);
    if ((element == null)) {
      return CollectionLiterals.<Location>emptyList();
    }
    final ArrayList<Location> locations = CollectionLiterals.<Location>newArrayList();
    final TargetURIs targetURIs = this.collectTargetURIs(element);
    for (final URI targetURI : targetURIs) {
      {
        this.operationCanceledManager.checkCanceled(cancelIndicator);
        final Procedure1<EObject> _function = (EObject obj) -> {
          final Location location = this._documentExtensions.newLocation(obj);
          if ((location != null)) {
            locations.add(location);
          }
        };
        this.doRead(resourceAccess, targetURI, _function);
      }
    }
    return locations;
  }
  
  public List<? extends Location> getReferences(final Document document, final XtextResource resource, final ReferenceParams params, final IReferenceFinder.IResourceAccess resourceAccess, final IResourceDescriptions indexData, final CancelIndicator cancelIndicator) {
    final int offset = document.getOffSet(params.getPosition());
    List<? extends Location> _xifexpression = null;
    boolean _isIncludeDeclaration = params.getContext().isIncludeDeclaration();
    if (_isIncludeDeclaration) {
      _xifexpression = this.getDefinitions(resource, offset, resourceAccess, cancelIndicator);
    } else {
      _xifexpression = CollectionLiterals.emptyList();
    }
    final List<? extends Location> definitions = _xifexpression;
    final List<? extends Location> references = this.getReferences(resource, offset, resourceAccess, indexData, cancelIndicator);
    final Iterable<Location> result = Iterables.<Location>concat(definitions, references);
    return IterableExtensions.<Location>toList(result);
  }
  
  public List<? extends Location> getReferences(final XtextResource resource, final int offset, final IReferenceFinder.IResourceAccess resourceAccess, final IResourceDescriptions indexData, final CancelIndicator cancelIndicator) {
    final EObject element = this._eObjectAtOffsetHelper.resolveElementAt(resource, offset);
    if ((element == null)) {
      return CollectionLiterals.<Location>emptyList();
    }
    final ArrayList<Location> locations = CollectionLiterals.<Location>newArrayList();
    final TargetURIs targetURIs = this.collectTargetURIs(element);
    final IAcceptor<IReferenceDescription> _function = (IReferenceDescription reference) -> {
      final Procedure1<EObject> _function_1 = (EObject obj) -> {
        final Location location = this._documentExtensions.newLocation(obj, reference.getEReference(), reference.getIndexInList());
        if ((location != null)) {
          locations.add(location);
        }
      };
      this.doRead(resourceAccess, reference.getSourceEObjectUri(), _function_1);
    };
    ReferenceAcceptor _referenceAcceptor = new ReferenceAcceptor(this.resourceServiceProviderRegistry, _function);
    CancelIndicatorProgressMonitor _cancelIndicatorProgressMonitor = new CancelIndicatorProgressMonitor(cancelIndicator);
    this.referenceFinder.findAllReferences(targetURIs, resourceAccess, indexData, _referenceAcceptor, _cancelIndicatorProgressMonitor);
    return locations;
  }
  
  protected TargetURIs collectTargetURIs(final EObject targetObject) {
    final TargetURIs targetURIs = this.targetURIProvider.get();
    this.targetURICollector.add(targetObject, targetURIs);
    return targetURIs;
  }
  
  public List<Either<SymbolInformation, DocumentSymbol>> getSymbols(final Document document, final XtextResource resource, final DocumentSymbolParams params, final CancelIndicator cancelIndicator) {
    return this.getSymbols(resource, cancelIndicator);
  }
  
  public List<Either<SymbolInformation, DocumentSymbol>> getSymbols(final XtextResource resource, final CancelIndicator cancelIndicator) {
    final LinkedHashMap<EObject, SymbolInformation> symbols = CollectionLiterals.<EObject, SymbolInformation>newLinkedHashMap();
    final TreeIterator<Object> contents = EcoreUtil.<Object>getAllProperContents(resource, true);
    while (contents.hasNext()) {
      {
        this.operationCanceledManager.checkCanceled(cancelIndicator);
        Object _next = contents.next();
        final EObject obj = ((EObject) _next);
        final SymbolInformation symbol = this.createSymbol(obj);
        if ((symbol != null)) {
          symbols.put(obj, symbol);
          final EObject container = this.getContainer(obj);
          final SymbolInformation containerSymbol = symbols.get(container);
          String _name = null;
          if (containerSymbol!=null) {
            _name=containerSymbol.getName();
          }
          symbol.setContainerName(_name);
        }
      }
    }
    final Function1<SymbolInformation, Either<SymbolInformation, DocumentSymbol>> _function = (SymbolInformation it) -> {
      return Either.<SymbolInformation, DocumentSymbol>forLeft(it);
    };
    return IterableExtensions.<Either<SymbolInformation, DocumentSymbol>>toList(IterableExtensions.<SymbolInformation, Either<SymbolInformation, DocumentSymbol>>map(symbols.values(), _function));
  }
  
  protected EObject getContainer(final EObject obj) {
    return obj.eContainer();
  }
  
  protected SymbolInformation createSymbol(final EObject object) {
    final String name = this.getSymbolName(object);
    if ((name == null)) {
      return null;
    }
    final SymbolKind kind = this.getSymbolKind(object);
    if ((kind == null)) {
      return null;
    }
    final Location location = this.getSymbolLocation(object);
    if ((location == null)) {
      return null;
    }
    final SymbolInformation symbol = new SymbolInformation();
    symbol.setName(name);
    symbol.setKind(kind);
    symbol.setLocation(location);
    return symbol;
  }
  
  protected String getSymbolName(final EObject object) {
    return this.getSymbolName(this._iQualifiedNameProvider.getFullyQualifiedName(object));
  }
  
  protected SymbolKind getSymbolKind(final EObject object) {
    return this.getSymbolKind(object.eClass());
  }
  
  protected Location getSymbolLocation(final EObject object) {
    return this._documentExtensions.newLocation(object);
  }
  
  public List<? extends SymbolInformation> getSymbols(final IResourceDescription resourceDescription, final String query, final IReferenceFinder.IResourceAccess resourceAccess, final CancelIndicator cancelIndicator) {
    final LinkedList<SymbolInformation> symbols = CollectionLiterals.<SymbolInformation>newLinkedList();
    Iterable<IEObjectDescription> _exportedObjects = resourceDescription.getExportedObjects();
    for (final IEObjectDescription description : _exportedObjects) {
      {
        this.operationCanceledManager.checkCanceled(cancelIndicator);
        boolean _filter = this.filter(description, query);
        if (_filter) {
          final Procedure1<SymbolInformation> _function = (SymbolInformation symbol) -> {
            symbols.add(symbol);
          };
          this.createSymbol(description, resourceAccess, _function);
        }
      }
    }
    return symbols;
  }
  
  protected boolean filter(final IEObjectDescription description, final String query) {
    return description.getQualifiedName().toLowerCase().toString().contains(query.toLowerCase());
  }
  
  protected void createSymbol(final IEObjectDescription description, final IReferenceFinder.IResourceAccess resourceAccess, final Procedure1<? super SymbolInformation> acceptor) {
    final String name = this.getSymbolName(description);
    if ((name == null)) {
      return;
    }
    final SymbolKind kind = this.getSymbolKind(description);
    if ((kind == null)) {
      return;
    }
    final Procedure1<Location> _function = (Location location) -> {
      final SymbolInformation symbol = new SymbolInformation(name, kind, location);
      acceptor.apply(symbol);
    };
    this.getSymbolLocation(description, resourceAccess, _function);
  }
  
  protected SymbolInformation createSymbol(final IEObjectDescription description) {
    final String symbolName = this.getSymbolName(description);
    if ((symbolName == null)) {
      return null;
    }
    final SymbolKind symbolKind = this.getSymbolKind(description);
    if ((symbolKind == null)) {
      return null;
    }
    final SymbolInformation symbol = new SymbolInformation();
    symbol.setName(symbolName);
    symbol.setKind(symbolKind);
    return symbol;
  }
  
  protected String getSymbolName(final IEObjectDescription description) {
    return this.getSymbolName(description.getQualifiedName());
  }
  
  protected SymbolKind getSymbolKind(final IEObjectDescription description) {
    return this.getSymbolKind(description.getEClass());
  }
  
  protected void getSymbolLocation(final IEObjectDescription description, final IReferenceFinder.IResourceAccess resourceAccess, final Procedure1<? super Location> acceptor) {
    final Procedure1<EObject> _function = (EObject obj) -> {
      final Location location = this.getSymbolLocation(obj);
      if ((location != null)) {
        acceptor.apply(location);
      }
    };
    this.doRead(resourceAccess, description.getEObjectURI(), _function);
  }
  
  protected String getSymbolName(final QualifiedName qualifiedName) {
    String _string = null;
    if (qualifiedName!=null) {
      _string=qualifiedName.toString();
    }
    return _string;
  }
  
  protected SymbolKind getSymbolKind(final EClass type) {
    return SymbolKind.Property;
  }
  
  protected void doRead(final IReferenceFinder.IResourceAccess resourceAccess, final URI objectURI, final Procedure1<? super EObject> acceptor) {
    final IUnitOfWork<Object, ResourceSet> _function = (ResourceSet resourceSet) -> {
      final EObject object = resourceSet.getEObject(objectURI, true);
      if ((object != null)) {
        acceptor.apply(object);
      }
      return null;
    };
    resourceAccess.<Object>readOnly(objectURI, _function);
  }
}
