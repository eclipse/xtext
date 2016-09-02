/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.hover;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.typefox.lsapi.Hover;
import io.typefox.lsapi.MarkedString;
import io.typefox.lsapi.builders.HoverBuilder;
import io.typefox.lsapi.impl.HoverImpl;
import io.typefox.lsapi.impl.MarkedStringImpl;
import io.typefox.lsapi.impl.RangeImpl;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.nodemodel.ICompositeNode;
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
      List<MarkedStringImpl> _emptyList = Collections.<MarkedStringImpl>emptyList();
      return new HoverImpl(_emptyList, null);
    }
    final EObject element = pair.getFirst();
    final List<? extends MarkedString> contents = this.getContents(element);
    if ((contents == null)) {
      List<MarkedStringImpl> _emptyList_1 = Collections.<MarkedStringImpl>emptyList();
      return new HoverImpl(_emptyList_1, null);
    }
    final ITextRegion textRegion = pair.getSecond();
    boolean _contains = textRegion.contains(offset);
    boolean _not = (!_contains);
    if (_not) {
      List<MarkedStringImpl> _emptyList_2 = Collections.<MarkedStringImpl>emptyList();
      return new HoverImpl(_emptyList_2, null);
    }
    final RangeImpl range = this._documentExtensions.newRange(resource, textRegion);
    final Procedure1<HoverBuilder> _function = (HoverBuilder b) -> {
      b.range(range);
      final Consumer<MarkedString> _function_1 = (MarkedString it) -> {
        b.content(it);
      };
      contents.forEach(_function_1);
    };
    HoverBuilder _hoverBuilder = new HoverBuilder(_function);
    return _hoverBuilder.build();
  }
  
  protected List<? extends MarkedString> getContents(final EObject element) {
    List<MarkedString> _xblockexpression = null;
    {
      final String documentation = this._iEObjectDocumentationProvider.getDocumentation(element);
      List<MarkedString> _xifexpression = null;
      if ((documentation == null)) {
        return Collections.<MarkedString>emptyList();
      } else {
        MarkedStringImpl _markedStringImpl = new MarkedStringImpl(null, documentation);
        _xifexpression = Collections.<MarkedString>unmodifiableList(CollectionLiterals.<MarkedString>newArrayList(_markedStringImpl));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected Pair<EObject, ITextRegion> getXtextElementAt(final XtextResource resource, final int offset) {
    final EObject crossLinkedEObject = this._eObjectAtOffsetHelper.resolveCrossReferencedElementAt(resource, offset);
    boolean _notEquals = (!Objects.equal(crossLinkedEObject, null));
    if (_notEquals) {
      boolean _eIsProxy = crossLinkedEObject.eIsProxy();
      boolean _not = (!_eIsProxy);
      if (_not) {
        final IParseResult parseResult = resource.getParseResult();
        boolean _notEquals_1 = (!Objects.equal(parseResult, null));
        if (_notEquals_1) {
          ICompositeNode _rootNode = parseResult.getRootNode();
          ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(_rootNode, offset);
          if ((((!Objects.equal(leafNode, null)) && leafNode.isHidden()) && (leafNode.getOffset() == offset))) {
            ICompositeNode _rootNode_1 = parseResult.getRootNode();
            ILeafNode _findLeafNodeAtOffset = NodeModelUtils.findLeafNodeAtOffset(_rootNode_1, (offset - 1));
            leafNode = _findLeafNodeAtOffset;
          }
          boolean _notEquals_2 = (!Objects.equal(leafNode, null));
          if (_notEquals_2) {
            final ITextRegion leafRegion = leafNode.getTextRegion();
            return Tuples.<EObject, ITextRegion>create(crossLinkedEObject, leafRegion);
          }
        }
      }
    } else {
      final EObject o = this._eObjectAtOffsetHelper.resolveElementAt(resource, offset);
      boolean _notEquals_3 = (!Objects.equal(o, null));
      if (_notEquals_3) {
        final ITextRegion region = this._iLocationInFileProvider.getSignificantTextRegion(o);
        return Tuples.<EObject, ITextRegion>create(o, region);
      }
    }
    return null;
  }
}
