/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import com.google.common.collect.Lists;

/**
 * @noextend This interface is not intended to be extended by clients.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TraceRegionSerializer {

	/**
	 * @noextend This interface is not intended to be extended by clients.
	 * @noimplement This interface is not intended to be implemented by clients.
	 */
	public interface Strategy<Region, Location> {
		Location createLocation(int offset, int length, int lineNumber, int endLineNumber, URI path);
		Region createRegion(int offset, int length, int lineNumber, int endLineNumber, List<Location> associations, Region parent);
		void writeRegion(Region region, Callback<Region, Location> callback) throws IOException;
		void writeLocation(Location location, Callback<Region, Location> callback) throws IOException;
	}
	
	public interface Callback<Region, Location> {
		void doWriteRegion(int offset, int length, int lineNumber, int endLineNumber, List<Location> locations, List<Region> children) throws IOException;
		void doWriteLocation(int offset, int length, int lineNumber, int endLineNumber, URI path) throws IOException;
	}
	
	/**
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 */
	protected static class IdentityStrategy implements Strategy<AbstractTraceRegion, ILocationData> {

		@Override
		public ILocationData createLocation(int offset, int length, int lineNumber, int endLineNumber, URI path) {
			return new LocationData(offset, length, lineNumber, endLineNumber, path);
		}

		@Override
		public AbstractTraceRegion createRegion(int offset, int length, int lineNumber, int endLineNumber, List<ILocationData> associations,
				AbstractTraceRegion parent) {
			return new TraceRegion(offset, length, lineNumber, endLineNumber, associations, parent);
		}

		@Override
		public void writeRegion(AbstractTraceRegion region, Callback<AbstractTraceRegion, ILocationData> callback) throws IOException {
			callback.doWriteRegion(region.getMyOffset(), region.getMyLength(), region.getMyLineNumber(), region.getMyEndLineNumber(), region.getAssociatedLocations(), region.getNestedRegions());
		}

		@Override
		public void writeLocation(ILocationData location, Callback<AbstractTraceRegion, ILocationData> callback) throws IOException {
			callback.doWriteLocation(location.getOffset(), location.getLength(), location.getLineNumber(), location.getEndLineNumber(), location.getPath());
		}
		
	}
	
	private static final int VERSION_3 = 3;
	
	/**
	 * changes compared to version 3:
	 * 
	 * - in version 4, ILocationData has no project name.
	 */
	private static final int VERSION_4 = 4;
	
	public void writeTraceRegionTo(AbstractTraceRegion region, OutputStream stream) throws IOException {
		if (region != null && region.getParent() != null)
			throw new IllegalArgumentException("region must be the root");
		doWriteTo(new IdentityStrategy(), region, stream);
	}

	public <Region, Location> void doWriteTo(final Strategy<Region, Location> strategy, Region region, OutputStream stream) throws IOException {
		final DataOutputStream dataStream = new DataOutputStream(new BufferedOutputStream(stream));
		try {
			dataStream.writeInt(VERSION_4);
			dataStream.writeBoolean(region != null);
			if (region == null)
				return;
			strategy.writeRegion(region, new Callback<Region, Location>() {
				@Override
				public void doWriteRegion(int offset, int length, int lineNumber, int endLineNumber, List<Location> locations, List<Region> children) throws IOException {
					dataStream.writeInt(offset);
					dataStream.writeInt(length);
					dataStream.writeInt(lineNumber);
					dataStream.writeInt(endLineNumber);
					dataStream.writeInt(locations.size());
					for(Location loc: locations) {
						strategy.writeLocation(loc, this);
					}
					dataStream.writeInt(children.size());
					for(Region child: children) {
						strategy.writeRegion(child, this);
					}
				}

				@Override
				public void doWriteLocation(int offset, int length, int lineNumber, int endLineNumber, URI path) throws IOException {
					dataStream.writeInt(offset);
					dataStream.writeInt(length);
					dataStream.writeInt(lineNumber);
					dataStream.writeInt(endLineNumber);
					if (path != null) {
						dataStream.writeBoolean(true);
						dataStream.writeUTF(path.toString());
					} else {
						dataStream.writeBoolean(false);
					}
				}
			});
		} finally {
			dataStream.flush();
		}
	}
	
	public AbstractTraceRegion readTraceRegionFrom(InputStream contents) throws IOException {
		return doReadFrom(contents, new IdentityStrategy());
	}

	public <Region, Location> Region doReadFrom(InputStream contents, Strategy<Region, Location> reader) throws IOException {
		DataInputStream dataStream = new DataInputStream(new BufferedInputStream(contents));
		int version = dataStream.readInt();
		if (version != VERSION_3 && version != VERSION_4)
			return null;
		boolean isNull = !dataStream.readBoolean();
		if (isNull)
			return null;
		return doReadFrom(dataStream, reader, null, version);
	}

	public <Location, Region> Region doReadFrom(DataInputStream dataStream, Strategy<Region, Location> reader, Region parent, int version)
			throws IOException {
		int offset = dataStream.readInt();
		int length = dataStream.readInt();
		int lineNumber = dataStream.readInt();
		int endLineNumber = dataStream.readInt();
		int locationSize = dataStream.readInt();
		List<Location> allLocations = Lists.newArrayListWithCapacity(locationSize);
		while(locationSize != 0) {
			int locationOffset = dataStream.readInt();
			int locationLength = dataStream.readInt();
			int locationLineNumber = dataStream.readInt();
			int locationEndLineNumber = dataStream.readInt();
			URI path = null;
			if (dataStream.readBoolean())
				path = URI.createURI(dataStream.readUTF());
			if(version == VERSION_3) {
				if (dataStream.readBoolean()) // true, if a project is specified
					dataStream.readUTF(); // read the project name
			}
			allLocations.add(reader.createLocation(locationOffset, locationLength, locationLineNumber, locationEndLineNumber, path));
			locationSize--;
		}
		Region result = reader.createRegion(offset, length, lineNumber, endLineNumber, allLocations, parent);
		int childrenSize = dataStream.readInt();
		while(childrenSize != 0) {
			doReadFrom(dataStream, reader, result, version);
			childrenSize--;
		}
		return result;
	}

	
	
}
