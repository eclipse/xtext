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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultCallHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeLocationProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.hierarchy.XtextCallHierarchyNode;
import org.eclipse.xtext.ui.editor.hierarchy.XtextCallHierarchyNodeLocationProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
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
  protected IHierarchyNodeLocationProvider getHierarchyNodeLocationProvider() {
    return this.callHierarchyNodeLocationProvider;
  }
  
  @Override
  protected IEObjectDescription findDeclaration(final URI objectURI) {
    final IEObjectDescription description = this.getDescription(objectURI);
    EClass _eClass = null;
    if (description!=null) {
      _eClass=description.getEClass();
    }
    boolean _isRule = this.isRule(_eClass);
    if (_isRule) {
      return description;
    }
    final IUnitOfWork<IEObjectDescription, EObject> _function = new IUnitOfWork<IEObjectDescription, EObject>() {
      @Override
      public IEObjectDescription exec(final EObject object) throws Exception {
        AbstractRule _containerOfType = EcoreUtil2.<AbstractRule>getContainerOfType(object, AbstractRule.class);
        return XtextCallHierarchyBuilder.this.getDescription(_containerOfType);
      }
    };
    return this.<IEObjectDescription>readOnly(objectURI, _function);
  }
  
  @Override
  protected boolean filterReference(final IReferenceDescription reference) {
    return ((reference != null) && this.isRule(reference.getEReference().getEType()));
  }
  
  @Override
  protected IEObjectDescription findSourceDeclaration(final IReferenceDescription reference) {
    URI _containerEObjectURI = reference.getContainerEObjectURI();
    return this.getDescription(_containerEObjectURI);
  }
  
  protected boolean isRule(final EClassifier type) {
    return this.isAssignable(XtextPackage.Literals.ABSTRACT_RULE, type);
  }
  
  @Override
  protected IHierarchyNode createRoot(final IEObjectDescription declaration) {
    final XtextCallHierarchyNode node = new XtextCallHierarchyNode();
    node.setElement(declaration);
    IEObjectDescription _grammarDescription = this.getGrammarDescription(declaration);
    node.setGrammarDescription(_grammarDescription);
    node.setMayHaveChildren(true);
    return node;
  }
  
  @Override
  protected IHierarchyNode createChild(final IEObjectDescription declaration, final IHierarchyNode parent) {
    final XtextCallHierarchyNode node = new XtextCallHierarchyNode();
    node.setParent(parent);
    node.setElement(declaration);
    IEObjectDescription _grammarDescription = this.getGrammarDescription(declaration);
    node.setGrammarDescription(_grammarDescription);
    node.setMayHaveChildren((this.isRule(declaration.getEClass()) && (!node.isRecursive())));
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
