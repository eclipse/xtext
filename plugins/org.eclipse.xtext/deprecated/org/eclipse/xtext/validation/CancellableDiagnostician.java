/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated use {@link CancelableDiagnostician} instead.
 */
@Deprecated
public class CancellableDiagnostician extends CancelableDiagnostician {

	@Inject
	public CancellableDiagnostician(Registry registry) {
		super(registry);
	}

}
