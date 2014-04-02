/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import java.util.List;

import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tasks.ITaskFinder;
import org.eclipse.xtext.tasks.Task;

import com.google.inject.Inject;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
public class DefaultSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

	@Inject
	private ITaskFinder taskFinder;

	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if (resource == null)
			return;
		IParseResult parseResult = resource.getParseResult();
		if (parseResult == null || parseResult.getRootASTElement() == null)
			return;
		doProvideHighlightingFor(resource, acceptor);
	}

	/**
	 * <p>
	 * Actual implementation of the semantic highlighting calculation. It is ensured, that the given resource is not
	 * <code>null</code> and refers to an initialized parse result.
	 * </p>
	 * <p>
	 * Clients should override this method in order to perform custom highlighting.
	 * </p>
	 * 
	 * @param resource
	 *            a valid to-be-processed resource. Is never <code>null</code>.
	 * @param acceptor
	 *            the acceptor. Is never <code>null</code>.
	 */
	protected void doProvideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		highlightTasks(resource, acceptor);
	}
	
	protected void highlightTasks(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		List<Task> tasks = taskFinder.findTasks(resource);
		for (Task task : tasks) {
			acceptor.addPosition(task.getOffset(), task.getTagLength(), DefaultHighlightingConfiguration.TASK_ID);
		}
	}
}
