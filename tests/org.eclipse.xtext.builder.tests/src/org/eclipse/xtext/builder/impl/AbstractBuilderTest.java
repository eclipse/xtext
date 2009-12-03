/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.builder.impl.BuilderUtil.*;
import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Event;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractBuilderTest extends TestCase implements IResourceDescription.Event.Listener {
	public final String F_EXT = ".buildertestlanguage";
	private volatile List<Event> events = Lists.newArrayList();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		assertEquals(0, countResourcesInIndex());
		assertEquals(0, root().getProjects().length);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		cleanWorkspace();
		waitForAutoBuild();
		events.clear();
		getBuilderState().removeListener(this);
	}

	public void descriptionsChanged(Event event) {
		this.events.add(event);
	}
	
	public List<Event> getEvents() {
		return events;
	}
}
