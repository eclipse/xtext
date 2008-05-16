package org.eclipse.xtext.core.parsetree;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;

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
//			System.out.println(n);
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
