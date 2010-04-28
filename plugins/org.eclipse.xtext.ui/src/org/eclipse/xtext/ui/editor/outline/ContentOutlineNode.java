/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.util.concurrent.IEObjectHandle;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Michael Clay
 */
public class ContentOutlineNode implements IAdaptable {

	private StyledString styledString;
	private Image image;
	private IRegion region;
	private List<ContentOutlineNode> children;
	private ContentOutlineNode parent;
	private EClass eClass;
	private IEObjectHandle<EObject> handle;

	public ContentOutlineNode() {
	}

	public ContentOutlineNode(String text) {
		this.styledString = new StyledString(text);
	}

	public ContentOutlineNode(StyledString styledString) {
		this.styledString = styledString;
	}

	public ContentOutlineNode(StyledString styledString, Image image, IRegion region,
			IEObjectHandle<EObject> eObjectHandle, EClass eClass) {
		this.styledString = styledString;
		this.image = image;
		this.region = region;
		this.handle = eObjectHandle;
		this.eClass = eClass;
	}

	public void setStyledString(StyledString styledString) {
		this.styledString = styledString;
	}

	public StyledString getStyledString() {
		return styledString;
	}
	
	public String getLabel() {
		return styledString != null ? styledString.getString() : "";
	}
	
	public void setLabel(String label) {
		styledString = new StyledString(label);
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Image getImage() {
		return image;
	}

	public void addChildren(ContentOutlineNode contentOutlineNode) {
		contentOutlineNode.parent = this;
		getChildren().add(contentOutlineNode);
	}

	public List<ContentOutlineNode> getChildren() {
		if (children == null) {
			children = new ArrayList<ContentOutlineNode>();
		}
		return children;
	}

	public ContentOutlineNode getParent() {
		return parent;
	}

	public IRegion getRegion() {
		return region;
	}

	public EClass getClazz() {
		return eClass;
	}

	public URI getUri() {
		if (handle != null)
			return handle.getURI();
		return null;
	}

	public IEObjectHandle<EObject> getEObjectHandle() {
		return handle;
	}

	public int getSelectionOffset() {
		return null == region ? 0 : region.getOffset();
	}

	public int getSelectionLength() {
		return null == region ? 0 : region.getLength();
	}

	public void setStyler(Styler styler) {
		Assert.isNotNull(styler, "parameter 'styler' must not be null");
		StyledString styledString = getStyledString();
		if (styledString != null) {
			styledString.setStyle(0, styledString.getString().length(), styler);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getLabel() == null) ? 0 : getLabel().hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((handle == null) ? 0 : handle.hashCode());
		return result;
	}

	@Override
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
		if(handle != null) {
			return handle.equals(other.handle);
		}
		if (parent == null) {
			if (other.parent != null) {
				return false;
			}
		} else {
			if (!parent.equals(other.parent)) {
				return false;
			}
		}
		if (getLabel() == null) {
			if (other.getLabel() != null) {
				return false;
			}
		} else if (!getLabel().equals(other.getLabel())) {
			return false;
		}
		if (image == null) {
			if (other.image != null) {
				return false;
			}
		} else if (!image.equals(other.image)) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class expected) {
		return Platform.getAdapterManager().getAdapter(this, expected);
	}

}