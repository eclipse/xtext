/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug429376Test  extends AbstractXtendCompilerTest {
	
	@Test def void test_01() {
		assertCompilesTo('''
			class C {
				def <T> T m(Object o) {
					val enumClazz = o as Class<? extends Enum>
					Enum.valueOf(enumClazz, '') as T
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public <T extends Object> T m(final Object o) {
			    T _xblockexpression = null;
			    {
			      final Class<? extends Enum> enumClazz = ((Class<? extends Enum>) o);
			      Enum _valueOf = Enum.valueOf(enumClazz, "");
			      _xblockexpression = ((T) _valueOf);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
}