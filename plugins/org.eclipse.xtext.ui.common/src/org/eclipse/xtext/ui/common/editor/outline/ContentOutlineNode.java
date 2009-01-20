/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class ContentOutlineNode {

	private String label;
	private String image;
	private EObject semanticNode;
	private List<ContentOutlineNode> children;
	private ContentOutlineNode parent;

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setSemanticNode(EObject semanticNode) {
		this.semanticNode = semanticNode;
	}

	public EObject getSemanticNode() {
		return semanticNode;
	}

	public void setChildren(List<ContentOutlineNode> children) {
		this.children = children;
	}

	public List<ContentOutlineNode> getChildren() {
		if (children == null) {
			children = new ArrayList<ContentOutlineNode>();
		}
		return children;
	}

	public void setParent(ContentOutlineNode outlineParentNode) {
		this.parent = outlineParentNode;
	}
	
	public ContentOutlineNode getParent() {
		return parent;
	}

}
