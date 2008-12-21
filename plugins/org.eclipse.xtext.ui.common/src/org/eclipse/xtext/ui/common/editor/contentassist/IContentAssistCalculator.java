/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import java.util.List;

import org.eclipse.xtext.AbstractElement;

/**
 * Strategy interface for calculating a list of <code>AbstractElement</code> elements which are applicable for 
 * the provided <code>IContentAssistContext</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public interface IContentAssistCalculator {
	
	/**
	 * Calculate a list of <code>AbstractElement</code> matching the provided <code>IContentAssistContext</code>.
	 * 
	 * @param contentAssistContext the current context of the content assist proposal request
	 * @return the list of <code>AbstractElement</code> matching the provided <code>IContentAssistContext</code>.
	 */
	List<AbstractElement> computeProposalElements(IContentAssistContext contentAssistContext);
}
