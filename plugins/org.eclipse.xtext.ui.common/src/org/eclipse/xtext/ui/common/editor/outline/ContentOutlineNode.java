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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class ContentOutlineNode {

	private String label;
	private Image image;
	private ImageDescriptor imageDescriptor;
	private int selectionOffset;
	private int selectionLength;
	private List<ContentOutlineNode> children;
	private ContentOutlineNode parent;
	private EClass clazz;

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Image getImage() {
		return image;
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

	public void setSelectionOffset(int selectionOffset) {
		this.selectionOffset = selectionOffset;
	}

	public int getSelectionOffset() {
		return selectionOffset;
	}

	public void setSelectionLength(int selectionLength) {
		this.selectionLength = selectionLength;
	}

	public int getSelectionLength() {
		return selectionLength;
	}

	public void setImageDescriptor(ImageDescriptor imageDescriptor) {
		this.imageDescriptor = imageDescriptor;
	}

	public ImageDescriptor getImageDescriptor() {
		return imageDescriptor;
	}

	public void setClazz(EClass clazz) {
		this.clazz = clazz;
	}

	public EClass getClazz() {
		return clazz;
	}

}