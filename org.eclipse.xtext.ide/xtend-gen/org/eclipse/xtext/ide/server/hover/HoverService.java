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
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class HoverService {
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
  
  public Hover hover(final XtextResource resource, final int offset) {
    final Pair<EObject, ITextRegion> pair = this.getXtextElementAt(resource, offset);
    if ((((pair == null) || (pair.getFirst() == null)) || (pair.getSecond() == null))) {
      List<Either<String, MarkedString>> _emptyList = Collections.<Either<String, MarkedString>>emptyList();
      return new Hover(_emptyList, null);
    }
    final EObject element = pair.getFirst();
    final List<? extends String> contents = this.getContents(element);
    if ((contents == null)) {
      List<Either<String, MarkedString>> _emptyList_1 = Collections.<Either<String, MarkedString>>emptyList();
      return new Hover(_emptyList_1, null);
    }
    final ITextRegion textRegion = pair.getSecond();
    boolean _contains = textRegion.contains(offset);
    boolean _not = (!_contains);
    if (_not) {
      List<Either<String, MarkedString>> _emptyList_2 = Collections.<Either<String, MarkedString>>emptyList();
      return new Hover(_emptyList_2, null);
    }
    final Range range = this._documentExtensions.newRange(resource, textRegion);
    Hover _hover = new Hover();
    final Procedure1<Hover> _function = (Hover b) -> {
      b.setRange(range);
      final Function1<String, Either<String, MarkedString>> _function_1 = (String it) -> {
        return Either.<String, MarkedString>forLeft(it);
      };
      b.setContents(ListExtensions.map(contents, _function_1));
    };
    return ObjectExtensions.<Hover>operator_doubleArrow(_hover, _function);
  }
  
  protected List<? extends String> getContents(final EObject element) {
    List<String> _xblockexpression = null;
    {
      final String documentation = this._iEObjectDocumentationProvider.getDocumentation(element);
      List<String> _xifexpression = null;
      if ((documentation == null)) {
        return Collections.<String>emptyList();
      } else {
        _xifexpression = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(documentation));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected Pair<EObject, ITextRegion> getXtextElementAt(final XtextResource resource, final int offset) {
    final EObject crossLinkedEObject = this._eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, offset);
    if ((crossLinkedEObject != null)) {
      boolean _eIsProxy = crossLinkedEObject.eIsProxy();
      boolean _not = (!_eIsProxy);
      if (_not) {
        final IParseResult parseResult = resource.getParseResult();
        if ((parseResult != null)) {
          ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
          if ((((leafNode != null) && leafNode.isHidden()) && (leafNode.getOffset() == offset))) {
            leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), (offset - 1));
          }
          if ((leafNode != null)) {
            final ITextRegion leafRegion = leafNode.getTextRegion();
            return Tuples.<EObject, ITextRegion>create(crossLinkedEObject, leafRegion);
          }
        }
      }
    } else {
      final EObject o = this._eObjectAtOffsetHelper.resolveElementAt(resource, offset);
      if ((o != null)) {
        final ITextRegion region = this._iLocationInFileProvider.getSignificantTextRegion(o);
        return Tuples.<EObject, ITextRegion>create(o, region);
      }
    }
    return null;
  }
}
