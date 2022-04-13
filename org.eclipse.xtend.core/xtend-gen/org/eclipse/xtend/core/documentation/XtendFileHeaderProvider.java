/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.documentation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.documentation.impl.MultiLineFileHeaderProvider;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFileHeaderProvider extends MultiLineFileHeaderProvider {
  @Inject
  private IEObjectDocumentationProvider documentationProvider;

  @Override
  public List<INode> getFileHeaderNodes(final Resource resource) {
    if ((resource instanceof XtextResource)) {
      final IParseResult parseResult = ((XtextResource)resource).getParseResult();
      if ((parseResult != null)) {
        Iterable<ILeafNode> _leafNodes = parseResult.getRootNode().getLeafNodes();
        for (final ILeafNode leafNode : _leafNodes) {
          {
            boolean break_ = true;
            final EObject grammarElement = leafNode.getGrammarElement();
            if ((grammarElement instanceof TerminalRule)) {
              final String terminalRuleName = ((TerminalRule)grammarElement).getName();
              boolean _equalsIgnoreCase = this.ruleName.equalsIgnoreCase(terminalRuleName);
              if (_equalsIgnoreCase) {
                boolean _isTypeComment = this.isTypeComment(leafNode, resource);
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

  private boolean isTypeComment(final ILeafNode leafNode, final Resource resource) {
    final EObject content = IterableExtensions.<EObject>head(resource.getContents());
    if ((content instanceof XtendFile)) {
      final XtendTypeDeclaration type = IterableExtensions.<XtendTypeDeclaration>head(((XtendFile)content).getXtendTypes());
      if ((type != null)) {
        if ((this.documentationProvider instanceof IEObjectDocumentationProviderExtension)) {
          INode _head = IterableExtensions.<INode>head(((IEObjectDocumentationProviderExtension)this.documentationProvider).getDocumentationNodes(type));
          return Objects.equal(leafNode, _head);
        }
      }
    }
    return false;
  }
}
