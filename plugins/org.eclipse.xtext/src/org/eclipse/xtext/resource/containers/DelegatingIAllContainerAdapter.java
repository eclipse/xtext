/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DelegatingIAllContainerAdapter extends AdapterImpl implements IAllContainersState{

	private IAllContainersState delegate;

	public DelegatingIAllContainerAdapter(IAllContainersState delegate) {
		super();
		this.delegate = delegate;
	}

	public List<String> getVisibleContainerHandles(String handle) {
		return delegate.getVisibleContainerHandles(handle);
	}

	public Collection<URI> getContainedURIs(String containerHandle) {
		return delegate.getContainedURIs(containerHandle);
	}

	public String getContainerHandle(URI uri) {
		return delegate.getContainerHandle(uri);
	}
	
	public IAllContainersState getDelegate() {
		return delegate;
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return IAllContainersState.class.equals(type);
	}
	
}
