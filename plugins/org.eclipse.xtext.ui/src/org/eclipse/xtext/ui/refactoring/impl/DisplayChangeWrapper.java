/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.ChangeDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.TextEditBasedChange;
import org.eclipse.ltk.core.refactoring.TextEditBasedChangeGroup;
import org.eclipse.text.edits.TextEditGroup;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;

/**
 * Wraps the execution of a {@link Change} to be performed on the display thread.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class DisplayChangeWrapper extends TextEditBasedChange {

	private Change delegate;

	public DisplayChangeWrapper(TextEditBasedChange delegate) {
		this((Change)delegate);
	}
	
	protected DisplayChangeWrapper(Change delegate) {
		super(delegate.getName());
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

	@Override
	public void addChangeGroup(TextEditBasedChangeGroup group) {
		getTextEditBasedChangeDelegate().addChangeGroup(group);
	}

	@Override
	public void addTextEditGroup(TextEditGroup group) {
		getTextEditBasedChangeDelegate().addTextEditGroup(group);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean hasOneGroupCategory(List groupCategories) {
		return getTextEditBasedChangeDelegate().hasOneGroupCategory(groupCategories);
	}

	@Override
	public String getCurrentContent(IProgressMonitor pm) throws CoreException {
		return getTextEditBasedChangeDelegate().getCurrentContent(pm);
	}

	@Override
	public String getCurrentContent(IRegion region, boolean expandRegionToFullLine, int surroundingLines,
			IProgressMonitor pm) throws CoreException {
		return getTextEditBasedChangeDelegate().getCurrentContent(region, expandRegionToFullLine, surroundingLines, pm);
	}

	@Override
	public boolean getKeepPreviewEdits() {
		return getTextEditBasedChangeDelegate().getKeepPreviewEdits();
	}

	@Override
	public String getPreviewContent(TextEditBasedChangeGroup[] changeGroups, IRegion region,
			boolean expandRegionToFullLine, int surroundingLines, IProgressMonitor pm) throws CoreException {
		return getTextEditBasedChangeDelegate().getPreviewContent(changeGroups, region, expandRegionToFullLine, surroundingLines, pm);
	}

	@Override
	public String getPreviewContent(IProgressMonitor pm) throws CoreException {
		return getTextEditBasedChangeDelegate().getPreviewContent(pm);
	}

	@Override
	public String getTextType() {
		return getTextEditBasedChangeDelegate().getTextType();
	}

	@Override
	public void setKeepPreviewEdits(boolean keep) {
		getTextEditBasedChangeDelegate().setKeepPreviewEdits(keep);
	}

	@Override
	public void setTextType(String type) {
		getTextEditBasedChangeDelegate().setTextType(type);
	}
	
	protected TextEditBasedChange getTextEditBasedChangeDelegate() {
		if(!(delegate instanceof TextEditBasedChange))
			throw new RuntimeException("Delegate change is not a TextEditBasedChange but is expected to be one. This should never happen ;-)");
		return (TextEditBasedChange) delegate;
	}
	
}