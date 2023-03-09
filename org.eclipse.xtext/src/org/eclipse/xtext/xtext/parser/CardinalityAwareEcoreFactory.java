/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.parser;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.DefaultEcoreElementFactory;

/**
 * The Xtext grammar allows to override the cardinality value by using patterns like
 * {@code (feature+=RuleCall+)?}. Usually the '?' would override the '+' and the information
 * about the '+' is completely lost. This factory will flag such patterns with a warning. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
public class CardinalityAwareEcoreFactory extends DefaultEcoreElementFactory {

	@Override
	public void set(EObject object, String feature, Object value, String ruleName, INode node) throws ValueConverterException {
		if (object instanceof AbstractElement && XtextPackage.Literals.ABSTRACT_ELEMENT__CARDINALITY.getName().equals(feature)) {
			AbstractElement casted = (AbstractElement) object;
			String knownCardinality = casted.getCardinality();
			if (knownCardinality != null) {
				String newCardinality = String.valueOf(getTokenAsStringIfPossible(value));
				if ("*".equals(newCardinality)) {
					casted.setCardinality("*");
				} else if ("*".equals(knownCardinality)) {
					// nothing to do
				} else if ("+".equals(knownCardinality)) {
					if ("?".equals(newCardinality)) {
						casted.setCardinality("*");	
					}
				} else if ("?".equals(knownCardinality)) {
					if ("+".equals(newCardinality)) {
						casted.setCardinality("*");
					}
				}
				throw new MoreThanOneCardinalityException(newCardinality, casted.getCardinality(), node);
			}
		} 
		super.set(object, feature, value, ruleName, node);
	}
	
}
