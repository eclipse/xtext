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
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractIdentifiableTypeTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class BatchIdentifiableTypeTest extends AbstractIdentifiableTypeTest {
  @Inject
  private IBatchTypeResolver batchTypeResolver;
  
  public IBatchTypeResolver getTypeResolver() {
    return this.batchTypeResolver;
  }
  
  @Override
  public void resolvesIdentifiablesTo(final String expression, final String... types) {
    try {
      final String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
      final XExpression xExpression = this.expression(expressionWithQualifiedNames, false);
      final IResolvedTypes resolvedTypes = this.getTypeResolver().resolveTypes(xExpression);
      final List<JvmIdentifiableElement> identifiables = this.findIdentifiables(xExpression);
      Assert.assertFalse(identifiables.isEmpty());
      Assert.assertEquals(((List<String>)Conversions.doWrapArray(types)).size(), identifiables.size());
      final Procedure2<JvmIdentifiableElement, Integer> _function = (JvmIdentifiableElement identifiable, Integer index) -> {
        final LightweightTypeReference type = resolvedTypes.getActualType(identifiable);
        Assert.assertNotNull(type);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("failed for identifiable at ");
        _builder.append(index);
        Assert.assertEquals(_builder.toString(), types[(index).intValue()], type.getSimpleName());
      };
      IterableExtensions.<JvmIdentifiableElement>forEach(identifiables, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
