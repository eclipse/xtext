/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.io.File;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl;
import org.eclipse.xtext.builder.builderState.impl.ReferenceDescriptionImpl;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.EmfStructureComparator;

import com.google.common.collect.Lists;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractEMFBasedPersisterTest extends TestCase {

	protected EMFBasedPersister persister;
	private File tempFile;
	private List<IResourceDescription> descriptions;

	@Override
	protected void setUp() throws Exception {
		tempFile = File.createTempFile("foo", "bar");
		SharedStateModule module = new SharedStateModule();
		Module m = Modules.override(module).with(new AbstractModule() {
			@Override
			protected void configure() {
				bind(EMFBasedPersister.class).toInstance(new EMFBasedPersister() {
					@Override
					protected File getBuilderStateLocation() {
						return tempFile;
					}
				});
			}});
		persister = Guice.createInjector(m).getInstance(EMFBasedPersister.class);
		descriptions = Lists.newArrayList(
				createResourceDescription(1),
				createResourceDescription(2),
				createResourceDescription(3)
		);
	}
	
	public void testSaveAndReload() throws Exception {
		persister.save(descriptions);
		List<IResourceDescription> loaded = Lists.newArrayList(persister.load());
		checkEquals(loaded);
	}
	
	// this test will fail for binary resources ... :-(
	public void testSaveAndReloadTwice() throws Exception {
		persister.save(descriptions);
		List<IResourceDescription> loaded = Lists.newArrayList(persister.load());
		tempFile.delete();
		persister.save(loaded);
		loaded = Lists.newArrayList(persister.load());
		checkEquals(loaded);
	}

	private void checkEquals(List<IResourceDescription> loaded) {
		assertEquals(descriptions.size(), loaded.size());
		EmfStructureComparator comparator = new EmfStructureComparator();
		for(int i = 0; i < descriptions.size(); i++) {
			comparator.assertSameStructure((EObject)descriptions.get(i), (EObject) loaded.get(i));
		}
	}
	
	public IResourceDescription createResourceDescription(int idx) {
		ResourceDescriptionImpl result = (ResourceDescriptionImpl) BuilderStateFactory.eINSTANCE.createResourceDescription();
		result.setURI(URI.createPlatformResourceURI(idx + ".uri", true));
		result.getExportedObjects().add(createObjectDescription(1));
		result.getExportedObjects().add(createObjectDescription(2));
		result.getExportedObjects().add(createObjectDescription(3));
		result.getReferenceDescriptions().add(createReferenceDescription(1));
		result.getReferenceDescriptions().add(createReferenceDescription(2));
		result.getReferenceDescriptions().add(createReferenceDescription(3));
		result.getImportedNames().add("name1");
		result.getImportedNames().add("name2");
		result.getImportedNames().add("name3");
		return result;
	}
	
	public IEObjectDescription createObjectDescription(int idx) {
		EObjectDescriptionImpl result = (EObjectDescriptionImpl) BuilderStateFactory.eINSTANCE.createEObjectDescription();
		result.setEClass(BuilderStatePackage.eINSTANCE.getEObjectDescription());
		result.setFragment("newFragment" + idx);
		result.setName("name" + idx);
		return result;
	}
	
	public IReferenceDescription createReferenceDescription(int idx) {
		ReferenceDescriptionImpl result = (ReferenceDescriptionImpl) BuilderStateFactory.eINSTANCE.createReferenceDescription();
		result.setIndexInList(idx);
		result.setReference(BuilderStatePackage.eINSTANCE.getEObjectDescription_ResourceDescriptor());
		result.setSourceEObjectUri(URI.createFileURI(idx + "source.uri"));
		result.setSourceEObjectUri(URI.createFileURI(idx + "target.uri"));
		return result;
	}
	
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=321536
	 */
	public void testBug321536() throws Exception {
		ResourceDescriptionImpl result = (ResourceDescriptionImpl) BuilderStateFactory.eINSTANCE.createResourceDescription();
		URI uri = URI.createURI("copy of model.uri",true);
		result.setURI(uri);
		persister.save(Collections.singleton((IResourceDescription)result));
		Iterable<IResourceDescription> load = persister.load();
		URI uriAfterSave = load.iterator().next().getURI();
		assertEquals(uri,uriAfterSave);
	}
}
