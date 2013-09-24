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
import org.eclipse.xtext.builder.impl.QueuedBuildData
import org.eclipse.xtext.builder.impl.javasupport.JavaChangeQueueFiller
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
	protected QueuedBuildData queuedBuildData

	@Inject
	protected JavaChangeQueueFiller javaChangeQueueFiller

	override tearDown() throws Exception {
		testHelper.tearDown
		super.tearDown
	}

	def assertThereAreDeltas(=>void producer, String ... expectedStructucalChangedTypes) {
		producer.assertDeltas.assertThereAreDeltas(expectedStructucalChangedTypes)
	}

	def assertThereAreDeltas(Collection<? extends Delta> deltas, String... expectedStructucalChangedTypes) {
		assertNotEquals("There are not deltas", 0, deltas.size)
		if (expectedStructucalChangedTypes.length != 0) {
			val remainingQualifiedNames = <String>newHashSet(expectedStructucalChangedTypes)
			for (type : deltas.types) {
				val qualifiedName = expectedStructucalChangedTypes.findFirst[type == it]
				assertNotNull(type, qualifiedName)
				remainingQualifiedNames.remove(qualifiedName)
			}
			assertEquals('''There are not deltas for the following types: «remainingQualifiedNames»''', 0,
				remainingQualifiedNames.length)
		}
		deltas
	}

	def assertThereAreNotDeltas(=>void producer) {
		val deltas = producer.assertDeltas
		assertThereAreNotDeltas(deltas)
	}

	def assertThereAreNotDeltas(Collection<? extends Delta> deltas) {
		assertEquals("There are deltas: " + deltas.types, 0, deltas.size)
		deltas
	}

	def getTypes(Collection<? extends Delta> deltas) {
		deltas.map[
			{
				val uri = uri.toString
				uri.substring(uri.lastIndexOf("/") + 1)
			}].toSet
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
		assertTrue('''There are unconfirmed changes: «deltas.types»''', result)
	}

	def tryConfirmDeltas() {
		waitForAutoBuild
		queuedBuildData.tryConfirmAllChanges(project)
	}

}
