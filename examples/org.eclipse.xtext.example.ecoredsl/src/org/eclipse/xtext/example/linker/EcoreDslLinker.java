/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example.linker;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.linking.impl.Linker;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class EcoreDslLinker extends Linker {
	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());
	
	@Override
	protected void setDefaultValueImpl(EObject obj, EReference ref, IDiagnosticProducer producer) {
		//hack: ePackage always needs an eFactoryInstance (gets cleared in #clearReferences?)
		if (ref.getName().equalsIgnoreCase("eFactoryInstance")) {
			((EPackage) obj).setEFactoryInstance(EcoreFactory.eINSTANCE.createEFactory());
		}
		super.setDefaultValueImpl(obj, ref, producer);
	}

	@Override
	protected void clearReferences(EObject obj) {
		EList<EReference> allReferences = obj instanceof EClass ? ((EClass) obj).getEAllReferences() : obj.eClass()
				.getEAllReferences();
		// hack: exceptions when eType, eExceptions are null
		for (EReference ref : allReferences) {
			try {
				if (ref.isContainment() || 
				    ref.isContainer()   || 
				    ref.isDerived() 	|| obj.eGet(ref) == null || ref.getName() == null
						|| (obj instanceof ETypedElement && ref.getName().equalsIgnoreCase("eType"))
						|| (obj instanceof ETypedElement && ref.getName().equalsIgnoreCase("eExceptions"))) {
					continue;
				}

				clearReference(obj, ref);
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
	}
}