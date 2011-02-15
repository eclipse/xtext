/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.refactoring;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.DefaultReferenceUpdater;
import org.eclipse.xtext.xtend2.linking.IXtend2JvmAssociations;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2ReferenceUpdater extends DefaultReferenceUpdater {

	@Inject
	private IXtend2JvmAssociations xtend2jvmAssociations;

	@Override
	protected void createReferenceUpdate(EObject referringElement, URI referringResourceURI, EReference reference,
			int indexInList, EObject newTargetElement, IRefactoringUpdateAcceptor updateAcceptor) {
		if (!isInferredJvmModelElement(referringElement))
			super.createReferenceUpdate(referringElement, referringResourceURI, reference, indexInList,
					newTargetElement, updateAcceptor);
	}
	
	protected boolean isInferredJvmModelElement(EObject element) {
		EObject rootContainer = EcoreUtil.getRootContainer(element);
		return !isEmpty(xtend2jvmAssociations.getXtendElements(rootContainer));
	}
	
}
