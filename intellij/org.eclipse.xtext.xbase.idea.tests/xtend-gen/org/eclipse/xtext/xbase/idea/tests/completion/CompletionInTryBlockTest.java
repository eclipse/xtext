/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.tests.completion;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.idea.tests.completion.AbstractXbaseCompletionTest;

@SuppressWarnings("all")
public class CompletionInTryBlockTest extends AbstractXbaseCompletionTest {
  protected String getPrefix() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String getSuffix() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
