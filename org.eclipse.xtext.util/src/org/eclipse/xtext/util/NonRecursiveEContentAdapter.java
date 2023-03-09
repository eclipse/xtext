/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.eclipse.emf.ecore.util.EContentAdapter;

/**
 * {@link EContentAdapter} with recursion disabled. Will work with EMF 2.14+ only.
 * 
 * @since 2.14
 * @author Christian Dietrich - Initial contribution and API
 */
public class NonRecursiveEContentAdapter extends EContentAdapter {

	// @Override cannot be done cause super class method is not available with current tp
	protected boolean useRecursion() {
		return false;
	}

}
