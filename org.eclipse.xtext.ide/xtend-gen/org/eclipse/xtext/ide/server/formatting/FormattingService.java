/**
 * Copyright (c) 2016, 2018 itemis AG (http://www.itemis.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.formatting;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.lsp4j.DocumentFormattingParams;
import org.eclipse.lsp4j.DocumentRangeFormattingParams;
import org.eclipse.lsp4j.FormattingOptions;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Language Service Implementation for Formatting and Range-Formatting
 * 
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.11
 */
@SuppressWarnings("all")
public class FormattingService {
  private static class OverrideChecker {
    private static final Map<Class<?>, Boolean> CLASSES_WITH_OVERRIDES = new ConcurrentHashMap<Class<?>, Boolean>();
    
    public static boolean hasFormatOverride(final Class<? extends FormattingService> formattingServiceClass) {
      Boolean result = FormattingService.OverrideChecker.CLASSES_WITH_OVERRIDES.get(formattingServiceClass);
      if ((result == null)) {
        try {
          result = Boolean.FALSE;
          Class<?> theClass = formattingServiceClass;
          while (((!(result).booleanValue()) && (theClass != FormattingService.class))) {
            {
              try {
                theClass.getDeclaredMethod("format", XtextResource.class, Document.class, Integer.TYPE, Integer.TYPE);
                result = Boolean.TRUE;
              } catch (final Throwable _t) {
                if (_t instanceof NoSuchMethodException) {
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
              theClass = theClass.getSuperclass();
            }
          }
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            result = Boolean.TRUE;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        FormattingService.OverrideChecker.CLASSES_WITH_OVERRIDES.put(formattingServiceClass, result);
      }
      return (result).booleanValue();
    }
  }
  
  @Inject(optional = true)
  private Provider<IFormatter2> formatter2Provider;
  
  @Inject
  private Provider<FormatterRequest> formatterRequestProvider;
  
  @Inject
  private TextRegionAccessBuilder regionBuilder;
  
  @Inject
  private IIndentationInformation indentationInformation;
  
  public List<? extends TextEdit> format(final Document document, final XtextResource resource, final DocumentFormattingParams params, final CancelIndicator cancelIndicator) {
    final int offset = 0;
    final int length = document.getContents().length();
    if (((length == 0) || resource.getContents().isEmpty())) {
      return CollectionLiterals.<TextEdit>emptyList();
    }
    boolean _hasFormatOverride = FormattingService.OverrideChecker.hasFormatOverride(this.getClass());
    if (_hasFormatOverride) {
      return this.format(resource, document, offset, length);
    }
    return this.format(resource, document, offset, length, params.getOptions());
  }
  
  public List<? extends TextEdit> format(final Document document, final XtextResource resource, final DocumentRangeFormattingParams params, final CancelIndicator cancelIndicator) {
    final int offset = document.getOffSet(params.getRange().getStart());
    int _offSet = document.getOffSet(params.getRange().getEnd());
    final int length = (_offSet - offset);
    boolean _hasFormatOverride = FormattingService.OverrideChecker.hasFormatOverride(this.getClass());
    if (_hasFormatOverride) {
      return this.format(resource, document, offset, length);
    }
    return this.format(resource, document, offset, length, params.getOptions());
  }
  
  /**
   * @deprecated use {@link #format(XtextResource, Document, int, int, FormattingOptions)} instead.
   */
  @Deprecated
  public List<TextEdit> format(final XtextResource resource, final Document document, final int offset, final int length) {
    return this.format(resource, document, offset, length, null);
  }
  
  /**
   * @since 2.14
   */
  public List<TextEdit> format(final XtextResource resource, final Document document, final int offset, final int length, final FormattingOptions options) {
    String indent = this.indentationInformation.getIndentString();
    if ((options != null)) {
      boolean _isInsertSpaces = options.isInsertSpaces();
      if (_isInsertSpaces) {
        indent = Strings.padEnd("", options.getTabSize(), ' ');
      }
    }
    if ((this.formatter2Provider != null)) {
      final MapBasedPreferenceValues preferences = new MapBasedPreferenceValues();
      preferences.put("indentation", indent);
      TextRegion _textRegion = new TextRegion(offset, length);
      final List<ITextReplacement> replacements = this.format2(resource, _textRegion, preferences);
      final Function1<ITextReplacement, TextEdit> _function = (ITextReplacement r) -> {
        return this.toTextEdit(document, r.getReplacementText(), r.getOffset(), r.getLength());
      };
      return IterableExtensions.<TextEdit>toList(ListExtensions.<ITextReplacement, TextEdit>map(replacements, _function));
    } else {
      return CollectionLiterals.<TextEdit>newArrayList();
    }
  }
  
  protected TextEdit toTextEdit(final Document document, final String formattedText, final int startOffset, final int length) {
    TextEdit _textEdit = new TextEdit();
    final Procedure1<TextEdit> _function = (TextEdit it) -> {
      it.setNewText(formattedText);
      Range _range = new Range();
      final Procedure1<Range> _function_1 = (Range it_1) -> {
        it_1.setStart(document.getPosition(startOffset));
        it_1.setEnd(document.getPosition((startOffset + length)));
      };
      Range _doubleArrow = ObjectExtensions.<Range>operator_doubleArrow(_range, _function_1);
      it.setRange(_doubleArrow);
    };
    return ObjectExtensions.<TextEdit>operator_doubleArrow(_textEdit, _function);
  }
  
  protected List<ITextReplacement> format2(final XtextResource resource, final ITextRegion selection, final ITypedPreferenceValues preferences) {
    final FormatterRequest request = this.formatterRequestProvider.get();
    request.setAllowIdentityEdits(false);
    request.setFormatUndefinedHiddenRegionsOnly(false);
    if ((selection != null)) {
      request.setRegions(Collections.<ITextRegion>unmodifiableList(CollectionLiterals.<ITextRegion>newArrayList(selection)));
    }
    if ((preferences != null)) {
      request.setPreferences(preferences);
    }
    final ITextRegionAccess regionAccess = this.regionBuilder.forNodeModel(resource).create();
    request.setTextRegionAccess(regionAccess);
    final IFormatter2 formatter2 = this.formatter2Provider.get();
    final List<ITextReplacement> replacements = formatter2.format(request);
    return replacements;
  }
}
