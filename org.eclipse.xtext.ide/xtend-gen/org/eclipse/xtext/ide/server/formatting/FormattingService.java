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
import io.typefox.lsapi.TextEdit;
import io.typefox.lsapi.impl.PositionImpl;
import io.typefox.lsapi.impl.RangeImpl;
import io.typefox.lsapi.impl.TextEditImpl;
import java.util.Collections;
import java.util.List;
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
    TextEditImpl _textEditImpl = new TextEditImpl();
    final Procedure1<TextEditImpl> _function = (TextEditImpl it) -> {
      it.setNewText(formattedText);
      RangeImpl _rangeImpl = new RangeImpl();
      final Procedure1<RangeImpl> _function_1 = (RangeImpl it_1) -> {
        PositionImpl _position = document.getPosition(startOffset);
        it_1.setStart(_position);
        PositionImpl _position_1 = document.getPosition((startOffset + length));
        it_1.setEnd(_position_1);
      };
      RangeImpl _doubleArrow = ObjectExtensions.<RangeImpl>operator_doubleArrow(_rangeImpl, _function_1);
      it.setRange(_doubleArrow);
    };
    return ObjectExtensions.<TextEditImpl>operator_doubleArrow(_textEditImpl, _function);
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
