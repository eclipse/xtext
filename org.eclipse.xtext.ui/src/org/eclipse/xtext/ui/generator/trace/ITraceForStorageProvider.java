/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.xtext.generator.trace.internal.IPlatformSpecificTraceProvider;

/**
 * Provides read access to the available trace information for generated resources or input resources.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 * @since 2.9
 */
public interface ITraceForStorageProvider extends IPlatformSpecificTraceProvider<IStorage, IEclipseTrace> {
	/**
	 * @since 2.13
	 */
	default IFile getTraceFile(IFile generatedFile) {
		return null;
	}

	/**
	 * @since 2.13
	 */
	default boolean isTraceFile(IStorage storage) {
		return false;
	}
	
	
	class Null extends org.eclipse.xtext.generator.trace.internal.NoTraces<IStorage, IEclipseTrace> implements ITraceForStorageProvider {
	}
}