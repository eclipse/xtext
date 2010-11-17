package org.eclipse.xtext.nodemodel.impl;

public class HiddenLeafNode extends LeafNode {

	@Override
	public boolean isHidden() {
		return true;
	}
	
	@Override
	public int getNodeType() {
		return super.getNodeType() | HIDDEN;
	}
	
}
