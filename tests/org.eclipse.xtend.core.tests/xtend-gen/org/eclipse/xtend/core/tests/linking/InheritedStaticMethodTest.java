/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.linking;

import org.eclipse.xtend.core.tests.linking.AbstractOverloadedStaticMethodTest;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Use a copy of org.junit.Assert as test data
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class InheritedStaticMethodTest extends AbstractOverloadedStaticMethodTest {
  protected String inMethodBody(final String invocation) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import overloading.CopiedAssert");
    _builder.newLine();
    _builder.append("class C extends CopiedAssert {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(invocation, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
