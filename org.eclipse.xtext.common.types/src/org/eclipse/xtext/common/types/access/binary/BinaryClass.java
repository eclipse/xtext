/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;

import com.google.common.base.Strings;

/**
 * <p>
 * Represents an available class in a classloader.
 * </p>
 * <p>
 * The binary class allows to obtain the persistent bytes to read them manually without defining the class object via
 * the class loader. </p>
 * <p>
 * Instances are usually obtained via {@link BinaryClass#forName(String, ClassLoader)}.
 * </p>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BinaryClass {

	private final String name;
	private final ClassLoader classLoader;

	public BinaryClass(String binaryName, ClassLoader classLoader) {
		super();
		this.name = binaryName;
		this.classLoader = classLoader;
	}

	protected ClassLoader getClassLoader() {
		return classLoader;
	}

	public String getOutermostClassName() {
		int lastDot = name.lastIndexOf('.');
		return getOutermostClassName(lastDot + 1);
	}

	private String getOutermostClassName(int offset) {
		if (offset > name.length())
			return name;

		int dollar = name.indexOf('$', offset);
		while (dollar != -1) {
			String outerName = name.substring(0, dollar);
			if (classLoader.getResource(toClassFile(outerName)) != null) {
				return outerName;
			}
			dollar = name.indexOf('$', dollar + 1);
		}
		return name;
	}

	public String getName() {
		return name;
	}

	public byte[] getBytes() {
		InputStream stream = null;
		try {
			stream = classLoader.getResourceAsStream(toClassFile(name));
			if (stream != null) {
				return getInputStreamAsByteArray(stream, -1);
			}
			return null;
		} catch (IOException e) {
			throw new IllegalStateException("Cannot read bytes for " + e);
		} finally {
			try {
				if (stream != null)
					stream.close();
			} catch (IOException e) {
				// ignore
			}
		}
	}
	
	private static final int DEFAULT_READING_SIZE = 8192;
	
	/**
	 * Returns the given input stream's contents as a byte array.
	 * If a length is specified (i.e. if length != -1), only length bytes
	 * are returned. Otherwise all bytes in the stream are returned.
	 * Note this doesn't close the stream.
	 * @throws IOException if a problem occured reading the stream.
	 */
	private byte[] getInputStreamAsByteArray(InputStream stream, int length)
			throws IOException {
		byte[] contents;
		if (length == -1) {
			contents = new byte[0];
			int contentsLength = 0;
			int amountRead = -1;
			do {
				int amountRequested = Math.max(stream.available(), DEFAULT_READING_SIZE);  // read at least 8K

				// resize contents if needed
				if (contentsLength + amountRequested > contents.length) {
					System.arraycopy(
						contents,
						0,
						contents = new byte[contentsLength + amountRequested],
						0,
						contentsLength);
				}

				// read as many bytes as possible
				amountRead = stream.read(contents, contentsLength, amountRequested);

				if (amountRead > 0) {
					// remember length of contents
					contentsLength += amountRead;
				}
			} while (amountRead != -1);

			// resize contents if necessary
			if (contentsLength < contents.length) {
				System.arraycopy(
					contents,
					0,
					contents = new byte[contentsLength],
					0,
					contentsLength);
			}
		} else {
			contents = new byte[length];
			int len = 0;
			int readSize = 0;
			while ((readSize != -1) && (len != length)) {
				// See PR 1FMS89U
				// We record first the read size. In this case len is the actual read size.
				len += readSize;
				readSize = stream.read(contents, len, length - len);
			}
		}

		return contents;
	}
	
	public boolean isPrimitive() {
		return false;
	}

	public boolean isArray() {
		return false;
	}

	public int getArrayDimensions() {
		return -1;
	}

	public BinaryClass getRootComponentType() {
		return null;
	}

	@Override
	public String toString() {
		return name;
	}

	public URI getResourceURI() {
		return URIHelperConstants.OBJECTS_URI.appendSegment(getOutermostClassName());
	}

	public String getURIFragment() {
		return getName();
	}

	/**
	 * @param clazzName
	 *            a binary name that would also work for {@link Class#forName(String)}.
	 * @see Class#forName(String)
	 */
	@SuppressWarnings("serial")
	public static BinaryClass forName(String clazzName, ClassLoader classLoader) throws ClassNotFoundException {
		int i = 0;
		int length = clazzName.length();
		while (i < length - 1 && clazzName.charAt(i) == '[') {
			i++;
		}
		if (i != 0) {
			switch (clazzName.charAt(i)) {
				case 'B':
					return new Array(new Primitive(Byte.TYPE), i, clazzName);
				case 'C':
					return new Array(new Primitive(Character.TYPE), i, clazzName);
				case 'D':
					return new Array(new Primitive(Double.TYPE), i, clazzName);
				case 'F':
					return new Array(new Primitive(Float.TYPE), i, clazzName);
				case 'I':
					return new Array(new Primitive(Integer.TYPE), i, clazzName);
				case 'J':
					return new Array(new Primitive(Long.TYPE), i, clazzName);
				case 'S':
					return new Array(new Primitive(Short.TYPE), i, clazzName);
				case 'Z':
					return new Array(new Primitive(Boolean.TYPE), i, clazzName);
				case 'L': {
					String actualName = clazzName.substring(i + 1, clazzName.length() - 1);
					return new Array(forName(actualName, classLoader), i, clazzName);
				}
			}
		}
		URL url = classLoader.getResource(toClassFile(clazzName));
		if (url != null) {
			return new BinaryClass(clazzName, classLoader);
		}
		throw new ClassNotFoundException(clazzName) {
			@SuppressWarnings("sync-override")
			@Override
			public Throwable fillInStackTrace() {
				// don't care
				return this;
			}
		};
	}

	protected static String toClassFile(String name) {
		return name.replace('.', '/') + ".class";
	}

	public static class Array extends BinaryClass {

		private final int dimensions;
		private final BinaryClass componentType;

		public Array(BinaryClass componentType, int dimensions, String binaryName) {
			super(binaryName, null);
			this.componentType = componentType;
			this.dimensions = dimensions;
		}

		@Override
		public boolean isArray() {
			return true;
		}

		@Override
		public int getArrayDimensions() {
			return dimensions;
		}

		@Override
		public BinaryClass getRootComponentType() {
			return componentType;
		}

		@Override
		public URI getResourceURI() {
			return getRootComponentType().getResourceURI();
		}

		@Override
		public String getURIFragment() {
			return getRootComponentType().getURIFragment() + Strings.repeat("[]", getArrayDimensions());
		}

	}

	public static class Primitive extends BinaryClass {
		public Primitive(Class<?> type) {
			super(type.getName(), null);
		}

		@Override
		public boolean isPrimitive() {
			return true;
		}

		@Override
		public URI getResourceURI() {
			return URIHelperConstants.PRIMITIVES_URI;
		}
	}

}
