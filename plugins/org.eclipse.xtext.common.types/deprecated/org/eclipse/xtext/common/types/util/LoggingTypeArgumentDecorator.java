/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class LoggingTypeArgumentDecorator extends TypeArgumentContextProvider implements TypeArgumentContextProvider.IInitializableTypeArgumentContext, TypeArgumentContextProvider.Request {

	private static final Logger primaryLog = Logger.getLogger(LoggingTypeArgumentDecorator.class.getCanonicalName() + ".Primary");
	private static final Logger requestLogger = Logger.getLogger(LoggingTypeArgumentDecorator.class.getCanonicalName() + ".Request");
	
	public static boolean isDebugEnabled() {
		return primaryLog.isDebugEnabled() || requestLogger.isDebugEnabled();
	}
	
	private String indentation = "";
	
	protected void indent() {
		indentation = indentation + "  ";
	}
	
	protected void dedent() {
		indentation = indentation.substring(0, indentation.length() - 2);
	}
	
	private final TypeArgumentContextProvider.IInitializableTypeArgumentContext contextDelegate;

	private TypeArgumentContextProvider.Request requestDelegate;
	
	private TypeArgumentContextProvider contextProviderDelegate;
	
	public LoggingTypeArgumentDecorator(TypeArgumentContextProvider.IInitializableTypeArgumentContext contextDelegate) {
		this.contextDelegate = contextDelegate;
	}
	
	public void initialize(TypeArgumentContextProvider.Request request, TypeArgumentContextProvider contextProvider) {
		if (primaryLog.isDebugEnabled()) {
			primaryLog.debug(indentation + "Initialized argument context for request " + request);
		}
		contextProviderDelegate = contextProvider;
		this.requestDelegate = request;
		contextDelegate.initialize(this, this);
	}

	public JvmTypeReference getBoundArgument(JvmTypeParameter parameter) {
		if (primaryLog.isDebugEnabled()) {
			primaryLog.debug(indentation + "getBoundArgument(" + parameter + ")");
			indent();
		}
		JvmTypeReference result = contextDelegate.getBoundArgument(parameter);
		if (primaryLog.isDebugEnabled()) {
			dedent();
			primaryLog.debug(indentation + "getBoundArgument.result = " + result);
		}
		return result;
	}

	public JvmTypeReference getLowerBound(JvmTypeReference reference) {
		if (primaryLog.isDebugEnabled()) {
			primaryLog.debug(indentation + "getLowerBound(" + reference + ")");
			indent();
		}
		JvmTypeReference result = contextDelegate.getLowerBound(reference);
		if (primaryLog.isDebugEnabled()) {
			dedent();
			primaryLog.debug(indentation + "getLowerBound.result = " + result);
		}
		return result;
	}

	public JvmTypeReference getUpperBound(JvmTypeReference reference, Notifier context) {
		if (primaryLog.isDebugEnabled()) {
			primaryLog.debug(indentation + "getUpperBound(" + reference + ",..)");
			indent();
		}
		JvmTypeReference result = contextDelegate.getUpperBound(reference, context);
		if (primaryLog.isDebugEnabled()) {
			dedent();
			primaryLog.debug(indentation + "getUpperBound.result = " + result);
		}
		return result;
	}

	public JvmTypeReference resolve(JvmTypeReference reference) {
		if (primaryLog.isDebugEnabled()) {
			primaryLog.debug(indentation + "resolve(" + reference + ")");
			indent();
		}
		JvmTypeReference result = contextDelegate.resolve(reference);
		if (primaryLog.isDebugEnabled()) {
			dedent();
			primaryLog.debug(indentation + "resolve.result = " + result);
		}
		return result;
	}

	public boolean isRawTypeContext() {
		if (primaryLog.isDebugEnabled()) {
			primaryLog.debug(indentation + "isRawTypeContext()");
			indent();
		}
		boolean result = contextDelegate.isRawTypeContext();
		if (primaryLog.isDebugEnabled()) {
			dedent();
			primaryLog.debug(indentation + "isRawTypeContext.result = " + result);
		}
		return result;
	}

	public JvmTypeReference getReceiverType() {
		if (requestLogger.isDebugEnabled()) {
			requestLogger.debug(indentation + "getReceiverType()");
			indent();
		}
		JvmTypeReference result = requestDelegate.getReceiverType();
		if (requestLogger.isDebugEnabled()) {
			dedent();
			requestLogger.debug(indentation + "getReceiverType.result = " + result);
		}
		return result;
	}

	public JvmFeature getFeature() {
		if (requestLogger.isDebugEnabled()) {
			requestLogger.debug(indentation + "getFeature()");
			indent();
		}
		JvmFeature result = requestDelegate.getFeature();
		if (requestLogger.isDebugEnabled()) {
			dedent();
			requestLogger.debug(indentation + "getFeature.result = " + getIdentifier(result));
		}
		return result;
	}

	protected String getIdentifier(JvmIdentifiableElement identifiable) {
		if (identifiable == null)
			return "/null/";
		return identifiable.getIdentifier();
	}

	public JvmTypeParameterDeclarator getNearestDeclarator() {
		if (requestLogger.isDebugEnabled()) {
			requestLogger.debug(indentation + "getNearestDeclarator()");
			indent();
		}
		JvmTypeParameterDeclarator result = requestDelegate.getNearestDeclarator();
		if (requestLogger.isDebugEnabled()) {
			dedent();
			requestLogger.debug(indentation + "getNearestDeclarator.result = " + result);
		}
		return result;
	}

	public List<JvmTypeReference> getArgumentTypes() {
		if (requestLogger.isDebugEnabled()) {
			requestLogger.debug(indentation + "getArgumentTypes()");
			indent();
		}
		List<JvmTypeReference> result = requestDelegate.getArgumentTypes();
		if (requestLogger.isDebugEnabled()) {
			dedent();
			requestLogger.debug(indentation + "getArgumentTypes.result = " + result);
		}
		return result;
	}

	public List<JvmTypeReference> getExplicitTypeArgument() {
		if (requestLogger.isDebugEnabled()) {
			requestLogger.debug(indentation + "getExplicitTypeArgument()");
			indent();
		}
		List<JvmTypeReference> result = requestDelegate.getExplicitTypeArgument();
		if (requestLogger.isDebugEnabled()) {
			dedent();
			requestLogger.debug(indentation + "getExplicitTypeArgument.result = " + result);
		}
		return result;
	}

	public JvmTypeReference getExpectedType() {
		if (requestLogger.isDebugEnabled()) {
			requestLogger.debug(indentation + "getExpectedType()");
			indent();
		}
		JvmTypeReference result = requestDelegate.getExpectedType();
		if (requestLogger.isDebugEnabled()) {
			dedent();
			requestLogger.debug(indentation + "getExpectedType.result = " + result);
		}
		return result;
	}

	public JvmTypeReference getDeclaredType() {
		if (requestLogger.isDebugEnabled()) {
			requestLogger.debug(indentation + "getDeclaredType()");
			indent();
		}
		JvmTypeReference result = requestDelegate.getDeclaredType();
		if (requestLogger.isDebugEnabled()) {
			dedent();
			requestLogger.debug(indentation + "getDeclaredType.result = " + result);
		}
		return result;
	}
	
	@Override
	protected ITypeArgumentContext getDeclaredBoundsContext(JvmExecutable feature) {
		if (primaryLog.isDebugEnabled()) {
			primaryLog.debug(indentation + "compute declared bounds context for " + getIdentifier(feature));
		}
		return contextProviderDelegate.getDeclaredBoundsContext(feature);
	}
	
	@Override
	protected ITypeArgumentContext getExpectedTypeContext(JvmTypeReference declaredType, JvmTypeReference expectedType) {
		if (primaryLog.isDebugEnabled()) {
			primaryLog.debug(indentation + "compute expected type context for " + expectedType + " <= " + declaredType);
		}
		return contextProviderDelegate.getExpectedTypeContext(declaredType, expectedType);
	}
	
	@Override
	protected ITypeArgumentContext getExplicitArgumentContext(JvmExecutable executable,
			List<JvmTypeReference> explicitTypeArguments) {
		if (primaryLog.isDebugEnabled()) {
			primaryLog.debug(indentation + "compute explicit argument context for " + explicitTypeArguments + " " + getIdentifier(executable));
		}
		return contextProviderDelegate.getExplicitArgumentContext(executable, explicitTypeArguments);
	}
	
	@Override
	protected ITypeArgumentContext getParameterContext(JvmExecutable executable, List<JvmTypeReference> argumentTypes) {
		if (primaryLog.isDebugEnabled()) {
			primaryLog.debug(indentation + "compute parameter context for " + getIdentifier(executable) + " with " + argumentTypes);
		}
		return contextProviderDelegate.getParameterContext(executable, argumentTypes);
	}
	
	@Override
	protected TypeArgumentContext getReceiverContext(JvmTypeReference receiverType) {
		if (primaryLog.isDebugEnabled()) {
			primaryLog.debug(indentation + "compute receiver context for " + receiverType);
		}
		return contextProviderDelegate.getReceiverContext(receiverType);
	}

}
