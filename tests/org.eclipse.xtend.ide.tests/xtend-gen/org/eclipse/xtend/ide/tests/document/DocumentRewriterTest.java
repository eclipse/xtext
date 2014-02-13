package org.eclipse.xtend.ide.tests.document;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtend.core.parser.antlr.XtendAntlrTokenFileProvider;
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory;
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;
import org.eclipse.xtend.ide.editor.model.XtendDocumentTokenSource;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
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
  
  @Test
  public void testSectionOverlap() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//***********");
    _builder.newLine();
    final Procedure2<DocumentRewriter,XtextResource> _function = new Procedure2<DocumentRewriter,XtextResource>() {
      public void apply(final DocumentRewriter it, final XtextResource r) {
        DocumentRewriter.Section _newSection = it.newSection(3, 1);
        _newSection.append("one");
        DocumentRewriter.Section _newSection_1 = it.newSection(4, 2);
        _newSection_1.append("two");
        DocumentRewriter.Section _newSection_2 = it.newSection(6, 1);
        _newSection_2.append("three");
        final Procedure1<DocumentRewriter> _function = new Procedure1<DocumentRewriter>() {
          public void apply(final DocumentRewriter it) {
            it.newSection(4, 2);
          }
        };
        DocumentRewriterTest.this.assertFails(it, _function);
        final Procedure1<DocumentRewriter> _function_1 = new Procedure1<DocumentRewriter>() {
          public void apply(final DocumentRewriter it) {
            it.newSection(5, 0);
          }
        };
        DocumentRewriterTest.this.assertFails(it, _function_1);
        final Procedure1<DocumentRewriter> _function_2 = new Procedure1<DocumentRewriter>() {
          public void apply(final DocumentRewriter it) {
            it.newSection(5, 1);
          }
        };
        DocumentRewriterTest.this.assertFails(it, _function_2);
        final Procedure1<DocumentRewriter> _function_3 = new Procedure1<DocumentRewriter>() {
          public void apply(final DocumentRewriter it) {
            it.newSection(5, 2);
          }
        };
        DocumentRewriterTest.this.assertFails(it, _function_3);
        final Procedure1<DocumentRewriter> _function_4 = new Procedure1<DocumentRewriter>() {
          public void apply(final DocumentRewriter it) {
            it.newSection(6, 0);
          }
        };
        DocumentRewriterTest.this.assertFails(it, _function_4);
        final Procedure1<DocumentRewriter> _function_5 = new Procedure1<DocumentRewriter>() {
          public void apply(final DocumentRewriter it) {
            it.newSection(6, 1);
          }
        };
        DocumentRewriterTest.this.assertFails(it, _function_5);
        final Procedure1<DocumentRewriter> _function_6 = new Procedure1<DocumentRewriter>() {
          public void apply(final DocumentRewriter it) {
            it.newSection(6, 2);
          }
        };
        DocumentRewriterTest.this.assertFails(it, _function_6);
      }
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
    final Procedure2<DocumentRewriter,XtextResource> _function = new Procedure2<DocumentRewriter,XtextResource>() {
      public void apply(final DocumentRewriter it, final XtextResource r) {
        DocumentRewriter.Section _newSection = it.newSection(6, 1);
        _newSection.append("one");
        DocumentRewriter.Section _newSection_1 = it.newSection(4, 2);
        _newSection_1.append("two");
        DocumentRewriter.Section _newSection_2 = it.newSection(3, 1);
        _newSection_2.append("three");
        final Procedure1<DocumentRewriter> _function = new Procedure1<DocumentRewriter>() {
          public void apply(final DocumentRewriter it) {
            it.newSection(4, 2);
          }
        };
        DocumentRewriterTest.this.assertFails(it, _function);
        final Procedure1<DocumentRewriter> _function_1 = new Procedure1<DocumentRewriter>() {
          public void apply(final DocumentRewriter it) {
            it.newSection(5, 0);
          }
        };
        DocumentRewriterTest.this.assertFails(it, _function_1);
        final Procedure1<DocumentRewriter> _function_2 = new Procedure1<DocumentRewriter>() {
          public void apply(final DocumentRewriter it) {
            it.newSection(5, 1);
          }
        };
        DocumentRewriterTest.this.assertFails(it, _function_2);
        final Procedure1<DocumentRewriter> _function_3 = new Procedure1<DocumentRewriter>() {
          public void apply(final DocumentRewriter it) {
            it.newSection(5, 2);
          }
        };
        DocumentRewriterTest.this.assertFails(it, _function_3);
        final Procedure1<DocumentRewriter> _function_4 = new Procedure1<DocumentRewriter>() {
          public void apply(final DocumentRewriter it) {
            it.newSection(6, 0);
          }
        };
        DocumentRewriterTest.this.assertFails(it, _function_4);
        final Procedure1<DocumentRewriter> _function_5 = new Procedure1<DocumentRewriter>() {
          public void apply(final DocumentRewriter it) {
            it.newSection(6, 1);
          }
        };
        DocumentRewriterTest.this.assertFails(it, _function_5);
        final Procedure1<DocumentRewriter> _function_6 = new Procedure1<DocumentRewriter>() {
          public void apply(final DocumentRewriter it) {
            it.newSection(6, 2);
          }
        };
        DocumentRewriterTest.this.assertFails(it, _function_6);
      }
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
    final Procedure2<DocumentRewriter,XtextResource> _function = new Procedure2<DocumentRewriter,XtextResource>() {
      public void apply(final DocumentRewriter it, final XtextResource r) {
        int _indexOf = model.indexOf("class");
        DocumentRewriter.Section _newSection = it.newSection(_indexOf, 0);
        _newSection.append("abstract ");
        int _indexOf_1 = model.indexOf("foo");
        DocumentRewriter.Section _newSection_1 = it.newSection(_indexOf_1, 0);
        _newSection_1.append("static ");
        int _indexOf_2 = model.indexOf("bar");
        DocumentRewriter.Section _newSection_2 = it.newSection(_indexOf_2, 0);
        _newSection_2.append("private int ");
        int _lastIndexOf = model.lastIndexOf("{}");
        DocumentRewriter.Section _newSection_3 = it.newSection(_lastIndexOf, 2);
        _newSection_3.append("{ 42 }");
      }
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
    final Procedure2<DocumentRewriter,XtextResource> _function = new Procedure2<DocumentRewriter,XtextResource>() {
      public void apply(final DocumentRewriter it, final XtextResource r) {
        int _indexOf = model.indexOf("foo");
        final DocumentRewriter.Section beforeFoo = it.newSection(_indexOf, 0);
        TypeReferences _typeReferences = DocumentRewriterTest.this.services.getTypeReferences();
        JvmType _findDeclaredType = _typeReferences.findDeclaredType(Serializable.class, r);
        beforeFoo.append(_findDeclaredType);
        beforeFoo.append(" ");
      }
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
    final Procedure2<DocumentRewriter,XtextResource> _function = new Procedure2<DocumentRewriter,XtextResource>() {
      public void apply(final DocumentRewriter it, final XtextResource r) {
        int _indexOf = model.indexOf("foo");
        final DocumentRewriter.Section beforeFoo = it.newSection(_indexOf, 0);
        int _indexOf_1 = model.indexOf("bar");
        final DocumentRewriter.Section beforeBar = it.newSection(_indexOf_1, 0);
        final StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(DocumentRewriterTest.this.services, r);
        final OwnedConverter converter = new OwnedConverter(owner);
        TypeReferences _typeReferences = DocumentRewriterTest.this.services.getTypeReferences();
        JvmWildcardTypeReference _createJvmWildcardTypeReference = DocumentRewriterTest.this._typesFactory.createJvmWildcardTypeReference();
        final JvmTypeReference list = _typeReferences.getTypeForName(List.class, r, _createJvmWildcardTypeReference);
        LightweightTypeReference _apply = converter.apply(list);
        beforeFoo.append(_apply);
        TypeReferences _typeReferences_1 = DocumentRewriterTest.this.services.getTypeReferences();
        JvmTypeReference _typeForName = _typeReferences_1.getTypeForName(File.class, r);
        LightweightTypeReference _apply_1 = converter.apply(_typeForName);
        beforeBar.append(_apply_1);
        beforeFoo.append(" ");
        beforeBar.append(" ");
      }
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
    final Procedure2<DocumentRewriter,XtextResource> _function = new Procedure2<DocumentRewriter,XtextResource>() {
      public void apply(final DocumentRewriter it, final XtextResource r) {
        int _indexOf = model.indexOf("foo");
        final DocumentRewriter.Section beforeFoo = it.newSection(_indexOf, 0);
        int _indexOf_1 = model.indexOf("bar");
        final DocumentRewriter.Section beforeBar = it.newSection(_indexOf_1, 0);
        final StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(DocumentRewriterTest.this.services, r);
        final OwnedConverter converter = new OwnedConverter(owner);
        TypeReferences _typeReferences = DocumentRewriterTest.this.services.getTypeReferences();
        TypeReferences _typeReferences_1 = DocumentRewriterTest.this.services.getTypeReferences();
        JvmTypeReference _typeForName = _typeReferences_1.getTypeForName(String.class, r);
        JvmTypeReference _typeForName_1 = _typeReferences.getTypeForName(List.class, r, _typeForName);
        LightweightTypeReference _apply = converter.apply(_typeForName_1);
        beforeFoo.append(_apply);
        TypeReferences _typeReferences_2 = DocumentRewriterTest.this.services.getTypeReferences();
        TypeReferences _typeReferences_3 = DocumentRewriterTest.this.services.getTypeReferences();
        JvmTypeReference _typeForName_2 = _typeReferences_3.getTypeForName(File.class, r);
        JvmTypeReference _typeForName_3 = _typeReferences_2.getTypeForName(List.class, r, _typeForName_2);
        LightweightTypeReference _apply_1 = converter.apply(_typeForName_3);
        beforeBar.append(_apply_1);
        beforeFoo.append(" ");
        beforeBar.append(" ");
      }
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
    final Procedure2<DocumentRewriter,XtextResource> _function = new Procedure2<DocumentRewriter,XtextResource>() {
      public void apply(final DocumentRewriter it, final XtextResource r) {
        int _indexOf = model.indexOf("def bar");
        final DocumentRewriter.Section beforeDefBar = it.newSection(_indexOf, 0, true);
        beforeDefBar.append("val x = 42");
      }
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
    final String model = _builder.toString();
    final Procedure2<DocumentRewriter,XtextResource> _function = new Procedure2<DocumentRewriter,XtextResource>() {
      public void apply(final DocumentRewriter it, final XtextResource r) {
        int _indexOf = model.indexOf("{}");
        int _plus = (_indexOf + 3);
        DocumentRewriter.Section _newSection = it.newSection(_plus, 0, true);
        _newSection.append("val x = 42");
        int _lastIndexOf = model.lastIndexOf("{\n");
        int _plus_1 = (_lastIndexOf + 1);
        DocumentRewriter.Section _newSection_1 = it.newSection(_plus_1, 0, 2, true);
        _newSection_1.append("val y = 43");
        int _indexOf_1 = model.indexOf("\t}");
        int _plus_2 = (_indexOf_1 + 2);
        DocumentRewriter.Section _newSection_2 = it.newSection(_plus_2, 0, true);
        _newSection_2.append("val z = 44");
      }
    };
    String _rewrite = this.rewrite(model, _function);
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
    this.andExpect(_rewrite, _builder_1);
  }
  
  protected String rewrite(final CharSequence model, final Procedure2<? super DocumentRewriter,? super XtextResource> test) {
    try {
      String _xblockexpression = null;
      {
        String _string = model.toString();
        final XtextDocument document = this.createDocument(_string);
        final IUnitOfWork<TextEdit,XtextResource> _function = new IUnitOfWork<TextEdit,XtextResource>() {
          public TextEdit exec(final XtextResource it) throws Exception {
            TextEdit _xblockexpression = null;
            {
              final DocumentRewriter rewriter = DocumentRewriterTest.this.factory.create(document, it);
              test.apply(rewriter, it);
              List<ReplaceRegion> _changes = rewriter.getChanges();
              _xblockexpression = DocumentRewriterTest.this._replaceConverter.convertToTextEdit(_changes);
            }
            return _xblockexpression;
          }
        };
        TextEdit _readOnly = document.<TextEdit>readOnly(_function);
        _readOnly.apply(document);
        _xblockexpression = document.get();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void andExpect(final String model, final CharSequence expectation) {
    String _string = expectation.toString();
    Assert.assertEquals(_string, model);
  }
  
  protected Object assertFails(final DocumentRewriter it, final Procedure1<? super DocumentRewriter> procedure) {
    Object _xtrycatchfinallyexpression = null;
    try {
      procedure.apply(it);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception exc = (Exception)_t;
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
      ResourceSet _resourceSet = this._workbenchTestHelper.getResourceSet();
      IPath _fullPath = file.getFullPath();
      String _string = _fullPath.toString();
      URI _createPlatformResourceURI = URI.createPlatformResourceURI(_string, true);
      final Resource resource = _resourceSet.getResource(_createPlatformResourceURI, true);
      XtendDocumentTokenSource _xtendDocumentTokenSource = new XtendDocumentTokenSource();
      final Procedure1<XtendDocumentTokenSource> _function = new Procedure1<XtendDocumentTokenSource>() {
        public void apply(final XtendDocumentTokenSource it) {
          AntlrTokenDefProvider _antlrTokenDefProvider = new AntlrTokenDefProvider();
          final Procedure1<AntlrTokenDefProvider> _function = new Procedure1<AntlrTokenDefProvider>() {
            public void apply(final AntlrTokenDefProvider it) {
              XtendAntlrTokenFileProvider _xtendAntlrTokenFileProvider = new XtendAntlrTokenFileProvider();
              it.setAntlrTokenFileProvider(_xtendAntlrTokenFileProvider);
            }
          };
          AntlrTokenDefProvider _doubleArrow = ObjectExtensions.<AntlrTokenDefProvider>operator_doubleArrow(_antlrTokenDefProvider, _function);
          it.setTokenDefProvider(_doubleArrow);
          final Provider<Lexer> _function_1 = new Provider<Lexer>() {
            public Lexer get() {
              InternalXtendLexer _internalXtendLexer = new InternalXtendLexer();
              return ((Lexer) _internalXtendLexer);
            }
          };
          it.setLexer(_function_1);
          it.setFlexerFactory(DocumentRewriterTest.this.flexerFactory);
        }
      };
      final XtendDocumentTokenSource source = ObjectExtensions.<XtendDocumentTokenSource>operator_doubleArrow(_xtendDocumentTokenSource, _function);
      final XtextDocument document = new XtextDocument(source, null);
      document.set(content);
      document.setInput(((XtextResource) resource));
      _xblockexpression = document;
    }
    return _xblockexpression;
  }
}
