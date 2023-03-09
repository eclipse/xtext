/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr.internal;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * A linked hash set specialization that will refuse to add null values. It is notable that this implementation
 * intentionally violates the specification of {@link Collection#add(Object)} thus it should be used
 * with caution.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
public class LinkedHashSetWithoutNull<T> extends LinkedHashSet<T> {
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(T e) {
		if (e == null)
			return false;
		return super.add(e);
	}
}