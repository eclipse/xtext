/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.trace

import com.intellij.openapi.module.Module
import com.intellij.openapi.vfs.VirtualFile
import org.eclipse.xtext.generator.trace.internal.IPlatformSpecificLocation
import org.eclipse.xtext.generator.trace.internal.IPlatformSpecificTrace
import org.eclipse.xtext.generator.trace.internal.IPlatformSpecificTraceProvider
import org.eclipse.xtext.generator.trace.internal.NoTraces

/**
 * Provides read access to the available trace information for generated resources or input resources.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 * @since 2.9
 */
interface ITraceForVirtualFileProvider extends IPlatformSpecificTraceProvider<VirtualFile, IIdeaTrace> {
	
	class Null extends NoTraces<VirtualFile, IIdeaTrace> implements ITraceForVirtualFileProvider {
	}
	
}

/**
 * IDEA specific extension to the trace information.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
interface IIdeaTrace extends IPlatformSpecificTrace<VirtualFile, Module, ILocationInVirtualFile, IIdeaTrace>  {
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
interface ILocationInVirtualFile extends IPlatformSpecificLocation<VirtualFile, Module> {
}
