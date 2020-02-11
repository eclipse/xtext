/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import com.google.inject.ImplementedBy;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyNodeLocationProvider;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

/**
 * This class is used to identify a region for {@link IHierarchyNode} and {@link IHierarchyNodeReference}.
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@ImplementedBy(DefaultHierarchyNodeLocationProvider.class)
@SuppressWarnings("all")
public interface IHierarchyNodeLocationProvider {
  ITextRegionWithLineInformation getTextRegion(final EObject obj);
  
  ITextRegionWithLineInformation getTextRegion(final EObject owner, final EStructuralFeature feature, final int indexInList);
}
