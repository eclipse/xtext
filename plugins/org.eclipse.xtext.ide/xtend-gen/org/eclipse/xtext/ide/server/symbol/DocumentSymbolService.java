/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.symbol;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import io.typefox.lsapi.Location;
import io.typefox.lsapi.LocationImpl;
import io.typefox.lsapi.SymbolInformation;
import io.typefox.lsapi.SymbolInformationImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.ReferenceAcceptor;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.findReferences.TargetURIs;
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
  
  public List<? extends Location> getDefinitions(final XtextResource resource, final int offset, final IReferenceFinder.IResourceAccess resourceAccess, final CancelIndicator cancelIndicator) {
    final EObject element = this._eObjectAtOffsetHelper.resolveElementAt(resource, offset);
    if ((element == null)) {
      return CollectionLiterals.<Location>emptyList();
    }
    final ArrayList<LocationImpl> locations = CollectionLiterals.<LocationImpl>newArrayList();
    final TargetURIs targetURIs = this.collectTargetURIs(element);
    for (final URI targetURI : targetURIs) {
      {
        this.operationCanceledManager.checkCanceled(cancelIndicator);
        final Procedure1<EObject> _function = new Procedure1<EObject>() {
          @Override
          public void apply(final EObject obj) {
            LocationImpl _newLocation = DocumentSymbolService.this._documentExtensions.newLocation(obj);
            locations.add(_newLocation);
          }
        };
        this.doRead(resourceAccess, targetURI, _function);
      }
    }
    return locations;
  }
  
  public List<? extends Location> getReferences(final XtextResource resource, final int offset, final IReferenceFinder.IResourceAccess resourceAccess, final IResourceDescriptions indexData, final CancelIndicator cancelIndicator) {
    final EObject element = this._eObjectAtOffsetHelper.resolveElementAt(resource, offset);
    if ((element == null)) {
      return CollectionLiterals.<Location>emptyList();
    }
    final ArrayList<LocationImpl> locations = CollectionLiterals.<LocationImpl>newArrayList();
    final TargetURIs targetURIs = this.collectTargetURIs(element);
    final IAcceptor<IReferenceDescription> _function = new IAcceptor<IReferenceDescription>() {
      @Override
      public void accept(final IReferenceDescription reference) {
        URI _sourceEObjectUri = reference.getSourceEObjectUri();
        final Procedure1<EObject> _function = new Procedure1<EObject>() {
          @Override
          public void apply(final EObject obj) {
            EReference _eReference = reference.getEReference();
            int _indexInList = reference.getIndexInList();
            LocationImpl _newLocation = DocumentSymbolService.this._documentExtensions.newLocation(obj, _eReference, _indexInList);
            locations.add(_newLocation);
          }
        };
        DocumentSymbolService.this.doRead(resourceAccess, _sourceEObjectUri, _function);
      }
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
  
  public List<? extends SymbolInformation> getSymbols(final XtextResource resource, final CancelIndicator cancelIndicator) {
    final LinkedHashMap<EObject, SymbolInformationImpl> symbols = CollectionLiterals.<EObject, SymbolInformationImpl>newLinkedHashMap();
    final TreeIterator<Object> contents = EcoreUtil.<Object>getAllProperContents(resource, true);
    while (contents.hasNext()) {
      {
        this.operationCanceledManager.checkCanceled(cancelIndicator);
        Object _next = contents.next();
        final EObject obj = ((EObject) _next);
        final SymbolInformationImpl symbol = this.createSymbol(obj);
        if ((symbol != null)) {
          symbols.put(obj, symbol);
          final EObject container = this.getContainer(obj);
          final SymbolInformationImpl containerSymbol = symbols.get(container);
          String _name = null;
          if (containerSymbol!=null) {
            _name=containerSymbol.getName();
          }
          symbol.setContainer(_name);
        }
      }
    }
    Collection<SymbolInformationImpl> _values = symbols.values();
    return IterableExtensions.<SymbolInformationImpl>toList(_values);
  }
  
  protected EObject getContainer(final EObject obj) {
    return obj.eContainer();
  }
  
  protected SymbolInformationImpl createSymbol(final EObject object) {
    final String symbolName = this.getSymbolName(object);
    if ((symbolName == null)) {
      return null;
    }
    final SymbolInformationImpl symbol = new SymbolInformationImpl();
    symbol.setName(symbolName);
    int _symbolKind = this.getSymbolKind(object);
    symbol.setKind(_symbolKind);
    LocationImpl _newLocation = this._documentExtensions.newLocation(object);
    symbol.setLocation(_newLocation);
    return symbol;
  }
  
  protected String getSymbolName(final EObject object) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(object);
    return this.getSymbolName(_fullyQualifiedName);
  }
  
  protected int getSymbolKind(final EObject object) {
    EClass _eClass = object.eClass();
    return this.getSymbolKind(_eClass);
  }
  
  public List<? extends SymbolInformation> getSymbols(final IResourceDescription resourceDescription, final String query, final IReferenceFinder.IResourceAccess resourceAccess, final CancelIndicator cancelIndicator) {
    final LinkedList<SymbolInformationImpl> symbols = CollectionLiterals.<SymbolInformationImpl>newLinkedList();
    Iterable<IEObjectDescription> _exportedObjects = resourceDescription.getExportedObjects();
    for (final IEObjectDescription description : _exportedObjects) {
      {
        this.operationCanceledManager.checkCanceled(cancelIndicator);
        boolean _filter = this.filter(description, query);
        if (_filter) {
          final SymbolInformationImpl symbol = this.createSymbol(description);
          if ((symbol != null)) {
            symbols.add(symbol);
            URI _eObjectURI = description.getEObjectURI();
            final Procedure1<EObject> _function = new Procedure1<EObject>() {
              @Override
              public void apply(final EObject obj) {
                LocationImpl _newLocation = DocumentSymbolService.this._documentExtensions.newLocation(obj);
                symbol.setLocation(_newLocation);
              }
            };
            this.doRead(resourceAccess, _eObjectURI, _function);
          }
        }
      }
    }
    return symbols;
  }
  
  protected boolean filter(final IEObjectDescription description, final String query) {
    QualifiedName _qualifiedName = description.getQualifiedName();
    QualifiedName _lowerCase = _qualifiedName.toLowerCase();
    String _string = _lowerCase.toString();
    String _lowerCase_1 = query.toLowerCase();
    return _string.contains(_lowerCase_1);
  }
  
  protected SymbolInformationImpl createSymbol(final IEObjectDescription description) {
    final String symbolName = this.getSymbolName(description);
    if ((symbolName == null)) {
      return null;
    }
    final SymbolInformationImpl symbol = new SymbolInformationImpl();
    symbol.setName(symbolName);
    int _symbolKind = this.getSymbolKind(description);
    symbol.setKind(_symbolKind);
    return symbol;
  }
  
  protected String getSymbolName(final IEObjectDescription description) {
    QualifiedName _qualifiedName = description.getQualifiedName();
    return this.getSymbolName(_qualifiedName);
  }
  
  protected int getSymbolKind(final IEObjectDescription description) {
    EClass _eClass = description.getEClass();
    return this.getSymbolKind(_eClass);
  }
  
  protected String getSymbolName(final QualifiedName qualifiedName) {
    String _string = null;
    if (qualifiedName!=null) {
      _string=qualifiedName.toString();
    }
    return _string;
  }
  
  protected int getSymbolKind(final EClass type) {
    return 0;
  }
  
  protected void doRead(final IReferenceFinder.IResourceAccess resourceAccess, final URI objectURI, final Procedure1<? super EObject> acceptor) {
    final IUnitOfWork<Object, ResourceSet> _function = new IUnitOfWork<Object, ResourceSet>() {
      @Override
      public Object exec(final ResourceSet resourceSet) throws Exception {
        final EObject object = resourceSet.getEObject(objectURI, true);
        if ((object != null)) {
          acceptor.apply(object);
        }
        return null;
      }
    };
    resourceAccess.<Object>readOnly(objectURI, _function);
  }
}
