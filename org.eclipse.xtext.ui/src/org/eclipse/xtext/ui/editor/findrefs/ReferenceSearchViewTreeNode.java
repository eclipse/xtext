/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.ide.editor.navigation.INavigatable;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.Lists;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReferenceSearchViewTreeNode implements INavigatable {

	private ReferenceSearchViewTreeNode parent;

	private List<ReferenceSearchViewTreeNode> children;

	private Object labelDescription;

	private Object description;
	
	public ReferenceSearchViewTreeNode(ReferenceSearchViewTreeNode parent, Object description, Object labelDescription) {
		super();
		this.parent = parent;
		this.description = description;
		this.labelDescription = labelDescription;
		if (parent != null) {
			parent.addChild(this);
		}
	}

	public ReferenceSearchViewTreeNode getParent() {
		return parent;
	}

	public List<ReferenceSearchViewTreeNode> getChildren() {
		if (children == null) {
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(children);
	}

	public void addChild(ReferenceSearchViewTreeNode child) {
		if (children == null) {
			children = Lists.newArrayList();
		}
		children.add(child);
	}
	
	public void removeChild(ReferenceSearchViewTreeNode child) {
		if(children != null) {
			children.remove(child);
		}
	}

	public Object getDescription() {
		return description;
	}
	
	public Object getLabelDescription() {
		return labelDescription;
	}

	@Override
	public Object getNavigationElement() {
		return getDescription();
	}
	
	/**
	 * recursively collects the node's description into the given {@link IAcceptor} including the node's children.
	 * Only IReferenceDescriptions are collected
	 */
	public void collectReferenceDescriptions(IAcceptor<IReferenceDescription> descriptionsAcceptor) {
		if(description instanceof IReferenceDescription) {
			descriptionsAcceptor.accept((IReferenceDescription) description);
		}
		for (ReferenceSearchViewTreeNode child : getChildren()) {
			child.collectReferenceDescriptions(descriptionsAcceptor);
		}
	}
}
