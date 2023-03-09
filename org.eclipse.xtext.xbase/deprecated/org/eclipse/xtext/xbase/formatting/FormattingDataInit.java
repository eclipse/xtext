/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @deprecated use {@link IHiddenRegionFormatter}
 */
@Deprecated
public class FormattingDataInit {
	public String space = null;

	public Integer newLines = null;

	public int increaseIndentationChange = 0;

	public int decreaseIndentationChange = 0;

	public PreferenceKey key = null;

	public void cfg(PreferenceKey key) {
		this.key = key;
	}

	public void newLine() {
		newLines = 1;
	}

	public void noSpace() {
		space = "";
	}

	public void oneSpace() {
		space = " ";
	}

	public void increaseIndentation() {
		increaseIndentationChange = increaseIndentationChange + 1;
	}

	public void decreaseIndentation() {
		decreaseIndentationChange = decreaseIndentationChange - 1;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).addAllFields().toString();
	}
}
