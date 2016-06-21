/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
      IBatchTypeResolver _typeResolver = this.getTypeResolver();
      final IResolvedTypes resolvedTypes = _typeResolver.resolveTypes(xExpression);
      final List<JvmIdentifiableElement> identifiables = this.findIdentifiables(xExpression);
      boolean _isEmpty = identifiables.isEmpty();
      Assert.assertFalse(_isEmpty);
      int _size = ((List<String>)Conversions.doWrapArray(types)).size();
      int _size_1 = identifiables.size();
      Assert.assertEquals(_size, _size_1);
      final Procedure2<JvmIdentifiableElement, Integer> _function = (JvmIdentifiableElement identifiable, Integer index) -> {
        final LightweightTypeReference type = resolvedTypes.getActualType(identifiable);
        Assert.assertNotNull(type);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("failed for identifiable at ");
        _builder.append(index, "");
        Object _get = types[(index).intValue()];
        String _simpleName = type.getSimpleName();
        Assert.assertEquals(_builder.toString(), _get, _simpleName);
      };
      IterableExtensions.<JvmIdentifiableElement>forEach(identifiables, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
