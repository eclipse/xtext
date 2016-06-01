/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class StringLiteralTest extends AbstractXbaseTestCase {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  public void resolvesStringLiteralsTo(final String expression, final String... types) {
    final String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
    final List<XStringLiteral> featureCalls = this.findLiterals(expressionWithQualifiedNames);
    boolean _isEmpty = featureCalls.isEmpty();
    Assert.assertFalse(_isEmpty);
    int _size = ((List<String>)Conversions.doWrapArray(types)).size();
    int _size_1 = featureCalls.size();
    Assert.assertEquals(_size, _size_1);
    XStringLiteral _head = IterableExtensions.<XStringLiteral>head(featureCalls);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(_head);
    final Procedure2<XStringLiteral, Integer> _function = (XStringLiteral featureCall, Integer index) -> {
      final LightweightTypeReference type = resolvedTypes.getActualType(featureCall);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("failed for literal at ");
      _builder.append(index, "");
      Object _get = types[(index).intValue()];
      String _simpleName = type.getSimpleName();
      Assert.assertEquals(_builder.toString(), _get, _simpleName);
    };
    IterableExtensions.<XStringLiteral>forEach(featureCalls, _function);
  }
  
  protected List<XStringLiteral> findLiterals(final CharSequence expression) {
    try {
      final XExpression xExpression = this.expression(expression, false);
      TreeIterator<EObject> _eAll = EcoreUtil2.eAll(xExpression);
      Iterator<XStringLiteral> _filter = Iterators.<XStringLiteral>filter(_eAll, XStringLiteral.class);
      final List<XStringLiteral> featureCalls = IteratorExtensions.<XStringLiteral>toList(_filter);
      final Function1<XStringLiteral, Integer> _function = (XStringLiteral it) -> {
        ICompositeNode _findActualNodeFor = NodeModelUtils.findActualNodeFor(it);
        return Integer.valueOf(_findActualNodeFor.getOffset());
      };
      return IterableExtensions.<XStringLiteral, Integer>sortBy(featureCalls, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoExpectation_01() throws Exception {
    this.resolvesStringLiteralsTo("\'\'", "String");
  }
  
  @Test
  public void testNoExpectation_02() throws Exception {
    this.resolvesStringLiteralsTo("\'1\'", "String");
  }
  
  @Test
  public void testNoExpectation_03() throws Exception {
    this.resolvesStringLiteralsTo("\'11\'", "String");
  }
  
  @Test
  public void testMemberCall_01() throws Exception {
    this.resolvesStringLiteralsTo("\'1\'.toString", "String");
  }
  
  @Test
  @Ignore("Improve typing according to expectation")
  public void testMemberCall_02() throws Exception {
    this.resolvesStringLiteralsTo("\'1\'.charValue", "char");
  }
  
  @Test
  @Ignore("Improve typing according to expectation")
  public void testMemberCall_03() throws Exception {
    this.resolvesStringLiteralsTo("\'1\'.compareTo(null as Character)", "char");
  }
  
  @Test
  @Ignore("Improve typing according to expectation")
  public void testBinaryOperation_01() throws Exception {
    this.resolvesStringLiteralsTo("{ var char c = \'1\' \'1\' == c", "char", "char");
  }
  
  @Test
  public void testBinaryOperation_02() throws Exception {
    this.resolvesStringLiteralsTo("{ var c = \'1\' \'1\' == c", "String", "String");
  }
  
  @Test
  public void testBinaryOperation_03() throws Exception {
    this.resolvesStringLiteralsTo("{ var String c = \'1\' \'1\' == c", "String", "String");
  }
  
  @Test
  public void testCharExpectation_01() throws Exception {
    this.resolvesStringLiteralsTo("{ var char c = \'\' }", "String");
  }
  
  @Test
  public void testCharExpectation_02() throws Exception {
    this.resolvesStringLiteralsTo("{ var char c = \'1\' }", "char");
  }
  
  @Test
  public void testCharExpectation_03() throws Exception {
    this.resolvesStringLiteralsTo("{ var char c = \'11\' }", "String");
  }
  
  @Test
  public void testCharExpectation_04() throws Exception {
    this.resolvesStringLiteralsTo("Character::valueOf(\'\')", "String");
  }
  
  @Test
  public void testCharExpectation_05() throws Exception {
    this.resolvesStringLiteralsTo("Character::valueOf(\'1\')", "char");
  }
  
  @Test
  public void testCharExpectation_06() throws Exception {
    this.resolvesStringLiteralsTo("Character::valueOf(\'11\')", "String");
  }
  
  @Test
  public void testCharacterExpectation_01() throws Exception {
    this.resolvesStringLiteralsTo("{ var Character c = \'\' }", "String");
  }
  
  @Test
  public void testCharacterExpectation_02() throws Exception {
    this.resolvesStringLiteralsTo("{ var Character c = \'1\' }", "Character");
  }
  
  @Test
  public void testCharacterExpectation_03() throws Exception {
    this.resolvesStringLiteralsTo("{ var Character c = \'11\' }", "String");
  }
  
  @Test
  public void testAmbiguousExpectation_01() throws Exception {
    this.resolvesStringLiteralsTo("String::valueOf(\'\')", "String");
  }
  
  @Test
  public void testAmbiguousExpectation_02() throws Exception {
    this.resolvesStringLiteralsTo("String::valueOf(\'1\')", "String");
  }
  
  @Test
  public void testAmbiguousExpectation_03() throws Exception {
    this.resolvesStringLiteralsTo("String::valueOf(\'11\')", "String");
  }
  
  @Test
  public void testCastToChar_01() throws Exception {
    this.resolvesStringLiteralsTo("\'a\' as Character", "String");
  }
}
