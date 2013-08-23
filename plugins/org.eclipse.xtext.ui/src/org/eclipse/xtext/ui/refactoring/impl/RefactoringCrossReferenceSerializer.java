/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.parsetree.reconstr.impl.CrossReferenceSerializer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Inject;

/**
 * Calculates the new text for a cross reference when the target is renamed. The functionality differs from the original
 * cross reference serializers {@link CrossReferenceSerializer} and
 * {@link org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer} as we have to preserve the syntax of the
 * original cross-reference, e.g. short-cut syntax for a getter call.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * 
 * @since 2.4
 */
public class RefactoringCrossReferenceSerializer {

	private static final Logger log = Logger.getLogger(RefactoringCrossReferenceSerializer.class);
	
	@Inject
	@SerializerScopeProviderBinding
	private IScopeProvider scopeProvider;

	@Inject
	private IValueConverterService valueConverter;

	@Inject
	private LinkingHelper linkingHelper;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	public String getCrossRefText(EObject owner, CrossReference crossref, EObject target,
			RefTextEvaluator refTextEvaluator, ITextRegion linkTextRegion, StatusWrapper status) {
		try {
			final EReference ref = GrammarUtil.getReference(crossref, owner.eClass());
			final IScope scope = scopeProvider.getScope(owner, ref);
			if (scope == null) {
				throw new IllegalStateException("Could not create scope for the given cross reference.");
			}
			String ruleName = linkingHelper.getRuleNameFrom(crossref);

			Iterable<IEObjectDescription> descriptionsForCrossRef = scope.getElements(target);
			String bestRefText = null;
			for (IEObjectDescription desc : descriptionsForCrossRef) {
				try {
					String unconvertedRefText = qualifiedNameConverter.toString(desc.getName());
					String convertedRefText = valueConverter.toString(unconvertedRefText, ruleName);
					if (refTextEvaluator.isValid(desc) && (bestRefText == null || refTextEvaluator.isBetterThan(convertedRefText, bestRefText)))
						bestRefText = convertedRefText;
				} catch (ValueConverterException e) {
					status.add(RefactoringStatus.WARNING,
							"Missconfigured language: New reference text has invalid syntax.", owner, linkTextRegion);
				}
			}
			if (bestRefText == null)
				status.add(RefactoringStatus.ERROR, "Refactoring introduces a name conflict.", owner, linkTextRegion);
			return bestRefText;

		} catch (Exception exc) {
			log.error(exc.getMessage(), exc);
			status.add(ERROR, exc.getMessage(), owner, linkTextRegion);
			return null;
		}
	}
	
	public static interface RefTextEvaluator {
		
		boolean isBetterThan(String newText, String currentText);
		
		boolean isValid(IEObjectDescription target);
	}
}
