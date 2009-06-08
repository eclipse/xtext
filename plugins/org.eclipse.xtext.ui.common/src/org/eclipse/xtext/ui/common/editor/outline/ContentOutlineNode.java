/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.concurrent.IEObjectHandle;

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
	private IEObjectHandle<EObject> handle;

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

	public URI getUri() {
		return handle.getURI();
	}

	public void setEObjectHandle(IEObjectHandle<EObject> handle) {
		this.handle = handle;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		final ContentOutlineNode other = (ContentOutlineNode) obj;
		if (label == null) {
			if (other.label != null) {
				return false;
			}
		}
		else if (!label.equals(other.label)) {
			return false;
		}
		if (parent == null) {
			if (other.parent != null) {
				return false;
			}
		}
		else if (!parent.equals(other.parent)) {
			return false;
		}

		return true;
	}

}