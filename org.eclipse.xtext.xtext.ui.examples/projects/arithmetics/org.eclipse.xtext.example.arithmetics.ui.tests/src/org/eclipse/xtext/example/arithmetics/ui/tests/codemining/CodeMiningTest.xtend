/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.tests.codemining

import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractCodeMiningTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(ArithmeticsUiInjectorProvider)
class CodeMiningTest extends AbstractCodeMiningTest {

	@Test def evaluation_value_is_presented_as_code_mining() {
		'''
			module volume

			def cubeVolume(l): boxVolume(l,l,l);
			def boxVolume(l,w,h): l*w*h;

			cubeVolume(10);
			cubeVolume(2);
			boxVolume(1,3,5);
		'''.testCodeMining('''
			module volume

			def cubeVolume(l): boxVolume(l,l,l);
			def boxVolume(l,w,h): l*w*h;

			cubeVolume(10) = 1000;
			cubeVolume(2) = 8;
			boxVolume(1,3,5) = 15;
		''')
	}
}
