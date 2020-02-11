/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.4
 */
@ImplementedBy(DefaultResourceUIServiceProvider.class)
public interface IResourceUIServiceProviderExtension {

	/**
	 * @return returns true, if the file described by uri and storage should be handled by the Xtext builder.
	 */
	boolean canBuild(URI uri, IStorage storage);

}
