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
import org.eclipse.lsp4j.Position;
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
  
  public List<TextEdit> format(final XtextResource resource, final Document document, final int offset, final int length) {
    if ((this.formatter2Provider != null)) {
      TextRegion _textRegion = new TextRegion(offset, length);
      final List<ITextReplacement> replacements = this.format2(resource, _textRegion, null);
      final Function1<ITextReplacement, TextEdit> _function = (ITextReplacement r) -> {
        String _replacementText = r.getReplacementText();
        int _offset = r.getOffset();
        int _length = r.getLength();
        return this.toTextEdit(document, _replacementText, _offset, _length);
      };
      List<TextEdit> _map = ListExtensions.<ITextReplacement, TextEdit>map(replacements, _function);
      return IterableExtensions.<TextEdit>toList(_map);
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
        Position _position = document.getPosition(startOffset);
        it_1.setStart(_position);
        Position _position_1 = document.getPosition((startOffset + length));
        it_1.setEnd(_position_1);
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
    TextRegionAccessBuilder _forNodeModel = this.regionBuilder.forNodeModel(resource);
    final ITextRegionAccess regionAccess = _forNodeModel.create();
    request.setTextRegionAccess(regionAccess);
    final IFormatter2 formatter2 = this.formatter2Provider.get();
    final List<ITextReplacement> replacements = formatter2.format(request);
    return replacements;
  }
}
