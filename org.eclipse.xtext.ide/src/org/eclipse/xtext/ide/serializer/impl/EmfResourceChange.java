/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;

import com.google.common.base.Throwables;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EmfResourceChange implements IEmfResourceChange {

	public final URI oldURI;
	public final Resource resource;

	public EmfResourceChange(Resource resource, URI oldURI) {
		super();
		this.resource = resource;
		this.oldURI = oldURI;
	}

	@Override
	public Resource getResource() {
		return resource;
	}

	@Override
	public URI getOldURI() {
		return oldURI;
	}

	@Override
	public URI getNewURI() {
		return getResource().getURI();
	}

	@Override
	public String toString() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			resource.save(out, Collections.emptyMap());
		} catch (IOException e) {
			return Throwables.getStackTraceAsString(e);
		}
		return out.toString();
	}

}
