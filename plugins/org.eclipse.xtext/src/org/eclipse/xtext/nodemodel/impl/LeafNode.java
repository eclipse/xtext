package org.eclipse.xtext.nodemodel.impl;

import org.eclipse.xtext.nodemodel.ILeafNode;

public class LeafNode extends AbstractNode implements ILeafNode {

	private int totalOffset;
	
	private int totalLength;
	
	public int getNodeType() {
		return LEAF;
	}
	
	public boolean isHidden() {
		return false;
	}

	public int getTotalOffset() {
		return totalOffset;
	}

	public int getTotalLength() {
		return totalLength;
	}
	
	public void setTotalOffset(int offset) {
		this.totalOffset = offset;
	}
	
	public void setTotalLength(int length) {
		this.totalLength = length;
	}

}
