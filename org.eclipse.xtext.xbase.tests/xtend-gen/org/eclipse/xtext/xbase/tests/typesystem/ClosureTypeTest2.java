/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.tests.typesystem.AbstractClosureTypeTest2;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ClosureTypeTest2 extends AbstractClosureTypeTest2 {
  @Test
  public void testScenario_1_1_a_01() throws Exception {
    this.withEquivalents(this.resolvesClosuresTo("{\n\t\t\tval iter = null as Iterable<StringBuffer>\n\t\t\tval testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n\t\t\tval Iterable<String> res = testData.method_1_1_a(iter) []\n\t\t}", "(List<StringBuffer>)=>List<String>"), "ListFunction1<StringBuffer, String>");
  }
  
  @Test
  public void testScenario_1_1_a_02() throws Exception {
    this.withEquivalents(this.resolvesClosuresTo("{\n\t\t\tval iter = null as Iterable<StringBuffer>\n\t\t\tval testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n\t\t\ttestData.method_1_1_a(iter) []\n\t\t}", "(List<StringBuffer>)=>List<Object>"), "ListFunction1<StringBuffer, Object>");
  }
  
  @Test
  public void testScenario_1_1_a_03() throws Exception {
    this.withEquivalents(this.resolvesClosuresTo("{\n\t\t\tval testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n\t\t\ttestData.<String>method_1_1_a(iter) []\n\t\t}", "(List<StringBuffer>)=>List<String>"), "ListFunction1<StringBuffer, String>");
  }
  
  @Test
  public void testScenario_1_1_b_01() throws Exception {
    this.withEquivalents(this.resolvesClosuresTo("{\n\t\t\tval iter = null as Iterable<StringBuffer>\n\t\t\tval testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n\t\t\tval Iterable<String> res = testData.method_1_1_b(iter) [] // actually invalid since List<? extends OUT> is returned\n\t\t}", "(List<StringBuffer>)=>List<? extends String>"), "ListFunction1<StringBuffer, ? extends String>");
  }
  
  @Test
  public void testScenario_1_1_b_02() throws Exception {
    this.withEquivalents(this.resolvesClosuresTo("{\n\t\t\tval iter = null as Iterable<StringBuffer>\n\t\t\tval testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n\t\t\ttestData.method_1_1_b(iter) []\n\t\t}", "(List<StringBuffer>)=>List<Object>"), "ListFunction1<StringBuffer, Object>");
  }
  
  @Test
  public void testScenario_1_1_b_03() throws Exception {
    this.withEquivalents(this.resolvesClosuresTo("{\n\t\t\tval testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n\t\t\ttestData.<String>method_1_1_b(null) []\n\t\t}", "(List<StringBuffer>)=>List<String>"), "ListFunction1<StringBuffer, String>");
  }
  
  @Test
  public void testScenario_1_1_c_01() throws Exception {
    this.withEquivalents(this.resolvesClosuresTo("{\n\t\t\tval iter = null as Iterable<StringBuffer>\n\t\t\tval testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n\t\t\t// invalid but should infer String since Object would be invalid, too\n\t\t\tval Iterable<String> res = testData.method_1_1_c(iter) []\n\t\t}", "(List<StringBuffer>)=>List<String>"), "ListFunction1<StringBuffer, String>");
  }
  
  @Test
  public void testScenario_1_1_c_02() throws Exception {
    this.withEquivalents(this.resolvesClosuresTo("{\n\t\t\tval iter = null as Iterable<StringBuffer>\n\t\t\tval testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n\t\t\tval Iterable<? super String> res = testData.method_1_1_c(iter) []\n\t\t}", "(List<StringBuffer>)=>List<String>"), "ListFunction1<StringBuffer, String>");
  }
  
  @Test
  public void testScenario_1_1_c_03() throws Exception {
    this.withEquivalents(this.resolvesClosuresTo("{\n\t\t\tval iter = null as Iterable<StringBuffer>\n\t\t\tval testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n\t\t\ttestData.method_1_1_c(iter) []\n\t\t}", "(List<StringBuffer>)=>List<Object>"), "ListFunction1<StringBuffer, Object>");
  }
  
  @Test
  public void testScenario_1_1_c_04() throws Exception {
    this.withEquivalents(this.resolvesClosuresTo("{\n\t\t\tval testData = null as ClosureTypeResolutionTestData2<StringBuffer>\n\t\t\ttestData.<String>method_1_1_c(null) []\n\t\t}", "(List<StringBuffer>)=>List<String>"), "ListFunction1<StringBuffer, String>");
  }
}
