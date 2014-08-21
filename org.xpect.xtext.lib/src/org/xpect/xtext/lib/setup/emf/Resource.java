/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.setup.emf;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.xpect.xtext.lib.setup.FileSetupContext;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class Resource implements ResourceFactory {

	private final org.xpect.xtext.lib.setup.generic.File delegate;

	public Resource() {
		this.delegate = new org.xpect.xtext.lib.setup.generic.File();
	}

	public Resource(org.xpect.xtext.lib.setup.generic.File file) {
		this.delegate = file;
	}

	public Resource(String name) {
		delegate = new org.xpect.xtext.lib.setup.generic.File(name);
	}

	public org.eclipse.emf.ecore.resource.Resource create(FileSetupContext ctx, ResourceSet resourceSet) throws IOException {
		URI resourceURI = ctx.resolve(delegate.getLocalURI(ctx).toString());
		return ctx.load(resourceSet, resourceURI, delegate.getContents(ctx));
	}

	public void setFrom(String from) {
		delegate.setFrom(from);
	}
}
