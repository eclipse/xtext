/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.util;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class InsertionOffsets {
  public int before(final EObject element) {
    ICompositeNode _findActualNodeFor = NodeModelUtils.findActualNodeFor(element);
    return _findActualNodeFor.getOffset();
  }
  
  public int after(final EObject element) {
    int _xblockexpression = (int) 0;
    {
      final ICompositeNode node = NodeModelUtils.findActualNodeFor(element);
      _xblockexpression = node.getEndOffset();
    }
    return _xblockexpression;
  }
  
  public int inEmpty(final EObject element) {
    int _xblockexpression = (int) 0;
    {
      final ICompositeNode node = NodeModelUtils.findActualNodeFor(element);
      Iterable<ILeafNode> _leafNodes = node.getLeafNodes();
      final Function1<ILeafNode, Boolean> _function = new Function1<ILeafNode, Boolean>() {
        public Boolean apply(final ILeafNode it) {
          String _text = it.getText();
          return Boolean.valueOf(Objects.equal(_text, "{"));
        }
      };
      final ILeafNode openingBraceNode = IterableExtensions.<ILeafNode>findFirst(_leafNodes, _function);
      int _xifexpression = (int) 0;
      boolean _notEquals = (!Objects.equal(openingBraceNode, null));
      if (_notEquals) {
        int _offset = openingBraceNode.getOffset();
        _xifexpression = (_offset + 1);
      } else {
        _xifexpression = node.getEndOffset();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
