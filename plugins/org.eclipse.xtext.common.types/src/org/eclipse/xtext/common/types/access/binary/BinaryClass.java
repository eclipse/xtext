/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.jdt.internal.compiler.util.Util;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class BinaryClass {

	private final String name;
	private final ClassLoader classLoader;
	
	public BinaryClass(String name, ClassLoader classLoader) {
		super();
		this.name = name;
		this.classLoader = classLoader;
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
			return Util.getInputStreamAsByteArray(stream, -1);
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

	/**
	 * @param clazzName a name that would also work for {@link Class#forName(String)}.
	 */
	@SuppressWarnings("serial")
	public static BinaryClass forName(String clazzName, ClassLoader classLoader) throws ClassNotFoundException {
		int i = 0;
		while(clazzName.charAt(i) == '[') {
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
			@Override
			public synchronized Throwable fillInStackTrace() {
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

		public Array(BinaryClass componentType, int dimensions, String name) {
			super(name, null);
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
		
	}
	
	public static class Primitive extends BinaryClass {

		public Primitive(Class<?> type) {
			super(type.getName(), null);
		}
		
		@Override
		public boolean isPrimitive() {
			return true;
		}
	}
	
}
