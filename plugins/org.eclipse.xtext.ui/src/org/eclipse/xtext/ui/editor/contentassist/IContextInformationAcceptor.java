/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.jface.text.contentassist.IContextInformation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IContextInformationAcceptor {

	void accept(IContextInformation information);
	
	boolean canAcceptMoreInformation();
	
	class Delegate implements IContextInformationAcceptor {

		private IContextInformationAcceptor delegate;

		public void setDelegate(IContextInformationAcceptor acceptor) {
			this.delegate = acceptor;
		}
		
		public IContextInformationAcceptor getDelegate() {
			return delegate;
		}
		
		public void accept(IContextInformation information) {
			delegate.accept(information);
		}

		public boolean canAcceptMoreInformation() {
			return delegate.canAcceptMoreInformation();
		}
		
	}
	
}
