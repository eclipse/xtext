/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.emfindex.Index;
import org.eclipse.emf.emfindex.MemoryIndexImpl;
import org.eclipse.emf.emfindex.query.EObjectQueryExecutorStrategyImpl;
import org.eclipse.emf.emfindex.query.EReferenceQueryExecutorStrategyImpl;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.query.QueryExecutorImpl;
import org.eclipse.emf.emfindex.query.ResourceQueryExecutorStrategyImpl;
import org.eclipse.emf.emfindex.store.IndexUpdater;
import org.eclipse.emf.emfindex.store.IndexUpdaterImpl;
import org.eclipse.emf.emfindex.store.UpdateCommand;
import org.eclipse.xtext.index.DefaultDeclarativeResourceIndexer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.impl.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractIndexBasedTest extends AbstractGeneratorTest {

	protected MemoryIndexImpl index;
	protected DefaultDeclarativeResourceIndexer indexer;
	protected QueryExecutorImpl queryExecutor;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		index = new MemoryIndexImpl();
		index.setIndexUpdater(new IndexUpdaterImpl(index));
		queryExecutor = new QueryExecutorImpl();
		index.setQueryExecutor(queryExecutor);
		queryExecutor.addQueryExecutorStrategy(new EObjectQueryExecutorStrategyImpl(), 0);
		queryExecutor.addQueryExecutorStrategy(new EReferenceQueryExecutorStrategyImpl(), 0);
		queryExecutor.addQueryExecutorStrategy(new ResourceQueryExecutorStrategyImpl(), 0);
		
		indexer = new DefaultDeclarativeResourceIndexer();
		DefaultDeclarativeQualifiedNameProvider nameProvider = new DefaultDeclarativeQualifiedNameProvider();
		indexer.setNameProvider(nameProvider);
	}

	protected void index(String source, String fileName) throws Exception {
		final XtextResource resource = getResource(new StringInputStream(source), URI.createURI(fileName));
		indexResource(resource);
	}

	protected void indexResource(final Resource resource) {
		index.executeUpdateCommand(new UpdateCommand<Object>() {

			public Object execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor, Index indexStore) {
				indexer.resourceChanged(resource, indexUpdater);
				return null;
			}
		});
	}
	
	protected URI normalizedURI(Resource resource) {
		URIConverter uriConverter = resource.getResourceSet().getURIConverter();
		if (uriConverter==null)
			uriConverter = URIConverter.INSTANCE;
		return uriConverter.normalize(resource.getURI());
	}
}
