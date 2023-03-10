/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.persistence;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.web.server.InvalidRequestException;

/**
 * Default resource base provider that assumes all resource identifiers are
 * relative paths inside a certain resource base path, which has to be given
 * when creating this provider.
 */
public class ResourceBaseProviderImpl implements IResourceBaseProvider {
	private final String resourceBase;

	public ResourceBaseProviderImpl(String resourceBase) {
		this.resourceBase = resourceBase;
	}

	@Override
	public URI getFileURI(String resourceId) {
		if (resourceId.contains("..")) {
			throw new InvalidRequestException.InvalidParametersException("Invalid resource path.");
		}
		if (resourceBase.endsWith(File.separator)) {
			return URI.createFileURI(this.resourceBase + resourceId);
		} else {
			return URI.createFileURI(this.resourceBase + File.separator + resourceId);
		}
	}

}
