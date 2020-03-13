/**
 * Copyright (c) 2015-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractURIWrapper {
	private final URI uri;

	@Override
	public String toString() {
		return uri.toString();
	}

	public AbstractURIWrapper(URI uri) {
		this.uri = uri;
	}

	@Override
	public int hashCode() {
		return 31 * 1 + (this.uri == null ? 0 : this.uri.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractURIWrapper other = (AbstractURIWrapper) obj;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

	public URI getURI() {
		return uri;
	}
}
