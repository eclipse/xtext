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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer;
import org.eclipse.xtext.ide.tests.serializer.ChangeSerializerTestHelper;
import org.eclipse.xtext.ide.tests.serializer.PartialSerializationTestLanguageInjectorProviderWithEmf;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.EClassRef;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Model;
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
@InjectWith(PartialSerializationTestLanguageInjectorProviderWithEmf.class)
@SuppressWarnings("all")
public class ChangeSerializerWithEmfTest {
  @Inject
  private Provider<ChangeSerializer> serializerProvider;
  
  @Inject
  @Extension
  private ChangeSerializerTestHelper _changeSerializerTestHelper;
  
  @Test
  public void testRefToXML() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#21 MyPackage.MyClass1");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder_1.newLine();
    _builder_1.append("<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"MyPackage\">");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("<eClassifiers xsi:type=\"ecore:EClass\" name=\"MyClass1\" eSuperTypes=\"#//MyClass2\"/>");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("<eClassifiers xsi:type=\"ecore:EClass\" name=\"MyClass2\"/>");
    _builder_1.newLine();
    _builder_1.append("</ecore:EPackage>");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("inmemory:/file2.ecore", _builder_1.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo_1);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final EClassRef model = this._changeSerializerTestHelper.<EClassRef>contents(rs, "inmemory:/file1.pstl", EClassRef.class);
    final ChangeSerializer serializer = this.serializerProvider.get();
    final IChangeSerializer.IModification<EClassRef> _function = (EClassRef it) -> {
      EClassifier _get = model.getRef().getEPackage().getEClassifiers().get(1);
      model.setRef(((EClass) _get));
    };
    serializer.<EClassRef>addModification(model, _function);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_2.newLine();
    _builder_2.append("#21 <4:18|MyPackage.MyClass2>");
    _builder_2.newLine();
    _builder_2.append("--------------------------------------------------------------------------------");
    _builder_2.newLine();
    _builder_2.append("4 18 \"MyPackage.MyClass1\" -> \"MyPackage.MyClass2\"");
    _builder_2.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_2);
  }
  
  @Test
  public void testRefFromXML() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#20 DslEClass");
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _builder.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder_1.newLine();
    _builder_1.append("<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"MyPackage\">");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("<eClassifiers xsi:type=\"ecore:EClass\" name=\"MyClass1\" eSuperTypes=\"inmemory:/file1.pstl#//@clazz.0\"/>");
    _builder_1.newLine();
    _builder_1.append("</ecore:EPackage>");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("inmemory:/file2.ecore", _builder_1.toString());
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo_1);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final Model model = this._changeSerializerTestHelper.<Model>contents(rs, "inmemory:/file1.pstl", Model.class);
    final ChangeSerializer serializer = this.serializerProvider.get();
    final IChangeSerializer.IModification<Resource> _function = (Resource it) -> {
      EClass _get = model.getClazz().get(0);
      _get.setName("ChangedName");
      EList<EClass> _clazz = model.getClazz();
      EClass _createEClass = EcoreFactory.eINSTANCE.createEClass();
      final Procedure1<EClass> _function_1 = (EClass it_1) -> {
        it_1.setName("NewName");
      };
      EClass _doubleArrow = ObjectExtensions.<EClass>operator_doubleArrow(_createEClass, _function_1);
      _clazz.add(0, _doubleArrow);
      Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
    };
    serializer.<Resource>addModification(model.eResource(), _function);
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------");
    _builder_2.newLine();
    _builder_2.append("#20<3:1| NewName ><4:9| ChangedName>");
    _builder_2.newLine();
    _builder_2.append("--------------------------------------------------------------------------------");
    _builder_2.newLine();
    _builder_2.append("3 1 \" \" -> \" NewName \"");
    _builder_2.newLine();
    _builder_2.append("4 9 \"DslEClass\" -> \" ChangedName\"");
    _builder_2.newLine();
    _builder_2.append("---------------------------- inmemory:/file2.ecore -----------------------------");
    _builder_2.newLine();
    _builder_2.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder_2.newLine();
    _builder_2.append("<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
    _builder_2.newLine();
    _builder_2.append("    ");
    _builder_2.append("xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"MyPackage\">");
    _builder_2.newLine();
    _builder_2.append("  ");
    _builder_2.append("<eClassifiers xsi:type=\"ecore:EClass\" name=\"MyClass1\" eSuperTypes=\"file1.pstl#//@clazz.1\"/>");
    _builder_2.newLine();
    _builder_2.append("</ecore:EPackage>");
    _builder_2.newLine();
    _builder_2.append("--------------------------------------------------------------------------------");
    _builder_2.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_2);
  }
}
