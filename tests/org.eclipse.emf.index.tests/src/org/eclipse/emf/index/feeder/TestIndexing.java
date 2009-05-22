package org.eclipse.emf.index.feeder;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.impl.EcoreIndexFeederImpl;
import org.eclipse.emf.index.guice.AbstractEmfIndexTest;
import org.eclipse.emf.index.resource.impl.IndexFeederImpl;
import org.eclipse.emf.index.resource.impl.ResourceIndexerImpl;

import com.google.inject.Inject;

/**
 * @author Christian Mohr
 */
public class TestIndexing extends AbstractEmfIndexTest {

	@Inject
	private IndexStore index;

	ResourceIndexerImpl indexer = new ResourceIndexerImpl();
	
	private File testFile;

	public void testIndexingObjectNameFeatureNull() {

		// feed the EcorePackage only
		new EcoreIndexFeederImpl(index).index(EcorePackage.eINSTANCE, false);
		
		// create test data
		EParameter objectNameAttributeNullToIndex = EcoreFactory.eINSTANCE.createEParameter();
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createFileURI(testFile.getAbsolutePath());
		Resource r = rs.createResource(uri);
		r.getContents().add(objectNameAttributeNullToIndex);
	 
		// index test data
		IndexFeederImpl feeder = new IndexFeederImpl(index);
		indexer.resourceChanged(r, feeder);
		feeder.commit();

		// assert resource is indexed
		ResourceDescriptor rd = index.resourceDAO().createQueryResource(r).executeSingleResult();
		assertNotNull(rd);
		
		// assert object with indexed typed is indexed
		EObjectDescriptor od = index.eObjectDAO().createQueryEObjectInResource(objectNameAttributeNullToIndex, rd).executeSingleResult();
		assertNotNull(od);
		assertEquals(EcoreUtil.getURI(objectNameAttributeNullToIndex), od.getFragmentURI());
	}
	
	// TODO: fix bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=276460
	
	/*
	public void testIndexingMissingtType() {

		// create an empty index
		IndexStore index = this.createIndexStore();
		EcoreIndexFeeder ecoreFeeder = new EcoreIndexFeederImpl(index);
		ecoreFeeder.index(EcorePackage.eINSTANCE, false);
		
		// create test data
		EAnnotation objectIndexedClassToIndex = EcoreFactory.eINSTANCE.createEAnnotation();
		XMLNamespaceDocumentRoot objectNotIndexedClassToIndex = XMLNamespaceFactory.eINSTANCE.createXMLNamespaceDocumentRoot();
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createFileURI(testFile.getAbsolutePath());
		Resource r = rs.createResource(uri);
		r.getContents().add(objectNotIndexedClassToIndex);
		r.getContents().add(objectIndexedClassToIndex);
	 
		// index test data
		IndexFeeder feeder = new IndexFeederImpl(index);
		ResourceIndexer indexer = new ResourceIndexerImpl();
		indexer.resourceChanged(r, feeder);

		// assert resource is indexed
		ResourceDescriptor rd = index.resourceDAO().createQueryResource(r).executeSingleResult();
		assertNotNull(rd);
		// assert object of indexed typed is indexed
		EObjectDescriptor od1 = index.eObjectDAO().createQueryEObjectInResource(objectIndexedClassToIndex, rd).executeSingleResult();
		assertNotNull(od1);
		assertEquals(EcoreUtil.getURI(objectIndexedClassToIndex), od1.getFragmentURI());
		// assert object of not indexed type is not indexed
		EObjectDescriptor od2 = index.eObjectDAO().createQueryEObjectInResource(objectNotIndexedClassToIndex, rd).executeSingleResult();
		assertNull(od2);
	}
	 */

	
	public void setUp() throws Exception {
		super.setUp();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		testFile = File.createTempFile("indexingTest", ".xmi");
	}

	public void tearDown() throws Exception {
		super.tearDown();
		if (testFile.exists()) {
			testFile.delete();
		}
	}

}
