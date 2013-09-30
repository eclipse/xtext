/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.builder

import org.eclipse.core.runtime.NullProgressMonitor
import org.junit.Test

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class TypesChangingQueuedBuildDataTest extends AbstractQueuedBuildDataTest {

	@Test def void createPrimaryType() {
		assertThereAreDeltas(
			[ |
				'Bar.java'.create("public class Bar {}")
			], "Bar")
	}

	@Test def void createPrimaryType2() {
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.create(
					'''
						package mypackage;
						
						public class Bar {
						
						}
					''')
			], "mypackage.Bar")
	}

	@Test def void createPrimaryAndSecondaryType() {
		assertThereAreDeltas(
			[ |
				'Bar.java'.create(
					'''
						public class Bar {}
						
						class Foo {}
					''')
			], "Foo", "Bar")
	}

	@Test def void createPrimaryAndSecondaryType2() {
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.create(
					'''
						package mypackage;
						
						public class Bar {
						
						}
						
						class Foo {
						
						}
					''')
			], "mypackage.Foo", "mypackage.Bar")
	}

	@Test def void createPrimaryAndNestedTypes() {
		assertThereAreDeltas(
			[ |
				'Bar.java'.create(
					'''
						public class Bar {
						
							public class Foo {

								public class Foo3 {
								}

							}
						
							public static class Foo2 {}
						
						}
					''')
			], "Bar$Foo$Foo3", "Bar$Foo", "Bar$Foo2", "Bar")
	}

	@Test def void createPrimaryAndNestedTypes2() {
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.create(
					'''
						package mypackage;
						
						public class Bar {
						
							public class Foo {

								public class Foo3 {
								}

							}
						
							public static class Foo2 {}
						
						}
					''')
			], "mypackage.Bar$Foo$Foo3", "mypackage.Bar$Foo", "mypackage.Bar$Foo2", "mypackage.Bar")
	}

	@Test def void deletePrimaryType() {
		'Bar.java'.create("public class Bar {}")
		assertThereAreDeltas(
			[ |
				'Bar.java'.delete
			], "Bar")
	}

	@Test def void deletePrimaryType2() {
		'/mypackage/Bar.java'.create(
			'''
				package mypackage;
				
				public class Bar {
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.delete
			], "mypackage.Bar")
	}

	@Test def void deletePrimaryAndSecondaryType() {
		'Bar.java'.create(
			'''
				public class Bar {}
				
				class Foo {}
			''')
		assertThereAreDeltas(
			[ |
				'Bar.java'.delete
			], "Bar", "Foo")
	}

	@Test def void deletePrimaryAndSecondaryType2() {
		'/mypackage/Bar.java'.create(
			'''
				package mypackage;
				
				public class Bar {
				
				}
				
				class Foo {
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.delete
			], "mypackage.Bar", "mypackage.Foo")
	}

	@Test def void deletePrimaryAndNestedTypes() {
		'Bar.java'.create(
			'''
				public class Bar {
				
					public class Foo {

						public class Foo3 {
						}

					}
				
					public static class Foo2 {}
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'Bar.java'.delete
			], "Bar", "Bar$Foo2", "Bar$Foo", "Bar$Foo$Foo3")
	}

	@Test def void deletePrimaryAndNestedTypes2() {
		'/mypackage/Bar.java'.create(
			'''
				package mypackage;
				
				public class Bar {
				
					public class Foo {

						public class Foo3 {
						}

					}
				
					public static class Foo2 {}
				
				}
			''')
		assertThereAreDeltas(
			[ |
				'/mypackage/Bar.java'.delete
			], "mypackage.Bar", "mypackage.Bar$Foo$Foo3", "mypackage.Bar$Foo2", "mypackage.Bar$Foo")
	}

	def create(String fileName, String content) {
		waitForPostChangeEvent[ |
			fileName.createFile(content)
		]
		fileName
	}

	def delete(String fileName) {
		waitForPostChangeEvent[ |
			fileName.file.delete(true, new NullProgressMonitor)
		]
	}

}
