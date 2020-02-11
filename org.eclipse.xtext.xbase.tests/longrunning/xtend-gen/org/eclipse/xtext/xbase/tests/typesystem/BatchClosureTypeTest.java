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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractClosureTypeTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class BatchClosureTypeTest extends AbstractClosureTypeTest {
  @Inject
  private IBatchTypeResolver batchTypeResolver;
  
  public IBatchTypeResolver getTypeResolver() {
    return this.batchTypeResolver;
  }
  
  @Rule
  public ErrorCollector collector = new ErrorCollector();
  
  @Override
  public List<Object> resolvesClosuresTo(final String expression, final String... types) {
    final List<XClosure> closures = this.findClosures(expression);
    Assert.assertFalse(closures.isEmpty());
    Assert.assertEquals(((List<String>)Conversions.doWrapArray(types)).size(), closures.size());
    final IResolvedTypes resolvedTypes = this.getTypeResolver().resolveTypes(IterableExtensions.<XClosure>head(closures));
    final ArrayList<Object> result = CollectionLiterals.<Object>newArrayList();
    final Procedure2<XClosure, Integer> _function = (XClosure closure, Integer index) -> {
      final LightweightTypeReference closureType = resolvedTypes.getActualType(closure);
      final Callable<Object> _function_1 = () -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("failed for closure at ");
        _builder.append(index);
        _builder.append(": ");
        _builder.append(closureType);
        Assert.assertTrue(_builder.toString(), (closureType instanceof FunctionTypeReference));
        return null;
      };
      this.collector.<Object>checkSucceeds(_function_1);
      final Callable<Object> _function_2 = () -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("failed for closure at ");
        _builder.append(index);
        Assert.assertEquals(_builder.toString(), types[(index).intValue()], closureType.getSimpleName());
        return null;
      };
      this.collector.<Object>checkSucceeds(_function_2);
      result.add(closureType);
    };
    IterableExtensions.<XClosure>forEach(closures, _function);
    return result;
  }
  
  @Override
  public void withEquivalents(final List<Object> references, final String... types) {
    final Procedure2<Object, Integer> _function = (Object reference, Integer index) -> {
      final Callable<Object> _function_1 = () -> {
        Assert.assertTrue((reference instanceof FunctionTypeReference));
        return null;
      };
      this.collector.<Object>checkSucceeds(_function_1);
      final Callable<Object> _function_2 = () -> {
        Assert.assertEquals(types[(index).intValue()], this.getEquivalent(((FunctionTypeReference) reference)));
        return null;
      };
      this.collector.<Object>checkSucceeds(_function_2);
    };
    IterableExtensions.<Object>forEach(references, _function);
  }
  
  public String getEquivalent(final ParameterizedTypeReference type) {
    boolean _isEmpty = type.getTypeArguments().isEmpty();
    if (_isEmpty) {
      return type.getType().getSimpleName();
    }
    StringConcatenation _builder = new StringConcatenation();
    String _simpleName = type.getType().getSimpleName();
    _builder.append(_simpleName);
    _builder.append("<");
    final Function1<LightweightTypeReference, CharSequence> _function = (LightweightTypeReference it) -> {
      return it.getSimpleName();
    };
    String _join = IterableExtensions.<LightweightTypeReference>join(type.getTypeArguments(), ", ", _function);
    _builder.append(_join);
    _builder.append(">");
    return _builder.toString();
  }
}
