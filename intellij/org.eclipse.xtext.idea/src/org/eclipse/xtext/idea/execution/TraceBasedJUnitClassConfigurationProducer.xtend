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
import com.intellij.execution.junit.JUnitConfiguration
import com.intellij.execution.junit.JUnitUtil
import com.intellij.execution.junit.TestClassConfigurationProducer
import com.intellij.openapi.actionSystem.DataContextWrapper
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.util.Key
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.idea.trace.TraceUtils

/**
 * @author dhuebner - Initial contribution and API
 */
class TraceBasedJUnitClassConfigurationProducer extends TestClassConfigurationProducer {
	static final Key<PsiClass> TRACE_BASED_PSI_KEY = Key.create("TRACE_BASED_PSI_KEY")
	@Inject TraceUtils traceUtils
	IXtextLanguage xtextLanguage

	new(IXtextLanguage xtextLanguage) {
		super()
		xtextLanguage.injectMembers(this)
		this.xtextLanguage = xtextLanguage
	}

	@Override
	override boolean setupConfigurationFromContext(JUnitConfiguration configuration, ConfigurationContext context,
		Ref<PsiElement> sourceElement) {
		if (context.location !== null) {
			val originalLocation = context.location
			val javaElement = traceUtils.getBestJavaElementMatch(originalLocation.psiElement).head
			if (javaElement !== null) {
				val testClass = JUnitUtil.getTestClass(javaElement)
				if (testClass !== null) {
					configuration.putUserData(TRACE_BASED_PSI_KEY, testClass)
					return super.setupConfigurationFromContext(configuration, prepareContext(context, testClass),
						sourceElement)
				}
			}
		}
		return false
	}

	override isConfigurationFromContext(JUnitConfiguration junitConf, ConfigurationContext context) {
		var PsiClass testClass = null
		val storedXtextLeafTarget = junitConf.getUserData(TRACE_BASED_PSI_KEY)
		if (storedXtextLeafTarget !== null) {
			testClass = storedXtextLeafTarget
		} else {
			testClass = JUnitUtil.getTestClass(traceUtils.getBestJavaElementMatch(context.location.psiElement).head)
		}
		if (testClass === null) {
			return false
		}
		return super.isConfigurationFromContext(junitConf, prepareContext(context, testClass))
	}

	def ConfigurationContext prepareContext(ConfigurationContext context, PsiElement psiElement) {
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
}
