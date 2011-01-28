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
		
		private RichString rootObject = null;
		
		public Implementation(IRichStringPartAcceptor acceptor, IRichStringIndentationHandler indentationHandler) {
			this.acceptor = acceptor;
			this.indentationHandler = indentationHandler;
		}
		
		@Override
		public Boolean caseRichString(RichString object) {
			if (rootObject == null)
				rootObject = object;
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
			}
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean caseRichStringLiteral(RichStringLiteral object) {
			acceptor.announceNextLiteral(object);
			String value = object.getValue();
			List<TextLine> lines = TextLines.splitString(value);
			switch(lines.size()) {
				case 0: 
					return Boolean.TRUE;
				case 1: 
					handleOnlyLine(object, lines.get(0)); 
					return Boolean.TRUE;
				case 2: 
					handleFirstLine(object, lines.get(0));
					handleLastLine(object, lines.get(1));
					return Boolean.TRUE;
				default:
					handleFirstLine(object, lines.get(0));
					handleMiddleLines(object, lines.subList(1, lines.size() - 1));
					handleLastLine(object, lines.get(lines.size() - 1));
					return Boolean.TRUE;
			}
		}
		
		protected void handleMiddleLines(RichStringLiteral object, List<TextLine> lines) {
			for(TextLine line: lines) {
				pushIndentationAndAnnounceContent(object, line);
				announceSemanticLinebreak(line.getDelimiterLength(), object);
				indentationHandler.popIndentation();
			}
		}

		// we are sure to have a trailing line break
		protected void handleFirstLine(RichStringLiteral object, TextLine line) {
			if (firstEventInLine) {
				if (line.containsOnlyWhitespace()) {
					acceptor.acceptTemplateText(line, object);
					acceptor.acceptTemplateLineBreak(line.getDelimiterLength(), object);
				} else { // line has semantic data
					announceSemanticText(line, object);
					announceSemanticLinebreak(line.getDelimiterLength(), object);
				}
			} else { // line is not the first with data
				if (line.containsOnlyWhitespace()) {
					acceptor.acceptTemplateText(line, object);
					announceSemanticLinebreak(line.getDelimiterLength(), object);
				} else {
					announceSemanticText(line, object);
					announceSemanticLinebreak(line.getDelimiterLength(), object);
				}
				RichString container = (RichString) object.eContainer();
				if (container.getElements().get(0) != object)
					indentationHandler.popIndentation();
			}
		}

		protected void handleOnlyLine(RichStringLiteral object, TextLine line) {
			if (!line.hasTrailingLineBreak()) {
				if (firstEventInLine) {
					pushIndentationAndAnnounceContent(object, line);
				} else { // !firstEventInLine
					announceSemanticText(line, object);
				}
			} else { // trailing line break
				if (firstEventInLine) {
					if (line.containsOnlyWhitespace()) {
						acceptor.acceptTemplateText(line, object);
						acceptor.acceptTemplateLineBreak(line.getDelimiterLength(), object);
					} else { // line has semantic data
						announceSemanticText(line, object);
						announceSemanticLinebreak(line.getDelimiterLength(), object);
					}
				} else { // line is not the first with data
					if (line.containsOnlyWhitespace()) {
						acceptor.acceptTemplateText(line, object);
						announceSemanticLinebreak(line.getDelimiterLength(), object);
					} else {
						announceSemanticText(line, object);
						announceSemanticLinebreak(line.getDelimiterLength(), object);
					}
					RichString container = (RichString) object.eContainer();
					List<XExpression> siblings = container.getElements();
					if (siblings.get(siblings.size() - 1) != object)
						indentationHandler.popIndentation();
				}
			}
		}
		
		protected void handleLastLine(RichStringLiteral object, TextLine line) {
			if (line.hasTrailingLineBreak()) {
				pushIndentationAndAnnounceContent(object, line);
				announceSemanticLinebreak(line.getDelimiterLength(), object);
				indentationHandler.popIndentation();
			} else {
				if (line.containsOnlyWhitespace()) {
					RichString container = (RichString) object.eContainer();
					List<XExpression> siblings = container.getElements();
					if (container != rootObject) {
						if (siblings.get(siblings.size() - 1) == object)
							indentationHandler.popIndentation();
						pushIndentationAndAnnounceContent(object, line);
					} else {
						if (siblings.get(siblings.size() - 1) == object) {
							CharSequence leadingWS = line.getLeadingWhiteSpace();
							indentationHandler.pushTemplateIndentation(leadingWS);
							CharSequence tail = line.subSequence(leadingWS.length(), line.length());
							announceTemplateText(tail, object);
						} else {
							pushIndentationAndAnnounceContent(object, line);	
						}
					}
				} else {
					pushIndentationAndAnnounceContent(object, line);
				}
			}
		}

		protected void pushIndentationAndAnnounceContent(RichStringLiteral object, TextLine line) {
			CharSequence leadingWS = line.getLeadingWhiteSpace();
			pushSemanticIndentation(leadingWS);
			CharSequence tail = line.subSequence(leadingWS.length(), line.length());
			announceSemanticText(tail, object);
		}
	
		protected void pushSemanticIndentation(CharSequence line) {
			indentationHandler.pushSemanticIndentation(line);
		}
		
		protected void announceSemanticText(CharSequence text, RichStringLiteral origin) {
			announceIndentation();
			acceptor.acceptSemanticText(text, origin);
		}
		
		public void announceTemplateText(CharSequence text, RichStringLiteral origin) {
			announceIndentation();
			acceptor.acceptSemanticText(text, origin);
		}
		
		public void announceIndentation() {
			if (firstEventInLine) {
				indentationHandler.accept(acceptor);
				firstEventInLine = false;
			}
		}
		
		public void announceSemanticLinebreak(int delimiterLength, RichStringLiteral origin) {
			announceIndentation();
			acceptor.acceptSemanticLineBreak(delimiterLength, origin);
			firstEventInLine = true;
		}
		
		public String computeInitialIndentation(RichString object) {
			InitialTemplateIndentationComputer computer = new InitialTemplateIndentationComputer(
					indentationHandler.getTotalIndentation());
			String result = computer.doSwitch(object);
			return result;
		}
	}
	
}
