/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.config

import com.intellij.openapi.command.WriteCommandAction
import org.eclipse.xtend.core.idea.config.GradleBuildFileUtility
import org.eclipse.xtend.core.idea.config.XtendLibraryManager
import org.eclipse.xtend.idea.LightXtendTest
import org.jetbrains.plugins.groovy.lang.psi.GroovyFile
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrApplicationStatement
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.path.GrMethodCallExpression

/**
 * @author dhuebner - Initial contribution and API
 */
class GradleBuildFileUtilTest extends LightXtendTest {
	val util = new GradleBuildFileUtility

	def void testSetupGradleBuildEmptyFile() {
		val buildFile = myFixture.addFileToProject('build.gradle', '') as GroovyFile

		assertNotNull(buildFile)

		// running twice to test duplicates
		WriteCommandAction.runWriteCommandAction(myFixture.project, [util.setupGradleBuild(myModule, buildFile)])
		WriteCommandAction.runWriteCommandAction(myFixture.project, [util.setupGradleBuild(myModule, buildFile)])

		assertTree(buildFile)

		assertEquals('''
		buildscript {
		    dependencies {
		        classpath 'org.xtend:xtend-gradle-plugin:«util.xtendGradlePluginVersion»'
		    }
		}
		apply plugin: 'org.xtend.xtend' '''.toString.trim, buildFile.text)
	}

	def void testSetupGradleBuildFileWithContent() {
		val buildFile = myFixture.addFileToProject('build.gradle', 'buildscript{dependencies{}}') as GroovyFile

		assertNotNull(buildFile)

		// running twice to test duplicates
		WriteCommandAction.runWriteCommandAction(myFixture.project, [util.setupGradleBuild(myModule, buildFile)])
		WriteCommandAction.runWriteCommandAction(myFixture.project, [util.setupGradleBuild(myModule, buildFile)])

		assertTree(buildFile)

		assertEquals('''
		buildscript{dependencies{
		    classpath 'org.xtend:xtend-gradle-plugin:«util.xtendGradlePluginVersion»'
		}}
		apply plugin: 'org.xtend.xtend' '''.toString.trim, buildFile.text)

	}

	def void testAddDependencyEmptyFile() {
		val buildFile = myFixture.addFileToProject('build.gradle', '') as GroovyFile
		assertNotNull(buildFile)
		WriteCommandAction.runWriteCommandAction(myFixture.project, [
			util.addDependency(buildFile, "compile '" + XtendLibraryManager.xtendLibMavenId().toString + "'")
		])
		assertEquals('''
		dependencies {
		    compile '«XtendLibraryManager.xtendLibMavenId().toString»'
		}'''.toString, buildFile.text)
	}

	def void testAddDependencyFileWithContent() {
		val buildFile = myFixture.addFileToProject('build.gradle', '''dependencies {}''') as GroovyFile

		assertNotNull(buildFile)
		WriteCommandAction.runWriteCommandAction(myFixture.project, [
			util.addDependency(buildFile, "compile '" + XtendLibraryManager.xtendLibMavenId().toString + "'")
		])
		assertEquals('''
		dependencies {
		    compile '«XtendLibraryManager.xtendLibMavenId().toString»'
		}'''.toString, buildFile.text)
	}

	def void _testIsGradleModule() {
		//TODO 
		myFixture.addFileToProject('build.gradle', '')
		assertTrue(util.isGradleedModule(myFixture.module))
	}

	def assertTree(GroovyFile buildFile) {
		assertEquals(2, buildFile.getStatements().length)
		assertTrue(buildFile.statements.get(0) instanceof GrMethodCallExpression)
		val bs = buildFile.statements.get(0) as GrMethodCallExpression
		assertEquals('buildscript', bs.invokedExpression.text)
		val dps = bs.closureArguments.head.children.filter(GrMethodCallExpression).head
		assertEquals('dependencies', dps.invokedExpression.text)
		assertEquals(3, dps.children.length)
		val closureBlock = dps.closureArguments.head
		assertEquals(1, closureBlock.statements.length)

		val clEntry = closureBlock.statements.filter(GrApplicationStatement).head
		assertNotNull(clEntry)
		assertEquals('classpath', clEntry.invokedExpression.text)
		assertTrue(clEntry.argumentList.text.startsWith("'org.xtend:xtend-gradle-plugin:"))
	}
}