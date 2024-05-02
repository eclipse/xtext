/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution;
import org.eclipse.ui.views.markers.internal.Util;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.editor.model.edit.ITextualMultiModification;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.ui.internal.XtextPluginImages;
import org.eclipse.xtext.ui.util.IssueUtil;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Issue;

import com.google.common.annotations.Beta;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * Adapter from {@link ITextualMultiModification} to {@link WorkbenchMarkerResolution}
 * 
 * @author Christian Dietrich - Initial contribution and API
 * 
 * @since 2.17
 */
@Beta
public class TextualMultiModificationWorkbenchMarkerResolutionAdapter extends WorkbenchMarkerResolution {

	private static final Logger log = Logger.getLogger(TextualMultiModificationWorkbenchMarkerResolutionAdapter.class);

	/**
	 * The number of maximal quickfixes show on the quickfix page.
	 */
	private static final int MAX_QUICKFIXES = 5000;

	public static class Factory {

		@Inject
		protected Provider<TextualMultiModificationWorkbenchMarkerResolutionAdapter> provider;

		public IMarkerResolution create(IMarker marker, IssueResolution resolution) {
			TextualMultiModificationWorkbenchMarkerResolutionAdapter adapter = provider.get();
			adapter.setMarker(marker);
			adapter.setResolution(resolution);
			return adapter;
		}
	}

	@Inject
	private IssueModificationContext.Factory modificationContextFactory;

	@Inject
	private IssueUtil issueUtil;

	@Inject
	private IImageHelper imageHelper;

	@Inject
	private ILanguageResourceHelper languageResourceHelper;

	@Named(AbstractIssueResolutionProviderAdapter.DEFAULT_IMAGE)
	@Inject(optional = true)
	private String defaultImage = XtextPluginImages.OBJ_CORRECTION_CHANGE;

	private IssueResolution resolution;
	
	private IMarker marker;

	public IssueResolution getResolution() {
		return resolution;
	}

	public void setResolution(IssueResolution resolution) {
		if (!(resolution.getModification() instanceof ITextualMultiModification)) {
			throw new IllegalArgumentException("ITextualMultiModification expected");
		}
		this.resolution = resolution;
	}

	public IMarker getMarker() {
		return marker;
	}

	public void setMarker(IMarker marker) {
		this.marker = marker;
	}

	@Override
	public String getLabel() {
		return resolution.getLabel();
	}

	@Override
	public void run(IMarker pMarker) {
		Issue issue = issueUtil.createIssue(pMarker);
		if (issue == null) {
			return;
		}
		try {
			resolution.getModification().apply(modificationContextFactory.createModificationContext(issue));
		} catch (Exception exc) {
			throw new WrappedException(exc);
		}
	}

	@Override
	public String getDescription() {
		return resolution.getDescription();
	}

	@Override
	public Image getImage() {
		return getImage(resolution);
	}

	public Image getImage(IssueResolution resolution) {
		if (Strings.isEmpty(resolution.getImage()))
			return XtextPluginImages.get(defaultImage);
		else
			return imageHelper.getImage(resolution.getImage());
	}

	@Override
	public IMarker[] findOtherMarkers(IMarker[] markers) {
		List<IMarker> result = new ArrayList<>();
		Object markerCodeKey;
		try {
			markerCodeKey = marker.getAttribute(Issue.CODE_KEY);
			if (markerCodeKey != null) {
				for (IMarker candidate : markers) {
					if (languageResourceHelper.isLanguageResource(marker.getResource()) && candidate != marker) {
						Object canidateCodeKey = candidate.getAttribute(Issue.CODE_KEY);
						if (Objects.equals(markerCodeKey, canidateCodeKey)) {
							result.add(candidate);
							if (result.size() >= MAX_QUICKFIXES) {
								break;
							}
						}
					}
				}
			}
		} catch (CoreException e) {
			log.error("Reading of Marker attributes failed", e);
		}
		return result.toArray(new IMarker[result.size()]);
	}

	public void processUIEvents(int waitTime) {
		if (Display.getCurrent() != null) {
			while (Display.getDefault().readAndDispatch()) {
				// process queued ui events
			}
		}
		if (waitTime != 0) {
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				log.error("processUIEvents() interrupted", e);
			}
		}
	}

	@Override
	public void run(IMarker[] markers, IProgressMonitor parentMonitor) {
		int count = markers.length;
		Comparator<IMarker> c1 = Comparator.comparing(e -> e.getResource().toString());
		Comparator<IMarker> c2 = Comparator.comparing(e -> Integer.valueOf(-e.getAttribute("charEnd", 0)));
		Arrays.sort(markers, c1.thenComparing(c2));
		SubMonitor monitor = SubMonitor.convert(parentMonitor, count);
		int i = 1;
		for (IMarker m : markers) {
			if (parentMonitor.isCanceled()) {
				return;
			}
			monitor.subTask("fixing (" + i + "/" + count + ") in " + m.getResource().getName() + " Line "
					+ Util.getProperty(IMarker.LINE_NUMBER, m));
			processUIEvents(0);
			run(m);
			monitor.worked(1);
			i++;
		}
	}

}