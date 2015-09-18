/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.java8.javaconverter;

import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.javaconverter.JavaConverterTest;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
@InjectWith(Java8RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class Java8ConverterTest extends JavaConverterTest {
  @Test
  public void testDiamondOperator() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def List<?> foo() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var List<String> x=new ArrayList() ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return new ArrayList() ");
    _builder.newLine();
    _builder.append("}");
    String _string = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public List<?> foo() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("List<String> x = new ArrayList<>();");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return new ArrayList<>();");
    _builder_1.newLine();
    _builder_1.append("}");
    String _xtendClassBodyDeclr = this.toXtendClassBodyDeclr(_builder_1);
    Assert.assertEquals(_string, _xtendClassBodyDeclr);
  }
  
  @Test
  public void testJava7() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package int thousand=1_000");
    _builder.newLine();
    _builder.append("package int million=1_000_000");
    _builder.newLine();
    _builder.append("package double d1=1000_000.0d");
    _builder.newLine();
    _builder.append("// long a1 = 0b1000_1010_0010_1101_1010_0001_0100_0101L;");
    _builder.newLine();
    _builder.append("package Map<String, List<String>> trades=new TreeMap()");
    _builder.newLine();
    _builder.append("def void processTrade(String t) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("switch (t) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case \"NEW\",");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case \"EXECUTE\",");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case \"PENDING\",");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("default :{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try (var FileInputStream in=new FileInputStream(\"java7.txt\")){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(in.read()) ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new IllegalAccessException()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (IOException e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e.printStackTrace() ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (IllegalAccessException e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e.printStackTrace() ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    String _string = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("int thousand = 1_000;");
    _builder_1.newLine();
    _builder_1.append("int million = 1_000_000;");
    _builder_1.newLine();
    _builder_1.append("double d1 = 1000_000.0d;");
    _builder_1.newLine();
    _builder_1.append("// long a1 = 0b1000_1010_0010_1101_1010_0001_0100_0101L;");
    _builder_1.newLine();
    _builder_1.append("Map<String, List<String>> trades = new TreeMap<>();");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("public void processTrade(String t) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("switch (t) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case \"NEW\":");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case \"EXECUTE\":");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case \"PENDING\":");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("try (FileInputStream in = new FileInputStream(\"java7.txt\")) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("System.out.println(in.read());");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("throw new IllegalAccessException();");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("} catch (IOException | IllegalAccessException e) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("e.printStackTrace();");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    String _xtendClassBodyDeclr = this.toXtendClassBodyDeclr(_builder_1);
    Assert.assertEquals(_string, _xtendClassBodyDeclr);
  }
  
  @Test
  public void testDefaultMethod() throws Exception {
    JavaConverterTest.DUMP = true;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public interface XtendInterfaze {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public default String foo() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return \"- Hi, I\\\'m a default impl\";");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public abstract String baar();");
    _builder.newLine();
    _builder.append("}");
    final XtendInterface clazz = this.toValidXtendInterface(_builder.toString());
    Assert.assertNotNull(clazz);
  }
  
  @Test
  public void testSimpleLambda() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.awt.EventQueue;");
    _builder.newLine();
    _builder.append("import java.util.concurrent.Callable;");
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("public void javaLambda(){");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("EventQueue.invokeLater(() -> System.out.println(\"invoked later\"));");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("Callable<Runnable> callable = () -> () -> ");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("System.out.println(\"callable says hello\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("static Runnable getRunnable(String s)");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return () -> System.out.println(s);");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendClass clazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(clazz);
  }
  
  @Test
  public void testSimpleLambda_2() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def void javaLambda() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EventQueue.invokeLater([System.out.println(\"invoked later\")]) ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var Callable<Runnable> callable=[[System.out.println(\"callable says hello\")]] ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("def static package Runnable getRunnable(String s) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return [System.out.println(s)] ");
    _builder.newLine();
    _builder.append("}");
    String _string = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public void javaLambda(){");
    _builder_1.newLine();
    _builder_1.append("\t ");
    _builder_1.append("EventQueue.invokeLater(() -> System.out.println(\"invoked later\"));");
    _builder_1.newLine();
    _builder_1.append("\t ");
    _builder_1.append("Callable<Runnable> callable = () -> () -> ");
    _builder_1.newLine();
    _builder_1.append("\t          ");
    _builder_1.append("System.out.println(\"callable says hello\");");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("static Runnable getRunnable(String s)");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return () -> System.out.println(s);");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("}");
    _builder_1.newLine();
    String _xtendClassBodyDeclr = this.toXtendClassBodyDeclr(_builder_1);
    Assert.assertEquals(_string, _xtendClassBodyDeclr);
  }
}
