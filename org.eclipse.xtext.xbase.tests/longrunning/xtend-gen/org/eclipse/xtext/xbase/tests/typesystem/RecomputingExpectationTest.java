/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractExpectationTest;
import org.eclipse.xtext.xbase.tests.typesystem.ExpectationTestingTypeComputer;
import org.eclipse.xtext.xbase.tests.typesystem.RecordingRecomputingReentrantTypeResolver;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class RecomputingExpectationTest extends AbstractExpectationTest {
  @Inject
  private ExpectationTestingTypeComputer typeComputer;
  
  @Inject
  private RecordingRecomputingReentrantTypeResolver resolver;
  
  @Override
  public ExpectationTestingTypeComputer getTypeComputer() {
    return this.typeComputer;
  }
  
  @Override
  public PublicReentrantTypeResolver getResolver() {
    return this.resolver;
  }
}
