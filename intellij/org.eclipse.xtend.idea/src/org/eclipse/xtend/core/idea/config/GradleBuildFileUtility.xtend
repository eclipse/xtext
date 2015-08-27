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
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.util.PsiTreeUtil
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

	public val xtendGradlePluginId = '0.4.7'

	def boolean isGradleedModule(Module module) {
		ExternalSystemApiUtil.isExternalSystemAwareModule(GradleConstants.SYSTEM_ID, module)
	}

	def setupGradleBuild(Module module) {
		val buildFile = locateBuildFile(module)
		if (buildFile === null) {
			return
		}
		val buildScriptDeps = buildFile.createOrGetBlock("buildscript")
		val android = module.isAndroidGradleModule
		buildScriptDeps.addDependency('''classpath 'org.xtend:xtend«if(android)'-android'»-gradle-plugin:«xtendGradlePluginId»' ''')

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

	def void addDependency(PsiElement parentElement, String dependencyEntry) {
		parentElement.dependencies().createStatementIfNotExists(dependencyEntry)
	}

	def private createStatementIfNotExists(GrStatementOwner statementOwner, String statement) {
		if (statementOwner.statements.findFirst[statement == text] !== null) {
			return
		}
		var factory = GroovyPsiElementFactory.getInstance(statementOwner.project)
		statementOwner.addStatementBefore(factory.createStatementFromText(statement), null)
	}

	def GrClosableBlock dependencies(PsiElement parent) {
		parent.createOrGetBlock("dependencies")
	}

	def private GrClosableBlock createOrGetBlock(PsiElement element, String blockName) {
		var closableBlocks = PsiTreeUtil.getChildrenOfTypeAsList(element, GrMethodCall)
		var block = closableBlocks.findFirst [
			var expression = getInvokedExpression()
			expression !== null && blockName.equals(expression.getText())
		]
		if (block === null) {
			var factory = GroovyPsiElementFactory.getInstance(element.project)
			block = factory.createStatementFromText(
			'''
			«blockName» {
			}''') as GrMethodCall
			element.add(block)
		}
		return block.firstClosureArgument
	}

	def GrClosableBlock firstClosureArgument(GrCall call) {
		call.getClosureArguments().head
	}

	def isAndroidGradleModule(Module module) {
		//TODO find a smarter way to detect
		val mnr = FacetManager.getInstance(module)
		val foo = mnr.allFacets.<Facet<?>>filter["Android-Gradle" == name]
		return foo.size > 0
	}
}