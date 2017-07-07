/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer;
import org.eclipse.xtext.ide.tests.serializer.ChangeSerializerTestHelper;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguageFactory;
import org.eclipse.xtext.ide.tests.testlanguage.tests.PartialSerializationTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.InMemoryURIHandler;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(PartialSerializationTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class ChangeSerializerTest {
  @Extension
  private PartialSerializationTestLanguageFactory fac = PartialSerializationTestLanguageFactory.eINSTANCE;
  
  @Inject
  private Provider<ChangeSerializer> serializerProvider;
  
  @Inject
  @Extension
  private ChangeSerializerTestHelper _changeSerializerTestHelper;
  
  @Test
  public void testSimple() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#2 foo");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final MandatoryValue model = this._changeSerializerTestHelper.<MandatoryValue>contents(rs, "inmemory:/file1.pstl", MandatoryValue.class);
    final ChangeSerializer serializer = this.serializerProvider.get();
    serializer.beginRecordChanges(model.eResource());
    model.setName("bar");
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_1.newLine();
    _builder_1.append("#2 <3:3|bar>");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("3 3 \"foo\" -> \"bar\"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testTwoChildren() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#1 root { foo1; foo2; }");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final Node model = this._changeSerializerTestHelper.<Node>contents(rs, "inmemory:/file1.pstl", Node.class);
    final ChangeSerializer serializer = this.serializerProvider.get();
    serializer.beginRecordChanges(model.eResource());
    Node _get = model.getChildren().get(0);
    _get.setName("bazz4");
    Node _get_1 = model.getChildren().get(1);
    _get_1.setName("bazz5");
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_1.newLine();
    _builder_1.append("#1 root { <10:4|bazz4>; <16:4|bazz5>; }");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("10 4 \"foo1\" -> \"bazz4\"");
    _builder_1.newLine();
    _builder_1.append("16 4 \"foo2\" -> \"bazz5\"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testInsertOneChild() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#1 root { child1 { foo1; } }");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final Node model = this._changeSerializerTestHelper.<Node>contents(rs, "inmemory:/file1.pstl", Node.class);
    final ChangeSerializer serializer = this.serializerProvider.get();
    serializer.beginRecordChanges(model.eResource());
    EList<Node> _children = model.getChildren().get(0).getChildren();
    Node _createNode = this.fac.createNode();
    final Procedure1<Node> _function = (Node it) -> {
      it.setName("bazz");
    };
    Node _doubleArrow = ObjectExtensions.<Node>operator_doubleArrow(_createNode, _function);
    _children.add(_doubleArrow);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_1.newLine();
    _builder_1.append("#1 root { child1 { foo1;<24:1| bazz; >} }");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("24 1 \" \" -> \" bazz; \"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testInsertTwoChild() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#1 root { child1 { foo1; } }");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final Node model = this._changeSerializerTestHelper.<Node>contents(rs, "inmemory:/file1.pstl", Node.class);
    final ChangeSerializer serializer = this.serializerProvider.get();
    serializer.beginRecordChanges(model.eResource());
    EList<Node> _children = model.getChildren().get(0).getChildren();
    Node _createNode = this.fac.createNode();
    final Procedure1<Node> _function = (Node it) -> {
      it.setName("bazz1");
    };
    Node _doubleArrow = ObjectExtensions.<Node>operator_doubleArrow(_createNode, _function);
    _children.add(_doubleArrow);
    EList<Node> _children_1 = model.getChildren().get(0).getChildren();
    Node _createNode_1 = this.fac.createNode();
    final Procedure1<Node> _function_1 = (Node it) -> {
      it.setName("bazz2");
    };
    Node _doubleArrow_1 = ObjectExtensions.<Node>operator_doubleArrow(_createNode_1, _function_1);
    _children_1.add(_doubleArrow_1);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_1.newLine();
    _builder_1.append("#1 root { child1 { foo1;<24:1| bazz1; bazz2; >} }");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("24 1 \" \" -> \" bazz1; bazz2; \"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testDeleteChild() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#1 root { child1 { foo1; } }");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final Node model = this._changeSerializerTestHelper.<Node>contents(rs, "inmemory:/file1.pstl", Node.class);
    final ChangeSerializer serializer = this.serializerProvider.get();
    serializer.beginRecordChanges(model.eResource());
    EcoreUtil.remove(model.getChildren().get(0).getChildren().get(0));
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_1.newLine();
    _builder_1.append("#1 root { child1 {<18:7|  >} }");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("18 7 \" foo1; \" -> \"  \"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testRenameLocal() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#1 root { foo1; foo2 { ref foo1 } }");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final Node model = this._changeSerializerTestHelper.<Node>contents(rs, "inmemory:/file1.pstl", Node.class);
    final ChangeSerializer serializer = this.serializerProvider.get();
    serializer.beginRecordChanges(model.eResource());
    Node _get = model.getChildren().get(0);
    _get.setName("bazz4");
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_1.newLine();
    _builder_1.append("#1 root { <10:4|bazz4>; foo2 { ref <27:4|bazz4> } }");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("10 4 \"foo1\" -> \"bazz4\"");
    _builder_1.newLine();
    _builder_1.append("27 4 \"foo1\" -> \"bazz4\"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testRenameGlobal1() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#1 root1;");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("#1 root2 { ref root1 }");
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("inmemory:/file2.pstl", _builder_1.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo_1);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final Node model = this._changeSerializerTestHelper.<Node>contents(rs, "inmemory:/file1.pstl", Node.class);
    final ChangeSerializer serializer = this.serializerProvider.get();
    serializer.beginRecordChanges(model.eResource());
    model.setName("newroot");
    Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_2.newLine();
    _builder_2.append("#1 <3:5|newroot>;");
    _builder_2.newLine();
    _builder_2.append("--------------------------------------------------------------------------------");
    _builder_2.newLine();
    _builder_2.append("3 5 \"root1\" -> \"newroot\"");
    _builder_2.newLine();
    _builder_2.append("----------------- inmemory:/file2.pstl (syntax: <offset|text>) -----------------");
    _builder_2.newLine();
    _builder_2.append("#1 root2 { ref <15:5|newroot> }");
    _builder_2.newLine();
    _builder_2.append("--------------------------------------------------------------------------------");
    _builder_2.newLine();
    _builder_2.append("15 5 \"root1\" -> \"newroot\"");
    _builder_2.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_2);
  }
}
