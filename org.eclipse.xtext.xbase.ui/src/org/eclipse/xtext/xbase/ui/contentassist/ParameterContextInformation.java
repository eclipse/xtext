/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jdt.internal.ui.text.JavaHeuristicScanner;
import org.eclipse.jface.preference.JFacePreferences;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.contentassist.ISmartContextInformation;

import com.google.common.collect.Lists;

/**
 * This class is mainly adopted from {@link org.eclipse.jdt.internal.ui.text.java.ProposalContextInformation}
 * and friends.
 * @see org.eclipse.jdt.internal.ui.text.java.JavaParameterListValidator
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@SuppressWarnings("restriction")
public class ParameterContextInformation implements ISmartContextInformation {

	private final ParameterData data;
	private final String contextDisplayString;
	private int parameterListOffset;
	private int currentParameter = -1;
	private int initialCaretOffset;

	public ParameterContextInformation(ParameterData data, String contextDisplayString, int parameterListOffset, int initialCarretOffset) {
		this.data = data;
		this.contextDisplayString = contextDisplayString;
		this.parameterListOffset = parameterListOffset;
		this.initialCaretOffset = initialCarretOffset;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof IContextInformation) {
			IContextInformation contextInformation= (IContextInformation) object;
			boolean equals= getInformationDisplayString().equalsIgnoreCase(contextInformation.getInformationDisplayString());
			if (getContextDisplayString() != null)
				equals= equals && getContextDisplayString().equalsIgnoreCase(contextInformation.getContextDisplayString());
			return equals;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int low= getContextDisplayString() != null ? getContextDisplayString().hashCode() : 0;
		return (getInformationDisplayString().hashCode() << 16) | low;
	}

	@Override
	public String getInformationDisplayString() {
		return data.getDisplayString();
	}
	
	public List<String> internalGetInformationDisplayString() {
		return data.getRawDisplayString();
	}

	@Override
	public Image getImage() {
		// TODO implement
		return null;
	}

	@Override
	public String getContextDisplayString() {
		return contextDisplayString;
	}

	@Override
	public int getContextInformationPosition() {
		return initialCaretOffset;
	}

	@Override
	public void setContextInformationPosition(int pos) {
		this.initialCaretOffset = pos;
	}

	@Override
	public boolean isContextInformationValid(ITextViewer viewer, int position) {
		try {
			if (position < this.parameterListOffset)
				return false;

			IDocument document= viewer.getDocument();
			IRegion line= document.getLineInformationOfOffset(this.parameterListOffset);

			if (position < line.getOffset() || position >= document.getLength())
				return false;

			return getCharCount(document, this.parameterListOffset, position, "(<", ")>", false) >= 0; //$NON-NLS-1$ //$NON-NLS-2$

		} catch (BadLocationException x) {
			return false;
		}
	}

	@Override
	public boolean updatePresentation(ITextViewer viewer, int position, TextPresentation presentation) {
		int currentParameter= -1;

		try {
			currentParameter= getCharCount(viewer.getDocument(), this.parameterListOffset, position, ",", "", true);  //$NON-NLS-1$//$NON-NLS-2$
		} catch (BadLocationException x) {
			return false;
		}

		if (currentParameter != -1) {
			if (currentParameter == this.currentParameter)
				return false;
		}

		presentation.clear();
		this.currentParameter= currentParameter;

		List<String> rawStrings = internalGetInformationDisplayString();
		List<int[]> commaArrays = Lists.newArrayList();
		for(String s: rawStrings) {
			commaArrays.add(computeCommaPositions(s));
		}

		int offset = 0;
		for(int i = 0; i < rawStrings.size(); i++) {
			String raw = rawStrings.get(i);
			int[] commas = commaArrays.get(i);
			if (commas.length - 2 < this.currentParameter && !data.isVarArgs(i)) {
				presentation.addStyleRange(new StyleRange(offset, raw.length(), JFaceResources.getColorRegistry().get(JFacePreferences.QUALIFIER_COLOR), null, SWT.NORMAL));
			} else {
				int actualParameter = this.currentParameter;
				if (actualParameter + 1 >= commas.length)
					actualParameter = commas.length - 2;
				int start= commas[actualParameter] + 1;
				int end= commas[actualParameter + 1];
				if (start > 0)
					presentation.addStyleRange(new StyleRange(offset, start, null, null, SWT.NORMAL));
				
				if (end > start)
					presentation.addStyleRange(new StyleRange(offset + start, end - start, null, null, SWT.BOLD));
				
				if (end < raw.length())
					presentation.addStyleRange(new StyleRange(offset + end, raw.length() - end, null, null, SWT.NORMAL));
			}
			offset += raw.length() + 1;
		}

		return true;
	}
	
	protected int[] computeCommaPositions(String code) {
		final int length= code.length();
	    int pos= 0;
		List<Integer> positions= new ArrayList<Integer>();
		positions.add(Integer.valueOf(-1));
		while (pos < length && pos != -1) {
			char ch= code.charAt(pos);
			switch (ch) {
	            case ',':
		            positions.add(Integer.valueOf(pos));
		            break;
	            case '<':
	            	pos = advance(code, length, pos, '<', '>');
	            	break;
	            case '[': 
	            	pos = advance(code, length, pos, '[', ']');
	            	break;
	            case '(':
	            	pos = advance(code, length, pos, '(', ')');
	            	break;
	            default:
	            	break;
            }
			if (pos != -1)
				pos++;
		}
		positions.add(Integer.valueOf(length));

		int[] fields= new int[positions.size()];
		for (int i= 0; i < fields.length; i++)
	        fields[i]= positions.get(i).intValue();
	    return fields;
    }

	protected int advance(String code, final int length, int pos, char left, char right) {
		int remaining = 1;
		pos++;
		while(pos < length && pos != -1 && remaining > 0) {
			char ch2 = code.charAt(pos);
			if (ch2 == left)
				remaining++;
			else if (ch2 == right)
				remaining--;
			pos++;
		}
		return pos;
	}
	
	// see JavaParameterListValidator
	protected int getCharCount(IDocument document, final int start, final int end, String increments, String decrements, boolean considerNesting) throws BadLocationException {

		Assert.isTrue((increments.length() != 0 || decrements.length() != 0) && !increments.equals(decrements));

		final int NONE= 0;
		final int BRACKET= 1;
		final int BRACE= 2;
		final int PAREN= 3;
		final int ANGLE= 4;

		int nestingMode= NONE;
		int nestingLevel= 0;

		int charCount= 0;
		int offset= start;
		while (offset < end) {
			char curr= document.getChar(offset++);
			switch (curr) {
				case '/':
					if (offset < end) {
						char next= document.getChar(offset);
						if (next == '*') {
							// a comment starts, advance to the comment end
							offset= getCommentEnd(document, offset + 1, end);
						} else if (next == '/') {
							// '//'-comment: nothing to do anymore on this line
							int nextLine= document.getLineOfOffset(offset) + 1;
							if (nextLine == document.getNumberOfLines())
								offset= end;
							else
								offset= document.getLineOffset(nextLine);
						}
					}
					break;
				case '*':
					if (offset < end) {
						char next= document.getChar(offset);
						if (next == '/') {
							// we have been in a comment: forget what we read before
							charCount= 0;
							++ offset;
						}
					}
					break;
				case '"':
				case '\'':
					offset= getStringEnd(document, offset, end, curr);
					break;
				case '[':
					if (considerNesting) {
						if (nestingMode == BRACKET || nestingMode == NONE) {
							nestingMode= BRACKET;
							nestingLevel++;
						}
						break;
					}
					//$FALL-THROUGH$
				case ']':
					if (considerNesting) {
						if (nestingMode == BRACKET)
							if (--nestingLevel == 0)
								nestingMode= NONE;
						break;
					}
					//$FALL-THROUGH$
				case '(':
					if (considerNesting) {
						if (nestingMode == ANGLE) {
							// generics heuristic failed
							nestingMode=PAREN;
							nestingLevel= 1;
						}
						if (nestingMode == PAREN || nestingMode == NONE) {
							nestingMode= PAREN;
							nestingLevel++;
						}
						break;
					}
					//$FALL-THROUGH$
				case ')':
					if (considerNesting) {
						if (nestingMode == PAREN)
							if (--nestingLevel == 0)
								nestingMode= NONE;
						break;
					}
					//$FALL-THROUGH$
				case '{':
					if (considerNesting) {
						if (nestingMode == ANGLE) {
							// generics heuristic failed
							nestingMode=BRACE;
							nestingLevel= 1;
						}
						if (nestingMode == BRACE || nestingMode == NONE) {
							nestingMode= BRACE;
							nestingLevel++;
						}
						break;
					}
					//$FALL-THROUGH$
				case '}':
					if (considerNesting) {
						if (nestingMode == BRACE)
							if (--nestingLevel == 0)
								nestingMode= NONE;
						break;
					}
					//$FALL-THROUGH$
				case '<':
					if (considerNesting) {
						if (nestingMode == ANGLE || nestingMode == NONE && checkGenericsHeuristic(document, offset - 1, start - 1)) {
							nestingMode= ANGLE;
							nestingLevel++;
						}
						break;
					}
					//$FALL-THROUGH$
				case '>':
					if (considerNesting) {
						if (nestingMode == ANGLE)
							if (--nestingLevel == 0)
								nestingMode= NONE;
						break;
					}
					//$FALL-THROUGH$
				default:
					if (nestingLevel != 0)
						continue;

					if (increments.indexOf(curr) >= 0) {
						++ charCount;
					}

					if (decrements.indexOf(curr) >= 0) {
						-- charCount;
					}
			}
		}

		return charCount;
	}
	
	protected int getCommentEnd(IDocument d, int pos, int end) throws BadLocationException {
		while (pos < end) {
			char curr= d.getChar(pos);
			pos++;
			if (curr == '*') {
				if (pos < end && d.getChar(pos) == '/') {
					return pos + 1;
				}
			}
		}
		return end;
	}
	
	protected int getStringEnd(IDocument d, int pos, int end, char ch) throws BadLocationException {
		while (pos < end) {
			char curr= d.getChar(pos);
			pos++;
			if (curr == '\\') {
				// ignore escaped characters
				pos++;
			} else if (curr == ch) {
				return pos;
			}
		}
		return end;
	}

	protected boolean checkGenericsHeuristic(IDocument document, int end, int bound) {
		JavaHeuristicScanner scanner = new JavaHeuristicScanner(document);
		return scanner.looksLikeClassInstanceCreationBackward(end, bound);
	}
}
