/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.formatting;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collections;
import java.util.List;
import org.eclipse.lsp4j.DocumentFormattingParams;
import org.eclipse.lsp4j.DocumentRangeFormattingParams;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
  @Inject(optional = true)
  private Provider<IFormatter2> formatter2Provider;
  
  @Inject
  private Provider<FormatterRequest> formatterRequestProvider;
  
  @Inject
  private TextRegionAccessBuilder regionBuilder;
  
  public List<? extends TextEdit> format(final Document document, final XtextResource resource, final DocumentFormattingParams params, final CancelIndicator cancelIndicator) {
    final int offset = 0;
    final int length = document.getContents().length();
    if (((length == 0) || resource.getContents().isEmpty())) {
      return CollectionLiterals.<TextEdit>emptyList();
    }
    return this.format(resource, document, offset, length);
  }
  
  public List<? extends TextEdit> format(final Document document, final XtextResource resource, final DocumentRangeFormattingParams params, final CancelIndicator cancelIndicator) {
    final int offset = document.getOffSet(params.getRange().getStart());
    int _offSet = document.getOffSet(params.getRange().getEnd());
    final int length = (_offSet - offset);
    return this.format(resource, document, offset, length);
  }
  
  public List<TextEdit> format(final XtextResource resource, final Document document, final int offset, final int length) {
    if ((this.formatter2Provider != null)) {
      TextRegion _textRegion = new TextRegion(offset, length);
      final List<ITextReplacement> replacements = this.format2(resource, _textRegion, null);
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
