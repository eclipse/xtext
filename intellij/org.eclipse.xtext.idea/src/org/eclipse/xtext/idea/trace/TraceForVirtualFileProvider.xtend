/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.trace

import com.intellij.openapi.vfs.VirtualFile
import org.eclipse.xtext.generator.trace.internal.AbstractTraceForURIProvider
import org.eclipse.xtext.generator.trace.AbsoluteURI
import com.intellij.openapi.vfs.VirtualFileManager

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class TraceForVirtualFileProvider extends AbstractTraceForURIProvider<VirtualFile, VirtualFileBasedTrace> implements ITraceForVirtualFileProvider {
	
	override protected asFile(AbsoluteURI absoluteURI) {
		VirtualFileManager.instance.findFileByUrl(absoluteURI.URI.toString)
	}
	
	override protected findInverseTraceFiles(VirtualFile sourceFile) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected findPersistedTrace(VirtualFile generatedFile) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected getAbsoluteLocation(VirtualFile file) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected getProjectConfig(VirtualFile sourceFile) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected newAbstractTrace(VirtualFile file) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getTraceToTarget(VirtualFile sourceResource) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}