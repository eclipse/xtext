/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import static java.util.Collections.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.ImplementedBy;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(IJvmModelInferrer.NullImpl.class)
public interface IJvmModelInferrer {

	List<? extends EObject> inferJvmModel(EObject sourceObject);
	
	public static class NullImpl implements IJvmModelInferrer {

		public List<? extends EObject> inferJvmModel(EObject sourceObject) {
			return emptyList();
		}
		
	}
}
