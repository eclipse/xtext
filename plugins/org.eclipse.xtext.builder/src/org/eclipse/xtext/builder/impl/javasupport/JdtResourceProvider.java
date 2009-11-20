/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.xtext.builder.impl.ResourceProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class JdtResourceProvider extends ResourceProvider {
	
	@Inject
	private JdtUriUtil uriUtil;
	
	@Override
	public URI getURI(IStorage resource) {
		if (resource instanceof IJarEntryResource) {
			return uriUtil.getURI((IJarEntryResource)resource);
		}
		return super.getURI(resource);
	}
}
