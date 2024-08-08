/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.refactoring2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.resource.ResourceChange;

import com.google.common.io.ByteStreams;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
public class ReplaceFileContentChange extends ResourceChange {

	private static final Logger LOG = Logger.getLogger(ReplaceFileContentChange.class);

	private final IFile file;

	private final byte[] newContents;

	private String name;

	private VerifyMode verifyMode = VerifyMode.BOTH;
	private enum VerifyMode {
		BOTH,
		NOT_FOR_UNDO_NOW_FWD,
		NOT_FOR_UNDO_NOW_UNDO
	}

	public ReplaceFileContentChange(String name, IFile file, byte[] newContents) {
		this(file, newContents);
		this.name = name;
	}

	public ReplaceFileContentChange(IFile file, byte[] newContents) {
		this.file = file;
		this.newContents = newContents;
	}

	private ReplaceFileContentChange(String name, IFile file, byte[] newContents, VerifyMode verifyMode) {
		this(name, file, newContents);
		this.verifyMode = verifyMode;
	}

	@Override
	protected IResource getModifiedResource() {
		return file;
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		RefactoringStatus result = new RefactoringStatus();
		if (verifyMode != VerifyMode.NOT_FOR_UNDO_NOW_UNDO && !file.exists()) {
			result.addFatalError("File " + file.getFullPath() + " does not exist");
		}
		return result;
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		byte[] oldContents = getOldContents();
		Change change = null;
		try (ByteArrayInputStream newContentsIS = new ByteArrayInputStream(newContents)) {
			file.setContents(newContentsIS, true, true, pm);
			change = new ReplaceFileContentChange(null, file, oldContents, getNextUndoVerifyMode());
		} catch (IOException e) {
			LOG.error("Error closing stream", e);
		}
		return change;
	}

	private VerifyMode getNextUndoVerifyMode() {
		if(verifyMode == VerifyMode.NOT_FOR_UNDO_NOW_FWD ) {
			return VerifyMode.NOT_FOR_UNDO_NOW_UNDO;
		}
		if(verifyMode == VerifyMode.NOT_FOR_UNDO_NOW_UNDO ) {
			return VerifyMode.NOT_FOR_UNDO_NOW_FWD;
		}
		return VerifyMode.BOTH;
	}

	protected byte[] getOldContents() {
		byte[] oldContents = new byte[0];
		try (InputStream oldContentsIS = file.getContents()) {
			try {
				oldContents = ByteStreams.toByteArray(oldContentsIS);
			} catch (IOException e) {
				LOG.error("Error reading contents of file " + file.getName(), e);
			}
		} catch (IOException e) {
			LOG.error("Error closing stream", e);
		} catch (CoreException e) {
			LOG.error("Error reading contents of file " + file.getName(), e);
		}
		return oldContents;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@link #isValid(IProgressMonitor)} does verify that the file is existing.
	 * But when this change is potentially combined with file renaming or move, that verify will fail for UNDO.
	 * Skipping it avoids the problem.
	 */
	public static ReplaceFileContentChange createWithSkippingUndoVerify(String name, IFile file, byte[] newContent) {
		return new ReplaceFileContentChange(name, file, newContent, VerifyMode.NOT_FOR_UNDO_NOW_FWD);
	}
}
