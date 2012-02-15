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
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.TraceRegion;

/**
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TraceRegionSerializer {

	/**
	 * @noextend This interface is not intended to be extended by clients.
	 * @noimplement This interface is not intended to be implemented by clients.
	 */
	protected interface Strategy<Type> {
		Type createResult(int fromOffset, int fromLength, int toOffset, int toLength, Type parent,
				URI toPath, String toProject);
		AbstractTraceRegion toRegion(Type t);
		List<Type> getChildren(Type t);
	}
	
	/**
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 */
	protected class IdentityStrategy implements Strategy<AbstractTraceRegion> {
		public AbstractTraceRegion createResult(int fromOffset, int fromLength, int toOffset,
				int toLength, AbstractTraceRegion parent, URI toPath, String toProject) {
			return new TraceRegion(fromOffset, fromLength, toOffset, toLength, parent, toPath, toProject);
		}
		public List<AbstractTraceRegion> getChildren(AbstractTraceRegion t) {
			return t.getNestedRegions();
		}
		public AbstractTraceRegion toRegion(AbstractTraceRegion t) {
			return t;
		}
	}
	
	private static final int VERSION_1_0 = 1;
	
	public void writeTraceRegionTo(AbstractTraceRegion region, OutputStream stream) throws IOException {
		if (region != null && region.getParent() != null)
			throw new IllegalArgumentException("region must be the root");
		doWriteTo(new IdentityStrategy(), region, stream);
	}

	protected <Type> void doWriteTo(Strategy<Type> strategy, Type t, OutputStream stream) throws IOException {
		AbstractTraceRegion region = strategy.toRegion(t);
		DataOutputStream dataStream = new DataOutputStream(new BufferedOutputStream(stream));
		try {
			dataStream.writeInt(VERSION_1_0);
			dataStream.writeBoolean(region != null);
			if (region == null)
				return;
			dataStream.writeInt(region.getMyOffset());
			dataStream.writeInt(region.getMyLength());
			dataStream.writeInt(region.getAssociatedOffset());
			dataStream.writeInt(region.getAssociatedLength());
			URI toPath = region.getAssociatedPath();
			dataStream.writeBoolean(toPath != null);
			if (toPath != null)
				dataStream.writeUTF(toPath.toString());
			String toProjectName = region.getAssociatedProjectName();
			dataStream.writeBoolean(toProjectName != null);
			if (toProjectName != null)
				dataStream.writeUTF(toProjectName);
			writeChildrenTo(strategy, t, dataStream);
		} finally {
			dataStream.flush();
		}
	}
	
	protected <Type> void writeChildrenTo(Strategy<Type> strategy, Type genericParent, DataOutputStream dataStream) throws IOException {
		List<Type> nestedRegions = strategy.getChildren(genericParent);
		dataStream.writeInt(nestedRegions.size());
		AbstractTraceRegion parent = strategy.toRegion(genericParent);
		for(Type genericChild: nestedRegions) {
			AbstractTraceRegion child = strategy.toRegion(genericChild);
			dataStream.writeInt(child.getMyOffset());
			dataStream.writeInt(child.getMyLength());
			dataStream.writeInt(child.getAssociatedOffset());
			dataStream.writeInt(child.getAssociatedLength());
			URI toPath = child.getAssociatedPath();
			if (toPath != null && !toPath.equals(parent.getAssociatedPath())) {
				dataStream.writeBoolean(true);
				dataStream.writeUTF(toPath.toString());
			} else {
				dataStream.writeBoolean(false);
			}
			String toProjectName = child.getAssociatedProjectName();
			if (toProjectName != null && !toProjectName.equals(parent.getAssociatedProjectName())) {
				dataStream.writeBoolean(true);
				dataStream.writeUTF(toProjectName);
			} else {
				dataStream.writeBoolean(false);
			}
			writeChildrenTo(strategy, genericChild, dataStream);
		}
	}
	
	public AbstractTraceRegion readTraceRegionFrom(InputStream contents) throws IOException {
		return doReadFrom(contents, new IdentityStrategy());
	}

	protected <Result> Result doReadFrom(InputStream contents, Strategy<Result> reader) throws IOException {
		DataInputStream dataStream = new DataInputStream(new BufferedInputStream(contents));
		int version = dataStream.readInt(); // no version specific code yet, only one version shipped
		boolean isNull = !dataStream.readBoolean();
		if (isNull)
			return null;
		int fromOffset = dataStream.readInt();
		int fromLength = dataStream.readInt();
		int toOffset = dataStream.readInt();
		int toLength = dataStream.readInt();
		URI toPath = null;
		if (dataStream.readBoolean())
			toPath = URI.createURI(dataStream.readUTF());
		String toProject = null;
		if (dataStream.readBoolean())
			toProject = dataStream.readUTF();
		Result result = reader.createResult(fromOffset, fromLength, toOffset, toLength, null, toPath, toProject);
		readChildren(result, reader, dataStream, version);
		return result;
	}

	protected <Result> void readChildren(Result parent, Strategy<Result> reader, DataInputStream dataStream, int version) throws IOException {
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
			Result child = reader.createResult(fromOffset, fromLength, toOffset, toLength, parent, toPath, toProject);
			readChildren(child, reader, dataStream, version);
		}
	}
	
}
