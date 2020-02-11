/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
	
	@Override
	public boolean isEmpty(String containerHandle) {
		return delegate.isEmpty(containerHandle);
	}

	@Override
	public List<String> getVisibleContainerHandles(String handle) {
		return delegate.getVisibleContainerHandles(handle);
	}

	@Override
	public Collection<URI> getContainedURIs(String containerHandle) {
		return delegate.getContainedURIs(containerHandle);
	}
	
	@Override
	public boolean containsURI(String containerHandle, URI candidateURI) {
		return delegate.containsURI(containerHandle, candidateURI);
	}

	@Override
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
