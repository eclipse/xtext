/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.xbase.junit.typesystem.Oven;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseWithLogicalContainerInjectorProvider;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(XbaseWithLogicalContainerInjectorProvider.class)
@SuppressWarnings("all")
public class ErrorWithLogicalContainerTest extends AbstractXbaseTestCase {
  @Inject
  @Extension
  private Oven _oven;
  
  @Test
  public void testErrorModel_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return s");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("retus.toUpperCase");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
}
