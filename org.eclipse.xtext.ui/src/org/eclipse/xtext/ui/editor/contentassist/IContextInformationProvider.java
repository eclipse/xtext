/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IContextInformationProvider {

	void getContextInformation(ContentAssistContext context, IContextInformationAcceptor acceptor);
	
}
