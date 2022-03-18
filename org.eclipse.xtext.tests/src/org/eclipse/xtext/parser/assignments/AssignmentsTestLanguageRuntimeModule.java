/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.assignments;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractToStringConverter;
import org.eclipse.xtext.nodemodel.INode;

/**
 * Use this class to register components to be used within the IDE.
 */
public class AssignmentsTestLanguageRuntimeModule extends org.eclipse.xtext.parser.assignments.AbstractAssignmentsTestLanguageRuntimeModule {

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return AssignmentsValueConverterService.class;
	}
	
	public static class AssignmentsValueConverterService extends DefaultTerminalConverters {
		
		@ValueConverter(rule = "IdDatatype")
		public IValueConverter<String> IdDatatype() {
			return new AbstractToStringConverter<String>() {
				@Override
				protected String internalToValue(String string, INode node) {
					return "IdDatatype: " + string;
				}
			};
		}
		
		@ValueConverter(rule = "StringDatatype")
		public IValueConverter<String> StringDatatype() {
			return new AbstractToStringConverter<String>() {
				@Override
				protected String internalToValue(String string, INode node) {
					return "StringDatatype: " + string;
				}
			};
		}
		
	}
}
