/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.resource.impl;

import java.util.Collection;

import org.eclipse.emf.index.resource.EmfResourceChangeListenerRegistry;
import org.eclipse.emf.index.resource.EmfResourceChangeListener;
import org.eclipse.emf.index.util.MultiMap;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EmfResourceChangeListenerRegistryImpl implements EmfResourceChangeListenerRegistry{

	private MultiMap<String, EmfResourceChangeListener> registry = new MultiMap<String, EmfResourceChangeListener>();
	
	public void registerListener(String fileExtension, EmfResourceChangeListener factory) {
		registry.put(fileExtension, factory);
	}

	public void deregisterListeners(String fileExtension, EmfResourceChangeListener factory) {
		registry.remove(fileExtension, factory);
	}

	public Collection<EmfResourceChangeListener> getListenersFor(String fileExtension) {
		return registry.get(fileExtension);
	}

}
