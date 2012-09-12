package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.List;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractClosureTypeTest2;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ClosureTypeTest3 extends AbstractClosureTypeTest2 {
  @Test
  public void testScenario_1_1_a_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval iter = null as Iterable<StringBuffer>\n\t\t\tval testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>\n\t\t\tval Iterable<String> res = testData.method_1_1_a(iter) []\n\t\t}", "(List<StringBuffer>)=>List<String>");
    this.withEquivalents(_resolvesClosuresTo, "ListFunction1<StringBuffer, String>");
  }
  
  @Test
  public void testScenario_1_1_a_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>\n\t\t\ttestData.method_1_1_a(null) []\n\t\t}", "(List<StringBuffer>)=>List<String>");
    this.withEquivalents(_resolvesClosuresTo, "ListFunction1<StringBuffer, String>");
  }
  
  @Test
  public void testScenario_1_1_b_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval iter = null as Iterable<StringBuffer>\n\t\t\tval testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>\n\t\t\tval Iterable<String> res = testData.method_1_1_b(iter) []\n\t\t}", "(List<StringBuffer>)=>List<String>");
    this.withEquivalents(_resolvesClosuresTo, "ListFunction1<StringBuffer, String>");
  }
  
  @Test
  public void testScenario_1_1_b_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>\n\t\t\ttestData.method_1_1_b(null) []\n\t\t}", "(List<StringBuffer>)=>List<String>");
    this.withEquivalents(_resolvesClosuresTo, "ListFunction1<StringBuffer, String>");
  }
  
  @Test
  public void testScenario_1_1_c_01() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval iter = null as Iterable<StringBuffer>\n\t\t\tval testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>\n\t\t\tval Iterable<String> res = testData.method_1_1_c(iter) []\n\t\t}", "(List<StringBuffer>)=>List<String>");
    this.withEquivalents(_resolvesClosuresTo, "ListFunction1<StringBuffer, String>");
  }
  
  @Test
  public void testScenario_1_1_c_02() throws Exception {
    List<Object> _resolvesClosuresTo = this.resolvesClosuresTo("{\n\t\t\tval testData = null as ClosureTypeResolutionTestData3<StringBuffer, String>\n\t\t\ttestData.method_1_1_c(null) []\n\t\t}", "(List<StringBuffer>)=>List<String>");
    this.withEquivalents(_resolvesClosuresTo, "ListFunction1<StringBuffer, String>");
  }
}
