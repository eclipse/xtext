/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index;

import org.easymock.EasyMock;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.xtext.index.indexTestLanguage.Namespace;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class DefaultDeclarativeResourceIndexerTest extends AbstractXtextTests {

	public void testSimple() throws Exception {
		with(new IndexTestLanguageStandaloneSetup());
		Resource r = getResource(new StringInputStream(
				"foo.bar { " +
				"  entity Person {  " +
				"    String name " +
				"  } " +
				"  datatype String " +
				"}"));
		TreeIterator<EObject> iterator = EcoreUtil.getAllProperContents(r, true);
		// skip the file
		iterator.next();
		
		IndexFeeder feeder = EasyMock.createMock(IndexFeeder.class);
		// start recording expected calls
		feeder.createResourceDescriptor(r, null);
		
		feeder.createEObjectDescriptor(iterator.next(), "foo.bar", "foo.bar", null);
		feeder.createEObjectDescriptor(iterator.next(), "foo.bar.Person", "foo.bar.Person", null);
		feeder.createEObjectDescriptor(iterator.next(), "foo.bar.Person.name", "foo.bar.Person.name", null);
		feeder.createEObjectDescriptor(iterator.next(), "foo.bar.String", "foo.bar.String", null);
		
		feeder.createEReferenceDescriptor((URI) EasyMock.anyObject(), EasyMock.startsWith("type"), EasyMock.eq(-1), (URI) EasyMock.anyObject());
		//end recording
		EasyMock.replay(feeder);
		
		DefaultDeclarativeResourceIndexer indexer = new DefaultDeclarativeResourceIndexer();
		indexer.resourceChanged(r, feeder);
		
		EasyMock.verify(feeder);
	}
	
	public void testSurpressIndexingForNamespaces() throws Exception {
		with(new IndexTestLanguageStandaloneSetup());
		@SuppressWarnings("unused")
		DefaultDeclarativeResourceIndexer indexer = new DefaultDeclarativeResourceIndexer() {

			protected boolean isIndex(Namespace ns) {
				return false;
			}
			
		};
		
		Resource r = getResource(new StringInputStream(
				"foo.bar { " +
				"  entity Person {  " +
				"    String name " +
				"  } " +
				"  datatype String " +
				"}"));
		TreeIterator<EObject> iterator = EcoreUtil.getAllProperContents(r, true);
		// skip the file
		iterator.next();
		
		IndexFeeder feeder = EasyMock.createMock(IndexFeeder.class);
		// start recording expected calls
		feeder.createResourceDescriptor(r, null);
		
		// skip the name space
		iterator.next();
//		feeder.createEObjectDescriptor(iterator.next(), "foo.bar", "foo.bar", null);
		feeder.createEObjectDescriptor(iterator.next(), "foo.bar.Person", "foo.bar.Person", null);
		feeder.createEObjectDescriptor(iterator.next(), "foo.bar.Person.name", "foo.bar.Person.name", null);
		feeder.createEObjectDescriptor(iterator.next(), "foo.bar.String", "foo.bar.String", null);
		
		feeder.createEReferenceDescriptor((URI) EasyMock.anyObject(), EasyMock.startsWith("type"), EasyMock.eq(-1), (URI) EasyMock.anyObject());
		//end recording
		EasyMock.replay(feeder);
		
		indexer.resourceChanged(r, feeder);
		
		EasyMock.verify(feeder);
	}
}
