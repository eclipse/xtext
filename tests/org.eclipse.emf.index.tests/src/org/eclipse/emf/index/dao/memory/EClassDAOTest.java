package org.eclipse.emf.index.dao.memory;

import org.eclipse.emf.index.EClassDescriptor;
import org.eclipse.emf.index.EPackageDescriptor;
import org.eclipse.emf.index.dao.AbstractEClassDAOTest;
import org.eclipse.emf.index.impl.memory.EClassDAOImpl;
import org.eclipse.emf.index.impl.memory.EPackageDAOImpl;

public class EClassDAOTest extends AbstractEClassDAOTest {

	@Override
	protected EPackageDescriptor.DAO createEPackageDAO() {
		return new EPackageDAOImpl(indexStore);
	}

	@Override
	protected EClassDescriptor.DAO createEClassDAO() {
		return new EClassDAOImpl(indexStore);
	}
	
}
