/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
public class XtextCallHierarchyNodeLocationProvider extends DefaultHierarchyNodeLocationProvider {

	@Override
	public ITextRegionWithLineInformation getTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		Assignment assignment = GrammarUtil.containingAssignment(owner);
		if (assignment != null) {
			return getTextRegion(assignment);
		}
		return super.getTextRegion(owner, feature, indexInList);
	}
}
