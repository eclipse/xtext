/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import org.eclipse.xtext.nodemodel.ILeafNode;

/**
 * @since 2.35
 */
public abstract class ForwardingLeafNode extends ForwardingNode implements ILeafNode {
	@Override
	protected abstract ILeafNode delegate();

	@Override
	public boolean isHidden() {
		return delegate().isHidden();
	}
	
}
