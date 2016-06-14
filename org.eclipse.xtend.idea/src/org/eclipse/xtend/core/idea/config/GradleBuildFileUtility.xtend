/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.config

import com.intellij.facet.Facet
import com.intellij.facet.FacetManager
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.util.ExternalSystemApiUtil
import com.intellij.openapi.module.Module
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.util.PsiTreeUtil
import org.eclipse.xtext.idea.util.PlatformUtil
import org.eclipse.xtext.util.XtextVersion
import org.jetbrains.plugins.gradle.service.project.wizard.GradleModuleBuilder
import org.jetbrains.plugins.gradle.util.GradleConstants
import org.jetbrains.plugins.groovy.lang.psi.GroovyFile
import org.jetbrains.plugins.groovy.lang.psi.GroovyPsiElementFactory
import org.jetbrains.plugins.groovy.lang.psi.api.statements.blocks.GrClosableBlock
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrCall
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrMethodCall
import org.jetbrains.plugins.groovy.lang.psi.api.util.GrStatementOwner

/**
 * @author dhuebner - Initial contribution and API
 */
class GradleBuildFileUtility {
	static final Logger LOG = Logger.getInstance(GradleBuildFileUtility.name)
	
	def boolean isGradleedModule(Module module) {
		if (new PlatformUtil().isGradleInstalled) {
			return ExternalSystemApiUtil.isExternalSystemAwareModule(GradleConstants.SYSTEM_ID, module) ||
				GradleModuleBuilder.getBuildScriptData(module) !== null
		}
		return false
	}

	def void addXtendLibGradleDependency(Module module, boolean isTestScope) {
		val buildFile = module.locateBuildFile
		if (buildFile === null) {
			LOG.error("Gradle build file not found in module " + module.name)
			return
		}

		new WriteCommandAction.Simple(module.project, "Gradle: Add Xtend Runtime Library",
			newImmutableList(buildFile)) {
			override protected run() throws Throwable {
				val scope = if(isTestScope) "testCompile" else "compile"
				buildFile.addDependency('''«scope» '«XtendLibraryConfigurator.xtendLibMavenId.key»' ''')
			}
		}.execute

	}

	def void setupGradleBuild(Module module, GroovyFile buildFile) {
		if (buildFile === null) {
			return
		}
		val android = module.isAndroidGradleModule
		if (buildFile.statements.findFirst [
			text.trim.matches('''apply plugin:.*org\\.xtext«if(android)'\\.android'»\\.xtend.*''')
		] !== null) {
			return
		}
		val buildScript = buildFile.createOrGetMethodCall("buildscript")
		buildScript.createOrGetMethodCall('repositories').createStatementIfNotExists('jcenter()')
		val pluginDef = 
			if (android) 
				'''classpath 'org.xtext:xtext-android-gradle-plugin:«XtextVersion.current.xtendAndroidGradlePluginVersion»' '''
			else 
				'''classpath 'org.xtext:xtext-gradle-plugin:«XtextVersion.current.xtendGradlePluginVersion»' '''
								
		buildScript.addDependency(pluginDef)
		createStatementIfNotExists(buildFile, '''apply plugin: 'org.xtext«if(android)'.android'».xtend' ''')
	}

	def GroovyFile locateBuildFile(Module module) {
		val modulePath = ExternalSystemApiUtil.getExternalProjectPath(module)
		if (modulePath !== null) {
			var buildScriptPath = FileUtil.findFileInProvidedPath(modulePath, GradleConstants.DEFAULT_SCRIPT_NAME)
			if (!buildScriptPath.isNullOrEmpty) {
				var VirtualFile virtualFile = LocalFileSystem.getInstance().refreshAndFindFileByPath(buildScriptPath)
				if (virtualFile !== null) {
					val PsiFile psiFile = PsiManager.getInstance(module.project).findFile(virtualFile)
					if (psiFile instanceof GroovyFile && psiFile.valid) {
						return psiFile as GroovyFile
					}
				}
			}
		}
		return null
	}

	def void addDependency(GrStatementOwner parentElement, String dependencyEntry) {
		parentElement.createOrGetMethodCall("dependencies").createStatementIfNotExists(dependencyEntry)
	}

	def private boolean createStatementIfNotExists(GrStatementOwner statementOwner, String statement) {
		if (statementOwner.statements.findFirst[statement.trim == text] !== null) {
			return false
		}
		var factory = GroovyPsiElementFactory.getInstance(statementOwner.project)
		val entry = factory.createStatementFromText(statement)
		statementOwner.addStatementBefore(entry, null)
		return true
	}

	def private GrClosableBlock createOrGetMethodCall(GrStatementOwner element, String methodName) {
		var methodCalls = PsiTreeUtil.getChildrenOfTypeAsList(element, GrMethodCall)
		var methodCall = methodCalls.findFirst [
			var expression = getInvokedExpression()
			expression !== null && methodName.equals(expression.getText())
		]
		if (methodCall === null) {
			var factory = GroovyPsiElementFactory.getInstance(element.project)
			methodCall = element.addStatementBefore(factory.createStatementFromText('''«methodName»{}'''),
				null) as GrMethodCall
		}
		return methodCall.firstClosureArgument
	}

	def private GrClosableBlock firstClosureArgument(GrCall call) {
		call.getClosureArguments().head
	}

	def isAndroidGradleModule(Module module) {
		// TODO find a smarter way to detect
		val mnr = FacetManager.getInstance(module)
		val foo = mnr.allFacets.<Facet<?>>filter["android-gradle" == it.typeId.toString]
		return foo.size > 0
	}
}
