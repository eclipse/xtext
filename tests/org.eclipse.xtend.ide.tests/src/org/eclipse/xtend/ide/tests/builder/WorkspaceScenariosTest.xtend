/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.builder

import com.google.common.io.ByteStreams
import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.name.Named
import java.io.ByteArrayInputStream
import java.io.InputStream
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IResourceVisitor
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.util.StringInputStream
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

import static extension org.eclipse.xtend.ide.tests.WorkbenchTestHelper.*
import static extension org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import static extension org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtendIDEInjectorProvider)
class WorkspaceScenariosTest {
	
	@Inject
	@Named(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS)
	private Provider<IResourceDescriptions> persistedResourceDescriptions;
	
	@Test def void testJarWithEverything() {
		val project = createProjectWithJarDependency[ false ]
		try {
			assertNoErrorsInWorkspace
			assertEquals(1, persistedResourceDescriptions.get.allResourceDescriptions.length)
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
			Assert.assertEquals(2, allXtendMarkers.size)
			assertEquals(1, persistedResourceDescriptions.get.allResourceDescriptions.length)
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
		waitForBuild
		assertNoErrorsInWorkspace
		val javaB = fileA.project.getFile("xtend-gen/mypack/ClassB.java")
		// check that a.anotherMethod is an extension call
		assertTrue(javaB.contentsAsString.contains("anotherMethod(a);"))
		
		
		fileA.setContents(new StringInputStream('''
			package mypack
			
			class ClassA {
				
				def void myMethod(ClassB b) {
					b.myMethod
				}
				
				def void anotherMethod() {}
			}
		'''), true, true, null)
		waitForBuild
		assertNoErrorsInWorkspace
		// check that a.anotherMethod is no longer an extension call
		assertTrue(javaB.contentsAsString.contains("a.anotherMethod();"))
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
		addJarToProject(project, jarData)
		
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
		
		waitForBuild
		return project
	}
	
	protected def addJarToProject(IProject project, byte[] jarData) {
		val jarFile = project.getFile("mydependency.jar")
		jarFile.create(new ByteArrayInputStream(jarData), true, null)
		JavaCore.create(project).addJarToClasspath(jarFile)
	}
	
	def byte[] createJar(Iterable<? extends Pair<? extends String, ? extends String>> sourceFiles, (String)=>boolean filter) {
		val project = "my.temporary.data.project".createPluginProject('org.eclipse.xtext.xbase.lib', 'org.eclipse.xtend.lib')
		val listOfContents = <String,InputStream>newHashMap
		try {
			JavaCore.create(project).addSourceFolder("src")
			JavaCore.create(project).addSourceFolder("xtend-gen")
			for (sourceFile : sourceFiles) {
				('my.temporary.data.project/src/'+sourceFile.key).createFile(sourceFile.value)
			}
			waitForBuild
			
			
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
			for (it : listOfContents.values) {
				close
			}
			project.delete(true, true, null)
		}
	}
	
}