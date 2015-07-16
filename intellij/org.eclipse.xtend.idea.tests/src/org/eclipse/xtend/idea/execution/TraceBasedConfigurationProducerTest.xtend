/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.execution

import com.intellij.execution.ExecutionException
import com.intellij.execution.Location
import com.intellij.execution.PsiLocation
import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.RunConfigurationProducer
import com.intellij.execution.application.ApplicationConfiguration
import com.intellij.execution.configurations.JavaCommandLine
import com.intellij.execution.configurations.JavaParameters
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.configurations.RuntimeConfigurationError
import com.intellij.execution.configurations.RuntimeConfigurationException
import com.intellij.execution.executors.DefaultRunExecutor
import com.intellij.execution.runners.ExecutionEnvironmentBuilder
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.module.ModuleUtilCore
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiMethodUtil
import com.intellij.testFramework.MapDataContext
import com.intellij.util.containers.ContainerUtilRt
import java.util.Collections
import org.eclipse.xtend.core.idea.execution.XtendApplicationConfigurationProducer
import org.eclipse.xtend.idea.XtendIdeaTestCase
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.jetbrains.annotations.NotNull

/**
 * @author dhuebner - Initial contribution and API
 */
class TraceBasedConfigurationProducerTest extends XtendIdeaTestCase {

	def void testApplicationConfiguration() {
		var code = '''
			/**
			* Test
			*/
			class XtendMainClass {
				/** test method */
				def static void m|ain(String[] args) {
					println("Hello")
					println("World")
				}
			}
		'''
		val cursorIdx = code.indexOf('|')
		code = code.replace('|', '')
		val file = addFile("XtendMainClass.xtend" -> code)
		val xtendFile = psiManager.findFile(file)
		assertTrue(xtendFile instanceof BaseXtextFile)

		val sourceElement = xtendFile.viewProvider.findElementAt(cursorIdx)
		val configuration = createConfiguration(sourceElement,
			XtendApplicationConfigurationProducer) as ApplicationConfiguration

		assertEquals(Collections.singleton(module), ContainerUtilRt.newHashSet(configuration.getModules()))
		assertTrue(PsiMethodUtil.hasMainMethod(configuration.mainClass))
		assertEquals("XtendMainClass", configuration.mainClass.qualifiedName);
		assertEquals("XtendMainClass", configuration.getName())

		checkCanRun(configuration)
		val sameConfiguration = createConfiguration(sourceElement, XtendApplicationConfigurationProducer)

		val producer = RunConfigurationProducer.getInstance(XtendApplicationConfigurationProducer)
		assertTrue(producer.isConfigurationFromContext(sameConfiguration, createContext(sourceElement)))
	}

	def protected createConfiguration(PsiElement psiElement, Class<? extends RunConfigurationProducer<?>> clazz) {
		val context = createContext(psiElement);
		val producer = RunConfigurationProducer.getInstance(clazz)
		assertNotNull(producer)
		val fromContext = producer.createConfigurationFromContext(context);
		assertNotNull(fromContext);
		return fromContext.getConfiguration()
	}

	def private ConfigurationContext createContext(@NotNull PsiElement psiClass) {
		val dataContext = new MapDataContext();
		return createContext(psiClass, dataContext);
	}

	def private ConfigurationContext createContext(@NotNull PsiElement psiClass, @NotNull MapDataContext dataContext) {
		dataContext.put(CommonDataKeys.PROJECT, myProject);
		if (LangDataKeys.MODULE.getData(dataContext) == null) {
			dataContext.put(LangDataKeys.MODULE, ModuleUtilCore.findModuleForPsiElement(psiClass));
		}
		dataContext.put(Location.DATA_KEY, PsiLocation.fromPsiElement(psiClass));
		return ConfigurationContext.getFromContext(dataContext);
	}

	def static JavaParameters checkCanRun(RunConfiguration configuration) throws ExecutionException {
		val RunProfileState state = ExecutionEnvironmentBuilder.create(DefaultRunExecutor.getRunExecutorInstance(),
			configuration).build().getState();
		assertNotNull(state);
		assertTrue(state instanceof JavaCommandLine);
		try {
			configuration.checkConfiguration();
		} catch (RuntimeConfigurationError e) {
			fail("cannot run: " + e.getMessage());
		} catch (RuntimeConfigurationException e) {
			fail("cannot run: " + e.getMessage());
		}
		return (state as JavaCommandLine).getJavaParameters();
	}

}