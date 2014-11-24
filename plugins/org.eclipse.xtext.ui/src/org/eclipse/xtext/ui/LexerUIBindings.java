/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @deprecated Use {@link org.eclipse.xtext.ide.LexerIdeBindings} instead
 */
@Deprecated
public interface LexerUIBindings {

	/**
	 * @deprecated Use {@link org.eclipse.xtext.ide.LexerIdeBindings#CONTENT_ASSIST} instead
	 */
	@Deprecated
	String CONTENT_ASSIST = org.eclipse.xtext.ide.LexerIdeBindings.CONTENT_ASSIST;
	
	/**
	 * @deprecated Use {@link org.eclipse.xtext.ide.LexerIdeBindings#HIGHLIGHTING} instead
	 */
	@Deprecated
	String HIGHLIGHTING = org.eclipse.xtext.ide.LexerIdeBindings.HIGHLIGHTING;
	
}
