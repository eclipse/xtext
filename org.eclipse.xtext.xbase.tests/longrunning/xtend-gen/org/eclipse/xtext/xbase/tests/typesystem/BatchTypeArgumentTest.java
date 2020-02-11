/**
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeArgumentTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class BatchTypeArgumentTest extends AbstractTypeArgumentTest {
  @Inject
  private IBatchTypeResolver batchTypeResolver;
  
  public IBatchTypeResolver getTypeResolver() {
    return this.batchTypeResolver;
  }
  
  private IResolvedTypes resolvedTypes;
  
  @Override
  protected void resolveTypes(final XExpression expression) {
    this.resolvedTypes = this.getTypeResolver().resolveTypes(expression);
  }
  
  @After
  public void discardResolvedTypes() {
    this.resolvedTypes = null;
  }
  
  @Override
  protected void hasTypeArguments(final XExpression expression, final String... typeArguments) {
    final List<LightweightTypeReference> actualTypeArguments = this.resolvedTypes.getActualTypeArguments(expression);
    Assert.assertEquals(((List<String>)Conversions.doWrapArray(typeArguments)).size(), actualTypeArguments.size());
    final Procedure2<String, Integer> _function = (String typeArgument, Integer i) -> {
      StringConcatenation _builder = new StringConcatenation();
      String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(typeArguments)), ", ");
      _builder.append(_join);
      _builder.append(" vs ");
      final Function1<LightweightTypeReference, String> _function_1 = (LightweightTypeReference it) -> {
        return it.getSimpleName();
      };
      String _join_1 = IterableExtensions.join(ListExtensions.<LightweightTypeReference, String>map(actualTypeArguments, _function_1), ", ");
      _builder.append(_join_1);
      Assert.assertEquals(_builder.toString(), typeArgument, actualTypeArguments.get((i).intValue()).getSimpleName());
    };
    IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(typeArguments)), _function);
  }
  
  @Test
  @Ignore("TODO Fix me")
  @Override
  public void testRawType_01() throws Exception {
    super.testRawType_01();
  }
  
  @Test
  @Ignore("TODO Fix me")
  @Override
  public void testRawType_02() throws Exception {
    super.testRawType_02();
  }
  
  @Test
  @Ignore("TODO Fix me")
  @Override
  public void testRawType_05() throws Exception {
    super.testRawType_05();
  }
}
