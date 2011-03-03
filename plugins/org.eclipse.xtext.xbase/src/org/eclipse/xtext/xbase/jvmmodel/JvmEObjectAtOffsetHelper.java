/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmEObjectAtOffsetHelper extends EObjectAtOffsetHelper {

	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	@Override
	public EObject resolveCrossReferencedElementAt(XtextResource resource, int offset) {
		return convertToSource(super.resolveCrossReferencedElementAt(resource, offset));
	}
	
	@Override
	public EObject resolveElementAt(XtextResource resource, int offset) {
		return convertToSource(super.resolveElementAt(resource, offset));
	}
	
	protected EObject convertToSource(EObject element) {
		if(element == null)
			return null;
		Iterable<EObject> sourceElements = jvmModelAssociations.getSourceElements(element, false);
		return (isEmpty(sourceElements)) ? element : sourceElements.iterator().next();
	}

}
