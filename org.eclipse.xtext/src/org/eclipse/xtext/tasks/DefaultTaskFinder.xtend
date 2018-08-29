/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.tasks

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.Collections
import java.util.List
import java.util.regex.Pattern
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.documentation.impl.AbstractMultiLineCommentProvider
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper
import org.eclipse.xtext.resource.XtextResource

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
class DefaultTaskFinder implements ITaskFinder {
	@Inject
	ITaskParser parser
	@Inject
	ITaskTagProvider taskTagProvider
	@Inject
	IHiddenTokenHelper hiddenTokenHelper
	Pattern endTagPattern = Pattern.compile("\\*/\\z")

	/**
	 * this method is not intended to be called by clients
	 * @since 2.12
	 */
	@Inject(optional=true)
	protected def setEndTag(@Named(AbstractMultiLineCommentProvider.END_TAG) String endTag) {
		endTagPattern = Pattern.compile(endTag+"\\z")
	}

	override findTasks(Resource resource) {
		val taskTags = taskTagProvider.getTaskTags(resource)
		if(taskTags.empty) return #[]
		if (resource instanceof XtextResource) {
			resource.parseResult?.rootNode?.findTasks(taskTags) ?: #[]
		} else {
			#[]
		}
	}

	protected def List<Task> findTasks(ICompositeNode it, TaskTags taskTags) {
		val result = newArrayList
		leafNodes.forEach[result.addAll(findTasks(taskTags))]
		return result
	}

	protected def List<Task> findTasks(ILeafNode node, TaskTags taskTags) {
		if (node.canContainTaskTags) {
			//TODO strip comment characters before parsing, see https://bugs.eclipse.org/bugs/show_bug.cgi?id=380449#c13
			val tasks = parser.parseTasks(stripText(node, node.text), taskTags)
			tasks.forEach [
				offset = offset + node.offset
				lineNumber = lineNumber + node.startLine - 1
			]
			return tasks
		}
		return Collections.emptyList
	}

	/**
	 * @since 2.12
	 */
	protected def String stripText(ILeafNode node, String text) {
		return endTagPattern.matcher(text).replaceAll("")
	}

	protected def boolean canContainTaskTags(ILeafNode node) {
		val rule = node.grammarElement
		if (rule instanceof AbstractRule) {
			return hiddenTokenHelper.isComment(rule)
		}
		return false;
	}
}
