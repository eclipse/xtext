/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.compare;

import java.io.InputStream;

import org.eclipse.compare.IEncodedStreamContentAccessor;
import org.eclipse.compare.IResourceProvider;
import org.eclipse.compare.IStreamContentAccessor;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class StreamContentAccessorDelegate implements IResourceProvider, IEncodedStreamContentAccessor {
	private IStreamContentAccessor streamContentAccessor;
	private IResourceProvider resourceProvider;

	public StreamContentAccessorDelegate(IStreamContentAccessor streamContentAccessor,
			IResourceProvider resourceProvider) {
		super();
		Assert.isNotNull(streamContentAccessor, "parameter 'streamContentAccessor' must not be null");
		Assert.isNotNull(resourceProvider, "parameter 'resourceProvider' must not be null");
		this.streamContentAccessor = streamContentAccessor;
		this.resourceProvider = resourceProvider;
	}

	@Override
	public InputStream getContents() throws CoreException {
		try {
			return streamContentAccessor.getContents();
		} catch (CoreException e) {
			// deleted files cause a CoreException in egit compare dialog
			return null;
		}
	}

	@Override
	public boolean equals(Object object) {
		return streamContentAccessor.equals(object);
	}

	@Override
	public int hashCode() {
		return streamContentAccessor.hashCode();
	}

	@Override
	public IResource getResource() {
		return resourceProvider.getResource();
	}

	@Override
	public String getCharset() throws CoreException {
		if(streamContentAccessor instanceof IEncodedStreamContentAccessor)
			return ((IEncodedStreamContentAccessor) streamContentAccessor).getCharset();
		else 
			return ResourcesPlugin.getEncoding();
	}

}


