/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testing.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIHandler;

/**
 * @noimplement
 * @noreference
 */
public class InMemoryURIHandler implements URIHandler {
	public static class InMemFile {
		private final URI uri;

		private byte[] contents;

		private boolean exists;

		public OutputStream createOutputstream() {
			return new ByteArrayOutputStream() {
				@Override
				public void close() throws IOException {
					contents = toByteArray();
					exists = true;
				}
			};
		}

		public InputStream createInputStream() throws IOException {
			if (contents == null || !exists) {
				throw new IOException("File " + uri + " does not exist.");
			}
			return new ByteArrayInputStream(contents);
		}

		public InMemFile(URI uri) {
			this.uri = uri;
		}

		public URI getUri() {
			return uri;
		}

		public byte[] getContents() {
			return contents;
		}

		public void setContents(byte[] contents) {
			this.contents = contents;
		}

		public boolean isExists() {
			return exists;
		}

		public void setExists(boolean exists) {
			this.exists = exists;
		}
	}

	public static final String SCHEME = "inmemory";

	private Map<URI, InMemoryURIHandler.InMemFile> files = new HashMap<>();

	@Override
	public boolean canHandle(URI uri) {
		return InMemoryURIHandler.SCHEME.equals(uri.scheme());
	}

	@Override
	public Map<String, ?> contentDescription(URI uri, Map<?, ?> options) throws IOException {
		return Collections.emptyMap();
	}

	@Override
	public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
		return getInMemoryFile(uri).createInputStream();
	}

	@Override
	public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
		return getInMemoryFile(uri).createOutputstream();
	}

	@Override
	public void delete(URI uri, Map<?, ?> options) throws IOException {
		getInMemoryFile(uri).exists = false;
	}

	@Override
	public boolean exists(URI uri, Map<?, ?> options) {
		return getInMemoryFile(uri).exists;
	}

	@Override
	public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
		return Collections.emptyMap();
	}

	@Override
	public void setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
	}

	public InMemFile getInMemoryFile(URI uri) {
		InMemFile result = files.get(uri);
		if (result == null) {
			result = new InMemFile(uri);
			files.put(uri, result);
		}
		return result;
	}

	public Map<URI, InMemoryURIHandler.InMemFile> getFiles() {
		return files;
	}
}
