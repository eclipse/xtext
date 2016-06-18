/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractBatchTypeResolverTest;
import org.eclipse.xtext.xbase.tests.typesystem.EagerBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

/**
 * This tests ensures that the type calculation does not depend on some lazy evaluation.
 * Therefore all argument types for all overloaded variants are computed eagerly.
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class IsolationTest extends AbstractBatchTypeResolverTest {
  @Inject
  private EagerBatchTypeResolver typeResolver;
  
  @Override
  public IBatchTypeResolver getTypeResolver() {
    return this.typeResolver;
  }
}
