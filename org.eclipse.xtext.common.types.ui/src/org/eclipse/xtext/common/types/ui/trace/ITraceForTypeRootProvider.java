/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.trace;

import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.xtext.ui.generator.trace.IEclipseTrace;
import org.eclipse.xtext.ui.generator.trace.ITraceForStorageProvider;

import com.google.inject.ImplementedBy;

/**
 * Equivalent to {@link ITraceForStorageProvider} for ITypeRoots (e.g. IClassFiles) since there is no IStorage for them.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(TraceForTypeRootProvider.class)
public interface ITraceForTypeRootProvider {
	
	IEclipseTrace getTraceToSource(ITypeRoot derivedResource);
	
}