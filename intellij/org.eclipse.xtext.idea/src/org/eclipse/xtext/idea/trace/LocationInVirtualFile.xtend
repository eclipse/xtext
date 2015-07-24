/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.trace

import org.eclipse.xtext.generator.trace.internal.LocationInResource
import org.eclipse.xtext.generator.trace.SourceRelativeURI
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.module.Module

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class LocationInVirtualFile extends LocationInResource implements ILocationInVirtualFile {
	
	new(int offset, int length, int lineNumber, int endLineNumber, SourceRelativeURI srcRelativeResourceURI, VirtualFileBasedTrace trace) {
		super(offset, length, lineNumber, endLineNumber, srcRelativeResourceURI, trace);
	}
	
	override VirtualFileBasedTrace getTrace() {
		return super.getTrace() as VirtualFileBasedTrace
	}
	
	override VirtualFile getPlatformResource() {
		return getTrace().findVirtualFile(getSrcRelativeResourceURI(), getProject());
	}

	override Module getProject() {
		return getTrace().getLocalProject();
	}
}

