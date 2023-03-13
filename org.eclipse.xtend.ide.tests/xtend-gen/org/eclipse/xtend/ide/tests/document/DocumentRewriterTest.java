/**
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.document;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtend.core.parser.antlr.XtendAntlrTokenFileProvider;
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory;
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;
import org.eclipse.xtend.ide.editor.model.XtendDocumentTokenSource;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.resource.OutdatedStateManager;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.ui.document.DocumentRewriter;
import org.eclipse.xtext.xbase.ui.imports.ReplaceConverter;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class DocumentRewriterTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper _workbenchTestHelper;

  @Inject
  private DocumentRewriter.Factory factory;

  @Inject
  @Extension
  private ReplaceConverter _replaceConverter;

  @Inject
  @Extension
  private CommonTypeComputationServices services;

  @Inject
  @Extension
  private TypesFactory _typesFactory;

  @Inject
  private FlexerFactory flexerFactory;

  @Inject
  private OutdatedStateManager outdatedStateManager;

  @Inject
  private OperationCanceledManager operationCanceledManager;

  @Test
  public void testSectionOverlap() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//***********");
    _builder.newLine();
    final Procedure2<DocumentRewriter, XtextResource> _function = (DocumentRewriter it, XtextResource r) -> {
      it.newSection(3, 1).append("one");
      it.newSection(4, 2).append("two");
      it.newSection(6, 1).append("three");
      final Procedure1<DocumentRewriter> _function_1 = (DocumentRewriter it_1) -> {
        it_1.newSection(4, 2);
      };
      this.assertFails(it, _function_1);
      final Procedure1<DocumentRewriter> _function_2 = (DocumentRewriter it_1) -> {
        it_1.newSection(5, 0);
      };
      this.assertFails(it, _function_2);
      final Procedure1<DocumentRewriter> _function_3 = (DocumentRewriter it_1) -> {
        it_1.newSection(5, 1);
      };
      this.assertFails(it, _function_3);
      final Procedure1<DocumentRewriter> _function_4 = (DocumentRewriter it_1) -> {
        it_1.newSection(5, 2);
      };
      this.assertFails(it, _function_4);
      final Procedure1<DocumentRewriter> _function_5 = (DocumentRewriter it_1) -> {
        it_1.newSection(6, 0);
      };
      this.assertFails(it, _function_5);
      final Procedure1<DocumentRewriter> _function_6 = (DocumentRewriter it_1) -> {
        it_1.newSection(6, 1);
      };
      this.assertFails(it, _function_6);
      final Procedure1<DocumentRewriter> _function_7 = (DocumentRewriter it_1) -> {
        it_1.newSection(6, 2);
      };
      this.assertFails(it, _function_7);
    };
    String _rewrite = this.rewrite(_builder, _function);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("//*onetwothree******");
    _builder_1.newLine();
    this.andExpect(_rewrite, _builder_1);
  }

  @Test
  public void testSectionOrderIrrelevant() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//***********");
    _builder.newLine();
    final Procedure2<DocumentRewriter, XtextResource> _function = (DocumentRewriter it, XtextResource r) -> {
      it.newSection(6, 1).append("one");
      it.newSection(4, 2).append("two");
      it.newSection(3, 1).append("three");
      final Procedure1<DocumentRewriter> _function_1 = (DocumentRewriter it_1) -> {
        it_1.newSection(4, 2);
      };
      this.assertFails(it, _function_1);
      final Procedure1<DocumentRewriter> _function_2 = (DocumentRewriter it_1) -> {
        it_1.newSection(5, 0);
      };
      this.assertFails(it, _function_2);
      final Procedure1<DocumentRewriter> _function_3 = (DocumentRewriter it_1) -> {
        it_1.newSection(5, 1);
      };
      this.assertFails(it, _function_3);
      final Procedure1<DocumentRewriter> _function_4 = (DocumentRewriter it_1) -> {
        it_1.newSection(5, 2);
      };
      this.assertFails(it, _function_4);
      final Procedure1<DocumentRewriter> _function_5 = (DocumentRewriter it_1) -> {
        it_1.newSection(6, 0);
      };
      this.assertFails(it, _function_5);
      final Procedure1<DocumentRewriter> _function_6 = (DocumentRewriter it_1) -> {
        it_1.newSection(6, 1);
      };
      this.assertFails(it, _function_6);
      final Procedure1<DocumentRewriter> _function_7 = (DocumentRewriter it_1) -> {
        it_1.newSection(6, 2);
      };
      this.assertFails(it, _function_7);
    };
    String _rewrite = this.rewrite(_builder, _function);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("//*threetwoone******");
    _builder_1.newLine();
    this.andExpect(_rewrite, _builder_1);
  }

  @Test
  public void testInsertText() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String model = _builder.toString();
    final Procedure2<DocumentRewriter, XtextResource> _function = (DocumentRewriter it, XtextResource r) -> {
      it.newSection(model.indexOf("class"), 0).append("abstract ");
      it.newSection(model.indexOf("foo"), 0).append("static ");
      it.newSection(model.indexOf("bar"), 0).append("private int ");
      it.newSection(model.lastIndexOf("{}"), 2).append("{ 42 }");
    };
    String _rewrite = this.rewrite(model, _function);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("abstract class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def static foo() {}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def private int bar() { 42 }");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.andExpect(_rewrite, _builder_1);
  }

  @Test
  public void testInsertExistingType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.Serializable");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo implements Serializable {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String model = _builder.toString();
    final Procedure2<DocumentRewriter, XtextResource> _function = (DocumentRewriter it, XtextResource r) -> {
      final DocumentRewriter.Section beforeFoo = it.newSection(model.indexOf("foo"), 0);
      beforeFoo.append(this.services.getTypeReferences().findDeclaredType(Serializable.class, r));
      beforeFoo.append(" ");
    };
    String _rewrite = this.rewrite(model, _function);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.io.Serializable");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo implements Serializable {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def Serializable foo() {}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.andExpect(_rewrite, _builder_1);
  }

  @Test
  public void testInsertTypesImportsSorted() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.Serializable");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo implements Serializable {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String model = _builder.toString();
    final Procedure2<DocumentRewriter, XtextResource> _function = (DocumentRewriter it, XtextResource r) -> {
      final DocumentRewriter.Section beforeFoo = it.newSection(model.indexOf("foo"), 0);
      final DocumentRewriter.Section beforeBar = it.newSection(model.indexOf("bar"), 0);
      final StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(this.services, r);
      final JvmTypeReference list = this.services.getTypeReferences().getTypeForName(List.class, r, this._typesFactory.createJvmWildcardTypeReference());
      beforeFoo.append(owner.toLightweightTypeReference(list));
      beforeBar.append(owner.toLightweightTypeReference(this.services.getTypeReferences().getTypeForName(File.class, r)));
      beforeFoo.append(" ");
      beforeBar.append(" ");
    };
    String _rewrite = this.rewrite(model, _function);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.io.File");
    _builder_1.newLine();
    _builder_1.append("import java.io.Serializable");
    _builder_1.newLine();
    _builder_1.append("import java.util.List");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo implements Serializable {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def List<?> foo() {}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def File bar() {}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.andExpect(_rewrite, _builder_1);
  }

  @Test
  public void testInsertTypesWithOverlappingImports() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String model = _builder.toString();
    final Procedure2<DocumentRewriter, XtextResource> _function = (DocumentRewriter it, XtextResource r) -> {
      final DocumentRewriter.Section beforeFoo = it.newSection(model.indexOf("foo"), 0);
      final DocumentRewriter.Section beforeBar = it.newSection(model.indexOf("bar"), 0);
      final StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(this.services, r);
      beforeFoo.append(owner.toLightweightTypeReference(this.services.getTypeReferences().getTypeForName(List.class, r, this.services.getTypeReferences().getTypeForName(String.class, r))));
      beforeBar.append(owner.toLightweightTypeReference(this.services.getTypeReferences().getTypeForName(List.class, r, this.services.getTypeReferences().getTypeForName(File.class, r))));
      beforeFoo.append(" ");
      beforeBar.append(" ");
    };
    String _rewrite = this.rewrite(model, _function);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.io.File");
    _builder_1.newLine();
    _builder_1.append("import java.util.List");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def List<String> foo() {}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def List<File> bar() {}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.andExpect(_rewrite, _builder_1);
  }

  @Test
  public void testEmptyLinesAround() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String model = _builder.toString();
    final Procedure2<DocumentRewriter, XtextResource> _function = (DocumentRewriter it, XtextResource r) -> {
      final DocumentRewriter.Section beforeDefBar = it.newSection(model.indexOf("def bar"), 0, true);
      beforeDefBar.append("val x = 42");
    };
    String _rewrite = this.rewrite(model, _function);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val x = 42");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.andExpect(_rewrite, _builder_1);
  }

  @Test
  public void testWhitespaces() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String model = Strings.toUnixLineSeparator(_builder);
    final Procedure2<DocumentRewriter, XtextResource> _function = (DocumentRewriter it, XtextResource r) -> {
      int _indexOf = model.indexOf("{}");
      int _plus = (_indexOf + 3);
      it.newSection(_plus, 0, true).append("val x = 42");
      int _lastIndexOf = model.lastIndexOf("{\n");
      int _plus_1 = (_lastIndexOf + 1);
      it.newSection(_plus_1, 0, 2, true).append("val y = 43");
      int _indexOf_1 = model.indexOf("\t}");
      int _plus_2 = (_indexOf_1 + 2);
      it.newSection(_plus_2, 0, true).append("val z = 44");
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val x = 42");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val y = 43");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val z = 44");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.andExpect(this.rewrite(model, _function), Strings.toUnixLineSeparator(_builder_1));
  }

  protected String rewrite(final CharSequence model, final Procedure2<? super DocumentRewriter, ? super XtextResource> test) {
    try {
      String _xblockexpression = null;
      {
        final XtextDocument document = this.createDocument(model.toString());
        final IUnitOfWork<TextEdit, XtextResource> _function = (XtextResource it) -> {
          TextEdit _xblockexpression_1 = null;
          {
            final DocumentRewriter rewriter = this.factory.create(document, it);
            test.apply(rewriter, it);
            _xblockexpression_1 = this._replaceConverter.convertToTextEdit(rewriter.getChanges());
          }
          return _xblockexpression_1;
        };
        document.<TextEdit>readOnly(_function).apply(document);
        _xblockexpression = document.get();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected void andExpect(final String model, final CharSequence expectation) {
    Assert.assertEquals(expectation.toString(), model);
  }

  protected Object assertFails(final DocumentRewriter it, final Procedure1<? super DocumentRewriter> procedure) {
    Object _xtrycatchfinallyexpression = null;
    try {
      procedure.apply(it);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        _xtrycatchfinallyexpression = null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }

  protected XtextDocument createDocument(final String content) throws Exception {
    XtextDocument _xblockexpression = null;
    {
      final IFile file = this._workbenchTestHelper.createFile("Foo", content);
      final Resource resource = this._workbenchTestHelper.getResourceSet().getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), true);
      XtendDocumentTokenSource _xtendDocumentTokenSource = new XtendDocumentTokenSource();
      final Procedure1<XtendDocumentTokenSource> _function = (XtendDocumentTokenSource it) -> {
        AntlrTokenDefProvider _antlrTokenDefProvider = new AntlrTokenDefProvider();
        final Procedure1<AntlrTokenDefProvider> _function_1 = (AntlrTokenDefProvider it_1) -> {
          XtendAntlrTokenFileProvider _xtendAntlrTokenFileProvider = new XtendAntlrTokenFileProvider();
          it_1.setAntlrTokenFileProvider(_xtendAntlrTokenFileProvider);
        };
        AntlrTokenDefProvider _doubleArrow = ObjectExtensions.<AntlrTokenDefProvider>operator_doubleArrow(_antlrTokenDefProvider, _function_1);
        it.setTokenDefProvider(_doubleArrow);
        final Provider<Lexer> _function_2 = () -> {
          InternalXtendLexer _internalXtendLexer = new InternalXtendLexer();
          return ((Lexer) _internalXtendLexer);
        };
        it.setLexer(_function_2);
        it.setFlexerFactory(this.flexerFactory);
      };
      final XtendDocumentTokenSource source = ObjectExtensions.<XtendDocumentTokenSource>operator_doubleArrow(_xtendDocumentTokenSource, _function);
      final XtextDocument document = new XtextDocument(source, null, this.outdatedStateManager, this.operationCanceledManager);
      document.set(content);
      document.setInput(((XtextResource) resource));
      _xblockexpression = document;
    }
    return _xblockexpression;
  }
}
