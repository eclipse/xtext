/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring2

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.ltk.core.refactoring.RefactoringStatus
import org.eclipse.ltk.core.refactoring.resource.ResourceChange
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

import static org.eclipse.xtext.ui.refactoring2.TryWithResource.*

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@FinalFieldsConstructor
class ReplaceFileContentChange extends ResourceChange {

	val IFile file
	val byte[] newContents
	
	@Accessors String name
	
	new(String name, IFile file, byte[] newContents) {
		this(file, newContents)
		this.name = name
	} 
	
	override protected getModifiedResource() {
		file
	}
	
	override isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		val result = new RefactoringStatus
		if (!file.exists) 
			result.addFatalError('''File '«file.fullPath»' does not exist''')
		return result
	}
	
	override perform(IProgressMonitor pm) throws CoreException {
		val oldContents = getOldContents
		val newContentsIS = new ByteArrayInputStream(newContents)
		tryWith(newContentsIS) [
			file.setContents(newContentsIS, true, true, pm)
			return new ReplaceFileContentChange(file, oldContents)
		]
	}
	
	protected def byte[] getOldContents() {
		val oldContentsBAOS = new ByteArrayOutputStream
		tryWith(oldContentsBAOS) [
			val oldContentsIS = file.contents
			tryWith(oldContentsIS) [
				var readBytes = 0
				val buffer = newByteArrayOfSize(4096)
				while((readBytes = oldContentsIS.read(buffer)) !== -1) 
					oldContentsBAOS.write(buffer, 0, readBytes)
				return oldContentsBAOS.toByteArray
			]
		]
	}
}