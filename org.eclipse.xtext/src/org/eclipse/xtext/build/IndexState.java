/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.build;

import java.util.Collections;

import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IndexState {
	private final ResourceDescriptionsData resourceDescriptions;

	private final Source2GeneratedMapping fileMappings;

	public IndexState() {
		this(new ResourceDescriptionsData(Collections.emptySet()), new Source2GeneratedMapping());
	}

	public IndexState(ResourceDescriptionsData resourceDescriptions, Source2GeneratedMapping fileMappings) {
		this.resourceDescriptions = resourceDescriptions;
		this.fileMappings = fileMappings;
	}

	public ResourceDescriptionsData getResourceDescriptions() {
		return resourceDescriptions;
	}

	public Source2GeneratedMapping getFileMappings() {
		return fileMappings;
	}
}
