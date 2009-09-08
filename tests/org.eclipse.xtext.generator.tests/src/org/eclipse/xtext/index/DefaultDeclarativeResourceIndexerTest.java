/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index;

import java.util.Iterator;
import java.util.List;

import org.easymock.EasyMock;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.Index;
import org.eclipse.emf.emfindex.ResourceDescriptor;
import org.eclipse.emf.emfindex.query.QueryCommand;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.query.QueryResult;
import org.eclipse.emf.emfindex.query.ResourceDescriptorQuery;
import org.eclipse.emf.emfindex.query.ResourceQueryExecutorStrategyImpl;
import org.eclipse.xtext.index.indexTestLanguage.Namespace;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class DefaultDeclarativeResourceIndexerTest extends AbstractIndexBasedTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new IndexTestLanguageStandaloneSetup());
	}

	public void testSimple() throws Exception {
		final Resource r = getResource(new StringInputStream(
				  "foo.bar { " 
				+ "  entity Person {  " 
				+ "    String name "
				+ "  } " 
				+ "  datatype String " 
				+ "}"));

		indexResource(r);

		index.executeQueryCommand(new QueryCommand<Object>() {

			public Object execute(QueryExecutor queryExecutor, Index index) {
				ResourceDescriptorQuery query = new ResourceDescriptorQuery();
				query.setURI(normalizedURI(r));
				QueryResult<ResourceDescriptor> result = queryExecutor.execute(query, index);
				ResourceDescriptor resourceDescriptor = result.iterator().next();
				Iterator<EObjectDescriptor> descriptors = resourceDescriptor.getEObjectDescriptors().iterator();

				EObjectDescriptor namespace = descriptors.next();
				assertEquals("foo.bar", namespace.getName());

				descriptors = namespace.getEObjectDescriptors().iterator();

				EObjectDescriptor person = descriptors.next();
				assertEquals("foo.bar.Person", person.getName());
				assertEquals("foo.bar.Person.name", person.getEObjectDescriptors().get(0).getName());
				assertEquals("foo.bar.String", descriptors.next().getName());

				return null;
			}
		});

	}

	public void testSurpressIndexingForNamespaces() throws Exception {
		indexer = new DefaultDeclarativeResourceIndexer() {
			protected boolean isIndex(Namespace ns) {
				return false;
			}
		};

		final Resource r = getResource(new StringInputStream(
				  "foo.bar { " 
				+ "  entity Person {  " 
				+ "    String name "
				+ "  } " 
				+ "  datatype String " 
				+ "}"));

		indexResource(r);

		index.executeQueryCommand(new QueryCommand<Object>() {

			public Object execute(QueryExecutor queryExecutor, Index index) {
				ResourceDescriptorQuery query = new ResourceDescriptorQuery();
				query.setURI(normalizedURI(r));
				QueryResult<ResourceDescriptor> result = queryExecutor.execute(query, index);
				ResourceDescriptor resourceDescriptor = result.iterator().next();
				Iterator<EObjectDescriptor> descriptors = resourceDescriptor.getEObjectDescriptors().iterator();

				//Indexing of Namespace is omitted by indexer (see above) 
//				EObjectDescriptor namespace = descriptors.next();
//				assertEquals("foo.bar", namespace.getName());
//
//				descriptors = namespace.getEObjectDescriptors().iterator();

				EObjectDescriptor person = descriptors.next();
				assertEquals("foo.bar.Person", person.getName());
				assertEquals("foo.bar.Person.name", person.getEObjectDescriptors().get(0).getName());
				assertEquals("foo.bar.String", descriptors.next().getName());

				return null;
			}
		});
	}
}
