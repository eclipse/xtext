/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.util.TextLocation;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Lists;

/**
 * @author koehnlein - Initial contribution and API
 */
public abstract class AbstractOutlineNode implements IOutlineNode {

	private Image image;

	private Object text;

	private AbstractOutlineNode parent;

	private List<IOutlineNode> children;

	private boolean hasPredictedChildren = false;

	private TextLocation textLocation;

	protected AbstractOutlineNode(IOutlineNode parent, Image image, Object text, boolean hasPredictedChildren) {
		this.text = text == null ? "<unnamed>" : text;
		this.image = image;
		this.hasPredictedChildren = hasPredictedChildren;
		setParent(parent);
		textLocation = new TextLocation();
	}

	protected void setParent(IOutlineNode newParent) {
		Assert.isLegal(newParent == null || newParent instanceof AbstractOutlineNode);
		if (parent != null)
			parent.removeChild(this);
		parent = (AbstractOutlineNode) newParent;
		if (parent != null)
			parent.addChild(this);
	}

	protected boolean addChild(IOutlineNode outlineNode) {
		if (children == null)
			children = Lists.newArrayList();
		return children.add(outlineNode); 
	}

	protected boolean removeChild(IOutlineNode outlineNode) {
		if (children == null)
			return false;
		return children.remove(outlineNode);
	}

	public List<IOutlineNode> getChildren() {
		if (!hasPredictedChildren)
			return Collections.emptyList();
		if (children == null) {
			getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource resource) throws Exception {
					getTreeProvider().createChildren(AbstractOutlineNode.this, resource);
				}
			});
		}
		return (children == null) ? Collections.<IOutlineNode>emptyList() : Collections.unmodifiableList(children);
	}

	public IOutlineNode getParent() {
		return parent;
	}

	public boolean hasChildren() {
		return hasPredictedChildren || children != null && children.size() > 0;
	}

	public Object getText() {
		return text;
	}
	
	public void setText(Object text) {
		this.text = text;
	}

	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}

	public IXtextDocument getDocument() {
		if (parent != null) {
			return parent.getDocument();
		}
		return null;
	}

	public IOutlineTreeProvider getTreeProvider() {
		if (parent != null) {
			return parent.getTreeProvider();
		}
		return null;
	}

	public ILocationInFileProvider getLocationInFileProvider() {
		if (parent != null) {
			return parent.getLocationInFileProvider();
		}
		return null;
	}
	
	protected void setTextRegion(TextLocation textLocation) {
		this.textLocation = textLocation;
	}

	public TextLocation getFullTextRegion() {
		return textLocation;
	}

	public TextLocation getShortTextRegion() {
		return textLocation;
	}

	@Override
	public String toString() {
		return "[" + getClass().getSimpleName() + "] " + text.toString();
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapterType) {
		return Platform.getAdapterManager().getAdapter(this, adapterType);
	}

	public <T> T readOnly(IUnitOfWork<T, EObject> work) {
		return null;
	}

	public <T> T modify(IUnitOfWork<T, EObject> work) {
		throw new UnsupportedOperationException("Elements cannot be modified in content outline");
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj.getClass().equals(getClass())
				&& equalsNullSafe(parent, ((IOutlineNode) obj).getParent())
				&& equalsNullSafe(text, ((IOutlineNode) obj).getText())
				&& equalsNullSafe(image, ((IOutlineNode) obj).getImage());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode() + 11 * hashCodeNullSafe(parent) + 13 * hashCodeNullSafe(text) + 17
				* hashCodeNullSafe(image);
	}

	protected boolean equalsNullSafe(Object o0, Object o1) {
		return (o0 == null) ? o1 == null : o0.equals(o1);
	}

	protected int hashCodeNullSafe(Object o) {
		return (o == null) ? 0 : o.hashCode();
	}
}
