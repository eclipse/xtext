/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import org.eclipse.core.resources.IStorage;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceInformation;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@NonNullByDefault
public class FileBasedTraceInformation implements ITraceInformation {

	public static final String TRACE_FILE_EXTENSION = "_trace";

	@Inject
	private Provider<FileBasedTrace> traceToSourceProvider;
	
	@Nullable
	public ITrace getTraceToSource(IStorage derivedResource) {
		FileBasedTrace result = traceToSourceProvider.get();
		result.setLocalStorage(derivedResource);
		return result;
	}

	@Nullable
	public ITrace getTraceToTarget(IStorage sourceResource) {
		return null;
	}

}
