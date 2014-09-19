/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import org.eclipse.core.resources.IStorage;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.base.Objects;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StorageWithRegion {
	private final ITextRegion region;
	private final IStorage storage;

	public StorageWithRegion(IStorage storage) {
		this(storage, null);
	}

	public StorageWithRegion(IStorage storage, ITextRegion region) {
		super();
		this.storage = storage;
		this.region = region;
	}

	public ITextRegion getRegion() {
		return region;
	}

	public IStorage getStorage() {
		return storage;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("storage", storage).add("region", region).toString();
	}

}
