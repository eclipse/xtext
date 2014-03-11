/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.navigation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.xtext.ui.TypeAwareHyperlinkHelper;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.imports.StaticallyImportedMemberProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class StaticallyImportedMemberAwareHyperlinkHelper extends TypeAwareHyperlinkHelper {
  @Inject
  @Extension
  private ILocationInFileProvider _iLocationInFileProvider;
  
  @Inject
  @Extension
  private StaticallyImportedMemberProvider _staticallyImportedMemberProvider;
  
  public void createHyperlinksByOffset(final XtextResource resource, final int offset, final IHyperlinkAcceptor acceptor) {
    EObjectAtOffsetHelper _eObjectAtOffsetHelper = this.getEObjectAtOffsetHelper();
    EObject _resolveElementAt = _eObjectAtOffsetHelper.resolveElementAt(resource, offset);
    final EObject element = _resolveElementAt;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof XImportDeclaration) {
        boolean _and = false;
        boolean _isStatic = ((XImportDeclaration)element).isStatic();
        if (!_isStatic) {
          _and = false;
        } else {
          boolean _isWildcard = ((XImportDeclaration)element).isWildcard();
          boolean _not = (!_isWildcard);
          _and = _not;
        }
        if (_and) {
          _matched=true;
          final ITextRegion textRegion = this.getTextRegion(((XImportDeclaration)element), offset);
          boolean _notEquals = (!Objects.equal(textRegion, null));
          if (_notEquals) {
            int _offset = textRegion.getOffset();
            int _length = textRegion.getLength();
            final Region region = new Region(_offset, _length);
            Iterable<JvmFeature> _allFeatures = this._staticallyImportedMemberProvider.getAllFeatures(((XImportDeclaration)element));
            for (final JvmFeature feature : _allFeatures) {
              this.createHyperlinksTo(resource, region, feature, acceptor);
            }
          }
        }
      }
    }
    super.createHyperlinksByOffset(resource, offset, acceptor);
  }
  
  public ITextRegion getTextRegion(final XImportDeclaration it, final int offset) {
    final List<INode> nodes = NodeModelUtils.findNodesForFeature(it, XtypePackage.Literals.XIMPORT_DECLARATION__MEMBER_NAME);
    for (final INode node : nodes) {
      {
        final ITextRegion textRegion = node.getTextRegion();
        boolean _contains = textRegion.contains(offset);
        if (_contains) {
          return textRegion;
        }
      }
    }
    return null;
  }
  
  protected void createHyperlinksTo(final XtextResource resource, final INode node, final EObject target, final IHyperlinkAcceptor acceptor) {
    EObject _findActualSemanticObjectFor = NodeModelUtils.findActualSemanticObjectFor(node);
    final EObject element = _findActualSemanticObjectFor;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof XImportDeclaration) {
        boolean _isStatic = ((XImportDeclaration)element).isStatic();
        if (_isStatic) {
          _matched=true;
          final ITextRegion textRegion = this._iLocationInFileProvider.getSignificantTextRegion(element, XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE, 0);
          int _offset = textRegion.getOffset();
          int _length = textRegion.getLength();
          final Region region = new Region(_offset, _length);
          this.createHyperlinksTo(resource, region, target, acceptor);
        }
      }
    }
    if (!_matched) {
      super.createHyperlinksTo(resource, node, target, acceptor);
    }
  }
}
