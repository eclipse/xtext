/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.richstring;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.richstring.util.ProcessedRichStringSwitch;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringElseIf;
import org.eclipse.xtend.core.xtend.RichStringForLoop;
import org.eclipse.xtend.core.xtend.RichStringIf;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtend.core.xtend.util.XtendSwitch;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringProcessor {

	public void process(RichString richString, IRichStringPartAcceptor acceptor,
			IRichStringIndentationHandler indentationHandler) {
		ProcessedRichString processedRichString = new ProcessedRichStringBuilder().processRichString(richString);
		Implementation implementation = new Implementation(acceptor, indentationHandler);
		implementation.doSwitch(processedRichString);
	}
	
	public static class ProcessedRichStringBuilder extends XtendSwitch<Boolean> {

		@Inject
		private ProcessedRichStringFactory factory = ProcessedRichStringFactory.eINSTANCE;
		
		private ProcessedRichString result = null;

		private Line currentLine = null; 
		
		public ProcessedRichString processRichString(RichString richString) {
			if (result != null || currentLine != null)
				throw new IllegalStateException("result is already set");
			doSwitch(richString);
			return result;
		}
		
		@Override
		public Boolean doSwitch(EObject theEObject) {
			if(theEObject == null)
				return Boolean.TRUE;
			return super.doSwitch(theEObject);
		}
		
		protected void addToCurrentLine(LinePart part) {
			if (currentLine == null) {
				currentLine = factory.createLine();
				if (!(part instanceof Literal) && !result.getLines().isEmpty()) {
					Line prevLine = result.getLines().get(result.getLines().size() - 1);
					LineBreak lineBreak = (LineBreak) prevLine.getParts().get(prevLine.getParts().size() - 1);
					Literal literal = factory.createLiteral();
					literal.setLength(0);
					literal.setOffset(lineBreak.getLiteral().getValue().length());
					literal.setLiteral(lineBreak.getLiteral());
					currentLine.getParts().add(literal);
				}
				result.getLines().add(currentLine);
			}
			if (part != null)
				currentLine.getParts().add(part);
		}
		
		@Override
		public Boolean caseRichString(RichString object) {
			if (result == null) {
				result = factory.createProcessedRichString();
				result.setRichString(object);
			}
			List<XExpression> elements = object.getExpressions();
			for (XExpression element : elements) {
				doSwitch(element);
			}
			if (currentLine == null && !result.getLines().isEmpty()) {
				// add next line with empty text since the previous ends with a line break
				addToCurrentLine(null);
			}
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseRichStringForLoop(RichStringForLoop object) {
			ForLoopStart start = factory.createForLoopStart();
			start.setLoop(object);
			addToCurrentLine(start);
			doSwitch(object.getEachExpression());
			ForLoopEnd end = factory.createForLoopEnd();
			end.setStart(start);
			addToCurrentLine(end);
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseRichStringIf(RichStringIf object) {
			IfConditionStart start = factory.createIfConditionStart();
			start.setRichStringIf(object);
			addToCurrentLine(start);
			doSwitch(object.getThen());
			for (RichStringElseIf elseIf : object.getElseIfs()) {
				ElseIfCondition elseIfStart = factory.createElseIfCondition();
				elseIfStart.setIfConditionStart(start);
				elseIfStart.setRichStringElseIf(elseIf);
				addToCurrentLine(elseIfStart);
				doSwitch(elseIf.getThen());
			}
			if (object.getElse() != null) {
				ElseStart elseStart = factory.createElseStart();
				elseStart.setIfConditionStart(start);
				addToCurrentLine(elseStart);
				doSwitch(object.getElse());
			}
			EndIf end = factory.createEndIf();
			end.setIfConditionStart(start);
			addToCurrentLine(end);
			return Boolean.TRUE;
		}

		@Override
		public Boolean defaultCase(EObject object) {
			if (object instanceof XExpression) {
				// caseXExpression does not work since object.ePackage != XtendSwitch.modelPackage
				PrintedExpression printedExpression = factory.createPrintedExpression();
				printedExpression.setExpression((XExpression) object);
				addToCurrentLine(printedExpression);
			}
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseRichStringLiteral(RichStringLiteral object) {
			String value = object.getValue();
			List<TextLine> lines = TextLines.splitString(value);
			if (lines.isEmpty()) {
				Literal literal = factory.createLiteral();
				literal.setLength(0);
				literal.setOffset(0);
				literal.setLiteral(object);
				addToCurrentLine(literal);
			} else {
				for(TextLine textLine: lines) {
					Literal literal = factory.createLiteral();
					literal.setLength(textLine.length());
					literal.setOffset(textLine.getRelativeOffset());
					literal.setLiteral(object);
					addToCurrentLine(literal);
					if (textLine.hasTrailingLineBreak()) {
						LineBreak lineBreak = factory.createLineBreak();
						lineBreak.setLength(textLine.getDelimiterLength());
						lineBreak.setOffset(textLine.getRelativeOffset() + textLine.length());
						lineBreak.setLiteral(object);
						addToCurrentLine(lineBreak);
						currentLine = null;
					}
				}
			}
			return Boolean.TRUE;
		}
		
	}

	public static class Implementation extends ProcessedRichStringSwitch<Boolean> {

		private final IRichStringPartAcceptor acceptor;

		private final IRichStringIndentationHandler indentationHandler;

		private LinePart nextPart;
		
		private RichStringLiteral announced;
		
		private int skipCount = 0;

		public Implementation(IRichStringPartAcceptor acceptor, IRichStringIndentationHandler indentationHandler) {
			this.acceptor = acceptor;
			this.indentationHandler = indentationHandler;
		}

		@Override
		public Boolean doSwitch(EObject theEObject) {
			if(theEObject == null)
				return Boolean.TRUE;
			return super.doSwitch(theEObject);
		}
		
		@Override
		public Boolean caseProcessedRichString(ProcessedRichString object) {
			String indentation = computeInitialIndentation(object.getRichString());
			pushTemplateIndentation(indentation);
			List<Line> lines = object.getLines();
			if (!lines.isEmpty()) {
				int i = 0;
				nextPart = null;
				Line currentLine = lines.get(i);
				while(currentLine.getParts().isEmpty() && i < lines.size()) {
					currentLine = lines.get(i);
				}
				if (!currentLine.getParts().isEmpty()) {
					nextPart = currentLine.getParts().get(0);
				}
				while(nextPart != null) {
					doSwitch(nextPart);
				}
			}
			popIndentation();
			return Boolean.TRUE;
		}
		
		protected void computeNextPart(LinePart part) {
			Line line = part.getLine();
			int index = line.getParts().indexOf(part);
			if (index == line.getParts().size() - 1) {
				ProcessedRichString richString = line.getRichString();
				index = richString.getLines().indexOf(line);
				if (index == richString.getLines().size() - 1)
					nextPart = null;
				else {
					int i = index + 1;
					nextPart = null;
					line = richString.getLines().get(i);
					while(line.getParts().isEmpty() && i < richString.getLines().size()) {
						line = richString.getLines().get(i);
					}
					if (!line.getParts().isEmpty()) {
						nextPart = line.getParts().get(0);
					}
				}
			} else {
				nextPart = line.getParts().get(index+1);
			}
		}
		
		@Override
		public Boolean caseForLoopStart(ForLoopStart object) {
			RichStringForLoop loop = object.getLoop();
			acceptor.acceptForLoop(loop.getDeclaredParam(), loop.getForExpression());
			pushTemplateIndentationTwice(computeInitialIndentation((RichString) loop.getEachExpression()));
			boolean hasNext = acceptor.forLoopHasNext(loop.getBefore(), loop.getSeparator(), indentationHandler.getTotalSemanticIndentation());
			if (hasNext) {
				while (hasNext) {
					computeNextPart(object);
					while(nextPart != object.getEnd()) {
						doSwitch(nextPart);
					}
					hasNext = acceptor.forLoopHasNext(loop.getBefore(), loop.getSeparator(), indentationHandler.getTotalSemanticIndentation());
				}
			} else {
				nextPart = object.getEnd();
			}
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean caseForLoopEnd(ForLoopEnd object) {
			popIndentationTwice();
			acceptor.acceptEndFor(object.getStart().getLoop().getAfter(), indentationHandler.getTotalSemanticIndentation());
			computeNextPart(object);
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean caseIfConditionStart(IfConditionStart object) {
			RichStringIf richStringIf = object.getRichStringIf();
			acceptor.acceptIfCondition(richStringIf.getIf());
			computeNextPart(object);
			pushTemplateIndentationTwice(computeInitialIndentation((RichString) richStringIf.getThen()));
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean caseElseIfCondition(ElseIfCondition object) {
			popIndentationTwice();
			RichStringElseIf elseIf = object.getRichStringElseIf();
			acceptor.acceptElseIfCondition(elseIf.getIf());
			computeNextPart(object);
			pushTemplateIndentationTwice(computeInitialIndentation((RichString) elseIf.getThen()));
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean caseElseStart(ElseStart object) {
			popIndentationTwice();
			acceptor.acceptElse();
			computeNextPart(object);
			pushTemplateIndentationTwice(computeInitialIndentation((RichString) object.getIfConditionStart().getRichStringIf().getElse()));
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean caseEndIf(EndIf object) {
			popIndentationTwice();
			acceptor.acceptEndIf();
			computeNextPart(object);
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean casePrintedExpression(PrintedExpression object) {
			acceptor.acceptExpression(object.getExpression(), indentationHandler.getTotalSemanticIndentation());
			computeNextPart(object);
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean caseLineBreak(LineBreak object) {
			Line line = object.getLine();
			if (isTemplateLine(line)) {
				announceTemplateLinebreak(object);
				ProcessedRichString string = line.getRichString();
				boolean firstOrLast = string.getLines().get(0) == line || string.getLines().get(string.getLines().size()-1) == line;
				if (!firstOrLast)
					popIndentation();
			} else {
				announceSemanticLinebreak(object);
				popIndentation();
			}
			computeNextPart(object);
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean caseLiteral(Literal object) {
			if (announced == null || announced != object.getLiteral()) {
				acceptor.announceNextLiteral(object.getLiteral());
				announced = object.getLiteral();
			}
			Line line = object.getLine();
			TextLine textLine = new TextLine(Strings.emptyIfNull(object.getLiteral().getValue()), object.getOffset(), object.getLength(), 0);
			CharSequence ws = textLine.getLeadingWhiteSpace();
			ProcessedRichString string = line.getRichString();
			boolean firstOrLast = string.getLines().get(0) == line || string.getLines().get(string.getLines().size()-1) == line;
			if (isTemplateLine(line)) {
				if (line.getParts().get(0) == object) {
					if (!firstOrLast) {
						boolean followedByOpening = false;
						if (line.getParts().size() >= 2) {
							LinePart next = line.getParts().get(1);
							if (next instanceof ForLoopStart || next instanceof IfConditionStart) {
								followedByOpening = true;
							}
						}
						if (!followedByOpening) {
							pushSemanticIndentation(indentationHandler.getTotalIndentation());
						} else {
							pushSemanticIndentation(ws);
						}
					}
				}
				announceTemplateText(textLine, object.getLiteral());
			} else {
				if (skipCount <= 1) {
					firstOrLast = false;
					if (skipCount == 0 && line.getParts().get(0) == object) {
						if (textLine.length() == ws.length()) {
							for(int i = 1; i < line.getParts().size(); i++) {
								if (line.getParts().get(i) instanceof Literal && !(line.getParts().get(i) instanceof LineBreak)) {
									Literal nextLiteralInSameLine = (Literal) line.getParts().get(i);
									TextLine nextLiteralLine = new TextLine(nextLiteralInSameLine.getLiteral().getValue(), nextLiteralInSameLine.getOffset(), nextLiteralInSameLine.getLength(), 0);
									CharSequence nextLeading = nextLiteralLine.getLeadingWhiteSpace();
									if (nextLeading.length() > 0) {
										ws = ws.toString() + nextLeading;
									}
									skipCount++;
									if (nextLeading.length() != nextLiteralLine.length()) {
										break;
									}
								} else {
									break;
								}
							}
							if (skipCount != 0) {
								pushSemanticIndentation(ws);
							} else {
								pushSemanticIndentation(ws);
								announceIndentation();
								announceSemanticText(textLine.subSequence(ws.length(), textLine.length()), object.getLiteral());
							}
						} else {
							pushSemanticIndentation(ws);
							announceIndentation();
							announceSemanticText(textLine.subSequence(ws.length(), textLine.length()), object.getLiteral());
						}
					} else {
						if (skipCount == 1) {
							skipCount--;
							announceIndentation();
							announceSemanticText(textLine.subSequence(ws.length(), textLine.length()), object.getLiteral());
						} else {
							announceSemanticText(textLine, object.getLiteral());
						}
					}
				} else {
					skipCount--;
				}
			}
			if (!firstOrLast && line.getParts().get(line.getParts().size() - 1) == object) {
				popIndentation();
			}
			computeNextPart(object);
			return Boolean.TRUE;
		}
		
		protected boolean isTemplateLine(Line line) {
			ProcessedRichString string = line.getRichString();
			if (string.getLines().size() == 1) {
				return false;
			}
			boolean firstOrLast = string.getLines().get(0) == line;
			if (!firstOrLast) {
				if (string.getLines().get(string.getLines().size()-1) == line) {
					if (!(line.getParts().get(line.getParts().size() - 1) instanceof LineBreak))
						firstOrLast = true;
				}
			}
			boolean onlyLiterals = true;
			for(LinePart part: line.getParts()) {
				if (part instanceof PrintedExpression)
					return false;
				if (part instanceof Literal) {
					Literal literal = (Literal) part;
					if (literal instanceof LineBreak) {
						if (firstOrLast)
							return onlyLiterals;
						return !onlyLiterals;
					}
					if (!(new TextLine(literal.getLiteral().getValue(), literal.getOffset(), literal.getLength(), 0).containsOnlyWhitespace()))
						return false;
				} else if (firstOrLast) {
					return false;
				} else {
					onlyLiterals = false;
				}
			}
			if (firstOrLast)
				return onlyLiterals;
			return !onlyLiterals;
		}
		
		protected void pushSemanticIndentation(CharSequence line) {
			indentationHandler.pushSemanticIndentation(line);
		}

		protected void popIndentation() {
			indentationHandler.popIndentation();
		}
		
		protected void popIndentationTwice() {
			popIndentation();
			popIndentation();
		}

		protected void pushTemplateIndentationTwice(CharSequence indentation) {
			pushTemplateIndentation(indentation);
			pushTemplateIndentation(indentation);
		}
		
		protected void pushTemplateIndentation(CharSequence indentation) {
			indentationHandler.pushTemplateIndentation(indentation);
		}

		protected void announceSemanticText(CharSequence text, RichStringLiteral origin) {
			acceptor.acceptSemanticText(text, origin);
		}

		public void announceTemplateText(CharSequence text, RichStringLiteral origin) {
			acceptor.acceptTemplateText(text, origin);
		}

		public void announceIndentation() {
			indentationHandler.accept(acceptor);
		}

		protected void announceTemplateLinebreak(LineBreak lineBreak) {
			acceptor.acceptTemplateLineBreak(lineBreak.getLength(), lineBreak.getLiteral());
		}

		public void announceSemanticLinebreak(LineBreak lineBreak) {
			boolean controlStructureSeen = false;
			for(LinePart part: lineBreak.getLine().getParts()) {
				if (!(part instanceof Literal)) {
					controlStructureSeen = true;
					break;
				}
			}
			acceptor.acceptSemanticLineBreak(lineBreak.getLength(), lineBreak.getLiteral(), controlStructureSeen);
		}

		public String computeInitialIndentation(RichString object) {
			if (object == null) {
				return indentationHandler.getTotalIndentation().toString();
			}
			InitialTemplateIndentationComputer computer = new InitialTemplateIndentationComputer(
					indentationHandler.getTotalIndentation());
			String result = computer.doSwitch(object);
			return result;
		}
	}

}
