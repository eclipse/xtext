/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.quickfix;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.WorkbenchMarkerResolutionAdapter;

/**
 * Creates new WorkbenchMarkerResolutionAdapter
 * 
 * @author dhuebner - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public class WorkbenchMarkerResolutionAdapterFactory {
  @Inject
  private Provider<WorkbenchMarkerResolutionAdapter> provider;
  
  public IMarkerResolution create(final IMarker marker, final IssueResolution resolution) {
    final WorkbenchMarkerResolutionAdapter resolutionFix = this.provider.get();
    resolutionFix.setPrimaryResolution(resolution);
    resolutionFix.setPrimaryMarker(marker);
    return resolutionFix;
  }
}
