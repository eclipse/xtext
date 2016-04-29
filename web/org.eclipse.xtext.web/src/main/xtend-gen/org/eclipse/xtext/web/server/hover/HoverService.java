/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.hover;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.labels.AlternativeImageDescription;
import org.eclipse.xtext.ide.labels.DecoratedImageDescription;
import org.eclipse.xtext.ide.labels.IImageDescription;
import org.eclipse.xtext.ide.labels.IImageDescriptionProvider;
import org.eclipse.xtext.ide.labels.INameLabelProvider;
import org.eclipse.xtext.ide.labels.SimpleImageDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.contentassist.ContentAssistService;
import org.eclipse.xtext.web.server.hover.HoverResult;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.web.server.util.ElementAtOffsetUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Service class for mouse hover information. Such information can be created for an already
 * existing model element or for an element proposed through content assist.
 */
@Singleton
@SuppressWarnings("all")
public class HoverService {
  @Inject
  @Extension
  private ElementAtOffsetUtil _elementAtOffsetUtil;
  
  @Inject
  @Extension
  private IEObjectDocumentationProvider _iEObjectDocumentationProvider;
  
  @Inject
  @Extension
  private IImageDescriptionProvider _iImageDescriptionProvider;
  
  @Inject
  @Extension
  private INameLabelProvider _iNameLabelProvider;
  
  @Inject
  @Extension
  private OperationCanceledManager _operationCanceledManager;
  
  @Inject
  private ContentAssistService contentAssistService;
  
