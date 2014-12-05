/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import com.google.inject.Inject
import java.io.IOException
import java.util.Map
import org.eclipse.xtext.linking.lazy.LazyLinkingResource
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * A resource implementation that can load itself from ResourceStorage.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
class StorageAwareResource extends LazyLinkingResource {
	
	@Accessors(PUBLIC_GETTER) @Inject ResourceStorage storage
	
	protected boolean isLoadedFromStorage = false;
	
	override load(Map<?, ?> options) throws IOException {
		if (!isLoaded && !isLoading && storage.shouldLoadFromStorage(this)) {
			isLoading = true;
			try {
				storage.loadResource(this)
				isLoaded = true;
			} finally {
				isLoadedFromStorage = true;
				isLoading = false
			}
		} else {
			super.load(options)
		}
	}
	
	override protected clearInternalState() {
		isLoadedFromStorage = false;
		super.clearInternalState();
	}
	
}