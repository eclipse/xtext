/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.util.Strings.*;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.ltk.core.refactoring.FileStatusContext;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusContext;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.google.common.base.Function;
import com.google.inject.Inject;
import com.ibm.icu.text.MessageFormat;

/**
 * Convenience class to create refactoring issues with an {@link RefactoringStatusContext}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class StatusWrapper {

	@Inject
	private RefactoringStatus status;

	@Inject
	private ProjectUtil projectUtil;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	private PolymorphicDispatcher<String> toString = PolymorphicDispatcher.createForSingleTarget("_toString", this);

	protected RefactoringStatusContext createContext(EObject eObject) {
		if (eObject != null) {
			ITextRegion textRegion = locationInFileProvider.getSignificantTextRegion(eObject);
			return createContext(eObject, textRegion);
		}
		return null;
	}

	protected RefactoringStatusContext createContext(EObject eObject, ITextRegion textRegion) {
		IRegion region = null;
		if (textRegion != null)
			region = new Region(textRegion.getOffset(), textRegion.getLength());
		IFile file = projectUtil.findFileStorage(EcoreUtil2.getPlatformResourceOrNormalizedURI(eObject), false);
		if(file == null)
			return null;
		return new FileStatusContext(file, region);
	}

	protected RefactoringStatusContext createContext(URI uri, ResourceSet resourceSet) {
		EObject eObject = null;
		if (resourceSet != null && uri.hasFragment())
			eObject = resourceSet.getEObject(uri, true);
		if (eObject != null)
			return createContext(eObject);
		else
			return createContext(projectUtil.findFileStorage(uri, false), null);
	}

	protected RefactoringStatusContext createContext(IFile file, ITextRegion textRegion) {
		if (file == null)
			return null;
		Region region = textRegion == null ? null : new Region(textRegion.getOffset(), textRegion.getLength());
		return new FileStatusContext(file, region);
	}

	protected String _toString(URI uri) {
		IFile file = projectUtil.findFileStorage(uri, false);
		return (file != null) ? file.getFullPath().toString() : uri.toString();
	}

	protected String _toString(EObject element) {
		return element.eClass().getName() + " '" + notNull(SimpleAttributeResolver.NAME_RESOLVER.apply(element)) + "' in " + _toString(element.eResource().getURI());
	}

	protected String _toString(Exception exc) {
		return notNull(exc.getMessage());
	}

	protected String _toString(Object element) {
		return notNull(element);
	}

	public RefactoringStatus getRefactoringStatus() {
		return status;
	}

	protected String format(String message, Object... elements) {
		Object[] strings = toArray(transform(newArrayList(elements), new Function<Object, String>() {
			public String apply(Object from) {
				return toString.invoke(from);
			}
		}), String.class);
		return MessageFormat.format(message, strings);
	}

	public void add(int severity, String message, URI uri, ResourceSet resourceSet) {
		status.addEntry(new RefactoringStatusEntry(severity, format(message, uri), createContext(uri, resourceSet)));
	}

	public void add(int severity, String message, URI resourceUri) {
		status.addEntry(new RefactoringStatusEntry(severity, format(message, resourceUri), createContext(resourceUri, null)));
	}

	public void add(int severity, String message, EObject element) {
		status.addEntry(new RefactoringStatusEntry(severity, format(message, element), createContext(element)));
	}

	public void add(int severity, String message, EObject element, ITextRegion region) {
		status.addEntry(new RefactoringStatusEntry(severity, notNull(message), createContext(element, region)));
	}

	public void add(int severity, String message, Exception exc, Logger log) {
		String formatted = format(message, exc);
		status.addEntry(new RefactoringStatusEntry(severity, formatted + ".\nSee log for details."));
		log.error(formatted, exc);
	}

	public void add(int severity, String message, Object... params) {
		status.addEntry(new RefactoringStatusEntry(severity, format(message, params)));
	}

	public void merge(RefactoringStatus status) {
		this.status.merge(status);
	}

	public void merge(StatusWrapper status) {
		this.status.merge(status.getRefactoringStatus());
	}
}
