/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.internal;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IFormattableSubDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.ISubFormatter;
import org.eclipse.xtext.formatting2.internal.FormatterTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.internal.GenericFormatter;
import org.eclipse.xtext.formatting2.internal.GenericFormatterTestRequest;
import org.eclipse.xtext.formatting2.internal.GenericFormatterTester;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList;
import org.eclipse.xtext.formatting2.internal.services.FormatterTestLanguageGrammarAccess;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
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
public class FormattableDocumentTest {
  @Inject
  @Extension
  private GenericFormatterTester _genericFormatterTester;
  
  @Inject
  @Extension
  private FormatterTestLanguageGrammarAccess _formatterTestLanguageGrammarAccess;
  
  @Test
  public void simple() {
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("idlist  a");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      final GenericFormatter<IDList> _function_1 = new GenericFormatter<IDList>() {
        @Override
        protected void format(final IDList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          ISemanticRegionsFinder _regionFor = regions.regionFor(model);
          ISemanticRegion _keyword = _regionFor.keyword("idlist");
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
            it_1.oneSpace();
          };
          document.append(_keyword, _function);
        }
      };
      it.setFormatter(_function_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("idlist a");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
  
  @Test
  public void autowrap() {
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(10));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("idlist  aaa  bbb  ccc  ddd  eee  fff");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      final GenericFormatter<IDList> _function_2 = new GenericFormatter<IDList>() {
        @Override
        protected void format(final IDList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          ISemanticRegionsFinder _regionFor = regions.regionFor(model);
          TerminalRule _iDRule = FormattableDocumentTest.this._formatterTestLanguageGrammarAccess.getIDRule();
          List<ISemanticRegion> _ruleCallsTo = _regionFor.ruleCallsTo(_iDRule);
          final Consumer<ISemanticRegion> _function = (ISemanticRegion it_1) -> {
            final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_2) -> {
              it_2.autowrap();
              it_2.oneSpace();
            };
            document.prepend(it_1, _function_1);
          };
          _ruleCallsTo.forEach(_function);
        }
      };
      it.setFormatter(_function_2);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("idlist aaa");
      _builder_1.newLine();
      _builder_1.append("bbb ccc");
      _builder_1.newLine();
      _builder_1.append("ddd eee fff");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
  
