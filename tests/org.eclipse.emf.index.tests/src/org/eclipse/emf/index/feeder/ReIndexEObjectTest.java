package org.eclipse.emf.index.feeder;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ecore.impl.EcoreIndexFeederImpl;
import org.eclipse.emf.index.guice.AbstractEmfIndexTest;
import org.eclipse.emf.index.resource.IndexFeeder;

import com.google.inject.Inject;

public class ReIndexEObjectTest extends AbstractEmfIndexTest {

	@Inject
	private IndexStore index;
	
	@Inject
	private IndexFeeder feeder;
	
	public void testReIndexEObject() throws Exception {
		new EcoreIndexFeederImpl(index).index(EcorePackage.eINSTANCE, true);
		XMIResourceImpl resource = new XMIResourceImpl(URI.createURI("example.ecore"));
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName("test");
		resource.getContents().add(ePackage);
		EClass testClass = EcoreFactory.eINSTANCE.createEClass();
		testClass.setName("Test");
		ePackage.getEClassifiers().add(testClass);
		
		feeder.createResourceDescriptor(resource, null);
		feeder.createEObjectDescriptor(testClass, "Test", "Test", null);
		feeder.commit();
		
		Iterator<EObjectDescriptor> result = index.eObjectDAO().createQueryEObjectsByType(EcorePackage.Literals.ECLASS).executeListResult().iterator();
		assertTrue(result.hasNext());
		assertEquals("Test", result.next().getName());
		assertFalse(result.hasNext());

		EDataType testDatatype = EcoreFactory.eINSTANCE.createEDataType(); 
		testDatatype.setName("Test");
		ePackage.getEClassifiers().clear();
		ePackage.getEClassifiers().add(testDatatype);
		feeder.createResourceDescriptor(resource, null);
		feeder.createEObjectDescriptor(testDatatype, "Test", "Test", null);
		feeder.commit();

		result = index.eObjectDAO().createQueryEObjectsByType(EcorePackage.Literals.ECLASS).executeListResult().iterator();
		assertFalse(result.hasNext());
		
		result = index.eObjectDAO().createQueryEObjectsByType(EcorePackage.Literals.EDATA_TYPE).executeListResult().iterator();
		assertTrue(result.hasNext());
		assertEquals("Test", result.next().getName());
		assertFalse(result.hasNext());
	}
	
	
}
