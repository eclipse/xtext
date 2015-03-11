/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.scoping;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.example.arithmetics.arithmetics.DeclaredParameter;
import org.eclipse.xtext.example.arithmetics.arithmetics.Definition;
import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.example.arithmetics.arithmetics.util.ArithmeticsSwitch;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import com.google.inject.Inject;

/**
 * changes the exported name of a function to be the signature and not just the simple name.
 *   
 * @author Sven Efftinge - initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 */
public class NameProvider extends IQualifiedNameProvider.AbstractImpl {
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if(obj.eIsProxy())
			return null;
		String name = new ArithmeticsSwitch<String>() {

			public String caseModule(Module object) {
				return object.getName();
			}

			public String caseDefinition(Definition object) {
				StringBuilder sb = new StringBuilder();
				sb.append(doSwitch(object.eContainer()));
				sb.append(".");
				sb.append(object.getName());
				if (!object.getArgs().isEmpty()) {
					sb.append("(");
					Iterator<DeclaredParameter> iter = object.getArgs()
							.iterator();
					int i = 1;
					while (iter.hasNext()) {
						iter.next();
						sb.append("arg" + (i++));
						if (iter.hasNext())
							sb.append(",");
					}
					sb.append(")");
				}
				return sb.toString();
			}

			public String caseDeclaredParameter(DeclaredParameter object) {
				return doSwitch(object.eContainer()) + "." + object.getName();
			}

		}.doSwitch(obj);
		if(name == null)
			return null;
		return qualifiedNameConverter.toQualifiedName(name);
	}
}