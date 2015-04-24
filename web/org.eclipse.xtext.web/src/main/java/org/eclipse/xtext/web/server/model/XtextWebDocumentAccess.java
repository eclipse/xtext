/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model;

import static org.eclipse.xtext.web.server.InvalidRequestException.Type.INVALID_DOCUMENT_STATE;

import java.util.Collection;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

public class XtextWebDocumentAccess {
	
	private final ReadAccess readOnlyAccess = new ReadAccess();
	
	private final ModifyAccess modifyAccess = new ModifyAccess();
	
	private final XtextWebDocument document;

	private final String requiredStateId;
	
	public XtextWebDocumentAccess(XtextWebDocument document, String requiredStateId) throws InvalidRequestException {
		this.document = document;
		this.requiredStateId = requiredStateId;
		checkStateId();
	}
	
	public XtextWebDocumentAccess(XtextWebDocument document) {
		this.document = document;
		this.requiredStateId = null;
	}

	protected void checkStateId() throws InvalidRequestException {
		if (requiredStateId != null && !requiredStateId.equals(document.getStateId())) {
			throw new InvalidRequestException(INVALID_DOCUMENT_STATE, "The given state id does not match the current state.");
		}
	}
	
	public <T> T readOnly(CancelableUnitOfWork<T, IXtextWebDocument> work) {
		return doAccess(work, false, false, null);
	}
	
	public <T> T priorityReadOnly(CancelableUnitOfWork<T, IXtextWebDocument> work, XtextWorkerThread workerThread) {
		return doAccess(work, true, false, workerThread);
	}
	
	public <T> T modify(CancelableUnitOfWork<T, IXtextWebDocument> work, XtextWorkerThread workerThread) {
		return doAccess(work, true, true, workerThread);
	}
	
	protected <T> T doAccess(CancelableUnitOfWork<T, IXtextWebDocument> work, boolean priority, boolean modify,
			XtextWorkerThread workerThread) {
		final DocumentSynchronizer synchronizer = document.getSynchronizer();
		IXtextWebDocument documentAccess = null;
		try {
			synchronizer.acquireLock(priority);
			checkStateId();
			work.setCancelIndicator(synchronizer);
			if (modify)
				documentAccess = modifyAccess;
			else
				documentAccess = readOnlyAccess;
			return work.exec(documentAccess);
		} catch (Exception exception) {
			Exceptions.sneakyThrow(exception);
			return null;
		} finally {
			if (workerThread == null || documentAccess == null || Thread.currentThread().isInterrupted()) {
				synchronizer.releaseLock();
			} else {
				workerThread.setDocument(documentAccess);
				workerThread.setCancelIndicator(synchronizer);
				workerThread.setWhenFinished(new Procedure0() {
					@Override
					public void apply() {
						synchronizer.releaseLock();
					}
				});
				workerThread.start();
			}
		}
	}
	
	protected class ReadAccess implements IXtextWebDocument {
		@Override
		public XtextResource getResource() {
			return document.getResource();
		}

		@Override
		public String getResourceId() {
			return document.getResourceId();
		}
		
		@Override
		public String getText() {
			return document.getText();
		}
		
		@Override
		public String getStateId() {
			return document.getStateId();
		}
		
		@Override
		public boolean isDirty() {
			return document.isDirty();
		}

		@Override
		public boolean isProcessingCompleted() {
			return document.isProcessingCompleted();
		}

		@Override
		public Collection<Issue> getIssues() {
			return document.getIssues();
		}

		@Override
		public void setDirty(boolean dirty) {
			document.setDirty(dirty);
		}

		@Override
		public void setText(String text) {
			throw new UnsupportedOperationException("Cannot modify the document with read-only access.");
		}

		@Override
		public void updateText(String text, int offset, int replaceLength) {
			throw new UnsupportedOperationException("Cannot modify the document with read-only access.");
		}

		@Override
		public void createNewStateId() {
			throw new UnsupportedOperationException("Cannot modify the document with read-only access.");
		}

		@Override
		public void setProcessingCompleted(boolean completed) {
			throw new UnsupportedOperationException("Cannot modify the document with read-only access.");
		}
	}
	
	protected class ModifyAccess extends ReadAccess {
		@Override
		public void setText(String text) {
			document.setText(text);
		}
		
		@Override
		public void updateText(String text, int offset, int replaceLength) {
			document.updateText(text, offset, replaceLength);
		}
		
		@Override
		public void createNewStateId() {
			document.createNewStateId();
		}

		@Override
		public void setProcessingCompleted(boolean completed) {
			document.setProcessingCompleted(completed);
		}
	}

}