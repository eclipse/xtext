/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build

import com.intellij.compiler.CompilerMessageImpl
import com.intellij.compiler.ProblemsView
import com.intellij.openapi.compiler.CompileScope
import com.intellij.openapi.compiler.CompilerMessage
import com.intellij.openapi.compiler.CompilerMessageCategory
import com.intellij.openapi.fileEditor.OpenFileDescriptor
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import java.util.UUID
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.build.BuildRequest
import org.eclipse.xtext.validation.Issue

import static extension org.eclipse.xtext.idea.resource.VirtualFileURIUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
class BuildProgressReporter implements BuildRequest.IPostValidationCallback {

	val sessionId = UUID.randomUUID

	val affectedScope = new AffectedScope

	Project project

	ProblemsView problemsView

	def void setProject(Project project) {
		this.project = project
		problemsView = ProblemsView.SERVICE.getInstance(project)
	}

	def void clearProgress() {
		problemsView.clearProgress
		problemsView.clearOldMessages(affectedScope, sessionId)
	}

	def void markAsAffected(URI uri) {
		affectedScope.affectedFiles += uri
	}

	override afterValidate(URI validated, Iterable<Issue> issues) {
		markAsAffected(validated)
		for (issue : issues) {
			reportIssue(validated, issue)
		}
		return true
	}

	protected def reportIssue(URI validated, Issue issue) {
		val compilerMessage = getCompilerMessage(validated, issue)
		problemsView.addMessage(compilerMessage, sessionId)
	}

	protected def CompilerMessage getCompilerMessage(URI validated, Issue issue) {
		val file = validated.virtualFile
		return new CompilerMessageImpl(
			project,
			issue.category,
			issue.message,
			file,
			issue.lineNumber,
			-1,
			new OpenFileDescriptor(project, file, issue.offset)
		)
	}

	protected def getCategory(Issue issue) {
		switch issue.severity {
			case ERROR:
				CompilerMessageCategory.ERROR
			case WARNING:
				CompilerMessageCategory.WARNING
			case INFO:
				CompilerMessageCategory.INFORMATION
			default:
				CompilerMessageCategory.INFORMATION
		}
	}
	
}

class AffectedScope implements CompileScope {

	@Accessors
	val affectedFiles = <URI>newHashSet

	override belongs(String url) {
		val uri = URI.createURI(url)
		affectedFiles.contains(uri)
	}

	override getAffectedModules() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override getFiles(FileType fileType, boolean inSourceOnly) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override exportUserData() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override <T> getUserData(Key<T> key) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override <T> putUserData(Key<T> key, T value) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
