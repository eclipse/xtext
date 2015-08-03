/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.navigation

import org.eclipse.xtend.idea.LightXtendTest
import com.intellij.openapi.vfs.VfsUtil
import org.eclipse.xtext.generator.trace.TraceRegionSerializer
import com.google.inject.Inject
import java.io.ByteArrayInputStream
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider
import org.eclipse.xtext.idea.trace.VirtualFileInProject
import org.eclipse.xtext.util.TextRegion
import org.junit.Ignore

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

}