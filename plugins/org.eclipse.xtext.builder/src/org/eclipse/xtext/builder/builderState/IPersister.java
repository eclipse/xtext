/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
@ImplementedBy(IPersister.DefaultImpl.class)
public interface IPersister {
	void load(Resource state);
	void save(Resource state);
	
	public class DefaultImpl implements IPersister {
		
		private final static Logger log = Logger.getLogger(org.eclipse.xtext.builder.builderState.IPersister.DefaultImpl.class);

		public void load(Resource state) {
			try {
				state.load(null);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}

		public void save(Resource state) {
			try {
				state.save(null);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		
	}
}
