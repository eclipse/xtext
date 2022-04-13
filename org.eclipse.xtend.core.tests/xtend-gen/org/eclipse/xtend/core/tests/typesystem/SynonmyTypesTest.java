/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashSet;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class SynonmyTypesTest extends AbstractTestingTypeReferenceOwner {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;

  @Inject
  @Extension
  private SynonymTypesProvider _synonymTypesProvider;

  public void hasSynonyms(final String type, final String... expectedSynonyms) {
    this.hasSynonyms(Pair.<String, String>of(type, null), expectedSynonyms);
  }

  public void hasSynonyms(final Pair<String, String> typeAndTypeParams, final String... expectedSynonyms) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def ");
      {
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(typeAndTypeParams.getValue());
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder.append("<");
          String _value = typeAndTypeParams.getValue();
          _builder.append(_value);
          _builder.append("> ");
        }
      }
      _builder.append("void method(");
      String _key = typeAndTypeParams.getKey();
      _builder.append(_key);
      _builder.append(" p) {}");
      final String signature = _builder.toString();
      final XtendFunction function = this.function(signature.toString());
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      LightweightTypeReference _xifexpression = null;
      String _key_1 = typeAndTypeParams.getKey();
      boolean _tripleNotEquals = (_key_1 != null);
      if (_tripleNotEquals) {
        _xifexpression = this.toLightweightTypeReference(IterableExtensions.<JvmFormalParameter>head(operation.getParameters()).getParameterType());
      } else {
        _xifexpression = this.getOwner().newAnyTypeReference();
      }
      final LightweightTypeReference primary = _xifexpression;
      final HashSet<String> actualSynonyms = CollectionLiterals.<String>newHashSet();
      final SynonymTypesProvider.Acceptor _function = new SynonymTypesProvider.Acceptor() {
        @Override
        protected boolean accept(final LightweightTypeReference type, final int conformance) {
          return actualSynonyms.add(type.getSimpleName());
        }
      };
      this._synonymTypesProvider.collectSynonymTypes(primary, _function);
      Assert.assertEquals(actualSynonyms.toString(), expectedSynonyms.length, actualSynonyms.size());
      Assert.assertTrue(actualSynonyms.toString(), actualSynonyms.containsAll(((Collection<?>)Conversions.doWrapArray(expectedSynonyms))));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInt() {
    this.hasSynonyms("int", "Integer");
    this.hasSynonyms("Integer", "int");
  }

  @Test
  public void testShort() {
    this.hasSynonyms("short", "Short");
    this.hasSynonyms("Short", "short");
  }

  @Test
  public void testDouble() {
    this.hasSynonyms("double", "Double");
    this.hasSynonyms("Double", "double");
  }

  @Test
  public void testBoolean() {
    this.hasSynonyms("boolean", "Boolean");
    this.hasSynonyms("Boolean", "boolean");
  }

  @Test
  public void testVoid() {
    this.hasSynonyms("void");
    this.hasSynonyms("Void");
  }

  @Test
  public void testListToArray() {
    this.hasSynonyms("char[]", "List<Character>");
    this.hasSynonyms("java.util.List<String>", "String[]");
  }

  @Test
  public void testIterableToArray_01() {
    this.hasSynonyms("Iterable<? extends Integer>", "Integer[]", "int[]");
  }

  @Test
  public void testArrayListToArray_02() {
    this.hasSynonyms("java.util.ArrayList<? extends Integer>", "Integer[]", "int[]");
  }

  @Test
  public void testListWithUpperBound_01() {
    this.hasSynonyms("java.util.List<? super Integer>", "Object[]");
  }

  @Test
  public void testListWithTypeParameter_01() {
    this.hasSynonyms(Pair.<String, String>of("java.util.List<T>", "T extends String"), "T[]");
    this.hasSynonyms(Pair.<String, String>of("java.util.List<? extends T>", "T extends String"), "T[]");
  }

  @Test
  public void testListWithTypeParameter_02() {
    this.hasSynonyms(Pair.<String, String>of("java.util.List<T>", "T extends Integer"), "T[]", "int[]");
    this.hasSynonyms(Pair.<String, String>of("java.util.List<? extends T>", "T extends Integer"), "T[]", "int[]");
  }

  @Test
  public void testArrayWithTypeParameter_01() {
    this.hasSynonyms(Pair.<String, String>of("T[]", "T extends String"), "List<T>");
    this.hasSynonyms(Pair.<String, String>of("T[][]", "T extends String"), "List<T[]>");
  }

  @Test
  public void testArrayWithTypeParameter_02() {
    this.hasSynonyms(Pair.<String, String>of("T[]", "T extends Integer"), "List<T>");
    this.hasSynonyms(Pair.<String, String>of("T[][]", "T extends Integer"), "List<T[]>");
  }

  @Test
  public void testTypeParameter_01() {
    this.hasSynonyms(Pair.<String, String>of("T", "V, T extends Iterable<V>"), "V[]");
  }

  @Test
  public void testTypeParameter_02() {
    this.hasSynonyms(Pair.<String, String>of("T", "T extends Iterable<Integer>"), "Integer[]", "int[]");
  }

  @Test
  public void testTypeParameter_03() {
    this.hasSynonyms(Pair.<String, String>of("T", "V extends Integer, T extends Iterable<V>"), "V[]", "int[]");
  }
}
