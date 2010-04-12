/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.index.IndexTestLanguageStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StopWatch;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ProfilingTest extends AbstractXtextTests {
	
	private static final int ELEMENTS = 600;
//	private static final int ELEMENTS = 6000;
	
	public void testSimple() throws Exception {
		with(new IndexTestLanguageStandaloneSetup());
		XtextResourceSet rs = get(XtextResourceSet.class);
		Resource outer = rs.createResource(URI.createURI("outer."+getCurrentFileExtension()));
		outer.load(new StringInputStream(outerFile(ELEMENTS)), null);
		Resource inner = rs.createResource(URI.createURI("inner."+getCurrentFileExtension()));
		StopWatch watch = new StopWatch();
		
		inner.load(new StringInputStream(generateFile(ELEMENTS)), null);
//		resource.load(new StringInputStream(generateFile(1000)), null);
		watch.resetAndLog("loading");
		EcoreUtil.resolveAll(inner);
		watch.resetAndLog("linking");
		
		assertTrue(inner.getErrors().size()+" errors ", inner.getErrors().isEmpty());
		Manager manager = get(IResourceDescription.Manager.class);
//		Yourkit.startTracing();
		IResourceDescription iResourceDescription = manager.getResourceDescription(inner);
		Sets.newHashSet(iResourceDescription.getReferenceDescriptions());
//		Yourkit.stopCpuProfiling();
		watch.resetAndLog("resourcedescriptions");
		System.out.println(Sets.newHashSet(inner.getAllContents()).size());
	}

	private String generateFile(int numberOfElements) {
		StringBuilder sb = new StringBuilder();
		sb.append("foo {\n");
		for (int i = 0;i< numberOfElements ;i++) {
			sb.append("  entity Name"+i+"{\n");
			sb.append("    Name"+i+" foo\n");
			sb.append("    foo.Name"+i+" bar\n");
			sb.append("    bar.Name"+i+" baz\n");
			sb.append("  }\n");
		}
		sb.append("}\n");
		return sb.toString();
	}
	private String outerFile(int numberOfElements) {
		StringBuilder sb = new StringBuilder();
		sb.append("bar {\n");
		for (int i = 0;i< numberOfElements ;i++) {
			sb.append("  entity Name"+i+"{}\n");
		}
		sb.append("}\n");
		return sb.toString();
	}
}
