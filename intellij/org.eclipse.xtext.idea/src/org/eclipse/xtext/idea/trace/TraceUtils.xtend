/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.trace

import com.google.common.collect.Lists
import com.google.inject.Inject
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.util.PsiUtilCore
import org.eclipse.xtext.generator.trace.TraceFileNameProvider
import org.eclipse.xtext.generator.trace.TraceRegionSerializer
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.TextRegion
import org.jetbrains.annotations.NotNull

import static extension com.intellij.psi.util.PsiTreeUtil.*
import static extension org.eclipse.xtext.idea.resource.VirtualFileURIUtil.*

/**
 * @author dhuebner - Initial contribution and API
 */
class TraceUtils {
	@Inject TraceRegionSerializer traceRegionSerializer
	@Inject TraceFileNameProvider traceFileNameProvider

	def Iterable<PsiElement> getBestJavaElementMatch(@NotNull PsiElement xtextElement) {
		val xtextFile = xtextFile(xtextElement)
		val javaElements = Lists.newArrayList
		if (xtextFile != null) {
			val builder = xtextElement.project.getComponent(XtextAutoBuilderComponent)
			val generated = builder.getGeneratedSources(xtextFile.virtualFile.getURI)
			if (generated != null) {
				for (uri : generated.filter[fileExtension == 'java']) {
					val lastSegmentOfTrace = traceFileNameProvider.getTraceFromJava(uri.lastSegment)
					val traceFile = uri.trimSegments(1).appendSegment(lastSegmentOfTrace).virtualFile
					if (traceFile != null && traceFile.exists) {
						val javaPsiFile = PsiManager.getInstance(xtextElement.project).findFile(uri.virtualFile)
						if (xtextElement instanceof BaseXtextFile) {
							javaElements.add(javaPsiFile)
						} else {
							val traces = traceRegionSerializer.readTraceRegionFrom(traceFile.inputStream)
							val sourceRegion = xtextElement.textRange.toTextRegion
							val matches = traces.leafIterator.filter[mergedAssociatedLocation.contains(sourceRegion)]
							if (!matches.empty) {
								val bestTrace = matches.min([ t1, t2 |
									t1.mergedAssociatedLocation.length.compareTo(t2.mergedAssociatedLocation.length)
								])
								javaElements.add(PsiUtilCore.getElementAtOffset(javaPsiFile, bestTrace.myOffset))
							}
						}
					}
				}
			}
		}
		return javaElements
	}

	def ITextRegion toTextRegion(TextRange range) {
		return new TextRegion(range.startOffset, range.length)
	}

	def protected BaseXtextFile xtextFile(PsiElement element) {
		if (element instanceof BaseXtextFile) {
			return element
		}
		return element.getParentOfType(BaseXtextFile)
	}

}