  /**
   * Compute a hover result at the given offset in the document.
   */
  public HoverResult getHover(final XtextWebDocumentAccess document, final int offset) throws InvalidRequestException {
    final CancelableUnitOfWork<HoverResult, IXtextWebDocument> _function = new CancelableUnitOfWork<HoverResult, IXtextWebDocument>() {
      @Override
      public HoverResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        HoverResult _xblockexpression = null;
        {
          XtextResource _resource = it.getResource();
          final EObject element = HoverService.this._elementAtOffsetUtil.getElementAt(_resource, offset);
          String _stateId = it.getStateId();
          _xblockexpression = HoverService.this.createHover(element, _stateId, cancelIndicator);
        }
        return _xblockexpression;
      }
    };
    return document.<HoverResult>readOnly(_function);
  }
  
  /**
   * Compute a hover result for a content assist proposal at the given offset.
   */
  public HoverResult getHover(final XtextWebDocumentAccess document, final String proposal, final ITextRegion selection, final int offset) throws InvalidRequestException {
    final CancelableUnitOfWork<HoverResult, IXtextWebDocument> _function = new CancelableUnitOfWork<HoverResult, IXtextWebDocument>() {
      @Override
      public HoverResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        HoverResult _xblockexpression = null;
        {
          final ContentAssistContext[] contexts = HoverService.this.contentAssistService.getContexts(it, selection, offset);
          final Wrapper<Object> proposedElement = new Wrapper<Object>();
          IdeContentProposalProvider _proposalProvider = HoverService.this.contentAssistService.getProposalProvider();
          _proposalProvider.createProposals(((Collection<ContentAssistContext>)Conversions.doWrapArray(contexts)), new IIdeContentProposalAcceptor() {
            @Override
            public void accept(final ContentAssistEntry entry, final int priority) {
              HoverService.this._operationCanceledManager.checkCanceled(cancelIndicator);
              if ((((entry != null) && (entry.getSource() != null)) && Objects.equal(entry.getProposal(), proposal))) {
                Object _source = entry.getSource();
                proposedElement.set(_source);
              }
            }
            
            @Override
            public boolean canAcceptMoreProposals() {
              Object _get = proposedElement.get();
              return (_get == null);
            }
          });
          Object _get = proposedElement.get();
          String _stateId = it.getStateId();
          _xblockexpression = HoverService.this.createHover(_get, _stateId, cancelIndicator);
        }
        return _xblockexpression;
      }
    };
    return document.<HoverResult>readOnly(_function);
  }
  
  protected HoverResult createHover(final Object element, final String stateId, final CancelIndicator cancelIndicator) {
    String _nameLabel = null;
    if (element!=null) {
      _nameLabel=this._iNameLabelProvider.getNameLabel(element);
    }
    String _surroundWithDiv = null;
    if (_nameLabel!=null) {
      _surroundWithDiv=this.surroundWithDiv(_nameLabel, "element-name");
    }
    final String nameLabel = _surroundWithDiv;
    if ((nameLabel != null)) {
      this._operationCanceledManager.checkCanceled(cancelIndicator);
      IImageDescription _imageDescription = this._iImageDescriptionProvider.getImageDescription(element);
      String _addIconDivs = this.addIconDivs(_imageDescription, nameLabel);
      final String titleHtml = this.surroundWithDiv(_addIconDivs, "xtext-hover");
      this._operationCanceledManager.checkCanceled(cancelIndicator);
      EObject _switchResult = null;
      boolean _matched = false;
      if (element instanceof EObject) {
        _matched=true;
        _switchResult = ((EObject)element);
      }
      if (!_matched) {
        if (element instanceof IEObjectDescription) {
          _matched=true;
          _switchResult = ((IEObjectDescription)element).getEObjectOrProxy();
        }
      }
      final EObject eobject = _switchResult;
      String bodyHtml = "";
      if (((eobject != null) && (!eobject.eIsProxy()))) {
        final String documentation = this._iEObjectDocumentationProvider.getDocumentation(eobject);
        if ((documentation != null)) {
          String _surroundWithDiv_1 = this.surroundWithDiv(documentation, "xtext-hover");
          bodyHtml = _surroundWithDiv_1;
        }
      }
      return new HoverResult(stateId, titleHtml, bodyHtml);
    }
    return new HoverResult(stateId);
  }
  
  protected String addIconDivs(final IImageDescription it, final String nameHtml) {
    String _switchResult = null;
    boolean _matched = false;
    if (it instanceof SimpleImageDescription) {
      _matched=true;
      String _imageID = ((SimpleImageDescription)it).getImageID();
      String _plus = (_imageID + "-icon");
      _switchResult = this.surroundWithDiv(nameHtml, _plus);
    }
    if (!_matched) {
      if (it instanceof AlternativeImageDescription) {
        _matched=true;
        List<String> _imageIDs = ((AlternativeImageDescription)it).getImageIDs();
        final Function1<String, String> _function = new Function1<String, String>() {
          @Override
          public String apply(final String it) {
            return (it + "-icon");
          }
        };
        List<String> _map = ListExtensions.<String, String>map(_imageIDs, _function);
        _switchResult = this.surroundWithDiv(nameHtml, ((String[])Conversions.unwrapArray(_map, String.class)));
      }
    }
    if (!_matched) {
      if (it instanceof DecoratedImageDescription) {
        _matched=true;
        List<IImageDescription> _decorators = ((DecoratedImageDescription)it).getDecorators();
        IImageDescription _baseImage = ((DecoratedImageDescription)it).getBaseImage();
        Iterable<IImageDescription> _plus = Iterables.<IImageDescription>concat(_decorators, Collections.<IImageDescription>unmodifiableList(CollectionLiterals.<IImageDescription>newArrayList(_baseImage)));
        final Function2<String, IImageDescription, String> _function = new Function2<String, IImageDescription, String>() {
          @Override
          public String apply(final String $0, final IImageDescription $1) {
            return HoverService.this.addIconDivs($1, $0);
          }
        };
        _switchResult = IterableExtensions.<IImageDescription, String>fold(_plus, nameHtml, _function);
      }
    }
    return _switchResult;
  }
  
  protected String surroundWithDiv(final String html, final String... divClasses) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div");
    {
      int _length = divClasses.length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append(" class=\"");
        String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(divClasses)), " ");
        _builder.append(_join, "");
        _builder.append("\"");
      }
    }
    _builder.append(">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(html, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("</div>");
    _builder.newLine();
    return _builder.toString();
  }
}
