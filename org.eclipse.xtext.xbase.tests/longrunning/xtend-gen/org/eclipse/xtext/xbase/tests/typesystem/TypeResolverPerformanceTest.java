/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.concurrent.TimeUnit;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.tests.typesystem.BatchTypeResolverTest;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 * @author Sebastian Zarnekow
 */
@Ignore
@SuppressWarnings("all")
public class TypeResolverPerformanceTest extends BatchTypeResolverTest {
  @Rule
  public final Timeout timeout = new Timeout(100, TimeUnit.MILLISECONDS);
  
  @Override
  public LightweightTypeReference resolvesTo(final String expression, final String type) {
    try {
      final XExpression xExpression = this.expression(expression.replace("$$", "org::eclipse::xtext::xbase::lib::"), false);
      final IResolvedTypes resolvedTypes = this.getTypeResolver().resolveTypes(xExpression);
      final LightweightTypeReference lightweight = resolvedTypes.getActualType(xExpression);
      Assert.assertEquals(type, lightweight.getSimpleName());
      return lightweight;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
