/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.findrefs;

import static org.eclipse.xtext.util.Strings.*;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.search.ui.text.Match;
import org.eclipse.search.ui.text.MatchFilter;
import org.eclipse.xtext.builder.DerivedResourceMarkers;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DerivedJavaMatchFilter extends MatchFilter {

	private static final Logger LOG = Logger.getLogger(DerivedJavaMatchFilter.class);
	
	@Inject
	private DerivedResourceMarkers derivedResourceMarkers;
	
	@Override
	public boolean filters(Match match) {
		Object element = match.getElement();
		if(element instanceof IJavaElement) {
			try {
				IResource resource = ((IJavaElement) element).getResource();
				IMarker[] markers = derivedResourceMarkers.findDerivedResourceMarkers(resource);
				if(markers.length > 0)
					return true;
			} catch (Exception e) {
				LOG.error("Error detecting derived resource for " + notNull(((IJavaElement) element).getElementName()), e);
			}
		}
		return false;
	}

	@Override
	public String getName() {
		return "Derived Java elements";
	}

	@Override
	public String getDescription() {
		return "Generated Java elements";
	}

	@Override
	public String getActionLabel() {
		return "Filter derived Java elements";
	}

	@Override
	public String getID() {
		return getClass().getCanonicalName();
	}

}
