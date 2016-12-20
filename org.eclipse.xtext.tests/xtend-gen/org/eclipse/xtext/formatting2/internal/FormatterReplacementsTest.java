/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.internal;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.internal.GenericFormatter;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList;
import org.eclipse.xtext.formatting2.internal.services.FormatterTestLanguageGrammarAccess;
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FormatterTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class FormatterReplacementsTest {
  @Inject
  private Provider<FormatterRequest> requestProvider;
  
  @Inject
  private TextRegionAccessBuilder regionBuilder;
  
  @Inject
  private ParseHelper<IDList> parseHelper;
  
  @Inject
  @Extension
  private FormatterTestLanguageGrammarAccess _formatterTestLanguageGrammarAccess;
  
  @Test
  public void testIdentityEditsAreFiltered() {
    try {
      final GenericFormatter<IDList> _function = new GenericFormatter<IDList>() {
        @Override
        protected void format(final IDList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          ISemanticRegionsFinder _regionFor = regions.regionFor(model);
          TerminalRule _iDRule = FormatterReplacementsTest.this._formatterTestLanguageGrammarAccess.getIDRule();
          List<ISemanticRegion> _ruleCallsTo = _regionFor.ruleCallsTo(_iDRule);
          final Consumer<ISemanticRegion> _function = (ISemanticRegion it) -> {
            final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
              it_1.autowrap();
              it_1.oneSpace();
            };
            document.prepend(it, _function_1);
          };
          _ruleCallsTo.forEach(_function);
        }
      };
      final GenericFormatter<IDList> formatter = _function;
      final IDList parsed = this.parseHelper.parse("idlist  aaa bbb");
      final FormatterRequest request = this.requestProvider.get();
      request.setAllowIdentityEdits(false);
      Resource _eResource = parsed.eResource();
      TextRegionAccessBuilder _forNodeModel = this.regionBuilder.forNodeModel(((XtextResource) _eResource));
      ITextRegionAccess _create = _forNodeModel.create();
      request.setTextRegionAccess(_create);
      final List<ITextReplacement> replacements = formatter.format(request);
      final Function1<ITextReplacement, String> _function_1 = (ITextReplacement it) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\"");
        String _text = it.getText();
        _builder.append(_text);
        _builder.append("\" -> \"");
        String _replacementText = it.getReplacementText();
        _builder.append(_replacementText);
        _builder.append("\"");
        _builder.append("\n");
        return _builder.toString();
      };
      List<String> _map = ListExtensions.<ITextReplacement, String>map(replacements, _function_1);
      final String actual = IterableExtensions.join(_map);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"  \" -> \" \"");
      _builder.newLine();
      final String expected = _builder.toString();
      Assert.assertEquals(expected, actual);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
