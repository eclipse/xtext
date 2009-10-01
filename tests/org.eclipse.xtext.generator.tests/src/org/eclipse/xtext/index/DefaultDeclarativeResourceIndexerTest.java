/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index;

import org.eclipse.xtext.scoping.impl.AbstractIndexBasedTest;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class DefaultDeclarativeResourceIndexerTest extends AbstractIndexBasedTest {

//	@Override
//	public void setUp() throws Exception {
//		super.setUp();
//		with(new IndexTestLanguageStandaloneSetup());
//	}
//
//	public void testSimple() throws Exception {
//		final Resource r = getResource(new StringInputStream(
//				  "foo.bar { " 
//				+ "  entity Person {  " 
//				+ "    String name "
//				+ "  } " 
//				+ "  datatype String " 
//				+ "}"));
//
//		indexResource(r);
//
//		index.executeQueryCommand(new QueryCommand<Object>() {
//
//			public Object execute(QueryExecutor queryExecutor) {
//				ResourceDescriptorQuery query = new ResourceDescriptorQuery();
//				query.setURI(normalizedURI(r));
//				QueryResult<ResourceDescriptor> result = queryExecutor.execute(query);
//				ResourceDescriptor resourceDescriptor = result.iterator().next();
//				Iterator<EObjectDescriptor> descriptors = resourceDescriptor.getEObjectDescriptors().iterator();
//
//				EObjectDescriptor namespace = descriptors.next();
//				assertEquals("foo.bar", namespace.getName());
//
////				descriptors = namespace.getEObjectDescriptors().iterator();
//
//				EObjectDescriptor person = descriptors.next();
//				assertEquals("foo.bar.Person", person.getName());
//				assertEquals("foo.bar.Person.name", descriptors.next().getName());
//				assertEquals("foo.bar.String", descriptors.next().getName());
//
//				return null;
//			}
//		});
//
//	}
//
//	public void testSurpressIndexingForNamespaces() throws Exception {
//		indexer = new DefaultDeclarativeResourceIndexer() {
//			@SuppressWarnings("unused")
//			protected boolean isIndex(Namespace ns) {
//				return false;
//			}
//		};
//
//		final Resource r = getResource(new StringInputStream(
//				  "foo.bar { " 
//				+ "  entity Person {  " 
//				+ "    String name "
//				+ "  } " 
//				+ "  datatype String " 
//				+ "}"));
//
//		indexResource(r);
//
//		index.executeQueryCommand(new QueryCommand<Object>() {
//
//			public Object execute(QueryExecutor queryExecutor) {
//				ResourceDescriptorQuery query = new ResourceDescriptorQuery();
//				query.setURI(normalizedURI(r));
//				QueryResult<ResourceDescriptor> result = queryExecutor.execute(query);
//				ResourceDescriptor resourceDescriptor = result.iterator().next();
//				Iterator<EObjectDescriptor> descriptors = resourceDescriptor.getEObjectDescriptors().iterator();
//
//				//Indexing of Namespace is omitted by indexer (see above) 
////				EObjectDescriptor namespace = descriptors.next();
////				assertEquals("foo.bar", namespace.getName());
////
////				descriptors = namespace.getEObjectDescriptors().iterator();
//
//				EObjectDescriptor person = descriptors.next();
//				assertEquals("foo.bar.Person", person.getName());
//				assertEquals("foo.bar.Person.name", descriptors.next().getName());
//				assertEquals("foo.bar.String", descriptors.next().getName());
//
//				return null;
//			}
//		});
//	}
	
	public void testDummy() {
		assertTrue(true);
	}
}
