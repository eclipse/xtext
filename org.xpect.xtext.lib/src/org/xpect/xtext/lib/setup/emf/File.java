/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.setup.emf;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.xpect.setup.IXpectRunnerSetup.IFileSetupContext;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class File implements ResourceFactory {

	private final org.xpect.xtext.lib.setup.generic.File delegate;

	public File() {
		delegate = new org.xpect.xtext.lib.setup.generic.File();
	}

	public File(org.xpect.xtext.lib.setup.generic.File file) {
		delegate = file;
	}

	public File(String name) {
		delegate = new org.xpect.xtext.lib.setup.generic.File(name);
	}

	public Resource create(IFileSetupContext ctx, ResourceSet resourceSet) throws IOException {
		return ctx.load(resourceSet, delegate.getResolvedURI(ctx), delegate.getContents(ctx));
	}

	public void setFrom(String from) {
		delegate.setFrom(from);
	}

}
