/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.validation;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.IRawTypeHelper;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OperationSignature {

	public static class Provider {
		
		@Inject
		private IRawTypeHelper rawTypeHelper;
		
		public OperationSignature get(JvmOperation operation) {
			return new OperationSignature(operation, rawTypeHelper);
		}
	}

	private JvmOperation operation;

	private List<JvmType> erasureParameterTypes;

	protected OperationSignature(JvmOperation operation, IRawTypeHelper rawTypeHelper) {
		this.operation = operation;
		if (operation != null) {
			erasureParameterTypes = Lists.newArrayListWithCapacity(operation.getParameters().size());
			for (JvmFormalParameter parameter : operation.getParameters()) {
				List<JvmType> rawTypes = rawTypeHelper.getAllRawTypes(parameter.getParameterType(),
						operation.eResource());
				if (rawTypes.isEmpty()) {
					erasureParameterTypes.add(null);
				} else {
					erasureParameterTypes.add(rawTypes.get(0));
				}
			}
		} else {
			erasureParameterTypes = Collections.emptyList();
		}
	}

	public String getName() {
		if (operation == null)
			return "null";
		return operation.getSimpleName();
	}

	public Object getErasureKey() {
		return Tuples.create(getName(), erasureParameterTypes);
	}

}