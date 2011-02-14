/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import java.util.Iterator;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypesSwitch;

import com.google.common.base.Function;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmFeatureSignatureProvider implements Function<JvmFeature, String> {
	
	static class Switch extends TypesSwitch<String> {
		
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
				builder.append(context.getLowerBound(params.next().getParameterType()).getIdentifier());
				if (params.hasNext())
					builder.append(",");
			}
			builder.append(")");
			return builder.toString();
		}
	}
	private Switch theSwitch = null;
	
	public JvmFeatureSignatureProvider(TypeArgumentContext context) {
		theSwitch = new Switch(context);
	}

	public String apply(JvmFeature from) {
		return theSwitch.doSwitch(from);
	}

}
