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
import org.eclipse.xtext.common.services.TerminalsGrammarAccess
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
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
	TerminalsGrammarAccess terminals

	override findTasks(Resource resource) {
		val taskTags = taskTagProvider.getTaskTags(resource)
		if(taskTags.empty) return #[]
		if (resource instanceof XtextResource) {
			resource.parseResult?.rootNode?.findTasks(taskTags) ?: #[]
		}
	}

	protected def List<Task> findTasks(ICompositeNode it, TaskTags taskTags) {
		leafNodes.map[findTasks(taskTags)].flatten.toList
	}

	protected def List<Task> findTasks(ILeafNode node, TaskTags taskTags) {
		if (node.canContainTaskTags) {
			val tasks = parser.parseTasks(node.text, taskTags)
			tasks.forEach [
				offset = offset + node.offset
				lineNumber = lineNumber + node.startLine - 1
			]
			return tasks
		}
		return #[]
	}

	protected def boolean canContainTaskTags(ILeafNode node) {
		if (terminals.grammar !== null) {
			return node.grammarElement == terminals.ML_COMMENTRule ||
				node.grammarElement == terminals.SL_COMMENTRule
		}
		return false;
	}
}
