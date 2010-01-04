/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * A value converter that delegates to the {@link org.eclipse.emf.ecore.EFactory} of a {@link EDataType}.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class EFactoryValueConverter implements IValueConverter<Object> {

	private final EDataType dataType;

	public EFactoryValueConverter(EDataType dataType) {
		this.dataType = dataType;
	}

	public String toString(Object value) {
		return dataType.getEPackage().getEFactoryInstance().convertToString(dataType, value);
	}

	public Object toValue(String string, AbstractNode node) throws ValueConverterException {
		return dataType.getEPackage().getEFactoryInstance().createFromString(dataType, string);
	}

}
