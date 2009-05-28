/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.tests;

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
