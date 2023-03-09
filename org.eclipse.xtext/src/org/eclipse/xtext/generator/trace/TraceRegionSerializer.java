/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
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
		Location createLocation(int offset, int length, int lineNumber, int endLineNumber, SourceRelativeURI path);
		Region createRegion(int offset, int length, int lineNumber, int endLineNumber, boolean useForDebugging, List<Location> associations, Region parent);
		void writeRegion(Region region, Callback<Region, Location> callback) throws IOException;
		void writeLocation(Location location, Callback<Region, Location> callback) throws IOException;
	}
	
	public interface Callback<Region, Location> {
		void doWriteRegion(int offset, int length, int lineNumber, int endLineNumber, boolean useForDebugging, List<Location> locations, List<Region> children) throws IOException;
		void doWriteLocation(int offset, int length, int lineNumber, int endLineNumber, SourceRelativeURI path) throws IOException;
	}
	
	/**
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 */
	protected static class IdentityStrategy implements Strategy<AbstractTraceRegion, ILocationData> {

		@Override
		public ILocationData createLocation(int offset, int length, int lineNumber, int endLineNumber, SourceRelativeURI path) {
			return new LocationData(offset, length, lineNumber, endLineNumber, path);
		}

		@Override
		public AbstractTraceRegion createRegion(int offset, int length, int lineNumber, int endLineNumber, boolean useForDebugging, List<ILocationData> associations,
				AbstractTraceRegion parent) {
			return new TraceRegion(offset, length, lineNumber, endLineNumber, useForDebugging, (Collection<ILocationData>) associations, parent);
		}

		@Override
		public void writeRegion(AbstractTraceRegion region, Callback<AbstractTraceRegion, ILocationData> callback) throws IOException {
			callback.doWriteRegion(region.getMyOffset(), region.getMyLength(), region.getMyLineNumber(), region.getMyEndLineNumber(), region.isUseForDebugging(), region.getAssociatedLocations(), region.getNestedRegions());
		}

		@Override
		public void writeLocation(ILocationData location, Callback<AbstractTraceRegion, ILocationData> callback) throws IOException {
			callback.doWriteLocation(location.getOffset(), location.getLength(), location.getLineNumber(), location.getEndLineNumber(), location.getSrcRelativePath());
		}
		
	}
	
	private static final int VERSION_3 = 3;
	
	/**
	 * changes compared to version 3:
	 * 
	 * - in version 4, ILocationData has no project name.
	 */
	private static final int VERSION_4 = 4;
	
	/**
	 * changes compared to version 4:
	 * 
	 * - in version 5, ILocationData has no project name.
	 */
	private static final int VERSION_5 = 5;
	
	public void writeTraceRegionTo(AbstractTraceRegion region, OutputStream stream) throws IOException {
		if (region != null && region.getParent() != null)
			throw new IllegalArgumentException("region must be the root");
		doWriteTo(new IdentityStrategy(), region, stream);
	}

	public <Region, Location> void doWriteTo(final Strategy<Region, Location> strategy, Region region, OutputStream stream) throws IOException {
		final DataOutputStream dataStream = new DataOutputStream(new BufferedOutputStream(stream));
		try {
			dataStream.writeInt(VERSION_5);
			dataStream.writeBoolean(region != null);
			if (region == null)
				return;
			strategy.writeRegion(region, new Callback<Region, Location>() {
				@Override
				public void doWriteRegion(int offset, int length, int lineNumber, int endLineNumber, boolean isUseForDebugging, List<Location> locations, List<Region> children) throws IOException {
					writeCompressedInt(dataStream, offset);
					writeCompressedInt(dataStream, length);
					writeCompressedInt(dataStream, lineNumber);
					writeCompressedInt(dataStream, endLineNumber);
					dataStream.writeBoolean(isUseForDebugging);
					writeCompressedInt(dataStream, locations.size());
					for(Location loc: locations) {
						strategy.writeLocation(loc, this);
					}
					writeCompressedInt(dataStream, children.size());
					for(Region child: children) {
						strategy.writeRegion(child, this);
					}
				}

				@Override
				public void doWriteLocation(int offset, int length, int lineNumber, int endLineNumber, SourceRelativeURI path) throws IOException {
					writeCompressedInt(dataStream, offset);
					writeCompressedInt(dataStream, length);
					writeCompressedInt(dataStream, lineNumber);
					writeCompressedInt(dataStream, endLineNumber);
					if (path != null) {
						dataStream.writeBoolean(true);
						dataStream.writeUTF(path.getURI().toString());
					} else {
						dataStream.writeBoolean(false);
					}
				}
			});
		} finally {
			dataStream.flush();
		}
	}
	
	private void writeCompressedInt(DataOutput output, int value) throws IOException {
		// see EObjectOutputStream.writeCompressedInt
		++value;
		if (value < 0) {
			throw new IOException("All values are expected to be positive, but got: " + String.valueOf(value - 1));
		} else if (value <= 0x3F) {
			output.writeByte(value);
		} else if (value <= 0x3FFF) {
			output.writeByte(value >> 8 | 0x40);
			output.writeByte(value & 0xFF);
		} else if (value <= 0x3FFFFF) {
			output.writeByte(value >> 16 | 0x80);
			output.writeByte(value >> 8 & 0xFF);
			output.writeByte(value & 0xFF);
		} else if (value <= 0x3FFFFFFF) {
			output.writeByte(value >> 24 | 0xC0);
			output.writeByte(value >> 16 & 0xFF);
			output.writeByte(value >> 8 & 0xFF);
			output.writeByte(value & 0xFF);
		} else {
			throw new IOException("Invalid value: " + String.valueOf(value - 1));
		}
	}
	
	public AbstractTraceRegion readTraceRegionFrom(InputStream contents) throws IOException {
		return doReadFrom(contents, new IdentityStrategy());
	}
	
	protected static class CompressedIntDataInput extends FilterInputStream implements DataInput {

		private DataInput delegate;
		
		public <Delegate extends InputStream & DataInput> CompressedIntDataInput(Delegate delegate) {
			super(delegate);
			this.delegate = delegate;
		}
		
		@Override
		public boolean readBoolean() throws IOException {
			return delegate.readBoolean();
		}

		@Override
		public byte readByte() throws IOException {
			return delegate.readByte();
		}

		@Override
		public char readChar() throws IOException {
			return delegate.readChar();
		}

		@Override
		public double readDouble() throws IOException {
			return delegate.readDouble();
		}

		@Override
		public float readFloat() throws IOException {
			return delegate.readFloat();
		}

		@Override
		public void readFully(byte[] b) throws IOException {
			delegate.readFully(b);
		}

		@Override
		public void readFully(byte[] b, int off, int len) throws IOException {
			delegate.readFully(b, off, len);
		}

		@Override
		public int readInt() throws IOException {
			// see EObjectInputStream.readCompressedInt
			int initialByte = readByte();
			int code = (initialByte >> 6) & 0x3;
			switch (code) {
				case 0: {
					return initialByte - 1;
				}
				case 1: {
					return (initialByte << 8 & 0x3F00 | readByte() & 0xFF) - 1;
				}
				case 2: {
					return ((initialByte << 16) & 0x3F0000 | (readByte() << 8) & 0xFF00 | readByte() & 0xFF) - 1;
				}
				default: {
					return ((initialByte << 24) & 0x3F000000 | (readByte() << 16) & 0xFF0000
							| (readByte() << 8) & 0xFF00 | readByte() & 0xFF) - 1;
				}
			}
		}

		@Override
		public String readLine() throws IOException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long readLong() throws IOException {
			return delegate.readLong();
		}

		@Override
		public short readShort() throws IOException {
			return delegate.readShort();
		}

		@Override
		public String readUTF() throws IOException {
			return delegate.readUTF();
		}

		@Override
		public int readUnsignedByte() throws IOException {
			return delegate.readUnsignedByte();
		}

		@Override
		public int readUnsignedShort() throws IOException {
			return delegate.readUnsignedShort();
		}

		@Override
		public int skipBytes(int n) throws IOException {
			return delegate.skipBytes(n);
		}
		
	}

	public <Region, Location> Region doReadFrom(InputStream contents, Strategy<Region, Location> reader) throws IOException {
		DataInputStream dataStream = new DataInputStream(new BufferedInputStream(contents));
		int version = dataStream.readInt();
		if (version != VERSION_3 && version != VERSION_4 && version != VERSION_5)
			return null;
		boolean isNull = !dataStream.readBoolean();
		if (isNull)
			return null;
		if (version >= VERSION_5) {
			return doReadFrom(new CompressedIntDataInput(dataStream), reader, null, version);
		} else {
			return doReadFrom(dataStream, reader, null, version);
		}
	}

	public <Location, Region> Region doReadFrom(DataInput dataStream, Strategy<Region, Location> reader, Region parent, int version)
			throws IOException {
		int offset = dataStream.readInt();
		int length = dataStream.readInt();
		int lineNumber = dataStream.readInt();
		int endLineNumber = dataStream.readInt();
		boolean useForDebugging = version < VERSION_5 || dataStream.readBoolean();
		int locationSize = dataStream.readInt();
		List<Location> allLocations = Lists.newArrayListWithCapacity(locationSize);
		while(locationSize != 0) {
			int locationOffset = dataStream.readInt();
			int locationLength = dataStream.readInt();
			int locationLineNumber = dataStream.readInt();
			int locationEndLineNumber = dataStream.readInt();
			final SourceRelativeURI path;
			if (dataStream.readBoolean()) {
				if (version < VERSION_5) {
					URI uri = URI.createURI(dataStream.readUTF());
					if (version == VERSION_3 && !uri.isRelative()) {
						if (uri.isPlatform()) {
							String platformString = uri.toPlatformString(false);
							path = new SourceRelativeURI(platformString.substring(platformString.indexOf('/') + 1));
						} else if (uri.isFile()) {
							path = new SourceRelativeURI(uri.lastSegment());
						} else {
							path = SourceRelativeURI.fromAbsolute(uri);
						}
					} else {
						path = new SourceRelativeURI(uri);
					}
				} else {
					path = new SourceRelativeURI(dataStream.readUTF());
				}
			} else {
				path = null;
			}
			if(version == VERSION_3) {
				if (dataStream.readBoolean()) // true, if a project is specified
					dataStream.readUTF(); // read and skip the project name
			}
			allLocations.add(reader.createLocation(locationOffset, locationLength, locationLineNumber, locationEndLineNumber, path));
			locationSize--;
		}
		Region result = reader.createRegion(offset, length, lineNumber, endLineNumber, useForDebugging, allLocations, parent);
		int childrenSize = dataStream.readInt();
		while(childrenSize != 0) {
			doReadFrom(dataStream, reader, result, version);
			childrenSize--;
		}
		return result;
	}

}
