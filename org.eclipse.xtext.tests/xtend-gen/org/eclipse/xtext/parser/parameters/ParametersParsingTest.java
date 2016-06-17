/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.parser.parameters;

import org.eclipse.xtext.parser.parameters.AbstractParametersParsingTest;
import org.eclipse.xtext.parser.parameters.ParametersTestLanguageStandaloneSetup;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ParametersParsingTest extends AbstractParametersParsingTest {
  @Override
  public void setUp() throws Exception {
    super.setUp();
    ParametersTestLanguageStandaloneSetup _parametersTestLanguageStandaloneSetup = new ParametersTestLanguageStandaloneSetup();
    this.with(_parametersTestLanguageStandaloneSetup);
  }
}
