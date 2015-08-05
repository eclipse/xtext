/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.navigation

import com.google.inject.Inject
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ui.configuration.projectRoot.LibrariesContainer
import com.intellij.openapi.roots.ui.configuration.projectRoot.LibrariesContainerFactory
import com.intellij.openapi.vfs.JarFileSystem
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.psi.util.PsiUtil
import java.io.ByteArrayInputStream
import org.eclipse.xtend.idea.LightXtendTest
import org.eclipse.xtext.generator.trace.TraceRegionSerializer
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider
import org.eclipse.xtext.idea.trace.VirtualFileInProject
import org.eclipse.xtext.util.TextRegion
import org.junit.Ignore
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.module.Module

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class IdeaTraceTest extends LightXtendTest {

	@Inject TraceRegionSerializer bareTraceReader
	@Inject ITraceForVirtualFileProvider traceProvider

	def void testTraceFileContents() {
		myFixture.addFileToProject('com/acme/MyClass.xtend', '''
			package com.acme
			class MyClass {
			}
		''')
		val file = myFixture.findFileInTempDir('xtend-gen/com/acme/MyClass.java')
		assertTrue(file.exists)
		val compiledContent = VfsUtil.loadText(file)
		assertEquals('''
			package com.acme;
			
			@SuppressWarnings("all")
			public class MyClass {
			}
		'''.toString, compiledContent)
		val traceFile = myFixture.findFileInTempDir('xtend-gen/com/acme/.MyClass.java._trace')
		assertTrue(file.exists)
		val trace = bareTraceReader.readTraceRegionFrom(new ByteArrayInputStream(traceFile.contentsToByteArray))
		val associatedPath = trace.associatedSrcRelativePath
		assertEquals('com/acme/MyClass.xtend', associatedPath.toString)
	}
	
	def void testNoTraceFile() {
		val file = myFixture.addFileToProject('com/acme/MyClass.java', '''
			package com.acme;
			public class MyClass {
			}
		''')
		val trace = traceProvider.getTraceToSource(new VirtualFileInProject(PsiUtil.getVirtualFile(file), file.project))
		assertNull(trace)
	}

	def void testTraceToTarget() {
		val psiFile = myFixture.addFileToProject('com/acme/MyClass.xtend', '''
			package com.acme
			class MyClass {
			}
		''')
		val virtualFile = psiFile.virtualFile
		val traceToTarget = traceProvider.getTraceToTarget(new VirtualFileInProject(virtualFile, psiFile.project))
		val noAssociatedLocation = traceToTarget.getBestAssociatedLocation(new TextRegion(0, 1))
		assertNull(noAssociatedLocation)
		// c#l#ass MyClass
		val associatedLocation = traceToTarget.getBestAssociatedLocation(new TextRegion(18, 1))
		assertNotNull(associatedLocation)
		val srcRelativeLocation = associatedLocation.srcRelativeResourceURI
		assertEquals('com/acme/MyClass.java', srcRelativeLocation.toString)
		assertEquals('temp:///src/xtend-gen/com/acme/MyClass.java', associatedLocation.absoluteResourceURI.toString)
	}
	
	@Ignore
	def void _testTraceToTargetForPsiFile() {
		val psiFile = myFixture.addFileToProject('com/acme/MyClass.xtend', '''
			package com.acme
			class MyClass {
			}
		''')
		val psiFileTrace = traceProvider.getGeneratedElements(psiFile)
		assertNotEmpty(psiFileTrace)
	}

	def void testTraceToSource() {
		myFixture.addFileToProject('com/acme/MyClass.xtend', '''
			package com.acme
			class MyClass {
			}
		''')
		val file = myFixture.findFileInTempDir('xtend-gen/com/acme/MyClass.java')
		val traceToSource = traceProvider.getTraceToSource(new VirtualFileInProject(file, project))
		// package c#om.a#cme
		val associatedLocation = traceToSource.getBestAssociatedLocation(new TextRegion(8, 4))
		assertNotNull(associatedLocation)
	}
	
	def void testTraceForJar_01() {
		val bin = 'smap-binary.jar'.virtualFile
		val src = 'smap-sources.jar'.virtualFile
		addLibrary(myFixture.module, bin, src)
		val jarRoot = JarFileSystem.getInstance().getJarRootForLocalFile(src);
		val generated = jarRoot.findFileByRelativePath("de/itemis/HelloXtend.java")
		val traceToSource = traceProvider.getTraceToSource(new VirtualFileInProject(generated, project))
		assertNotNull(traceToSource)
		traceToSource.allAssociatedLocations.forEach [
			assertTrue(it.absoluteResourceURI.toString.endsWith("smap-sources.jar!/de/itemis/HelloXtend.xtend"))
		]
	}
	
	def void testTraceForJar_02() {
		val bin = 'smap-binary.jar'.virtualFile
		val src = 'smap-sources.jar'.virtualFile
		addLibrary(myFixture.module, bin, src)
		val jarRoot = JarFileSystem.getInstance().getJarRootForLocalFile(src);
		val generated = jarRoot.findFileByRelativePath("de/itemis/HelloXtend.xtend")
		val traceToTarget = traceProvider.getTraceToTarget(new VirtualFileInProject(generated, project))
		//TODO we don't know how to find trace files for sources in jars
		//https://bugs.eclipse.org/bugs/show_bug.cgi?id=474324
		assertNull(traceToTarget)
	}
	
	def addLibrary(Module module, VirtualFile bin, VirtualFile src) {
		val container = LibrariesContainerFactory.createContainer(project)
		ApplicationManager.application.runWriteAction [
			val lib = container.createLibrary("my-lib", LibrariesContainer.LibraryLevel.GLOBAL, #[bin], #[src])
			val model = ModuleRootManager.getInstance(module).modifiableModel
			model.addLibraryEntry(lib)
			Disposer.register(myFixture.module, [model.dispose])
			return
		]
	}
	
	
	protected def VirtualFile getVirtualFile(String fileNameInPackage) {
		val name = "/"+class.package.name.replace('.','/') + '/'+fileNameInPackage
		val url = class.getResource(name)
		return VirtualFileManager.instance.findFileByUrl(VfsUtilCore.convertFromUrl(url))
	}

}