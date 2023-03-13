/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring.importer

import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.ui.document.DocumentRewriter
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression
import org.eclipse.xtext.xbase.XSynchronizedExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall

/**
 * Computes changes necessary on a method call to use with a static extension import.
 * 
 * e.g.:<br>
 * <pre>
 * // before
 * import test.other.Other
 * 
 * Other.doSomething('test')
 * 
 * // after
 * import static extension test.other.Other.doSomething
 * 
 * 'test'.doSomething()
 * </pre>
 * 
 * @author vivien.jovet - Initial contribution and API
 */
class StaticExtensionMethodImporter extends StaticMethodImporter {

    override protected useExtension() { true }

    override protected computeChange(XMemberFeatureCall call, DocumentRewriter rewriter) {
        if (call.memberCallArguments.empty)
            super.computeChange(call, rewriter)
        else {
            val firstArg = call.memberCallArguments.head
            val firstArgNode = NodeModelUtils.findActualNodeFor(firstArg)
            val firstArgText = rewriter.document.get(firstArgNode.offset, firstArgNode.length)
            // if there is more than one arg it needs to remove up to the second arg to remove the comma (,)
            val replaceLength = if (call.memberCallArguments.size > 1) {
                    val secondArgNode = NodeModelUtils.findActualNodeFor(call.memberCallArguments.get(1))
                    secondArgNode.offset - firstArgNode.offset
                } else
                    firstArgNode.length

            val memberNode = NodeModelUtils.findActualNodeFor(call.memberCallTarget)
            
            // wrap the memberCallTarget in ( ) if necessary
            val replaceText = firstArg.shouldWrap
                    ? '''(«firstArgText»)''' : firstArgText
            try {
                // remove the first argument Other.doSomething(|'test'|, 'other')
                rewriter.newSection(firstArgNode.offset, replaceLength)
                // replace the memberCallTarget with the first arg |Other|.doSomething('other')
                rewriter.newSection(memberNode.offset, memberNode.length).append(replaceText)
            } catch (IllegalArgumentException ignored) {
                // this means that the changes are overlapping other changes like in Other.test(Other.test('a'))
            }
        }
    }
    
    /**
     * Returns true if the expression should be wrapped in ( )
     * in order to accept a static extension call.
     */
    def private shouldWrap(XExpression expression) {
        switch expression {
            XMemberFeatureCall,
            XFeatureCall:
                false
            XAbstractFeatureCall,
            XSwitchExpression,
            XTryCatchFinallyExpression,
            XSynchronizedExpression,
            XIfExpression:
                true
            default:
                false
        }
    }

}
