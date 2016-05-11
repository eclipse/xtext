/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy;

import com.google.inject.Singleton;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyNodeLocationProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class AssociationHierarchyNodeLocationProvider extends DefaultHierarchyNodeLocationProvider {
  @Override
  public ITextRegionWithLineInformation getTextRegion(final EObject owner, final EStructuralFeature feature, final int indexInList) {
    final Property property = EcoreUtil2.<Property>getContainerOfType(owner, Property.class);
    if ((property != null)) {
      final ITextRegion textRegion = this.locationInFileProvider.getFullTextRegion(property);
      return this.toTextRegionWithLineInformation(property, textRegion);
    }
    return super.getTextRegion(owner, feature, indexInList);
  }
}
