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
public class File implements ISetupFile {
	private String from;
	private String name;

	public File(String name) {
		super();
		this.name = name;
	}

	public InputStream createInputStream(IFileSetupContext ctx) throws IOException {
		String from = this.from != null ? this.from : name;
		Resource resource = ctx.getXpectFile().eResource();
		URI uri = ctx.getURIProvider().resolveURI(resource.getURI(), from);
		return resource.getResourceSet().getURIConverter().createInputStream(uri);
	}

	public String getFrom() {
		return from;
	}

	public String getName() {
		return name;
	}

	public URI getURI(IFileSetupContext ctx) {
		return ctx.getURIProvider().resolveURI(ctx.getXpectFile().eResource().getURI(), name);
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setName(String name) {
		this.name = name;
	}

}
