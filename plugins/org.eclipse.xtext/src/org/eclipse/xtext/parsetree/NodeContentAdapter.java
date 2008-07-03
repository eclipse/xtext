/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class NodeContentAdapter extends EContentAdapter {

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		Object notifier = notification.getNotifier();
		if (notifier instanceof CompositeNode) {
			CompositeNode parent = (CompositeNode) notifier;
			Object feature = notification.getFeature();
			if (ParsetreePackage.Literals.COMPOSITE_NODE__CHILDREN.equals(feature)) {
				AbstractNode child = (AbstractNode) notification.getNewValue();
				int eventType = notification.getEventType();
				int position = notification.getPosition();
				switch (eventType) {
					case Notification.ADD:
						if (position == 0) {
							updateOffsetAndLine(child, new NodeInfo(parent.getOffset(), parent.getLine()));
						}
						else {
							AbstractNode predecessor = parent.getChildren().get(position - 1);
							updateOffsetAndLine(child, new NodeInfo((predecessor.getOffset() + predecessor.getLength()), predecessor.endLine()));
						}
						break;
					case Notification.REMOVE:
						if (position == 0) {
							updateOffsetAndLine(parent, new NodeInfo(parent.getOffset(), parent.getLine()));
						}
						else {
							AbstractNode successor = parent.getChildren().get(position);
							updateOffsetAndLine(successor, new NodeInfo(child.getOffset(), child.getLine()));
						}
						break;
					case Notification.ADD_MANY:
					case Notification.MOVE:
					case Notification.REMOVE_MANY:
						updateOffsetAndLine(parent, new NodeInfo(parent.getOffset(), parent.getLine()));
						break;
					default:
						break;
				}
			}
		}
	}

	@Override
	protected void setTarget(EObject target) {
		if (target instanceof AbstractNode) {
			AbstractNode targetNode = (AbstractNode) target;
			CompositeNode parent = targetNode.getParent();
			if (parent != null) {
				EList<AbstractNode> siblings = parent.getChildren();
				int index = siblings.indexOf(target);
				if (index == 0) {
					updateOffsetAndLine(targetNode, new NodeInfo(parent.getOffset(), parent.getLine()));
				}
				else {
					AbstractNode predecessor = siblings.get(index - 1);
					updateOffsetAndLine(targetNode, new NodeInfo((predecessor.getOffset() + predecessor.getLength()), predecessor.endLine()));
				}
			}
			else {
				updateOffsetAndLine(targetNode, new NodeInfo(0, 1));
			}
		}
	}

	static class NodeInfo {
		int offset;
		int line;
		
		public NodeInfo(int offset, int line) {
			this.offset = offset;
			this.line = line;
		}
	}
	
	protected NodeInfo updateOffsetAndLineInContents(AbstractNode node, NodeInfo info) {
		node.setOffset(info.offset);
		node.setLine(info.line);
		if (node instanceof LeafNode) {
			node.setLength(((LeafNode)node).getText().length());
			info.offset += node.getLength();
			info.line = node.endLine();
		} else if (node instanceof CompositeNode) {
			int length = 0;
			for (AbstractNode child : ((CompositeNode) node).getChildren()) {
				info = updateOffsetAndLineInContents(child, info);
				length += child.getLength();
			}
			node.setLength(length);
		}
		return info;
	}

	protected AbstractNode updateOffsetAndLine(AbstractNode node, NodeInfo info) {
		updateOffsetAndLineInContents(node, info);
		CompositeNode parent = node.getParent();
		if (parent != null) {
			EList<AbstractNode> siblings = parent.getChildren();
			int index = siblings.indexOf(node);
			for (int i = index + 1; i < siblings.size(); ++i) {
				info = updateOffsetAndLineInContents(siblings.get(i), info);
			}
		}
		return node;
	}
}
