/*******************************************************************************
 * Copyright (c) 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.compiler

import com.google.common.io.ByteStreams
import com.google.inject.Inject
import java.util.concurrent.atomic.AtomicBoolean
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.Opcodes

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class QuickDebugSourceInstallingCompilationParticipantTest extends AbstractXtendUITestCase {

	@Inject
	WorkbenchTestHelper workbenchTestHelper;

	@Before @After def void cleanUp() {
		workbenchTestHelper.tearDown
	}

	@Test def void testIfThereIsAnyStatum() {
		val source = workbenchTestHelper.createFile('somePackage/Outer.xtend', '''
			package somePackage
			
			class Outer {
			  def dosomething() {
			  	println(1)
			  	println(2)
			  	println(3)
			  }
			}
		''')
		waitForBuild()
		val clazz = source.project.getFile("bin/somePackage/Outer.class")
		assertTrue("bytecode not found", clazz.exists)

		val debugInfoFound = new AtomicBoolean(false)
		try (val in = clazz.getContents()) {
			val bytes = ByteStreams.toByteArray(in)
			val r = new ClassReader(bytes)
			r.accept(new ClassVisitor(Opcodes.ASM9) {

				override visitSource(String source, String debug) {
					if ("Outer.java" == source) {
						assertEquals('''
							SMAP
							Outer.java
							Xtend
							*S Xtend
							*F
							+ 0 Outer.xtend
							somePackage/Outer.xtend
							*L
							4:8,2
							5:10
							6:11
							7:12
							4:13,2
							*E
						'''.toString.replace("\r", ""),
							debug.replace("\r", ""))
						debugInfoFound.set(true)
					}
					super.visitSource(source, debug)
				}

			}, 0)
			if (!debugInfoFound.get) {
				fail("No source attribute found in bytecode")
			}
		}
	}
}
