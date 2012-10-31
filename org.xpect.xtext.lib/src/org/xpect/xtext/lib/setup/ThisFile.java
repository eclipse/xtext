/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.setup;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.xpect.setup.IXpectSetup.IFileSetupContext;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ThisFile implements ISetupFile {
	private String name;

	public ThisFile() {
		this(null);
	}

	public ThisFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public InputStream createInputStream(IFileSetupContext ctx) throws IOException {
		Resource resource = ctx.getXpectFile().eResource();
		return resource.getResourceSet().getURIConverter().createInputStream(resource.getURI());
	}

	public String getName() {
		return name;
	}

	@Override
	public URI getURI(IFileSetupContext ctx) {
		if (name == null)
			return ctx.getXpectFile().eResource().getURI();
		return ctx.getURIProvider().resolveURI(ctx.getXpectFile().eResource().getURI(), name);
	}

}
