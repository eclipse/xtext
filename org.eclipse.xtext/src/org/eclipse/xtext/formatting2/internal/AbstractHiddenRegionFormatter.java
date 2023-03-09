/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.9
 */
public abstract class AbstractHiddenRegionFormatter implements IHiddenRegionFormatter {

	@Override
	public void highPriority() {
		setPriority(HIGH_PRIORITY);
	}

	@Override
	public void lowPriority() {
		setPriority(LOW_PRIORITY);
	}

	@Override
	public void newLine() {
		setNewLines(1);
	}

	@Override
	public void noSpace() {
		setSpace("");
	}

	@Override
	public void oneSpace() {
		setSpace(" ");

	}

	@Override
	public void setNewLines(int newLines) {
		setNewLines(newLines, newLines, newLines);
	}
}
