/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.trace

import com.google.inject.Inject
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
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

	def Iterable<? extends PsiElement> getBestJavaElementMatch(@NotNull PsiElement xtextElement) {
		if (xtextElement instanceof BaseXtextFile) {
			return getJavaFiles(xtextElement)
		}
		val javaElements = newArrayList
		for (javaFile : getJavaFiles(xtextElement)) {
			val uri = javaFile.virtualFile.URI
			val lastSegmentOfTrace = traceFileNameProvider.getTraceFromJava(uri.lastSegment)
			val traceFile = uri.trimSegments(1).appendSegment(lastSegmentOfTrace).virtualFile
			if (traceFile != null && traceFile.exists) {
				val traces = traceRegionSerializer.readTraceRegionFrom(traceFile.inputStream)
				val sourceRegion = xtextElement.textRange.toTextRegion
				val matches = traces.treeIterator.filter[mergedAssociatedLocation.contains(sourceRegion)]
				if (!matches.empty) {
					val bestTrace = matches.min([ t1, t2 |
						t1.mergedAssociatedLocation.length.compareTo(t2.mergedAssociatedLocation.length)
					])
					javaElements.add(PsiUtilCore.getElementAtOffset(javaFile, bestTrace.myOffset))
				}
			}
			return javaElements
		}
		return emptySet
	}

	def Iterable<PsiFile> getJavaFiles(@NotNull PsiElement xtextElement) {
		val xtextFile = xtextElement.getParentOfType(BaseXtextFile, false)
		if (xtextFile == null) {
			return emptySet
		}
		val builder = xtextFile.project.getComponent(XtextAutoBuilderComponent)
		val generated = builder.getGeneratedSources(xtextFile.virtualFile.getURI)
		if (generated != null) {
			val javaFiles = newArrayList
			for (uri : generated.filter[fileExtension == 'java']) {
				val javaPsiFile = PsiManager.getInstance(xtextFile.project).findFile(uri.virtualFile)
				javaFiles.add(javaPsiFile)
			}
			return javaFiles
		}
		return emptySet
	}

	def ITextRegion toTextRegion(TextRange range) {
		return new TextRegion(range.startOffset, range.length)
	}

}