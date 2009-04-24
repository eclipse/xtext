package org.eclipse.emf.index;

import java.io.File;
import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.index.ecore.EcoreIndexFeeder;
import org.eclipse.emf.index.ecore.impl.EcoreIndexFeederImpl;
import org.eclipse.emf.index.impl.memory.InMemoryIndex;
import org.eclipse.emf.index.resource.impl.IndexFeederImpl;

public class TestResourceUnloading extends TestCase {

	private	File	testFile;
	
	public void testResourceUnloading() throws Exception {
		// 1. create test data
		ResourceSet	rs	=	new ResourceSetImpl();
		
		URI uri = URI.createFileURI( testFile.getAbsolutePath() );
		Resource r	=	rs.createResource( uri);
		
		EClass	c1	=	EcoreFactory.eINSTANCE.createEClass();
		c1.setName( "class1" );
		r.getContents().add( c1 );
		
		// 2. persist the resource
		r.save(null);
		r = null;
		
		InMemoryIndex index = new InMemoryIndex();
		
		EcoreIndexFeeder indexFeeder = new EcoreIndexFeederImpl(index);
		indexFeeder.index(EcorePackage.eINSTANCE, true);

		IndexFeederImpl feeder = new IndexFeederImpl(index);
		
		feeder.begin();
		
		// 3. create a new resource set
		rs	=	new ResourceSetImpl();
		r = rs.getResource(uri, true);

		feeder.createResourceDescriptor(r, null);
		
		for (Iterator<EObject> i = EcoreUtil.getAllProperContents(r, false); i.hasNext();) {
			EObject element = i.next();
			feeder.createEObjectDescriptor(element, this.getEObjectName(element), this.getEObjectDisplayName(element), null);
			
			for (EReference eReference : element.eClass().getEAllReferences()) {
				if (this.isIndexReference(eReference, element)) {
					feeder.createECrossReferenceDescriptor(element, eReference);
				}
			}
		}

		// 4. unload resource set. this is where the NPE happened
		r.unload();
		
		feeder.commit();

		// 5. assert we indexed what was intended
		EObjectDescriptor desc = index.eObjectDAO().createQueryEObjectsByType(EcorePackage.eINSTANCE.getEClass()).executeSingleResult();
		
		assertNotNull("Didn't return the object descriptor.", desc);
		assertEquals(EcoreUtil.getURI(c1),desc.getFragmentURI());
	}
	
	
	private boolean isIndexReference(EReference eReference, EObject element) {

		return element.eIsSet(eReference);
	}

	protected String getEObjectName(EObject eObject) {

		return ((EClass)eObject).getName();
	}

	protected String getEObjectDisplayName(EObject eObject) {

		String displayName = this.getEObjectName(eObject);
		if (displayName == null) {
			displayName = eObject.eResource().getURIFragment(eObject);
		}
		return displayName;
	}

	public void setUp() throws Exception {
		testFile	=	File.createTempFile("resourceUnloadingTest", "xmi");
	}
	
	public void tearDown() {
		if ( testFile.exists()) {
			testFile.delete();
		}
	}

}
