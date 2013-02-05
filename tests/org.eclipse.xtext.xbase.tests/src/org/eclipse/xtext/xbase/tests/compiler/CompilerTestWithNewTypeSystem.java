/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompilerTestWithNewTypeSystem extends CompilerTest {
	
	@Override
	@Test
	public void testSwitchTypeGuards_01() throws Exception {
		assertCompilesTo(
				"String _switchResult = null;\n" + 
				"final CharSequence x = ((CharSequence) \"foo\");\n" + 
				"boolean _matched = false;\n" + 
				"if (!_matched) {\n" + 
				"  if (x instanceof String) {\n" + 
				"    final String _string = (String)x;\n" + 
				"    _matched=true;\n" + 
				"    String _substring = _string.substring(3);\n" + 
				"    String _plus = (_substring + _string);\n" + 
				"    _switchResult = _plus;\n" + 
				"  }\n" + 
				"}\n" + 
				"if (!_matched) {\n" + 
				"  if (x instanceof Comparable) {\n" + 
				"    final Comparable _comparable = (Comparable)x;\n" + 
				"    _matched=true;\n" + 
				"    int _compareTo = ((Comparable)_comparable).compareTo(\"jho\");\n" + 
				"    String _plus = (\"\" + Integer.valueOf(_compareTo));\n" + 
				// diff is here: CharSequence.toString instead of Comparable.toString
				"    String _string = ((CharSequence)_comparable).toString();\n" + 
				"    String _plus_1 = (_plus + _string);\n" + 
				"    _switchResult = _plus_1;\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;"
				, 
				"switch x : 'foo' as CharSequence {" +
				"  String : x.substring(3) + x " +
				"  Comparable : '' + x.compareTo('jho') + x.toString" +
				"}");
	}
	
}
