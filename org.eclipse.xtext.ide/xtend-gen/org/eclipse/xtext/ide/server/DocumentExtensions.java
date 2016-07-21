/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.typefox.lsapi.LocationImpl;
import io.typefox.lsapi.PositionImpl;
import io.typefox.lsapi.RangeImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.LineAndColumn;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class DocumentExtensions {
  @Inject
  @Extension
  private UriExtensions _uriExtensions;
  
  @Inject
  private ILocationInFileProvider locationInFileProvider;
  
  public PositionImpl newPosition(final Resource resource, final int offset) {
    if ((resource instanceof XtextResource)) {
      IParseResult _parseResult = ((XtextResource)resource).getParseResult();
      final ICompositeNode rootNode = _parseResult.getRootNode();
      final LineAndColumn lineAndColumn = NodeModelUtils.getLineAndColumn(rootNode, offset);
      int _line = lineAndColumn.getLine();
      int _minus = (_line - 1);
      int _column = lineAndColumn.getColumn();
      int _minus_1 = (_column - 1);
      return new PositionImpl(_minus, _minus_1);
    }
    return null;
  }
  
  public RangeImpl newRange(final Resource resource, final int startOffset, final int endOffset) {
    final PositionImpl startPosition = this.newPosition(resource, startOffset);
    final PositionImpl endPosition = this.newPosition(resource, endOffset);
    return new RangeImpl(startPosition, endPosition);
  }
  
  public RangeImpl newRange(final Resource resource, final ITextRegion region) {
    if ((region == null)) {
      return null;
    }
    int _offset = region.getOffset();
    int _offset_1 = region.getOffset();
    int _length = region.getLength();
    int _plus = (_offset_1 + _length);
    return this.newRange(resource, _offset, _plus);
  }
  
  public LocationImpl newLocation(final Resource resource, final ITextRegion textRegion) {
    final LocationImpl location = new LocationImpl();
    URI _uRI = resource.getURI();
    String _path = this._uriExtensions.toPath(_uRI);
    location.setUri(_path);
    RangeImpl _newRange = this.newRange(resource, textRegion);
    location.setRange(_newRange);
    return location;
  }
  
  public LocationImpl newLocation(final EObject object) {
    final Resource resource = object.eResource();
    final ITextRegion textRegion = this.locationInFileProvider.getSignificantTextRegion(object);
    return this.newLocation(resource, textRegion);
  }
  
  public LocationImpl newLocation(final EObject owner, final EStructuralFeature feature, final int indexInList) {
    final Resource resource = owner.eResource();
    final ITextRegion textRegion = this.locationInFileProvider.getSignificantTextRegion(owner, feature, indexInList);
    return this.newLocation(resource, textRegion);
  }
}
