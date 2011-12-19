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
import org.eclipse.xtext.ui.editor.findrefs.ReferenceQueryExecutor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JvmModelReferenceQueryExecutor extends ReferenceQueryExecutor {

	@Inject
	private IJvmModelAssociations jvmModelAssociations;
	
	@Override
	protected String getLabelPrefix() {
		return "JVM References to ";
	}
	
	@Override
	protected Iterable<URI> getTargetURIs(EObject target) {
		Set<URI> targetURIs = newLinkedHashSet();
		targetURIs.add(getURI(target));
		for (EObject jvmElement : jvmModelAssociations.getJvmElements(target))
			targetURIs.add(getURI(jvmElement));
		return targetURIs;
	}
	
	@Override
	protected Predicate<IReferenceDescription> getFilter(EObject primaryTarget) {
		return new JvmModelReferenceFilter();
	}
}
