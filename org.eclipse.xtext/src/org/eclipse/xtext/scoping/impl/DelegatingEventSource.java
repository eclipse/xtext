/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.resource.impl.AbstractResourceDescriptionChangeEventSource;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.util.OnChangeEvictingCache.CacheAdapter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DelegatingEventSource extends AbstractResourceDescriptionChangeEventSource 
	implements IResourceDescription.Event.Listener, OnChangeEvictingCache.Listener {

	private final IResourceDescription.Event.Source source;

	public DelegatingEventSource(IResourceDescription.Event.Source source) {
		this.source = source;
	}
	
	public void initialize() {
		source.addListener(this);
	}
	
	@Override
	public void descriptionsChanged(Event event) {
		notifyListeners(event);
	}

	@Override
	public void onEvict(CacheAdapter cache) {
		source.removeListener(this);
	}

}
