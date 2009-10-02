/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.builder;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ui.core.builder.DefaultLanguageBuilder;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DomainModelLanguageBuilder extends DefaultLanguageBuilder {

	@Override
	public List<Map<String, Object>> validate(Resource res, IProgressMonitor monitor) {
		List<Map<String, Object>> validate = super.validate(res, monitor);
		return validate;
	}
	
	@Override
	public void doBuild(Resource res, IProgressMonitor monitor) {
		super.doBuild(res, monitor);
	}
	
	@Override
	public void indexEObjectDescriptors(Resource resource, IEObjectDescriptorIndexer feeder, IProgressMonitor monitor) {
		super.indexEObjectDescriptors(resource, feeder, monitor);
	}
	
	@Override
	public void indexEReferenceDescriptors(Resource resource, IEReferenceDescriptorIndexer feeder,
			IProgressMonitor monitor) {
		super.indexEReferenceDescriptors(resource, feeder, monitor);
	}
	
}
