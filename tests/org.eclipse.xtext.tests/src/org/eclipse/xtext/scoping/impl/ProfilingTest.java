/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.index.IndexTestLanguageStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.util.StopWatch;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ProfilingTest extends AbstractXtextTests {
	
	public void testSimple() throws Exception {
		with(new IndexTestLanguageStandaloneSetup());
		XtextResourceSet rs = get(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		XtextResource resource = (XtextResource) getResourceFactory().createResource(URI.createURI("mytestmodel."+getCurrentFileExtension()));
		rs.getResources().add(resource);
		StopWatch watch = new StopWatch();
		resource.load(new StringInputStream(generateFile(10)), null);
//		resource.load(new StringInputStream(generateFile(1000)), null);
		watch.resetAndLog("loading");
		EcoreUtil.resolveAll(resource);
		watch.resetAndLog("linking");
		assertTrue(resource.getErrors().size()+" errors ", resource.getErrors().isEmpty());
		Manager manager = get(IResourceDescription.Manager.class);
		IResourceDescription iResourceDescription = manager.getResourceDescription(resource);
		Sets.newHashSet(iResourceDescription.getReferenceDescriptions());
		watch.resetAndLog("resourcedescriptions");
		System.out.println(Sets.newHashSet(resource.getAllContents()).size());
	}

	private String generateFile(int numberOfElements) {
		StringBuilder sb = new StringBuilder();
		sb.append("foo {\n");
		for (int i = 0;i< numberOfElements ;i++) {
			sb.append("  entity Name"+i+"{\n");
			sb.append("    Name"+i+" foo\n");
			sb.append("    foo.Name"+i+" bar\n");
			sb.append("  }\n");
		}
		sb.append("}\n");
		return sb.toString();
	}
}
