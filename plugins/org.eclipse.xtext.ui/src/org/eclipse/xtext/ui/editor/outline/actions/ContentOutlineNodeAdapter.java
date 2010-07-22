/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.xtext.ui.editor.outline.IContentOutlineNode;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class ContentOutlineNodeAdapter implements Adapter {

	private Notifier target;
	
	private IContentOutlineNode contentOutlineNode;

	public void setTarget(Notifier newTarget) {
		target = newTarget;
	}
	
	public Notifier getTarget() {
		return target;
	}

	public boolean isAdapterForType(Object type) {
		return type == IContentOutlineNode.class;
	}

	public void notifyChanged(Notification notification) {
	}

	public void setContentOutlineNode(IContentOutlineNode contentOutlineNode) {
		this.contentOutlineNode = contentOutlineNode;
	}

	public IContentOutlineNode getContentOutlineNode() {
		return contentOutlineNode;
	}

}
