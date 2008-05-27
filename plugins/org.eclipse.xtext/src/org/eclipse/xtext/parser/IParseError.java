package org.eclipse.xtext.parser;

import org.eclipse.xtext.parsetree.AbstractNode;

public interface IParseError {

	public Object getContext();

	public String getMessage();

	public int getLine();

	public int getOffset();

	public int getLength();

	public String getProblematicText();

	public AbstractNode getProblematicNode();
	
}
