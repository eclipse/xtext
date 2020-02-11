/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.findReferences.ReferenceAcceptor;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.ide.editor.hierarchy.AbstractHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyNodeReference;
import org.eclipse.xtext.ide.editor.hierarchy.ICallHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeReference;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * <p>
 * Default implementation of a call hierarchy builder.
 * </p>
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public class DefaultCallHierarchyBuilder extends AbstractHierarchyBuilder implements ICallHierarchyBuilder {
  @Accessors
  private ICallHierarchyBuilder.CallHierarchyType hierarchyType = ICallHierarchyBuilder.CallHierarchyType.CALLER;
  
  @Override
  public Collection<IHierarchyNode> buildRoots(final URI rootURI, final IProgressMonitor monitor) {
    final IEObjectDescription rootDeclaration = this.findDeclaration(rootURI);
    if ((rootDeclaration == null)) {
      return CollectionLiterals.<IHierarchyNode>emptyList();
    }
    IHierarchyNode _createRoot = this.createRoot(rootDeclaration);
    return Collections.<IHierarchyNode>unmodifiableList(CollectionLiterals.<IHierarchyNode>newArrayList(_createRoot));
  }
  
  @Override
  public Collection<IHierarchyNode> buildChildren(final IHierarchyNode parent, final IProgressMonitor monitor) {
    boolean _mayHaveChildren = parent.mayHaveChildren();
    boolean _not = (!_mayHaveChildren);
    if (_not) {
      return CollectionLiterals.<IHierarchyNode>emptyList();
    }
    final LinkedHashMap<URI, IHierarchyNode> children = CollectionLiterals.<URI, IHierarchyNode>newLinkedHashMap();
    final Procedure2<IEObjectDescription, IReferenceDescription> _function = (IEObjectDescription declaration, IReferenceDescription reference) -> {
      final IHierarchyNode childNode = this.createChild(children, declaration, parent);
      if ((childNode != null)) {
        final IHierarchyNodeReference nodeReference = this.createNodeReference(reference);
        if ((nodeReference != null)) {
          Collection<IHierarchyNodeReference> _references = childNode.getReferences();
          _references.add(nodeReference);
        }
      }
    };
    this.findDeclarations(parent, monitor, _function);
    return children.values();
  }
  
  protected void findDeclarations(final IHierarchyNode parent, final IProgressMonitor monitor, final Procedure2<? super IEObjectDescription, ? super IReferenceDescription> acceptor) {
    final ICallHierarchyBuilder.CallHierarchyType hierarchyType = this.hierarchyType;
    if (hierarchyType != null) {
      switch (hierarchyType) {
        case CALLEE:
          this.findTargetDeclarations(parent.getElement().getEObjectURI(), monitor, acceptor);
          break;
        default:
          this.findSourceDeclarations(parent.getElement().getEObjectURI(), monitor, acceptor);
          break;
      }
    } else {
      this.findSourceDeclarations(parent.getElement().getEObjectURI(), monitor, acceptor);
    }
  }
  
  protected void findTargetDeclarations(final URI sourceDeclarationURI, final IProgressMonitor monitor, final Procedure2<? super IEObjectDescription, ? super IReferenceDescription> acceptor) {
    final IUnitOfWork<Object, EObject> _function = (EObject sourceDeclaration) -> {
      Object _xblockexpression = null;
      {
        IResourceServiceProvider.Registry _resourceServiceProviderRegistry = this.getResourceServiceProviderRegistry();
        final IAcceptor<IReferenceDescription> _function_1 = (IReferenceDescription reference) -> {
          boolean _filterReference = this.filterReference(reference);
          if (_filterReference) {
            IEObjectDescription _findTargetDeclaration = null;
            if (reference!=null) {
              _findTargetDeclaration=this.findTargetDeclaration(reference);
            }
            final IEObjectDescription targetDeclaration = _findTargetDeclaration;
            acceptor.apply(targetDeclaration, reference);
          }
        };
        ReferenceAcceptor _referenceAcceptor = new ReferenceAcceptor(_resourceServiceProviderRegistry, _function_1);
        this.getReferenceFinder().findAllReferences(sourceDeclaration, _referenceAcceptor, monitor);
        _xblockexpression = null;
      }
      return _xblockexpression;
    };
    this.<Object>readOnly(sourceDeclarationURI, _function);
  }
  
  protected void findSourceDeclarations(final URI targetDeclarationURI, final IProgressMonitor monitor, final Procedure2<? super IEObjectDescription, ? super IReferenceDescription> acceptor) {
    final TargetURIs targetURIs = this.collectTargetURIs(targetDeclarationURI);
    IResourceServiceProvider.Registry _resourceServiceProviderRegistry = this.getResourceServiceProviderRegistry();
    final IAcceptor<IReferenceDescription> _function = (IReferenceDescription reference) -> {
      boolean _filterReference = this.filterReference(reference);
      if (_filterReference) {
        IEObjectDescription _findSourceDeclaration = null;
        if (reference!=null) {
          _findSourceDeclaration=this.findSourceDeclaration(reference);
        }
        final IEObjectDescription sourceDeclaration = _findSourceDeclaration;
        acceptor.apply(sourceDeclaration, reference);
      }
    };
    ReferenceAcceptor _referenceAcceptor = new ReferenceAcceptor(_resourceServiceProviderRegistry, _function);
    this.getReferenceFinder().findAllReferences(targetURIs, 
      this.getResourceAccess(), 
      this.getIndexData(), _referenceAcceptor, monitor);
  }
  
  protected TargetURIs collectTargetURIs(final URI targetURI) {
    final TargetURIs targetURIs = this.getTargetURIProvider().get();
    if ((targetURI == null)) {
      return targetURIs;
    }
    final IUnitOfWork<Object, EObject> _function = (EObject targetObject) -> {
      if ((targetObject != null)) {
        this.getTargetURICollector().add(targetObject, targetURIs);
      }
      return null;
    };
    this.<Object>readOnly(targetURI, _function);
    return targetURIs;
  }
  
  protected boolean filterReference(final IReferenceDescription reference) {
    return (reference != null);
  }
  
  protected IEObjectDescription findDeclaration(final URI objectURI) {
    return this.getDescription(objectURI);
  }
  
  protected IEObjectDescription findTargetDeclaration(final IReferenceDescription reference) {
    return this.findDeclaration(reference.getTargetEObjectUri());
  }
  
  protected IEObjectDescription findSourceDeclaration(final IReferenceDescription reference) {
    return this.findDeclaration(reference.getContainerEObjectURI());
  }
  
  /**
   * @return a root hierarchy node for the given declaration; cannot be <code>null</code>
   */
  protected IHierarchyNode createRoot(final IEObjectDescription declaration) {
    final DefaultHierarchyNode node = new DefaultHierarchyNode();
    node.setElement(declaration);
    node.setMayHaveChildren(true);
    return node;
  }
  
  /**
   * @return a child node for the given declaration and the parent node; cannot be <code>null</code>
   */
  protected IHierarchyNode createChild(final IEObjectDescription declaration, final IHierarchyNode parent) {
    final DefaultHierarchyNode node = new DefaultHierarchyNode();
    node.setParent(parent);
    node.setElement(declaration);
    boolean _isRecursive = node.isRecursive();
    boolean _not = (!_isRecursive);
    node.setMayHaveChildren(_not);
    return node;
  }
  
  protected IHierarchyNode createChild(final Map<URI, IHierarchyNode> children, final IEObjectDescription declaration, final IHierarchyNode parent) {
    if ((declaration == null)) {
      return null;
    }
    IHierarchyNode childNode = children.get(declaration.getEObjectURI());
    if ((childNode == null)) {
      childNode = this.createChild(declaration, parent);
      children.put(declaration.getEObjectURI(), childNode);
    }
    return childNode;
  }
  
  /**
   * @return a hierarchy node reference for the given reference; cannot be <code>null</code>
   */
  protected IHierarchyNodeReference createNodeReference(final IReferenceDescription reference) {
    final IUnitOfWork<DefaultHierarchyNodeReference, EObject> _function = (EObject sourceObject) -> {
      final ITextRegionWithLineInformation textRegion = this.getTextRegion(sourceObject, reference.getEReference(), reference.getIndexInList());
      final String text = this.getText(sourceObject, textRegion);
      return new DefaultHierarchyNodeReference(text, textRegion, reference);
    };
    return this.<DefaultHierarchyNodeReference>readOnly(reference.getSourceEObjectUri(), _function);
  }
  
  protected ITextRegionWithLineInformation getTextRegion(final EObject obj, final EReference reference, final int indexInList) {
    return this.getHierarchyNodeLocationProvider().getTextRegion(obj, reference, indexInList);
  }
  
  protected String getText(final EObject obj, final ITextRegionWithLineInformation textRegion) {
    if (((obj == null) || (textRegion == ITextRegionWithLineInformation.EMPTY_REGION))) {
      return "";
    }
    final ICompositeNode node = NodeModelUtils.getNode(EcoreUtil.getRootContainer(obj));
    if ((node == null)) {
      return "";
    }
    int _offset = textRegion.getOffset();
    int _length = textRegion.getLength();
    final int endOffset = (_offset + _length);
    return node.getRootNode().getText().substring(textRegion.getOffset(), endOffset);
  }
  
  @Pure
  public ICallHierarchyBuilder.CallHierarchyType getHierarchyType() {
    return this.hierarchyType;
  }
  
  public void setHierarchyType(final ICallHierarchyBuilder.CallHierarchyType hierarchyType) {
    this.hierarchyType = hierarchyType;
  }
}
