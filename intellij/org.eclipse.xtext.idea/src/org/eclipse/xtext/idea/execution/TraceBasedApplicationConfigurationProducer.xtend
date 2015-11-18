package org.eclipse.xtext.idea.execution

import com.google.inject.Inject
import com.intellij.codeInsight.TestFrameworks
import com.intellij.execution.JavaExecutionUtil
import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.application.ApplicationConfiguration
import com.intellij.execution.application.ApplicationConfigurationType
import com.intellij.execution.configurations.ConfigurationUtil
import com.intellij.execution.junit.JavaRunConfigurationProducerBase
import com.intellij.openapi.module.Module
import com.intellij.openapi.util.Comparing
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import com.intellij.psi.util.PsiMethodUtil
import com.intellij.psi.util.PsiTreeUtil
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.jetbrains.annotations.Nullable

class TraceBasedApplicationConfigurationProducer extends JavaRunConfigurationProducerBase<ApplicationConfiguration> {
	@Inject extension ConfigurationProducerExtensions

	new(IXtextLanguage xtextLanguage) {
		super(ApplicationConfigurationType.instance)
		xtextLanguage.injectMembers(this)
	}

	override protected boolean setupConfigurationFromContext(ApplicationConfiguration conf,
		ConfigurationContext context, Ref<PsiElement> sourceElement) {
		val javaElement = context.tracedJavaElement
		if (javaElement !== null) {
			return internalSetupConfigurationFromContext(conf, context.prepareContextFor(javaElement), sourceElement)
		}
		return false
	}

	override boolean isConfigurationFromContext(ApplicationConfiguration appConf, ConfigurationContext context) {
		val javaElement = context.tracedJavaElement
		if (javaElement !== null) {
			return internalIsConfigurationFromContext(appConf, context.prepareContextFor(javaElement))
		}
		return false
	}

	def protected boolean internalSetupConfigurationFromContext(ApplicationConfiguration configuration,
		ConfigurationContext context, Ref<PsiElement> sourceElement) {
		val contextLocation = context.getLocation()
		if (contextLocation === null) {
			return false
		}
		val location = JavaExecutionUtil.stepIntoSingleClass(contextLocation)
		if (location === null) {
			return false
		}
		val PsiElement element = location.getPsiElement()
		if (!element.isPhysical()) {
			return false
		}
		var PsiElement currentElement = element
		var PsiMethod method
		while ((method = findMain(currentElement)) !== null) {
			val PsiClass aClass = method.getContainingClass()
			if (ConfigurationUtil.MAIN_CLASS.value(aClass)) {
				sourceElement.set(method)
				setupConfiguration(configuration, aClass, context)
				return true
			}
			currentElement = method.getParent()
		}
		val PsiClass aClass = ApplicationConfigurationType.getMainClass(element)
		if (aClass === null) {
			return false
		}
		sourceElement.set(aClass)
		setupConfiguration(configuration, aClass, context)
		return true
	}

	def private void setupConfiguration(ApplicationConfiguration configuration, PsiClass aClass,
		ConfigurationContext context) {
		configuration.MAIN_CLASS_NAME = JavaExecutionUtil.getRuntimeQualifiedName(aClass)
		configuration.setGeneratedName()
		setupConfigurationModule(context, configuration)
	}

	@Nullable def private static PsiMethod findMain(PsiElement element_finalParam_) {
		var element = element_finalParam_
		var PsiMethod method
		while ((method = PsiTreeUtil.getParentOfType(element, PsiMethod)) !== null) {
			if(PsiMethodUtil.isMainMethod(method)) return method else element = method.getParent()
		}
		return null
	}

	def boolean internalIsConfigurationFromContext(ApplicationConfiguration appConfiguration,
		ConfigurationContext context) {
		val PsiElement location = context.getPsiLocation()
		val PsiClass aClass = ApplicationConfigurationType.getMainClass(location)
		if (aClass !== null &&
			Comparing.equal(JavaExecutionUtil.getRuntimeQualifiedName(aClass), appConfiguration.MAIN_CLASS_NAME)) {
			val PsiMethod method = PsiTreeUtil.getParentOfType(location, PsiMethod, false)
			if (method !== null && TestFrameworks.getInstance().isTestMethod(method)) {
				return false
			}
			val Module configurationModule = appConfiguration.getConfigurationModule().getModule()
			if(Comparing.equal(context.getModule(), configurationModule)) return true
			var ApplicationConfiguration template = (context.getRunManager().getConfigurationTemplate(
				getConfigurationFactory()).getConfiguration() as ApplicationConfiguration)
			val Module predefinedModule = template.getConfigurationModule().getModule()
			if (Comparing.equal(predefinedModule, configurationModule)) {
				return true
			}
		}
		return false
	}
}
