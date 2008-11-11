/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline;

import java.util.Arrays;
import java.util.Comparator;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class NodeBasedTreeContentProvider implements ITreeContentProvider {

	private static Logger log = Logger.getLogger(NodeBasedTreeContentProvider.class);

	private ITreeContentProvider delegate;

	public NodeBasedTreeContentProvider(ITreeContentProvider delegate) {
		super();
		this.delegate = delegate;
	}

	public Object[] getChildren(Object parentElement) {
		Object[] children = (Object[]) delegate.getChildren(parentElement);
		Arrays.sort(children, new Comparator<Object>() {

			public int compare(Object o1, Object o2) {
				if (!(o1 instanceof EObject)) {
					log.error("Expected EObject was "+o1);
					return -1;
				}
				if (!(o2 instanceof EObject)) {
					log.error("Expected EObject was "+o2);
					return 1;
				}
				NodeAdapter nodeAdapter1 = NodeUtil.getNodeAdapter((EObject) o1);
				NodeAdapter nodeAdapter2 = NodeUtil.getNodeAdapter((EObject) o2);
				if (nodeAdapter1 == null)
					return -1;
				if (nodeAdapter2 == null)
					return 1;
				return ((Integer) nodeAdapter1.getParserNode().getOffset()).compareTo(nodeAdapter2.getParserNode()
						.getOffset());
			}
		});
		return children;
	}

	public Object getParent(Object element) {
		return delegate.getParent(element);
	}

	public boolean hasChildren(Object element) {
		return delegate.hasChildren(element);
	}

	public Object[] getElements(Object inputElement) {
		return delegate.getElements(inputElement);
	}

	public void dispose() {
		delegate.dispose();
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		delegate.inputChanged(viewer, oldInput, newInput);
	}

}
