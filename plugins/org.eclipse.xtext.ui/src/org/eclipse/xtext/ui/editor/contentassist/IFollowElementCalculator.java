/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;

/**
 * Strategy interface for calculating a list of <code>AbstractElement</code> elements which are applicable for
 * the provided <code>resource</code> at the given <code>offset</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public interface IFollowElementCalculator {
	
	interface IFollowElementAcceptor {
		void accept(AbstractElement element);
	}
	
	/**
	 * Calculate a list of <code>AbstractElement</code> matching the provided <code>IContentAssistContext</code>.
	 * 
	 * @param contentAssistContext the current context of the content assist proposal request
	 * @return the list of <code>AbstractElement</code> matching the provided <code>IContentAssistContext</code>.
	 */
	void calculateValidElements(CompositeNode rootNode, AbstractNode lastCompleteNode, int offset, IFollowElementAcceptor acceptor);
}