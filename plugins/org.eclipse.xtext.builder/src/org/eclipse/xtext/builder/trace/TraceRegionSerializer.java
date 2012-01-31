/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TraceRegionSerializer {

	private static final int VERSION_1_0 = 1;
	
	public void writeTraceRegionTo(ITraceRegion region, OutputStream stream) throws IOException {
		if (region != null && region.getParent() != null)
			throw new IllegalArgumentException("region must be the root");
		DataOutputStream dataStream = new DataOutputStream(new BufferedOutputStream(stream));
		try {
			dataStream.writeInt(VERSION_1_0);
			dataStream.writeBoolean(region != null);
			if (region == null)
				return;
			dataStream.writeInt(region.getFromOffset());
			dataStream.writeInt(region.getFromLength());
			dataStream.writeInt(region.getToOffset());
			dataStream.writeInt(region.getToLength());
			dataStream.writeUTF(region.getToPath().toString());
			dataStream.writeUTF(region.getToProjectName());
			writeChildrenTo(region, dataStream);
		} finally {
			dataStream.flush();
		}
	}
	
	protected void writeChildrenTo(ITraceRegion parent, DataOutputStream dataStream) throws IOException {
		dataStream.writeInt(parent.getNestedRegions().size());
		for(ITraceRegion child: parent.getNestedRegions()) {
			dataStream.writeInt(child.getFromOffset());
			dataStream.writeInt(child.getFromLength());
			dataStream.writeInt(child.getToOffset());
			dataStream.writeInt(child.getToLength());
			URI toPath = child.getToPath();
			if (!toPath.equals(parent.getToPath())) {
				dataStream.writeBoolean(true);
				dataStream.writeUTF(toPath.toString());
			} else {
				dataStream.writeBoolean(false);
			}
			String toProjectName = child.getToProjectName();
			if (!toProjectName.equals(parent.getToProjectName())) {
				dataStream.writeBoolean(true);
				dataStream.writeUTF(toProjectName);
			} else {
				dataStream.writeBoolean(false);
			}
			writeChildrenTo(child, dataStream);
		}
	}

	public ITraceRegion readTraceRegionFrom(InputStream contents) throws IOException {
		DataInputStream dataStream = new DataInputStream(new BufferedInputStream(contents));
		int version = dataStream.readInt(); // no version specific code yet, only one version shipped
		boolean isNull = !dataStream.readBoolean();
		if (isNull)
			return null;
		int fromOffset = dataStream.readInt();
		int fromLength = dataStream.readInt();
		int toOffset = dataStream.readInt();
		int toLength = dataStream.readInt();
		URI toPath = URI.createURI(dataStream.readUTF());
		String toProject = dataStream.readUTF();
		TraceRegion result = new TraceRegion(fromOffset, fromLength, toOffset, toLength, null, toPath, toProject);
		readChildren(result, dataStream, version);
		return result;
	}

	protected void readChildren(TraceRegion parent, DataInputStream dataStream, int version) throws IOException {
		int childCount = dataStream.readInt();
		for(int i = 0; i < childCount; i++) {
			int fromOffset = dataStream.readInt();
			int fromLength = dataStream.readInt();
			int toOffset = dataStream.readInt();
			int toLength = dataStream.readInt();
			URI toPath = null;
			if (dataStream.readBoolean()) {
				toPath = URI.createURI(dataStream.readUTF());
			}
			String toProject = null;
			if (dataStream.readBoolean()) {
				 toProject = dataStream.readUTF();
			}
			TraceRegion child = new TraceRegion(fromOffset, fromLength, toOffset, toLength, parent, toPath, toProject);
			readChildren(child, dataStream, version);
		}
	}
	
}
