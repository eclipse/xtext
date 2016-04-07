/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.outline;

import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.example.arithmetics.arithmetics.Definition;
import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;

/**
 * Customization of the default outline structure.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline
 */
@SuppressWarnings("all")
public class ArithmeticsOutlineTreeProvider extends DefaultOutlineTreeProvider {
  public void _createChildren(final IOutlineNode parentNode, final Module module) {
    EList<EObject> _eContents = module.eContents();
    Iterable<Definition> _filter = Iterables.<Definition>filter(_eContents, Definition.class);
    for (final Definition it : _filter) {
      this.createNode(parentNode, it);
    }
  }
  
  public boolean _isLeaf(final Definition definition) {
    return true;
  }
}
