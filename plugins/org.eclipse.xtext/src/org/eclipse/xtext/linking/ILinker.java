/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ILinker {

	/**
	 * sets cross references in the passed {@link EObject} and its {@link EObject#eAllContents()},
	 * using the information available (usually using the {@link AbstractNode} model associated via {@link NodeAdapter})
	 * 
	 * @param model
	 * @param diagnosticsConsumer
	 */
	void linkModel(EObject model, IDiagnosticConsumer diagnosticsConsumer);

}
