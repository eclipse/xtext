/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.macros

import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend.ide.buildpath.XtendLibClasspathAdder
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.util.StringInputStream
import org.junit.After
import org.junit.Assert
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

import static extension org.eclipse.xtend.ide.tests.WorkbenchTestHelper.*
import static extension org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
class JdtBasedProcessorProviderTest {

	@After def tearDown() throws Exception {
		cleanWorkspace();
	}

	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=439925
	 */
	@Test def void testClassLoaderSeesAllUpstreamProjects() {
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
					val comment = getClass.getClassLoader.loadClass("mylib.Lib").newInstance.toString
					annotatedClass.docComment = comment
				}
			}
		''')
		macroProject.project.addExportedPackages("annotation")
		
		val libProject = JavaCore.create(createPluginProject("libProject"))
		libProject.newSource("mylib/Lib.xtend", '''
			package mylib
			
			class Lib {
				override String toString() {
					return "HUNKELDUNKEL"
				}
			}
		''')
		libProject.project.addExportedPackages("mylib")
		waitForBuild()
				
		val userProject = JavaCore.create(
			createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib",
				"org.eclipse.xtend.core.tests", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "macroProject", "libProject"))
		userProject.newSource("client/A.xtend", '''
			package client
			
			@annotation.MyAA
			class SomeClass {
			}
		''')
		
		cleanBuild
		waitForBuild()
		assertNoErrorsInWorkspace();
		
		val javaCode = (file("userProject/xtend-gen/client/SomeClass.java") as IFile).contentsAsString
		Assert.assertTrue(javaCode.contains("HUNKELDUNKEL"))
	}
	
	@Test def void testClassLoaderSeesAllUpstreamProjects_01() {
		val libProject = JavaCore.create(createPluginProject("libProject"))
		libProject.newSource("mylib/Lib.xtend", '''
			package mylib
			
			class Lib {
				override String toString() {
					return "HUNKELDUNKEL"
				}
			}
		''')
		libProject.project.addExportedPackages("mylib")
		
		val macroProject = JavaCore.create(createPluginProject("macroProject", "com.google.inject", "org.eclipse.xtend.lib",
				"org.eclipse.xtend.core.tests", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "libProject"))
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
					annotatedClass.docComment = new mylib.Lib().toString()
				}
			}
		''')
		macroProject.project.addExportedPackages("annotation")
		waitForBuild()
				
		val userProject = JavaCore.create(
			createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib",
				"org.eclipse.xtend.core.tests", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "macroProject"))
		userProject.newSource("client/A.xtend", '''
			package client
			
			@annotation.MyAA
			class SomeClass {
			}
		''')
		
		cleanBuild
		waitForBuild()
		assertNoErrorsInWorkspace();
		
		val javaCode = (file("userProject/xtend-gen/client/SomeClass.java") as IFile).contentsAsString
		Assert.assertTrue(javaCode.contains("HUNKELDUNKEL"))
	}
	
	XtendLibClasspathAdder xtendLibs = new XtendLibClasspathAdder()
	
	private def xtendProject(String name, IJavaProject...upstreamProjects) {
		val result = createJavaProject(name)
		result.project.addNature(XtextProjectHelper.NATURE_ID)
		xtendLibs.addLibsToClasspath(result, null)
		for (it : upstreamProjects) {
			addToClasspath(result, JavaCore.newProjectEntry(getPath(), true));
		}
		return result
	}
	
	@Test def void testClassLoaderSeesAllDepsFromReferencedProjects() {
		val libProject = xtendProject("libProject")
		libProject.newSource("mylib/Lib.xtend", '''
			package mylib
			
			class Lib {
				override String toString() {
					return "HUNKELDUNKEL"
				}
			}
		''')
		
		val macroProject = xtendProject("macroProject", xtendProject("inbetween", libProject))
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
					annotatedClass.docComment = new mylib.Lib().toString()
				}
			}
		''')
		waitForBuild()
				
		val userProject = xtendProject("userProject", macroProject)
		userProject.newSource("client/A.xtend", '''
			package client
			
			@annotation.MyAA
			class SomeClass {
			}
		''')
		
		cleanBuild
		waitForBuild()
		assertNoErrorsInWorkspace();
		
		val javaCode = (file("userProject/xtend-gen/client/SomeClass.java") as IFile).contentsAsString
		Assert.assertTrue(javaCode.contains("HUNKELDUNKEL"))
	}
	
	@Test def void testClassLoaderDoesNotSeeLocalClasses() {
		
		val macroProject = xtendProject("macroProject")
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
					try {
						Class.forName("client.B")
					} catch (ClassNotFoundException e) {
						annotatedClass.docComment = 'classnotfound'
					}
				}
			}
		''')
		waitForBuild()
				
		val userProject = xtendProject("userProject", macroProject)
		userProject.newSource("client/B.java", '''
			package client;
			public class B {}
		''')
		userProject.newSource("client/A.xtend", '''
			package client
			
			@annotation.MyAA
			class SomeClass {
			}
		''')
		
		cleanBuild
		waitForBuild()
		assertNoErrorsInWorkspace();
		
		val javaCode = (file("userProject/xtend-gen/client/SomeClass.java") as IFile).contentsAsString
		Assert.assertTrue(javaCode.contains("classnotfound"))
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