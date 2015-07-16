/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.execution

import com.google.inject.Inject
import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.junit.JUnitConfiguration
import com.intellij.execution.junit.TestClassConfigurationProducer
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement
import org.eclipse.xtext.idea.lang.IXtextLanguage

/**
 * @author dhuebner - Initial contribution and API
 */
class TraceBasedJUnitClassConfigurationProducer extends TestClassConfigurationProducer {
	@Inject extension ConfigurationProducerExtensions

	new(IXtextLanguage xtextLanguage) {
		super()
		xtextLanguage.injectMembers(this)
	}

	@Override
	override boolean setupConfigurationFromContext(JUnitConfiguration configuration, ConfigurationContext context,
		Ref<PsiElement> sourceElement) {
		val javaElement = context.tracedJavaElement
		if (javaElement !== null) {
			return super.setupConfigurationFromContext(configuration, context.prepareContextFor(javaElement),
				sourceElement)
		}
		return false
	}

	override isConfigurationFromContext(JUnitConfiguration junitConf, ConfigurationContext context) {
		val javaElement = context.tracedJavaElement
		if (javaElement !== null) {
			return super.isConfigurationFromContext(junitConf, context.prepareContextFor(javaElement))
		}
		return false
	}

}
