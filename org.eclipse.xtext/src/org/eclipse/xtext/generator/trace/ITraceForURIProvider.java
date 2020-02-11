/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.eclipse.xtext.workspace.IProjectConfig;

/**
 * Provides read access to the available trace information for generated resources or input resources.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 * @since 2.9
 */
public interface ITraceForURIProvider {

	/**
	 * Returns the trace information to the sources that were used as input for the given derived resource. May return
	 * <code>null</code> if no such data is available for the given storage.
	 * 
	 * @param absoluteDerivedResource
	 *            the resource whose source trace is requested. May not be <code>null</code>.
	 * @param context
	 *            the project that contains the derived resource. May not be <code>null</code>.
	 * @return the trace to the source or <code>null</code>.
	 */
	ITrace getTraceToSource(AbsoluteURI absoluteDerivedResource, IProjectConfig context);

	/**
	 * Returns the trace information to the sources that were used as input for the given derived resource. May return
	 * <code>null</code> if no such data is available for the given storage.
	 * 
	 * @param srcRelativeDerivedResource
	 *            the resource whose source trace is requested. May not be <code>null</code>.
	 * @param project
	 *            the project that contains the derived resource. May not be <code>null</code>.
	 * @return the trace to the source or <code>null</code>.
	 */
	ITrace getTraceToSource(SourceRelativeURI srcRelativeDerivedResource, IProjectConfig project);

	/**
	 * Returns the trace information to the targets that were generated from the given source. May return
	 * <code>null</code> if no such data is available for the given storage.
	 * 
	 * @param absoluteSourceResource
	 *            the resource whose target trace is requested. May not be <code>null</code>.
	 * @param context
	 *            the project that contains the derived resource. May not be <code>null</code>.
	 * @return the trace to the generation targets or <code>null</code>.
	 */
	ITrace getTraceToTarget(AbsoluteURI absoluteSourceResource, IProjectConfig context);

	/**
	 * Returns the trace information to the targets that were generated from the given source. May return
	 * <code>null</code> if no such data is available for the given storage.
	 * 
	 * @param srcRelativeSourceResource
	 *            the resource whose target trace is requested. May not be <code>null</code>.
	 * @param project
	 *            the project that contains the resource. May not be <code>null</code>.
	 * @return the trace to the generation targets or <code>null</code>.
	 */
	ITrace getTraceToTarget(SourceRelativeURI srcRelativeSourceResource, IProjectConfig project);

}