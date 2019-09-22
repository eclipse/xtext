/**
 * Copyright (c) 2016, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.editor.hierarchy;

import com.google.inject.Singleton;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.example.arithmetics.arithmetics.FunctionCall;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyNodeLocationProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

@Singleton
@SuppressWarnings("all")
public class ArithmeticsCallHierarchyNodeLocationProvider extends DefaultHierarchyNodeLocationProvider {
  @Override
  public ITextRegionWithLineInformation getTextRegion(final EObject owner, final EStructuralFeature feature, final int indexInList) {
    if ((owner instanceof FunctionCall)) {
      final ITextRegion textRegion = this.locationInFileProvider.getFullTextRegion(owner);
      return this.toTextRegionWithLineInformation(owner, textRegion);
    }
    return super.getTextRegion(owner, feature, indexInList);
  }
}
