/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import java.util.Map;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.util.Pair;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IStorage2UriMapperJdtExtensions {

	/**
	 * @return all managed uris and their corresponding storages contained in the given {@link IPackageFragmentRoot}
	 */
	public Map<URI, IStorage> getAllEntries(IPackageFragmentRoot root);

	/**
	 * @return the {@link URI} mapping for the given {@link IPackageFragmentRoot}. The first entry in the pair is the possibly logical URI, the second the physical one.
	 * @throws JavaModelException 
	 */
	public Pair<URI,URI> getURIMapping(IPackageFragmentRoot root) throws JavaModelException;
}
