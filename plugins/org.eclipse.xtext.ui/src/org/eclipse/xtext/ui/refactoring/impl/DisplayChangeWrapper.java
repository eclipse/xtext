/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.ChangeDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;

/**
 * Wraps the execution of a {@link Change} to be performed on the display thread.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class DisplayChangeWrapper extends Change {

	private Change delegate;

	public DisplayChangeWrapper(Change delegate) {
		this.delegate = delegate;
	}
	
	public Change getDelegate() {
		return delegate;
	}

	@Override
	public ChangeDescriptor getDescriptor() {
		return delegate.getDescriptor();
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public void setEnabled(boolean enabled) {
		delegate.setEnabled(enabled);
	}

	@Override
	public Change getParent() {
		return delegate.getParent();
	}

	@Override
	public void dispose() {
		delegate.dispose();
	}

	@Override
	public boolean equals(Object obj) {
		return delegate.equals(obj);
	}

	@Override
	public Object getModifiedElement() {
		return delegate.getModifiedElement();
	}

	@Override
	public Object[] getAffectedObjects() {
		return delegate.getAffectedObjects();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		return delegate.getAdapter(adapter);
	}

	@Override
	public int hashCode() {
		return delegate.hashCode();
	}

	@Override
	public boolean isEnabled() {
		return delegate.isEnabled();
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
		delegate.initializeValidationData(pm);
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return delegate.isValid(pm);
	}

	@Override
	public Change perform(final IProgressMonitor pm) throws CoreException {
		Change undoChange = new DisplayRunnableWithResult<Change>() {
			@Override
			protected Change run() throws Exception {
				return delegate.perform(pm);
			}
		}.syncExec();
		return new DisplayChangeWrapper(undoChange);
	}

	@Override
	public String toString() {
		return delegate.toString();
	}

}