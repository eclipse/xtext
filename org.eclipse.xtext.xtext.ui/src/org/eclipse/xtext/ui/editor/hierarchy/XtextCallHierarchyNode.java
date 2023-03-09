/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyNode;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public class XtextCallHierarchyNode extends DefaultHierarchyNode {
	private IEObjectDescription grammarDescription;

	public IEObjectDescription getGrammarDescription() {
		return this.grammarDescription;
	}

	public void setGrammarDescription(final IEObjectDescription grammarDescription) {
		this.grammarDescription = grammarDescription;
	}
}