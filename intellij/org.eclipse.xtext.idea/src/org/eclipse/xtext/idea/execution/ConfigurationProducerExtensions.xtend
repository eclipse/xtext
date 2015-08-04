/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.execution

import com.google.inject.Inject
import com.intellij.execution.Location
import com.intellij.execution.PsiLocation
import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.actionSystem.DataContextWrapper
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import org.eclipse.xtext.idea.trace.IIdeaTrace
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider
import org.eclipse.xtext.idea.trace.VirtualFileInProject
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

import static extension com.intellij.psi.util.PsiTreeUtil.*

/**
 * @author dhuebner - Initial contribution and API
 */
class ConfigurationProducerExtensions {
	@Inject ITraceForVirtualFileProvider traceProvider

	def ConfigurationContext prepareContextFor(ConfigurationContext context, PsiElement psiElement) {
		val ctx = ConfigurationContext.getFromContext(new DataContextWrapper(context.dataContext) {
			override getData(String dataId) {
				if (RunConfiguration.DATA_KEY.is(dataId)) {
					return context.getOriginalConfiguration(null)
				} else if (LangDataKeys.MODULE.is(dataId)) {
					return context.module
				} else if (Location.DATA_KEY.is(dataId)) {
					return PsiLocation.fromPsiElement(psiElement)
				}
				return super.getData(dataId)
			}
		})
		return ctx
	}

	@Nullable
	def PsiElement tracedJavaElement(@NotNull ConfigurationContext context) {
		if (context.location?.psiElement !== null) {
			val psiElement = context.location?.psiElement
			var javaElement = traceProvider.getGeneratedElements(psiElement).head
			if (javaElement === null) {
				javaElement = psiElement.javaFiles.head
			}
			return javaElement
		}
		return null
	}

	def private Iterable<PsiFile> getJavaFiles(@NotNull PsiElement xtextElement) {
		val xtextFile = xtextElement.getParentOfType(BaseXtextFile, false)
		if (xtextFile == null) {
			return emptySet
		}
		val IIdeaTrace trace = traceProvider.getTraceToTarget(
			new VirtualFileInProject(xtextFile.virtualFile, xtextFile.project))
		if (trace !== null) {
			val javaFiles = newArrayList
			for (uri : trace.allAssociatedLocations) {
				val javaPsiFile = PsiManager.getInstance(xtextFile.project).findFile(uri.platformResource.file)
				javaFiles.add(javaPsiFile)
			}
			return javaFiles
		}
		return emptySet
	}
}