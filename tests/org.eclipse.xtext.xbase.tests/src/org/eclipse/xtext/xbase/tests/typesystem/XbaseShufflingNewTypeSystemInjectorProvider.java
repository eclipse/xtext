/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.internal.AssignmentArguments;
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionArgumentFactory;
import org.eclipse.xtext.xbase.typesystem.internal.FeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.internal.IFeatureCallArguments;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseShufflingNewTypeSystemInjectorProvider extends XbaseNewTypeSystemInjectorProvider {
	
	@Override
	protected Injector internalCreateInjector() {
		return new XbaseShufflingNewTypeSystemTestStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public static class XbaseShufflingNewTypeSystemTestStandaloneSetup extends XbaseStandaloneSetup {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new XbaseNewTypeSystemTestRuntimeModule() {
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
			return ListExtensions.reverseView(result);
		}
		
		@Override
		protected XExpression getThen(XIfExpression ifExpression) {
			if (ifExpression.getElse() != null)
				return ifExpression.getElse();
			return super.getThen(ifExpression);
		}
		
		@Override
		protected XExpression getElse(XIfExpression ifExpression) {
			if (ifExpression.getElse() != null)
				return ifExpression.getThen();
			return super.getElse(ifExpression);
		}
	}
	
	@NonNullByDefault
	public static class ShufflingExpressionArgumentFactory extends ExpressionArgumentFactory {
		@Override
		public IFeatureCallArguments createExpressionArguments(XExpression expression,
				AbstractLinkingCandidate<?> candidate) {
			if (expression instanceof XAssignment && !(candidate.getFeature() instanceof JvmExecutable)) {
				return new AssignmentArguments(candidate);
			} else {
				return new FeatureCallArguments(candidate) {
					@Override
					public LightweightTypeReference getDeclaredType(int argumentIndex) {
						List<JvmFormalParameter> parameters = getParameters();
						if (isVarArgs()) {
							parameters = parameters.subList(0, parameters.size() - 1);
						}
						int idx = argumentIndex - getArgumentSizeFixup();
						JvmFormalParameter parameter = ListExtensions.reverseView(parameters).get(idx);
						JvmTypeReference parameterType = parameter.getParameterType();
						LightweightTypeReference result = getConverter().toLightweightReference(parameterType);
						return result;
					}
					
					@Override
					public XExpression getArgument(int argumentIndex) {
						List<XExpression> arguments = getArguments();
						argumentIndex -= getArgumentSizeFixup();
						if (isVarArgs()) {
							if (argumentIndex >= getFixedArityArgumentCount()) {
								argumentIndex -= getFixedArityArgumentCount();
								arguments = arguments.subList(getFixedArityArgumentCount(), arguments.size());
								return ListExtensions.reverseView(arguments).get(argumentIndex);
							}
							arguments = arguments.subList(0, getFixedArityArgumentCount());
						}
						arguments = ListExtensions.reverseView(arguments);
						XExpression result = arguments.get(argumentIndex);
						return result;
					}
				};
			}
		}
	}
	
}
