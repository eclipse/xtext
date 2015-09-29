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
import org.eclipse.xtend.core.idea.config.XtendLibraryConfigurator
import org.eclipse.xtend.idea.LightXtendTest
import org.jetbrains.plugins.groovy.lang.psi.GroovyFile
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrApplicationStatement
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.path.GrMethodCallExpression
import org.eclipse.xtext.util.XtextVersion

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
		    repositories {
		        jcenter()
		    }
		    dependencies {
		        classpath 'org.xtend:xtend-gradle-plugin:«XtextVersion.current.xtendGradlePluginVersion»'
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
		    classpath 'org.xtend:xtend-gradle-plugin:«XtextVersion.current.xtendGradlePluginVersion»'
		}
		    repositories {
		        jcenter()
		    }
		}
		apply plugin: 'org.xtend.xtend' '''.toString.trim, buildFile.text)

	}

	def void testAddDependencyEmptyFile() {
		val buildFile = myFixture.addFileToProject('build.gradle', '') as GroovyFile
		assertNotNull(buildFile)
		WriteCommandAction.runWriteCommandAction(myFixture.project, [
			util.addDependency(buildFile, "compile '" + XtendLibraryConfigurator.xtendLibMavenId().toString + "'")
		])
		assertEquals('''
		dependencies {
		    compile '«XtendLibraryConfigurator.xtendLibMavenId().toString»'
		}'''.toString, buildFile.text)
	}

	def void testAddDependencyFileWithContent() {
		val buildFile = myFixture.addFileToProject('build.gradle', '''dependencies {}''') as GroovyFile

		assertNotNull(buildFile)
		WriteCommandAction.runWriteCommandAction(myFixture.project, [
			util.addDependency(buildFile, "compile '" + XtendLibraryConfigurator.xtendLibMavenId().toString + "'")
		])
		assertEquals('''
		dependencies {
		    compile '«XtendLibraryConfigurator.xtendLibMavenId().toString»'
		}'''.toString, buildFile.text)
	}

	def void _testIsGradleModule() {
		//TODO 
		myFixture.addFileToProject('build.gradle', '')
		assertTrue(util.isGradleedModule(myFixture.module))
	}

	def assertTree(GroovyFile buildFile) {
		assertEquals(2, buildFile.getStatements().length)
		val bsCol = buildFile.statements.filter(GrMethodCallExpression).filter[invokedExpression.text == 'buildscript']
		assertEquals(1,bsCol.size)
		val bs = bsCol.head
		assertEquals('buildscript', bs.invokedExpression.text)
		
		val children = bs.closureArguments.head.children.filter(GrMethodCallExpression)
		assertEquals(2,children.size)
		
		val dps = children.filter[invokedExpression.text == 'dependencies'].head
		assertNotNull(dps)
		assertEquals(3, dps.children.length)
		val closureBlock = dps.closureArguments.head
		assertEquals(1, closureBlock.statements.length)

		val clEntry = closureBlock.statements.filter(GrApplicationStatement).head
		assertNotNull(clEntry)
		assertEquals('classpath', clEntry.invokedExpression.text)
		assertTrue(clEntry.argumentList.text.startsWith("'org.xtend:xtend-gradle-plugin:"))
		
		val repos = children.filter[invokedExpression.text == 'repositories'].head
		assertNotNull(repos)
		
		val jcenterEntry = repos.closureArguments.head.statements.filter(GrMethodCallExpression).head
		assertEquals('jcenter', jcenterEntry.invokedExpression.text)
	}
}