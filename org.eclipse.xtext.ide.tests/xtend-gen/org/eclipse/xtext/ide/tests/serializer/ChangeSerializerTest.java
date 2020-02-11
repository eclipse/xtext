/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.serializer;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.tests.serializer.ChangeSerializerTestHelper;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ChildWithSubChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ChildWithSubChilds;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguageFactory;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.SubChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChildLists;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChilds;
import org.eclipse.xtext.ide.tests.testlanguage.tests.PartialSerializationTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.InMemoryURIHandler;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  @Extension
  private ChangeSerializerTestHelper _changeSerializerTestHelper;
  
  @Test
  public void testNoop() {
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, "");
  }
  
  @Test
  public void testSimple() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#2 foo");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final MandatoryValue model = this._changeSerializerTestHelper.<MandatoryValue>contents(rs, "inmemory:/file1.pstl", MandatoryValue.class);
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      model.setName("bar");
    };
    serializer.<Resource>addModification(model.eResource(), _function);
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
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      Node _get = model.getChildren().get(0);
      _get.setName("bazz4");
      Node _get_1 = model.getChildren().get(1);
      _get_1.setName("bazz5");
    };
    serializer.<Resource>addModification(model.eResource(), _function);
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
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      EList<Node> _children = model.getChildren().get(0).getChildren();
      Node _createNode = this.fac.createNode();
      final Procedure1<Node> _function_1 = (Node it_1) -> {
        it_1.setName("bazz");
      };
      Node _doubleArrow = ObjectExtensions.<Node>operator_doubleArrow(_createNode, _function_1);
      _children.add(_doubleArrow);
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_1.newLine();
    _builder_1.append("#1 root { child1 { foo1; <25:0|bazz; >} }");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("25 0 \"\" -> \"bazz; \"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testInsertBeforeComment() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#1 root {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**/ ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final Node model = this._changeSerializerTestHelper.<Node>contents(rs, "inmemory:/file1.pstl", Node.class);
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      EList<Node> _children = model.getChildren();
      Node _createNode = this.fac.createNode();
      final Procedure1<Node> _function_1 = (Node it_1) -> {
        it_1.setName("bazz");
      };
      Node _doubleArrow = ObjectExtensions.<Node>operator_doubleArrow(_createNode, _function_1);
      _children.add(0, _doubleArrow);
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_1.newLine();
    _builder_1.append("#1 root {<9:0| bazz;>");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("/**/ ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("child1;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("9 0 \"\" -> \" bazz;\"");
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
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      EList<Node> _children = model.getChildren().get(0).getChildren();
      Node _createNode = this.fac.createNode();
      final Procedure1<Node> _function_1 = (Node it_1) -> {
        it_1.setName("bazz1");
      };
      Node _doubleArrow = ObjectExtensions.<Node>operator_doubleArrow(_createNode, _function_1);
      _children.add(_doubleArrow);
      EList<Node> _children_1 = model.getChildren().get(0).getChildren();
      Node _createNode_1 = this.fac.createNode();
      final Procedure1<Node> _function_2 = (Node it_1) -> {
        it_1.setName("bazz2");
      };
      Node _doubleArrow_1 = ObjectExtensions.<Node>operator_doubleArrow(_createNode_1, _function_2);
      _children_1.add(_doubleArrow_1);
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_1.newLine();
    _builder_1.append("#1 root { child1 { foo1; <25:0|bazz1; bazz2; >} }");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("25 0 \"\" -> \"bazz1; bazz2; \"");
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
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      EcoreUtil.remove(model.getChildren().get(0).getChildren().get(0));
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_1.newLine();
    _builder_1.append("#1 root { child1 { <19:5|> } }");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("19 5 \"foo1;\" -> \"\"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testDeleteTwoChildren() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#1 root { child1; child2; }");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final Node model = this._changeSerializerTestHelper.<Node>contents(rs, "inmemory:/file1.pstl", Node.class);
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      EcoreUtil.remove(model.getChildren().get(1));
      EcoreUtil.remove(model.getChildren().get(0));
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_1.newLine();
    _builder_1.append("#1 root { <10:7|> <18:7|> }");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("10 7 \"child1;\" -> \"\"");
    _builder_1.newLine();
    _builder_1.append("18 7 \"child2;\" -> \"\"");
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
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      Node _get = model.getChildren().get(0);
      _get.setName("bazz4");
    };
    serializer.<Resource>addModification(model.eResource(), _function);
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
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      model.setName("newroot");
    };
    serializer.<Resource>addModification(model.eResource(), _function);
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
  
  @Test
  public void testRenameFqn1() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#1 r {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("X refs a1.a2 X.a1.a2 r.X.a1.a2 { a1 { a2 refs a2 { a3 { ref a3 } } } }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Y refs b1.b2 Y.b1.b2 r.Y.b1.b2 { b1 { b2 { ref b2 } } }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final Node model = this._changeSerializerTestHelper.<Node>contents(rs, "inmemory:/file1.pstl", Node.class);
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      Node _head = IterableExtensions.<Node>head(IterableExtensions.<Node>head(IterableExtensions.<Node>head(model.getChildren()).getChildren()).getChildren());
      _head.setName("b");
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_1.newLine();
    _builder_1.append("#1 r {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("X refs <15:5|a1.b> <21:7|a1.b> <29:9|a1.b> { a1 { <46:2|b> refs <54:2|b> { a3 { ref a3 } } } }");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Y refs b1.b2 Y.b1.b2 r.Y.b1.b2 { b1 { b2 { ref b2 } } }");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("15 5 \"a1.a2\" -> \"a1.b\"");
    _builder_1.newLine();
    _builder_1.append("21 7 \"X.a1.a2\" -> \"a1.b\"");
    _builder_1.newLine();
    _builder_1.append("29 9 \"r.X.a1.a2\" -> \"a1.b\"");
    _builder_1.newLine();
    _builder_1.append("46 2 \"a2\" -> \"b\"");
    _builder_1.newLine();
    _builder_1.append("54 2 \"a2\" -> \"b\"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testRenameFqn1ValueConversion() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#1 r {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("X refs ^a1.^a2 ^X.^a1.^a2 ^r.^X.^a1.^a2 { a1 { a2 refs ^a2 { a3 { ref ^a3 } } } }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Y refs ^b1.^b2 ^Y.^b1.^b2 ^r.^Y.^b1.^b2 { b1 { b2 { ref b2 } } }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final Node model = this._changeSerializerTestHelper.<Node>contents(rs, "inmemory:/file1.pstl", Node.class);
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      Node _head = IterableExtensions.<Node>head(IterableExtensions.<Node>head(IterableExtensions.<Node>head(model.getChildren()).getChildren()).getChildren());
      _head.setName("b");
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_1.newLine();
    _builder_1.append("#1 r {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("X refs <15:7|a1.b> <23:10|a1.b> <34:13|a1.b> { a1 { <55:2|b> refs <63:3|b> { a3 { ref ^a3 } } } }");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Y refs ^b1.^b2 ^Y.^b1.^b2 ^r.^Y.^b1.^b2 { b1 { b2 { ref b2 } } }");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("15  7 \"^a1.^a2\" -> \"a1.b\"");
    _builder_1.newLine();
    _builder_1.append("23 10 \"^X.^a1.^a2\" -> \"a1.b\"");
    _builder_1.newLine();
    _builder_1.append("34 13 \"^r.^X.^a1.^a2\" -> \"a1.b\"");
    _builder_1.newLine();
    _builder_1.append("55  2 \"a2\" -> \"b\"");
    _builder_1.newLine();
    _builder_1.append("63  3 \"^a2\" -> \"b\"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testResourceURIChange() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#1 root { }");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/f.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final Node model = this._changeSerializerTestHelper.<Node>contents(rs, "inmemory:/f.pstl", Node.class);
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      Resource _eResource = model.eResource();
      _eResource.setURI(URI.createURI("inmemory:/x.pstl"));
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----- renamed inmemory:/f.pstl to inmemory:/x.pstl (syntax: <offset|text>) -----");
    _builder_1.newLine();
    _builder_1.append("(no changes)");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testAddChildElement() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#22 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("children1 {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("child2 child3");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file-move.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final TwoChildLists model = this._changeSerializerTestHelper.<TwoChildLists>contents(rs, "inmemory:/file-move.pstl", TwoChildLists.class);
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      EList<MandatoryValue> _directChildren = model.getDirectChildren();
      MandatoryValue _createMandatoryValue = this.fac.createMandatoryValue();
      final Procedure1<MandatoryValue> _function_1 = (MandatoryValue it_1) -> {
        it_1.setName("newChild");
      };
      MandatoryValue _doubleArrow = ObjectExtensions.<MandatoryValue>operator_doubleArrow(_createMandatoryValue, _function_1);
      _directChildren.add(_doubleArrow);
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("--------------- inmemory:/file-move.pstl (syntax: <offset|text>) ---------------");
    _builder_1.newLine();
    _builder_1.append("#22 {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("child1<13:0| newChild>");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("children1 {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("child2 child3");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("13 0 \"\" -> \" newChild\"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testMoveElement() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#22 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("children1 {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("child2 jumper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file-move1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final TwoChildLists model = this._changeSerializerTestHelper.<TwoChildLists>contents(rs, "inmemory:/file-move1.pstl", TwoChildLists.class);
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      final Function1<MandatoryValue, Boolean> _function_1 = (MandatoryValue it_1) -> {
        String _name = it_1.getName();
        return Boolean.valueOf(Objects.equal(_name, "jumper"));
      };
      model.getDirectChildren().add(IterableExtensions.<MandatoryValue>findFirst(model.getChildsList().getChildren(), _function_1));
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("-------------- inmemory:/file-move1.pstl (syntax: <offset|text>) ---------------");
    _builder_1.newLine();
    _builder_1.append("#22 {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("child1<13:0| jumper>");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("children1 {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("child2 <36:6|>");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("13 0 \"\" -> \" jumper\"");
    _builder_1.newLine();
    _builder_1.append("36 6 \"jumper\" -> \"\"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testMoveElement_2() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#22 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("children1 {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("child2 jumper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file-move.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final TwoChildLists model = this._changeSerializerTestHelper.<TwoChildLists>contents(rs, "inmemory:/file-move.pstl", TwoChildLists.class);
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      final Function1<MandatoryValue, Boolean> _function_1 = (MandatoryValue it_1) -> {
        String _name = it_1.getName();
        return Boolean.valueOf(Objects.equal(_name, "jumper"));
      };
      model.getDirectChildren().add(0, IterableExtensions.<MandatoryValue>findFirst(model.getChildsList().getChildren(), _function_1));
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("--------------- inmemory:/file-move.pstl (syntax: <offset|text>) ---------------");
    _builder_1.newLine();
    _builder_1.append("#22 {<5:0| jumper>");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("child1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("children1 {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("child2 <36:6|>");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("5 0 \"\" -> \" jumper\"");
    _builder_1.newLine();
    _builder_1.append("36 6 \"jumper\" -> \"\"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testMoveElement_2a() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#22 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child1 child3");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("children1 {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("child2 jumper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file-move2a.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final TwoChildLists model = this._changeSerializerTestHelper.<TwoChildLists>contents(rs, "inmemory:/file-move2a.pstl", TwoChildLists.class);
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      final Function1<MandatoryValue, Boolean> _function_1 = (MandatoryValue it_1) -> {
        String _name = it_1.getName();
        return Boolean.valueOf(Objects.equal(_name, "jumper"));
      };
      model.getDirectChildren().add(1, IterableExtensions.<MandatoryValue>findFirst(model.getChildsList().getChildren(), _function_1));
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("-------------- inmemory:/file-move2a.pstl (syntax: <offset|text>) --------------");
    _builder_1.newLine();
    _builder_1.append("#22 {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("child1 <14:0|jumper >child3");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("children1 {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("child2 <43:6|>");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("14 0 \"\" -> \"jumper \"");
    _builder_1.newLine();
    _builder_1.append("43 6 \"jumper\" -> \"\"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testMoveElement_3() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#24 direct:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("child:jumper");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file-move3.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final TwoChilds model = this._changeSerializerTestHelper.<TwoChilds>contents(rs, "inmemory:/file-move3.pstl", TwoChilds.class);
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      model.setDirectChild(model.getOptChild().getChild());
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("-------------- inmemory:/file-move3.pstl (syntax: <offset|text>) ---------------");
    _builder_1.newLine();
    _builder_1.append("<0:26|#24 direct:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("jumper");
    _builder_1.newLine();
    _builder_1.append("child :>");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("0 26 \"#24 direct:\\n\tchil...\" -> \"#24 direct:\\n\tjump...\"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
  
  @Test
  public void testAddElements() {
    final String uri = "inmemory:/file-add.pstl";
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#23");
    Pair<String, String> _mappedTo = Pair.<String, String>of(uri, _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final ChildWithSubChilds model = this._changeSerializerTestHelper.<ChildWithSubChilds>contents(rs, uri, ChildWithSubChilds.class);
    final IChangeSerializer serializer = this._changeSerializerTestHelper.newChangeSerializer();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      EList<ChildWithSubChild> _children = model.getChildren();
      ChildWithSubChild _createChildWithSubChild = this.fac.createChildWithSubChild();
      final Procedure1<ChildWithSubChild> _function_1 = (ChildWithSubChild it_1) -> {
        EList<SubChild> _subChilds = it_1.getSubChilds();
        SubChild _createSubChild = this.fac.createSubChild();
        final Procedure1<SubChild> _function_2 = (SubChild it_2) -> {
          it_2.setName("A");
        };
        SubChild _doubleArrow = ObjectExtensions.<SubChild>operator_doubleArrow(_createSubChild, _function_2);
        _subChilds.add(_doubleArrow);
      };
      ChildWithSubChild _doubleArrow = ObjectExtensions.<ChildWithSubChild>operator_doubleArrow(_createChildWithSubChild, _function_1);
      _children.add(_doubleArrow);
      ChildWithSubChild _head = IterableExtensions.<ChildWithSubChild>head(model.getChildren());
      final Procedure1<ChildWithSubChild> _function_2 = (ChildWithSubChild it_1) -> {
        EList<SubChild> _subChilds = it_1.getSubChilds();
        SubChild _createSubChild = this.fac.createSubChild();
        final Procedure1<SubChild> _function_3 = (SubChild it_2) -> {
          it_2.setName("A2");
        };
        SubChild _doubleArrow_1 = ObjectExtensions.<SubChild>operator_doubleArrow(_createSubChild, _function_3);
        _subChilds.add(_doubleArrow_1);
      };
      ObjectExtensions.<ChildWithSubChild>operator_doubleArrow(_head, _function_2);
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("--------------- inmemory:/file-add.pstl (syntax: <offset|text>) ----------------");
    _builder_1.newLine();
    _builder_1.append("<0:3|#23 subs A A2>");
    _builder_1.newLine();
    _builder_1.append("--------------------------------------------------------------------------------");
    _builder_1.newLine();
    _builder_1.append("0 3 \"#23\" -> \"#23 subs A A2\"");
    _builder_1.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_1);
  }
}
