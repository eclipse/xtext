/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.eclipse.core.resources.IStorage;

/**
 * Provides read access to the available trace information for generated resources or input resources.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 * @since 2.3
 */
public interface ITraceForStorageProvider { // ITraceForStorageProvider // ITraceFor
	
	/**
	 * Returns the trace information to the sources that were used as input for the given derived resource.
	 * May return <code>null</code> if no such data is available for the given storage.
	 * @param derivedResource the resource whose source trace is requested. May not be <code>null</code>.
	 * @return the trace to the source or <code>null</code>.
	 */
	/* @Nullable */ ITrace getTraceToSource(IStorage derivedResource);
	
	/**
	 * Returns the trace information to the targets that were generated from the given source.
	 * May return <code>null</code> if no such data is available for the given storage.
	 * @param sourceResource the resource whose target trace is requested. May not be <code>null</code>.
	 * @return the trace to the generation targets or <code>null</code>.
	 */
	/* @Nullable */ ITrace getTraceToTarget(IStorage sourceResource);

	class Null implements ITraceForStorageProvider {

		/* @Nullable */ 
		public ITrace getTraceToSource(IStorage derivedResource) {
			return null;
		}

		/* @Nullable */ 
		public ITrace getTraceToTarget(IStorage sourceResource) {
			return null;
		}
		
	}
}