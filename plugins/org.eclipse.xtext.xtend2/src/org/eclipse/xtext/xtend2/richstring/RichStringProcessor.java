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
			while(acceptor.forLoopHasNext())
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
			List<TextLine> lines = TextLines.splitString(value);
			// only one line - everything is semantic
			if (lines.size() == 1) {
				TextLine line = lines.get(0);
				handleOnlyLine(object, line);
				return Boolean.TRUE;
			}
			for(int i = 0; i < lines.size(); i++) {
				TextLine line = lines.get(i);
				if (i == 0) {
					// first line contains only WS
					if (line.containsOnlyWhitespace()) {
						acceptor.acceptTemplateText(line);
						if (firstEventInLine) {
							acceptor.acceptTemplateLineBreak();
						} else {
							announceSemanticLinebreak();
							indentationHandler.popIndentation();
						}
					} else {
						acceptor.acceptSemanticText(line);
						acceptor.acceptSemanticLineBreak();
					}
				} else {
					CharSequence leadingWS = line.getLeadingWhiteSpace();
					pushSemanticIndentation(leadingWS);
					CharSequence tail = line.subSequence(leadingWS.length(), line.length());
					announceSemanticText(tail);
					if (line.hasTrailingLineBreak()) {
						announceSemanticLinebreak();
						indentationHandler.popIndentation();
					} else if (isLastRichStringPart(object)) {
						indentationHandler.popIndentation();
					}
				}
			}
			return Boolean.TRUE;
		}

		protected void handleOnlyLine(RichStringLiteral object, TextLine line) {
			if (!line.hasTrailingLineBreak()) {
				if (!firstEventInLine) {
					announceSemanticText(line);
				} else {
					CharSequence leadingWS = line.getLeadingWhiteSpace();
					pushSemanticIndentation(leadingWS);
					CharSequence tail = line.subSequence(leadingWS.length(), line.length());
					doAnnounceSemanticText(tail);
					if (isLastRichStringPart(object)) {
						indentationHandler.popIndentation();
					}
				}
			} else {
				if (!firstEventInLine) {
					announceSemanticText(line);
					announceSemanticLinebreak();
					indentationHandler.popIndentation();
				} else {
					if (line.containsOnlyWhitespace()) {
						acceptor.acceptTemplateText(line);
						acceptor.acceptTemplateLineBreak();
					} else {
						CharSequence leadingWS = line.getLeadingWhiteSpace();
						pushSemanticIndentation(leadingWS);
						CharSequence tail = line.subSequence(leadingWS.length(), line.length());
						announceSemanticText(tail);
						announceSemanticLinebreak();
						indentationHandler.popIndentation();
					}
				}
			}
		}

		protected boolean isLastRichStringPart(RichStringLiteral object) {
			RichString richString = (RichString) object.eContainer();
			List<XExpression> siblings = richString.getElements();
			boolean result = object == siblings.get(siblings.size()-1);
			return result;
		}

		protected void pushSemanticIndentation(CharSequence line) {
			indentationHandler.pushSemanticIndentation(line);
		}
		
		public void announceSemanticText(CharSequence text) {
			if (text.length() != 0) {
				doAnnounceSemanticText(text);
			}
		}

		protected void doAnnounceSemanticText(CharSequence text) {
			announceIndentation();
			acceptor.acceptSemanticText(text);
		}
		
		public void announceTemplateText(CharSequence text) {
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
		
		public String computeInitialIndentation(RichString object) {
			InitialTemplateIndentationComputer computer = new InitialTemplateIndentationComputer();
			String result = computer.doSwitch(object);
			return result;
		}
	}
	
}
