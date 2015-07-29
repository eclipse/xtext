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
import com.intellij.openapi.extensions.Extensions
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleUtilCore
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiMethodUtil
import com.intellij.testFramework.MapDataContext
import com.intellij.testIntegration.JavaTestFramework
import com.intellij.testIntegration.TestFramework
import com.intellij.util.containers.ContainerUtilRt
import java.util.Collections
import org.eclipse.xtend.core.idea.execution.XtendApplicationConfigurationProducer
import org.eclipse.xtend.core.idea.execution.XtendJunitClassConfigurationProducer
import org.eclipse.xtend.core.idea.execution.XtendJunitMethodConfigurationProducer
import org.eclipse.xtend.idea.XtendIdeaTestCase
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.jetbrains.annotations.NotNull

/**
 * @author dhuebner - Initial contribution and API
 */
class TraceBasedConfigurationProducerTest extends XtendIdeaTestCase {

	def void testApplicationConfiguration_1() {
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
		val configuration = createConfiguration(sourceElement, XtendApplicationConfigurationProducer) 

		assertEquals(Collections.singleton(module), ContainerUtilRt.newHashSet(configuration.getModules()))
		assertTrue(PsiMethodUtil.hasMainMethod(configuration.mainClass))
		assertEquals("XtendMainClass", configuration.mainClass.qualifiedName);
		assertEquals("XtendMainClass", configuration.getName())

		checkCanRun(configuration)
		val sameConfiguration = createConfiguration(sourceElement, XtendApplicationConfigurationProducer)

		val RunConfigurationProducer<ApplicationConfiguration> producer = RunConfigurationProducer.getInstance(XtendApplicationConfigurationProducer)
		assertTrue(producer.isConfigurationFromContext(sameConfiguration, createContext(sourceElement)))
	}

	def void testApplicationConfiguration_2() {
		var code = '''
			import java.util.List
			|
			
			/**
			* Test
			*/
			class XtendMainClass {
				/** test method */
				def static void main(String[] args) {
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
		val context = createContext(sourceElement);
		val producer = RunConfigurationProducer.getInstance(XtendApplicationConfigurationProducer)
		val confFromContext = producer.createConfigurationFromContext(context);
		assertNotNull(confFromContext)
		checkCanRun(confFromContext.configuration)
	}

	def void testApplicationConfigurationNoSelection() {
		val file = addFile("XtendMainClass.xtend" -> '''
			class XtendMainClass {
				def static void main(String[] args) {
				}
			}
		''')
		val xtendFile = psiManager.findFile(file)
		val conf = createConfiguration(xtendFile, XtendApplicationConfigurationProducer)
		checkCanRun(conf)
	}

	def void testJunitConfigurationNoSelection() {
		addJunit4Lib(module)
		val file = addFile("XtendJunitClass.xtend" -> '''
			import org.junit.Assert
			import org.junit.Test
			
			class XtendJunitClass extends Assert{
				@Test
				def void testMethod() {
					assertTrue(true)
				}
				@Test
				def void testMethod2() {
					assertTrue(true)
				}
			}
		''')
		val xtendFile = psiManager.findFile(file)
		val conf = createConfiguration(xtendFile, XtendJunitClassConfigurationProducer)
		assertEquals("XtendJunitClass", conf.getPersistentData().MAIN_CLASS_NAME)
		assertEquals("class", conf.getPersistentData().TEST_OBJECT)
		checkCanRun(conf)
	}

	def void testJunitConfigurationMethod_1() {
		addJunit4Lib(module)
		var code = '''
			import org.junit.Assert
			import org.junit.Test
			
			class XtendJunitClass extends Assert{
				@Test
				def void test|Method() {
					assertTrue(true)
				}
				@Test
				def void testMethod2() {
					assertTrue(true)
				}
			}
		'''
		val cursorIdx = code.indexOf('|')
		code = code.replace('|', '')
		val file = addFile("XtendJunitClass.xtend" -> code)
		val xtendFile = psiManager.findFile(file)
		assertTrue(xtendFile instanceof BaseXtextFile)

		val sourceElement = xtendFile.viewProvider.findElementAt(cursorIdx)
		val configuration = createConfiguration(sourceElement, XtendJunitMethodConfigurationProducer)
		assertEquals("XtendJunitClass", configuration.getPersistentData().MAIN_CLASS_NAME)
		assertEquals("method", configuration.getPersistentData().TEST_OBJECT)
		assertEquals("testMethod", configuration.getPersistentData().METHOD_NAME)
		checkCanRun(configuration)
	}

	def void testJunitConfigurationMethod_2() {
		addJunit4Lib(module)
		var code = '''
			import org.junit.Assert
			import org.junit.Test
			
			class XtendJunitClass extends Assert{
				@Test
				def void testMethod() {
					assertTrue(true)
				}
				@Test
				def void testM|ethod2() {
					assertTrue(true)
				}
			}
		'''
		val cursorIdx = code.indexOf('|')
		code = code.replace('|', '')
		val file = addFile("XtendMainClass.xtend" -> code)
		val xtendFile = psiManager.findFile(file)
		assertTrue(xtendFile instanceof BaseXtextFile)

		val sourceElement = xtendFile.viewProvider.findElementAt(cursorIdx)
		val configuration = createConfiguration(sourceElement, XtendJunitMethodConfigurationProducer)
		assertEquals("XtendJunitClass", configuration.getPersistentData().MAIN_CLASS_NAME)
		assertEquals("method", configuration.getPersistentData().TEST_OBJECT)
		assertEquals("testMethod2", configuration.getPersistentData().METHOD_NAME)
		checkCanRun(configuration)
	}

	def protected addJunit4Lib(Module module) {
		val frameworks = Extensions.getExtensions(TestFramework.EXTENSION_NAME)
		val junit4 = frameworks.findFirst["JUnit4" == name]
		if (!junit4.isLibraryAttached(module)) {
			if (junit4 instanceof JavaTestFramework) {
				junit4.setupLibrary(module)
			}
		}
	}

	def protected <T extends RunConfiguration> T createConfiguration(PsiElement psiElement, Class<? extends RunConfigurationProducer<T>> clazz) {
		val context = createContext(psiElement);
		val producer = RunConfigurationProducer.getInstance(clazz)
		assertNotNull(producer)
		val fromContext = producer.createConfigurationFromContext(context);
		assertNotNull(fromContext);
		return fromContext.getConfiguration() as T
	}

	def private ConfigurationContext createContext(@NotNull PsiElement psiClass) {
		val dataContext = new MapDataContext()
		return createContext(psiClass, dataContext)
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