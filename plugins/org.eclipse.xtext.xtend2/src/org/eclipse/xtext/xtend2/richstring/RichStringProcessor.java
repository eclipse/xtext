/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.richstring;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringElseIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringForLoop;
import org.eclipse.xtext.xtend2.xtend2.RichStringIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;
import org.eclipse.xtext.xtend2.xtend2.util.Xtend2Switch;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringProcessor {
	
	public void process(RichString richString, IRichStringPartAcceptor acceptor, IRichStringIndentationHandler indentationHandler) {
		Implementation implementation = new Implementation(acceptor, indentationHandler);
		implementation.doSwitch(richString);
	}
	
	public static class Implementation extends Xtend2Switch<Boolean> {
	
		private final IRichStringPartAcceptor acceptor;

		private final IRichStringIndentationHandler indentationHandler;
		
		private boolean firstEventInLine = true;
		
		public Implementation(IRichStringPartAcceptor acceptor, IRichStringIndentationHandler indentationHandler) {
			this.acceptor = acceptor;
			this.indentationHandler = indentationHandler;
		}
		
		@Override
		public Boolean caseRichString(RichString object) {
			String indentation = computeInitialIndentation(object);
			indentationHandler.pushTemplateIndentation(indentation);
			List<XExpression> elements = object.getElements();
			for(XExpression element: elements) {
				doSwitch(element);
			}
			indentationHandler.popIndentation();
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean caseRichStringForLoop(RichStringForLoop object) {
			acceptor.acceptForLoop(object.getDeclaredParam(), object.getForExpression());
			doSwitch(object.getEachExpression());
			acceptor.acceptEndFor();
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean caseRichStringIf(RichStringIf object) {
			acceptor.acceptIfCondition(object.getIf());
			doSwitch(object.getThen());
			for(RichStringElseIf elseIf: object.getElseIfs()) {
				acceptor.acceptElseIfCondition(elseIf.getIf());
				doSwitch(elseIf.getThen());
			}
			if (object.getElse() != null) {
				acceptor.acceptElse();
				doSwitch(object.getElse());
			}
			acceptor.acceptEndIf();
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean defaultCase(EObject object) {
			if (object instanceof XExpression) {
				// caseXExpression does not work since object.ePackage != Xtend2Switch.modelPackage
				announceIndentation();
				acceptor.acceptExpression((XExpression) object, indentationHandler.getTotalSemanticIndentation());
				return Boolean.TRUE;
			}
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean caseRichStringLiteral(RichStringLiteral object) {
			String value = object.getValue();
			String[] split = value.split("\\r?\\n");
			// only one line - everything is semantic
			if (split.length == 1) {
				String line = split[0];
				if (!firstEventInLine) {
					announceSemanticText(line);
				} else {
					String leadingWS = Strings.getLeadingWhiteSpace(line);
					pushSemanticIndentation(leadingWS);
					String tail = line.substring(leadingWS.length());
					announceSemanticText(tail);
				}
				return Boolean.TRUE;
			}
			for(int i = 0; i < split.length; i++) {
				String line = split[i];
				String leadingWS = Strings.getLeadingWhiteSpace(line);
				if (i == 0) {
					// first line contains only WS
					if (leadingWS == line) {
						acceptor.acceptTemplateText(line);
						acceptor.acceptTemplateLineBreak();
					} else {
						acceptor.acceptSemanticText(line);
						acceptor.acceptSemanticLineBreak();
					}
				} else if (i == split.length - 1) {
					pushSemanticIndentation(leadingWS);
					String tail = line.substring(leadingWS.length());
					announceSemanticText(tail);
					// "\n zonk\n".split(..) == { "", " zonk" }
					if (value.endsWith("\n")) {
						announceSemanticLinebreak();
						indentationHandler.popIndentation();
					}
				} else {
					pushSemanticIndentation(leadingWS);
					String tail = line.substring(leadingWS.length());
					announceSemanticText(tail);
					announceSemanticLinebreak();
					indentationHandler.popIndentation();
				}
			}
			return Boolean.TRUE;
		}

		protected void pushSemanticIndentation(String line) {
			indentationHandler.pushSemanticIndentation(line);
		}
		
		public void announceSemanticText(String text) {
			if (text.length() != 0) {
				announceIndentation();
				acceptor.acceptSemanticText(text);
			}
		}
		
		public void announceTemplateText(String text) {
			announceIndentation();
			acceptor.acceptSemanticText(text);
		}
		
		public void announceIndentation() {
			if (firstEventInLine) {
				indentationHandler.accept(acceptor);
				firstEventInLine = false;
			}
		}
		
		public void announceSemanticLinebreak() {
			announceIndentation();
			acceptor.acceptSemanticLineBreak();
			firstEventInLine = true;
		}
		
		public void announceTemplateLinebreak() {
			announceIndentation();
			acceptor.acceptTemplateLineBreak();
//			firstEventInLine = true;
		}
	
		public String computeInitialIndentation(RichString object) {
			InitialTemplateIndentationComputer computer = new InitialTemplateIndentationComputer();
			String result = computer.doSwitch(object);
			return result;
		}
		
	}
	
}
