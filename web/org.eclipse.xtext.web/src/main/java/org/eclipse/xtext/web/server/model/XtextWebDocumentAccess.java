/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model;

import static org.eclipse.xtext.web.server.InvalidRequestException.Type.INVALID_DOCUMENT_STATE;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.xbase.lib.Exceptions;

public class XtextWebDocumentAccess {
	
	private final Lock lock = new ReentrantLock();
	
	private final ReadAccess readOnlyAccess = new ReadAccess();
	
	private final ModifyAccess modifyAccess = new ModifyAccess();
	
	private final ModificationCancelIndicator cancelIndicator = new ModificationCancelIndicator();

	private final IXtextWebDocument document;

	private final String requiredStateId;
	
	public XtextWebDocumentAccess(IXtextWebDocument document, String requiredStateId) throws InvalidRequestException {
		this.document = document;
		this.requiredStateId = requiredStateId;
		checkStateId();
	}
	
	public XtextWebDocumentAccess(IXtextWebDocument document) {
		this.document = document;
		this.requiredStateId = null;
	}

	protected void checkStateId() throws InvalidRequestException {
		if (requiredStateId != null && !requiredStateId.equals(document.getStateId())) {
			throw new InvalidRequestException(INVALID_DOCUMENT_STATE, "The given state id does not match the current state.");
		}
	}
	
	public <T> T readOnly(CancelableUnitOfWork<T, IXtextWebDocument> work) {
		lock.lock();
		try {
			checkStateId();
			work.setCancelIndicator(cancelIndicator);
			return work.exec(readOnlyAccess);
		} catch (Exception exception) {
			Exceptions.sneakyThrow(exception);
			return null;
		} finally {
			lock.unlock();
		}
	}
	
	public <T> T modify(CancelableUnitOfWork<T, IXtextWebDocument> work) {
		cancelIndicator.canceled = true;
		lock.lock();
		cancelIndicator.canceled = false;
		try {
			checkStateId();
			work.setCancelIndicator(cancelIndicator);
			return work.exec(modifyAccess);
		} catch (Exception exception) {
			Exceptions.sneakyThrow(exception);
			return null;
		} finally {
			lock.unlock();
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
		public void setText(String text) {
			throw new UnsupportedOperationException("Cannot modify the document with read-only access.");
		}

		@Override
		public void updateText(String text, int offset, int replaceLength) {
			throw new UnsupportedOperationException("Cannot modify the document with read-only access.");
		}

		@Override
		public void setDirty(boolean dirty) {
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
		public void setDirty(boolean dirty) {
			document.setDirty(dirty);
		}
	}
	
	protected static class ModificationCancelIndicator implements CancelIndicator {
		boolean canceled;
		
		@Override
		public boolean isCanceled() {
			return canceled;
		}
	}
	
}