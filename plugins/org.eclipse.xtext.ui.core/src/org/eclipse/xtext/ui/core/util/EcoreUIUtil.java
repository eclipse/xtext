/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.util;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EcoreUIUtil {

	/**
	 * @see org.eclipse.emf.ecore.util.EcoreUtil#resolveAll(Resource)
	 */
	public static void resolveAll(Resource resource, IProgressMonitor monitor) {
		for (Iterator<EObject> i = resource.getAllContents(); !monitor.isCanceled() && i.hasNext();) {
			EObject eObject = i.next();
			resolveCrossReferences(eObject, monitor);
		}
	}

	/**
	 * @see org.eclipse.emf.ecore.util.EcoreUtil#resolveAll(EObject)
	 */
	public static void resolveAll(EObject eObject, IProgressMonitor monitor) {
		resolveCrossReferences(eObject, monitor);
		for (Iterator<EObject> i = eObject.eAllContents(); !monitor.isCanceled() && i.hasNext();) {
			EObject childEObject = i.next();
			resolveCrossReferences(childEObject, monitor);
		}
	}

	private static void resolveCrossReferences(EObject eObject, IProgressMonitor monitor) {
		for (Iterator<EObject> i = eObject.eCrossReferences().iterator(); !monitor.isCanceled() && i.hasNext(); i.next()) {
			// The loop resolves the cross references by visiting them.
		}
	}

}
