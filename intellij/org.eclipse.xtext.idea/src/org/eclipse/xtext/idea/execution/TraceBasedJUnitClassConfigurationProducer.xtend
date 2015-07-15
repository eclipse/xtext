/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.execution

import com.google.inject.Inject
import com.intellij.execution.JavaExecutionUtil
import com.intellij.execution.Location
import com.intellij.execution.PsiLocation
import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.junit.JUnitConfiguration
import com.intellij.execution.junit.JUnitUtil
import com.intellij.execution.junit.TestClassConfigurationProducer
import com.intellij.execution.junit2.PsiMemberParameterizedLocation
import com.intellij.openapi.module.Module
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.idea.trace.TraceUtils

/**
 * @author dhuebner - Initial contribution and API
 */
class TraceBasedJUnitClassConfigurationProducer extends TestClassConfigurationProducer {
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
			if (javaElement != null) {
				if (originalLocation instanceof PsiMemberParameterizedLocation) {
					val paramSetName = originalLocation.getParamSetName()
					if (paramSetName !== null) {
						configuration.setProgramParameters(paramSetName)
					}
				}
				val javaContextLocation = PsiLocation.fromPsiElement(javaElement)
				val Location<?> javaClassLocation = JavaExecutionUtil.stepIntoSingleClass(javaContextLocation)
				if(javaClassLocation === null) return false

				var PsiClass testClass = JUnitUtil.getTestClass(javaClassLocation)
				if(testClass === null) return false
				
				sourceElement.set(testClass)
				setupConfigurationModule(context, configuration)
				val Module originalModule = configuration.getConfigurationModule().getModule()
				configuration.beClassConfiguration(testClass)
				configuration.restoreOriginalModule(originalModule)
				val String forkMode = configuration.getForkMode()
				if (JUnitConfiguration.FORK_KLASS.equals(forkMode)) {
					configuration.setForkMode(JUnitConfiguration.FORK_NONE)
				}
				return true
			}
		}
		return false
	}

	override isConfigurationFromContext(JUnitConfiguration junitConf, ConfigurationContext context) {
		super.isConfigurationFromContext(junitConf, context)
	}

}
