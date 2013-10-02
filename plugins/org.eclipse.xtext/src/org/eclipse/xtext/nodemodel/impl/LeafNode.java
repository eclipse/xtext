/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.serialization.DeserializationConversionContext;
import org.eclipse.xtext.nodemodel.serialization.SerializationConversionContext;
import org.eclipse.xtext.nodemodel.serialization.SerializationUtil;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Mark Christiaens - Serialization support
 * @noextend This class is not intended to be subclassed by clients.
 */
public class LeafNode extends AbstractNode implements ILeafNode {

	private int totalOffset;
	
	private int totalLength;
	
	public boolean isHidden() {
		return false;
	}

	public int getTotalOffset() {
		return totalOffset;
	}

	public int getTotalLength() {
		return totalLength;
	}
	
	@Override
	public int getOffset() {
		return totalOffset;
	}
	
	@Override
	public int getLength() {
		return totalLength;
	}
	
	@Override
	protected int getLength(int offset) {
		return getLength();
	}
	
	protected void basicSetTotalOffset(int offset) {
		this.totalOffset = offset;
	}
	
	protected void basicSetTotalLength(int length) {
		this.totalLength = length;
	}
	
	@Override
	public Iterable<ILeafNode> getLeafNodes() {
		return Collections.<ILeafNode>singletonList(this);
	}

	@Override 
	void readData(DataInputStream in, DeserializationConversionContext context) throws IOException {
		super.readData(in, context);
		
		totalLength = SerializationUtil.readInt(in, true);   
	}
	
	@Override
	void write(DataOutputStream out, SerializationConversionContext scc) throws IOException {
		super.write(out, scc);
		
		SerializationUtil.writeInt (out, totalLength, true); 
	}

	@Override
	NodeType getNodeId() {
		return NodeType.LeafNode;
	}
}
