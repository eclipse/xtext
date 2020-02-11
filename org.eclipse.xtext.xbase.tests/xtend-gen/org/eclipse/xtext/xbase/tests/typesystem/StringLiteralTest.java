/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
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
    Assert.assertFalse(featureCalls.isEmpty());
    Assert.assertEquals(((List<String>)Conversions.doWrapArray(types)).size(), featureCalls.size());
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(IterableExtensions.<XStringLiteral>head(featureCalls));
    final Procedure2<XStringLiteral, Integer> _function = (XStringLiteral featureCall, Integer index) -> {
      final LightweightTypeReference type = resolvedTypes.getActualType(featureCall);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("failed for literal at ");
      _builder.append(index);
      Assert.assertEquals(_builder.toString(), types[(index).intValue()], type.getSimpleName());
    };
    IterableExtensions.<XStringLiteral>forEach(featureCalls, _function);
  }
  
  protected List<XStringLiteral> findLiterals(final CharSequence expression) {
    try {
      final XExpression xExpression = this.expression(expression, false);
      final List<XStringLiteral> featureCalls = IteratorExtensions.<XStringLiteral>toList(Iterators.<XStringLiteral>filter(EcoreUtil2.eAll(xExpression), XStringLiteral.class));
      final Function1<XStringLiteral, Integer> _function = (XStringLiteral it) -> {
        return Integer.valueOf(NodeModelUtils.findActualNodeFor(it).getOffset());
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
