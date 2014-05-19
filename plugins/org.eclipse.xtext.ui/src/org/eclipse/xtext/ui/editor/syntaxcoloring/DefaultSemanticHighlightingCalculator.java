/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tasks.ITaskFinder;
import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.util.ITextRegion;

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
	 * By default this will visit the elements in the resource recursively and call
	 * {@link #highlightElement(EObject, IHighlightedPositionAcceptor)} for each of them. As the last step, tasks will
	 * be highlighted.
	 * </p>
	 * <p>
	 * Clients can override this method if the default recursive approach does not fit their use case
	 * </p>
	 * 
	 * @param resource
	 *            a valid to-be-processed resource. Is never <code>null</code>.
	 * @param acceptor
	 *            the acceptor. Is never <code>null</code>.
	 */
	protected void doProvideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		searchAndHighlightElements(resource, acceptor);
		highlightTasks(resource, acceptor);
	}

	protected void searchAndHighlightElements(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult == null)
			throw new IllegalStateException("resource#parseResult may not be null");
		EObject element = parseResult.getRootASTElement();
		highlightElementRecursively(element, acceptor);
	}

	protected void highlightElementRecursively(EObject element, IHighlightedPositionAcceptor acceptor) {
		TreeIterator<EObject> iterator = EcoreUtil2.eAll(element);
		while (iterator.hasNext()) {
			EObject object = iterator.next();
			if (highlightElement(object, acceptor)) {
				iterator.prune();
			}
		}
	}

	/**
	 * @return true to skip the children of this element false otherwise
	 */
	protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor) {
		return false;
	}

	protected void highlightTasks(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		List<Task> tasks = taskFinder.findTasks(resource);
		for (Task task : tasks) {
			acceptor.addPosition(task.getOffset(), task.getTagLength(), DefaultHighlightingConfiguration.TASK_ID);
		}
	}

	/**
	 * Highlights an object at the position of the given {@link EStructuralFeature}
	 */
	protected void highlightFeature(IHighlightedPositionAcceptor acceptor, EObject object, EStructuralFeature feature,
			String... styleIds) {
		List<INode> children = NodeModelUtils.findNodesForFeature(object, feature);
		if (children.size() > 0)
			highlightNode(acceptor, children.get(0), styleIds);
	}

	/**
	 * Highlights the non-hidden parts of {@code node} with the styles given by the {@code styleIds}
	 */
	protected void highlightNode(IHighlightedPositionAcceptor acceptor, INode node, String... styleIds) {
		if (node == null)
			return;
		if (node instanceof ILeafNode) {
			ITextRegion textRegion = node.getTextRegion();
			acceptor.addPosition(textRegion.getOffset(), textRegion.getLength(), styleIds);
		} else {
			for (ILeafNode leaf : node.getLeafNodes()) {
				if (!leaf.isHidden()) {
					ITextRegion leafRegion = leaf.getTextRegion();
					acceptor.addPosition(leafRegion.getOffset(), leafRegion.getLength(), styleIds);
				}
			}
		}
	}
}
