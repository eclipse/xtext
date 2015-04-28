/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.navigation;

import com.google.common.base.Objects;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiParameter;
import com.intellij.psi.impl.DebugUtil;
import junit.framework.TestCase;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend.idea.navigation.NavigationTestData;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.psi.PsiEObjectIdentifier;
import org.eclipse.xtext.psi.PsiNamedEObject;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClass;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendNavigationTest extends LightXtendTest {
  public void testNavigateToParameter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Greeter {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void sayHello(String ");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t");
    _builder.append("name");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("println(na");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t");
    _builder.append("me)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<PsiParameter>testNavigateTo(
      "mypackage/Greeter.xtend", _builder.toString(), 
      PsiParameter.class);
  }
  
  public void testNavigateToClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "");
    _builder.append("Greeter");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String ... args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new ");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t");
    _builder.append("Greeter().sayHello(args.head)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void sayHello(String name) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(name)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<PsiMethod>testNavigateTo(
      "mypackage/Greeter.xtend", _builder.toString(), 
      PsiMethod.class);
  }
  
  public void testNavigateToClass_Extends() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "");
    _builder.append("Foo");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Bar extends ");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "");
    _builder.append("Foo {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.<JvmPsiClass>testNavigateTo(
      "mypackage/Foo.xtend", _builder.toString(), 
      JvmPsiClass.class);
  }
  
  public void testNavigateToClass_Implements() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface ");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "");
    _builder.append("Foo");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Bar implements ");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "");
    _builder.append("Foo {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.<JvmPsiClass>testNavigateTo(
      "mypackage/Foo.xtend", _builder.toString(), 
      JvmPsiClass.class);
  }
  
  public void testNavigateToClass_Throws() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "");
    _builder.append("MyException");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "");
    _builder.append(" extends Exception {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Client {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void someMethod() throws My");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t");
    _builder.append("Exception {}");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<JvmPsiClass>testNavigateTo(
      "mypackage/Exception.xtend", _builder.toString(), 
      JvmPsiClass.class);
  }
  
  public void testNavigateToClass_ExtendsBound() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "");
    _builder.append("Foo");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Bar<T extends Fo");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "");
    _builder.append("o> {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.<JvmPsiClass>testNavigateTo(
      "mypackage/Foo.xtend", _builder.toString(), 
      JvmPsiClass.class);
  }
  
  public void testNavigateToInnerClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static class ");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t");
    _builder.append("Bar");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t");
    _builder.append(" {}");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("static class Baz extends ");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t");
    _builder.append("Bar {}");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.<PsiClass>testNavigateTo(
      "mypackage/Foo.xtend", _builder.toString(), 
      PsiClass.class);
  }
  
  public void testNavigateToAnnonymousClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface Greeter {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void sayHello(String name)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String ... args) {");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("new Greeter() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("override sayHello(String name) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t\t\t");
    _builder.append("this.sayHello(name)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("new Greeter() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("override sayHello(String name) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("throw new UnsupportedOperationException(\"TODO: auto-generated method stub\")");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<PsiClass>testNavigateTo(
      "mypackage/Foo.xtend", _builder.toString(), 
      PsiClass.class);
  }
  
  public void testNavigateToAnnonymousClass2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface Greeter {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void sayHello(String name)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String ... args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Greeter() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("override sayHello(String name) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("throw new UnsupportedOperationException(\"TODO: auto-generated method stub\")");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("new Greeter() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("override sayHello(String name) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t\t\t");
    _builder.append("this.sayHello(name)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<PsiClass>testNavigateTo(
      "mypackage/Foo.xtend", _builder.toString(), 
      PsiClass.class);
  }
  
  public void testNavigateToAnnonymousClass3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface ");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "");
    _builder.append("Greeter");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("def void sayHello(String name)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String ... args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("acceptGreeter [ String name |");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t\t");
    _builder.append("self.sayHello(name)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Greeter() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("override sayHello(String name) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("throw new UnsupportedOperationException(\"TODO: auto-generated method stub\")");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void acceptGreeter(Greeter greeter) {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<JvmPsiClass>testNavigateTo(
      "mypackage/Foo.xtend", _builder.toString(), 
      JvmPsiClass.class);
  }
  
  public void testNavigateToAnnonymousClass4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("abstract class Greeter {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("abstract def void sayHello(String name)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String ... args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("acceptGreeter [ String name |");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new UnsupportedOperationException(\"TODO: auto-generated method stub\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("new Greeter() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("override sayHello(String name) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t\t\t");
    _builder.append("this.sayHello(name)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void acceptGreeter(Greeter greeter) {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<PsiClass>testNavigateTo(
      "mypackage/Foo.xtend", _builder.toString(), 
      PsiClass.class);
  }
  
  public void testNavigateToAnnonymousClass5() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("abstract class Greeter {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("abstract def void sayHello(String name)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static val greeter =");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t");
    _builder.append(" new Greeter() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("override sayHello(String name) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t\t\t");
    _builder.append("this.sayHello(name)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String ... args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("greeter.sayHello(args.head)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<PsiClass>testNavigateTo(
      "mypackage/Foo.xtend", _builder.toString(), 
      PsiClass.class);
  }
  
  public void testNavigateToEnumeration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("enum ");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "");
    _builder.append("Light");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("ON, OFF");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Room {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t");
    _builder.append("Light light");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void enable() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("light = Light.ON");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<JvmPsiClass>testNavigateTo(
      "mypackage/Foo.xtend", _builder.toString(), 
      JvmPsiClass.class);
  }
  
  public void testNavigateToEnumConstant() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("enum Light {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t");
    _builder.append("ON");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t");
    _builder.append(", OFF");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Room {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Light light");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void enable() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("light = Light.");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t");
    _builder.append("ON");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<PsiField>testNavigateTo(
      "mypackage/Foo.xtend", _builder.toString(), 
      PsiField.class);
  }
  
  public void testNavigateToConstructor() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Greeter {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String ... args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new ");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t");
    _builder.append("Greeter(args.head)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(String name) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(name)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiMethod psiConstructor = this.<PsiMethod>testNavigateTo(
      "mypackage/Greeter.xtend", _builder.toString(), 
      PsiMethod.class);
    boolean _isConstructor = psiConstructor.isConstructor();
    TestCase.assertTrue(_isConstructor);
  }
  
  public void testNavigateToMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Greeter {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String ... args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Greeter().");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t");
    _builder.append("sayHello(args.head)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void ");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t");
    _builder.append("sayHello");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t");
    _builder.append("(String name) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("println(name)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiMethod psiMethod = this.<PsiMethod>testNavigateTo(
      "mypackage/Greeter.xtend", _builder.toString(), 
      PsiMethod.class);
    boolean _isConstructor = psiMethod.isConstructor();
    TestCase.assertFalse(_isConstructor);
  }
  
  public void testNavigateToAnnotationMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("annotation MyAnnotation {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Class<?> ");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t");
    _builder.append("type");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getType(MyAnnotation myAnnotation) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("myAnnotation.ty");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t");
    _builder.append("pe()");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<PsiMethod>testNavigateTo(
      "mypackage/MyAnnotation.xtend", _builder.toString(), 
      PsiMethod.class);
  }
  
  public void testNavigateToField() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Greeter {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String ");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t");
    _builder.append("name");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void sayHello() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\'Hello \' + na");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t");
    _builder.append("me)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<PsiField>testNavigateTo(
      "mypackage/MyAnnotation.xtend", _builder.toString(), 
      PsiField.class);
  }
  
  public void testNavigateToVariable() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyFunction {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def calc() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val ");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t\t");
    _builder.append("x");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t\t");
    _builder.append(" = 1");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("val y = 1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t");
    _builder.append("x + y");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<PsiEObject>testNavigateTo(
      "mypackage/MyFunction.xtend", _builder.toString(), 
      PsiEObject.class);
  }
  
  protected <T extends Object> T testNavigateTo(final String relativePath, final String fileText, final Class<T> expectedType) {
    T _xblockexpression = null;
    {
      final NavigationTestData navigationTestData = new NavigationTestData(fileText);
      String _model = navigationTestData.getModel();
      this.openFileInEditor(relativePath, _model);
      int _navigationElementStartOffset = navigationTestData.getNavigationElementStartOffset();
      int _navigationElementEndOffset = navigationTestData.getNavigationElementEndOffset();
      TextRange _textRange = new TextRange(_navigationElementStartOffset, _navigationElementEndOffset);
      final PsiElement navigationElement = this.findNavigationElement(_textRange);
      int _referenceOffset = navigationTestData.getReferenceOffset();
      _xblockexpression = this.<T>assertReference(_referenceOffset, expectedType, navigationElement);
    }
    return _xblockexpression;
  }
  
  protected <T extends Object> T assertReference(final int referenceOffset, final Class<T> expectedType, final PsiElement expectedNavigationElement) {
    T _xblockexpression = null;
    {
      Editor _editor = this.myFixture.getEditor();
      CaretModel _caretModel = _editor.getCaretModel();
      _caretModel.moveToOffset(referenceOffset);
      final PsiElement targetElement = this.myFixture.getElementAtCaret();
      TestCase.assertNotNull(targetElement);
      Class<? extends PsiElement> _class = targetElement.getClass();
      String _plus = (_class + " is not assignable from ");
      String _plus_1 = (_plus + expectedType);
      Class<? extends PsiElement> _class_1 = targetElement.getClass();
      boolean _isAssignableFrom = expectedType.isAssignableFrom(_class_1);
      TestCase.assertTrue(_plus_1, _isAssignableFrom);
      final PsiElement actualNavigationElement = targetElement.getNavigationElement();
      boolean _notEquals = (!Objects.equal(expectedNavigationElement, actualNavigationElement));
      if (_notEquals) {
        PsiFile _file = this.getFile();
        String _psiToString = DebugUtil.psiToString(_file, true, true);
        TestCase.assertEquals(_psiToString, expectedNavigationElement, actualNavigationElement);
      }
      _xblockexpression = ((T) targetElement);
    }
    return _xblockexpression;
  }
  
  protected PsiElement findNavigationElement(final TextRange range) {
    PsiElement _xblockexpression = null;
    {
      PsiFile _file = this.getFile();
      int _startOffset = range.getStartOffset();
      PsiElement element = _file.findElementAt(_startOffset);
      TestCase.assertNotNull(element);
      final PsiElement namedEObject = this.findPsiNamedEObject(element, range);
      boolean _notEquals = (!Objects.equal(namedEObject, null));
      if (_notEquals) {
        PsiElement _navigationElement = namedEObject.getNavigationElement();
        TestCase.assertEquals(namedEObject, _navigationElement);
        return namedEObject;
      }
      while ((!Objects.equal(element.getTextRange(), range))) {
        {
          PsiElement _parent = element.getParent();
          element = _parent;
          TestCase.assertNotNull(element);
        }
      }
      PsiElement _navigationElement_1 = element.getNavigationElement();
      TestCase.assertEquals(element, _navigationElement_1);
      _xblockexpression = element;
    }
    return _xblockexpression;
  }
  
  protected PsiElement findPsiNamedEObject(final PsiElement element, final TextRange identifierRange) {
    boolean _equals = Objects.equal(element, null);
    if (_equals) {
      return null;
    }
    if ((element instanceof PsiNamedEObject)) {
      final PsiEObjectIdentifier nameIdentifier = ((PsiNamedEObject)element).getNameIdentifier();
      boolean _notEquals = (!Objects.equal(nameIdentifier, null));
      if (_notEquals) {
        PsiNamedEObject _xifexpression = null;
        TextRange _textRange = nameIdentifier.getTextRange();
        boolean _equals_1 = Objects.equal(_textRange, identifierRange);
        if (_equals_1) {
          _xifexpression = ((PsiNamedEObject)element);
        } else {
          _xifexpression = null;
        }
        return _xifexpression;
      }
    }
    PsiElement _parent = element.getParent();
    return this.findPsiNamedEObject(_parent, identifierRange);
  }
  
  protected PsiFile openFileInEditor(final String relativePath, final String fileText) {
    PsiFile _xblockexpression = null;
    {
      final PsiFile xtendFile = this.myFixture.addFileToProject(relativePath, fileText);
      VirtualFile _virtualFile = xtendFile.getVirtualFile();
      this.myFixture.testHighlighting(true, true, true, _virtualFile);
      VirtualFile _virtualFile_1 = xtendFile.getVirtualFile();
      this.myFixture.openFileInEditor(_virtualFile_1);
      _xblockexpression = xtendFile;
    }
    return _xblockexpression;
  }
}
