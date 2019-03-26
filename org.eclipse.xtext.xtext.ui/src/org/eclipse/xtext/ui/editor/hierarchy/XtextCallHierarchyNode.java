/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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