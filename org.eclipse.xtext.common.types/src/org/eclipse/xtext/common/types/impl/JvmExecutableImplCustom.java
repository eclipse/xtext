/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmFormalParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmExecutableImplCustom extends JvmExecutableImpl {

	private Runnable initializer;

	@Override
	public void internalSetIdentifier(String identifier) {
		if (this.identifier != null && identifier == null) {
			if (eResource() != null) {
				EcoreUtil.resolveAll(this);
			}
		}
		super.internalSetIdentifier(identifier);
	}
	
	@Override
	protected String computeIdentifier() {
		String result = super.computeIdentifier();
		if (result != null) {
			StringBuilder builder = new StringBuilder(result);
			builder.append('(');
			boolean first = true;
			for(JvmFormalParameter parameter: getParameters()) {
				if (!first) {
					builder.append(',');
				} else {
					first = false;
				}
				if (parameter.getParameterType() != null && parameter.getParameterType().getType() != null)
					builder.append(parameter.getParameterType().getType().getIdentifier());
				else
					builder.append("null");
			}
			builder.append(')');
			return builder.toString();
		}
		return null;
	}
	
	public void runInitializer() {
		if (initializer == null)
			return;
		Runnable init = initializer;
		initializer = null;
		init.run();
	}

	public void setParameterNameInitializer(Runnable initializer) {
		this.initializer = initializer;
	}
	
}
