/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.findrefs;

import static com.google.common.collect.Sets.*;
import static org.eclipse.emf.ecore.util.EcoreUtil.*;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.editor.findrefs.FindReferenceQueryDataFactory;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JvmModelFindReferenceQueryDataFactory extends FindReferenceQueryDataFactory {

	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	@Override
	protected Predicate<IReferenceDescription> createResultFilter(EObject target) {
		return new JvmModelReferenceFilter(getURI(target));
	}

	@Override
	protected Set<URI> createTargetURIs(EObject target) {
		Set<URI> targetURIs = newLinkedHashSet();
		targetURIs.add(getURI(target));
		for (EObject jvmElement : jvmModelAssociations.getJvmElements(target))
			targetURIs.add(getURI(jvmElement));
		return targetURIs;
	}
}
