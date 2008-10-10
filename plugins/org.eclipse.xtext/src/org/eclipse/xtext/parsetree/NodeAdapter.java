/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

public class NodeAdapter implements Adapter {

	private Notifier target;

	private CompositeNode parserNode;

	public Notifier getTarget() {
		return target;
	}

	public boolean isAdapterForType(Object type) {
		return type == AbstractNode.class;
	}

	public void notifyChanged(Notification n) {
//		if (n.getFeature() instanceof EAttribute) {
//			EAttribute attr = (EAttribute) n.getFeature();
//			EList<AbstractNode> children = parserNode.getChildren();
//			for (AbstractNode abstractNode : children) {
//				if (abstractNode instanceof LeafNode) {
//					LeafNode leaf = (LeafNode) abstractNode;
//					if (attr.getName().equals(leaf.getFeature())) {
//						leaf.setText(n.getNewStringValue());
//					}
//				}
//			}
//		} else {
//			logger.debug(n);
//		}
	}

	public void setTarget(Notifier newTarget) {
		target = newTarget;
	}

	public CompositeNode getParserNode() {
		return parserNode;
	}

	public void setParserNode(CompositeNode parserNode) {
		this.parserNode = parserNode;
	}

}
