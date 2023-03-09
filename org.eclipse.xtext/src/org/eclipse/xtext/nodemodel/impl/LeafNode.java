/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
	
	@Override
	public boolean isHidden() {
		return false;
	}

	@Override
	public int getTotalOffset() {
		return totalOffset;
	}

	@Override
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
	protected void readData(DataInputStream in, DeserializationConversionContext context) throws IOException {
		super.readData(in, context);
		
		totalLength = SerializationUtil.readInt(in, true);   
	}
	
	@Override
	protected void write(DataOutputStream out, SerializationConversionContext scc) throws IOException {
		super.write(out, scc);
		
		SerializationUtil.writeInt (out, totalLength, true); 
	}

	@Override
	protected NodeType getNodeId() {
		return NodeType.LeafNode;
	}
}
