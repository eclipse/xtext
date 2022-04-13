/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.outline;

import java.util.List;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.OutlineWithEditorLinker;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendOutlineWithEditorLinker extends OutlineWithEditorLinker {
  @Override
  public void selectInTreeView(final ISelection selection) {
    if (((selection instanceof ITextSelection) && (!this.treeViewer.getTree().isDisposed()))) {
      final ITextSelection textSelection = ((ITextSelection) selection);
      int _offset = textSelection.getOffset();
      int _length = textSelection.getLength();
      final TextRegion selectedTextRegion = new TextRegion(_offset, _length);
      final Object input = this.treeViewer.getInput();
      if ((input instanceof IOutlineNode)) {
        final List<IOutlineNode> matchingNodes = CollectionLiterals.<IOutlineNode>newArrayList();
        this.findNodesInRange(((IOutlineNode)input), selectedTextRegion, matchingNodes);
        boolean _isEmpty = matchingNodes.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          final Function1<IOutlineNode, Integer> _function = (IOutlineNode it) -> {
            return Integer.valueOf(it.getFullTextRegion().getLength());
          };
          final Integer smallestMatch = IterableExtensions.<Integer>min(ListExtensions.<IOutlineNode, Integer>map(matchingNodes, _function));
          final Function1<IOutlineNode, Boolean> _function_1 = (IOutlineNode it) -> {
            int _length_1 = it.getFullTextRegion().getLength();
            return Boolean.valueOf((_length_1 == (smallestMatch).intValue()));
          };
          final Iterable<IOutlineNode> nodesToBeSelected = IterableExtensions.<IOutlineNode>filter(matchingNodes, _function_1);
          boolean _isEmpty_1 = IterableExtensions.isEmpty(nodesToBeSelected);
          boolean _not_1 = (!_isEmpty_1);
          if (_not_1) {
            Object[] _array = IterableExtensions.<IOutlineNode>toList(nodesToBeSelected).toArray();
            StructuredSelection _structuredSelection = new StructuredSelection(_array);
            this.treeViewer.setSelection(_structuredSelection);
          }
        }
      }
    }
  }

  protected void findNodesInRange(final IOutlineNode input, final ITextRegion selectedTextRegion, final List<IOutlineNode> nodes) {
    final ITextRegion textRegion = input.getFullTextRegion();
    if (((textRegion == null) || textRegion.contains(selectedTextRegion))) {
      nodes.add(input);
    }
    List<IOutlineNode> _children = input.getChildren();
    for (final IOutlineNode child : _children) {
      this.findNodesInRange(child, selectedTextRegion, nodes);
    }
  }
}
