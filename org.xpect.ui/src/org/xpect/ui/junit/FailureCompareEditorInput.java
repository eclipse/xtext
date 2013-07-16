/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.junit;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.IEditableContent;
import org.eclipse.compare.IModificationDate;
import org.eclipse.compare.IStreamContentAccessor;
import org.eclipse.compare.ITypedElement;
import org.eclipse.compare.ResourceNode;
import org.eclipse.compare.internal.ICompareUIConstants;
import org.eclipse.compare.structuremergeviewer.DiffNode;
import org.eclipse.compare.structuremergeviewer.Differencer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.junit.model.ITestCaseElement;
import org.eclipse.jdt.junit.model.ITestElement.FailureTrace;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.util.Exceptions;
import org.xpect.text.IReplacement;
import org.xpect.text.Text;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class FailureCompareEditorInput extends CompareEditorInput {

	protected static class CompareItem implements IStreamContentAccessor, ITypedElement, IModificationDate {
		private String contents, name;

		CompareItem(String name, String contents) {
			this.name = name;
			this.contents = contents;
		}

		public InputStream getContents() throws CoreException {
			return new ByteArrayInputStream(contents.getBytes());
		}

		public Image getImage() {
			return null;
		}

		public long getModificationDate() {
			return 0;
		}

		public String getName() {
			return name;
		}

		public String getString() {
			return contents;
		}

		public String getType() {
			return ITypedElement.TEXT_TYPE;
		}
	}

	protected static class EditableCompareItem extends CompareItem implements IEditableContent {
		private final IFile file;

		EditableCompareItem(String name, String contents, IFile file) {
			super(name, contents);
			this.file = file;
		}

		public boolean isEditable() {
			return file != null;
		}

		public ITypedElement replace(ITypedElement dest, ITypedElement src) {
			System.out.println("public ITypedElement replace(ITypedElement dest, ITypedElement src)");
			return null;
		}

		public void setContent(byte[] newContent) {
			ByteArrayInputStream inputStream = new ByteArrayInputStream(newContent);
			try {
				file.setContents(inputStream, true, true, new NullProgressMonitor());
			} catch (CoreException e) {
				LOG.error(e);
			}
		}

	}

	private final static Logger LOG = Logger.getLogger(FailureCompareEditorInput.class);

	protected static CompareConfiguration createConfiguration(IFile file) {
		CompareConfiguration configuration = new CompareConfiguration();
		configuration.setLeftEditable(true);
		configuration.setLeftLabel("Expected Test Result" + (file != null ? " - " + file.getName() : ""));
		configuration.setRightLabel("Actual Test Result");
		configuration.setAncestorLabel("File on Disk");
		configuration.setProperty(ICompareUIConstants.PROP_ANCESTOR_VISIBLE, Boolean.FALSE);
		return configuration;
	}

	private IFile file;
	private Collection<ITestCaseElement> testElements;

	public FailureCompareEditorInput(IFile file, Collection<ITestCaseElement> testElements) {
		super(createConfiguration(file));
		Preconditions.checkNotNull(file);
		Preconditions.checkArgument(testElements.size() > 0);
		this.testElements = testElements;
		this.file = file;
	}

	@Override
	public String getTitle() {
		return file.getName();
	}

	protected Object prepareInput(IProgressMonitor pm) {
		try {
			ResourceNode ancestor = new ResourceNode(file);
			String ancestorContent = getContent(ancestor);
			String leftContent, rightContent;
			if (testElements.size() == 1) {
				FailureTrace trace = testElements.iterator().next().getFailureTrace();
				leftContent = trace.getExpected();
				rightContent = trace.getActual();
			} else {
				List<IReplacement> expectations = Lists.newArrayList();
				List<IReplacement> actuals = Lists.newArrayList();
				Text ancestorText = new Text(ancestorContent);
				for (ITestCaseElement t : testElements) {
					IReplacement expected = ancestorText.replacementTo(t.getFailureTrace().getExpected());
					IReplacement actual = ancestorText.replacementTo(t.getFailureTrace().getActual());
					if (expected != null)
						expectations.add(expected);
					if (actual != null)
						actuals.add(actual);
				}
				leftContent = ancestorText.with(expectations);
				rightContent = ancestorText.with(actuals);
			}
			if (!leftContent.equals(ancestorContent))
				getCompareConfiguration().setProperty(ICompareUIConstants.PROP_ANCESTOR_VISIBLE, Boolean.TRUE);
			CompareItem left = new EditableCompareItem("Left", leftContent, file);
			CompareItem right = new CompareItem("Right", rightContent);
			return new DiffNode(null, Differencer.CHANGE | Differencer.DIRECTION_MASK, ancestor, left, right);
		} catch (Throwable t) {
			LOG.error(t.getMessage(), t);
			Exceptions.throwUncheckedException(t);
			return null;
		}
	}

	private String getContent(ResourceNode ancestor) {
		try {
			return new String(ancestor.getContent(), file.getCharset());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

}
