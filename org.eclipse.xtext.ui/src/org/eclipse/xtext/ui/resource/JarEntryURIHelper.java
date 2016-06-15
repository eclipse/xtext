/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
