/*******************************************************************************
 * Copyright (c) 2012, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.formatting;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.RuntimeIOException;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
public class PreferenceStoreWhitespaceInformationProvider implements IWhitespaceInformationProvider {

	@Inject
	private IIndentationInformation indentInfo;
	
	@Inject
	private ILineSeparatorInformation lineSeparatorInformation;

	@Inject
	private IStorage2UriMapper storage2UriMapper;

	@Inject
	private IWorkspace workspace;

	@Override
	public IIndentationInformation getIndentationInformation(URI uri) {
		return indentInfo;
	}

	@Override
	public ILineSeparatorInformation getLineSeparatorInformation(URI uri) {
		if (uri == null) {
			return lineSeparatorInformation;
		}
		final String lineSeparator = getLineSeparatorPreference(uri);
		return new ILineSeparatorInformation() {
			@Override
			public String getLineSeparator() {
				return lineSeparator;
			}
		};
	}

	protected String getLineSeparatorPreference(URI uri) {
		if (uri.isPlatformResource()) {
			IFile file = workspace.getRoot().getFile(new Path(uri.toPlatformString(true)));
			String delimiter = senseLineDelimiter(file);
			if (delimiter != null) return delimiter;
		}
		IProject project = null;
		if (uri.isPlatformResource()) {
			project = workspace.getRoot().getProject(uri.segment(1));
		} else {
			for (Pair<IStorage, IProject> storage : storage2UriMapper.getStorages(uri)) {
				project = storage.getSecond();
				break;
			}
		}
		if (project != null) {
			String result = getLineSeparatorPreference(new ProjectScope(project));
			if (result != null)
				return result;
		}
		String result = getLineSeparatorPreference(InstanceScope.INSTANCE);
		if (result != null)
			return result;
		return System.getProperty("line.separator");
	}
	
	private String senseLineDelimiter(IFile file) {
		if (file.exists()) {
			InputStream content = null;
			try {
				content = file.getContents();
				Reader reader = new InputStreamReader(content, file.getCharset());
				int read;
				boolean rFound = false;
				while ((read = reader.read()) != -1) {
					char c = (char) read;
					if (c == '\n') {
						if (rFound) {
							return "\r\n";
						} else {
							return "\n";
						}
					}
					if (rFound) {
						return "\r";
					}
					if (c == '\r') {
						rFound = true;
					}
				}
				if (rFound) {
					return "\r";
				}
			} catch (CoreException e) {
				if (e.getStatus().getCode()!=IResourceStatus.RESOURCE_NOT_FOUND) {
					throw new RuntimeIOException(e);
				}
			} catch (Exception e) {
				throw new RuntimeIOException(e);
			} finally {
				try {
					if (content != null) {
						content.close();
					}
				} catch (IOException e) {
					throw new RuntimeIOException(e);
				}
			}
		}
		return null;
	}

	protected String getLineSeparatorPreference(IScopeContext scopeContext) {
		String lineDelimiter = Platform.getPreferencesService().getString(Platform.PI_RUNTIME,
				Platform.PREF_LINE_SEPARATOR, null, new IScopeContext[] { scopeContext });
		return lineDelimiter;
	}
}
