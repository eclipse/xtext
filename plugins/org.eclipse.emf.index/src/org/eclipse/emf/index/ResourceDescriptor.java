/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Primary key: (uri)
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface ResourceDescriptor extends Serializable {
	
	static final long NEVER = Long.MIN_VALUE;
	
	public interface DAO extends IDAO<ResourceDescriptor>{
		Query createQuery();
		
		IGenericQuery<ResourceDescriptor> createQueryResource(Resource resource);
	}

	public interface Query extends IGenericQuery<ResourceDescriptor> {
		Query uri(String pattern);
		
		Query indexingDate(long date);
		
		Query indexingDate(Date date);
	}

	String getURI();
	
	long getIndexingDate();
	
	Map<String, String> getUserData();
	
	String getUserData(String key);
}