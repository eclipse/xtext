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
	 * @param relativeOffset the offset relative to the beginning of the origin's value.
	 * @param origin the instance holding the complete text value.
	 */
	void acceptSemanticText(CharSequence text /*, int relativeOffset, RichStringLiteral origin */);
	
	/**
	 * @param text the template text. May not be <code>null</code>.
	 * @param relativeOffset the offset relative to the beginning of the origin's value.
	 * @param origin the instance holding the complete text value.
	 */
	void acceptTemplateText(CharSequence text /*, int relativeOffset, RichStringLiteral origin */);

	/**
	 * @param relativeOffset the offset relative to the beginning of the origin's value.
	 * @param origin the instance holding the complete text value.
	 */
	void acceptSemanticLineBreak(/*, int relativeOffset, RichStringLiteral origin */);
	
	/**
	 * @param relativeOffset the offset relative to the beginning of the origin's value.
	 * @param origin the instance holding the complete text value.
	 */
	void acceptTemplateLineBreak(/*, int relativeOffset, RichStringLiteral origin */);
	
	void acceptIfCondition(XExpression condition);
	
	void acceptElseIfCondition(XExpression condition);
	
	void acceptElse();
	
	void acceptEndIf();
	
	void acceptForLoop(JvmFormalParameter parameter, XExpression expression);
	
	boolean forLoopHasNext();
	
	void acceptEndFor();
	
	void acceptExpression(XExpression expression, CharSequence indentation);
	
}
