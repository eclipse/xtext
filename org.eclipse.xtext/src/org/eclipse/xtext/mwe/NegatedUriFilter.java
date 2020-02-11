/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe2.runtime.Mandatory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NegatedUriFilter implements UriFilter {

	private UriFilter uriFilter;
	
	@Override
	public boolean matches(URI uri) {
		return !getUriFilter().matches(uri);
	}

	@Mandatory
	public void setUriFilter(UriFilter uriFilter) {
		this.uriFilter = uriFilter;
	}

	public UriFilter getUriFilter() {
		return uriFilter;
	}

}
