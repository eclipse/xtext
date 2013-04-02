/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.parameters;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractOffsetProvider extends AbstractIntegerProvider {
	@Override
	protected String getValue() {
		return String.valueOf(getOffset());
	}

	public abstract int getOffset();
}
