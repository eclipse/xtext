/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testing;

import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

public class FileInfo {
	private final String uri;

	private final String contents;

	public FileInfo(String uri, String contents) {
		super();
		this.uri = uri;
		this.contents = contents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return prime * result + ((contents == null) ? 0 : contents.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		FileInfo other = (FileInfo) obj;
		if (uri == null) {
			if (other.uri != null) {
				return false;
			}
		} else if (!uri.equals(other.uri)) {
			return false;
		}
		if (contents == null) {
			if (other.contents != null) {
				return false;
			}
		} else if (!contents.equals(other.contents)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("uri", uri);
		b.add("contents", contents);
		return b.toString();
	}

	public String getUri() {
		return uri;
	}

	public String getContents() {
		return contents;
	}
}
