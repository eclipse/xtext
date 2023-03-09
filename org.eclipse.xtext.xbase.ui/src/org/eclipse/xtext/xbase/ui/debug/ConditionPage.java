/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.debug;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.internal.ui.SWTFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.debug.core.IJavaBreakpoint;
import org.eclipse.jdt.debug.core.IJavaStratumLineBreakpoint;
import org.eclipse.jdt.debug.ui.breakpoints.JavaBreakpointConditionEditor;
import org.eclipse.jdt.internal.debug.ui.propertypages.JavaBreakpointPage;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.xtext.builder.smap.StratumBreakpointAdapterFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class ConditionPage extends JavaBreakpointPage {
	@Inject
	private IResourceServiceProvider.Registry registry;
	
	private JavaBreakpointConditionEditor editor;

	@Override
	protected Control createContents(Composite parent) {
		noDefaultAndApplyButton();
		Composite mainComposite = SWTFactory.createComposite(parent, parent.getFont(), 1, 1, GridData.FILL_HORIZONTAL, 0, 0);
		createTypeSpecificEditors(mainComposite);
		setValid(true);
		return mainComposite;
	}
	
	@Override
	protected void doStore() throws CoreException {
		if (editor != null && editor.isDirty()) {
			editor.doSave();
		}
	}
	
	@Override
	protected void createTypeSpecificEditors(Composite parent) {
		try {
			IJavaBreakpoint breakpoint = getBreakpoint();
			IMarker marker = breakpoint.getMarker();
			Object sourceUri = marker.getAttribute(StratumBreakpointAdapterFactory.ORG_ECLIPSE_XTEXT_XBASE_SOURCE_URI);
			if (sourceUri != null) {
				setTitle("Condition");
				final JavaBreakpointConditionEditor editor = new JavaBreakpointConditionEditor();
				editor.createControl(parent);
				editor.addPropertyListener(new IPropertyListener() {
					@Override
					public void propertyChanged(Object source, int propId) {
						IStatus status = editor.getStatus();
						if (status.isOK()) {
							if (fPrevMessage != null) {
								removeErrorMessage(fPrevMessage);
								fPrevMessage = null;
							}
						} else {
							fPrevMessage = status.getMessage();
							addErrorMessage(fPrevMessage);
						}
					}
				});
				URI uri = URI.createURI(String.valueOf(sourceUri));
				JavaBreakPointProvider breakPointProvider = registry.getResourceServiceProvider(uri).get(JavaBreakPointProvider.class);
				editor.setInput(breakPointProvider.getBreakpointWithJavaLocation((IJavaStratumLineBreakpoint) breakpoint));
				// set this editor only if it was correctly initialized
				this.editor = editor;
			}
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		} 
	}
	
}
