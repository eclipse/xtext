/*******************************************************************************
 * Copyright (c) 2009, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import org.eclipse.xtext.GeneratedMetamodel;

/**
 * Strategy interface for post processors used to augment the generated Ecore models.
 * 
 * @author Knut Wannheden - Initial contribution and API
 * @author Michael Clay
 * @deprecated Switch to a manually maintained metamodel instead.
 */
@Deprecated
public interface IXtext2EcorePostProcessor {

	/**
	 * Process the given metatmodel (e.g. set default values, make references bi-directional, ...)
	 * 
	 * @param metamodel the metatmodel to augment
	 */
	void process(GeneratedMetamodel metamodel);
}
