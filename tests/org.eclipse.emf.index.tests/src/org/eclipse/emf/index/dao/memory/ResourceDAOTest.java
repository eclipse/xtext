package org.eclipse.emf.index.dao.memory;

import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.dao.AbstractResourceDAOTest;
import org.eclipse.emf.index.impl.memory.ResourceDAOImpl;

public class ResourceDAOTest extends AbstractResourceDAOTest {

	@Override
	protected ResourceDescriptor.DAO createResourceDAO() {
		return new ResourceDAOImpl(indexStore);
	}

}
