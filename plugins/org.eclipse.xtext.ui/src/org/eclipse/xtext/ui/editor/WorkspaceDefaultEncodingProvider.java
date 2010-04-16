/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.parser.IDefaultEncodingProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author koehnlein - Initial contribution and API
 */
@Singleton
public class WorkspaceDefaultEncodingProvider implements IDefaultEncodingProvider {

	private static final Logger LOG = Logger.getLogger(WorkspaceDefaultEncodingProvider.class); 
	
	@Inject
	private IWorkspace workspace;
	
	public String getEncoding() {
		if(workspace == null) {
			try {
				return workspace.getRoot().getDefaultCharset();
			} catch (CoreException e) {
				LOG.error("Error gettig workspace encoding", e);
			}	
		}
		return Charset.defaultCharset().name();
	}

}
