/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.tests.parsing;

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.parser.XbaseParserTest;
import org.junit.Ignore;

@FinalFieldsConstructor
@Ignore("Only here as a delegate")
@SuppressWarnings("all")
public class IdeaXbaseParserTest extends XbaseParserTest {
  private final ModelChecker expresssionChecker;
  
  @Override
  protected XExpression expression(final CharSequence string) throws Exception {
    String _string = string.toString();
    return this.expresssionChecker.<XExpression>checkModel(_string, false);
  }
  
  @Override
  protected XExpression expression(final CharSequence string, final boolean resolve) throws Exception {
    String _string = string.toString();
    return this.expresssionChecker.<XExpression>checkModel(_string, resolve);
  }
  
  public IdeaXbaseParserTest(final ModelChecker expresssionChecker) {
    super();
    this.expresssionChecker = expresssionChecker;
  }
}
