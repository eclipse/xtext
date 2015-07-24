/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

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
	
	class Null extends org.eclipse.xtext.generator.trace.internal.NoTraces<IStorage, IEclipseTrace> implements ITraceForStorageProvider {
	}
}