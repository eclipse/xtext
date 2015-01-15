/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractExpectationTest;
import org.eclipse.xtext.xbase.tests.typesystem.ExpectationTestingTypeComputer;
import org.eclipse.xtext.xbase.tests.typesystem.RecomputingReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class RecordingRecomputingReentrantTypeResolver extends RecomputingReentrantTypeResolver {
  @Override
  public RootResolvedTypes createResolvedTypes(final CancelIndicator monitor) {
    RootResolvedTypes _xblockexpression = null;
    {
      ITypeComputer _typeComputer = this.getTypeComputer();
      final ExpectationTestingTypeComputer recorder = ((ExpectationTestingTypeComputer) _typeComputer);
      final AbstractExpectationTest test = recorder.getTest();
      test.clearData();
      _xblockexpression = super.createResolvedTypes(monitor);
    }
    return _xblockexpression;
  }
}
