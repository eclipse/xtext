package org.eclipse.xtext.generator.tests;

public class DummyParserNode {

	private Object astElement;
	
	private Object grammarElement;
	
	private String text;
	
	private DummyParserNode parent;

	public DummyParserNode getParent() {
		return parent;
	}

	public void setParent(DummyParserNode parent) {
		this.parent = parent;
	}

	public Object getAstElement() {
		return astElement;
	}

	public void setAstElement(Object astElement) {
		this.astElement = astElement;
	}

	public Object getGrammarElement() {
		return grammarElement;
	}

	public void setGrammarElement(Object grammarElement) {
		this.grammarElement = grammarElement;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
}	
