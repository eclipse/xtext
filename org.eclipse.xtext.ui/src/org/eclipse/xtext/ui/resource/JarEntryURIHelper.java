/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IPackageFragmentRoot;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JarEntryURIHelper {

	public static URI getUriForPackageFragmentRoot(IPackageFragmentRoot root) {
		IResource underlyingResource = root.getResource();
		if (underlyingResource == null) {
			return URI.createFileURI(root.getPath().toString());
		} else {
			return URI.createPlatformResourceURI(underlyingResource.getFullPath().toString(), true);
		}
	}
	
}
