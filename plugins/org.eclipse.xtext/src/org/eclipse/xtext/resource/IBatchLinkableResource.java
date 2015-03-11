/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.7
 */
public interface IBatchLinkableResource {

	void linkBatched(CancelIndicator monitor);
}
