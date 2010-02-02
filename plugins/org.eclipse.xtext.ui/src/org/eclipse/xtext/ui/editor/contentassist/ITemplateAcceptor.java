/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.jface.text.templates.TemplateProposal;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITemplateAcceptor {

	void accept(TemplateProposal template);
	
	boolean canAcceptMoreTemplates();
	
	public class Delegate implements ITemplateAcceptor {

		private ITemplateAcceptor delegate;
		
		public void accept(TemplateProposal template) {
			delegate.accept(template);
		}

		public boolean canAcceptMoreTemplates() {
			return delegate.canAcceptMoreTemplates();
		}

		public void setDelegate(ITemplateAcceptor delegate) {
			this.delegate = delegate;
		}

		public ITemplateAcceptor getDelegate() {
			return delegate;
		}

	}
}
