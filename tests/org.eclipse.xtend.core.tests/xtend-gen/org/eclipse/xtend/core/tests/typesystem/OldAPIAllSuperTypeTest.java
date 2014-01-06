/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.typesystem.AllSuperTypesTest;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class OldAPIAllSuperTypeTest extends AllSuperTypesTest {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private SuperTypeCollector superTypeCollector;
  
  public void assertSuperTypes(final Pair<String,String> type, final String... superTypes) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def ");
      {
        String _value = type.getValue();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_value);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder.append("<");
          String _value_1 = type.getValue();
          _builder.append(_value_1, "");
          _builder.append("> ");
        }
      }
      _builder.append("void method(");
      String _key = type.getKey();
      _builder.append(_key, "");
      _builder.append(" type) {}");
      final String signature = _builder.toString();
      String _string = signature.toString();
      final XtendFunction function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      EList<JvmFormalParameter> _parameters = operation.getParameters();
      JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(_parameters);
      final JvmTypeReference subtype = _head.getParameterType();
      final Set<JvmTypeReference> computedSuperTypes = this.superTypeCollector.collectSuperTypes(subtype);
      final Set<String> expectedSupertypesAsSet = IterableExtensions.<String>toSet(((Iterable<String>)Conversions.doWrapArray(superTypes)));
      final Function1<JvmTypeReference,String> _function = new Function1<JvmTypeReference,String>() {
        public String apply(final JvmTypeReference it) {
          return it.getSimpleName();
        }
      };
      Iterable<String> _map = IterableExtensions.<JvmTypeReference, String>map(computedSuperTypes, _function);
      final Set<String> actualSupertypesAsSet = IterableExtensions.<String>toSet(_map);
      Assert.assertEquals(expectedSupertypesAsSet, ((Object) actualSupertypesAsSet));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Ignore("Old API does not support this properly")
  @Test
  public void testRawCollection() {
    Assert.fail("Old API does not support this properly");
  }
  
  @Ignore("Old API does not support this properly")
  @Test
  public void testStringCollection() {
    Assert.fail("Old API does not support this properly");
  }
  
  @Ignore("Old API does not support this properly")
  @Test
  public void testRawList() {
    Assert.fail("Old API does not support this properly");
  }
  
  @Ignore("Old API does not support this properly")
  @Test
  public void testStringList() {
    Assert.fail("Old API does not support this properly");
  }
  
  @Ignore("Old API does not support this properly")
  @Test
  public void testStringArrayArrayList() {
    Assert.fail("Old API does not support this properly");
  }
}
