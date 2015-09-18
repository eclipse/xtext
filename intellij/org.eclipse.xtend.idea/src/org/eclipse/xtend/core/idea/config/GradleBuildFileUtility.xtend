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
import com.intellij.openapi.externalSystem.util.ExternalSystemApiUtil
import com.intellij.openapi.module.Module
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.util.PsiTreeUtil
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

	public val xtendGradlePluginVersion = '0.4.7'

	def boolean isGradleedModule(Module module) {
		ExternalSystemApiUtil.isExternalSystemAwareModule(GradleConstants.SYSTEM_ID, module) ||
			GradleModuleBuilder.getBuildScriptData(module) !== null
	}

	def void setupGradleBuild(Module module, GroovyFile buildFile) {
		if (buildFile === null) {
			return
		}
		val android = module.isAndroidGradleModule
		val buildScript = buildFile.createOrGetMethodCall("buildscript")
		buildScript.createOrGetMethodCall('repositories').createStatementIfNotExists('jcenter()')
		buildScript.addDependency('''classpath 'org.xtend:xtend«if(android)'-android'»-gradle-plugin:«xtendGradlePluginVersion»' ''')

		createStatementIfNotExists(buildFile, '''apply plugin: 'org.xtend.xtend«if(android)'-android'»' ''')
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

	def private void createStatementIfNotExists(GrStatementOwner statementOwner, String statement) {
		if (statementOwner.statements.findFirst[statement.trim == text] !== null) {
			return
		}
		var factory = GroovyPsiElementFactory.getInstance(statementOwner.project)
		val entry = factory.createStatementFromText(statement)
		statementOwner.addStatementBefore(entry, null)
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