/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.List;

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
		
		private int numberOfIrrelevantArguments;
		private TypeArgumentContext ctx;
		
		public Switch(TypeArgumentContext ctx, int numberOfIrrelevantArguments) {
			this.numberOfIrrelevantArguments = numberOfIrrelevantArguments;
			this.ctx = ctx; 
		}
		
		@Override
		public String caseJvmField(JvmField object) {
			return object.getSimpleName();
		}
		
		@Override
		public String caseJvmOperation(JvmOperation object) {
			StringBuilder builder = new StringBuilder(32);
			builder.append(object.getSimpleName());
			builder.append("(");
			List<JvmFormalParameter> params = object.getParameters();
			for (int i = numberOfIrrelevantArguments; i < params.size(); i++) {
				if (i != numberOfIrrelevantArguments)
					builder.append(",");
				JvmTypeReference resolvedParameterType = ctx.getLowerBound(params.get(i).getParameterType());
				if (resolvedParameterType != null)
					builder.append(resolvedParameterType.getIdentifier());
				else
					builder.append("null");
			}
			builder.append(")");
			return builder.toString();
		}
	}
	
	public String getSignature(JvmFeature from, TypeArgumentContext ctx, int numberOfIrrelevantArguments) {
		return createSwitch(ctx, numberOfIrrelevantArguments).doSwitch(from);
	}
	
	protected Switch createSwitch(TypeArgumentContext context, int numberOfIrrelevantArguments) {
		return new Switch(context, numberOfIrrelevantArguments);
	}

}
