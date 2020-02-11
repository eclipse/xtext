/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.internal;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.internal.GenericFormatter;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.FormattertestlanguageFactory;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList;
import org.eclipse.xtext.formatting2.internal.services.FormatterTestLanguageGrammarAccess;
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
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
  
  @Inject
  private Serializer serializer;
  
  @Inject
  private IResourceFactory resFact;
  
  private final FormattertestlanguageFactory fact = FormattertestlanguageFactory.eINSTANCE;
  
  @Test
  public void testIdentityEditsAreFiltered() {
    try {
      final GenericFormatter<IDList> _function = new GenericFormatter<IDList>() {
        @Override
        protected void format(final IDList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
          final Consumer<ISemanticRegion> _function = (ISemanticRegion it) -> {
            final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
              it_1.autowrap();
              it_1.oneSpace();
            };
            document.prepend(it, _function_1);
          };
          regions.regionFor(model).ruleCallsTo(FormatterReplacementsTest.this._formatterTestLanguageGrammarAccess.getIDRule()).forEach(_function);
        }
      };
      final GenericFormatter<IDList> formatter = _function;
      final IDList parsed = this.parseHelper.parse("idlist  aaa bbb");
      final FormatterRequest request = this.requestProvider.get();
      request.setAllowIdentityEdits(false);
      Resource _eResource = parsed.eResource();
      request.setTextRegionAccess(this.regionBuilder.forNodeModel(((XtextResource) _eResource)).create());
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
      final String actual = IterableExtensions.join(ListExtensions.<ITextReplacement, String>map(replacements, _function_1));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"  \" -> \" \"");
      _builder.newLine();
      final String expected = _builder.toString();
      Assert.assertEquals(expected, actual);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUndefinedIdentityEditsAreNotFiltered() {
    final GenericFormatter<IDList> _function = new GenericFormatter<IDList>() {
      @Override
      protected void format(final IDList model, @Extension final ITextRegionExtensions regions, @Extension final IFormattableDocument document) {
        final Consumer<ISemanticRegion> _function = (ISemanticRegion it) -> {
          final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
            it_1.setSpace("");
          };
          document.prepend(it, _function_1);
        };
        regions.regionFor(model).ruleCallsTo(FormatterReplacementsTest.this._formatterTestLanguageGrammarAccess.getIDRule()).forEach(_function);
      }
    };
    final GenericFormatter<IDList> formatter = _function;
    IDList _createIDList = this.fact.createIDList();
    final Procedure1<IDList> _function_1 = (IDList it) -> {
      EList<String> _ids = it.getIds();
      _ids.add("a");
    };
    final IDList model = ObjectExtensions.<IDList>operator_doubleArrow(_createIDList, _function_1);
    Resource _createResource = this.resFact.createResource(URI.createURI("foo.ext"));
    final Procedure1<Resource> _function_2 = (Resource it) -> {
      EList<Resource> _resources = new XtextResourceSet().getResources();
      _resources.add(it);
      EList<EObject> _contents = it.getContents();
      _contents.add(model);
    };
    ObjectExtensions.<Resource>operator_doubleArrow(_createResource, _function_2);
    final FormatterRequest request = this.requestProvider.get();
    request.setAllowIdentityEdits(false);
    request.setTextRegionAccess(this.serializer.serializeToRegions(model));
    final List<ITextReplacement> replacements = formatter.format(request);
    final Function1<ITextReplacement, String> _function_3 = (ITextReplacement it) -> {
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
    final String actual = IterableExtensions.join(ListExtensions.<ITextReplacement, String>map(replacements, _function_3));
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"\" -> \"\"");
    _builder.newLine();
    _builder.append("\"\" -> \"\"");
    _builder.newLine();
    _builder.append("\"\" -> \"\"");
    _builder.newLine();
    final String expected = _builder.toString();
    Assert.assertEquals(expected, actual);
  }
}
