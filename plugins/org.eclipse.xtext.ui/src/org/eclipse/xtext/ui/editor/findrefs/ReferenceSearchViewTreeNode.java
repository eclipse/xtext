/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import java.util.Collections;
import java.util.List;


import com.google.common.collect.Lists;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReferenceSearchViewTreeNode {

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

}
