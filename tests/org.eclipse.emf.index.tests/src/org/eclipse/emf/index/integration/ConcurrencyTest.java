package org.eclipse.emf.index.integration;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ecore.EcoreIndexFeeder;
import org.eclipse.emf.index.guice.AbstractEmfIndexTest;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.emf.index.resource.impl.ResourceIndexerImpl;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ConcurrencyTest extends AbstractEmfIndexTest {

	private static final String TEST_MODEL = "org/eclipse/emf/index/integration/domainmodel.ecore";

	@Inject
	protected IndexStore index;

	@Inject
	protected EcoreIndexFeeder ecoreFeeder;

	@Inject
	protected Provider<IndexFeeder> feederProvider;

	private ResourceIndexerImpl resourceIndexer = new ResourceIndexerImpl();

	protected IndexFeeder feeder;

	private URI uri;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		feeder = feederProvider.get();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
	}

	private Resource indexExampleResource() throws IOException {
		uri = URI.createFileURI("src/" + TEST_MODEL);
		XMIResourceImpl resource = new XMIResourceImpl();
		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(TEST_MODEL);
		resource.load(resourceAsStream, null);
		resource.setURI(uri);
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResources().add(resource);
		resourceIndexer.resourceChanged(uri, feeder);
		return resource;
	}

	public void testConcurrency() throws IOException {
		ecoreFeeder.index(EcorePackage.eINSTANCE, true);
		final Resource resource = indexExampleResource();

		Thread indexerThread = new Thread() {
			public void run() {
				EList<EObject> contents = new BasicEList<EObject>(resource.getContents());
				while (true) {
					resource.getContents().clear();
					resourceIndexer.resourceChanged(resource, feeder);
					resource.getContents().addAll(contents);
					resourceIndexer.resourceChanged(resource, feeder);
				}
			};
		};
		indexerThread.start();

		EReferenceDescriptor.Query crossRefQuery = index.eReferenceDAO().createQuery();
		crossRefQuery.targetFragment("//Feature");

		for (int i = 0; i < 1000; i++) {
			crossRefQuery.executeListResult();
		}
	}

}
