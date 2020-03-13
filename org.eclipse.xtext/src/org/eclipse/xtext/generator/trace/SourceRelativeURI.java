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

import com.google.common.base.Objects;

/**
 * A source relative URI.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SourceRelativeURI extends AbstractURIWrapper {
	public static SourceRelativeURI fromAbsolute(URI uri) {
		if (uri.isRelative()) {
			throw new IllegalArgumentException(uri.toString());
		}
		return new SourceRelativeURI(uri.path().substring(1));
	}

	public SourceRelativeURI(URI sourceRelativeURI) {
		super(sourceRelativeURI);
		if (!sourceRelativeURI.isRelative() || sourceRelativeURI.path().startsWith("/")) {
			throw new IllegalArgumentException(String.valueOf(sourceRelativeURI));
		}
	}

	public SourceRelativeURI(String relativeURI) {
		this(URI.createURI(relativeURI));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && !Objects.equal(obj.getClass(), SourceRelativeURI.class)) {
			throw new IllegalArgumentException(obj.toString() + " instanceof " + obj.getClass().getName());
		}
		return super.equals(obj);
	}
}
