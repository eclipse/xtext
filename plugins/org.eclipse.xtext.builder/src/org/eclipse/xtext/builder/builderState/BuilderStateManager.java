/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.util.concurrent.IStateAccess;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class BuilderStateManager extends IStateAccess.AbstractImpl<BuilderState> {

	public final static String NAMED_URI= "org.eclipse.xtext.index.Index.URI";
	private IPersister persister;
	private Resource resource;
	
	@Inject
	public BuilderStateManager(ResourceSet resourceSet, @Named(NAMED_URI) String uri, IPersister persister, BufferedBinaryResourceFactory resourceFactory) {
		URI createURI = URI.createURI(uri);
		resource = resourceFactory.createResource(createURI);
		resourceSet.getResources().add(resource);
		this.persister = persister;
	}

	@Override
	protected BuilderState getState() {
		EList<EObject> list = resource.getContents();
		if (list.isEmpty()) {
			BuilderState builderState = BuilderStateFactory.eINSTANCE.createBuilderState();
			list.add(builderState);
			return builderState;
		} else {
			return (BuilderState) list.get(0);
		}
	}
	
	public void load() {
		modify(new IUnitOfWork<Void, BuilderState>(){
			public java.lang.Void exec(BuilderState state) throws Exception {
				persister.load(resource);
				return null;
			}});
	}

	public void save() {
		modify(new IUnitOfWork<Void, BuilderState>(){
			public java.lang.Void exec(BuilderState state) throws Exception {
				persister.save(resource);
				return null;
			}});
	}
}
