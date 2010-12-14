/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.ui.refactoring.ElementRenameInfo;
import org.eclipse.xtext.util.Strings;

/**
 * @author koehnlein - Initial contribution and API
 */
public class LocalReferenceUpdater extends AbstractReferenceUpdater {

	@Override
	protected CrossRefRenameInfo.Table getCrossReferenceInfos(Iterable<ElementRenameInfo> elementRenameInfos,
			ResourceSet resourceSet, RefactoringStatus status) {
		CrossRefRenameInfo.Table renamedCrossRefs = new CrossRefRenameInfo.Table();
		// TODO:  we assume the elements to be renamed are all loaded in the resource set. Is that valid?
		Map<EObject, Collection<Setting>> targetResourceInternalCrossRefs = CrossReferencer.find(Collections
				.singletonList(resourceSet));
		for (ElementRenameInfo elementRenameInfo : elementRenameInfos) {
			EObject renamedElement = resourceSet.getEObject(elementRenameInfo.getElementURI(), false);
			if (renamedElement == null || renamedElement.eIsProxy()) {
				status.addError("Cannot resolve renamed element " + Strings.notNull(elementRenameInfo.getElementURI()));
			}
			Collection<Setting> crossRefSettings = targetResourceInternalCrossRefs.get(renamedElement);
			if (crossRefSettings != null) {
				for (Setting crossRefSetting : crossRefSettings) {
					if (crossRefSetting.getEStructuralFeature().isMany()) {
						List<?> values = (List<?>) crossRefSetting.getEObject().eGet(
								crossRefSetting.getEStructuralFeature());
						for (int i = 0; i < values.size(); ++i) {
							if (renamedElement == values.get(i)) {
								renamedCrossRefs.add(elementRenameInfo.getDocument(), crossRefSetting.getEObject(),
										(EReference) crossRefSetting.getEStructuralFeature(), i, elementRenameInfo);
							}
						}
					} else {
						renamedCrossRefs.add(elementRenameInfo.getDocument(), crossRefSetting.getEObject(),
								(EReference) crossRefSetting.getEStructuralFeature(), 0, elementRenameInfo);
					}
				}
			}
		}
		return renamedCrossRefs;
	}

}
