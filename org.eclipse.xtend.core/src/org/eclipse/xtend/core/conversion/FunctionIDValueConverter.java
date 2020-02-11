/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.conversion;

import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractValueConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class FunctionIDValueConverter extends AbstractValueConverter<String> {

	@Inject
	private OperatorMapping operatorMapping;
	
	private IValueConverter<Object> delegate;

	private XtendGrammarAccess grammarAccess;

	private XtendValueConverterService service;

	@Inject
	protected void setDelegate(XtendValueConverterService service, XtendGrammarAccess grammarAccess) {
		this.service = service;
		this.grammarAccess = grammarAccess;
	}
	
	@Override
	public String toValue(String string, INode node) throws ValueConverterException {
		QualifiedName operatorMethodName = operatorMapping.getMethodName(QualifiedName.create(string));
		if (operatorMethodName != null) {
			return operatorMethodName.getFirstSegment();
		}
		return (String) getDelegate().toValue(string, node);
	}

	private IValueConverter<Object> getDelegate() {
		if (delegate != null)
			return delegate;
		return delegate = service.getConverter(grammarAccess.getValidIDRule().getName());
	}

	@Override
	public String toString(String value) throws ValueConverterException {
		QualifiedName operatorName = operatorMapping.getOperator(QualifiedName.create(value));
		if (operatorName != null) {
			return operatorName.getFirstSegment();
		}
		return getDelegate().toString(value);
	}
	
}
