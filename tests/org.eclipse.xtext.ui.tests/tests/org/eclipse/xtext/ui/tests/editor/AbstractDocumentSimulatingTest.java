/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.IDocumentPartitioningListener;
import org.eclipse.jface.text.IPositionUpdater;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextDocumentContentObserver;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.util.concurrent.IEObjectHandle;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractDocumentSimulatingTest extends AbstractXtextTests implements IXtextDocument {

	public void addDocumentListener(IDocumentListener listener) {
		fail("Unexpected call");
	}

	public void addDocumentPartitioningListener(IDocumentPartitioningListener listener) {
		fail("Unexpected call");
	}

	public void addPosition(Position position) throws BadLocationException {
		fail("Unexpected call");
	}

	public void addPosition(String category, Position position) throws BadLocationException,
			BadPositionCategoryException {
		fail("Unexpected call");
	}

	public void addPositionCategory(String category) {
		fail("Unexpected call");
	}

	public void addPositionUpdater(IPositionUpdater updater) {
		fail("Unexpected call");
	}

	public void addPrenotifiedDocumentListener(IDocumentListener documentAdapter) {
		fail("Unexpected call");
	}

	public int computeIndexInCategory(String category, int offset) throws BadLocationException,
			BadPositionCategoryException {
		fail("Unexpected call");
		return 0;
	}

	public int computeNumberOfLines(String text) {
		fail("Unexpected call");
		return 0;
	}

	public ITypedRegion[] computePartitioning(int offset, int length) throws BadLocationException {
		fail("Unexpected call");
		return null;
	}

	public boolean containsPosition(String category, int offset, int length) {
		fail("Unexpected call");
		return false;
	}

	public boolean containsPositionCategory(String category) {
		fail("Unexpected call");
		return false;
	}
	
	public String get() {
		fail("Unexpected call");
		return null;
	}

	public String get(int offset, int length) throws BadLocationException {
		fail("Unexpected call");
		return null;
	}

	public char getChar(int offset) throws BadLocationException {
		fail("Unexpected call");
		return 0;
	}

	public String getContentType(int offset) throws BadLocationException {
		fail("Unexpected call");
		return null;
	}

	public IDocumentPartitioner getDocumentPartitioner() {
		fail("Unexpected call");
		return null;
	}

	public String[] getLegalContentTypes() {
		fail("Unexpected call");
		return null;
	}

	public String[] getLegalLineDelimiters() {
		fail("Unexpected call");
		return null;
	}

	public int getLength() {
		fail("Unexpected call");
		return 0;
	}

	public String getLineDelimiter(int line) throws BadLocationException {
		fail("Unexpected call");
		return null;
	}

	public IRegion getLineInformation(int line) throws BadLocationException {
		fail("Unexpected call");
		return null;
	}

	public IRegion getLineInformationOfOffset(int offset) throws BadLocationException {
		fail("Unexpected call");
		return null;
	}

	public int getLineLength(int line) throws BadLocationException {
		fail("Unexpected call");
		return 0;
	}

	public int getLineOfOffset(int offset) throws BadLocationException {
		fail("Unexpected call");
		return 0;
	}

	public int getLineOffset(int line) throws BadLocationException {
		fail("Unexpected call");
		return 0;
	}

	public int getNumberOfLines() {
		fail("Unexpected call");
		return 0;
	}

	public int getNumberOfLines(int offset, int length) throws BadLocationException {
		fail("Unexpected call");
		return 0;
	}

	public ITypedRegion getPartition(int offset) throws BadLocationException {
		fail("Unexpected call");
		return null;
	}

	public String[] getPositionCategories() {
		fail("Unexpected call");
		return null;
	}

	public IPositionUpdater[] getPositionUpdaters() {
		fail("Unexpected call");
		return null;
	}

	public Position[] getPositions(String category) throws BadPositionCategoryException {
		fail("Unexpected call");
		return null;
	}

	public void insertPositionUpdater(IPositionUpdater updater, int index) {
		fail("Unexpected call");
	}

	public void removeDocumentListener(IDocumentListener listener) {
		fail("Unexpected call");
	}

	public void removeDocumentPartitioningListener(IDocumentPartitioningListener listener) {
		fail("Unexpected call");
	}

	public void removePosition(Position position) {
		fail("Unexpected call");
	}

	public void removePosition(String category, Position position) throws BadPositionCategoryException {
		fail("Unexpected call");
	}

	public void removePositionCategory(String category) throws BadPositionCategoryException {
		fail("Unexpected call");
	}

	public void removePositionUpdater(IPositionUpdater updater) {
		fail("Unexpected call");
	}

	public void removePrenotifiedDocumentListener(IDocumentListener documentAdapter) {
		fail("Unexpected call");
	}

	public void replace(int offset, int length, String text) throws BadLocationException {
		fail("Unexpected call");
	}

	@Deprecated
	public int search(int startOffset, String findString, boolean forwardSearch, boolean caseSensitive,
			boolean wholeWord) throws BadLocationException {
		fail("Unexpected call");
		return 0;
	}

	public void set(String text) {
		fail("Unexpected call");
	}

	public void setDocumentPartitioner(IDocumentPartitioner partitioner) {
		fail("Unexpected call");
	}

	public void addModelListener(IXtextModelListener listener) {
		fail("Unexpected call");
	}

	public void addXtextDocumentContentObserver(IXtextDocumentContentObserver listener) {
		fail("Unexpected call");
	}

	public <T extends EObject> IEObjectHandle<T> createHandle(T obj) {
		fail("Unexpected call");
		return null;
	}

	public <T> T getAdapter(Class<T> adapterType) {
		fail("Unexpected call");
		return null;
	}

	public void removeModelListener(IXtextModelListener listener) {
		fail("Unexpected call");
	}

	public void removeXtextDocumentContentObserver(IXtextDocumentContentObserver listener) {
		fail("Unexpected call");
	}

	public <T> T modify(IUnitOfWork<T, XtextResource> work) {
		fail("Unexpected call");
		return null;
	}
	
	public <T> T readOnly(IUnitOfWork<T, XtextResource> work) {
		fail("Unexpected call");
		return null;
	}

}
