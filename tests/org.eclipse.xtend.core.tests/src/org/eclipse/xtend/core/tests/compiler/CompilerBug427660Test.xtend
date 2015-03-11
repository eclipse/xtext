/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug427660Test extends AbstractXtendCompilerTest {
	
	@Test def void testBug_427660_01() {
		assertCompilesTo('''
			class C {
				def enumValue(Class<?> clazz, String value) {
					if(clazz.enum)
						Enum.valueOf(clazz as Class<Enum>, value)
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public Enum enumValue(final Class<?> clazz, final String value) {
			    Enum _xifexpression = null;
			    boolean _isEnum = clazz.isEnum();
			    if (_isEnum) {
			      _xifexpression = Enum.<Enum>valueOf(((Class<Enum>) clazz), value);
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	
	@Test def void testBug_427660_02() {
		assertCompilesTo('''
			class C {
				def enumValue(Class<Enum> clazz, String value) {
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public Object enumValue(final Class<Enum> clazz, final String value) {
			    return null;
			  }
			}
		''')
	}
		
}