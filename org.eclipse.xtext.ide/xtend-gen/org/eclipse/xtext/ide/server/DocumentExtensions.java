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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
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
  
  public Position newPosition(final Resource resource, final int offset) {
    if ((resource instanceof XtextResource)) {
      final ICompositeNode rootNode = ((XtextResource)resource).getParseResult().getRootNode();
      final LineAndColumn lineAndColumn = NodeModelUtils.getLineAndColumn(rootNode, offset);
      int _line = lineAndColumn.getLine();
      int _minus = (_line - 1);
      int _column = lineAndColumn.getColumn();
      int _minus_1 = (_column - 1);
      return new Position(_minus, _minus_1);
    }
    return null;
  }
  
  public Range newRange(final Resource resource, final int startOffset, final int endOffset) {
    final Position startPosition = this.newPosition(resource, startOffset);
    if ((startPosition == null)) {
      return null;
    }
    final Position endPosition = this.newPosition(resource, endOffset);
    if ((endPosition == null)) {
      return null;
    }
    return new Range(startPosition, endPosition);
  }
  
  public Range newRange(final Resource resource, final ITextRegion region) {
    if ((region == null)) {
      return null;
    }
    int _offset = region.getOffset();
    int _offset_1 = region.getOffset();
    int _length = region.getLength();
    int _plus = (_offset_1 + _length);
    return this.newRange(resource, _offset, _plus);
  }
  
  public Location newLocation(final Resource resource, final ITextRegion textRegion) {
    final Range range = this.newRange(resource, textRegion);
    if ((range == null)) {
      return null;
    }
    final String uri = this._uriExtensions.toUriString(resource.getURI());
    return new Location(uri, range);
  }
  
  public Location newLocation(final EObject object) {
    final Resource resource = object.eResource();
    final ITextRegion textRegion = this.locationInFileProvider.getSignificantTextRegion(object);
    return this.newLocation(resource, textRegion);
  }
  
  public Location newLocation(final EObject owner, final EStructuralFeature feature, final int indexInList) {
    final Resource resource = owner.eResource();
    final ITextRegion textRegion = this.locationInFileProvider.getSignificantTextRegion(owner, feature, indexInList);
    return this.newLocation(resource, textRegion);
  }
}
