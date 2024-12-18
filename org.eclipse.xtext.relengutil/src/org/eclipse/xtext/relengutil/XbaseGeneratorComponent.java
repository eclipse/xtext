/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.relengutil;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe2.runtime.Mandatory;

/**
 * MWE2 wrapper around the GenerateXbase class.
 */
public class XbaseGeneratorComponent extends AbstractWorkflowComponent2 {

	private String rootPath;
	
	public XbaseGeneratorComponent() {}
	
	@Mandatory
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}
	
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		try {
			var generateXbase = Class.forName("org.eclipse.xtext.xbase.GenerateXbase");
			var main = generateXbase.getMethod("main", String[].class);
			main.invoke(null, new Object[] {  new String[] {rootPath} });
		} catch(ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}

}
