/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.ui.refactoring.impl.LinkedModelCalculator;

import com.google.common.collect.Lists;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class LinkedModelCalculatorTest extends TestCase {
	LinkedModelCalculator l;
	List<TextEdit> textEdits; 
	String originalName;
	int invocationOffset;
	boolean sort = false;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		sort = false;
		fillTextEdits();
		l = new LinkedModelCalculator() {
			@Override
			public java.lang.Iterable<org.eclipse.text.edits.TextEdit> computeTextEdits() {
				return textEdits;
			}
			
			@Override
			protected String getOriginalName() {
				return originalName;
			}
			
			@Override
			protected org.eclipse.jface.text.IDocument getDocument() {
				return new MockDocument();
			}
			
			@Override
			protected int getInvocationOffset() {
				return invocationOffset;
			}
			@Override
			public Iterable<LinkedPosition> sortPositions(Iterable<LinkedPosition> linkedPositions, int invocationOffset) {
				if(sort)
					return super.sortPositions(linkedPositions, invocationOffset);
					// Do not sort
				return linkedPositions;
			}
		};
	}
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		textEdits = null;
		originalName = null;
		invocationOffset = 0;
		sort = false;
		l = null;
	}



	public void testCalculationRightNumberOfLinkedPositions() throws Exception {
		invocationOffset = 42;
		originalName = "Zonk";
		LinkedPositionGroup linkedPositionGroup = l.getLinkedPositionGroup();
		assertEquals(5, linkedPositionGroup.getPositions().length);
	}
	
	public void testRightOffset1() throws Exception {
		invocationOffset = 42;
		originalName = "Zonk";
		String firstPart = "foo.bar.";
		LinkedPositionGroup linkedPositionGroup = l.getLinkedPositionGroup();
		LinkedPosition[] positions = linkedPositionGroup.getPositions();
		for(int i = 0; i < positions.length; i++){
			TextEdit textEdit = textEdits.get(i);
			LinkedPosition position = positions[i];
			assertEquals(textEdit.getOffset() + firstPart.length(), position.getOffset());
			assertEquals(textEdit.getLength() - firstPart.length(), position.getLength());
		}
	}
	
	public void testRightOffset2() throws Exception {
		invocationOffset = 42;
		originalName = "foo.bar";
		String lastPart = ".Zonk";
		LinkedPositionGroup linkedPositionGroup = l.getLinkedPositionGroup();
		LinkedPosition[] positions = linkedPositionGroup.getPositions();
		for(int i = 0; i < positions.length; i++){
			TextEdit textEdit = textEdits.get(i);
			LinkedPosition position = positions[i];
			assertEquals(textEdit.getOffset(), position.getOffset());
			assertEquals(textEdit.getLength() - lastPart.length(), position.getLength());
		}
	}
	
	public void testHasSequence() throws Exception {
		invocationOffset = 42;
		originalName = "Zonk";
		LinkedPositionGroup linkedPositionGroup = l.getLinkedPositionGroup();
		LinkedPosition[] positions = linkedPositionGroup.getPositions();
		for(int i = 0; i < positions.length; i++){
			LinkedPosition pos = positions[i];
			assertEquals(i, pos.getSequenceNumber());
		}
	}
	
	public void testRightOrder() throws Exception {
		invocationOffset = 42;
		originalName = "foo.bar";
		sort = true;
		int[] sortedOffsets = {42,56,89,120,30};
		LinkedPositionGroup linkedPositionGroup = l.getLinkedPositionGroup();
		LinkedPosition[] positions = linkedPositionGroup.getPositions();
		for(int i = 0; i < positions.length;i++ ){
			assertEquals(sortedOffsets[i],positions[i].getOffset());
		}
	}
	
	public void testRightOrder2() throws Exception {
		invocationOffset = 89;
		originalName = "foo.bar";
		sort = true;
		int[] sortedOffsets = {89,120,30,42,56};
		LinkedPositionGroup linkedPositionGroup = l.getLinkedPositionGroup();
		LinkedPosition[] positions = linkedPositionGroup.getPositions();
		for(int i = 0; i < positions.length;i++ ){
			assertEquals(sortedOffsets[i],positions[i].getOffset());
		}
	}
	
	public void testNameIsTwiceInQualifiedName() throws Exception {
		fillTextEditsWithNameTwiceInQualifiedName();
		invocationOffset = 89;
		originalName = "foo.bar";
		sort = true;
		int[] sortedOffsets = {89,120,30,42,56};
		LinkedPositionGroup linkedPositionGroup = l.getLinkedPositionGroup();
		LinkedPosition[] positions = linkedPositionGroup.getPositions();
		for(int i = 0; i < positions.length;i++ ){
			assertEquals(sortedOffsets[i],positions[i].getOffset());
			assertEquals(originalName.length(), positions[i].getLength());
		}
	}
	
	private void fillTextEditsWithNameTwiceInQualifiedName() {
		textEdits = Lists.newArrayList();
		textEdits.add(new ReplaceEdit(120, 20, "foo.bar.foo.bar.Zonk"));
		textEdits.add(new ReplaceEdit(89, 20, "foo.bar.foo.bar.Zonk"));
		textEdits.add(new ReplaceEdit(56, 20, "foo.bar.foo.bar.Zonk"));
		textEdits.add(new ReplaceEdit(42, 20, "foo.bar.foo.bar.Zonk"));
		textEdits.add(new ReplaceEdit(30, 20, "foo.bar.foo.bar.Zonk"));
		
	}
	private void fillTextEdits() {
		textEdits = Lists.newArrayList();
		textEdits.add(new ReplaceEdit(120, 12, "foo.bar.Zonk"));
		textEdits.add(new ReplaceEdit(89, 12, "foo.bar.Zonk"));
		textEdits.add(new ReplaceEdit(56, 12, "foo.bar.Zonk"));
		textEdits.add(new ReplaceEdit(42, 12, "foo.bar.Zonk"));
		textEdits.add(new ReplaceEdit(30, 12, "foo.bar.Zonk"));
	}
	
}
