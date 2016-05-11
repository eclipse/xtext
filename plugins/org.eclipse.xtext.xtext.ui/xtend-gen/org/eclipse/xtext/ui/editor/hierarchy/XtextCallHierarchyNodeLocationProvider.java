/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import com.google.inject.Singleton;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyNodeLocationProvider;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Singleton
@SuppressWarnings("all")
public class XtextCallHierarchyNodeLocationProvider extends DefaultHierarchyNodeLocationProvider {
  @Override
  public ITextRegionWithLineInformation getTextRegion(final EObject owner, final EStructuralFeature feature, final int indexInList) {
    final Assignment assignment = GrammarUtil.containingAssignment(owner);
    if ((assignment != null)) {
      return this.getTextRegion(assignment);
    }
    return super.getTextRegion(owner, feature, indexInList);
  }
}
