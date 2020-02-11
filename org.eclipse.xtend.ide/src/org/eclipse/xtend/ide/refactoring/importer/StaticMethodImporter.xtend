/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring.importer

import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.ui.document.DocumentRewriter

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
class StaticMethodImporter extends AbstractStaticMethodImporter {

    override protected void computeChange(XMemberFeatureCall call, DocumentRewriter rewriter) {
        val memberNode = NodeModelUtils.findActualNodeFor(call.memberCallTarget)
        val dotNode = memberNode.findDot

        if (dotNode === null)
            return;
        // this will remove the memberCallTarget up to "." or "::"
        // |Other.|doSomething('test') or |Other::|doSomething('test')
        rewriter.newSection(memberNode.offset, memberNode.length)
        rewriter.newSection(dotNode.offset, dotNode.length)
    }

    /**
     * Attempts to find the next dot (.) or ::
     * 
     * @return the dot/:: node or null
     */
    def private findDot(INode node) {
        var sibling = node
        while (sibling.hasNextSibling) {
            if (sibling.grammarElement == grammar.XMemberFeatureCallAccess.fullStopKeyword_1_1_0_0_1_0 ||
                sibling.grammarElement ==
                    grammar.XMemberFeatureCallAccess.explicitStaticColonColonKeyword_1_1_0_0_1_2_0)
                return sibling
            sibling = sibling.nextSibling
        }
    }

}
