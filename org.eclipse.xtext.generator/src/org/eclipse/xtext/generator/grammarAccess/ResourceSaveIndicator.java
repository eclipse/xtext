/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import org.eclipse.xtext.util.Wrapper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public class ResourceSaveIndicator extends Wrapper<Boolean> {

	public ResourceSaveIndicator() {
		super(Boolean.FALSE);
	}

	public boolean isSaving() {
		return get().booleanValue();
	}

}
