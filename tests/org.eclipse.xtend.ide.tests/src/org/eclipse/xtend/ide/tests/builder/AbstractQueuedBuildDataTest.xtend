/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.builder

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.builder.impl.javasupport.JavaChangeQueueFiller
import org.eclipse.xtext.builder.impl.javasupport.JdtQueuedBuildData
import org.eclipse.xtext.resource.IResourceDescription.Delta

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
abstract class AbstractQueuedBuildDataTest extends AbstractXtendUITestCase {

	/**
	 * <p>
	 * To print events into the console set <code>VERBOSE</code> flag of <code>JavaEditorExtension</code> as <code>true</code>.
	 * </p>
	 */
	@Inject
	protected extension JavaEditorExtension

	@Inject
	protected extension WorkbenchTestHelper testHelper

	@Inject
	protected JdtQueuedBuildData queuedBuildData

	@Inject
	protected JavaChangeQueueFiller javaChangeQueueFiller

	override tearDown() throws Exception {
		testHelper.tearDown
		super.tearDown
	}

	def assertThereAreDeltas(=>void producer, String ... expectedExportedNames) {
		producer.assertDeltas.assertThereAreDeltas(expectedExportedNames)
	}

	def assertThereAreDeltas(Collection<? extends Delta> deltas, String... expectedExportedNames) {
		assertTrue("There are not deltas", 0 != deltas.size)
		if (expectedExportedNames.length != 0) {
			val remainingExportedNames = <String>newHashSet(expectedExportedNames)
			val unexpectedExportedNames = <String>newHashSet
			for (exportedName : deltas.exportedNames) {
				val qualifiedName = expectedExportedNames.findFirst[exportedName == it]
				if (qualifiedName == null) {
					unexpectedExportedNames.add(exportedName)
				} else {
					remainingExportedNames.remove(qualifiedName)
				}
			}
			assertEquals('''There are unexpected exported names: «unexpectedExportedNames»''', 0,
				unexpectedExportedNames.length)
			assertEquals('''There are not expected exported names «remainingExportedNames»''', 0,
				remainingExportedNames.length)
		}
		deltas
	}

	def assertThereAreNotDeltas(=>void producer) {
		val deltas = producer.assertDeltas
		assertThereAreNotDeltas(deltas)
	}

	def assertThereAreNotDeltas(Collection<? extends Delta> deltas) {
		assertEquals("There are deltas: " + deltas.exportedNames, 0, deltas.size)
		deltas
	}

	def getExportedNames(Collection<? extends Delta> deltas) {
		deltas.map[
			{
				val names = <String>newHashSet
				if (!haveEObjectDescriptionsChanged) {
					return names
				}
				getNew?.exportedObjects?.forEach [
					names += name.toString
				]
				old?.exportedObjects?.forEach [
					names += name.toString
				]
				names
			}].reduce[t, t2|
			{
				t.addAll(t2)
				t
			}]
	}

	def assertDeltas(=>void producer) {
		reset
		producer.apply
		confirmDeltas
		queuedBuildData.andRemovePendingDeltas
	}

	def reset() {
		waitForAutoBuild
		queuedBuildData.reset
	}

	def confirmDeltas() {
		val result = tryConfirmDeltas
		val deltas = queuedBuildData.unconfirmedDeltas
		assertTrue('''There are unconfirmed changes: «deltas.exportedNames»''', result)
	}

	def tryConfirmDeltas() {
		waitForAutoBuild
		!queuedBuildData.needRebuild(project)
	}

}
