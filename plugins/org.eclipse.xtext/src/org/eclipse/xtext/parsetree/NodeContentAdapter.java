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
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.parsetree.impl.ParsetreeUtil;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class NodeContentAdapter extends EContentAdapter {

	public static void createAdapterAndAddToNode(final CompositeNode node) {
		new NodeContentAdapter().addToNode(node);
	}
	
	public void addToNode(final CompositeNode node) {
		node.eAdapters().add(this);
		updateCompositeNode(node, -1, new NodeInfo(0, 1));
	}
	
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		Object notifier = notification.getNotifier();
		if (notifier instanceof CompositeNode) {
			CompositeNode parent = (CompositeNode) notifier;
			Object feature = notification.getFeature();
			if (ParsetreePackage.Literals.COMPOSITE_NODE__CHILDREN.equals(feature)) {
				int eventType = notification.getEventType();
				switch (eventType) {
					case Notification.ADD:
						int newIdx = notification.getPosition();
						int startIndex = parent.getOffset() - 1;
						if (newIdx >= 1) {
							AbstractNode prevSibling = parent.getChildren().get(newIdx - 1);
							startIndex = prevSibling.getOffset() + prevSibling.getLength() - 1;
						}
						updateCompositeNode(getRootNode(parent), 
								startIndex, new NodeInfo(0, 1));
						break;
					case Notification.REMOVE:
						updateCompositeNode(getRootNode(parent), 
								((AbstractNode) notification.getOldValue()).getOffset() - 1, new NodeInfo(0, 1));
						break;
					case Notification.ADD_MANY:
					case Notification.MOVE:
					case Notification.REMOVE_MANY:
						updateNodeInfo(parent);
						break;
					default:
						break;
				}
			}
		}
	}

	private CompositeNode getRootNode(AbstractNode node) {
		return (CompositeNode) EcoreUtil.getRootContainer(node);
	}

	/**
	 * Perform necessary updates in any nodes, that are required due
     * to changes in the given targetNode.
	 * 
	 * @param targetNode
	 */
	public void updateNodeInfo(AbstractNode targetNode) {
		CompositeNode root = getRootNode(targetNode);
		CompositeNode parent = targetNode.getParent();
		if (parent != null) {
			EList<AbstractNode> siblings = parent.getChildren();
			int index = siblings.indexOf(target);
			if (index <= 0) {
				updateCompositeNode(root, parent.getOffset() - 1, new NodeInfo(0, 1));
			}
			else {
				AbstractNode predecessor = siblings.get(index - 1);
				updateCompositeNode(root, predecessor.getOffset() + predecessor.getLength() - 1, new NodeInfo(0, 1));
			}
		}
		else {
			updateCompositeNode(root, -1, new NodeInfo(0, 1));
		}
	}
	
	/**
	 * Recursive implementation for updates of composite nodes due to change events in the node tree.
	 * The given workingInfo is used as an aggregating parameter.
	 * @param nodeToUpdate the current node, that will be updated
	 * @param startAtOffset Update only nodes, that are affected be changes at this index.
	 * @param workingInfo aggregating object.
	 */
	protected void updateCompositeNode(CompositeNode nodeToUpdate, int startAtOffset, NodeInfo workingInfo) {
		if (nodeToUpdate.getOffset() + nodeToUpdate.getLength() < startAtOffset && nodeToUpdate.getLength() >= 0) {
			workingInfo.offset += nodeToUpdate.getLength();
			return;
		}
		if (nodeToUpdate.getOffset() > startAtOffset) {
			nodeToUpdate.setOffset(workingInfo.offset);
			nodeToUpdate.setLine(workingInfo.line);
		} else {
			workingInfo.line = nodeToUpdate.getLine();			
		}		
		EList<AbstractNode> children = nodeToUpdate.getChildren();
		for(int i = 0; i < children.size(); i++) {
			AbstractNode child = children.get(i);
			if (child instanceof CompositeNode) {
				updateCompositeNode((CompositeNode) child, startAtOffset, workingInfo);
			} else {
				updateLeafNode((LeafNode) child, workingInfo);
			}
		}
		nodeToUpdate.setLength(workingInfo.offset - nodeToUpdate.getOffset());
	}
	
	/**
	 * Updates a leaf node and modifies the given workingInfo.
	 * @param node
	 * @param workingInfo
	 */
	protected void updateLeafNode(LeafNode node, NodeInfo workingInfo) {
		node.setLength(node.getText().length());
		node.setOffset(workingInfo.offset);
		node.setLine(workingInfo.line);
		workingInfo.offset += node.getLength();
		workingInfo.line += ParsetreeUtil.countLines(node.getText());
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == NodeContentAdapter.class;
	}
	
	/**
	 * Internal data structure.
	 * Serves as an aggregating parameter.
	 */
	static class NodeInfo {
		int offset;
		int line;

		public NodeInfo(int offset, int line) {
			this.offset = offset;
			this.line = line;
		}
	}
}
