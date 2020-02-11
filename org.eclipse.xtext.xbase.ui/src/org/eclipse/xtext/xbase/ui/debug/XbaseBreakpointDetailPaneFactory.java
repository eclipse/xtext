/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.debug;

import java.util.Collections;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.ui.IDetailPane;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.debug.core.IJavaStratumLineBreakpoint;
import org.eclipse.jdt.internal.debug.ui.JDIDebugUIPlugin;
import org.eclipse.jdt.internal.debug.ui.breakpoints.AbstractJavaBreakpointEditor;
import org.eclipse.jdt.internal.debug.ui.breakpoints.BreakpointDetailPaneFactory;
import org.eclipse.jdt.internal.debug.ui.breakpoints.LineBreakpointDetailPane;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.xtext.builder.smap.StratumBreakpointAdapterFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Inject;

/**
 * Creates the detail pane for Xbase breakpoints, e.g. Stratum breakpoint that have a special
 * xbase source marker.
 * 
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XbaseBreakpointDetailPaneFactory extends BreakpointDetailPaneFactory {
	public static final String XBASE_DETAIL_PANE = "org.eclipse.xtext.xbase.debug.DetailPane";

	@Inject
	private XbaseDetailPanePrioritizer prioritizer;
	@Inject
	private IResourceServiceProvider.Registry registry;
	
	@Override
	public Set<String> getDetailPaneTypes(IStructuredSelection selection) {
		prioritizer.prioritizeXbaseOverJdt();
		if (selection.size() == 1) {
			Object selectedElement = selection.getFirstElement();
			if (selectedElement instanceof IBreakpoint) {
				IBreakpoint b = (IBreakpoint) selectedElement;
				try {
					Object sourceUri = b.getMarker().getAttribute(StratumBreakpointAdapterFactory.ORG_ECLIPSE_XTEXT_XBASE_SOURCE_URI);
					if (sourceUri != null) {
						return Collections.singleton(XBASE_DETAIL_PANE);
					}
				} catch (CoreException e) {}
			}
		}
		return Collections.emptySet();
	}
	
	@Override
	public IDetailPane createDetailPane(String paneID) {
		if (XBASE_DETAIL_PANE.equals(paneID)) {
			return new LineBreakpointDetailPane() {
				@Override
				public void display(IStructuredSelection selection) {
					super.display(selection);
					AbstractJavaBreakpointEditor editor = getEditor();
					Object input = null;
					if (selection != null && selection.size() == 1) {
						input = selection.getFirstElement();
					}
					try {
						if (input instanceof IJavaStratumLineBreakpoint) {
							IJavaStratumLineBreakpoint stratumBreakpoint = (IJavaStratumLineBreakpoint) input;
							URI uri = URI.createURI((String) stratumBreakpoint.getMarker().getAttribute(StratumBreakpointAdapterFactory.ORG_ECLIPSE_XTEXT_XBASE_SOURCE_URI));
							IResourceServiceProvider resourceServiceProvider = registry.getResourceServiceProvider(uri);
							if (resourceServiceProvider != null) {
								JavaBreakPointProvider javaBreakPointProvider = resourceServiceProvider.get(JavaBreakPointProvider.class);
								input = javaBreakPointProvider.getBreakpointWithJavaLocation(stratumBreakpoint);
							}
						}
						editor.setInput(input);
					} catch (CoreException e) {
						JDIDebugUIPlugin.log(e);
					}
				}
			};
		} else {
			return super.createDetailPane(paneID);
		}
	}
}
