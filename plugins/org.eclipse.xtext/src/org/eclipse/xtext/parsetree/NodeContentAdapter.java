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
		updateCompositeNode(node, -1, createWorkingNodeInfo());
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
					case Notification.ADD_MANY:
					case Notification.REMOVE_MANY:
						{
							int idx = notification.getPosition();
							int startIndex = idx < 1 ? 
								parent.getOffset() - 1:
								getOffsetOfNextLeaf(parent.getChildren().get(idx - 1)) - 1;
							updateCompositeNode(getRootNode(parent), startIndex, createWorkingNodeInfo());
						}
						break;
					case Notification.REMOVE:
					case Notification.SET:
						updateCompositeNode(getRootNode(parent), ((AbstractNode) notification.getOldValue()).getOffset() - 1, 
								createWorkingNodeInfo());
						break;
					case Notification.MOVE:
						{
							int leftPos = Math.min(notification.getPosition(), (Integer)notification.getOldValue());
							int startIndex = leftPos < 1 ? 
								parent.getOffset() - 1:
								getOffsetOfNextLeaf(parent.getChildren().get(leftPos - 1)) - 1;
							updateCompositeNode(getRootNode(parent), startIndex, createWorkingNodeInfo());
						}
						break;
					default:
						break;
				}
			}
		}
	}

	private int getOffsetOfNextLeaf(AbstractNode node) {
		return node.getOffset() + node.getLength();
	}

	private NodeInfo createWorkingNodeInfo() {
		return new NodeInfo(0, 1);
	}

	private CompositeNode getRootNode(AbstractNode node) {
		return (CompositeNode) EcoreUtil.getRootContainer(node);
	}

	private boolean isUpdateRequired(AbstractNode node, int updateFromOffset, int lastOffset) {
		return node.getOffset() >= updateFromOffset || 
			getOffsetOfNextLeaf(node) > updateFromOffset;
	}
	
	/**
	 * Recursive implementation for updates of composite nodes due to change events in the node tree.
	 * The given workingInfo is used as an aggregating parameter.
	 * @param nodeToUpdate the current node, that will be updated
	 * @param startAtOffset Update only nodes, that are affected be changes at this index.
	 * @param workingInfo aggregating object.
	 */
	protected void updateCompositeNode(CompositeNode nodeToUpdate, int startAtOffset, NodeInfo workingInfo) {
		if (workingInfo.offset < startAtOffset && !isUpdateRequired(nodeToUpdate, startAtOffset, workingInfo.offset)) {
			workingInfo.offset += nodeToUpdate.getLength();
//			workingInfo.line = nodeToUpdate.getLine();		
			return;
		}
		if (workingInfo.offset >= startAtOffset || nodeToUpdate.getOffset() >= startAtOffset) {
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
