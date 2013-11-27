/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.builder

import org.junit.Test

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class SeveralEditorsQueuedBuildTest extends AbstractQueuedBuildDataTest {

	@Test def void saveSeveralEditorsOneByOne() {
		createFile('/mypackage/Foo.java',
			'''
				package mypackage;
				
				public class Foo {
				
					public void foo() {
					}
				
				}
			''')
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					public void bar() {
					}
				
				}
			''')
		reset

		val fooEditor = '/mypackage/Foo.java'.reconcile("foo", "foo2")
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		val barEditor = '/mypackage/Bar.java'.reconcile("bar", "bar2")
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		barEditor.save
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreDeltas("mypackage.Bar")
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		confirmDeltas
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreDeltas("mypackage.Bar")

		fooEditor.save
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreDeltas("mypackage.Foo")
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		confirmDeltas
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreDeltas("mypackage.Foo")
	}

	@Test def void closeEditorWithChanges() {
		createFile('/mypackage/Foo.java',
			'''
				package mypackage;
				
				public class Foo {
				
					public void foo() {
					}
				
				}
			''')
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					public void bar() {
					}
				
				}
			''')
		reset

		val fooEditor = '/mypackage/Foo.java'.reconcile("foo", "foo2")
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		val barEditor = '/mypackage/Bar.java'.reconcile("bar", "bar2")
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		fooEditor.close
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		barEditor.save
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreDeltas("mypackage.Bar")
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		confirmDeltas
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreDeltas("mypackage.Bar")
	}

	@Test def void undoEditorChangesAndClose() {
		createFile('/mypackage/Foo.java',
			'''
				package mypackage;
				
				public class Foo {
				
					public void foo() {
					}
				
				}
			''')
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					public void bar() {
					}
				
				}
			''')
		reset

		val fooEditor = '/mypackage/Foo.java'.reconcile("foo", "foo2")
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		val barEditor = '/mypackage/Bar.java'.reconcile("bar", "bar2")
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		fooEditor.reconcile("foo2", "foo")
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		fooEditor.close
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		barEditor.save
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreDeltas("mypackage.Bar")
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		confirmDeltas
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreDeltas("mypackage.Bar")
	}

	@Test def void undoEditorChangesAndSave() {
		createFile('/mypackage/Foo.java',
			'''
				package mypackage;
				
				public class Foo {
				
					public void foo() {
					}
				
				}
			''')
		createFile('/mypackage/Bar.java',
			'''
				package mypackage;
				
				public class Bar {
				
					public void bar() {
					}
				
				}
			''')
		reset

		val fooEditor = '/mypackage/Foo.java'.reconcile("foo", "foo2")
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		val barEditor = '/mypackage/Bar.java'.reconcile("bar", "bar2")
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		fooEditor.reconcile("foo2", "foo")
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		fooEditor.save
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreDeltas("mypackage.Foo")
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		confirmDeltas
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		barEditor.save
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreDeltas("mypackage.Bar")
		queuedBuildData.andRemovePendingDeltas.assertThereAreNotDeltas

		confirmDeltas
		queuedBuildDataContribution.unconfirmedDeltas.assertThereAreNotDeltas
		queuedBuildData.andRemovePendingDeltas.assertThereAreDeltas("mypackage.Bar")
	}

}
