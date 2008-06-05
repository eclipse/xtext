package org.eclipse.xtext.generator.resource;

import java.io.File;
import java.io.FileWriter;
import java.net.MalformedURLException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.testlanguages.TestLanguageStandaloneSetup;
import org.eclipse.xtext.xtext2ecore.EcoreModelComparator;

public class ResourceTest extends TestCase {

	public void testResource() throws Exception {
		new Object(); // workaround for Java bug on MacOSX
		org.eclipse.xtext.testlanguages.TestLanguageStandaloneSetup.doSetup();
		IResourceFactory resourceFactory = ServiceRegistry.getService(TestLanguageStandaloneSetup.getLanguageDescriptor(), IResourceFactory.class);

		File modelFile = File.createTempFile("testfile", "." + resourceFactory.getModelFileExtensions()[0]);
		modelFile.deleteOnExit();
		FileWriter fileWriter = new FileWriter(modelFile);
		String model = "reducible 'x' choice optional y choice z reducible 'x' 'y'";
		fileWriter.append(model);
		fileWriter.close();
		
		ResourceSet rs0 = new ResourceSetImpl();
		Resource resource = loadAsResource(modelFile, rs0);
		File savedFile = File.createTempFile("testfile_save", "." + resourceFactory.getModelFileExtensions()[0]);
		resource.setURI(URI.createURI(savedFile.toURL().toString()));
		resource.setModified(true);
		resource.save(null);
		
		ResourceSet rs1 = new ResourceSetImpl();
		Resource resource1 = loadAsResource(savedFile, rs1);

		EcoreModelComparator ecoreModelComparator = new EcoreModelComparator();
		assertFalse(ecoreModelComparator.modelsDiffer(resource, resource1));
	}

	private Resource loadAsResource(File modelFile, ResourceSet rs0) throws MalformedURLException {
		Resource resource = rs0.getResource(URI.createURI(modelFile.toURL().toString()), true);
		assertNotNull(resource);
		assertFalse(resource.getContents().isEmpty());
		EObject rootElement = resource.getContents().get(0);
		assertNotNull(rootElement);
		// TODO: perform some checks
		return resource;
	}
}
