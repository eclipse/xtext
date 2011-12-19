/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.occurrence;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.editor.occurrences.DefaultOccurrenceComputer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmModelOccurrenceComputer extends DefaultOccurrenceComputer {

	@Inject
	private IJvmModelAssociations associations;

	@Override
	protected Iterable<URI> getTargetURIs(EObject target) {
		return concat(super.getTargetURIs(target),
				transform(associations.getJvmElements(target), new Function<EObject, URI>() {
					public URI apply(EObject input) {
						return EcoreUtil2.getNormalizedURI(input);
					}
				}));
	}
}
