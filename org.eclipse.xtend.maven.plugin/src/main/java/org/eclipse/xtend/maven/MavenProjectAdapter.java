/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.maven;

import java.util.Iterator;

import org.apache.maven.project.MavenProject;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * 
 * @author Moritz Eysholdt
 */
public class MavenProjectAdapter extends AdapterImpl {
	public static MavenProject get(ResourceSet rs) {
		for (Adapter a : rs.eAdapters())
			if (a instanceof MavenProjectAdapter)
				return ((MavenProjectAdapter) a).project;
		throw new RuntimeException("The Maven Project is not registered in the ResourceSet");
	}

	public static void install(ResourceSet rs, MavenProject project) {
		Iterator<Adapter> i = rs.eAdapters().iterator();
		while (i.hasNext())
			if (i.next() instanceof MavenProjectAdapter)
				i.remove();
		rs.eAdapters().add(new MavenProjectAdapter(project));
	}

	private MavenProject project;

	private MavenProjectAdapter(MavenProject project) {
		super();
		this.project = project;
	}
}
