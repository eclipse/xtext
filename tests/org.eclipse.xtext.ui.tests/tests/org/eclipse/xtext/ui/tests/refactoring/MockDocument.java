/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.IDocumentPartitioningListener;
import org.eclipse.jface.text.IPositionUpdater;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;

/**
 * @author schill - Initial contribution and API
 */
public class MockDocument implements IDocument {

	public char getChar(int offset) throws BadLocationException {
		
		return 0;
	}

	public int getLength() {
		
		return 0;
	}

	public String get() {
		
		return null;
	}

	public String get(int offset, int length) throws BadLocationException {
		return "Foo";
	}

	public void set(String text) {
		

	}

	public void replace(int offset, int length, String text) throws BadLocationException {
		

	}

	public void addDocumentListener(IDocumentListener listener) {
		

	}

	public void removeDocumentListener(IDocumentListener listener) {
		

	}

	public void addPrenotifiedDocumentListener(IDocumentListener documentAdapter) {
		

	}

	public void removePrenotifiedDocumentListener(IDocumentListener documentAdapter) {
		

	}

	public void addPositionCategory(String category) {
		

	}

	public void removePositionCategory(String category) throws BadPositionCategoryException {
		

	}

	public String[] getPositionCategories() {
		
		return null;
	}

	public boolean containsPositionCategory(String category) {
		
		return false;
	}

	public void addPosition(Position position) throws BadLocationException {
		

	}

	public void removePosition(Position position) {
		

	}

	public void addPosition(String category, Position position) throws BadLocationException,
			BadPositionCategoryException {
		

	}

	public void removePosition(String category, Position position) throws BadPositionCategoryException {
		

	}

	public Position[] getPositions(String category) throws BadPositionCategoryException {
		
		return null;
	}

	public boolean containsPosition(String category, int offset, int length) {
		
		return false;
	}

	public int computeIndexInCategory(String category, int offset) throws BadLocationException,
			BadPositionCategoryException {
		
		return 0;
	}

	public void addPositionUpdater(IPositionUpdater updater) {
		

	}

	public void removePositionUpdater(IPositionUpdater updater) {
		

	}

	public void insertPositionUpdater(IPositionUpdater updater, int index) {
		

	}

	public IPositionUpdater[] getPositionUpdaters() {
		
		return null;
	}

	public String[] getLegalContentTypes() {
		
		return null;
	}

	public String getContentType(int offset) throws BadLocationException {
		
		return null;
	}

	public ITypedRegion getPartition(int offset) throws BadLocationException {
		
		return null;
	}

	public ITypedRegion[] computePartitioning(int offset, int length) throws BadLocationException {
		
		return null;
	}

	public void addDocumentPartitioningListener(IDocumentPartitioningListener listener) {
		

	}

	public void removeDocumentPartitioningListener(IDocumentPartitioningListener listener) {
		

	}

	public void setDocumentPartitioner(IDocumentPartitioner partitioner) {
		

	}

	public IDocumentPartitioner getDocumentPartitioner() {
		
		return null;
	}

	public int getLineLength(int line) throws BadLocationException {
		
		return 0;
	}

	public int getLineOfOffset(int offset) throws BadLocationException {
		
		return 0;
	}

	public int getLineOffset(int line) throws BadLocationException {
		
		return 0;
	}

	public IRegion getLineInformation(int line) throws BadLocationException {
		
		return null;
	}

	public IRegion getLineInformationOfOffset(int offset) throws BadLocationException {
		
		return null;
	}

	public int getNumberOfLines() {
		
		return 0;
	}

	public int getNumberOfLines(int offset, int length) throws BadLocationException {
		
		return 0;
	}

	public int computeNumberOfLines(String text) {
		
		return 0;
	}

	public String[] getLegalLineDelimiters() {
		
		return null;
	}

	public String getLineDelimiter(int line) throws BadLocationException {
		
		return null;
	}

	@SuppressWarnings("deprecation")
	public int search(final int startOffset, final String findString, final boolean forwardSearch, final boolean caseSensitive,
			final boolean wholeWord) throws BadLocationException {
		
		return 0;
	}

}
