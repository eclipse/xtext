/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.common.util.URI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class ReadonlyStorage extends PlatformObject implements IStorage {

	private final URI uri;

	protected ReadonlyStorage(URI uri) {
		this.uri = uri;
	}
	public boolean isReadOnly() {
		return true;
	}

	public URI getURI() {
		return uri;
	}

}
