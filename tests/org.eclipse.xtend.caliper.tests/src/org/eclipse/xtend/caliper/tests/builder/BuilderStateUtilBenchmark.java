/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.builder;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.builderState.BuilderStateFactory;
import org.eclipse.xtext.builder.builderState.BuilderStatePackage;
import org.eclipse.xtext.builder.builderState.BuilderStateUtil;
import org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

/**
 * BuilderStateUtil has a shortcut for input data that is already
 * represented as an EObject, thus BuilderStateUtil's entry method is
 * duplicated here.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BuilderStateUtilBenchmark extends SimpleBenchmark {

	public enum Impl {
		Old {
			@Override
			IResourceDescription create(IResourceDescription desc) {
				ResourceDescriptionImpl result = (ResourceDescriptionImpl) BuilderStateFactory.eINSTANCE.createResourceDescription();
				result.setURI(desc.getURI());
				for (IEObjectDescription objDesc : desc.getExportedObjects()) {
					result.getExportedObjects().add(BuilderStateUtil.create(objDesc));
				}
				Iterable<IReferenceDescription> referenceDescriptions = desc.getReferenceDescriptions();
				for (IReferenceDescription iReferenceDescription : referenceDescriptions) {
					result.getReferenceDescriptions().add(BuilderStateUtil.create(iReferenceDescription));
				}
				Iterable<QualifiedName> importedNames = desc.getImportedNames();
				for (QualifiedName importedName : importedNames) {
					result.getImportedNames().add(importedName);
				}
				return result;
			}
		},
		New {
			@Override
			IResourceDescription create(IResourceDescription desc) {
				ResourceDescriptionImpl result = (ResourceDescriptionImpl) BuilderStateFactory.eINSTANCE.createResourceDescription();
				result.setURI(desc.getURI());
				BuilderStateUtil.copyExportedObject(desc, result);
				BuilderStateUtil.copyReferenceDescriptions(desc, result);
				BuilderStateUtil.copyImportedNames(desc, result);
				return result;
			}
		};
		abstract IResourceDescription create(IResourceDescription description);
	}
	
	@Param
	Impl implementation;
	
	@Param({ "0", "10", "20", "50", "500", "5000", "10000" })
	int importedNames;
	
	@Param({ "1", "2", "5", "10" }) //, "100" })
	int objectDescriptions;
	
//	@Param({ "0" })
//	int referenceDescriptions;
	
	@Param({ "0", "2" })
	int userDataKeys;
	
	@Param({ "1", "10", "20", "200" })
	int resourceDescriptions;

	private IResourceDescription copyMe;

	@Override
	protected void setUp() throws Exception {
		ResourceDescriptionImpl resourceDescription = (ResourceDescriptionImpl) BuilderStateFactory.eINSTANCE.createResourceDescription();
		resourceDescription.setURI(URI.createURI("myURI"));
		createExportedObjects(resourceDescription);
		createImportedNames(resourceDescription);
//		createReferenceDescriptions(resourceDescription);
		copyMe = resourceDescription;
	}

	private void createExportedObjects(ResourceDescriptionImpl resourceDescription) {
		List<IEObjectDescription> list = resourceDescription.getExportedObjects();
		for(int i = 0; i < objectDescriptions; i++) {
			final int idx = i;
			EObjectDescriptionImpl objectDescription = new EObjectDescriptionImpl() {
				URI uri = URI.createURI("myURI#myFragment/" + idx);
				@Override
				public URI getEObjectURI() {
					return uri;
				}
			};
			objectDescription.setEClass(BuilderStatePackage.Literals.EOBJECT_DESCRIPTION);
			objectDescription.setName(QualifiedName.create("myFragment", String.valueOf(i)));
			createUserData(objectDescription);
			list.add(objectDescription);
		}
	}

	private void createUserData(EObjectDescriptionImpl objectDescription) {
		for(int i = 0; i < userDataKeys; i++) {
			objectDescription.getUserData().put(String.valueOf(i), String.valueOf(i));
		}
	}

	private void createImportedNames(ResourceDescriptionImpl resourceDescription) {
		List<QualifiedName> list = resourceDescription.getImportedNames();
		for(int i = 0; i < importedNames; i++) {
			list.add(QualifiedName.create("a", "b" , String.valueOf(i)));
		}
		if (list.size() != importedNames) {
			throw new IllegalStateException();
		}
	}
	
	public int timeCopyDescription(int reps) {
		int result = 0;
		for (int i = 0; i < reps * resourceDescriptions; i++) {
			if (implementation.create(copyMe).getURI() != null) {
				result += i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Runner.main(BuilderStateUtilBenchmark.class, args);
	}

}