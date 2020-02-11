/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tasks

import org.eclipse.xtext.tasks.DefaultTaskFinder
import com.google.inject.Inject
import org.eclipse.xtend.core.services.XtendGrammarAccess
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.RuleCall

/**
 * @author Christian Dietrich - Initial contribution and API
 * @since 
 */
class XtendTaskFinder extends DefaultTaskFinder {

	@Inject extension XtendGrammarAccess

	override protected canContainTaskTags(ILeafNode node) {
		var result = super.canContainTaskTags(node)
		if (!result) {
			return node.isRichComment
		}
		return result
	}

	override protected stripText(ILeafNode node, String text) {
		if (node.isRichComment) {
			val char newLine = '\n'
			val index = text.indexOf(newLine)
			if (index !== -1) {
				return text.substring(0, index)
			}
			return text
		}
		super.stripText(node, text)
	}

	private def isRichComment(ILeafNode node) {
		if (node.grammarElement instanceof RuleCall) {
			return (node.grammarElement as RuleCall).rule == COMMENT_RICH_TEXT_ENDRule ||
				(node.grammarElement as RuleCall).rule == COMMENT_RICH_TEXT_INBETWEENRule 
		}
		return false
	}

}
