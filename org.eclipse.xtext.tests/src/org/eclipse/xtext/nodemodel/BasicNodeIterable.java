/*******************************************************************************
 * Copyright (c) 2020 Robert Lewis and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.xtext.nodemodel.impl.AbstractNode;

/**
 * @author Robert Lewis - Initial contribution and API
 */
public class BasicNodeIterable extends org.eclipse.xtext.nodemodel.impl.BasicNodeIterable {

	protected BasicNodeIterable(AbstractNode startWith) {
		super(startWith);
	}

}
