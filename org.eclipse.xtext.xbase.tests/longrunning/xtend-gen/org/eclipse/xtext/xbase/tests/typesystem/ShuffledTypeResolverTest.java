/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractBatchTypeResolverTest;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseShufflingInjectorProvider;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.junit.runner.RunWith;

/**
 * A test that triggers the computation of argument types in reverse order.
 * Furthermore it will shuffle the order of branches in if and switch expressions.
 * @author Sebastian Zarnekow
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseShufflingInjectorProvider.class)
@SuppressWarnings("all")
public class ShuffledTypeResolverTest extends AbstractBatchTypeResolverTest {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Override
  public IBatchTypeResolver getTypeResolver() {
    return this.typeResolver;
  }
}
