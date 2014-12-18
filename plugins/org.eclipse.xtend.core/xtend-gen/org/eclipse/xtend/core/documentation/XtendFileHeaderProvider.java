/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.documentation;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.documentation.impl.MultiLineFileHeaderProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFileHeaderProvider extends MultiLineFileHeaderProvider {
  public List<INode> getFileHeaderNodes(final Resource resource) {
    if ((resource instanceof XtextResource)) {
      final IParseResult parseResult = ((XtextResource)resource).getParseResult();
      boolean _notEquals = (!Objects.equal(parseResult, null));
      if (_notEquals) {
        ICompositeNode _rootNode = parseResult.getRootNode();
        Iterable<ILeafNode> _leafNodes = _rootNode.getLeafNodes();
        for (final ILeafNode leafNode : _leafNodes) {
          {
            boolean break_ = true;
            final EObject grammarElement = leafNode.getGrammarElement();
            if ((grammarElement instanceof TerminalRule)) {
              final String terminalRuleName = ((TerminalRule)grammarElement).getName();
              boolean _equalsIgnoreCase = this.ruleName.equalsIgnoreCase(terminalRuleName);
              if (_equalsIgnoreCase) {
                boolean _isTypeComment = this.isTypeComment(leafNode);
                boolean _not = (!_isTypeComment);
                if (_not) {
                  return Collections.<INode>singletonList(((INode) leafNode));
                }
              } else {
                boolean _equals = this.wsRuleName.equals(terminalRuleName);
                if (_equals) {
                  break_ = false;
                }
              }
            }
            if (break_) {
              return Collections.<INode>emptyList();
            }
          }
        }
      }
    }
    return Collections.<INode>emptyList();
  }
  
  private boolean isTypeComment(final ILeafNode leafNode) {
    INode node = leafNode;
    EObject grammarElement = null;
    do {
      {
        INode _nextSibling = node.getNextSibling();
        node = _nextSibling;
        EObject _grammarElement = null;
        if (node!=null) {
          _grammarElement=node.getGrammarElement();
        }
        grammarElement = _grammarElement;
      }
    } while(((grammarElement instanceof TerminalRule) && this.wsRuleName.equals(((TerminalRule) grammarElement).getName())));
    ICompositeNode _parent = null;
    if (node!=null) {
      _parent=node.getParent();
    }
    EObject _semanticElement = null;
    if (_parent!=null) {
      _semanticElement=_parent.getSemanticElement();
    }
    return (_semanticElement instanceof XtendTypeDeclaration);
  }
}
