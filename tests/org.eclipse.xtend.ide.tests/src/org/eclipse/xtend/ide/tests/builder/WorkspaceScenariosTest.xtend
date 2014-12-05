/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.builder

import com.google.common.io.ByteStreams
import java.io.ByteArrayInputStream
import java.io.InputStream
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IResourceVisitor
import org.eclipse.jdt.core.JavaCore
import org.eclipse.ui.texteditor.MarkerUtilities
import org.eclipse.xtext.util.StringInputStream
import org.junit.Assert
import org.junit.Test

import static extension org.eclipse.xtend.ide.tests.WorkbenchTestHelper.*
import static extension org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import static extension org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class WorkspaceScenariosTest {
	
	@Test def void testJarWithEverything() {
		val project = createProjectWithJarDependency[ false ]
		try {
			assertNoErrorsInWorkspace
		} finally {
			project.delete(true, true, null)
		}
	}
	
	@Test def void testJarWithoutJava() {
		val project = createProjectWithJarDependency[ endsWith('java') || endsWith('class')]
		try {
			// Java errors in the generated Java but not in Xtend
			val allXtendMarkers = newArrayList
			project.accept[
				if (it instanceof IFile) {
					if (fullPath.lastSegment.endsWith(".xtend")) {
						val markers = it.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE)
						for (m : markers) {
							allXtendMarkers += m
						}
					}
				}
				return true
			]
			Assert.assertEquals(3, allXtendMarkers.size)
			// only Java errors!
			Assert.assertTrue(allXtendMarkers.forall[MarkerUtilities.getMessage(it).startsWith("Java problem:")])
		} finally {
			project.delete(true, true, null)
		}
	}
	
	@Test def void testJarWithoutXtend() {
		val project = createProjectWithJarDependency[ !(endsWith('java') || endsWith('class'))]
		try {
			assertNoErrorsInWorkspace
		} finally {
			project.delete(true, true, null)
		}
	}
	
	@Test def void testJarWithoutStorage() {
		val project = createProjectWithJarDependency[ endsWith('bin') ]
		try {
			assertNoErrorsInWorkspace
		} finally {
			project.delete(true, true, null)
		}
	}
	
	@Test def void testIncrementalChangeOnBidirectionalDep() {
		"my.project".createPluginProject('org.eclipse.xtext.xbase.lib', 'org.eclipse.xtend.lib')
		val fileA = 'my.project/src/mypack/ClassA.xtend'.createFile('''
			package mypack
			
			class ClassA {
				
				def void myMethod(ClassB b) {
					b.myMethod
				}
			}
		''')
		'my.project/src/mypack/ClassB.xtend'.createFile('''
			package mypack
			
			class ClassB {
				
				def void anotherMethod(ClassA a) {
					a.anotherMethod
				}
			}
		''')
		waitForAutoBuild
		assertNoErrorsInWorkspace
		val javaB = fileA.project.getFile("xtend-gen/mypack/ClassB.java")
		// check that a.anotherMethod is an extension call
		assertTrue(new String(ByteStreams.toByteArray(javaB.contents)).contains("anotherMethod(a);"))
		
		
		fileA.setContents(new StringInputStream('''
			package mypack
			
			class ClassA {
				
				def void myMethod(ClassB b) {
					b.myMethod
				}
				
				def void anotherMethod() {}
			}
		'''), true, true, null)
		waitForAutoBuild
		assertNoErrorsInWorkspace
		// check that a.anotherMethod is no longer an extension call
		assertTrue(new String(ByteStreams.toByteArray(javaB.contents)).contains("a.anotherMethod();"))
	}
	
	protected def IProject createProjectWithJarDependency((String)=>boolean jarFilter) {
		// create a jar without the bin files
		val jarData = createJar(#[
		'mypack/MyData.xtend'->'''
			package mypack
			
			import org.eclipse.xtend.lib.annotations.Data
			
			@Data class MyData {
				String someProp
				int anotherProp
			}
		'''], jarFilter)
		
		// create a project WITHOUT xtend.lib on classpath
		val project = "my.project".createPluginProject('org.eclipse.xtext.xbase.lib')
		val jarFile = project.getFile("mydependency.jar")
		jarFile.create(new ByteArrayInputStream(jarData), true, null)
		JavaCore.create(project).addJarToClasspath(jarFile)
		
		"my.project/src/pack/MyClass.xtend".createFile('''
			package pack
			
			import mypack.MyData
			
			class MyClass {
				
				def String myMethod() {
					val myData = new MyData('foo', 42)
					return myData.getSomeProp() + myData.getAnotherProp()
				}
			}
		''')
		
		waitForAutoBuild
		return project
	}
	
	def byte[] createJar(Iterable<? extends Pair<? extends String, ? extends String>> sourceFiles, (String)=>boolean filter) {
		val project = "my.temporary.data.project".createPluginProject('org.eclipse.xtext.xbase.lib', 'org.eclipse.xtend.lib')
		try {
			JavaCore.create(project).addSourceFolder("src")
			JavaCore.create(project).addSourceFolder("xtend-gen")
			for (sourceFile : sourceFiles) {
				('my.temporary.data.project/src/'+sourceFile.key).createFile(sourceFile.value)
			}
			waitForAutoBuild
			
			val listOfContents = <String,InputStream>newHashMap
			
			val IResourceVisitor visitor = [
				if (it instanceof IFile) {
					val path = it.projectRelativePath.removeFirstSegments(1).toString
					if (!filter.apply(path))
						listOfContents.put(path , contents)
				}
				return true
			]
			
			project.getFolder('src').accept(visitor)
			project.getFolder('xtend-gen').accept(visitor)
			project.getFolder('bin').accept(visitor)
			
			val jarin = jarInputStream(listOfContents.entrySet.map[key->value].toList)
			return ByteStreams.toByteArray(jarin)
		} finally {
			project.delete(true, true, null)
		}
	}
	
}