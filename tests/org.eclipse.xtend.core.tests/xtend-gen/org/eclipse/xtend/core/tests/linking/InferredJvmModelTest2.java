/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.linking;

import org.eclipse.emf.common.util.EList;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = NewTypeSystemRuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class InferredJvmModelTest2 extends InferredJvmModelTest {
  @Ignore(value = "TODO: implement solution for recursive functions, e.g. doStuff in this test case")
  @Test
  public void testDispatchFunction_03() throws Exception {
    super.testDispatchFunction_03();
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
