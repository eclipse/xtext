package org.eclipse.emf.index.dao;

import org.eclipse.emf.index.EClassDescriptor;
import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EPackageDescriptor;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.ResourceDescriptor;


public abstract class AbstractECrossReferenceDAOTest extends AbstractDAOTest {

	/**
	 * To test a specific implementation, override this method.
	 */
	@Override
	protected abstract EPackageDescriptor.DAO createEPackageDAO();

	/**
	 * To test a specific implementation, override this method.
	 */
	@Override
	protected abstract EClassDescriptor.DAO createEClassDAO();

	/**
	 * To test a specific implementation, override this method.
	 */
	@Override
	protected abstract ResourceDescriptor.DAO createResourceDAO();
	
	/**
	 * To test a specific implementation, override this method.
	 */
	@Override
	protected abstract EObjectDescriptor.DAO createEObjectDAO();
	
	/**
	 * To test a specific implementation, override this method.
	 */
	@Override
	protected abstract ECrossReferenceDescriptor.DAO createECrossReferenceDAO();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		indexStore.resourceDAO().store(resourceDescriptor);
		indexStore.ePackageDAO().store(ePackageDescriptor);
		indexStore.eClassDAO().store(eClassDescriptor);
		indexStore.eObjectDAO().store(eObjectDescriptor);
	}

	public void testGenericQueries() throws Exception {
		ECrossReferenceDescriptor.Query query = indexStore.eCrossReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQuery().source(eObjectDescriptor);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);
		
		query.source(eObjectDescriptor).referenceName(ECROSS_REFERENCE_NAME);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.source().name(EOBJECT_NAME);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.source().fragment(EOBJECT_FRAGMENT);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.source().eClass(eClassDescriptor);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.source().eClass().name(ECLASS_NAME);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.source().eClass().ePackage(ePackageDescriptor);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);
		
		query = indexStore.eCrossReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.source().eClass().ePackage().nsURI(EPACKAGE_NS_URI);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);
		
		query = indexStore.eCrossReferenceDAO().createQuery().target(eObjectDescriptor);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);
		
		query.target(eObjectDescriptor).referenceName(ECROSS_REFERENCE_NAME);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.target().name(EOBJECT_NAME);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.target().fragment(EOBJECT_FRAGMENT);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.target().eClass(eClassDescriptor);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.target().eClass().name(ECLASS_NAME);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);

		query = indexStore.eCrossReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.target().eClass().ePackage(ePackageDescriptor);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);
		
		query = indexStore.eCrossReferenceDAO().createQuery().referenceName(ECROSS_REFERENCE_NAME);
		query.target().eClass().ePackage().nsURI(EPACKAGE_NS_URI);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);
		
	}

	public void testNonGenericQueries() {
		IGenericQuery<ECrossReferenceDescriptor> query = indexStore.eCrossReferenceDAO().createQueryCrossReference(eObjectDescriptor, eReference);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);
		
		query = indexStore.eCrossReferenceDAO().createQueryCrossReferencesFrom(eObjectDescriptor);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);
		
		query = indexStore.eCrossReferenceDAO().createQueryCrossReferencesTo(eObjectDescriptor);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);
		
		query = indexStore.eCrossReferenceDAO().createQueryCrossReferencesTo(eObject);
		genericQuerySingleResultTest(indexStore.eCrossReferenceDAO(), eCrossReferenceDescriptor, query);
	}

}
