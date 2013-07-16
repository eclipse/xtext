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
import org.eclipse.jdt.internal.junit.model.TestElement;
import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.util.Strings;

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
	private ITestElement testElement;

	public FailureCompareEditorInput(ITestElement testElement, IFile file) {
		super(createConfiguration(file));
		this.testElement = testElement;
		this.file = file;
	}

	@Override
	public String getTitle() {
		if (file != null)
			return file.getName();
		return super.getTitle();
	}

	protected Object prepareInput(IProgressMonitor pm) {
		TestElement te = (TestElement) testElement;
		ResourceNode ancestor = null;
		if (file != null) {
			ancestor = new ResourceNode(file);
			if (!Strings.isEmpty(te.getExpected()))
				try {
					String original = new String(ancestor.getContent(), file.getCharset());
					if (!te.getExpected().equals(original))
						getCompareConfiguration().setProperty(ICompareUIConstants.PROP_ANCESTOR_VISIBLE, Boolean.TRUE);
				} catch (UnsupportedEncodingException e) {
					LOG.error(e.getMessage(), e);
				} catch (CoreException e) {
					LOG.error(e.getMessage(), e);
				}
		}
		CompareItem left = new EditableCompareItem("Left", te.getExpected(), file);
		CompareItem right = new CompareItem("Right", te.getActual());
		return new DiffNode(null, Differencer.CHANGE | Differencer.DIRECTION_MASK, ancestor, left, right);
	}

}
