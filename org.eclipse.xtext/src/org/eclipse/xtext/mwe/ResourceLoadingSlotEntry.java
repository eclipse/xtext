/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.xtext.resource.IResourceDescriptions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceLoadingSlotEntry implements ISlotEntry {
	
	private String slot;
	
	/**
	 * the {@link WorkflowContext}'s slot to store the found {@link Resource}s in.
	 */
	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	private Set<Pattern> uris = newHashSet();
	
	/**
	 * a regular expression matching against the {@link Resource}'s URIs.
	 */
	public void addUri(String uri) {
		this.uris.add(Pattern.compile(uri));
	}

	@Override
	public void put(WorkflowContext ctx, IResourceDescriptions descriptions, ResourceSet resourceSet) {
		EList<Resource> resources = resourceSet.getResources();
		List<Resource> result = newArrayList();
		for (Resource resource : resources) {
			if (isMatch(resource))
				result.add(resource);
		}
		ctx.set(slot, result);
	}

	protected boolean isMatch(Resource resource) {
		if (uris.isEmpty())
			return true;
		for (Pattern uriPattern : uris) {
			if (uriPattern.matcher(resource.getURI().toString()).matches())
				return true;
		}
		return false;
	}

	@Override
	public void preInvoke() {
		if (slot==null)
			throw new IllegalStateException("'slot' has not been configured");
	}
	
}
