/*******************************************************************************
 * Copyright (c) 2021 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.folding;

/**
 * Contains the possible kinds of folding ranges defined by the LSP spec.
 * 
 * @author Mark Sujew - Initial contribution and API
 * 
 * @since 2.26
 */
public class FoldingRangeKind {
	public static final FoldingRangeKind COMMENT = new FoldingRangeKind("comment");
	public static final FoldingRangeKind IMPORTS = new FoldingRangeKind("imports");
	public static final FoldingRangeKind REGION = new FoldingRangeKind("region");

	private String kind;

	private FoldingRangeKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return kind;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof FoldingRangeKind) {
			return this.kind.equals(((FoldingRangeKind) other).kind);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return kind.hashCode();
	}
}
