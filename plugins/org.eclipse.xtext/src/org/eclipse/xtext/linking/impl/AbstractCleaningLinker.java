/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;

/**
 * @author Sebastian Zarnekow
 */
public abstract class AbstractCleaningLinker extends AbstractLinker {

	public void linkModel(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		beforeModelLinked(model, diagnosticsConsumer);
		doLinkModel(model, diagnosticsConsumer);
		afterModelLinked(model, diagnosticsConsumer);
	}

	protected void afterModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		// clients may override
	}

	protected abstract void doLinkModel(EObject model,	IDiagnosticConsumer diagnosticsConsumer);

	protected void beforeModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		clearAllReferences(model);
	}

	protected void clearAllReferences(EObject model) {
		clearReferences(model);
		final Iterator<EObject> iter = model.eAllContents();
		while (iter.hasNext())
			clearReferences(iter.next());
	}
	
	protected void clearReferences(EObject obj) {
		for(EReference ref: obj.eClass().getEAllReferences())
			clearReference(obj, ref);
	}

	protected void clearReference(EObject obj, EReference ref) {
		if (!ref.isContainment() && !ref.isContainer() && !ref.isDerived() && ref.isChangeable() && !ref.isTransient())
			obj.eUnset(ref);
	}
}
