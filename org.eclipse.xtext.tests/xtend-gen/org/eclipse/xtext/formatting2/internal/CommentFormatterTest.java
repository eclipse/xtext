/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.internal;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.internal.GenericFormatter;
import org.eclipse.xtext.formatting2.internal.GenericFormatterTestRequest;
import org.eclipse.xtext.formatting2.internal.GenericFormatterTester;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList;
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FormatterTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class CommentFormatterTest {
  @Inject
  @Extension
  private GenericFormatterTester _genericFormatterTester;
  
  @Test
  public void SL_inline() {
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("idlist  //x");
      _builder.newLine();
      _builder.append("a");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      final GenericFormatter<IDList> _function_1 = new GenericFormatter<IDList>() {
        @Override
        protected void format(final IDList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
            it_1.oneSpace();
          };
          document.append(regions.regionFor(model).keyword("idlist"), _function);
        }
      };
      it.setFormatter(_function_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("idlist //x");
      _builder_1.newLine();
      _builder_1.append("a");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
  
  @Test
  public void SL_multiline() {
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("idlist  ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("//x");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("a");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      final GenericFormatter<IDList> _function_1 = new GenericFormatter<IDList>() {
        @Override
        protected void format(final IDList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
            it_1.oneSpace();
          };
          document.append(regions.regionFor(model).keyword("idlist"), _function);
        }
      };
      it.setFormatter(_function_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("idlist //x");
      _builder_1.newLine();
      _builder_1.append("a");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
  
  @Test
  public void MLSL_inline() {
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("idlist  /*x*/  a");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      final GenericFormatter<IDList> _function_1 = new GenericFormatter<IDList>() {
        @Override
        protected void format(final IDList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
            it_1.oneSpace();
          };
          document.append(regions.regionFor(model).keyword("idlist"), _function);
        }
      };
      it.setFormatter(_function_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("idlist /*x*/ a");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
  
  @Test
  public void MLSL_paragraph() {
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("idlist");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("/*x*/");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("a");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      final GenericFormatter<IDList> _function_1 = new GenericFormatter<IDList>() {
        @Override
        protected void format(final IDList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
            it_1.oneSpace();
          };
          document.append(regions.regionFor(model).keyword("idlist"), _function);
        }
      };
      it.setFormatter(_function_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("idlist /*x*/");
      _builder_1.newLine();
      _builder_1.append("a");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
  
  @Test
  public void MLML_inline() {
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("idlist  /*");
      _builder.newLine();
      _builder.append("x");
      _builder.newLine();
      _builder.append("*/  a");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      final GenericFormatter<IDList> _function_1 = new GenericFormatter<IDList>() {
        @Override
        protected void format(final IDList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
            it_1.oneSpace();
          };
          document.append(regions.regionFor(model).keyword("idlist"), _function);
        }
      };
      it.setFormatter(_function_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("idlist");
      _builder_1.newLine();
      _builder_1.append("/*");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("* x");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("*/");
      _builder_1.newLine();
      _builder_1.append("a");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
  
  @Test
  public void MLML_paragraph() {
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("idlist");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("/*");
      _builder.newLine();
      _builder.append("x");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("a");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      final GenericFormatter<IDList> _function_1 = new GenericFormatter<IDList>() {
        @Override
        protected void format(final IDList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
            it_1.oneSpace();
          };
          document.append(regions.regionFor(model).keyword("idlist"), _function);
        }
      };
      it.setFormatter(_function_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("idlist");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("/*");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("* x");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("*/");
      _builder_1.newLine();
      _builder_1.append("a");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
}
