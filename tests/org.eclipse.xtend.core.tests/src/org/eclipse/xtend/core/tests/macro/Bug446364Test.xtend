/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.macro

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.junit.Test

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
class Bug446364Test extends AbstractActiveAnnotationTest {
	
	@Test def void testRenameMethods() {
		'''
			@org.eclipse.xtend.core.tests.macro.Bug446364('rename')
			class C {
				def String test() {
					"code"
				}
				def create new StringBuilder createMethod(String p) {
					append(p)
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.HashMap;
			import org.eclipse.xtend.core.tests.macro.Bug446364;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@Bug446364("rename")
			@SuppressWarnings("all")
			public class C {
			  public String prefix_test() {
			    return "code";
			  }
			  
			  public StringBuilder prefix_createMethod(final String p) {
			    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(p);
			    final StringBuilder _result;
			    synchronized (_createCache_createMethod) {
			      if (_createCache_createMethod.containsKey(_cacheKey)) {
			        return _createCache_createMethod.get(_cacheKey);
			      }
			      StringBuilder _stringBuilder = new StringBuilder();
			      _result = _stringBuilder;
			      _createCache_createMethod.put(_cacheKey, _result);
			    }
			    prefix__init_createMethod(_result, p);
			    return _result;
			  }
			  
			  private final HashMap<ArrayList<?>, StringBuilder> _createCache_createMethod = CollectionLiterals.newHashMap();
			  
			  private void prefix__init_createMethod(final StringBuilder it, final String p) {
			    it.append(p);
			  }
			}
		''')
	}
	
	@Test def void testChangeBody() {
		// Changing the body of a create method does not make any sense, and it leads to type computation problems
		// as seen below, but we want to make sure the AA processing completes without errors.
		'''
			@org.eclipse.xtend.core.tests.macro.Bug446364('changeBody')
			class C {
				def String test() {
					"code"
				}
				def create new StringBuilder createMethod(String p) {
					append(p)
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.HashMap;
			import org.eclipse.xtend.core.tests.macro.Bug446364;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@Bug446364("changeBody")
			@SuppressWarnings("all")
			public class C {
			  public String test() {
			    return null;
			  }
			  
			  public StringBuilder createMethod(final String p) {
			    return null;
			  }
			  
			  private final HashMap<ArrayList<?>, StringBuilder> _createCache_createMethod = CollectionLiterals.newHashMap();
			  
			  private void _init_createMethod(final Object/* type is 'null' */ it, final String p) {
			    return null;
			  }
			}
		''')
	}
	
}


@Active(Bug446364Processor)
annotation Bug446364 {
	String value
}
class Bug446364Processor extends AbstractClassProcessor {
	
	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		switch (annotatedClass.annotations.head.getStringValue('value')) {
			case 'rename': {
				for (it : annotatedClass.declaredMethods) {
					simpleName = 'prefix_' + simpleName
				}
			}
			case 'changeBody': {
				for (it : annotatedClass.declaredMethods) {
					body = '''return null;'''
				}
			}
		}
	}
	
}