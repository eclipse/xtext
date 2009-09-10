/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.validation;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;

public interface IXtextResourceChecker {

	static final String CODE_KEY = "code";
	static final String DIAGNOSTIC_KEY = "EmfDiagnostic";
	
	List<Map<String, Object>> check(final Resource resource, Map<?, ?> context, IProgressMonitor monitor);

}
