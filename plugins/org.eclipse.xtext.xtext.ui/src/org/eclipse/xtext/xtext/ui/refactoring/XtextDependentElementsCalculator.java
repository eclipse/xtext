/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.refactoring;

import static com.google.common.collect.Iterables.*;
import static java.util.Collections.*;

import java.util.Collections;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.base.Function;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XtextDependentElementsCalculator implements IDependentElementsCalculator {

	public Iterable<URI> getDependentElementURIs(EObject baseElement, IProgressMonitor monitor) {
		return new XtextSwitch<Iterable<URI>>() {
			@Override
			public java.lang.Iterable<URI> defaultCase(EObject object) {
				return Collections.<URI>emptySet();
			}
			
			@Override
			public Iterable<URI> caseParserRule(ParserRule object) {
				if(Strings.equal(object.getType().getClassifier().getName(), object.getName())) {
					return singletonList(EcoreUtil.getURI(object.getType().getClassifier()));
				}
				return null;
			}
		}.doSwitch(baseElement);
	}

	protected Iterable<URI> uris(Iterable<? extends EObject> elements) {
		return transform(elements, new Function<EObject, URI>() {
			public URI apply(EObject from) {
				return EcoreUtil.getURI(from);
			}
		});
	}
}
