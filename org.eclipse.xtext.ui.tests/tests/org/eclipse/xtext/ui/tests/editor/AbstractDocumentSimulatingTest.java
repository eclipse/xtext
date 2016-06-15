/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPartitioningException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.IDocumentPartitioningListener;
import org.eclipse.jface.text.IPositionUpdater;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextDocumentContentObserver;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractDocumentSimulatingTest extends AbstractXtextTests implements IXtextDocument {

	@Override
	public void addDocumentListener(IDocumentListener listener) {
		fail("Unexpected call");
	}

	@Override
	public void addDocumentPartitioningListener(IDocumentPartitioningListener listener) {
		fail("Unexpected call");
	}

	@Override
	public void addPosition(Position position) throws BadLocationException {
		fail("Unexpected call");
	}

	@Override
	public void addPosition(String category, Position position) throws BadLocationException,
			BadPositionCategoryException {
		fail("Unexpected call");
	}

	@Override
	public void addPositionCategory(String category) {
		fail("Unexpected call");
	}

	@Override
	public void addPositionUpdater(IPositionUpdater updater) {
		fail("Unexpected call");
	}

	@Override
	public void addPrenotifiedDocumentListener(IDocumentListener documentAdapter) {
		fail("Unexpected call");
	}

	@Override
	public int computeIndexInCategory(String category, int offset) throws BadLocationException,
			BadPositionCategoryException {
		fail("Unexpected call");
		return 0;
	}

	@Override
	public int computeNumberOfLines(String text) {
		fail("Unexpected call");
		return 0;
	}

	@Override
	public ITypedRegion[] computePartitioning(int offset, int length) throws BadLocationException {
		fail("Unexpected call");
		return null;
	}

	@Override
	public boolean containsPosition(String category, int offset, int length) {
		fail("Unexpected call");
		return false;
	}

	@Override
	public boolean containsPositionCategory(String category) {
		fail("Unexpected call");
		return false;
	}
	
	@Override
	public String get() {
		fail("Unexpected call");
		return null;
	}

	@Override
	public String get(int offset, int length) throws BadLocationException {
		fail("Unexpected call");
		return null;
	}

	@Override
	public char getChar(int offset) throws BadLocationException {
		fail("Unexpected call");
		return 0;
	}

	@Override
	public String getContentType(int offset) throws BadLocationException {
		fail("Unexpected call");
		return null;
	}

	@Override
	public IDocumentPartitioner getDocumentPartitioner() {
		fail("Unexpected call");
		return null;
	}

	@Override
	public String[] getLegalContentTypes() {
		fail("Unexpected call");
		return null;
	}

	@Override
	public String[] getLegalLineDelimiters() {
		fail("Unexpected call");
		return null;
	}

	@Override
	public int getLength() {
		fail("Unexpected call");
		return 0;
	}

	@Override
	public String getLineDelimiter(int line) throws BadLocationException {
		fail("Unexpected call");
		return null;
	}

	@Override
	public IRegion getLineInformation(int line) throws BadLocationException {
		fail("Unexpected call");
		return null;
	}

	@Override
	public IRegion getLineInformationOfOffset(int offset) throws BadLocationException {
		fail("Unexpected call");
		return null;
	}

	@Override
	public int getLineLength(int line) throws BadLocationException {
		fail("Unexpected call");
		return 0;
	}

	@Override
	public int getLineOfOffset(int offset) throws BadLocationException {
		fail("Unexpected call");
		return 0;
	}

	@Override
	public int getLineOffset(int line) throws BadLocationException {
		fail("Unexpected call");
		return 0;
	}

	@Override
	public int getNumberOfLines() {
		fail("Unexpected call");
		return 0;
	}

	@Override
	public int getNumberOfLines(int offset, int length) throws BadLocationException {
		fail("Unexpected call");
		return 0;
	}

	@Override
	public ITypedRegion getPartition(int offset) throws BadLocationException {
		fail("Unexpected call");
		return null;
	}

	@Override
	public String[] getPositionCategories() {
		fail("Unexpected call");
		return null;
	}

	@Override
	public IPositionUpdater[] getPositionUpdaters() {
		fail("Unexpected call");
		return null;
	}

	@Override
	public Position[] getPositions(String category) throws BadPositionCategoryException {
		fail("Unexpected call");
		return null;
	}

	@Override
	public void insertPositionUpdater(IPositionUpdater updater, int index) {
		fail("Unexpected call");
	}

	@Override
	public void removeDocumentListener(IDocumentListener listener) {
		fail("Unexpected call");
	}

	@Override
	public void removeDocumentPartitioningListener(IDocumentPartitioningListener listener) {
		fail("Unexpected call");
	}

	@Override
	public void removePosition(Position position) {
		fail("Unexpected call");
	}

	@Override
	public void removePosition(String category, Position position) throws BadPositionCategoryException {
		fail("Unexpected call");
	}

	@Override
	public void removePositionCategory(String category) throws BadPositionCategoryException {
		fail("Unexpected call");
	}

	@Override
	public void removePositionUpdater(IPositionUpdater updater) {
		fail("Unexpected call");
	}

	@Override
	public void removePrenotifiedDocumentListener(IDocumentListener documentAdapter) {
		fail("Unexpected call");
	}

	@Override
	public void replace(int offset, int length, String text) throws BadLocationException {
		fail("Unexpected call");
	}

	@Override
	@Deprecated
	public int search(int startOffset, String findString, boolean forwardSearch, boolean caseSensitive,
			boolean wholeWord) throws BadLocationException {
		fail("Unexpected call");
		return 0;
	}

	@Override
	public void set(String text) {
		fail("Unexpected call");
	}

	@Override
	public void setDocumentPartitioner(IDocumentPartitioner partitioner) {
		fail("Unexpected call");
	}

	@Override
	public void addModelListener(IXtextModelListener listener) {
		fail("Unexpected call");
	}

	@Override
	public void addXtextDocumentContentObserver(IXtextDocumentContentObserver listener) {
		fail("Unexpected call");
	}

	@Override
	public <T> T getAdapter(Class<T> adapterType) {
		fail("Unexpected call");
		return null;
	}

	@Override
	public void removeModelListener(IXtextModelListener listener) {
		fail("Unexpected call");
	}

	@Override
	public void removeXtextDocumentContentObserver(IXtextDocumentContentObserver listener) {
		fail("Unexpected call");
	}

	@Override
	public <T> T modify(IUnitOfWork<T, XtextResource> work) {
		fail("Unexpected call");
		return null;
	}
	
	@Override
	public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
		fail("Unexpected call");
		return null;
	}

	@Override
	public ITypedRegion[] computePartitioning(String partitioning, int offset, int length,
			boolean includeZeroLengthPartitions) throws BadLocationException, BadPartitioningException {
		fail("Unexpected call");
		return null;
	}
	
	@Override
	public String getContentType(String partitioning, int offset, boolean preferOpenPartitions)
			throws BadLocationException, BadPartitioningException {
		fail("Unexpected call");
		return null;
	}
	
	@Override
	public IDocumentPartitioner getDocumentPartitioner(String partitioning) {
		fail("Unexpected call");
		return null;
	}
	
	@Override
	public String[] getLegalContentTypes(String partitioning) throws BadPartitioningException {
		fail("Unexpected call");
		return null;
	}
	
	@Override
	public ITypedRegion getPartition(String partitioning, int offset, boolean preferOpenPartitions)
			throws BadLocationException, BadPartitioningException {
		fail("Unexpected call");
		return null;
	}
	
	@Override
	public String[] getPartitionings() {
		fail("Unexpected call");
		return null;
	}
	
	@Override
	public void setDocumentPartitioner(String partitioning, IDocumentPartitioner partitioner) {
		fail("Unexpected call");
	}
	
}
