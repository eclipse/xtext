package org.eclipse.emf.index.dao;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.ResourceDescriptor;

public abstract class AbstractResourceDAOTest extends AbstractDAOTest {

	/**
	 * To test a specific implementation, override this method.
	 */
	@Override
	protected abstract ResourceDescriptor.DAO createResourceDAO();

	public void testGenericQueries() throws Exception {
		ResourceDescriptor.Query query = indexStore.resourceDAO().createQuery().uri(RESOURCE_URI);
		genericQuerySingleResultTest(indexStore.resourceDAO(), resourceDescriptor, query);
	}

	public void testNonGenericQueries() {
		IGenericQuery<ResourceDescriptor> query = indexStore.resourceDAO().createQueryResource(resource);
		genericQuerySingleResultTest(indexStore.resourceDAO(), resourceDescriptor, query);

		indexStore.resourceDAO().store(resourceDescriptor);
		
		Resource resource = new ResourceImpl(URI.createURI("wrong"));
		query = indexStore.resourceDAO().createQueryResource(resource);
		assertEmptyResult(query);
	}

}
