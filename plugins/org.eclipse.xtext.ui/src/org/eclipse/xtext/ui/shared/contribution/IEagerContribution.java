/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.contribution;

import com.google.common.annotations.Beta;

/**
 * Clients that want to register shared services on startup of the Xtext framework /
 * contributions, should bind an {@link IEagerContribution} as a {@link SharedStateContribution}. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 */
@Beta
public interface IEagerContribution {

	/**
	 * Initialize the contribution eagerly.
	 */
	void initialize();
	
	/**
	 * Discard all registered state.
	 */
	void discard();
	
}
