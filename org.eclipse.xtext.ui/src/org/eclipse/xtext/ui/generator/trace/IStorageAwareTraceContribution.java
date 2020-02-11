/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import org.eclipse.core.resources.IStorage;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;

import com.google.common.annotations.Beta;

/**
 * This contributions allows to extend the lookup of paths that are
 * found in trace files.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
public interface IStorageAwareTraceContribution {

	/**
	 * Try to resolve the given path in the context of the local storage.
	 * Return <code>null</code> if it cannot be resolved.
	 */
	AbsoluteURI tryResolvePath(IStorage localStorage, SourceRelativeURI path);
	
}
