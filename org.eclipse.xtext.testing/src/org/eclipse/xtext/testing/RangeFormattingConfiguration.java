/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testing;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;

public class RangeFormattingConfiguration extends FormattingConfiguration {
	private Range range = new Range(new Position(0, 0), new Position(0, 1));

	public Range getRange() {
		return range;
	}

	public void setRange(Range range) {
		this.range = range;
	}
}
