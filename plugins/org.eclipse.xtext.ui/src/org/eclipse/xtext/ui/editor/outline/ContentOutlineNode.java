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
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.transformer.AbstractSemanticModelTransformer;
import org.eclipse.xtext.util.concurrent.IEObjectHandle;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Lists;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Michael Clay
 * @author Sebastian Zarnekow
 */
public class ContentOutlineNode implements IContentOutlineNode {

	private static final IContentOutlineNode[] EMPTY_ARRAY = new IContentOutlineNode[0];
	
	private StyledString styledString;
	private Image image;
	private IRegion region;
	private List<ContentOutlineNode> children;
	private IContentOutlineNode[] childrenAsArray;
	private ContentOutlineNode parent;
	private EClass eClass;
	private IEObjectHandle<EObject> handle;
	private List<IEObjectHandle<EObject>> handlesForChildren;
	private AbstractSemanticModelTransformer transformer;

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
			children = new ArrayList<ContentOutlineNode>(2);
		}
		if (handlesForChildren != null)
			computeChildren();
		return children;
	}
	
	public void addHandleForChildren(IEObjectHandle<EObject> handle) {
		if (handlesForChildren == null) {
			handlesForChildren = Lists.newArrayListWithExpectedSize(1);
		}
		handlesForChildren.add(handle);
	}
	
	protected void computeChildren() {
		if (getTransformer() == null || handlesForChildren == null)
			return;
		List<IEObjectHandle<EObject>> handlesForChildren = this.handlesForChildren;
		this.handlesForChildren = null;
		for(IEObjectHandle<EObject> handleForChildren: handlesForChildren) {
			processHandleForChildren(handleForChildren);
		}
	}

	protected void processHandleForChildren(IEObjectHandle<EObject> handleForChildren) {
		handleForChildren.readOnly(new IUnitOfWork.Void<EObject>() {
			@Override
			public void process(EObject state) throws Exception {
				getTransformer().transformSemanticChildNodes(state, ContentOutlineNode.this);
			}
		});
	}
	
	public IContentOutlineNode[] getChildrenAsArray() {
		if (childrenAsArray == null) {
			List<ContentOutlineNode> childList = getChildren();
			if (childList.isEmpty()) {
				childrenAsArray = EMPTY_ARRAY;
			} else {
				childrenAsArray = getChildren().toArray(new IContentOutlineNode[childList.size()]);
			}
		}
		return childrenAsArray;
	}
	
	public boolean hasChildren() {
		return getChildrenAsArray().length != 0;
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

	/**
	 * @deprecated use {@link #getURI()} instead.
	 */
	@Deprecated
	public URI getUri() {
		return getURI();
	}

	public IEObjectHandle<EObject> getEObjectHandle() {
		return handle;
	}
	
	public <T> T modify(IUnitOfWork<T, EObject> work) {
		if (handle != null)
			return handle.modify(work);
		return null;
	}
	
	public <T> T readOnly(IUnitOfWork<T, EObject> work) {
		if (handle != null)
			return handle.readOnly(work);
		return null;
	}
	
	public URI getURI() {
		if (handle != null)
			return handle.getURI();
		return null;
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

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class expected) {
		return Platform.getAdapterManager().getAdapter(this, expected);
	}
	
	public void setTransformer(AbstractSemanticModelTransformer transformer) {
		this.transformer = transformer;
	}
	
	public AbstractSemanticModelTransformer getTransformer() {
		if (transformer != null)
			return transformer;
		if (getParent() != null)
			return getParent().getTransformer();
		return null;
	}

}