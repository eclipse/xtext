/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.contribution;

/**
 * Clients that want to register shared services on startup of the Xtext framework /
 * contributions, should bind an {@link EagerContribution} as a {@link SharedStateContribution}. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 */
public interface EagerContribution {

	/**
	 * Initialize the contribution eagerly.
	 */
	void initialize();
	
	/**
	 * Discard all registered state.
	 */
	void discard();
	
}
