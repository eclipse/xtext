/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.editor

import com.intellij.ide.projectView.impl.ProjectViewTree
import com.intellij.openapi.fileEditor.OpenFileDescriptor
import com.intellij.openapi.fileEditor.impl.FileEditorNavigationPolicy
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectUtil
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.wm.ex.WindowManagerEx
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.build.XtextCompilerComponent

import static extension org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs.*

/**
 * @author kosyakov - Initial contribution and API
 */
@FinalFieldsConstructor
class IndexBasedFileEditorNavigationPolicy extends FileEditorNavigationPolicy {

	val XtextCompilerComponent compilerComponent

	override getNavigationFile(VirtualFile requestedFile) {
		requestedFile.getSourceFile(ProjectUtil.guessProjectForFile(requestedFile))
	}

	override getNavigationDescriptor(OpenFileDescriptor requestedDescriptor) {
		val sourceFile = requestedDescriptor.file.getSourceFile(requestedDescriptor.project)
		if (sourceFile != null)
			return new OpenFileDescriptor(requestedDescriptor.project, sourceFile)
	}

	protected def getSourceFile(VirtualFile generatedFile, Project project) {
		if(generatedFile.extension != 'java') return null

		val indexState = compilerComponent.autoBuilder.indexState
		if(indexState == null) return null

		val component = WindowManagerEx.getInstanceEx().getFocusedComponent(project)
		if(component instanceof ProjectViewTree) return null

		val uri = URI.createURI(generatedFile.url)
		val sourceURI = indexState.fileMappings.getSource(uri)?.head
		if (sourceURI != null)
			VfsUtil.findFileByIoFile(sourceURI.asFile, true)
	}

}