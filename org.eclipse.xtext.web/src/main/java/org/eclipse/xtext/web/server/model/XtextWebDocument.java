/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Container for an {@link XtextResource}.
 */
public class XtextWebDocument implements IXtextWebDocument {

	private static final Logger LOG = Logger.getLogger(XtextWebDocument.class);

	public XtextWebDocument(String resourceId, DocumentSynchronizer synchronizer) {
		this.resourceId = resourceId;
		this.synchronizer = synchronizer;
	}

	private final String resourceId;

	private final DocumentSynchronizer synchronizer;

	private XtextResource resource;

	private String text;

	private boolean dirty;

	private final Map<Class<?>, IServiceResult> cachedServiceResults = new HashMap<>();

	/**
	 * Clear any cached result of {@link AbstractCachedService}. This method is
	 * called whenever the text content of the resource is modified, but it may be
	 * necessary to clear the cached services in other cases, too.
	 */
	public void clearCachedServiceResults() {
		cachedServiceResults.clear();
	}

	public <T extends IServiceResult> T getCachedServiceResult(AbstractCachedService<T> service,
			CancelIndicator cancelIndicator, boolean logCacheMiss) {
		IServiceResult ca = this.cachedServiceResults.get(service.getClass());
		if (ca != null) {
			@SuppressWarnings("unchecked")
			T result = (T) ca;
			return result;
		} else {
			if (logCacheMiss) {
				LOG.trace("Cache miss for " + service.getClass().getSimpleName());
			}
			T result = service.compute(this, cancelIndicator);
			cachedServiceResults.put(service.getClass(), result);
			return result;
		}
	}

	@Override
	public String toString() {
		if (resourceId != null) {
			return getClass().getSimpleName() + "(" + resourceId + ")";
		}
		return super.toString();
	}

	public String setInput(XtextResource resource) {
		clearCachedServiceResults();
		this.resource = resource;
		return refreshText();
	}

	protected String refreshText() {
		String newText = "";
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null) {
			ICompositeNode rootNode = parseResult.getRootNode();
			if (rootNode != null) {
				String text = rootNode.getText();
				if (text != null) {
					newText = text;
				} 
			}
		}
		return text = newText;
	}

	@Override
	public String getStateId() {
		return Long.toString(resource.getModificationStamp(), 16);
	}

	/**
	 * Replace the text contents of the contained resource with the given text.
	 */
	@Override
	public void setText(String text) {
		try {
			clearCachedServiceResults();
			resource.reparse(text);
			refreshText();
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	/**
	 * Update a part of the text.
	 */
	@Override
	public void updateText(String text, int offset, int replaceLength) {
		clearCachedServiceResults();
		resource.update(offset, replaceLength, text);
		refreshText();
	}

	/**
	 * A new state id should be created whenever the text content is changed. The
	 * client must know the correct state id in order to send proper requests. If a
	 * request with an outdated state id is received by the server, the request is
	 * rejected.
	 */
	@Override
	public void createNewStateId() {
		long newStateId = resource.getModificationStamp() + 1;
		resource.setModificationStamp(newStateId);
	}

	public String getResourceId() {
		return resourceId;
	}

	DocumentSynchronizer getSynchronizer() {
		return synchronizer;
	}

	public XtextResource getResource() {
		return resource;
	}

	public String getText() {
		return text;
	}

	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}
}
