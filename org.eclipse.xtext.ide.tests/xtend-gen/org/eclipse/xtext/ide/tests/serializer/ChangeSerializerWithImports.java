/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collection;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer;
import org.eclipse.xtext.ide.tests.serializer.ChangeSerializerTestHelper;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node;
import org.eclipse.xtext.ide.tests.testlanguage.tests.PartialSerializationTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.InMemoryURIHandler;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(PartialSerializationTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class ChangeSerializerWithImports {
  @Inject
  private Provider<ChangeSerializer> serializerProvider;
  
  @Inject
  @Extension
  private ChangeSerializerTestHelper _changeSerializerTestHelper;
  
  @Test
  public void testRenameGlobal1() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#1 root1 { child1; }");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("#1 import root1.child1 refs child1;");
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("inmemory:/file2.pstl", _builder_1.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo_1);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final Node model = this._changeSerializerTestHelper.<Node>contents(rs, "inmemory:/file1.pstl", Node.class);
    final ChangeSerializer serializer = this.serializerProvider.get();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      Node _get = model.getChildren().get(0);
      _get.setName("newchild");
      Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_2.newLine();
    _builder_2.append("#1 root1 { <11:6|newchild>; }");
    _builder_2.newLine();
    _builder_2.append("--------------------------------------------------------------------------------");
    _builder_2.newLine();
    _builder_2.append("11 6 \"child1\" -> \"newchild\"");
    _builder_2.newLine();
    _builder_2.append("----------------- inmemory:/file2.pstl (syntax: <offset|text>) -----------------");
    _builder_2.newLine();
    _builder_2.append("#1 import <10:12|root1.newchild> refs <28:6|newchild>;");
    _builder_2.newLine();
    _builder_2.append("--------------------------------------------------------------------------------");
    _builder_2.newLine();
    _builder_2.append("10 12 \"root1.child1\" -> \"root1.newchild\"");
    _builder_2.newLine();
    _builder_2.append("28  6 \"child1\" -> \"newchild\"");
    _builder_2.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_2);
  }
}
