/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.4
 */
public interface IShadowedResourceDescriptions {

	/**
	 * @return whether an {@link EObjectDescription} exists that is shadowed
	 */
	boolean isShadowed(EClass type, QualifiedName name, boolean ignoreCase);
}
