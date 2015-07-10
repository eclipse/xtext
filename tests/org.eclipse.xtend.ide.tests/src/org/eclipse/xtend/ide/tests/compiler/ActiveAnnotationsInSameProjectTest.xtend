/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.compiler

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.junit4.internal.StopwatchRule
import org.eclipse.xtext.util.StringInputStream
import org.junit.After
import org.junit.Rule
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

import static extension org.eclipse.ui.texteditor.MarkerUtilities.*
import org.eclipse.core.runtime.Path
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil
import org.eclipse.jdt.core.IJavaProject

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ActiveAnnotationsInSameProjectTest extends AbstractXtendUITestCase {

	@Inject
	private WorkbenchTestHelper workbenchTestHelper;

	@Rule public StopwatchRule rule = new StopwatchRule(true)

	@After override void tearDown() {
		workbenchTestHelper.project.delete(true, null)
	}
	
	@Test def void testActiveAnnotationInSameProject() {
		val type1 = workbenchTestHelper.createFile('mypack/Client.xtend', '''
			package mypack
			
			import otherpack.Annotation
			
			@Annotation class Client {
			}
		''')
		val type2 = workbenchTestHelper.createFile('otherpack/Annotation.xtend', '''
			package otherpack
			
			import java.util.List
			import org.eclipse.xtend.lib.macro.AbstractClassProcessor
			import org.eclipse.xtend.lib.macro.Active
			import org.eclipse.xtend.lib.macro.CodeGenerationContext
			import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
			import org.eclipse.xtend.lib.macro.TransformationContext
			import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
			import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
			
			@Active(Processor)
			annotation Annotation {
			}
			
			class Processor extends AbstractClassProcessor {
				
				override doRegisterGlobals(List<? extends ClassDeclaration> annotatedClasses, extension RegisterGlobalsContext context) {
					context.registerInterface("mypackage.ShouldNotExist")
				}
				
				override doGenerateCode(List<? extends ClassDeclaration> annotatedSourceElements, extension CodeGenerationContext context) {
					throw new IllegalStateException("Same project, should not be called.")
				}
				
				override doTransform(List<? extends MutableClassDeclaration> annotatedClasses, extension TransformationContext context) {
					throw new IllegalStateException("Same project, should not be called.")
				}
			}
		''')
		waitForBuild()
		type1.assertHasErrors("same project")
		val file = type2.project.getFile("xtend-gen/mypackage/ShouldNotExist.java")
		assertFalse(file.exists)
		type1.setContents(new StringInputStream('''
			package mypack
			@otherpack.Annotation class Client {
				public String foo = "blabl"
			}
		'''),true,true, null)
		waitForBuild()
		assertFalse(file.exists)
		type1.assertHasErrors("same project")
	}
	
	@Test def void testActiveAnnotationInDifferentProject() {
		val annoProject = WorkbenchTestHelper.createPluginProject("annotation.project", "com.google.inject", "org.eclipse.xtend.lib", "org.eclipse.xtext.xbase.lib",
				"org.eclipse.xtend.ide.tests.data", "org.junit");
		WorkbenchTestHelper.addExportedPackages(annoProject, "otherpack");
				
		WorkbenchTestHelper.createPluginProject("client.project", "com.google.inject", "org.eclipse.xtend.lib", "org.eclipse.xtext.xbase.lib",
				"org.eclipse.xtend.ide.tests.data", "org.junit","annotation.project");
		
		annoProject.project.getFile("META-IND/MANIFEST.MF")
				
		createFile(new Path('/annotation.project/src/otherpack/Annotation.xtend'), '''
			package otherpack
			
			import java.util.List
			import org.eclipse.xtend.lib.macro.AbstractClassProcessor
			import org.eclipse.xtend.lib.macro.Active
			import org.eclipse.xtend.lib.macro.CodeGenerationContext
			import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
			import org.eclipse.xtend.lib.macro.TransformationContext
			import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
			import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
			
			@Active(Processor)
			annotation Annotation {
			}
			
			class Processor extends AbstractClassProcessor {
				
				override doRegisterGlobals(List<? extends ClassDeclaration> annotatedClasses, extension RegisterGlobalsContext context) {
					context.registerInterface("mypackage.ShouldExist")
				}
				
				override doGenerateCode(List<? extends ClassDeclaration> annotatedSourceElements, extension CodeGenerationContext context) {
				}
				
				override doTransform(List<? extends MutableClassDeclaration> annotatedClasses, extension TransformationContext context) {
				}
			}
		''')
		val type1 = createFile(new Path('/client.project/src/mypack/Client.xtend'), '''
			package mypack
			
			import otherpack.Annotation
			
			@Annotation class Client {
			}
		''')
		waitForBuild
		assertNoErrorsInWorkspace
		val file = type1.project.getFile("xtend-gen/mypackage/ShouldExist.java")
		assertTrue(file.exists)
		type1.setContents(new StringInputStream('''
			package mypack
			@otherpack.Annotation class Client {
				public String foo = "blabl"
			}
		'''),true,true, null)
		waitForBuild()
		assertTrue(file.exists)
		assertNoErrorsInWorkspace
	}
	
	@Test def void testActiveAnnotationInSameProjectWithJava() {
		val type1 = workbenchTestHelper.createFile('mypack/Client.xtend', '''
			package mypack
			
			import otherpack.Annotation
			
			@Annotation class Client {
			}
		''')
		val type2 = workbenchTestHelper.createFile('otherpack/Annotation.java', '''
			package otherpack;
			
			import org.eclipse.xtend.lib.macro.Active;
			
			@Active(Processor.class)
			public @interface Annotation {
			}
		''')
		workbenchTestHelper.createFile('otherpack/Processor.java', '''
			package otherpack;
			
			import java.util.List;
			import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
			import org.eclipse.xtend.lib.macro.CodeGenerationContext;
			import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
			import org.eclipse.xtend.lib.macro.TransformationContext;
			import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
			import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
			
			public class Processor extends AbstractClassProcessor {
				
				public void doRegisterGlobals(List<? extends ClassDeclaration> annotatedClasses, RegisterGlobalsContext context) {
					context.registerInterface("mypackage.ShouldNotExist");
				}
				
				public void doGenerateCode(List<? extends ClassDeclaration> annotatedSourceElements, CodeGenerationContext context) {
					throw new IllegalStateException("Same project, should not be called.");
				}
				
				public void doTransform(List<? extends MutableClassDeclaration> annotatedClasses, TransformationContext context) {
					throw new IllegalStateException("Same project, should not be called.");
				}
			}
		''')
		waitForBuild()
		type1.assertHasErrors("same project")
		val file = type2.project.getFile("xtend-gen/mypackage/ShouldNotExist.java")
		assertFalse(file.exists)
		type1.setContents(new StringInputStream('''
			package mypack
			@otherpack.Annotation class Client {
				public String foo = "blabl"
			}
		'''),true,true, null)
		waitForBuild()
		assertFalse(file.exists)
		type1.assertHasErrors("same project")
	}
	
	@Test def void testPropertyOfTypeInSameProject() {
		workbenchTestHelper.createFile('mypack/TypeA.xtend', '''
			package mypack
			
			class TypeA {
			}
		''')
		val type2 = workbenchTestHelper.createFile('otherpack/Client.xtend', '''
			package otherpack;
			
			import mypack.TypeA;
			
			class Client {
				@Property TypeA myTypeA
				
				def void setMyTypeA(TypeA myType) {
					_myTypeA = myType
				}
			}
		''')
		waitForBuild()
		assertNoErrorsInWorkspace
		type2.setContents(new StringInputStream('''
			package otherpack;
			
			import mypack.TypeA;
			
			class Client {
				@Property TypeA myTypeA
				
				def void setMyTypeA(TypeA myType) {
					_myTypeA = myType
				}
			}
		'''),true,true, null)
		waitForBuild()
		assertNoErrorsInWorkspace
	}

	@Test def void testActiveAnnotationInSameProjectInJar() {
		val project = JavaCore.create(
			WorkbenchTestHelper.createPluginProject(WorkbenchTestHelper.TESTPROJECT_NAME, "com.google.inject",
				"org.eclipse.xtend.lib", "org.eclipse.xtext.xbase.lib"))
		val jarFile = project.copyFile("Bug414992.jar", "Bug414992.jar")
		JavaProjectSetupUtil.addJarToClasspath(project, jarFile)
		workbenchTestHelper.createFile('mypack/Client.xtend',
			'''
				package mypack

				import myannotation.Bug414992

				@Bug414992 class Client {
				}
			''')
		waitForBuild()
		assertNoErrorsInWorkspace
	}

	def IFile copyFile(IJavaProject javaProject, String srcFile, String destFile) {
		val file = javaProject.getProject().getFile(destFile);
		val inputStream = ActiveAnnotationsInSameProjectTest.getResourceAsStream(srcFile);
		file.create(inputStream, IResource.FORCE, null);
		return file;
	}
	
	def void assertNoErrorsInWorkspace() {
		val findMarkers = ResourcesPlugin.workspace.root.findMarkers(IMarker::PROBLEM, true, IResource::DEPTH_INFINITE)
		for (iMarker : findMarkers) {
			assertFalse(iMarker.message, iMarker.severity == IMarker::SEVERITY_ERROR)
		}
	}
	
	def void assertHasErrors(IFile file, String msgPart) {
		val findMarkers = file.findMarkers(IMarker::PROBLEM, true, IResource::DEPTH_INFINITE)
		for (iMarker : findMarkers) {
			val message = iMarker.message
			if (iMarker.severity == IMarker::SEVERITY_ERROR && (message).contains(msgPart)) {
				return;
			}
		}
		fail("Expected an error marker containing '"+msgPart+"' on "+file.fullPath+" but found "+findMarkers.map[message].join(','))
	}
}
