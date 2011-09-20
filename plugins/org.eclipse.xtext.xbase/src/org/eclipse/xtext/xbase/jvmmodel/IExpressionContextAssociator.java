package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(ExpressionContextProvider.class)
public interface IExpressionContextAssociator {
	void associate(XExpression expression, JvmIdentifiableElement element);
}