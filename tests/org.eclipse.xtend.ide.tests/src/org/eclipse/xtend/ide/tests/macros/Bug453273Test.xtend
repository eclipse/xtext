/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.macros

import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.jar.Manifest
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.junit4.internal.StopwatchRule
import org.eclipse.xtext.util.StringInputStream
import org.junit.After
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

import static org.eclipse.xtend.ide.tests.WorkbenchTestHelper.*
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

/**
 * @author Joerg Reichert - Initial contribution and API
 */
class Bug453273Test {

	@Rule public StopwatchRule stopwatch = new StopwatchRule(true);

	@After def tearDown() throws Exception {
		cleanWorkspace();
	}

	@Test def void test() {
		val macroProject = JavaCore.create(createPluginProject("macroProject"))
		macroProject.newSource("annotation/MyAnnotation.xtend", '''
			package annotation
			
			import java.lang.annotation.ElementType
			import java.lang.annotation.Target
			import org.eclipse.xtend.lib.macro.AbstractClassProcessor
			import org.eclipse.xtend.lib.macro.Active
			import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
			import org.eclipse.xtend.lib.macro.TransformationContext
			import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
			import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
			import org.eclipse.xtend.lib.macro.declaration.Visibility
			
			@Target(ElementType.TYPE)
			@Active(typeof(MyAnnotationProcessor))
			annotation MyAnnotation {
			}
			
			class MyAnnotationProcessor extends AbstractClassProcessor {
			
				override doRegisterGlobals(ClassDeclaration annotatedType, RegisterGlobalsContext registerGlobalsContext) {
					registerGlobalsContext.registerClass(annotatedType.getDollarNestedClassName)
					registerGlobalsContext.registerClass(annotatedType.getDollarNestedNestedClassName)
					registerGlobalsContext.registerClass(annotatedType.getDotNestedClassName)
					registerGlobalsContext.registerClass(annotatedType.getDotNestedNestedClassName)
				}
			
				def getDollarNestedClassName(ClassDeclaration annotatedClass) {
					annotatedClass.qualifiedName + "$NestedType1"
				}

				def getDollarNestedNestedClassName(ClassDeclaration annotatedClass) {
					annotatedClass.qualifiedName + "$NestedType1$NestedType2"
				}
			
				def getDotNestedClassName(ClassDeclaration annotatedClass) {
					annotatedClass.qualifiedName + ".NestedType31"
				}
			
				def getDotNestedNestedClassName(ClassDeclaration annotatedClass) {
					annotatedClass.qualifiedName.replace(annotatedClass.simpleName, "") + "NestedType32.NestedType4"
				}
			
				override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
					val nestedType = findClass(annotatedClass.getDollarNestedClassName)
					val nestedType2 = findClass(annotatedClass.getDollarNestedNestedClassName)
					val nestedType3 = findClass(annotatedClass.getDotNestedClassName)
					val nestedType4 = findClass(annotatedClass.getDotNestedNestedClassName)
					nestedType.addStaticNameField(context)
					nestedType2.addStaticNameField(context)
					nestedType3.addStaticNameField(context)
					nestedType4.addStaticNameField(context)
				}
				
				def private addStaticNameField(MutableClassDeclaration nestedType, extension TransformationContext context) {
					nestedType.addField("name") [
						visibility = Visibility.PRIVATE
						static = true
						type = string
						initializer = «"'''"»"test"«"'''"»
					]
				}
			}
		''')
		macroProject.addExportedPackage("annotation")
		waitForAutoBuild()
				
		val userProject = JavaCore.create(
			createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib",
				"org.eclipse.xtend.core.tests", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit", "macroProject"))
		userProject.newSource("client/MyAnnotationUser.xtend", '''
			package client
			
			import annotation.MyAnnotation
			
			@MyAnnotation
			class MyAnnotationUser {
				
				def static void main(String[] args) {
					println(NestedType1.NestedType2.name)
				}
			}
		''')
		
		cleanBuild
		waitForBuild(new NullProgressMonitor)
		assertNoErrorsInWorkspace
		
		val clientPackage = userProject.project.getFolder("src/client")
		Assert.assertEquals("Expected classes MyAnnotationUser, NestedType31 and sub package NestedType32", 3, clientPackage.members.size)
		
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

	def void addExportedPackage(IJavaProject pluginProject, String ... exportedPackages) {
		val manifestFile = pluginProject.project.getFile("META-INF/MANIFEST.MF")
		val manifestContent = manifestFile.contents
		val manifest = try {
			new Manifest(manifestContent)
		} finally {
			manifestContent.close
		}
		val attrs = manifest.getMainAttributes()
		if (attrs.containsKey("Export-Package")) {
			attrs.putValue("Export-Package", attrs.get("Export-Package") + "," + exportedPackages.join(","))
		} else {
			attrs.putValue("Export-Package", exportedPackages.join(","))
		}
		val out = new ByteArrayOutputStream()
		manifest.write(out)
		val in = new ByteArrayInputStream(out.toByteArray)
		manifestFile.setContents(new BufferedInputStream(in), true, true, null)
	}
}