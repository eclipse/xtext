package org.eclipse.emf.index.dao.memory;

import org.eclipse.emf.index.EClassDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EPackageDescriptor;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.dao.AbstractEObjectDAOTest;
import org.eclipse.emf.index.impl.memory.EClassDAOImpl;
import org.eclipse.emf.index.impl.memory.EObjectDAOImpl;
import org.eclipse.emf.index.impl.memory.EPackageDAOImpl;
import org.eclipse.emf.index.impl.memory.ResourceDAOImpl;

public class EObjectDAOTest extends AbstractEObjectDAOTest {

	@Override
	protected EPackageDescriptor.DAO createEPackageDAO() {
		return new EPackageDAOImpl(indexStore);
	}

	@Override
	protected EClassDescriptor.DAO createEClassDAO() {
		return new EClassDAOImpl(indexStore);
	}

	@Override
	protected ResourceDescriptor.DAO createResourceDAO() {
		return new ResourceDAOImpl(indexStore);
	}

	@Override
	protected EObjectDescriptor.DAO createEObjectDAO() {
		return new EObjectDAOImpl(indexStore);
	}

}
