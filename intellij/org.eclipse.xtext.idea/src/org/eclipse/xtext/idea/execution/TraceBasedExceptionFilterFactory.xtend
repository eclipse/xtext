/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.execution

import com.google.inject.Inject
import com.intellij.execution.filters.ExceptionFilter
import com.intellij.execution.filters.ExceptionFilterFactory
import com.intellij.execution.filters.FileHyperlinkInfo
import com.intellij.execution.filters.Filter
import com.intellij.execution.filters.OpenFileHyperlinkInfo
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.fileEditor.OpenFileDescriptor
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.DocumentUtil
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider
import org.eclipse.xtext.idea.trace.VirtualFileInProject
import org.eclipse.xtext.util.TextRegion

/**
 * @author kosyakov - Initial contribution and API
 */
class TraceBasedExceptionFilterFactory implements ExceptionFilterFactory {

	override create(GlobalSearchScope searchScope) {
		new TraceBasedExceptionFilter(searchScope)
	}

}

class TraceBasedExceptionFilter extends ExceptionFilter {

	@Inject ITraceForVirtualFileProvider traceProvider

	new(GlobalSearchScope scope) {
		super(scope)
		IdeaSharedInjectorProvider.injectMembers(this)
	}

	override applyFilter(String line, int textEndOffset) {
		val result = super.applyFilter(line, textEndOffset)
		if (result == null)
			return null

		val resultItem = result.resultItems.findFirst[getHyperlinkInfo != null]
		val hyperlinkInfo = resultItem.getHyperlinkInfo
		if (hyperlinkInfo instanceof FileHyperlinkInfo) {
			val descriptor = hyperlinkInfo.descriptor
			if (descriptor != null) {
				val fileInProject = new VirtualFileInProject(descriptor.file, descriptor.project)
				if (traceProvider.isGenerated(fileInProject)) {
					val trace = traceProvider.getTraceToSource(fileInProject)
					val rangeMarker = descriptor.rangeMarker
					if (trace != null && rangeMarker != null) {
						val nonSpaceCharOffset = ApplicationManager.application.<Integer>runReadAction[
							val document = FileDocumentManager.instance.getDocument(descriptor.file)
							val lineNumber = document.getLineNumber(rangeMarker.startOffset)
							DocumentUtil.getFirstNonSpaceCharOffset(document, lineNumber)
						]
						val location = trace.getBestAssociatedLocation(new TextRegion(nonSpaceCharOffset, nonSpaceCharOffset))
						if (location != null) {
							val sourceFileDescriptor = new OpenFileDescriptor(
								location.platformResource.project,
								location.platformResource.file,
								location.textRegion.lineNumber,
								0
							)
							val linkInfo = new OpenFileHyperlinkInfo(sourceFileDescriptor)
							return new Filter.Result(
								resultItem.getHighlightStartOffset,
								resultItem.getHighlightEndOffset,
								linkInfo,
								resultItem.getHighlightAttributes
							)
						}
					}
				}
			}
		}
		return result
	}

}