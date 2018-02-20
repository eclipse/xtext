/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsp4j.DocumentFormattingParams;
import org.eclipse.lsp4j.DocumentRangeFormattingParams;
import org.eclipse.lsp4j.FormattingOptions;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.formatting.FormattingService;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.FormattingConfiguration;
import org.eclipse.xtext.testing.RangeFormattingConfiguration;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link FormattingService}
 * 
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class FormattingTest extends AbstractTestLangLanguageServerTest {
  public static class FormattingService2 extends FormattingService {
    @Override
    public List<TextEdit> format(final XtextResource resource, final Document document, final int offset, final int length) {
      throw new IllegalStateException("api maintenance layer broken");
    }
  }
  
  public static class AbstractCustomFormattingService extends FormattingService {
    @Override
    public List<TextEdit> format(final XtextResource resource, final Document document, final int offset, final int length) {
      throw new IllegalStateException("api maintenance layer broken");
    }
  }
  
  public static class FormattingService3 extends FormattingTest.AbstractCustomFormattingService {
  }
  
  @Test
  public void testFormattingService() {
    final Procedure1<FormattingConfiguration> _function = (FormattingConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo{int bar} type Bar{Foo foo}");
      it.setModel(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type Foo{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("int bar");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("type Bar{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo foo");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      it.setExpectedText(_builder_1.toString());
    };
    this.testFormatting(_function);
  }
  
  @Test
  public void testFormattingService_02() {
    final Procedure1<DocumentFormattingParams> _function = (DocumentFormattingParams it) -> {
      FormattingOptions _formattingOptions = new FormattingOptions(4, true);
      it.setOptions(_formattingOptions);
    };
    final Procedure1<FormattingConfiguration> _function_1 = (FormattingConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo{int bar} type Bar{Foo foo}");
      it.setModel(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type Foo{");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("int bar");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("type Bar{");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("Foo foo");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      it.setExpectedText(_builder_1.toString());
    };
    this.testFormatting(_function, _function_1);
  }
  
  @Test
  public void testFormattingClosedFile() {
    final Procedure1<FormattingConfiguration> _function = (FormattingConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo{int bar} type Bar{Foo foo}");
      Pair<String, String> _mappedTo = Pair.<String, String>of("foo.testlang", _builder.toString());
      it.setFilesInScope(Collections.<String, CharSequence>unmodifiableMap(CollectionLiterals.<String, CharSequence>newHashMap(_mappedTo)));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type Foo{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("int bar");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("type Bar{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo foo");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      it.setExpectedText(_builder_1.toString());
    };
    this.testFormatting(_function);
  }
  
  @Test
  public void testRangeFormattingService() {
    final Procedure1<RangeFormattingConfiguration> _function = (RangeFormattingConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo{int bar} type Bar{Foo foo}");
      it.setModel(_builder.toString());
      Range _range = new Range();
      final Procedure1<Range> _function_1 = (Range it_1) -> {
        Position _position = new Position(0, 0);
        it_1.setStart(_position);
        Position _position_1 = new Position(0, 17);
        it_1.setEnd(_position_1);
      };
      Range _doubleArrow = ObjectExtensions.<Range>operator_doubleArrow(_range, _function_1);
      it.setRange(_doubleArrow);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type Foo{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("int bar");
      _builder_1.newLine();
      _builder_1.append("} type Bar{Foo foo}");
      it.setExpectedText(_builder_1.toString());
    };
    this.testRangeFormatting(_function);
  }
  
  @Test
  public void testRangeFormattingService_02() {
    final Procedure1<DocumentRangeFormattingParams> _function = (DocumentRangeFormattingParams it) -> {
      FormattingOptions _formattingOptions = new FormattingOptions(4, true);
      it.setOptions(_formattingOptions);
    };
    final Procedure1<RangeFormattingConfiguration> _function_1 = (RangeFormattingConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo{int bar} type Bar{Foo foo}");
      it.setModel(_builder.toString());
      Range _range = new Range();
      final Procedure1<Range> _function_2 = (Range it_1) -> {
        Position _position = new Position(0, 0);
        it_1.setStart(_position);
        Position _position_1 = new Position(0, 17);
        it_1.setEnd(_position_1);
      };
      Range _doubleArrow = ObjectExtensions.<Range>operator_doubleArrow(_range, _function_2);
      it.setRange(_doubleArrow);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type Foo{");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("int bar");
      _builder_1.newLine();
      _builder_1.append("} type Bar{Foo foo}");
      it.setExpectedText(_builder_1.toString());
    };
    this.testRangeFormatting(_function, _function_1);
  }
  
  @Inject
  private Provider<XtextResourceSet> rsp;
  
  @Inject
  private Provider<FormattingTest.FormattingService2> fs2p;
  
  @Test
  public void testAPIMaintenance_01() {
    final FormattingTest.FormattingService2 fs2 = this.fs2p.get();
    this.doTestAPIMaintenanceLayer(fs2);
  }
  
  @Inject
  private Provider<FormattingTest.FormattingService3> fs3p;
  
  @Test
  public void testAPIMaintenance_02() {
    final FormattingTest.FormattingService3 fs3 = this.fs3p.get();
    this.doTestAPIMaintenanceLayer(fs3);
  }
  
  private void doTestAPIMaintenanceLayer(final FormattingService fs) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo{int bar} type Bar{Foo foo}");
      final String model = _builder.toString();
      final XtextResourceSet rs = this.rsp.get();
      Resource _createResource = rs.createResource(URI.createURI("dummy.testlang"));
      final XtextResource r = ((XtextResource) _createResource);
      StringInputStream _stringInputStream = new StringInputStream(model);
      r.load(_stringInputStream, null);
      try {
        Document _document = new Document(1, model);
        DocumentFormattingParams _documentFormattingParams = new DocumentFormattingParams();
        fs.format(_document, r, _documentFormattingParams, CancelIndicator.NullImpl);
        Assert.fail("IllegalStateException expected");
      } catch (final Throwable _t) {
        if (_t instanceof IllegalStateException) {
          final IllegalStateException e = (IllegalStateException)_t;
          String _message = e.getMessage();
          boolean _notEquals = (!Objects.equal(_message, "api maintenance layer broken"));
          if (_notEquals) {
            throw e;
          }
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
