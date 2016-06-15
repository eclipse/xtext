/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.TraceNotFoundException;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider.Registry;
import org.eclipse.xtext.ui.generator.trace.StorageAwareTrace;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.common.base.Throwables;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TraceEditor extends EcoreEditor {

	private StyledText text;

	@Override
	protected Composite createPageContainer(final Composite parent) {
		Composite tree = new Composite(parent, SWT.NONE);
		final Sash sash = new Sash(parent, SWT.HORIZONTAL);
		text = new StyledText(parent, SWT.READ_ONLY | SWT.V_SCROLL | SWT.H_SCROLL);
		text.setFont(JFaceResources.getTextFont());

		final FormLayout form = new FormLayout();
		parent.setLayout(form);

		FormData treeData = new FormData();
		treeData.left = new FormAttachment(0, 0);
		treeData.right = new FormAttachment(100, 0);
		treeData.top = new FormAttachment(0, 0);
		treeData.bottom = new FormAttachment(sash, 0);
		tree.setLayoutData(treeData);

		final int limit = 20, percent = 50;
		final FormData sashData = new FormData();
		sashData.left = new FormAttachment(0, 0);
		sashData.top = new FormAttachment(percent, 0);
		sashData.right = new FormAttachment(100, 0);
		sash.setLayoutData(sashData);
		sash.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event e) {
				Rectangle sashRect = sash.getBounds();
				Rectangle parentRect = parent.getClientArea();
				int bottom = parentRect.height - sashRect.height - limit;
				e.y = Math.max(Math.min(e.y, bottom), limit);
				if (e.y != sashRect.y) {
					sashData.top = new FormAttachment(0, e.y);
					parent.layout();
				}
			}
		});
		FormData textData = new FormData();
		textData.left = new FormAttachment(0, 0);
		textData.right = new FormAttachment(100, 0);
		textData.top = new FormAttachment(sash, 0);
		textData.bottom = new FormAttachment(100, 0);
		text.setLayoutData(textData);
		addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					try {
					Object x = ((IStructuredSelection) selection).getFirstElement();
					if (x instanceof EObject)
						updateText((EObject) x);
					if (x instanceof Resource)
						updateText(((Resource) x).getContents().get(0));
					} catch (Exception e) {
						text.setText(Throwables.getStackTraceAsString(e));
					}
				}
			}
		});
		return tree;
	}

	protected IStorage getLocalStorage(IResourceServiceProvider serviceProvider, URI traceURI) {
		TraceFileNameProvider fileNameProvider = serviceProvider.get(TraceFileNameProvider.class);
		IStorage2UriMapper storage2UriMapper = serviceProvider.get(IStorage2UriMapper.class);
		String generatedName = fileNameProvider.getJavaFromTrace(traceURI.lastSegment());
		URI generatedURI = traceURI.trimSegments(1).appendSegment(generatedName);
		for (Pair<IStorage, IProject> x : storage2UriMapper.getStorages(generatedURI))
			return x.getFirst();
		throw new IllegalStateException("Could not find IStorage for " + generatedURI);
	}

	protected void updateText(EObject obj) {
		DebugTraceRegion region = EcoreUtil2.getContainerOfType(obj, DebugTraceRegion.class);
		if (region == null) {
			text.setText("No " + DebugTraceRegion.class.getSimpleName() + " found for " + obj.eClass().getName());
			return;
		}
		final DebugTraceBasedRegion trace = new DebugTraceBasedRegion(null, region);
		SourceRelativeURI sourceURI = trace.getAssociatedSrcRelativePath();
		if (sourceURI == null) {
			text.setText("Could not find associated URI");
			return;
		}
		Registry registry = IResourceServiceProvider.Registry.INSTANCE;
		IResourceServiceProvider serviceProvider = registry.getResourceServiceProvider(sourceURI.getURI());
		URI traceURI = obj.eResource().getURI();
		IStorage localStorage = getLocalStorage(serviceProvider, traceURI);

		StorageAwareTrace traceProvider = serviceProvider.get(StorageAwareTrace.class);
		traceProvider.setLocalStorage(localStorage);
		traceProvider.setTraceToSource(true);
		traceProvider.setTraceRegionProvider(new ITraceRegionProvider() {
			@Override
			public AbstractTraceRegion getTraceRegion() throws TraceNotFoundException {
				return trace;
			}
		});
		String newText = traceProvider.toString();
		text.setText(newText);
	}

}
