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
import java.util.List;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.ReferenceAcceptor;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
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
  private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
  
  public List<? extends Location> getDefinitions(final XtextResource resource, final int offset, final IReferenceFinder.IResourceAccess resourceAccess) {
    final EObject element = this._eObjectAtOffsetHelper.resolveElementAt(resource, offset);
    if ((element == null)) {
      return CollectionLiterals.<Location>emptyList();
    }
    final ArrayList<LocationImpl> locations = CollectionLiterals.<LocationImpl>newArrayList();
    final TargetURIs targetURIs = this.collectTargetURIs(element);
    for (final URI targetURI : targetURIs) {
      final IUnitOfWork<Boolean, ResourceSet> _function = new IUnitOfWork<Boolean, ResourceSet>() {
        @Override
        public Boolean exec(final ResourceSet resourceSet) throws Exception {
          EObject _eObject = resourceSet.getEObject(targetURI, true);
          LocationImpl _newLocation = DocumentSymbolService.this._documentExtensions.newLocation(_eObject);
          return Boolean.valueOf(locations.add(_newLocation));
        }
      };
      resourceAccess.<Boolean>readOnly(targetURI, _function);
    }
    return locations;
  }
  
  public List<? extends Location> getReferences(final XtextResource resource, final int offset, final IReferenceFinder.IResourceAccess resourceAccess, final IResourceDescriptions indexData) {
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
        final IUnitOfWork<Boolean, ResourceSet> _function = new IUnitOfWork<Boolean, ResourceSet>() {
          @Override
          public Boolean exec(final ResourceSet resourceSet) throws Exception {
            boolean _xblockexpression = false;
            {
              URI _sourceEObjectUri = reference.getSourceEObjectUri();
              final EObject targetObject = resourceSet.getEObject(_sourceEObjectUri, true);
              EReference _eReference = reference.getEReference();
              int _indexInList = reference.getIndexInList();
              LocationImpl _newLocation = DocumentSymbolService.this._documentExtensions.newLocation(targetObject, _eReference, _indexInList);
              _xblockexpression = locations.add(_newLocation);
            }
            return Boolean.valueOf(_xblockexpression);
          }
        };
        resourceAccess.<Boolean>readOnly(_sourceEObjectUri, _function);
      }
    };
    ReferenceAcceptor _referenceAcceptor = new ReferenceAcceptor(this.resourceServiceProviderRegistry, _function);
    this.referenceFinder.findAllReferences(targetURIs, resourceAccess, indexData, _referenceAcceptor, 
      null);
    return locations;
  }
  
  protected TargetURIs collectTargetURIs(final EObject targetObject) {
    final TargetURIs targetURIs = this.targetURIProvider.get();
    this.targetURICollector.add(targetObject, targetURIs);
    return targetURIs;
  }
  
  public List<? extends SymbolInformation> getSymbols(final XtextResource resource) {
    final LinkedHashMap<EObject, SymbolInformationImpl> symbols = CollectionLiterals.<EObject, SymbolInformationImpl>newLinkedHashMap();
    final TreeIterator<EObject> contents = EcoreUtil.<EObject>getAllProperContents(resource, true);
    while (contents.hasNext()) {
      {
        final EObject obj = contents.next();
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
    String _string = null;
    if (_fullyQualifiedName!=null) {
      _string=_fullyQualifiedName.toString();
    }
    return _string;
  }
  
  protected int getSymbolKind(final EObject object) {
    return 0;
  }
}
