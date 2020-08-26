/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.internal;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.IAutowrapFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.internal.GenericFormatter;
import org.eclipse.xtext.formatting2.internal.GenericFormatterTestRequest;
import org.eclipse.xtext.formatting2.internal.GenericFormatterTester;
import org.eclipse.xtext.formatting2.internal.WhitespaceReplacer;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList;
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
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
public class CommentWithSpacesFormatterTest {
  public static class CustomFormatter extends GenericFormatter<IDList> {
    @Override
    public void format(final IDList model, final ITextRegionExtensions regionAccess, @Extension final IFormattableDocument document) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
        it.setNewLines(0);
        it.highPriority();
      };
      document.append(document.append(this.textRegionExtensions.regionFor(model).keyword("idlist"), _function), _function_1);
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
        it.setNewLines(0, 1, 2);
      };
      document.append(this.textRegionExtensions.regionFor(model).keyword("idlist").getNextSemanticRegion(), _function_2);
    }
  }
  
  public static class TabsAndSpacesSupportingFormatter extends CommentWithSpacesFormatterTest.CustomFormatter {
    @Override
    public ITextReplacer createWhitespaceReplacer(final ITextSegment hiddens, final IHiddenRegionFormatting formatting) {
      return new CommentWithSpacesFormatterTest.TabAndSpacesSupportingWhiteSpaceReplacer(hiddens, formatting);
    }
  }
  
  private static class TabAndSpacesSupportingWhiteSpaceReplacer extends WhitespaceReplacer {
    public TabAndSpacesSupportingWhiteSpaceReplacer(final ITextSegment whitespace, final IHiddenRegionFormatting formatting) {
      super(whitespace, formatting);
    }
    
    /**
     * Copied from {@link WhitespaceReplacer}
     */
    @Override
    public ITextReplacerContext createReplacements(final ITextReplacerContext context) {
      if (((this.getFormatting().getAutowrap() != null) && ((this.getFormatting().getAutowrap()).intValue() >= 0))) {
        context.setCanAutowrap(this.getFormatting().getAutowrap());
      }
      final String space = this.getFormatting().getSpace();
      final int trailingNewLinesOfPreviousRegion = this.trailingNewLinesOfPreviousRegion();
      final int computedNewLineCount = this.computeNewLineCount(context);
      int newLineCount = Math.max((computedNewLineCount - trailingNewLinesOfPreviousRegion), 0);
      if (((newLineCount == 0) && context.isAutowrap())) {
        final IAutowrapFormatter onAutowrap = this.getFormatting().getOnAutowrap();
        if ((onAutowrap != null)) {
          onAutowrap.format(this.getRegion(), this.getFormatting(), context.getDocument());
        }
        newLineCount = 1;
      }
      final int indentationCount = this.computeNewIndentation(context);
      if (((newLineCount == 0) && (trailingNewLinesOfPreviousRegion == 0))) {
        if ((space != null)) {
          context.addReplacement(this.getRegion().replaceWith(space));
        }
      } else {
        Boolean _noIndentation = this.getFormatting().getNoIndentation();
        final boolean noIndentation = Objects.equal(_noIndentation, Boolean.TRUE);
        final String newLines = context.getNewLinesString(newLineCount);
        String _xifexpression = null;
        if (noIndentation) {
          _xifexpression = "";
        } else {
          _xifexpression = context.getIndentationString(indentationCount);
        }
        final String indentation = _xifexpression;
        final boolean addSpace = ((trailingNewLinesOfPreviousRegion == 0) && (space != null));
        ITextSegment _region = this.getRegion();
        String _xifexpression_1 = null;
        if (addSpace) {
          _xifexpression_1 = space;
        } else {
          _xifexpression_1 = "";
        }
        String _plus = ((newLines + indentation) + _xifexpression_1);
        context.addReplacement(_region.replaceWith(_plus));
      }
      return context.withIndentation(indentationCount);
    }
  }
  
  @Inject
  @Extension
  private GenericFormatterTester _genericFormatterTester;
  
  @Test
  public void SL_inline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("idlist  //x");
    _builder.newLine();
    _builder.append("a");
    _builder.newLine();
    final String input = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("idlist //x");
    _builder_1.newLine();
    _builder_1.append("a");
    _builder_1.newLine();
    final String output = _builder_1.toString();
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter _tabsAndSpacesSupportingFormatter = new CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter();
      it.setFormatter(_tabsAndSpacesSupportingFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function);
    final Procedure1<GenericFormatterTestRequest> _function_1 = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.CustomFormatter _customFormatter = new CommentWithSpacesFormatterTest.CustomFormatter();
      it.setFormatter(_customFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function_1);
  }
  
  @Test
  public void SL_multiline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("idlist");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//x");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("a");
    _builder.newLine();
    final String input = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("idlist //x");
    _builder_1.newLine();
    _builder_1.append("a");
    _builder_1.newLine();
    final String output = _builder_1.toString();
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter _tabsAndSpacesSupportingFormatter = new CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter();
      it.setFormatter(_tabsAndSpacesSupportingFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function);
    final Procedure1<GenericFormatterTestRequest> _function_1 = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.CustomFormatter _customFormatter = new CommentWithSpacesFormatterTest.CustomFormatter();
      it.setFormatter(_customFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function_1);
  }
  
  @Test
  public void MLSL_inline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("idlist  /*x*/  a");
    _builder.newLine();
    final String input = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("idlist /*x*/ a");
    _builder_1.newLine();
    final String output = _builder_1.toString();
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter _tabsAndSpacesSupportingFormatter = new CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter();
      it.setFormatter(_tabsAndSpacesSupportingFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function);
    final Procedure1<GenericFormatterTestRequest> _function_1 = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.CustomFormatter _customFormatter = new CommentWithSpacesFormatterTest.CustomFormatter();
      it.setFormatter(_customFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function_1);
  }
  
  @Test
  public void MLSLOnSecondLine() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("idlist a");
    _builder.newLine();
    _builder.append("/*x*/");
    _builder.newLine();
    final String input = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("idlist a");
    _builder_1.newLine();
    _builder_1.append("/*x*/");
    _builder_1.newLine();
    final String output = _builder_1.toString();
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter _tabsAndSpacesSupportingFormatter = new CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter();
      it.setFormatter(_tabsAndSpacesSupportingFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function);
    final Procedure1<GenericFormatterTestRequest> _function_1 = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.CustomFormatter _customFormatter = new CommentWithSpacesFormatterTest.CustomFormatter();
      it.setFormatter(_customFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function_1);
  }
  
  @Test
  public void MLSL_paragraph() {
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
    final String input = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("idlist /*x*/");
    _builder_1.newLine();
    _builder_1.append("a");
    _builder_1.newLine();
    final String output = _builder_1.toString();
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter _tabsAndSpacesSupportingFormatter = new CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter();
      it.setFormatter(_tabsAndSpacesSupportingFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function);
    final Procedure1<GenericFormatterTestRequest> _function_1 = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.CustomFormatter _customFormatter = new CommentWithSpacesFormatterTest.CustomFormatter();
      it.setFormatter(_customFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function_1);
  }
  
  @Test
  public void MLML_inline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("idlist  /*");
    _builder.newLine();
    _builder.append("x");
    _builder.newLine();
    _builder.append("*/  a");
    _builder.newLine();
    final String input = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("idlist");
    _builder_1.newLine();
    _builder_1.append("/*");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* x");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/ a");
    _builder_1.newLine();
    final String output = _builder_1.toString();
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter _tabsAndSpacesSupportingFormatter = new CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter();
      it.setFormatter(_tabsAndSpacesSupportingFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function);
    final Procedure1<GenericFormatterTestRequest> _function_1 = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.CustomFormatter _customFormatter = new CommentWithSpacesFormatterTest.CustomFormatter();
      it.setFormatter(_customFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function_1);
  }
  
  @Test
  public void MLML_paragraph() {
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
    _builder.append("b");
    _builder.newLine();
    final String input = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("idlist /*");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* x");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("a");
    _builder_1.newLine();
    _builder_1.append("b");
    _builder_1.newLine();
    final String output = _builder_1.toString();
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter _tabsAndSpacesSupportingFormatter = new CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter();
      it.setFormatter(_tabsAndSpacesSupportingFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function);
    final Procedure1<GenericFormatterTestRequest> _function_1 = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.CustomFormatter _customFormatter = new CommentWithSpacesFormatterTest.CustomFormatter();
      it.setFormatter(_customFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function_1);
  }
  
  @Test
  public void MLOverOneLineSLML() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("idlist  /* i");
    _builder.newLine();
    _builder.append("j *//*y*/  a");
    _builder.newLine();
    final String input = _builder.toString();
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter _tabsAndSpacesSupportingFormatter = new CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter();
      it.setFormatter(_tabsAndSpacesSupportingFormatter);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("idlist");
      _builder_1.newLine();
      _builder_1.append("/* i");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("j */");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("/*y*/ a");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function);
    final Procedure1<GenericFormatterTestRequest> _function_1 = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.CustomFormatter _customFormatter = new CommentWithSpacesFormatterTest.CustomFormatter();
      it.setFormatter(_customFormatter);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("idlist");
      _builder_1.newLine();
      _builder_1.append("/* i");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("j */");
      _builder_1.newLine();
      _builder_1.append("/*y*/ a");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function_1);
  }
  
  @Test
  public void MLOverOneLineMLOverOneLine() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("idlist  /* i");
    _builder.newLine();
    _builder.append("j *//*x");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("y*/  a");
    _builder.newLine();
    final String input = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("idlist");
    _builder_1.newLine();
    _builder_1.append("/* i");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("j */");
    _builder_1.newLine();
    _builder_1.append("/*x");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("y*/ a");
    _builder_1.newLine();
    final String output = _builder_1.toString();
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter _tabsAndSpacesSupportingFormatter = new CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter();
      it.setFormatter(_tabsAndSpacesSupportingFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function);
    final Procedure1<GenericFormatterTestRequest> _function_1 = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.CustomFormatter _customFormatter = new CommentWithSpacesFormatterTest.CustomFormatter();
      it.setFormatter(_customFormatter);
      it.setExpectation(output);
    };
    this._genericFormatterTester.assertFormatted(_function_1);
  }
  
  @Test
  public void SLMLMLOverOneLine() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("idlist  /* n *//*x");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("y*/  a");
    _builder.newLine();
    final String input = _builder.toString();
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter _tabsAndSpacesSupportingFormatter = new CommentWithSpacesFormatterTest.TabsAndSpacesSupportingFormatter();
      it.setFormatter(_tabsAndSpacesSupportingFormatter);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("idlist /* n */");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("/*x");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("y*/ a");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function);
    final Procedure1<GenericFormatterTestRequest> _function_1 = (GenericFormatterTestRequest it) -> {
      it.setToBeFormatted(input);
      CommentWithSpacesFormatterTest.CustomFormatter _customFormatter = new CommentWithSpacesFormatterTest.CustomFormatter();
      it.setFormatter(_customFormatter);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("idlist /* n */");
      _builder_1.newLine();
      _builder_1.append("/*x");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("y*/ a");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function_1);
  }
}
