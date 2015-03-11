/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.java8.compiler;

import java.util.Collections;
import org.eclipse.xtend.core.tests.compiler.CompilerTest;
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
@InjectWith(Java8RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class Java8CompilerTest1 extends CompilerTest {
  @Test
  public void testJava8Reduce() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def test() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val intArray = #[1, 2, 3, 4, 5, 6, 7, 8]");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("intArray.stream.reduce[Integer.sum($0, $1)].get");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.invokeAndExpect2(Integer.valueOf(36), _builder.toString(), "test");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJava8StreamExample1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("static class Person {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("enum Sex {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("MALE, FEMALE");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("String name");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("int age");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("Sex gender");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("def test() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val roster = #[");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Carl\'     age=19 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Carla\'    age=37 gender=Person.Sex.FEMALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Rocco\'    age=12 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Frederic\' age=50 gender=Person.Sex.MALE]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("roster.stream");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append(".filter[gender == Person.Sex.MALE]");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append(".mapToInt[age]");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append(".average");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append(".getAsDouble");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.invokeAndExpect2(Double.valueOf(27.0), _builder.toString(), "test");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJava8StreamExample2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("static class Person {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("enum Sex {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("MALE, FEMALE");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("String name");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("int age");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("Sex gender");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("static class Averager implements java.util.function.IntConsumer {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("int total = 0");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("int count = 0");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def average() {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("if (count > 0) (total as double)/count else 0");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("override accept(int i) {");
      _builder.newLine();
      _builder.append("    \t");
      _builder.append("total += i");
      _builder.newLine();
      _builder.append("    \t");
      _builder.append("count++");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("def combine(Averager other) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("total += other.total");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("count += other.count");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("def test() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val roster = #[");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Carl\'     age=19 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Carla\'    age=37 gender=Person.Sex.FEMALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Rocco\'    age=12 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Frederic\' age=50 gender=Person.Sex.MALE]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val averageCollect = roster.stream");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append(".filter[gender == Person.Sex.MALE]");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append(".map[age]");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append(".collect([new Averager], [av, i | av.accept(i)], [av1, av2 | av1.combine(av2)])");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("averageCollect.average");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.invokeAndExpect2(Double.valueOf(27.0), _builder.toString(), "test");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJava8StreamExample3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("static class Person {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("enum Sex {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("MALE, FEMALE");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("String name");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("int age");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("Sex gender");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("def test() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val roster = #[");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Carl\'     age=19 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Carla\'    age=37 gender=Person.Sex.FEMALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Rocco\'    age=12 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Frederic\' age=50 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Brunhild\' age=96 gender=Person.Sex.FEMALE]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val namesByGender = roster.stream");
      _builder.newLine();
      _builder.append("        ");
      _builder.append(".collect(java.util.stream.Collectors.groupingBy(");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("[Person p | p.gender],");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("java.util.stream.Collectors.mapping(");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("[Person p | p.name],");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("java.util.stream.Collectors.toList)))");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("namesByGender.get(Person.Sex.FEMALE)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.invokeAndExpect2(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Carla", "Brunhild")), _builder.toString(), "test");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJava8StreamExample3b() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("static class Person {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("enum Sex {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("MALE, FEMALE");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("String name");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("int age");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("Sex gender");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("def test() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val roster = #[");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Carl\'     age=19 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Carla\'    age=37 gender=Person.Sex.FEMALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Rocco\'    age=12 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Frederic\' age=50 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Brunhild\' age=96 gender=Person.Sex.FEMALE]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val namesByGender = roster.stream");
      _builder.newLine();
      _builder.append("        ");
      _builder.append(".collect(java.util.stream.Collectors.groupingBy(");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("[gender],");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("java.util.stream.Collectors.mapping(");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("[name],");
      _builder.newLine();
      _builder.append("                    ");
      _builder.append("java.util.stream.Collectors.toList)))");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("namesByGender.get(Person.Sex.FEMALE)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.invokeAndExpect2(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Carla", "Brunhild")), _builder.toString(), "test");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJava8StreamExample4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("static class Person {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("enum Sex {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("MALE, FEMALE");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("String name");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("int age");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("Sex gender");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("def test() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val roster = #[");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Carl\'     age=19 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Carla\'    age=37 gender=Person.Sex.FEMALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Rocco\'    age=12 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Frederic\' age=50 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Brunhild\' age=96 gender=Person.Sex.FEMALE]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val totalAgeByGender = roster.stream");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append(".collect(java.util.stream.Collectors.groupingBy(");
      _builder.newLine();
      _builder.append("\t                ");
      _builder.append("[Person p | p.gender],");
      _builder.newLine();
      _builder.append("\t                ");
      _builder.append("java.util.stream.Collectors.reducing(");
      _builder.newLine();
      _builder.append("\t                    ");
      _builder.append("0,");
      _builder.newLine();
      _builder.append("\t                    ");
      _builder.append("[Person p | p.age],");
      _builder.newLine();
      _builder.append("\t                    ");
      _builder.append("[$0, $1 | Integer.sum($0, $1)])))");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("totalAgeByGender.get(Person.Sex.FEMALE)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.invokeAndExpect2(Integer.valueOf(133), _builder.toString(), "test");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJava8StreamExample4b() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("static class Person {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("enum Sex {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("MALE, FEMALE");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("String name");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("int age");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("Sex gender");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("def test() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val roster = #[");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Carl\'     age=19 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Carla\'    age=37 gender=Person.Sex.FEMALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Rocco\'    age=12 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Frederic\' age=50 gender=Person.Sex.MALE],");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Person => [name=\'Brunhild\' age=96 gender=Person.Sex.FEMALE]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val totalAgeByGender = roster.stream");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append(".collect(java.util.stream.Collectors.groupingBy(");
      _builder.newLine();
      _builder.append("\t                ");
      _builder.append("[gender],");
      _builder.newLine();
      _builder.append("\t                ");
      _builder.append("java.util.stream.Collectors.reducing(");
      _builder.newLine();
      _builder.append("\t                    ");
      _builder.append("0,");
      _builder.newLine();
      _builder.append("\t                    ");
      _builder.append("[age],");
      _builder.newLine();
      _builder.append("\t                    ");
      _builder.append("[$0 + $1])))");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("totalAgeByGender.get(Person.Sex.FEMALE)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.invokeAndExpect2(Integer.valueOf(133), _builder.toString(), "test");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJava8CalculatorExample() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface IntegerMath {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def int operation(int a, int b)   ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("def operateBinary(int a, int b, IntegerMath op) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op.operation(a, b)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("def test() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val IntegerMath addition = [$0 + $1]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val IntegerMath subtraction = [$0 - $1]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("40.operateBinary(2, addition).operateBinary(10, subtraction)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.invokeAndExpect2(Integer.valueOf(32), _builder.toString(), "test");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
