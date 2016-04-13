/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import com.google.common.base.Objects;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import javax.inject.Provider;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.ReferenceAcceptor;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.ide.editor.hierarchy.AbstractHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyNodeLocation;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNodeLocation;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNodeLocationProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * <p>
 * Default implementation of a call hierarchy builder.
 * </p>
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public class DefaultCallHierarchyBuilder extends AbstractHierarchyBuilder {
  @Override
  public Collection<HierarchyNode> buildRoots(final URI rootURI, final IProgressMonitor progressMonitor) {
    final IEObjectDescription rootDeclaration = this.getRootDeclaration(rootURI);
    if ((rootDeclaration == null)) {
      return CollectionLiterals.<HierarchyNode>emptyList();
    }
    HierarchyNode _createRoot = this.createRoot(rootDeclaration);
    return Collections.<HierarchyNode>unmodifiableList(CollectionLiterals.<HierarchyNode>newArrayList(_createRoot));
  }
  
  @Override
  public Collection<HierarchyNode> buildChildren(final HierarchyNode parent, final IProgressMonitor progressMonitor) {
    boolean _mayHaveChildren = parent.mayHaveChildren();
    boolean _not = (!_mayHaveChildren);
    if (_not) {
      return CollectionLiterals.<HierarchyNode>emptyList();
    }
    final LinkedHashMap<URI, HierarchyNode> children = CollectionLiterals.<URI, HierarchyNode>newLinkedHashMap();
    IEObjectDescription _element = parent.getElement();
    URI _eObjectURI = _element.getEObjectURI();
    final Procedure2<IEObjectDescription, IReferenceDescription> _function = new Procedure2<IEObjectDescription, IReferenceDescription>() {
      @Override
      public void apply(final IEObjectDescription declaration, final IReferenceDescription reference) {
        URI _eObjectURI = declaration.getEObjectURI();
        HierarchyNode childNode = children.get(_eObjectURI);
        if ((childNode == null)) {
          HierarchyNode _createChild = DefaultCallHierarchyBuilder.this.createChild(declaration, parent);
          childNode = _createChild;
          URI _eObjectURI_1 = declaration.getEObjectURI();
          children.put(_eObjectURI_1, childNode);
        }
        Collection<HierarchyNodeLocation> _locations = childNode.getLocations();
        HierarchyNodeLocation _createLocation = DefaultCallHierarchyBuilder.this.createLocation(reference);
        _locations.add(_createLocation);
      }
    };
    this.findDeclarations(_eObjectURI, progressMonitor, _function);
    return children.values();
  }
  
  protected void findDeclarations(final URI targetURI, final IProgressMonitor progressMonitor, final Procedure2<? super IEObjectDescription, ? super IReferenceDescription> acceptor) {
    final TargetURIs targetURIs = this.collectTargetURIs(targetURI);
    IReferenceFinder _referenceFinder = this.getReferenceFinder();
    IReferenceFinder.IResourceAccess _resourceAccess = this.getResourceAccess();
    IResourceDescriptions _indexData = this.getIndexData();
    IResourceServiceProvider.Registry _resourceServiceProviderRegistry = this.getResourceServiceProviderRegistry();
    final IAcceptor<IReferenceDescription> _function = new IAcceptor<IReferenceDescription>() {
      @Override
      public void accept(final IReferenceDescription reference) {
        final IEObjectDescription declaration = DefaultCallHierarchyBuilder.this.getDeclaration(reference);
        if ((declaration != null)) {
          acceptor.apply(declaration, reference);
        }
      }
    };
    ReferenceAcceptor _referenceAcceptor = new ReferenceAcceptor(_resourceServiceProviderRegistry, _function);
    _referenceFinder.findAllReferences(targetURIs, _resourceAccess, _indexData, _referenceAcceptor, progressMonitor);
  }
  
  protected TargetURIs collectTargetURIs(final URI targetURI) {
    Provider<TargetURIs> _targetURIProvider = this.getTargetURIProvider();
    final TargetURIs targetURIs = _targetURIProvider.get();
    if ((targetURI == null)) {
      return targetURIs;
    }
    IReferenceFinder.IResourceAccess _resourceAccess = this.getResourceAccess();
    final IUnitOfWork<TargetURIs, ResourceSet> _function = new IUnitOfWork<TargetURIs, ResourceSet>() {
      @Override
      public TargetURIs exec(final ResourceSet resourceSet) throws Exception {
        final EObject targetObject = resourceSet.getEObject(targetURI, true);
        if ((targetObject == null)) {
          return targetURIs;
        }
        TargetURICollector _targetURICollector = DefaultCallHierarchyBuilder.this.getTargetURICollector();
        _targetURICollector.add(targetObject, targetURIs);
        return targetURIs;
      }
    };
    return _resourceAccess.<TargetURIs>readOnly(targetURI, _function);
  }
  
  protected IEObjectDescription getRootDeclaration(final URI rootURI) {
    IEObjectDescription _declaration = this.getDeclaration(rootURI);
    return this.getRootDeclaration(_declaration);
  }
  
  /**
   * @returns a declaration representing a root hierarchy node for the given element; can return <code>null<code> if the hierarchy does not support such kind of declarations
   */
  protected IEObjectDescription getRootDeclaration(final IEObjectDescription declaration) {
    return declaration;
  }
  
  /**
   * @returns a declaration representing a child node that can be reached with the given reference; can return <code>null</code> if the hierarchy does not support such kind of references
   */
  protected IEObjectDescription getDeclaration(final IReferenceDescription reference) {
    if ((reference == null)) {
      return null;
    }
    URI _elvis = null;
    URI _containerEObjectURI = reference.getContainerEObjectURI();
    if (_containerEObjectURI != null) {
      _elvis = _containerEObjectURI;
    } else {
      URI _sourceEObjectUri = reference.getSourceEObjectUri();
      _elvis = _sourceEObjectUri;
    }
    final URI declarationURI = _elvis;
    return this.getDeclaration(declarationURI);
  }
  
  protected IEObjectDescription getDeclaration(final URI declarationURI) {
    IResourceDescriptions _indexData = this.getIndexData();
    URI _trimFragment = declarationURI.trimFragment();
    final IResourceDescription resourceDescription = _indexData.getResourceDescription(_trimFragment);
    if ((resourceDescription == null)) {
      return null;
    }
    Iterable<IEObjectDescription> _exportedObjects = resourceDescription.getExportedObjects();
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      @Override
      public Boolean apply(final IEObjectDescription it) {
        URI _eObjectURI = it.getEObjectURI();
        return Boolean.valueOf(Objects.equal(_eObjectURI, declarationURI));
      }
    };
    return IterableExtensions.<IEObjectDescription>findFirst(_exportedObjects, _function);
  }
  
  /**
   * @returns a root hierarchy node for the given declaration; cannot be <code>null</code>
   */
  protected HierarchyNode createRoot(final IEObjectDescription declaration) {
    final DefaultHierarchyNode node = new DefaultHierarchyNode();
    node.setElement(declaration);
    node.setMayHaveChildren(true);
    return node;
  }
  
  /**
   * @returns a child node for the given declaration and the parent node; cannot be <code>null</code>
   */
  protected HierarchyNode createChild(final IEObjectDescription declaration, final HierarchyNode parent) {
    final DefaultHierarchyNode node = new DefaultHierarchyNode();
    node.setParent(parent);
    node.setElement(declaration);
    boolean _isRecursive = node.isRecursive();
    boolean _not = (!_isRecursive);
    node.setMayHaveChildren(_not);
    return node;
  }
  
  /**
   * @returns a location for the given reference; cannot be <code>null</code>
   */
  protected HierarchyNodeLocation createLocation(final IReferenceDescription reference) {
    IReferenceFinder.IResourceAccess _resourceAccess = this.getResourceAccess();
    URI _sourceEObjectUri = reference.getSourceEObjectUri();
    final IUnitOfWork<DefaultHierarchyNodeLocation, ResourceSet> _function = new IUnitOfWork<DefaultHierarchyNodeLocation, ResourceSet>() {
      @Override
      public DefaultHierarchyNodeLocation exec(final ResourceSet resourceSet) throws Exception {
        URI _sourceEObjectUri = reference.getSourceEObjectUri();
        final EObject obj = resourceSet.getEObject(_sourceEObjectUri, true);
        final ITextRegionWithLineInformation textRegion = DefaultCallHierarchyBuilder.this.getTextRegion(obj, reference);
        final String text = DefaultCallHierarchyBuilder.this.getText(obj, textRegion);
        return new DefaultHierarchyNodeLocation(text, textRegion, reference);
      }
    };
    return _resourceAccess.<DefaultHierarchyNodeLocation>readOnly(_sourceEObjectUri, _function);
  }
  
  protected ITextRegionWithLineInformation getTextRegion(final EObject obj, final IReferenceDescription reference) {
    HierarchyNodeLocationProvider _hierarchyNodeLocationProvider = this.getHierarchyNodeLocationProvider();
    EReference _eReference = reference.getEReference();
    int _indexInList = reference.getIndexInList();
    return _hierarchyNodeLocationProvider.getTextRegion(obj, _eReference, _indexInList);
  }
  
  protected String getText(final EObject obj, final ITextRegionWithLineInformation textRegion) {
    if (((obj == null) || (textRegion == ITextRegionWithLineInformation.EMPTY_REGION))) {
      return "";
    }
    EObject _rootContainer = EcoreUtil.getRootContainer(obj);
    final ICompositeNode node = NodeModelUtils.getNode(_rootContainer);
    if ((node == null)) {
      return "";
    }
    int _offset = textRegion.getOffset();
    int _length = textRegion.getLength();
    final int endOffset = (_offset + _length);
    ICompositeNode _rootNode = node.getRootNode();
    String _text = _rootNode.getText();
    int _offset_1 = textRegion.getOffset();
    return _text.substring(_offset_1, endOffset);
  }
}
