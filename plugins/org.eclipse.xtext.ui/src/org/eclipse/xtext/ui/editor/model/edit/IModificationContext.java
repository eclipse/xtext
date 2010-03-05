/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(EditorModificationContext.class)
public interface IModificationContext {

	IXtextDocument getXtextDocument();

	void setIssue(Issue issue);
	
	@ImplementedBy(Factory.Default.class)
	public static interface Factory {
		IModificationContext createModificationContext(Issue issue);
		
		public static class Default implements Factory {
			
			@Inject
			private Provider<EditorModificationContext> provider;
			
			public IModificationContext createModificationContext(Issue issue) {
				IModificationContext modificationContext = provider.get();
				modificationContext.setIssue(issue);
				return modificationContext;
			}

		}
	}
}
