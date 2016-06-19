/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtext.resource.uriHell;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.testing.GlobalRegistries.GlobalStateMemento;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Cedric Brun - Initial contribution and API
 * 
 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=443946
 */
public class SrcSegmentsInUrisAreNotRemovedTests {

	private ResourceSet set = new XtextResourceSet();

	private XMIResource bRes;

	private XMIResource aRes;

	private String aResContent = "<?xml version=\"1.0\" encoding=\"ASCII\"?>\n"
			+ "<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"a\">\n"
			+ "  <eClassifiers xsi:type=\"ecore:EClass\" name=\"A\"/>\n"
			+ "</ecore:EPackage>";

	private String bResContent = "<?xml version=\"1.0\" encoding=\"ASCII\"?>\n"
			+ "<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"b\">\n"
			+ "  <eClassifiers xsi:type=\"ecore:EClass\" name=\"B\">\n"
			+ "    <eSuperTypes href=\"../../src/some/package/a.ecore#//A\"/>"
			+ "  <eOperations name=\"op\">\n"
			+ "      <eParameters name=\"param\" eType=\"ecore:EClass ../../src/some/package/a.ecore#//A\"/>\n"
			+ "    </eOperations>\n"
			+ "    <eStructuralFeatures xsi:type=\"ecore:EReference\" name=\"toA\">\n"
			+ "      <eType xsi:type=\"ecore:EClass\" href=\"../../src/some/package/a.ecore#//A\"/>\n"
			+ "    </eStructuralFeatures>\n" + "  </eClassifiers>\n"
			+ "</ecore:EPackage>";

	private GlobalStateMemento globalStateMemento;

	@After
	public void tearDown() {
		globalStateMemento.restoreGlobalState();
	}
	
	@Before
	public void setUp() throws Exception {
		globalStateMemento = GlobalRegistries.makeCopyOfGlobalState();
		EPackage.Registry.INSTANCE.put(XMLTypePackage.eNS_URI, XMLTypePackage.eINSTANCE);
		EcoreResourceFactoryImpl resFactory = new EcoreResourceFactoryImpl();
		set.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("ecore", resFactory);

		aRes = (XMIResource) set.createResource(URI.createPlatformResourceURI(
				"/myProject/main/src/some/package/a.ecore", true));
		InputStream stream = new ByteArrayInputStream(
				aResContent.getBytes("US-ASCII"));
		aRes.load(stream, set.getLoadOptions());
		stream.close();

		bRes = (XMIResource) set.createResource(URI.createPlatformResourceURI(
				"/myProject/model/b.ecore", true));

		stream = new ByteArrayInputStream(
				bResContent.getBytes("US-ASCII"));
		bRes.load(stream, set.getLoadOptions());
		stream.close();

	}

	@Test
	public void testSerializationBreakURIs() throws IOException {

		StringWriter writer = new StringWriter();
		bRes.save(writer, Collections.EMPTY_MAP);
		writer.flush();
		String fileContent = writer.toString();

		assertTrue(
				"We should have a src/ in the serialization as we are refering to a.ecore which is in a src folder.",
				fileContent.indexOf("src") > -1);

	}

}
