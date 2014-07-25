/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.internal;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.FormattingNotApplicableException;
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
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
    final Procedure1<GenericFormatterTestRequest> _function = new Procedure1<GenericFormatterTestRequest>() {
      public void apply(final GenericFormatterTestRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("idlist  a");
        _builder.newLine();
        it.setToBeFormatted(_builder);
        final GenericFormatter<IDList> _function = new GenericFormatter<IDList>() {
          @Override
          protected void format(final IDList model, @Extension final ITextRegionAccess regions, @Extension final IFormattableDocument document) {
            ISemanticRegion _regionForKeyword = regions.regionForKeyword(model, "idlist");
            final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
              public void apply(final IHiddenRegionFormatter it) {
                it.oneSpace();
              }
            };
            document.append(_regionForKeyword, _function);
          }
        };
        it.setFormatter(_function);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("idlist a");
        _builder_1.newLine();
        it.setExpectation(_builder_1);
      }
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
  
  @Test
  public void autowrap() {
    final Procedure1<GenericFormatterTestRequest> _function = new Procedure1<GenericFormatterTestRequest>() {
      public void apply(final GenericFormatterTestRequest it) {
        final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
          public void apply(final MapBasedPreferenceValues it) {
            it.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(10));
          }
        };
        it.preferences(_function);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("idlist  aaa  bbb  ccc  ddd  eee  fff");
        _builder.newLine();
        it.setToBeFormatted(_builder);
        final GenericFormatter<IDList> _function_1 = new GenericFormatter<IDList>() {
          @Override
          protected void format(final IDList model, @Extension final ITextRegionAccess regions, @Extension final IFormattableDocument document) {
            TerminalRule _iDRule = FormattableDocumentTest.this._formatterTestLanguageGrammarAccess.getIDRule();
            List<ISemanticRegion> _regionsForRuleCallsTo = regions.regionsForRuleCallsTo(model, _iDRule);
            final Procedure1<ISemanticRegion> _function = new Procedure1<ISemanticRegion>() {
              public void apply(final ISemanticRegion it) {
                final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
                  public void apply(final IHiddenRegionFormatter it) {
                    it.autowrap();
                    it.oneSpace();
                  }
                };
                document.prepend(it, _function);
              }
            };
            IterableExtensions.<ISemanticRegion>forEach(_regionsForRuleCallsTo, _function);
          }
        };
        it.setFormatter(_function_1);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("idlist aaa");
        _builder_1.newLine();
        _builder_1.append("bbb ccc");
        _builder_1.newLine();
        _builder_1.append("ddd eee fff");
        _builder_1.newLine();
        it.setExpectation(_builder_1);
      }
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
  
  @Test
  public void conditionalFormatting1() {
    final Procedure1<GenericFormatterTestRequest> _function = new Procedure1<GenericFormatterTestRequest>() {
      public void apply(final GenericFormatterTestRequest it) {
        final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
          public void apply(final MapBasedPreferenceValues it) {
            it.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(10));
          }
        };
        it.preferences(_function);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("kwlist  kw1  kw2");
        _builder.newLine();
        it.setToBeFormatted(_builder);
        final GenericFormatter<KWList> _function_1 = new GenericFormatter<KWList>() {
          @Override
          protected void format(final KWList model, @Extension final ITextRegionAccess regions, @Extension final IFormattableDocument document) {
            final ISubFormatter _function = new ISubFormatter() {
              public void format(final IFormattableSubDocument doc) throws FormattingNotApplicableException {
                @Extension
                final IFormattableSubDocument fits = doc.requireFitsInLine();
                ISemanticRegion _regionForKeyword = regions.regionForKeyword(model, "kwlist");
                final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
                  public void apply(final IHiddenRegionFormatter it) {
                    it.oneSpace();
                  }
                };
                fits.append(_regionForKeyword, _function);
                ISemanticRegion _regionForKeyword_1 = regions.regionForKeyword(model, "kw1");
                final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
                  public void apply(final IHiddenRegionFormatter it) {
                    it.oneSpace();
                  }
                };
                fits.append(_regionForKeyword_1, _function_1);
              }
            };
            final ISubFormatter _function_1 = new ISubFormatter() {
              public void format(@Extension final IFormattableSubDocument doc) throws FormattingNotApplicableException {
                ISemanticRegion _regionForKeyword = regions.regionForKeyword(model, "kwlist");
                final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
                  public void apply(final IHiddenRegionFormatter it) {
                    it.newLine();
                  }
                };
                doc.append(_regionForKeyword, _function);
                ISemanticRegion _regionForKeyword_1 = regions.regionForKeyword(model, "kw1");
                final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
                  public void apply(final IHiddenRegionFormatter it) {
                    it.newLine();
                  }
                };
                doc.append(_regionForKeyword_1, _function_1);
              }
            };
            document.formatConditionally(model, _function, _function_1);
          }
        };
        it.setFormatter(_function_1);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("kwlist");
        _builder_1.newLine();
        _builder_1.append("kw1");
        _builder_1.newLine();
        _builder_1.append("kw2");
        _builder_1.newLine();
        it.setExpectation(_builder_1);
      }
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
  
  @Test
  public void conditionalFormatting2() {
    final Procedure1<GenericFormatterTestRequest> _function = new Procedure1<GenericFormatterTestRequest>() {
      public void apply(final GenericFormatterTestRequest it) {
        final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
          public void apply(final MapBasedPreferenceValues it) {
            it.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(30));
          }
        };
        it.preferences(_function);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("kwlist  kw1  kw2");
        _builder.newLine();
        it.setToBeFormatted(_builder);
        final GenericFormatter<KWList> _function_1 = new GenericFormatter<KWList>() {
          @Override
          protected void format(final KWList model, @Extension final ITextRegionAccess regions, @Extension final IFormattableDocument document) {
            final ISubFormatter _function = new ISubFormatter() {
              public void format(final IFormattableSubDocument doc) throws FormattingNotApplicableException {
                @Extension
                final IFormattableSubDocument fits = doc.requireFitsInLine();
                ISemanticRegion _regionForKeyword = regions.regionForKeyword(model, "kwlist");
                final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
                  public void apply(final IHiddenRegionFormatter it) {
                    it.oneSpace();
                  }
                };
                fits.append(_regionForKeyword, _function);
                ISemanticRegion _regionForKeyword_1 = regions.regionForKeyword(model, "kw1");
                final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
                  public void apply(final IHiddenRegionFormatter it) {
                    it.oneSpace();
                  }
                };
                fits.append(_regionForKeyword_1, _function_1);
              }
            };
            final ISubFormatter _function_1 = new ISubFormatter() {
              public void format(@Extension final IFormattableSubDocument doc) throws FormattingNotApplicableException {
                ISemanticRegion _regionForKeyword = regions.regionForKeyword(model, "kwlist");
                final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
                  public void apply(final IHiddenRegionFormatter it) {
                    it.newLine();
                  }
                };
                doc.append(_regionForKeyword, _function);
                ISemanticRegion _regionForKeyword_1 = regions.regionForKeyword(model, "kw1");
                final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
                  public void apply(final IHiddenRegionFormatter it) {
                    it.newLine();
                  }
                };
                doc.append(_regionForKeyword_1, _function_1);
              }
            };
            document.formatConditionally(model, _function, _function_1);
          }
        };
        it.setFormatter(_function_1);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("kwlist kw1 kw2");
        _builder_1.newLine();
        it.setExpectation(_builder_1);
      }
    };
    this._genericFormatterTester.assertFormatted(_function);
  }
}
