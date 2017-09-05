/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.importHandling;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collection;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer;
import org.eclipse.xtext.ide.tests.importHandling.ImportTestHelper;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.InMemoryURIHandler;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration;
import org.eclipse.xtext.testlanguages.fileAware.ide.tests.FileAwareTestLanguageIdeInjectorProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FileAwareTestLanguageIdeInjectorProvider.class)
@SuppressWarnings("all")
public class FileAwareTestLanguageImportTest {
  @Inject
  private Provider<ChangeSerializer> serializerProvider;
  
  @Inject
  @Extension
  private ImportTestHelper _importTestHelper;
  
  @Test
  public void testRenameGlobal1() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package pkg1");
    _builder.newLine();
    _builder.newLine();
    _builder.append("element Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.fileawaretestlanguage", _builder.toString());
    this._importTestHelper.operator_add(fs, _mappedTo);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package pkg2");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import pkg1.Foo");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("element Bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("ref Foo");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("inmemory:/file2.fileawaretestlanguage", _builder_1.toString());
    this._importTestHelper.operator_add(fs, _mappedTo_1);
    final ResourceSet rs = this._importTestHelper.createResourceSet(fs);
    final PackageDeclaration model = this._importTestHelper.<PackageDeclaration>contents(rs, "inmemory:/file1.fileawaretestlanguage", PackageDeclaration.class);
    final ChangeSerializer serializer = this.serializerProvider.get();
    serializer.beginRecordChanges(model.eResource());
    model.setName("newpackage");
    Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._importTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("-------- inmemory:/file1.fileawaretestlanguage (syntax: <offset|text>) ---------");
    _builder_2.newLine();
    _builder_2.append("package <8:4|newpackage>");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("element Foo {");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("--------------------------------------------------------------------------------");
    _builder_2.newLine();
    _builder_2.append("8 4 \"pkg1\" -> \"newpackage\"");
    _builder_2.newLine();
    _builder_2.append("-------- inmemory:/file2.fileawaretestlanguage (syntax: <offset|text>) ---------");
    _builder_2.newLine();
    _builder_2.append("package pkg2");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("import <21:8|newpackage.Foo>");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("element Bar {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("ref Foo");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("--------------------------------------------------------------------------------");
    _builder_2.newLine();
    _builder_2.append("21 8 \"pkg1.Foo\" -> \"newpackage.Foo\"");
    _builder_2.newLine();
    this._importTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_2);
  }
  
  @Test
  public void testMoveToNewPackage() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package pkg1");
    _builder.newLine();
    _builder.newLine();
    _builder.append("element Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.fileawaretestlanguage", _builder.toString());
    this._importTestHelper.operator_add(fs, _mappedTo);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package pkg1");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("element Bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("ref Foo");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("inmemory:/file2.fileawaretestlanguage", _builder_1.toString());
    this._importTestHelper.operator_add(fs, _mappedTo_1);
    final ResourceSet rs = this._importTestHelper.createResourceSet(fs);
    final PackageDeclaration model = this._importTestHelper.<PackageDeclaration>contents(rs, "inmemory:/file1.fileawaretestlanguage", PackageDeclaration.class);
    final ChangeSerializer serializer = this.serializerProvider.get();
    serializer.beginRecordChanges(model.eResource());
    model.setName("newpackage");
    Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._importTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("-------- inmemory:/file1.fileawaretestlanguage (syntax: <offset|text>) ---------");
    _builder_2.newLine();
    _builder_2.append("package <8:4|newpackage>");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("element Foo {");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("--------------------------------------------------------------------------------");
    _builder_2.newLine();
    _builder_2.append("8 4 \"pkg1\" -> \"newpackage\"");
    _builder_2.newLine();
    _builder_2.append("-------- inmemory:/file2.fileawaretestlanguage (syntax: <offset|text>) ---------");
    _builder_2.newLine();
    _builder_2.append("package pkg1<12:2|");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("import newpackage.Foo");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append(">element Bar {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("ref Foo");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("--------------------------------------------------------------------------------");
    _builder_2.newLine();
    _builder_2.append("12 2 \"\\n\\n\" -> \"\\n\\nimport newpacka...\"");
    _builder_2.newLine();
    this._importTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_2);
  }
  
  @Test
  public void testMoveIntoLocalPackage() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package other");
    _builder.newLine();
    _builder.newLine();
    _builder.append("element Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.fileawaretestlanguage", _builder.toString());
    this._importTestHelper.operator_add(fs, _mappedTo);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package pkg1");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import other.Foo");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("element Bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("ref Foo");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("inmemory:/file2.fileawaretestlanguage", _builder_1.toString());
    this._importTestHelper.operator_add(fs, _mappedTo_1);
    final ResourceSet rs = this._importTestHelper.createResourceSet(fs);
    final PackageDeclaration model = this._importTestHelper.<PackageDeclaration>contents(rs, "inmemory:/file1.fileawaretestlanguage", PackageDeclaration.class);
    final ChangeSerializer serializer = this.serializerProvider.get();
    serializer.beginRecordChanges(model.eResource());
    model.setName("pkg1");
    Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._importTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("-------- inmemory:/file1.fileawaretestlanguage (syntax: <offset|text>) ---------");
    _builder_2.newLine();
    _builder_2.append("package <8:5|pkg1>");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("element Foo {");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("--------------------------------------------------------------------------------");
    _builder_2.newLine();
    _builder_2.append("8 5 \"other\" -> \"pkg1\"");
    _builder_2.newLine();
    _builder_2.append("-------- inmemory:/file2.fileawaretestlanguage (syntax: <offset|text>) ---------");
    _builder_2.newLine();
    _builder_2.append("package pkg1<12:20|");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append(">element Bar {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("ref Foo");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("--------------------------------------------------------------------------------");
    _builder_2.newLine();
    _builder_2.append("12 20 \"\\n\\nimport other.Foo\\n\\n\" -> \"\\n\\n\"");
    _builder_2.newLine();
    this._importTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_2);
  }
  
  @Test
  public void testNestedPackage() {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo ");
    _builder.newLine();
    _builder.append("element X {}");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/foo/X.fileawaretestlanguage", _builder.toString());
    this._importTestHelper.operator_add(fs, _mappedTo);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo.bar ");
    _builder_1.newLine();
    _builder_1.append("element Y { ref foo.X }");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("inmemory:/foo/bar/Y.fileawaretestlanguage", _builder_1.toString());
    this._importTestHelper.operator_add(fs, _mappedTo_1);
    final ResourceSet rs = this._importTestHelper.createResourceSet(fs);
    final PackageDeclaration model1 = this._importTestHelper.<PackageDeclaration>contents(rs, "inmemory:/foo/X.fileawaretestlanguage", PackageDeclaration.class);
    final PackageDeclaration model2 = this._importTestHelper.<PackageDeclaration>contents(rs, "inmemory:/foo/bar/Y.fileawaretestlanguage", PackageDeclaration.class);
    final ChangeSerializer serializer = this.serializerProvider.get();
    serializer.beginRecordChanges(model1.eResource());
    serializer.beginRecordChanges(model2.eResource());
    model1.setName("foo2");
    model2.setName("foo2.bar");
    Collection<IEmfResourceChange> _endRecordChangesToTextDocuments = this._importTestHelper.endRecordChangesToTextDocuments(serializer);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("-------- inmemory:/foo/X.fileawaretestlanguage (syntax: <offset|text>) ---------");
    _builder_2.newLine();
    _builder_2.append("package <8:3|foo2> ");
    _builder_2.newLine();
    _builder_2.append("element X {}");
    _builder_2.newLine();
    _builder_2.append("--------------------------------------------------------------------------------");
    _builder_2.newLine();
    _builder_2.append("8 3 \"foo\" -> \"foo2\"");
    _builder_2.newLine();
    _builder_2.append("------ inmemory:/foo/bar/Y.fileawaretestlanguage (syntax: <offset|text>) -------");
    _builder_2.newLine();
    _builder_2.append("package <8:7|foo2.bar><15:2|");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("import foo2.X");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append(">element Y { ref <33:5|X> }");
    _builder_2.newLine();
    _builder_2.append("--------------------------------------------------------------------------------");
    _builder_2.newLine();
    _builder_2.append(" ");
    _builder_2.append("8 7 \"foo.bar\" -> \"foo2.bar\"");
    _builder_2.newLine();
    _builder_2.append("15 2 \" \\n\" -> \"\\n\\nimport foo2.X\\n\\n\"");
    _builder_2.newLine();
    _builder_2.append("33 5 \"foo.X\" -> \"X\"");
    _builder_2.newLine();
    this._importTestHelper.operator_tripleEquals(_endRecordChangesToTextDocuments, _builder_2);
  }
}
