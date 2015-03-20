package org.eclipse.xtext.xbase.idea.execution

import com.google.inject.Inject
import com.intellij.codeInsight.TestFrameworks
import com.intellij.execution.JavaExecutionUtil
import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.application.ApplicationConfiguration
import com.intellij.execution.application.ApplicationConfigurationType
import com.intellij.execution.configurations.ConfigurationUtil
import com.intellij.execution.junit.JavaRunConfigurationProducerBase
import com.intellij.openapi.util.Comparing
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.idea.types.psi.JvmPsiClasses
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations

import static extension com.intellij.execution.application.ApplicationConfigurationType.*
import static extension com.intellij.psi.util.PsiMethodUtil.*
import static extension com.intellij.psi.util.PsiTreeUtil.*

class JvmTypesApplicationConfigurationProducer extends JavaRunConfigurationProducerBase<ApplicationConfiguration> {

	@Inject
	extension JvmPsiClasses

	@Inject
	extension IPsiJvmModelAssociations

	IXtextLanguage xtextLanguage

	new(IXtextLanguage xtextLanguage) {
		super(ApplicationConfigurationType.instance)
		xtextLanguage.injectMembers(this)
		this.xtextLanguage = xtextLanguage
	}

	override protected boolean setupConfigurationFromContext(
		ApplicationConfiguration configuration,
		ConfigurationContext context,
		Ref<PsiElement> sourceElement
	) {
		context.location.psiElement.elements.exists [
			setupConfiguration(configuration, context, sourceElement)
		]
	}

	protected def setupConfiguration(
		PsiElement it,
		ApplicationConfiguration configuration,
		ConfigurationContext context,
		Ref<PsiElement> sourceElement
	) {
		setupConfigurationWithMethod(configuration, context, sourceElement) ||
			setupConfigurationWithClass(configuration, context, sourceElement)
	}

	protected def boolean setupConfigurationWithClass(
		PsiElement element,
		ApplicationConfiguration configuration,
		ConfigurationContext context,
		Ref<PsiElement> sourceElement
	) {
		val mainClass = element.mainClass
		if (mainClass == null) {
			return false
		}
		sourceElement.set(mainClass)
		setupConfiguration(configuration, mainClass, context)
		return true
	}

	protected def boolean setupConfigurationWithMethod(
		PsiElement element,
		ApplicationConfiguration configuration,
		ConfigurationContext context,
		Ref<PsiElement> sourceElement
	) {
		val mainMethod = element.findMainMethod
		if (mainMethod == null) {
			return false
		}
		val class = mainMethod.containingClass
		if (ConfigurationUtil.MAIN_CLASS.value(class)) {
			sourceElement.set(mainMethod)
			setupConfiguration(configuration, class, context)
			return true
		}
		mainMethod.parent.setupConfigurationWithMethod(configuration, context, sourceElement)
	}

	protected def void setupConfiguration(
		ApplicationConfiguration configuration,
		PsiClass aClass,
		ConfigurationContext context
	) {
		configuration.MAIN_CLASS_NAME = JavaExecutionUtil.getRuntimeQualifiedName(aClass)
		configuration.setGeneratedName()
		setupConfigurationModule(context, configuration)
	}

	protected def PsiMethod findMainMethod(PsiElement element) {
		val method = element.getParentOfType(PsiMethod, false)
		if (method == null) {
			return null
		}
		if (method.mainMethod) {
			return method
		}
		method.parent.findMainMethod
	}

	override boolean isConfigurationFromContext(
		ApplicationConfiguration appConfiguration,
		ConfigurationContext context
	) {
		context.psiLocation.elements.exists [
			isConfiguration(appConfiguration, context)
		]
	}

	protected def isConfiguration(
		PsiElement element,
		ApplicationConfiguration appConfiguration,
		ConfigurationContext context
	) {
		val mainClass = element.mainClass
		if (mainClass == null) {
			return false
		}
		if (!Comparing.equal(JavaExecutionUtil.getRuntimeQualifiedName(mainClass), appConfiguration.MAIN_CLASS_NAME)) {
			return false
		}
		val method = element.getParentOfType(PsiMethod, false)
		if (method != null && TestFrameworks.getInstance().isTestMethod(method)) {
			return false
		}
		val configurationModule = appConfiguration.configurationModule.module
		if (Comparing.equal(context.module, configurationModule)) {
			return true
		}
		var template = context.runManager.getConfigurationTemplate(configurationFactory).configuration
		if (template instanceof ApplicationConfiguration) {
			val predefinedModule = template.configurationModule.module
			if (Comparing.equal(predefinedModule, configurationModule)) {
				return true
			}
		}
		return false
	}

	protected def Iterable<? extends PsiElement> getElements(PsiElement element) {
		if (element == null) {
			return emptyList
		}
		if (element instanceof BaseXtextFile) {
			return element.jvmPsiClasses
		}
		val jvmElements = element.jvmElements
		if (!jvmElements.empty) {
			return jvmElements
		}
		return element.parent.elements
	}

}