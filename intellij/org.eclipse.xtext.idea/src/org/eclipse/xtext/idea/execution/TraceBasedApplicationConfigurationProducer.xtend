package org.eclipse.xtext.idea.execution

import com.google.inject.Inject
import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.application.ApplicationConfiguration
import com.intellij.execution.application.ApplicationConfigurationProducer
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement
import org.eclipse.xtext.idea.lang.IXtextLanguage

class TraceBasedApplicationConfigurationProducer extends ApplicationConfigurationProducer {
	@Inject extension ConfigurationProducerExtensions

	new(IXtextLanguage xtextLanguage) {
		super()
		xtextLanguage.injectMembers(this)
	}

	override protected boolean setupConfigurationFromContext(ApplicationConfiguration conf,
		ConfigurationContext context, Ref<PsiElement> sourceElement) {
		val javaElement = context.tracedJavaElement
		if (javaElement !== null) {
			return super.setupConfigurationFromContext(conf, context.prepareContextFor(javaElement), sourceElement)
		}
		return false
	}

	override boolean isConfigurationFromContext(ApplicationConfiguration appConf, ConfigurationContext context) {
		val javaElement = context.tracedJavaElement
		if (javaElement !== null) {
			return super.isConfigurationFromContext(appConf, context.prepareContextFor(javaElement))
		}
		return false
	}

}
