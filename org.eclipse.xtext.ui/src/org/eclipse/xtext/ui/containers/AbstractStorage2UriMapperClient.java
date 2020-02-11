/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.containers;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractStorage2UriMapperClient {

	@Inject
	private IStorage2UriMapper mapper;
	
	protected URI getUri(IStorage file) {
		return mapper.getUri(file);
	}
	
	protected Iterable<Pair<IStorage, IProject>> getStorages(URI uri) {
		return mapper.getStorages(uri);
	}
	
	public void setMapper(IStorage2UriMapper mapper) {
		this.mapper = mapper;
	}
	
	public IStorage2UriMapper getMapper() {
		return mapper;
	}
}
