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
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IRichStringPartAcceptor {

	/**
	 * @param text the semantic text. May not be <code>null</code>.
	 * @param origin the value holder for the full text or null, if unknown.
	 */
	void acceptSemanticText(CharSequence text, RichStringLiteral origin);
	
	/**
	 * @param text the template text. May not be <code>null</code>.
	 * @param origin the value holder for the full text or null, if unknown.
	 */
	void acceptTemplateText(CharSequence text, RichStringLiteral origin);

	/**
	 * @param origin the instance holding the complete text value that contains the line break.
	 */
	void acceptSemanticLineBreak(int charCount, RichStringLiteral origin);
	
	/**
	 * @param origin the instance holding the complete text value that contains the line break.
	 */
	void acceptTemplateLineBreak(int charCount, RichStringLiteral origin);
	
	void acceptIfCondition(XExpression condition);
	
	void acceptElseIfCondition(XExpression condition);
	
	void acceptElse();
	
	void acceptEndIf();
	
	void acceptForLoop(JvmFormalParameter parameter, XExpression expression);
	
	boolean forLoopHasNext();
	
	void acceptEndFor();
	
	void acceptExpression(XExpression expression, CharSequence indentation);

	void announceNextLiteral(RichStringLiteral object);
	
}
