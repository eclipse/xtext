/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.tasks

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper

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
		leafNodes.map[findTasks(taskTags)].flatten.toList
	}

	protected def List<Task> findTasks(ILeafNode node, TaskTags taskTags) {
		if (node.canContainTaskTags) {
			//TODO strip comment characters before parsing, see https://bugs.eclipse.org/bugs/show_bug.cgi?id=380449#c13
			val tasks = parser.parseTasks(node.text, taskTags)
			for (it : tasks) {
				offset = offset + node.offset
				lineNumber = lineNumber + node.startLine - 1
			}
			return tasks
		}
		return #[]
	}

	protected def boolean canContainTaskTags(ILeafNode node) {
		val rule = node.grammarElement
		if (rule instanceof AbstractRule) {
			return hiddenTokenHelper.isComment(rule)
		}
		return false;
	}
}
