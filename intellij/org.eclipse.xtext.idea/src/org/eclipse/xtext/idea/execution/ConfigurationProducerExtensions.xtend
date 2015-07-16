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
import org.eclipse.xtext.idea.trace.TraceUtils
import org.jetbrains.annotations.Nullable
import org.jetbrains.annotations.NotNull

/**
 * @author dhuebner - Initial contribution and API
 */
class ConfigurationProducerExtensions {
	@Inject TraceUtils traceUtils

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
			val javaElement = traceUtils.getBestJavaElementMatch(context.location.psiElement).head
			if (javaElement !== null) {
				return javaElement
			}
		}
		return null
	}

}