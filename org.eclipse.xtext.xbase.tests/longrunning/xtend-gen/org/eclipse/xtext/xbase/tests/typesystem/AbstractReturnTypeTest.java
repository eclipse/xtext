/**
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeResolverTest;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractReturnTypeTest<Reference extends Object> extends AbstractTypeResolverTest<Reference> {
  @Test
  @Override
  public void testReturnExpression_01() throws Exception {
    this.resolvesTo("return \'foo\'", "String");
  }
  
  @Test
  @Override
  public void testReturnExpression_02() throws Exception {
    this.resolvesTo("return try { if (true) \'foo\' else \'bar\' } finally { String::valueOf(\'zonk\') }", "String");
  }
  
  @Test
  @Override
  public void testReturnExpression_03() throws Exception {
    this.resolvesTo("{ val c = [ int i | return i ] c.apply(1) return null }", "null");
  }
  
  @Test
  @Override
  public void testReturnExpression_04() throws Exception {
    this.resolvesTo("{ val c = [ int i | i ] c.apply(1) return null }", "null");
  }
  
  @Test
  @Override
  public void testReturnExpression_06() throws Exception {
    this.resolvesTo("{ var closure = [| return \'literal\'] return closure.apply }", "String");
  }
  
  @Test
  @Override
  public void testReturnExpression_08() throws Exception {
    this.resolvesTo("return [| return \'literal\'].apply", "String");
  }
  
  @Test
  @Override
  public void testReturnExpression_10() throws Exception {
    this.resolvesTo("return if (true) while(false) (\'foo\'+\'bar\').length", "null");
  }
  
  @Test
  @Override
  public void testBooleanLiteral_02() throws Exception {
    this.resolvesTo("return true", "boolean");
  }
  
  @Test
  @Override
  public void testIfExpression_03() throws Exception {
    this.resolvesTo("if (true) return \'foo\'", "String");
  }
  
  @Test
  @Override
  public void testIfExpression_04() throws Exception {
    this.resolvesTo("if (true) return \'\' else new StringBuilder", "Serializable & CharSequence");
  }
  
  @Test
  @Override
  public void testIfExpression_17() throws Exception {
    this.resolvesTo("if (true) return 1", "int");
  }
  
  @Test
  @Override
  public void testIfExpression_19() throws Exception {
    this.resolvesTo("if (true) return else null", "void");
  }
  
  @Test
  @Override
  public void testIfExpression_23() throws Exception {
    this.resolvesTo("{ val x = if (true) return 1 x }", "Integer");
  }
  
  @Test
  @Override
  public void testIfExpression_24() throws Exception {
    this.resolvesTo("{ val x = if (true) return; x }", "void");
  }
  
  @Test
  @Override
  public void testIfExpression_25() throws Exception {
    this.resolvesTo("{ val x = if (true) return else null x }", "void");
  }
  
  @Test
  @Override
  public void testIfExpression_28() throws Exception {
    this.resolvesTo("if (true) return \'\' else 1", "Comparable<?> & Serializable");
  }
  
  @Test
  @Override
  public void testSwitchExpression_1() throws Exception {
    this.resolvesTo("switch true { case true : return \'s\' default: null}", "String");
  }
  
  @Test
  @Override
  public void testSwitchExpression_2() throws Exception {
    this.resolvesTo("switch null {\n\t\t  Object : return null \n\t\t}", "null");
  }
  
  @Test
  @Override
  public void testForExpression_05() throws Exception {
    this.resolvesTo("for(String x : new java.util.ArrayList<String>()) return x.length", "Integer");
    this.resolvesTo("for(String x : newArrayList(\'foo\')) return x.length", "Integer");
    this.resolvesTo("for(String x : <String>newArrayList()) return x.length", "Integer");
  }
  
  @Test
  @Override
  public void testForExpression_06() throws Exception {
    this.resolvesTo("for(x : new java.util.ArrayList<String>()) return x.length", "Integer");
    this.resolvesTo("for(x : <String>newArrayList()) return x.length", "Integer");
    this.resolvesTo("for(x : newArrayList(\'foo\')) return x.length", "Integer");
  }
  
  @Test
  @Override
  public void testForExpression_07() throws Exception {
    this.resolvesTo("for(String x : null as String[]) return x.length", "Integer");
  }
  
  @Test
  @Override
  public void testForExpression_08() throws Exception {
    this.resolvesTo("for(x : null as String[]) return x.length", "Integer");
  }
  
  @Test
  public void testForExpression_10() throws Exception {
    this.resolvesTo("{ for(x : null as String[]) return x.length 1 }", "int");
  }
  
  @Test
  public void testForExpression_11() throws Exception {
    this.resolvesTo("for(x : null as String[]) if (true) return 1", "Integer");
  }
  
  @Test
  public void testForExpression_12() throws Exception {
    this.resolvesTo("for(x : null as String[]) if (true) return 1 else return 2", "Integer");
  }
  
  @Test
  @Override
  public void testWhileExpression_02() throws Exception {
    this.resolvesTo("while(true) return 1", "Integer");
  }
  
  @Test
  public void testWhileExpression_03() throws Exception {
    this.resolvesTo("while(if (true) return 1 else false) \'\'.length", "Integer");
  }
  
  @Test
  public void testWhileExpression_04() throws Exception {
    this.resolvesTo("while(null instanceof String) return \'\'", "String");
  }
  
  @Test
  public void testWhileExpression_05() throws Exception {
    this.resolvesTo("{ while(null instanceof String) return \'\' return \'\' }", "String");
  }
  
  @Test
  public void testWhileExpression_EarlyExitWithSwitchCase() throws Exception {
    this.resolvesTo("while(true) {\n\t\t\tswitch \"test\" {\n\t\t\t\tcase \"foo\" : return \"result\"\n\t\t\t}\n\t\t}", "String");
  }
  
  @Test
  public void testWhileExpression_EarlyExitWithSwitchDefault() throws Exception {
    this.resolvesTo("while(true) {\n\t\t\tswitch \"test\" {\n\t\t\t\tcase \"foo\" : {}\n\t\t\t\tdefault : return \"result\"\n\t\t\t}\n\t\t}", "String");
  }
  
  @Test
  public void testWhileExpression_EarlyExitWithSwitchAndIf() throws Exception {
    this.resolvesTo("while(true) {\n\t\t\tif(false) {\n\t\t\t\tswitch \"test\" {\n\t\t\t\t\tcase \"foo\" : if(false) return \"result\"\n\t\t\t\t}\n\t\t\t}\n\t\t}", "String");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_08() throws Exception {
    this.resolvesTo("try return \'foo\' catch (Exception e) return \'bar\'", "String");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_09() throws Exception {
    this.resolvesTo("try return \'foo\' catch (Exception e) return \'bar\' catch(RuntimeException e) return \'baz\'", "String");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_10() throws Exception {
    this.resolvesTo("try return \'foo\' catch (Exception e) return \'bar\' catch(RuntimeException e) return \'baz\' finally true", "String");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_11() throws Exception {
    this.resolvesTo("try { return \'literal\' as Object as Boolean } catch(ClassCastException e) return \'caught\'", "Serializable & Comparable<?>");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_12() throws Exception {
    this.resolvesTo("try { return \'literal\' as Object as Boolean } catch(ClassCastException e) {return \'caught\'}", "Serializable & Comparable<?>");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_13() throws Exception {
    this.resolvesTo("try return \'literal\' as Object as Boolean\n\t\t  catch(NullPointerException e) return \'second thing is thrown\'\t\t  \n\t\t  catch(ClassCastException e) throw new NullPointerException()\n\t\t", "Serializable & Comparable<?>");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_14() throws Exception {
    this.resolvesTo("try return \'literal\' as Object as Boolean\n\t\t  catch(ClassCastException e) throw new NullPointerException()\n\t\t  catch(NullPointerException e) return \'dont catch subsequent exceptions\'", "Serializable & Comparable<?>");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_15() throws Exception {
    this.resolvesTo("try return \'literal\' as Object as Boolean\n\t\t  catch(ClassCastException e) return null as Number\n\t\t  catch(NullPointerException e) return \'dont catch subsequent exceptions\'", "Serializable");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_19() throws Exception {
    this.resolvesTo("try { return \'literal\' as Object as Boolean } catch(ClassCastException e) \'caught\'", "Serializable & Comparable<?>");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_20() throws Exception {
    this.resolvesTo("try { return \'literal\' as Object as Boolean } catch(ClassCastException e) {\'caught\'}", "Serializable & Comparable<?>");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_21() throws Exception {
    this.resolvesTo("try return \'literal\' as Object as Boolean\n\t\t  catch(NullPointerException e) \'second thing is thrown\'\t\t  \n\t\t  catch(ClassCastException e) throw new NullPointerException()\n\t\t", "Serializable & Comparable<?>");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_22() throws Exception {
    this.resolvesTo("try return \'literal\' as Object as Boolean\n\t\t  catch(ClassCastException e) throw new NullPointerException()\n\t\t  catch(NullPointerException e) \'dont catch subsequent exceptions\'", "Serializable & Comparable<?>");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_25() throws Exception {
    this.resolvesTo("try true catch (Exception e) return \'bar\' catch(RuntimeException e) return \'baz\'", "Serializable & Comparable<?>");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_26() throws Exception {
    this.resolvesTo("try \'foo\' catch (Exception e) \'bar\' catch(RuntimeException e) return true finally true", "Serializable & Comparable<?>");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_27() throws Exception {
    this.resolvesTo("try { \'literal\' as Object as Boolean } catch(ClassCastException e) return \'caught\'", "Serializable & Comparable<?>");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_28() throws Exception {
    this.resolvesTo("try { \'literal\' as Object as Boolean } catch(ClassCastException e) {return \'caught\'}", "Serializable & Comparable<?>");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_29() throws Exception {
    this.resolvesTo("try \'literal\' as Object as Boolean\n\t\t  catch(NullPointerException e) return \'second thing is thrown\'\t\t  \n\t\t  catch(ClassCastException e) throw new NullPointerException()\n\t\t", "Serializable & Comparable<?>");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_30() throws Exception {
    this.resolvesTo("try \'literal\' as Object as Boolean\n\t\t  catch(ClassCastException e) throw new NullPointerException()\n\t\t  catch(NullPointerException e) return \'dont catch subsequent exceptions\'", "Serializable & Comparable<?>");
  }
  
  @Test
  @Override
  public void testTryCatchFinallyExpression_31() throws Exception {
    this.resolvesTo("try \'literal\' as Object as Boolean\n\t\t  catch(ClassCastException e) return null as Number\n\t\t  catch(NullPointerException e) return \'dont catch subsequent exceptions\'", "Serializable");
  }
  
  @Test
  public void testThrowExpressionAfterLoop_01() throws Exception {
    this.resolvesTo("{\n\t\t\twhile(true) \'\'.toString\n\t\t\tthrow new RuntimeException()\n\t\t}", "void");
  }
  
  @Test
  public void testThrowExpressionAfterLoop_02() throws Exception {
    this.resolvesTo("{\n\t\t\twhile(true) return 1\n\t\t\tthrow new RuntimeException()\n\t\t}", "int");
  }
  
  @Test
  public void testThrowExpressionAfterLoop_03() throws Exception {
    this.resolvesTo("{\n\t\t\twhile(true) if (true) return 1 else \'\'\n\t\t\tthrow new RuntimeException()\n\t\t}", "int");
  }
  
  @Test
  @Override
  public void testBlockExpression_09() throws Exception {
    this.resolvesTo("{val Object x = if (false) return; x }", "void");
  }
  
  @Test
  @Override
  public void testBlockExpression_10() throws Exception {
    this.resolvesTo("{ ( if (true) {val Object x = if (false) return; x } ) }", "void");
  }
  
  @Test
  @Override
  public void testBlockExpression_11() throws Exception {
    this.resolvesTo("{ ( if (true) {val Object x = if (false) return; x } ) {val Object x = if (false) return; x } }", "void");
  }
  
  @Test
  @Override
  public void testBlockExpression_12() throws Exception {
    this.resolvesTo("{ ( if (true) if (true) return else null ) { if (true) return else null } }", "void");
  }
}
