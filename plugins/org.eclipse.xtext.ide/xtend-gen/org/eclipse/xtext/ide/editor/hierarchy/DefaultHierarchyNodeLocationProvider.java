/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeLocationProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.LineAndColumn;
import org.eclipse.xtext.util.TextRegionWithLineInformation;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Singleton
@SuppressWarnings("all")
public class DefaultHierarchyNodeLocationProvider implements IHierarchyNodeLocationProvider {
  @Inject
  protected ILocationInFileProvider locationInFileProvider;
  
  @Override
  public ITextRegionWithLineInformation getTextRegion(final EObject obj) {
    if ((obj == null)) {
      return ITextRegionWithLineInformation.EMPTY_REGION;
    }
    final ITextRegion textRegion = this.locationInFileProvider.getSignificantTextRegion(obj);
    return this.toTextRegionWithLineInformation(obj, textRegion);
  }
  
  @Override
  public ITextRegionWithLineInformation getTextRegion(final EObject owner, final EStructuralFeature feature, final int indexInList) {
    if ((owner == null)) {
      return ITextRegionWithLineInformation.EMPTY_REGION;
    }
    final ITextRegion textRegion = this.locationInFileProvider.getSignificantTextRegion(owner, feature, indexInList);
    return this.toTextRegionWithLineInformation(owner, textRegion);
  }
  
  protected ITextRegionWithLineInformation toTextRegionWithLineInformation(final EObject obj, final ITextRegion textRegion) {
    if ((textRegion == null)) {
      return ITextRegionWithLineInformation.EMPTY_REGION;
    }
    if ((textRegion instanceof ITextRegionWithLineInformation)) {
      return ((ITextRegionWithLineInformation)textRegion);
    }
    final ICompositeNode node = NodeModelUtils.getNode(obj);
    if ((node == null)) {
      int _offset = textRegion.getOffset();
      int _length = textRegion.getLength();
      return new TextRegionWithLineInformation(_offset, _length, 0, 0);
    }
    int _offset_1 = textRegion.getOffset();
    LineAndColumn _lineAndColumn = NodeModelUtils.getLineAndColumn(node, _offset_1);
    int _line = _lineAndColumn.getLine();
    final int startLine = (_line - 1);
    int _offset_2 = textRegion.getOffset();
    int _length_1 = textRegion.getLength();
    int _plus = (_offset_2 + _length_1);
    LineAndColumn _lineAndColumn_1 = NodeModelUtils.getLineAndColumn(node, _plus);
    int _line_1 = _lineAndColumn_1.getLine();
    final int endLine = (_line_1 - 1);
    int _offset_3 = textRegion.getOffset();
    int _length_2 = textRegion.getLength();
    return new TextRegionWithLineInformation(_offset_3, _length_2, startLine, endLine);
  }
}
