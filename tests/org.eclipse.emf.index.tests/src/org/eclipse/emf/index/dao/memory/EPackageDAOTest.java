package org.eclipse.emf.index.dao.memory;

import org.eclipse.emf.index.EPackageDescriptor.DAO;
import org.eclipse.emf.index.dao.AbstractEPackageDAOTest;
import org.eclipse.emf.index.impl.memory.EPackageDAOImpl;


public class EPackageDAOTest extends AbstractEPackageDAOTest {

	@Override
	protected DAO createEPackageDAO() {
		return new EPackageDAOImpl(indexStore);
	}
	
}
