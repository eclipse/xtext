/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.tasks;

import static com.google.common.collect.Iterables.*;
import static java.util.Collections.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.documentation.impl.AbstractMultiLineCommentProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
public class DefaultTaskFinder implements ITaskFinder {
	@Inject
	private ITaskParser parser;

	@Inject
	private ITaskTagProvider taskTagProvider;

	@Inject
	private IHiddenTokenHelper hiddenTokenHelper;

	private Pattern endTagPattern = Pattern.compile("\\*/\\z");

	/**
	 * this method is not intended to be called by clients
	 *
	 * @since 2.12
	 */
	@Inject(optional = true)
	protected Pattern setEndTag(@Named(AbstractMultiLineCommentProvider.END_TAG) String endTag) {
		return endTagPattern = Pattern.compile(endTag + "\\z");
	}

	@Override
	public List<Task> findTasks(Resource resource) {
		TaskTags taskTags = taskTagProvider.getTaskTags(resource);
		if (isEmpty(taskTags) || !(resource instanceof XtextResource)) {
			return emptyList();
		}
		IParseResult parseResult = ((XtextResource) resource).getParseResult();
		if (parseResult == null || parseResult.getRootNode() == null) {
			return emptyList();
		}
		List<Task> tasks = findTasks(parseResult.getRootNode(), taskTags);
		return unmodifiableList(tasks);
	}

	protected List<Task> findTasks(ICompositeNode node, TaskTags taskTags) {
		ArrayList<Task> result = new ArrayList<>();
		node.getLeafNodes().forEach(leaf -> result.addAll(this.findTasks(leaf, taskTags)));
		return result;
	}

	protected List<Task> findTasks(ILeafNode node, TaskTags taskTags) {
		if (!canContainTaskTags(node)) {
			return emptyList();
		}
		List<Task> tasks = parser.parseTasks(stripText(node, node.getText()), taskTags);
		tasks.forEach(it -> {
			it.setOffset(it.getOffset() + node.getOffset());
			it.setLineNumber(it.getLineNumber() + node.getStartLine() - 1);
		});
		return tasks;
	}

	/**
	 * @since 2.12
	 */
	protected String stripText(ILeafNode node, String text) {
		return endTagPattern.matcher(text).replaceAll("");
	}

	protected boolean canContainTaskTags(ILeafNode node) {
		EObject rule = node.getGrammarElement();
		if (rule instanceof AbstractRule) {
			return hiddenTokenHelper.isComment((AbstractRule) rule);
		}
		return false;
	}
}
