/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.ui.refactoring.IChangeRedirector;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;

import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * Aggregates {@link TextEdit}s and/or {@link Change}s into a {@link CompositeChange}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RefactoringUpdateAcceptor implements IRefactoringUpdateAcceptor, IChangeRedirector.Aware {

	private IRefactoringDocument.Provider refactoringDocumentProvider; 
	
	@Inject
	public RefactoringUpdateAcceptor(IRefactoringDocument.Provider refactoringDocumentProvider) {
		this.refactoringDocumentProvider = refactoringDocumentProvider;
	}

	@Inject
	private StatusWrapper status;
	
	private Map<URI, IRefactoringDocument> uri2document = newHashMap();
	private Multimap<IRefactoringDocument, TextEdit> document2textEdits = LinkedHashMultimap.create();
	private Multimap<IRefactoringDocument, Change> document2change = LinkedHashMultimap.create();

	public void accept(URI resourceURI, TextEdit textEdit) {
		IRefactoringDocument document = getDocument(resourceURI);
		document2textEdits.put(document, textEdit);
	}

	public void accept(URI resourceURI, Change change) {
		IRefactoringDocument document = getDocument(resourceURI);
		document2change.put(document, change);
	}
	
	public IRefactoringDocument getDocument(URI resourceURI) {
		IRefactoringDocument document = uri2document.get(resourceURI);
		if(document != null) 
			return document;
		IRefactoringDocument newDocument = refactoringDocumentProvider.get(resourceURI, status); 
		uri2document.put(resourceURI, newDocument);
		return newDocument;
	}

	public StatusWrapper getRefactoringStatus() {
		return status;
	}
	
	public Change createCompositeChange(String name, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, document2textEdits.keySet().size()
				+ document2change.keySet().size());
		if(document2change.isEmpty() && document2textEdits.isEmpty())
			return null;
		CompositeChange compositeChange = new CompositeChange(name);
		for (IRefactoringDocument document : document2textEdits.keySet()) {
			Iterable<TextEdit> textEdits = document2textEdits.get(document);
			MultiTextEdit multiTextEdit = new MultiTextEdit();
			for (TextEdit textEdit : textEdits) {
				multiTextEdit.addChild(textEdit);
			}
			Change change = document.createChange(name, multiTextEdit);
			compositeChange.add(change);
			progress.worked(1);
		}
		for (IRefactoringDocument document : document2change.keySet()) {
			Iterable<Change> documentChanges = document2change.get(document);
			CompositeChange documentCompositeChange = new CompositeChange(name);
			documentCompositeChange.addAll(Iterables.toArray(documentChanges, Change.class));
			compositeChange.add(documentCompositeChange);
			progress.worked(1);
		}
		return compositeChange;
	}

	public void setChangeRedirector(IChangeRedirector changeRedirector) {
		if(refactoringDocumentProvider instanceof IChangeRedirector.Aware) 
			((IChangeRedirector.Aware) refactoringDocumentProvider).setChangeRedirector(changeRedirector);
	}

	public IChangeRedirector getChangeRedirector() {
		if(refactoringDocumentProvider instanceof IChangeRedirector.Aware) 
			return ((IChangeRedirector.Aware) refactoringDocumentProvider).getChangeRedirector();
		else 
			return IChangeRedirector.NULL;
	}
}
