/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.example.arithmetics.arithmetics.DeclaredParameter;
import org.eclipse.xtext.example.arithmetics.arithmetics.Definition;
import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ArithmeticsLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public ArithmeticsLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	String text(Module ele) {
		return ele.getName();
	}
	String text(Definition ele) {
		String name = ele.getName();
		if (!ele.getArgs().isEmpty()) {
			name+="(";
			for (DeclaredParameter p : ele.getArgs()) {
				name+=p.getName();
				if (ele.getArgs().indexOf(p)!=ele.getArgs().size()-1)
					name+=",";
			}
			name+=")";
		}
		return name;
	}
	
    String image(Module ele) {
    	return "home_nav.gif";
    }
}
