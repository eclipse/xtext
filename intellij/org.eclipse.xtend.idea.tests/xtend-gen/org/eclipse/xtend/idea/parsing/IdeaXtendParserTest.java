/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.parsing;

import org.eclipse.xtend.core.tests.parsing.ParserTest;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;

/**
 * @author kosyakov - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class IdeaXtendParserTest extends ParserTest {
  private final ModelChecker modelChecker;
  
  public XtendFile file(final String string, final boolean validate) {
    return this.modelChecker.<XtendFile>checkModel(string, validate);
  }
  
  public IdeaXtendParserTest(final ModelChecker modelChecker) {
    super();
    this.modelChecker = modelChecker;
  }
}
