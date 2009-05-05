/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultCrossReferenceSerializer extends
		AbstractCrossReferenceSerializer {

	@Inject
	private ILinkingService linkingService;

	@Override
	public String serializeCrossRef(IInstanceDescription container,
			CrossReference grammarElement, EObject target) {
		final EObject context = container.getDelegate();
		final EReference ref = GrammarUtil.getReference(grammarElement, context
				.eClass());
		final String text = linkingService.getLinkText(target, ref, context);
		if (text == null)
			throw new XtextSerializationException(
					container,
					"Error serializing CrossRefs: "
							+ "Unable to create a string represenation for reference '"
							+ grammarElement.getType().getClassifier().getName() + "' using "
							+ linkingService.getClass().getName()
							+ " EReference: " + ref.getName() + " Context:"
							+ context + " Target:" + target);
		return text;
	}

}
