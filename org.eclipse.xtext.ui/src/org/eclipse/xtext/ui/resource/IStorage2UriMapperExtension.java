/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
