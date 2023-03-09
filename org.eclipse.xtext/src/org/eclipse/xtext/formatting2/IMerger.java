/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.List;

/**
 * Generic interface to describe an external merger for some 
 * mergable type.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
public interface IMerger<T> {
	T merge(List<? extends T> conflicting);
}
