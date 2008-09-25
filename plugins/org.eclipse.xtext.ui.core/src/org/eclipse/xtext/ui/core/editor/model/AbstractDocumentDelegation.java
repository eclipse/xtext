package org.eclipse.xtext.ui.core.editor.model;

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

public abstract class AbstractDocumentDelegation implements IDocument {
	private IDocument document;
	
	public AbstractDocumentDelegation(IDocument doc) {
		if (doc==null)throw new NullPointerException();
		this.document = doc;
	}

	public void addDocumentListener(IDocumentListener listener) {
		document.addDocumentListener(listener);
	}

	public void addDocumentPartitioningListener(IDocumentPartitioningListener listener) {
		document.addDocumentPartitioningListener(listener);
	}

	public void addPosition(Position position) throws BadLocationException {
		document.addPosition(position);
	}

	public void addPosition(String category, Position position) throws BadLocationException,
			BadPositionCategoryException {
		document.addPosition(category, position);
	}

	public void addPositionCategory(String category) {
		document.addPositionCategory(category);
	}

	public void addPositionUpdater(IPositionUpdater updater) {
		document.addPositionUpdater(updater);
	}

	public void addPrenotifiedDocumentListener(IDocumentListener documentAdapter) {
		document.addPrenotifiedDocumentListener(documentAdapter);
	}

	public int computeIndexInCategory(String category, int offset) throws BadLocationException,
			BadPositionCategoryException {
		return document.computeIndexInCategory(category, offset);
	}

	public int computeNumberOfLines(String text) {
		return document.computeNumberOfLines(text);
	}

	public ITypedRegion[] computePartitioning(int offset, int length) throws BadLocationException {
		return document.computePartitioning(offset, length);
	}

	public boolean containsPosition(String category, int offset, int length) {
		return document.containsPosition(category, offset, length);
	}

	public boolean containsPositionCategory(String category) {
		return document.containsPositionCategory(category);
	}

	public String get() {
		return document.get();
	}

	public String get(int offset, int length) throws BadLocationException {
		return document.get(offset, length);
	}

	public char getChar(int offset) throws BadLocationException {
		return document.getChar(offset);
	}

	public String getContentType(int offset) throws BadLocationException {
		return document.getContentType(offset);
	}

	public IDocumentPartitioner getDocumentPartitioner() {
		return document.getDocumentPartitioner();
	}

	public String[] getLegalContentTypes() {
		return document.getLegalContentTypes();
	}

	public String[] getLegalLineDelimiters() {
		return document.getLegalLineDelimiters();
	}

	public int getLength() {
		return document.getLength();
	}

	public String getLineDelimiter(int line) throws BadLocationException {
		return document.getLineDelimiter(line);
	}

	public IRegion getLineInformation(int line) throws BadLocationException {
		return document.getLineInformation(line);
	}

	public IRegion getLineInformationOfOffset(int offset) throws BadLocationException {
		return document.getLineInformationOfOffset(offset);
	}

	public int getLineLength(int line) throws BadLocationException {
		return document.getLineLength(line);
	}

	public int getLineOffset(int line) throws BadLocationException {
		return document.getLineOffset(line);
	}

	public int getLineOfOffset(int offset) throws BadLocationException {
		return document.getLineOfOffset(offset);
	}

	public int getNumberOfLines() {
		return document.getNumberOfLines();
	}

	public int getNumberOfLines(int offset, int length) throws BadLocationException {
		return document.getNumberOfLines(offset, length);
	}

	public ITypedRegion getPartition(int offset) throws BadLocationException {
		return document.getPartition(offset);
	}

	public String[] getPositionCategories() {
		return document.getPositionCategories();
	}

	public Position[] getPositions(String category) throws BadPositionCategoryException {
		return document.getPositions(category);
	}

	public IPositionUpdater[] getPositionUpdaters() {
		return document.getPositionUpdaters();
	}

	public void insertPositionUpdater(IPositionUpdater updater, int index) {
		document.insertPositionUpdater(updater, index);
	}

	public void removeDocumentListener(IDocumentListener listener) {
		document.removeDocumentListener(listener);
	}

	public void removeDocumentPartitioningListener(IDocumentPartitioningListener listener) {
		document.removeDocumentPartitioningListener(listener);
	}

	public void removePosition(Position position) {
		document.removePosition(position);
	}

	public void removePosition(String category, Position position) throws BadPositionCategoryException {
		document.removePosition(category, position);
	}

	public void removePositionCategory(String category) throws BadPositionCategoryException {
		document.removePositionCategory(category);
	}

	public void removePositionUpdater(IPositionUpdater updater) {
		document.removePositionUpdater(updater);
	}

	public void removePrenotifiedDocumentListener(IDocumentListener documentAdapter) {
		document.removePrenotifiedDocumentListener(documentAdapter);
	}

	public void replace(int offset, int length, String text) throws BadLocationException {
		document.replace(offset, length, text);
	}

	@Deprecated
	public int search(int startOffset, String findString, boolean forwardSearch, boolean caseSensitive,
			boolean wholeWord) throws BadLocationException {
		return document.search(startOffset, findString, forwardSearch, caseSensitive, wholeWord);
	}

	public void set(String text) {
		document.set(text);
	}

	public void setDocumentPartitioner(IDocumentPartitioner partitioner) {
		document.setDocumentPartitioner(partitioner);
	}
	
}
