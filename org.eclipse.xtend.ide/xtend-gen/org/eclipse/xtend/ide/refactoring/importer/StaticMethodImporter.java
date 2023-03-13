/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.refactoring.importer;

import com.google.common.base.Objects;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.ui.document.DocumentRewriter;

/**
 * Computes changes necessary on a method call to use with a static import.
 * 
 * e.g.:<br>
 * <pre>
 * // before
 * import test.other.Other
 * 
 * Other.doSomething('test')
 * 
 * // after
 * import static test.other.Other.doSomething
 * 
 * doSomething('test')
 * </pre>
 * 
 * @author vivien.jovet - Initial contribution and API
 */
@SuppressWarnings("all")
public class StaticMethodImporter extends AbstractStaticMethodImporter {
  @Override
  protected void computeChange(final XMemberFeatureCall call, final DocumentRewriter rewriter) {
    final ICompositeNode memberNode = NodeModelUtils.findActualNodeFor(call.getMemberCallTarget());
    final INode dotNode = this.findDot(memberNode);
    if ((dotNode == null)) {
      return;
    }
    rewriter.newSection(memberNode.getOffset(), memberNode.getLength());
    rewriter.newSection(dotNode.getOffset(), dotNode.getLength());
  }

  /**
   * Attempts to find the next dot (.) or ::
   * 
   * @return the dot/:: node or null
   */
  private INode findDot(final INode node) {
    INode sibling = node;
    while (sibling.hasNextSibling()) {
      {
        if ((Objects.equal(sibling.getGrammarElement(), this.grammar.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0()) || 
          Objects.equal(sibling.getGrammarElement(), 
            this.grammar.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_1_0_0_1_2_0()))) {
          return sibling;
        }
        sibling = sibling.getNextSibling();
      }
    }
    return null;
  }
}
