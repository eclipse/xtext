/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.validation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UniqueClassNameValidator extends AbstractDeclarativeValidator {
	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private IJvmModelAssociations associations;

	@Override
	public void register(EValidatorRegistrar registrar) {
	}

	@Inject
	protected void register(EValidatorRegistrar registrar, IGrammarAccess grammarAccess) {
		AbstractRule entryRule = Iterables.getFirst(grammarAccess.getGrammar().getRules(), null);
		if (entryRule instanceof ParserRule) {
			registrar.register(((ParserRule) entryRule).getType().getClassifier().getEPackage(), this);
		}
	}

	@Check
	public void checkUniqueName(EObject root) {
		if (root.eContainer() == null) {
			Resource resource = root.eResource();
			if (Objects.equal(Iterables.getFirst(resource.getContents(), null), root)) {
				for (EObject o : resource.getContents()) {
					if (o instanceof JvmDeclaredType) {
						doCheckUniqueName((JvmDeclaredType) o);
					}
				}
			}
		}
	}

	protected void doCheckUniqueName(JvmDeclaredType type) {
		if (type.eContainer() == null) {
			QualifiedName name = qualifiedNameProvider.getFullyQualifiedName(type);
			if (name != null) {
				doCheckUniqueName(name, type);
			}
		}
	}

	protected boolean doCheckUniqueName(QualifiedName name, JvmDeclaredType type) {
		IResourceDescriptions index = resourceDescriptionsProvider.getResourceDescriptions(type.eResource());
		Iterable<IEObjectDescription> others = index.getExportedObjects(TypesPackage.Literals.JVM_DECLARED_TYPE, name,
				false);
		return checkUniqueInIndex(type, others);
	}

	protected boolean checkUniqueInIndex(JvmDeclaredType type, Iterable<IEObjectDescription> descriptions) {
		Set<URI> resourceURIs = new HashSet<>();
		for (IEObjectDescription d : descriptions) {
			resourceURIs.add(d.getEObjectURI().trimFragment());
		}
		if (resourceURIs.size() > 1) {
			for (URI uri : resourceURIs) {
				if (!Objects.equal(uri, type.eResource().getURI())) {
					addIssue(type, uri.lastSegment());
					break;
				}
			}
			return false;
		} else {
			if (IterableExtensions.size(descriptions) > 1) {
				addIssue(type);
				return false;
			}
		}
		return true;
	}

	/**
	 * Marks a type as already defined.
	 * 
	 * @since 2.15
	 */
	protected void addIssue(JvmDeclaredType type) {
		addIssue(type, null);
	}

	/**
	 * Marks a type as already defined.
	 * 
	 * @param type - the type to mark already defined.
	 * @param fileName - a file where the type is already defined. If fileName
	 * is null this information will not be part of the message.
	 */
	protected void addIssue(JvmDeclaredType type, String fileName) {
		StringConcatenation builder = new StringConcatenation();
		builder.append("The type ");
		builder.append(type.getSimpleName());
		builder.append(" is already defined");
		if (fileName != null) {
			builder.append(" in ");
			builder.append(fileName);
		}
		builder.append(".");
		String message = builder.toString();
		EObject sourceElement = associations.getPrimarySourceElement(type);
		if (sourceElement == null) {
			addIssue(message, type, IssueCodes.DUPLICATE_TYPE);
		} else {
			addIssue(message, sourceElement, sourceElement.eClass().getEStructuralFeature("name"),
					IssueCodes.DUPLICATE_TYPE);
		}
	}
}
