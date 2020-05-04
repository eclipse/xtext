/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
public class AssociationHierarchyNodeLocationProvider extends DefaultHierarchyNodeLocationProvider {
	@Override
	public ITextRegionWithLineInformation getTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		Property property = EcoreUtil2.getContainerOfType(owner, Property.class);
		if (property != null) {
			ITextRegion textRegion = locationInFileProvider.getFullTextRegion(property);
			return toTextRegionWithLineInformation(property, textRegion);
		}
		return super.getTextRegion(owner, feature, indexInList);
	}
}
