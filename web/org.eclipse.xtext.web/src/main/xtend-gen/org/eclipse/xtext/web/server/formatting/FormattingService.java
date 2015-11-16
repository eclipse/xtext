/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.formatting;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.formatting.INodeModelFormatter;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionRewriter;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextSegment;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.formatting.FormattingResult;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * Service class for text formatting.
 */
@Singleton
@SuppressWarnings("all")
public class FormattingService {
  @Inject(optional = true)
  private INodeModelFormatter formatter1;
  
  @Inject(optional = true)
  private Provider<IFormatter2> formatter2Provider;
  
  @Inject
  private Provider<FormatterRequest> formatterRequestProvider;
  
  @Inject
  private TextRegionAccessBuilder regionBuilder;
  
  /**
   * Format the given document. This operation modifies the document content and returns the
   */
  public FormattingResult format(final XtextWebDocumentAccess document, final ITextRegion selection, final ITypedPreferenceValues preferences) throws InvalidRequestException {
    FormattingResult _xblockexpression = null;
    {
      final Wrapper<String> textWrapper = new Wrapper<String>();
      final Wrapper<TextRegion> regionWrapper = new Wrapper<TextRegion>();
      final CancelableUnitOfWork<FormattingResult, IXtextWebDocument> _function = new CancelableUnitOfWork<FormattingResult, IXtextWebDocument>() {
        @Override
        public FormattingResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
          if ((FormattingService.this.formatter2Provider != null)) {
            XtextResource _resource = it.getResource();
            String _format2 = FormattingService.this.format2(_resource, selection, preferences);
            textWrapper.set(_format2);
            if ((selection != null)) {
              int _offset = selection.getOffset();
              int _length = selection.getLength();
              TextRegion _textRegion = new TextRegion(_offset, _length);
              regionWrapper.set(_textRegion);
            }
          } else {
            if ((FormattingService.this.formatter1 != null)) {
              XtextResource _resource_1 = it.getResource();
              final INodeModelFormatter.IFormattedRegion formattedRegion = FormattingService.this.format1(_resource_1, selection);
              String _formattedText = formattedRegion.getFormattedText();
              textWrapper.set(_formattedText);
              int _offset_1 = formattedRegion.getOffset();
              int _length_1 = formattedRegion.getLength();
              TextRegion _textRegion_1 = new TextRegion(_offset_1, _length_1);
              regionWrapper.set(_textRegion_1);
            } else {
              throw new IllegalStateException("No formatter is available in the language configuration.");
            }
          }
          it.setDirty(true);
          it.createNewStateId();
          String _stateId = it.getStateId();
          String _get = textWrapper.get();
          TextRegion _get_1 = regionWrapper.get();
          return new FormattingResult(_stateId, _get, _get_1);
        }
      };
      final CancelableUnitOfWork<Object, IXtextWebDocument> _function_1 = new CancelableUnitOfWork<Object, IXtextWebDocument>() {
        @Override
        public Object exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
          boolean _isEmpty = regionWrapper.isEmpty();
          if (_isEmpty) {
            String _get = textWrapper.get();
            it.setText(_get);
          } else {
            String _get_1 = textWrapper.get();
            TextRegion _get_2 = regionWrapper.get();
            int _offset = _get_2.getOffset();
            TextRegion _get_3 = regionWrapper.get();
            int _length = _get_3.getLength();
            it.updateText(_get_1, _offset, _length);
          }
          return null;
        }
      };
      _xblockexpression = document.<FormattingResult>modify(_function, _function_1);
    }
    return _xblockexpression;
  }
  
  protected INodeModelFormatter.IFormattedRegion format1(final XtextResource resource, final ITextRegion selection) {
    final IParseResult parseResult = resource.getParseResult();
    if ((parseResult == null)) {
      return null;
    }
    final ICompositeNode rootNode = parseResult.getRootNode();
    ITextRegion region = selection;
    if ((region == null)) {
      int _offset = rootNode.getOffset();
      int _length = rootNode.getLength();
      TextRegion _textRegion = new TextRegion(_offset, _length);
      region = _textRegion;
    }
    int _offset_1 = region.getOffset();
    int _length_1 = region.getLength();
    return this.formatter1.format(rootNode, _offset_1, _length_1);
  }
  
  protected String format2(final XtextResource resource, final ITextRegion selection, final ITypedPreferenceValues preferences) {
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
    if ((selection != null)) {
      ITextRegionRewriter _rewriter = regionAccess.getRewriter();
      int _offset = selection.getOffset();
      int _length = selection.getLength();
      TextSegment _textSegment = new TextSegment(regionAccess, _offset, _length);
      return _rewriter.renderToString(_textSegment, replacements);
    } else {
      ITextRegionRewriter _rewriter_1 = regionAccess.getRewriter();
      return _rewriter_1.renderToString(replacements);
    }
  }
}
