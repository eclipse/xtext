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
 * The {@link IRichStringPartAcceptor} can be passed into a {@link RichStringProcessor} to
 * handle the semantics of a {@link org.eclipse.xtext.xtend2.xtend2.RichString} for a 
 * specific use case. It's mainly an event sink but may influence the control flow
 * of the {@link RichStringProcessor} by means of {@link #forLoopHasNext()}.
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
	void acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen);
	
	/**
	 * @param origin the instance holding the complete text value that contains the line break.
	 */
	void acceptTemplateLineBreak(int charCount, RichStringLiteral origin);
	
	/**
	 * Announces that an <pre>«IF condition»</pre> has been consumed.
	 * @param condition the condition of an {@link org.eclipse.xtext.xtend2.xtend2.RichStringIf}.
	 */
	void acceptIfCondition(XExpression condition);
	
	/**
	 * Announces that an <pre>«ELSEIF condition»</pre> has been consumed.
	 * @param condition the condition of an {@link org.eclipse.xtext.xtend2.xtend2.RichStringElseIf}.
	 */
	void acceptElseIfCondition(XExpression condition);
	
	/**
	 * Announces that an <pre>«ELSE»</pre> has been consumed.
	 */
	void acceptElse();
	
	/**
	 * Announces that an <pre>«ENDIF»</pre> has been consumed.
	 */
	void acceptEndIf();

	/**
	 * Announces that a <pre>«FOR parameter: expression»</pre> has been consumed.
	 * @param parameter the declared parameter in the for-loop.
	 * @param expression the expression that produces an {@link Iterable}.
	 */
	void acceptForLoop(JvmFormalParameter parameter, XExpression expression);
	
	/**
	 * Queried to determine whether the body of the for-loop should be evaluated (again).
	 * @return <code>true</code> if the for-loop body should be evaluated.
	 */
	boolean forLoopHasNext();
	
	/**
	 * Announces that an <pre>«ENDFOR»</pre> has been consumed.
	 */
	void acceptEndFor();
	
	/**
	 * Announces that an <pre>«expression»</pre> has been consumed. If the expression's 
	 * evaluation result contains more than one line, any line besides the first one may be
	 * prefixed with the given indentation.
	 * @param expression the consumed expression. May not be <code>null</code>.
	 * @param indentation the additional indentation for any line besides the first one.
	 */
	void acceptExpression(XExpression expression, CharSequence indentation);

	/**
	 * Announces that a next literal will be processed.
	 * @param literal the literal.
	 */
	void announceNextLiteral(RichStringLiteral literal);
	
}
