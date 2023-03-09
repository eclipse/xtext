/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard;

import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.15
 */
public class SourceFolderDescriptor {
	private final String path;

	private final boolean test;

	public SourceFolderDescriptor(String path, boolean test) {
		super();
		this.path = path;
		this.test = test;
	}

	@Override
	@Pure
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.path == null) ? 0 : this.path.hashCode());
		return prime * result + (this.test ? 1231 : 1237);
	}

	@Override
	@Pure
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SourceFolderDescriptor other = (SourceFolderDescriptor) obj;
		if (this.path == null) {
			if (other.path != null)
				return false;
		} else if (!this.path.equals(other.path))
			return false;
		if (other.test != this.test)
			return false;
		return true;
	}

	@Override
	@Pure
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("path", this.path);
		b.add("test", this.test);
		return b.toString();
	}

	@Pure
	public String getPath() {
		return this.path;
	}

	@Pure
	public boolean isTest() {
		return this.test;
	}
}
