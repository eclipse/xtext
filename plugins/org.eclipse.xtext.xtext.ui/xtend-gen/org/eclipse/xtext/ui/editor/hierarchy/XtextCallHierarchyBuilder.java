/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultCallHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNodeLocationProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.hierarchy.XtextCallHierarchyNode;
import org.eclipse.xtext.ui.editor.hierarchy.XtextCallHierarchyNodeLocationProvider;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public class XtextCallHierarchyBuilder extends DefaultCallHierarchyBuilder {
  @Inject
  private XtextCallHierarchyNodeLocationProvider callHierarchyNodeLocationProvider;
  
  @Override
  protected HierarchyNodeLocationProvider getHierarchyNodeLocationProvider() {
    return this.callHierarchyNodeLocationProvider;
  }
  
  @Override
  protected IEObjectDescription getRootDeclaration(final IEObjectDescription declaration) {
    EClass _eClass = null;
    if (declaration!=null) {
      _eClass=declaration.getEClass();
    }
    boolean _isRule = this.isRule(_eClass);
    if (_isRule) {
      return declaration;
    }
    return null;
  }
  
  @Override
  protected IEObjectDescription getDeclaration(final IReferenceDescription reference) {
    EReference _eReference = null;
    if (reference!=null) {
      _eReference=reference.getEReference();
    }
    EClassifier _eType = null;
    if (_eReference!=null) {
      _eType=_eReference.getEType();
    }
    final EClassifier type = _eType;
    boolean _matched = false;
    if (type instanceof EClass) {
      boolean _isRule = this.isRule(((EClass)type));
      if (_isRule) {
        _matched=true;
        return super.getDeclaration(reference);
      }
    }
    return null;
  }
  
  protected boolean isRule(final EClass type) {
    return EcoreUtil2.isAssignableFrom(XtextPackage.Literals.ABSTRACT_RULE, type);
  }
  
  @Override
  protected HierarchyNode createRoot(final IEObjectDescription declaration) {
    final XtextCallHierarchyNode node = new XtextCallHierarchyNode();
    node.setElement(declaration);
    IEObjectDescription _grammarDescription = this.getGrammarDescription(declaration);
    node.setGrammarDescription(_grammarDescription);
    node.setMayHaveChildren(true);
    return node;
  }
  
  @Override
  protected HierarchyNode createChild(final IEObjectDescription declaration, final HierarchyNode parent) {
    final XtextCallHierarchyNode node = new XtextCallHierarchyNode();
    node.setParent(parent);
    node.setElement(declaration);
    IEObjectDescription _grammarDescription = this.getGrammarDescription(declaration);
    node.setGrammarDescription(_grammarDescription);
    boolean _isRecursive = node.isRecursive();
    boolean _not = (!_isRecursive);
    node.setMayHaveChildren(_not);
    return node;
  }
  
  protected IEObjectDescription getGrammarDescription(final IEObjectDescription description) {
    IEObjectDescription _xblockexpression = null;
    {
      URI _eObjectURI = description.getEObjectURI();
      final URI resourceURI = _eObjectURI.trimFragment();
      IResourceDescriptions _indexData = this.getIndexData();
      IResourceDescription _resourceDescription = _indexData.getResourceDescription(resourceURI);
      Iterable<IEObjectDescription> _exportedObjectsByType = _resourceDescription.getExportedObjectsByType(XtextPackage.Literals.GRAMMAR);
      _xblockexpression = IterableExtensions.<IEObjectDescription>head(_exportedObjectsByType);
    }
    return _xblockexpression;
  }
}
