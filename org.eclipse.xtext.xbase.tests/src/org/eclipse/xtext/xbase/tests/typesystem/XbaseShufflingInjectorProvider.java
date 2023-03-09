/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.List;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionArgumentFactory;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseShufflingInjectorProvider extends XbaseInjectorProvider {
	
	@Override
	protected Injector internalCreateInjector() {
		return new XbaseShufflingTestStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public static class XbaseShufflingTestStandaloneSetup extends XbaseStandaloneSetup {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new XbaseTestRuntimeModule() {
				@SuppressWarnings("unused")
				public Class<? extends XbaseTypeComputer> bindXbaseTypeComputer() {
					return ShufflingXbaseTypeComputer.class;
				}
				
				@SuppressWarnings("unused")
				public Class<? extends ExpressionArgumentFactory> bindExpressionArgumentFactory() {
					return ShufflingExpressionArgumentFactory.class;
				}
			});
		}
	}
	
	public static class ShufflingXbaseTypeComputer extends XbaseTypeComputer {
		@Override
		protected List<XCasePart> getCases(XSwitchExpression switchExpression) {
			List<XCasePart> result = super.getCases(switchExpression);
			for(XCasePart casePart: result) {
				if (casePart.getThen() == null) {
					return result;
				}
			}
			return Lists.reverse(result);
		}
		
		/* @Nullable */
		@Override
		protected XExpression getThen(XIfExpression ifExpression) {
			if (ifExpression.getElse() != null)
				return ifExpression.getElse();
			return super.getThen(ifExpression);
		}
		
		/* @Nullable */
		@Override
		protected XExpression getElse(XIfExpression ifExpression) {
			if (ifExpression.getElse() != null)
				return ifExpression.getThen();
			return super.getElse(ifExpression);
		}
	}
	
	public static class ShufflingExpressionArgumentFactory extends ExpressionArgumentFactory {
		
		@Override
		protected IFeatureCallArguments createArgumentsForExecutable(boolean varArgs, List<XExpression> arguments,
				List<JvmFormalParameter> parameters, boolean hasReceiver, ITypeReferenceOwner owner) {
			if (varArgs) {
				List<JvmFormalParameter> reversedParameters = Lists.newArrayList(Lists.reverse(parameters.subList(0, parameters.size() - 1)));
				reversedParameters.add(parameters.get(parameters.size() - 1));
				List<XExpression> reversedArgumetns = Lists.newArrayList(Lists.reverse(arguments.subList(0, parameters.size() - 1)));
				reversedArgumetns.addAll(Lists.reverse(arguments.subList(parameters.size() - 1, arguments.size())));
				return super.createArgumentsForExecutable(varArgs, reversedArgumetns, reversedParameters, hasReceiver, owner);
			}
			return super.createArgumentsForExecutable(varArgs, Lists.reverse(arguments), Lists.reverse(parameters), hasReceiver, owner);
		}
		
	}
	
}
