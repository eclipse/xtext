/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import org.eclipse.xtext.GeneratedMetamodel;

/**
 * Strategy interface for post processors used to augment the generated Ecore models.
 * 
 * @author Knut Wannheden - Initial contribution and API
 * @author Michael Clay
 */
public interface IXtext2EcorePostProcessor {

	/**
	 * Process the given metatmodel (e.g. set default values, make references bi-directional, ...)
	 * 
	 * @param metamodel the metatmodel to augment
	 */
	void process(GeneratedMetamodel metamodel);
}
