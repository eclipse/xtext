/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.hover;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.MarkedString;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.ide.server.hover.HoverContext;
import org.eclipse.xtext.ide.server.hover.IHoverService;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class HoverService implements IHoverService {
  @Inject
  @Extension
  private DocumentExtensions _documentExtensions;
  
  @Inject
  @Extension
  private EObjectAtOffsetHelper _eObjectAtOffsetHelper;
  
  @Inject
  @Extension
  private ILocationInFileProvider _iLocationInFileProvider;
  
  @Inject
  @Extension
  private IEObjectDocumentationProvider _iEObjectDocumentationProvider;
  
  @Override
  public Hover hover(final Document document, final XtextResource resource, final TextDocumentPositionParams params, final CancelIndicator cancelIndicator) {
    final int offset = document.getOffSet(params.getPosition());
    final HoverContext context = this.createContext(document, resource, offset);
    return this.hover(context);
  }
  
  protected HoverContext createContext(final Document document, final XtextResource resource, final int offset) {
    final EObject crossLinkedEObject = this._eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, offset);
    if ((crossLinkedEObject != null)) {
      boolean _eIsProxy = crossLinkedEObject.eIsProxy();
      if (_eIsProxy) {
        return null;
      }
      final IParseResult parseResult = resource.getParseResult();
      if ((parseResult == null)) {
        return null;
      }
      ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
      if ((((leafNode != null) && leafNode.isHidden()) && (leafNode.getOffset() == offset))) {
        leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), (offset - 1));
      }
      if ((leafNode == null)) {
        return null;
      }
      final ITextRegion leafRegion = leafNode.getTextRegion();
      return new HoverContext(document, resource, offset, leafRegion, crossLinkedEObject);
    }
    final EObject element = this._eObjectAtOffsetHelper.resolveElementAt(resource, offset);
    if ((element == null)) {
      return null;
    }
    final ITextRegion region = this._iLocationInFileProvider.getSignificantTextRegion(element);
    return new HoverContext(document, resource, offset, region, element);
  }
  
  protected Hover hover(final HoverContext context) {
    if ((context == null)) {
      return IHoverService.EMPTY_HOVER;
    }
    final List<Either<String, MarkedString>> contents = this.getContents(context);
    if ((contents == null)) {
      return IHoverService.EMPTY_HOVER;
    }
    final Range range = this.getRange(context);
    if ((range == null)) {
      return IHoverService.EMPTY_HOVER;
    }
    return new Hover(contents, range);
  }
  
  protected Range getRange(final HoverContext it) {
    boolean _contains = it.getRegion().contains(it.getOffset());
    boolean _not = (!_contains);
    if (_not) {
      return null;
    }
    return this._documentExtensions.newRange(it.getResource(), it.getRegion());
  }
  
  protected List<Either<String, MarkedString>> getContents(final HoverContext it) {
    final String language = this.getLanguage(it);
    final Function1<String, Either<String, MarkedString>> _function = (String value) -> {
      return this.toContents(language, value);
    };
    return ListExtensions.<String, Either<String, MarkedString>>map(this.getContents(it.getElement()), _function);
  }
  
  protected String getLanguage(final HoverContext it) {
    return null;
  }
  
  protected Either<String, MarkedString> toContents(final String language, final String value) {
    if ((language == null)) {
      return Either.<String, MarkedString>forLeft(value);
    }
    MarkedString _markedString = new MarkedString(language, value);
    return Either.<String, MarkedString>forRight(_markedString);
  }
  
  public List<String> getContents(final EObject element) {
    if ((element == null)) {
      return Collections.<String>emptyList();
    }
    final String documentation = this._iEObjectDocumentationProvider.getDocumentation(element);
    if ((documentation == null)) {
      return Collections.<String>emptyList();
    }
    return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(documentation));
  }
}
