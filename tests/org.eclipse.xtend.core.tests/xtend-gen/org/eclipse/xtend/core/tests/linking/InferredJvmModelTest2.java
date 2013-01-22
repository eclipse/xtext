/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.linking;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.linking.InferredJvmModelTest;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = NewTypeSystemRuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class InferredJvmModelTest2 extends InferredJvmModelTest {
  @Test
  public void testDispatchFunction_03() throws Exception {
    this.testDispatchFunction_03_impl(true);
  }
  
  @Test
  public void testDispatchFunction_03_noValidate() throws Exception {
    this.testDispatchFunction_03_impl(false);
  }
  
  protected void testDispatchFunction_03_impl(final boolean validation) throws Exception {
    String _plus = ("class Dispatcher {\n" + 
      "\tdef dispatch doStuff(org.eclipse.emf.ecore.EClass model) {\n");
    String _plus_1 = (_plus + 
      "\t\tmodel.ETypeParameters.map(e|doStuff(e))\n");
    String _plus_2 = (_plus_1 + 
      "\t}\n");
    String _plus_3 = (_plus_2 + 
      "\tdef dispatch doStuff(org.eclipse.emf.ecore.EPackage packageDecl) {\n");
    String _plus_4 = (_plus_3 + 
      "\t\tpackageDecl.EClassifiers.map(e|doStuff(e))\n");
    String _plus_5 = (_plus_4 + 
      "\t}\n");
    String _plus_6 = (_plus_5 + 
      "\tdef dispatch doStuff(org.eclipse.emf.ecore.EStructuralFeature feature) {\n");
    String _plus_7 = (_plus_6 + 
      "\t\tnewArrayList(feature)\n");
    String _plus_8 = (_plus_7 + 
      "\t}\n");
    String _plus_9 = (_plus_8 + 
      "}");
    final XtendFile xtendFile = this.file(_plus_9, validation);
    final JvmGenericType inferredType = this.getInferredType(xtendFile);
    final Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
    final JvmOperation dispatchCase = this.findByNameAndFirstParameterType(operations, "doStuff", ENamedElement.class);
    JvmTypeReference _returnType = dispatchCase.getReturnType();
    String _identifier = _returnType.getIdentifier();
    Assert.assertEquals("java.lang.Object", _identifier);
    final JvmOperation eClassParam = this.findByNameAndFirstParameterType(operations, "_doStuff", EClass.class);
    JvmTypeReference _returnType_1 = eClassParam.getReturnType();
    String _identifier_1 = _returnType_1.getIdentifier();
    Assert.assertEquals("java.util.List<? extends java.lang.Object>", _identifier_1);
    final JvmOperation ePackageParam = this.findByNameAndFirstParameterType(operations, "_doStuff", EPackage.class);
    JvmTypeReference _returnType_2 = ePackageParam.getReturnType();
    String _identifier_2 = _returnType_2.getIdentifier();
    Assert.assertEquals("java.util.List<? extends java.lang.Object>", _identifier_2);
    final JvmOperation eStructuralFeatureParam = this.findByNameAndFirstParameterType(operations, "_doStuff", EStructuralFeature.class);
    JvmTypeReference _returnType_3 = eStructuralFeatureParam.getReturnType();
    String _identifier_3 = _returnType_3.getIdentifier();
    Assert.assertEquals("java.util.List<? extends java.lang.Object>", _identifier_3);
  }
  
  @Test
  public void testDispatchFunction_04() throws Exception {
    final XtendFile xtendFile = this.file("class Foo { def dispatch foo(Integer x) {x} def dispatch foo(Double x) {x}}");
    final JvmGenericType inferredType = this.getInferredType(xtendFile);
    final Iterable<JvmOperation> operations = inferredType.getDeclaredOperations();
    final JvmOperation dispatcher = this.findByNameAndFirstParameterType(operations, "foo", Object.class);
    JvmTypeReference _returnType = dispatcher.getReturnType();
    String _identifier = _returnType.getIdentifier();
    Assert.assertEquals("java.lang.Object", _identifier);
    JvmOperation internal = this.findByNameAndFirstParameterType(operations, "_foo", Double.class);
    JvmTypeReference _returnType_1 = dispatcher.getReturnType();
    String _identifier_1 = _returnType_1.getIdentifier();
    JvmTypeReference _returnType_2 = internal.getReturnType();
    String _identifier_2 = _returnType_2.getIdentifier();
    Assert.assertEquals(_identifier_1, _identifier_2);
    JvmOperation _findByNameAndFirstParameterType = this.findByNameAndFirstParameterType(operations, "_foo", Integer.class);
    internal = _findByNameAndFirstParameterType;
    JvmTypeReference _returnType_3 = dispatcher.getReturnType();
    String _identifier_3 = _returnType_3.getIdentifier();
    JvmTypeReference _returnType_4 = internal.getReturnType();
    String _identifier_4 = _returnType_4.getIdentifier();
    Assert.assertEquals(_identifier_3, _identifier_4);
  }
  
  @Test
  public void testInferredFunctionWithReturnType_04() throws Exception {
    final XtendFile xtendFile = this.file("class Foo { def bar() { if (true) null as Double else null as Integer } }");
    final JvmGenericType inferredType = this.getInferredType(xtendFile);
    EList<JvmMember> _members = inferredType.getMembers();
    JvmMember _get = _members.get(1);
    final JvmOperation jvmOperation = ((JvmOperation) _get);
    JvmTypeReference _returnType = jvmOperation.getReturnType();
    String _identifier = _returnType.getIdentifier();
    Assert.assertEquals("java.lang.Object", _identifier);
  }
  
  @Test
  public void testInferredFunctionWithReturnType_05() throws Exception {
    final XtendFile xtendFile = this.file("class Foo { def bar() { newArrayList(if (true) null as Double else null as Integer) } }");
    final JvmGenericType inferredType = this.getInferredType(xtendFile);
    EList<JvmMember> _members = inferredType.getMembers();
    JvmMember _get = _members.get(1);
    final JvmOperation jvmOperation = ((JvmOperation) _get);
    JvmTypeReference _returnType = jvmOperation.getReturnType();
    String _identifier = _returnType.getIdentifier();
    Assert.assertEquals("java.util.ArrayList<java.lang.Object>", _identifier);
  }
}
