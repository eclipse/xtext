/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompositeNodeWithSemanticElement extends CompositeNode implements Adapter {

	private EObject semanticElement;
	
	@Override
	public EObject getSemanticElement() {
		if (semanticElement != null)
			return semanticElement;
		return super.getSemanticElement();
	}
	
	@Override
	protected EObject basicGetSemanticElement() {
		return semanticElement;
	}
	
	protected void basicSetSemanticElement(EObject element) {
		this.semanticElement = element;
	}

	public void notifyChanged(Notification notification) {
		// ignore
	}

	public Notifier getTarget() {
		return semanticElement;
	}

	public void setTarget(Notifier newTarget) {
		if (newTarget == null || newTarget instanceof EObject)
			semanticElement = (EObject) newTarget;
		else
			throw new IllegalArgumentException("Notifier must be an Eobject");
	}

	public boolean isAdapterForType(Object type) {
		return INode.class.isAssignableFrom((Class<?>)type);
	}
	
}
