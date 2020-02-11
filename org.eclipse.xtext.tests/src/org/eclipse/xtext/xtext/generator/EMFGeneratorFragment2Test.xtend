/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.junit.Test
import org.junit.Assert

import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2

/**
 */
class EMFGeneratorFragment2Test {

	val extension EMFGeneratorFragment2 = new EMFGeneratorFragment2

	@Test def void testTrimMultiLineString() {
		assertTrim('foo','''
			/*foo*/
		''')
		assertTrim('foo','''
			/* 
			 * foo*/
		''')
		assertTrim('foo','''
			/* 
			 * 
			 * foo
			 */
		''')
		assertTrim('''
			multi
			foo''',
		'''
			/* 
			 * multi
			 * foo
			 * 
			 */
		''')
		assertTrim('foo','''
			/* foo */
		''')
		assertTrim('foo','foo')
		assertTrim('''
		Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.
		This program and the accompanying materials are made available under the
		terms of the Eclipse Public License 2.0 which is available at
		http://www.eclipse.org/legal/epl-2.0.
		
		SPDX-License-Identifier: EPL-2.0''',
		'''
		/**
		 * Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.
		 * This program and the accompanying materials are made available under the
		 * terms of the Eclipse Public License 2.0 which is available at
		 * http://www.eclipse.org/legal/epl-2.0.
		 * 
		 * SPDX-License-Identifier: EPL-2.0
		 */''')
		assertTrim('''
		Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.
		This program and the accompanying materials are made available under the
		terms of the Eclipse Public License 2.0 which is available at
		http://www.eclipse.org/legal/epl-2.0.
		
		SPDX-License-Identifier: EPL-2.0''',
		'''
		/*******************************************************************************
		 * Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.
		 * This program and the accompanying materials are made available under the
		 * terms of the Eclipse Public License 2.0 which is available at
		 * http://www.eclipse.org/legal/epl-2.0.
		 * 
		 * SPDX-License-Identifier: EPL-2.0
		 *******************************************************************************/''')
		assertTrim('''
		Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.
		This program and the accompanying materials are made available under the
		terms of the Eclipse Public License 2.0 which is available at
		http://www.eclipse.org/legal/epl-2.0.
		
		SPDX-License-Identifier: EPL-2.0''',
		'''
		/*******************************************************************************
		 * Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.
		 * This program and the accompanying materials are made available under the
		 * terms of the Eclipse Public License 2.0 which is available at
		 * http://www.eclipse.org/legal/epl-2.0.
		 *
		 * SPDX-License-Identifier: EPL-2.0
		 *******************************************************************************/''')
	}

	private def void assertTrim(String expected, String original) {
		Assert.assertEquals(expected, original.trimMultiLineComment)
	}
}