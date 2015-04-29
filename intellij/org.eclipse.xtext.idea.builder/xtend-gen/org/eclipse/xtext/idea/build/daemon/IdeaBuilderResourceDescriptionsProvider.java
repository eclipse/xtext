/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.daemon;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.xtext.AbstractProjectAwareResourceDescriptionsProvider;
import org.eclipse.xtext.idea.build.daemon.IBuildSessionSingletons;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaBuilderResourceDescriptionsProvider extends AbstractProjectAwareResourceDescriptionsProvider {
  @Inject
  @Extension
  private IBuildSessionSingletons _iBuildSessionSingletons;
  
  @Override
  protected boolean isProjectLocal(final URI uri, final String encodedProjectName) {
    String _string = uri.toString();
    return _string.startsWith(encodedProjectName);
  }
  
  @Override
  protected String getProjectName(final ResourceSet resourceSet) {
    return this._iBuildSessionSingletons.getModuleBaseURL();
  }
}
