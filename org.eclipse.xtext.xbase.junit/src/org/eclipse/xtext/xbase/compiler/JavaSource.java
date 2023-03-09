/**
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @since 2.9
 */
@Deprecated(forRemoval = true)
public class JavaSource {
	private final String fileName;

	private final String code;

	public JavaSource(String fileName, String code) {
		this.fileName = fileName;
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JavaSource other = (JavaSource) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("fileName", this.fileName);
		b.add("code", this.code);
		return b.toString();
	}

	public String getFileName() {
		return fileName;
	}

	public String getCode() {
		return code;
	}
}
