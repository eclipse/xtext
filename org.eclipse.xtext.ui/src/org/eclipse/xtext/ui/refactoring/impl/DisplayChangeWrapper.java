/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.ChangeDescriptor;
import org.eclipse.ltk.core.refactoring.GroupCategory;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.TextEditBasedChange;
import org.eclipse.ltk.core.refactoring.TextEditBasedChangeGroup;
import org.eclipse.text.edits.TextEditGroup;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;

/**
 * Wraps a {@link Change} to be performed on the display thread.
 * 
 * {@link org.eclipse.ltk.core.refactoring.DocumentChange DocumentChanges} are by default not executed on the display
 * thread, causing thread access exceptions and leaving documents opened in editors in an inconsistent state.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DisplayChangeWrapper {

	public static Change wrap(Change delegate) {
		if(delegate instanceof TextEditBasedChange) {
			return new TextEditBased((TextEditBasedChange) delegate);
		} else if (delegate != null) {
			return new Generic(delegate);
		} else {
			return null;
		}
	}
	
	public static interface Wrapper {
		Change getDelegate();
	}
	
	public static class Generic extends Change implements Wrapper {
		
		private Change delegate;
	
		protected Generic(Change delegate) {
			this.delegate = delegate;
		}
	
		@Override
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
	
		@Override
		public <T> T getAdapter(Class<T> adapter) {
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
					Change result = delegate.perform(pm);
					return result;
				}
			}.syncExec();
			Change undoWrap = DisplayChangeWrapper.wrap(undoChange);
			return undoWrap;
		}
	
		@Override
		public String toString() {
			return delegate.toString();
		}
	}
	
	/**
	 * No interfaces in LTK :-(
	 * 
	 * @author koehnlein - Initial contribution and API
	 */
	public static class TextEditBased extends TextEditBasedChange implements Wrapper {

		private TextEditBasedChange delegate;

		protected TextEditBased(TextEditBasedChange delegate) {
			super(delegate.getName());
			this.delegate = delegate;
		}

		@Override
		public TextEditBasedChange getDelegate() {
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

		@Override
		public <T> T getAdapter(Class<T> adapter) {
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
					Change result = delegate.perform(pm);
					return result;
				}
			}.syncExec();
			Change undoWrap = DisplayChangeWrapper.wrap(undoChange);
			return undoWrap;
		}

		@Override
		public String toString() {
			return delegate.toString();
		}

		@Override
		public void addChangeGroup(TextEditBasedChangeGroup group) {
			delegate.addChangeGroup(group);
		}

		@Override
		public void addTextEditGroup(TextEditGroup group) {
			delegate.addTextEditGroup(group);
		}

		@Override
		public boolean hasOneGroupCategory(List<GroupCategory> groupCategories) {
			return delegate.hasOneGroupCategory(groupCategories);
		}

		@Override
		public String getCurrentContent(IProgressMonitor pm) throws CoreException {
			return delegate.getCurrentContent(pm);
		}

		@Override
		public String getCurrentContent(IRegion region, boolean expandRegionToFullLine, int surroundingLines,
				IProgressMonitor pm) throws CoreException {
			return delegate.getCurrentContent(region, expandRegionToFullLine, surroundingLines, pm);
		}

		@Override
		public boolean getKeepPreviewEdits() {
			return delegate.getKeepPreviewEdits();
		}

		@Override
		public String getPreviewContent(TextEditBasedChangeGroup[] changeGroups, IRegion region,
				boolean expandRegionToFullLine, int surroundingLines, IProgressMonitor pm) throws CoreException {
			return delegate.getPreviewContent(changeGroups, region, expandRegionToFullLine,
					surroundingLines, pm);
		}

		@Override
		public String getPreviewContent(IProgressMonitor pm) throws CoreException {
			return delegate.getPreviewContent(pm);
		}

		@Override
		public String getTextType() {
			return delegate.getTextType();
		}

		@Override
		public void setKeepPreviewEdits(boolean keep) {
			delegate.setKeepPreviewEdits(keep);
		}

		@Override
		public void setTextType(String type) {
			delegate.setTextType(type);
		}

	}
}