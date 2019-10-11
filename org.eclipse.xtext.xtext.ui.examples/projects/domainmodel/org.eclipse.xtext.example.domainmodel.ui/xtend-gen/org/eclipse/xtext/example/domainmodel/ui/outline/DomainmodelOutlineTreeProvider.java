/**
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.ui.outline;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;

/**
 * Customization of the default outline structure.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
 */
@SuppressWarnings("all")
public class DomainmodelOutlineTreeProvider extends DefaultOutlineTreeProvider {
  @Override
  protected void _createChildren(final DocumentRootNode parentNode, final EObject rootElement) {
    EList<EObject> _eContents = rootElement.eContents();
    for (final EObject content : _eContents) {
      this.createNode(parentNode, content);
    }
  }
  
  protected boolean _isLeaf(final Feature feature) {
    return true;
  }
}
