/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.richstring;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IRichStringPartAcceptor {

	/**
	 * @param text the semantic text. May not be <code>null</code>
	 */
	void acceptSemanticText(String text);
	
	/**
	 * @param text the semantic text. May not be <code>null</code>
	 */
	void acceptTemplateText(String text);
	
	void acceptSemanticLineBreak();
	
	void acceptTemplateLineBreak();
	
	void acceptIfCondition(XExpression condition);
	
	void acceptElseIfCondition(XExpression condition);
	
	void acceptElse();
	
	void acceptEndIf();
	
	void acceptForLoop(JvmFormalParameter parameter, XExpression expression);
	
	void acceptEndFor();
	
	void acceptExpression(XExpression expression, String indentation);
	
}
