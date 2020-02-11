/**
 * Copyright (c) 2019 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.rename;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.server.rename.RenameService2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class TestLanguageRenameService extends RenameService2 {
  @Inject
  @Extension
  private EObjectAtOffsetHelper _eObjectAtOffsetHelper;
  
  @Override
  protected EObject getElementWithIdentifierAt(final XtextResource xtextResource, final int offset) {
    if ((offset >= 0)) {
      IParseResult _parseResult = null;
      if (xtextResource!=null) {
        _parseResult=xtextResource.getParseResult();
      }
      ICompositeNode _rootNode = null;
      if (_parseResult!=null) {
        _rootNode=_parseResult.getRootNode();
      }
      final ICompositeNode rootNode = _rootNode;
      if ((rootNode != null)) {
        final ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset);
        if (((leaf != null) && this.isIdentifier(leaf))) {
          final EObject element = this._eObjectAtOffsetHelper.resolveElementAt(xtextResource, offset);
          if ((element != null)) {
            final IQualifiedNameProvider nameProvider = xtextResource.getResourceServiceProvider().<IQualifiedNameProvider>get(IQualifiedNameProvider.class);
            final QualifiedName fqn = nameProvider.getFullyQualifiedName(element);
            if ((fqn != null)) {
              final String leafText = NodeModelUtils.getTokenText(leaf);
              if ((((fqn.getSegmentCount() == 1) && Objects.equal(fqn.toString(), leafText)) || Objects.equal(fqn.getLastSegment(), leafText))) {
                return element;
              }
            }
          }
        }
      }
    }
    return null;
  }
}
