/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.trace;

import com.intellij.openapi.module.Module;
import org.eclipse.xtext.generator.trace.internal.IPlatformSpecificTrace;
import org.eclipse.xtext.idea.trace.ILocationInVirtualFile;
import org.eclipse.xtext.idea.trace.VirtualFileInProject;

/**
 * IDEA specific extension to the trace information.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
@SuppressWarnings("all")
public interface IIdeaTrace extends IPlatformSpecificTrace<VirtualFileInProject, Module, ILocationInVirtualFile, IIdeaTrace> {
}
