/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractClosureTypeTest;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow
 */
@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseNewTypeSystemInjectorProvider.class)
@SuppressWarnings("all")
public class BatchClosureTypeTest extends AbstractClosureTypeTest {
  @Inject
  private IBatchTypeResolver batchTypeResolver;
  
  public IBatchTypeResolver getTypeResolver() {
    return this.batchTypeResolver;
  }
  
  @Rule
  public ErrorCollector collector = new Function0<ErrorCollector>() {
    public ErrorCollector apply() {
      ErrorCollector _errorCollector = new ErrorCollector();
      return _errorCollector;
    }
  }.apply();
  
  public List<Object> resolvesClosuresTo(final String expression, final String... types) {
    final List<XClosure> closures = this.findClosures(expression);
    boolean _isEmpty = closures.isEmpty();
    Assert.assertFalse(_isEmpty);
    int _size = ((List<String>)Conversions.doWrapArray(types)).size();
    int _size_1 = closures.size();
    Assert.assertEquals(_size, _size_1);
    IBatchTypeResolver _typeResolver = this.getTypeResolver();
    XClosure _head = IterableExtensions.<XClosure>head(closures);
    final IResolvedTypes resolvedTypes = _typeResolver.resolveTypes(_head);
    final ArrayList<Object> result = CollectionLiterals.<Object>newArrayList();
    final Procedure2<XClosure,Integer> _function = new Procedure2<XClosure,Integer>() {
        public void apply(final XClosure closure, final Integer index) {
          final LightweightTypeReference closureType = resolvedTypes.getActualType(closure);
          final Function0<Object> _function = new Function0<Object>() {
              public Object apply() {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("failed for closure at ");
                _builder.append(index, "");
                _builder.append(": ");
                _builder.append(closureType, "");
                Assert.assertTrue(_builder.toString(), (closureType instanceof FunctionTypeReference));
                return null;
              }
            };
          BatchClosureTypeTest.this.collector.checkSucceeds(new Callable<Object>() {
              public Object call() {
                return _function.apply();
              }
          });
          final Function0<Object> _function_1 = new Function0<Object>() {
              public Object apply() {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("failed for closure at ");
                _builder.append(index, "");
                String _get = ((List<String>)Conversions.doWrapArray(types)).get((index).intValue());
                String _simpleName = closureType.getSimpleName();
                Assert.assertEquals(_builder.toString(), _get, _simpleName);
                return null;
              }
            };
          BatchClosureTypeTest.this.collector.checkSucceeds(new Callable<Object>() {
              public Object call() {
                return _function_1.apply();
              }
          });
          result.add(closureType);
        }
      };
    IterableExtensions.<XClosure>forEach(closures, _function);
    return result;
  }
  
  public void withEquivalents(final List<Object> references, final String... types) {
    final Procedure2<Object,Integer> _function = new Procedure2<Object,Integer>() {
        public void apply(final Object reference, final Integer index) {
          final Function0<Object> _function = new Function0<Object>() {
              public Object apply() {
                Assert.assertTrue((reference instanceof FunctionTypeReference));
                return null;
              }
            };
          BatchClosureTypeTest.this.collector.checkSucceeds(new Callable<Object>() {
              public Object call() {
                return _function.apply();
              }
          });
          final Function0<Object> _function_1 = new Function0<Object>() {
              public Object apply() {
                String _get = ((List<String>)Conversions.doWrapArray(types)).get((index).intValue());
                String _equivalent = BatchClosureTypeTest.this.getEquivalent(((FunctionTypeReference) reference));
                Assert.assertEquals(_get, _equivalent);
                return null;
              }
            };
          BatchClosureTypeTest.this.collector.checkSucceeds(new Callable<Object>() {
              public Object call() {
                return _function_1.apply();
              }
          });
        }
      };
    IterableExtensions.<Object>forEach(references, _function);
  }
  
  public String getEquivalent(final ParameterizedTypeReference type) {
    List<LightweightTypeReference> _typeArguments = type.getTypeArguments();
    boolean _isEmpty = _typeArguments.isEmpty();
    if (_isEmpty) {
      JvmType _type = type.getType();
      return _type.getSimpleName();
    }
    StringConcatenation _builder = new StringConcatenation();
    JvmType _type_1 = type.getType();
    String _simpleName = _type_1.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append("<");
    List<LightweightTypeReference> _typeArguments_1 = type.getTypeArguments();
    final Function1<LightweightTypeReference,String> _function = new Function1<LightweightTypeReference,String>() {
        public String apply(final LightweightTypeReference it) {
          String _simpleName = it.getSimpleName();
          return _simpleName;
        }
      };
    String _join = IterableExtensions.<LightweightTypeReference>join(_typeArguments_1, ", ", _function);
    _builder.append(_join, "");
    _builder.append(">");
    return _builder.toString();
  }
  
  @Ignore(value = "TODO the assertion should hold")
  @Test
  public void testClosure_51() throws Exception {
    super.testClosure_51();
  }
  
  @Ignore(value = "TODO the assertion should hold")
  @Test
  public void testClosure_52() throws Exception {
    super.testClosure_52();
  }
}
