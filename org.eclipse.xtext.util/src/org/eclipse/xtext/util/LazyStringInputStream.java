/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * An input stream based on a string that keeps a reference to the string
 * itself and converts it to bytes only on demand.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @since 2.5
 */
public class LazyStringInputStream extends InputStream {

	private InputStream delegate;
	private String string;
	private String encoding;

	public LazyStringInputStream(String string) {
		this(string, Charset.defaultCharset().name());
	}
	
	public LazyStringInputStream(String string, Charset encoding) {
		this(string, encoding.name());
	}
	
	public LazyStringInputStream(String string, String encoding) {
		this.string = string;
		this.encoding = encoding;
	}
	
	@Override
	public int read() throws IOException {
		return delegate().read();
	}

	private InputStream delegate() throws IOException {
		if (delegate == null) {
			delegate = new StringInputStream(string, encoding);
		}
		return delegate;
	}

	@Override
	public int read(byte[] b) throws IOException {
		return delegate().read(b);
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		return delegate().read(b, off, len);
	}

	@Override
	public long skip(long n) throws IOException {
		return delegate().skip(n);
	}

	@Override
	public int available() throws IOException {
		return delegate().available();
	}

	@Override
	public void close() throws IOException {
		delegate().close();
	}

	@Override
	public synchronized void mark(int readlimit) {
		try {
			delegate().mark(readlimit);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public synchronized void reset() throws IOException {
		delegate().reset();
	}

	@Override
	public boolean markSupported() {
		try {
			return delegate().markSupported();
		} catch (IOException e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return string;
	}
	
	public String getString() {
		return string;
	}
	
	public String getEncoding() {
		return encoding;
	}

}
