/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;


/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IStorage2UriMapperExtension extends IStorage2UriMapper {

	void initializeCache();
	
}
