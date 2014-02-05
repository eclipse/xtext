/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.List;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypesSwitch;

import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
@Singleton
public class JvmFeatureSignatureProvider {
	
	protected static class Switch extends TypesSwitch<String> {
		
		private int numberOfIrrelevantArguments;
		private ITypeArgumentContext ctx;
		
		public Switch(ITypeArgumentContext ctx, int numberOfIrrelevantArguments) {
			this.numberOfIrrelevantArguments = numberOfIrrelevantArguments;
			this.ctx = ctx; 
		}
		
		@Override
		public String caseJvmField(JvmField object) {
			return object.getSimpleName();
		}
		
		@Override
		public String caseJvmExecutable(JvmExecutable object) {
			StringBuilder builder = new StringBuilder(32);
			builder.append(object.getSimpleName());
			builder.append("(");
			List<JvmFormalParameter> params = object.getParameters();
			for (int i = 0; i < params.size(); i++) {
				if (i != 0)
					builder.append(",");
				if (i>=numberOfIrrelevantArguments) {
					JvmTypeReference resolvedParameterType = ctx.getLowerBound(params.get(i).getParameterType());
					if (resolvedParameterType != null)
						builder.append(resolvedParameterType.getIdentifier());
					else
						builder.append("null");
				}
			}
			builder.append(")");
			return builder.toString();
		}
	}
	
	public String getSignature(JvmFeature from, ITypeArgumentContext ctx, int numberOfIrrelevantArguments) {
		String result = createSwitch(ctx, numberOfIrrelevantArguments).doSwitch(from);
		if (result == null)
			throw new IllegalStateException("Could not create signature for " + from);
		return result;
	}
	
	protected Switch createSwitch(ITypeArgumentContext context, int numberOfIrrelevantArguments) {
		return new Switch(context, numberOfIrrelevantArguments);
	}

}
