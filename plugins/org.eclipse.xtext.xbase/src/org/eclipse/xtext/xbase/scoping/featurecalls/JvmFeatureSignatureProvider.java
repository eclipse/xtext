/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Iterator;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypesSwitch;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmFeatureSignatureProvider {
	
	protected static class Switch extends TypesSwitch<String> {
		
		private TypeArgumentContext context;
		
		public Switch(TypeArgumentContext context) {
			this.context = context;
		}
		
		@Override
		public String caseJvmField(JvmField object) {
			return object.getSimpleName();
		}
		
		@Override
		public String caseJvmOperation(JvmOperation object) {
			StringBuilder builder = new StringBuilder();
			builder.append(object.getSimpleName());
			builder.append("(");
			Iterator<JvmFormalParameter> params = object.getParameters().iterator();
			while (params.hasNext()){
				JvmTypeReference resolvedParameterType = context.getLowerBound(params.next().getParameterType());
				if (resolvedParameterType != null)
					builder.append(resolvedParameterType.getIdentifier());
				else
					builder.append("null");
				if (params.hasNext())
					builder.append(",");
			}
			builder.append(")");
			return builder.toString();
		}
	}
	
	public String getSignature(JvmFeature from, TypeArgumentContext context) {
		return createSwitch(context).doSwitch(from);
	}
	
	protected Switch createSwitch(TypeArgumentContext context) {
		return new Switch(context);
	}

}
