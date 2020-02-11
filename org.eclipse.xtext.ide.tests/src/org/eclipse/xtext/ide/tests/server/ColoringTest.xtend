/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.lsp4j.services.LanguageClientExtensions
import org.junit.Test

/**
 * Test for checking the coloring service for the test language.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@Deprecated
class ColoringTest extends AbstractTestLangLanguageServerTest {

	static val MODEL = '''
		type A {
			int a 
			op foo() { } 
			op foo(a: A): string { }
		}
		type B {
			int b
			op foo(a: A, b: B): int { }
		}
		type C {
			int c
			op foo(a: A, b: B, c: C): void { }
		}
		type Test {
			boolean t
			op main() { }
		}
	''';
	
	@Test
	def void checkColoring() {
		initialize();
		val file = root.toPath.resolve('''MyModel.«fileExtension»''').toFile;
		val uri = file.toURI.toString;
		uri.open(MODEL);
		
		// Map the file URI to the file name.
		val expectation = coloringParams.entrySet.toMap([it.key.substring(it.key.lastIndexOf('/') + 1)], [it.value]).toExpectation;
		assertEquals('''
		«file.name» ->
		 * [[1, 5] .. [1, 6]] -> [1]
		 * [[2, 4] .. [2, 7]] -> [1]
		 * [[3, 4] .. [3, 7]] -> [1]
		 * [[6, 5] .. [6, 6]] -> [1]
		 * [[7, 4] .. [7, 7]] -> [1]
		 * [[10, 5] .. [10, 6]] -> [1]
		 * [[11, 4] .. [11, 7]] -> [1]
		 * [[14, 9] .. [14, 10]] -> [1]
		 * [[15, 4] .. [15, 8]] -> [1]''', expectation);
	}

	override protected getLanguageClientClass() {
		return LanguageClientExtensions;
	}

}
