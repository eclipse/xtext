/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.fragments;

import org.eclipse.xtext.parser.fragments.AbstractFragmentsPlainParsingTest;
import org.eclipse.xtext.parser.fragments.FragmentTestLanguageExStandaloneSetup;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class FragmentExsPlainParsingTest extends AbstractFragmentsPlainParsingTest {
  @Override
  public void setUp() throws Exception {
    super.setUp();
    FragmentTestLanguageExStandaloneSetup _fragmentTestLanguageExStandaloneSetup = new FragmentTestLanguageExStandaloneSetup();
    this.with(_fragmentTestLanguageExStandaloneSetup);
  }
}