  @Test
  public void autoWrapWithSpan() {
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(10));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("kwlist  kw1  kw2  kw3  kw4");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      final GenericFormatter<KWList> _function_2 = new GenericFormatter<KWList>() {
        @Override
        protected void format(final KWList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          ISemanticRegionsFinder _regionFor = regions.regionFor(model);
          ISemanticRegion _keyword = _regionFor.keyword("kwlist");
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
            it_1.autowrap(6);
            it_1.oneSpace();
          };
          document.append(_keyword, _function);
          ISemanticRegionsFinder _regionFor_1 = regions.regionFor(model);
          ISemanticRegion _keyword_1 = _regionFor_1.keyword("kw1");
          final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
            it_1.autowrap();
            it_1.oneSpace();
          };
          document.append(_keyword_1, _function_1);
          ISemanticRegionsFinder _regionFor_2 = regions.regionFor(model);
          ISemanticRegion _keyword_2 = _regionFor_2.keyword("kw2");
          final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
            it_1.autowrap();
            it_1.oneSpace();
          };
          document.append(_keyword_2, _function_2);
          ISemanticRegionsFinder _regionFor_3 = regions.regionFor(model);
          ISemanticRegion _keyword_3 = _regionFor_3.keyword("kw3");
          final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it_1) -> {
            it_1.autowrap();
            it_1.oneSpace();
          };
          document.append(_keyword_3, _function_3);
          ISemanticRegionsFinder _regionFor_4 = regions.regionFor(model);
          ISemanticRegion _keyword_4 = _regionFor_4.keyword("kw4");
          final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
            it_1.autowrap();
            it_1.newLine();
          };
          document.append(_keyword_4, _function_4);
        }
      };
      it.setFormatter(_function_2);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("kwlist");
      _builder_1.newLine();
      _builder_1.append("kw1 kw2");
      _builder_1.newLine();
      _builder_1.append("kw3 kw4");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
  
  @Test
  public void conditionalFormatting1() {
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(10));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("kwlist  kw1  kw2");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      final GenericFormatter<KWList> _function_2 = new GenericFormatter<KWList>() {
        @Override
        protected void format(final KWList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          final ISubFormatter _function = (IFormattableSubDocument doc) -> {
            @Extension
            final IFormattableSubDocument fits = doc.requireFitsInLine();
            ISemanticRegionsFinder _regionFor = regions.regionFor(model);
            ISemanticRegion _keyword = _regionFor.keyword("kwlist");
            final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
              it_1.oneSpace();
            };
            fits.append(_keyword, _function_1);
            ISemanticRegionsFinder _regionFor_1 = regions.regionFor(model);
            ISemanticRegion _keyword_1 = _regionFor_1.keyword("kw1");
            final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
              it_1.oneSpace();
            };
            fits.append(_keyword_1, _function_2);
          };
          final ISubFormatter _function_1 = (IFormattableSubDocument doc) -> {
            ISemanticRegionsFinder _regionFor = regions.regionFor(model);
            ISemanticRegion _keyword = _regionFor.keyword("kwlist");
            final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
              it_1.newLine();
            };
            doc.append(_keyword, _function_2);
            ISemanticRegionsFinder _regionFor_1 = regions.regionFor(model);
            ISemanticRegion _keyword_1 = _regionFor_1.keyword("kw1");
            final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it_1) -> {
              it_1.newLine();
            };
            doc.append(_keyword_1, _function_3);
          };
          document.formatConditionally(model, _function, _function_1);
        }
      };
      it.setFormatter(_function_2);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("kwlist");
      _builder_1.newLine();
      _builder_1.append("kw1");
      _builder_1.newLine();
      _builder_1.append("kw2");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
  
  @Test
  public void conditionalFormatting2() {
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(30));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("kwlist  kw1  kw2");
      _builder.newLine();
      it.setToBeFormatted(_builder);
      final GenericFormatter<KWList> _function_2 = new GenericFormatter<KWList>() {
        @Override
        protected void format(final KWList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          final ISubFormatter _function = (IFormattableSubDocument doc) -> {
            @Extension
            final IFormattableSubDocument fits = doc.requireFitsInLine();
            ISemanticRegionsFinder _regionFor = regions.regionFor(model);
            ISemanticRegion _keyword = _regionFor.keyword("kwlist");
            final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
              it_1.oneSpace();
            };
            fits.append(_keyword, _function_1);
            ISemanticRegionsFinder _regionFor_1 = regions.regionFor(model);
            ISemanticRegion _keyword_1 = _regionFor_1.keyword("kw1");
            final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
              it_1.oneSpace();
            };
            fits.append(_keyword_1, _function_2);
          };
          final ISubFormatter _function_1 = (IFormattableSubDocument doc) -> {
            ISemanticRegionsFinder _regionFor = regions.regionFor(model);
            ISemanticRegion _keyword = _regionFor.keyword("kwlist");
            final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
              it_1.newLine();
            };
            doc.append(_keyword, _function_2);
            ISemanticRegionsFinder _regionFor_1 = regions.regionFor(model);
            ISemanticRegion _keyword_1 = _regionFor_1.keyword("kw1");
            final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it_1) -> {
              it_1.newLine();
            };
            doc.append(_keyword_1, _function_3);
          };
          document.formatConditionally(model, _function, _function_1);
        }
      };
      it.setFormatter(_function_2);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("kwlist kw1 kw2");
      _builder_1.newLine();
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
  
  @Test
  public void aroundDocument() {
    final Procedure1<GenericFormatterTestRequest> _function = (GenericFormatterTestRequest it) -> {
      FormatterRequest _request = it.getRequest();
      Collection<ITextRegion> _regions = _request.getRegions();
      TextRegion _textRegion = new TextRegion(0, 6);
      _regions.add(_textRegion);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("idlist");
      it.setToBeFormatted(_builder);
      final GenericFormatter<IDList> _function_1 = new GenericFormatter<IDList>() {
        @Override
        protected void format(final IDList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          ISemanticRegionsFinder _regionFor = regions.regionFor(model);
          ISemanticRegion _keyword = _regionFor.keyword("idlist");
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
            it_1.setSpace("!");
          };
          document.surround(_keyword, _function);
        }
      };
      it.setFormatter(_function_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("!idlist!");
      it.setExpectation(_builder_1);
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
}
