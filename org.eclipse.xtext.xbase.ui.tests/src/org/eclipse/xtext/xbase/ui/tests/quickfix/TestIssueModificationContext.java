/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.quickfix;

import com.google.inject.Singleton;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;

@Singleton
public class TestIssueModificationContext extends IssueModificationContext {
	private IXtextDocument doc;

	@Override
	public IXtextDocument getXtextDocument() {
		return doc;
	}

	public IXtextDocument setDocument(IXtextDocument doc) {
		return this.doc = doc;
	}
}
