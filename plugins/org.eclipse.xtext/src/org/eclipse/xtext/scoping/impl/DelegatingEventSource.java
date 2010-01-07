/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.resource.impl.AbstractResourceDescriptionChangeEventSource;
import org.eclipse.xtext.util.OnChangeEvictingCacheAdapter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DelegatingEventSource extends AbstractResourceDescriptionChangeEventSource 
	implements IResourceDescription.Event.Listener, OnChangeEvictingCacheAdapter.Listener {

	private final IResourceDescription.Event.Source source;

	public DelegatingEventSource(IResourceDescription.Event.Source source) {
		this.source = source;
	}
	
	public void initialize() {
		source.addListener(this);
	}
	
	public void descriptionsChanged(Event event) {
		notifyListeners(event);
	}

	public void onEvict(OnChangeEvictingCacheAdapter cache) {
		source.removeListener(this);
	}

}
