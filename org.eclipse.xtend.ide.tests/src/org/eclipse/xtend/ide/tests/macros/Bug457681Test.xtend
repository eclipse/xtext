/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.macros

import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend.ide.tests.StopwatchRule
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil
import org.eclipse.xtext.util.StringInputStream
import org.junit.After
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*

import static extension org.eclipse.xtend.ide.tests.WorkbenchTestHelper.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class Bug457681Test {

	@Rule public StopwatchRule stopwatch = new StopwatchRule(true);

	@BeforeClass
	def static void prepareEclipse() throws Exception {
		TargetPlatformUtil.setTargetPlatform(Bug457681Test);
	}

	@After def tearDown() throws Exception {
		cleanWorkspace();
	}

	@Test def void testDaBug_1() {
		val macroProject = JavaCore.create(createPluginProject("macroProject"))
		macroProject.newSource("annotation/MyAA.xtend", '''
			package annotation
			
			import org.eclipse.xtend.lib.macro.AbstractClassProcessor
			import org.eclipse.xtend.lib.macro.Active
			import org.eclipse.xtend.lib.macro.TransformationContext
			import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
			
			@Active(MyAAProcessor)
			annotation MyAA {
			}
			
			class MyAAProcessor extends AbstractClassProcessor {
				
				override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
					if(annotatedClass.extendedClass.declaredSuperTypes.empty) {
						annotatedClass.addError("Supertype must declare a supertype")
					}
				}
			}
		''')
		macroProject.project.addExportedPackages("annotation")
		waitForBuild()
				
		val userProject = JavaCore.create(
			createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib",
				"org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "macroProject"))
		userProject.newSource("client/A.xtend", '''
			package client
			
			import client.sub.B
			
			@SuppressWarnings("all")
			class A implements Cloneable {
				public B sub
			}
		''')
		userProject.newSource("client/sub/B.xtend", '''
			package client.sub
			
			import annotation.MyAA
			import client.A
			
			@MyAA
			
			class B extends A {
			}
		''')
		
		cleanBuild
		waitForBuild()
		assertNoErrorsInWorkspace
	}
	
	@Test def void testDaBug_NoAnnotationOnA() {
		val macroProject = JavaCore.create(createPluginProject("macroProject"))
		macroProject.newSource("annotation/MyAA.xtend", '''
			package annotation
			
			import org.eclipse.xtend.lib.macro.AbstractClassProcessor
			import org.eclipse.xtend.lib.macro.Active
			import org.eclipse.xtend.lib.macro.TransformationContext
			import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
			
			@Active(MyAAProcessor)
			annotation MyAA {
			}
			
			class MyAAProcessor extends AbstractClassProcessor {
				
				override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
					if(annotatedClass.extendedClass.declaredSuperTypes.empty) {
						annotatedClass.addError("Supertype must declare a supertype")
					}
				}
			}
		''')
		macroProject.project.addExportedPackages("annotation")
		waitForBuild()
				
		val userProject = JavaCore.create(
			createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib",
				"org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "macroProject"))
		userProject.newSource("client/A.xtend", '''
			package client
			
			import client.sub.B
			
			class A implements Cloneable {
				public B sub
			}
		''')
		userProject.newSource("client/sub/B.xtend", '''
			package client.sub
			
			import annotation.MyAA
			import client.A
			
			@MyAA
			
			class B extends A {
			}
		''')
		
		cleanBuild
		waitForBuild
		assertNoErrorsInWorkspace
	}
	
	def IFile newSource(IJavaProject it, String fileName, String contents) {
		val result = it.project.getFile("src/" + fileName)
		var parent = result.parent
		while (!parent.exists) {
			(parent as IFolder).create(true, false, null)
		}
		result.create(new StringInputStream(contents), true, null)
		return result
	}
}