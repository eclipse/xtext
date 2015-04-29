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
import java.util.concurrent.RejectedExecutionException;

import org.apache.log4j.Logger;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.xbase.lib.Exceptions;

public class XtextWebDocumentAccess {
	
	private static final Logger LOG = Logger.getLogger(XtextWebDocumentAccess.class);
	
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
	
	public <T> T priorityReadOnly(CancelableUnitOfWork<T, IXtextWebDocument> work,
			CancelableUnitOfWork<T, IXtextWebDocument> asynchronousWork) {
		return doAccess(work, true, false, asynchronousWork);
	}
	
	public <T> T modify(CancelableUnitOfWork<T, IXtextWebDocument> work,
			CancelableUnitOfWork<?, IXtextWebDocument> asynchronousWork) {
		return doAccess(work, true, true, asynchronousWork);
	}
	
	protected <T> T doAccess(CancelableUnitOfWork<T, IXtextWebDocument> synchronousWork, boolean priority,
			boolean modify, final CancelableUnitOfWork<?, IXtextWebDocument> asynchronousWork) {
		final DocumentSynchronizer synchronizer = document.getSynchronizer();
		IXtextWebDocument documentAccess = null;
		try {
			synchronizer.acquireLock(priority);
			checkStateId();
			synchronousWork.setCancelIndicator(synchronizer);
			if (modify)
				documentAccess = modifyAccess;
			else
				documentAccess = readOnlyAccess;
			return synchronousWork.exec(documentAccess);
		} catch (Exception exception) {
			Exceptions.sneakyThrow(exception);
			return null;
		} finally {
			if (asynchronousWork == null || documentAccess == null || synchronizer.isCanceled()
					|| Thread.currentThread().isInterrupted()) {
				synchronizer.releaseLock();
			} else {
				
				asynchronousWork.setCancelIndicator(synchronizer);
				final IXtextWebDocument asyncAccess = documentAccess;
				try {
					synchronizer.getExecutorService().submit(new Runnable() {
						@Override
						public void run() {
							try {
								asynchronousWork.exec(asyncAccess);
							} catch (VirtualMachineError error) {
								throw error;
							} catch (Throwable throwable) {
								if (!synchronizer.getOperationCanceledManager().isOperationCanceledException(throwable)) {
									LOG.error("Error during asynchronous service processing.", throwable);
								} else {
									LOG.trace("Canceling background process.");
								}
							} finally {
								synchronizer.releaseLock();
							}
						}
					});
				} catch (RejectedExecutionException ree) {
					synchronizer.releaseLock();
					LOG.error("Failed to start background work.", ree);
				}
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
		public void setProcessingCompleted(boolean completed) {
			document.setProcessingCompleted(completed);
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
	}

}