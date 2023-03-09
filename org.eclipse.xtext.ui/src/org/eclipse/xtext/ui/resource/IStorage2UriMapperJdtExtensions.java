/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
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
	Map<URI, IStorage> getAllEntries(IPackageFragmentRoot root);

	/**
	 * @return the {@link URI} mapping for the given {@link IPackageFragmentRoot}. The first entry in the pair is the possibly logical URI, the second the physical one.
	 */
	Pair<URI,URI> getURIMapping(IPackageFragmentRoot root) throws JavaModelException;
	
	/**
	 * By default, handle all fragment roots that are on the class-path, not from the JRE and not a source folder.
	 * 
	 * @since 2.26
	 */
	default boolean shouldHandle(IPackageFragmentRoot root) {
		try {
			boolean notJRE = !JavaRuntime.newDefaultJREContainerPath().isPrefixOf(root.getRawClasspathEntry().getPath());
			boolean result = notJRE && (root.isArchive() || root.isExternal()); 
			return result;
		} catch (JavaModelException ex) {
			if (!ex.isDoesNotExist()) {
				Logger.getLogger(IStorage2UriMapperJdtExtensions.class).error(ex.getMessage(), ex);
			}
			return false;
		}
	}
}
