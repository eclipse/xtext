/*******************************************************************************
 * Copyright (c) 2018, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.util.StringInputStream;

/**
 * Implementation of {@link IFileGenerator} to create the files from the template inside the eclipse workspace.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @author Hannes Niederhausen - encoding fix in execute method
 * @since 2.14
 */
public class WorkspaceFileGenerator extends WorkspaceModifyOperation implements IFileGenerator {

	private final SortedMap<String, CharSequence> files = new TreeMap<>();
	private IFile firstFile;

	@Override
	public void generate(CharSequence path, CharSequence content) {
		files.put(path.toString(), content);
	}

	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, files.size());
		try {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			for (Map.Entry<String, CharSequence> fileEntry : files.entrySet()) {
				IFile file = workspace.getRoot().getFile(new Path(fileEntry.getKey()));
				file.create(new StringInputStream(fileEntry.getValue().toString(), file.getCharset()), true, subMonitor);
				if (firstFile == null) {
					firstFile = file;
				}
				subMonitor.worked(1);
			}
		} catch (UnsupportedEncodingException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, e.getMessage(), e);
			throw new CoreException(status);
		} finally {
			subMonitor.done();
		}
	}

	public IFile getResult() {
		return firstFile;
	}

}
