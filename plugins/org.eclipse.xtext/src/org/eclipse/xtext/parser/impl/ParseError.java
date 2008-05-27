package org.eclipse.xtext.parser.impl;

import org.eclipse.xtext.parser.IParseError;
import org.eclipse.xtext.parsetree.AbstractNode;

public class ParseError implements IParseError {
	public Object context;
	public String message;
	public int length;
	public int offset;
	public int line;
	public String problematicText;

	public ParseError(int line, int offset, int length, String problematicText, String message, Object context) {
		super();
		this.context = context;
		this.length = length;
		this.line = line;
		this.message = message;
		this.offset = offset;
		this.problematicText = problematicText;
	}

	public AbstractNode problematicNode;

	public ParseError(AbstractNode problematicNode, String message, Object context) {
		this.problematicNode = problematicNode;
		this.message = message;
		this.context = context;
	}

	public Object getContext() {
		return context;
	}

	public String getMessage() {
		return message;
	}

	public int getLine() {
		return problematicNode != null ? problematicNode.line() : line;
	}

	public int getOffset() {
		return problematicNode != null ? problematicNode.offset() : offset;
	}

	public int getLength() {
		return problematicNode != null ? problematicNode.length() : length;
	}

	public String getProblematicText() {
		return problematicNode != null ? problematicNode.serialize() : problematicText;
	}

	public AbstractNode getProblematicNode() {
		return problematicNode;
	}

}
