/*******************************************************************************
 * Copyright (c) 2008, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractScopeProvider;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextScopeProvider extends AbstractScopeProvider {
	
	@Inject
	private IResourceDescription.Manager resourceDescriptionManager;
	
	@Inject
	private IGlobalScopeProvider globalScopeProvider;
	
	@Override
	public IScope getScope(final EObject context, EReference reference) {
		if (reference == XtextPackage.eINSTANCE.getTypeRef_Classifier()) {
			if (context instanceof TypeRef) {
				final TypeRef typeRef = (TypeRef) context;
				final AbstractMetamodelDeclaration metaModel = typeRef.getMetamodel();
				if (metaModel != null) {
					EPackage pack = metaModel.getEPackage();
					if (pack != null)
						return createClassifierScope(Collections.singletonList(pack));
				} else {
					return createReferencedPackagesScope(GrammarUtil.getGrammar(context));
				}
			} else {
				return createReferencedPackagesScope(GrammarUtil.getGrammar(context));
			}
			return IScope.NULLSCOPE;
		}
		if (reference == XtextPackage.eINSTANCE.getEnumLiteralDeclaration_EnumLiteral()) {
			final EnumRule rule = GrammarUtil.containingEnumRule(context);
			if (rule.getType() != null && rule.getType().getClassifier() != null && rule.getType().getClassifier() instanceof EEnum) {
				return createEnumLiteralsScope((EEnum) rule.getType().getClassifier());
			}
			return IScope.NULLSCOPE;
			
		}
		if(reference == XtextPackage.eINSTANCE.getGrammar_UsedGrammars()){
			return globalScopeProvider.getScope(context.eResource(), reference, new Predicate<IEObjectDescription>(){
				@Override
				public boolean apply(IEObjectDescription input) {
					return !input.getEObjectURI().equals(EcoreUtil.getURI(context));
				}
			});
		}
		if(reference == XtextPackage.eINSTANCE.getRuleCall_Rule()) {
			return createScope(context.eResource(), reference.getEReferenceType(), new SuperCallScope(context));
		}
		if (reference == XtextPackage.eINSTANCE.getParameterReference_Parameter()) {
			ParserRule rule = GrammarUtil.containingParserRule(context);
			if (rule == null) {
				return IScope.NULLSCOPE;
			}
			return Scopes.scopeFor(rule.getParameters());
		}
		if (reference == XtextPackage.eINSTANCE.getNamedArgument_Parameter()) {
			RuleCall ruleCall = EcoreUtil2.getContainerOfType(context, RuleCall.class);
			if (ruleCall == null) {
				return IScope.NULLSCOPE;
			}
			AbstractRule referencedRule = ruleCall.getRule();
			if (referencedRule instanceof ParserRule) {
				return Scopes.scopeFor(((ParserRule) referencedRule).getParameters());	
			}
			return IScope.NULLSCOPE;
		}
		return createScope(context.eResource(), reference.getEReferenceType(), IScope.NULLSCOPE);
	}

	protected IScope createEnumLiteralsScope(EEnum eEnum) {
		return new SimpleScope(IScope.NULLSCOPE, Iterables.transform(eEnum.getELiterals(), new Function<EEnumLiteral, IEObjectDescription>() {
			@Override
			public IEObjectDescription apply(EEnumLiteral param) {
				return EObjectDescription.create(QualifiedName.create(param.getName()), param);
			}
		}));
	}

	protected IScope createClassifierScope(List<EPackage> packages) {
		return new SimpleScope(
				IScope.NULLSCOPE, 
				FluentIterable.from(packages)
					.transformAndConcat(EPackage::getEClassifiers)
					.transform(classifier->EObjectDescription.create(QualifiedName.create(classifier.getName()), classifier))) {
			
			@Override
			protected IEObjectDescription getSingleLocalElementByName(QualifiedName name) {
				if (name.getSegmentCount() == 1) {
					EClassifier candidate = null;
					for(EPackage pack: packages) {
						EClassifier classifier = pack.getEClassifier(name.getFirstSegment());
						if (classifier != null) {
							if (candidate != null) {
								return null;
							}
							candidate = classifier;
						}
					}
					if (candidate != null) {
						return EObjectDescription.create(name, candidate);
					}
				}
				return null;
			}
		};
	}

	protected IScope createReferencedPackagesScope(Grammar g) {
		List<EPackage> allPackages = new ArrayList<EPackage>();
		for(AbstractMetamodelDeclaration decl: g.getMetamodelDeclarations()) {
			if (decl.getEPackage() != null)
				allPackages.add(decl.getEPackage());
		}
		return createClassifierScope(allPackages);
	}

	protected IScope createScope(Resource resource, EClass type, IScope parent) {
		if (resource.getContents().size() < 1)
			throw new IllegalArgumentException("resource is not as expected: contents.size == "
					+ resource.getContents().size() + " but expected: >= 1");
		final EObject firstContent = resource.getContents().get(0);
		if (!(firstContent instanceof Grammar))
			return parent;
		return createScope((Grammar) firstContent, type, parent);
	}

	protected IScope createScope(final Grammar grammar, EClass type, IScope current) {
		if (EcorePackage.Literals.EPACKAGE == type) {
			return createEPackageScope(grammar);
		} else if (AbstractMetamodelDeclaration.class.isAssignableFrom(type.getInstanceClass())) {
			return new SimpleScope(IScope.NULLSCOPE, Iterables.transform(grammar.getMetamodelDeclarations(),
							new Function<AbstractMetamodelDeclaration,IEObjectDescription>(){
								@Override
								public IEObjectDescription apply(AbstractMetamodelDeclaration from) {
									String name = from.getAlias() != null ? from.getAlias() : "";
									return EObjectDescription.create(QualifiedName.create(name), from);
								}
							}));
		}
		final List<Grammar> allGrammars = getAllGrammars(grammar);
		for (int i = allGrammars.size() - 1; i >= 0; i--) {
			current = doCreateScope(allGrammars.get(i), type, current);
		}
		return current;
	}


	protected IScope doCreateScope(final Grammar grammar, final EClass type, IScope parent) {
		final IResourceDescription resourceDescription = resourceDescriptionManager.getResourceDescription(grammar.eResource());
		return SelectableBasedScope.createScope(parent, resourceDescription, type, false);
	}

	protected List<Grammar> getAllGrammars(Grammar grammar) {
		List<Grammar> result = Lists.newArrayList(grammar);
		result.addAll(GrammarUtil.allUsedGrammars(grammar));
		return result;
	}

	protected IScope createEPackageScope(final Grammar grammar, IScope parent) {
		return new SimpleScope(parent,Iterables.transform(Iterables.filter(grammar.getMetamodelDeclarations(),
				new Predicate<AbstractMetamodelDeclaration>() {
					@Override
					public boolean apply(AbstractMetamodelDeclaration input) {
						return input.getEPackage() != null;
					}
				}), new Function<AbstractMetamodelDeclaration, IEObjectDescription>() {
			@Override
			public IEObjectDescription apply(AbstractMetamodelDeclaration from) {
				return EObjectDescription.create(QualifiedName.create(from.getEPackage().getNsURI()), from.getEPackage());
			}
		}));
	}

	protected IScope createEPackageScope(final Grammar grammar) {
		final List<Grammar> allGrammars = getAllGrammars(grammar);
		IScope current = new SimpleScope(IScope.NULLSCOPE, Iterables.transform(EPackage.Registry.INSTANCE.keySet(), new Function<String, IEObjectDescription>() {
			@Override
			public IEObjectDescription apply(String from) {
				InternalEObject proxyPackage = (InternalEObject) EcoreFactory.eINSTANCE.createEPackage();
				proxyPackage.eSetProxyURI(URI.createURI(from));
				return EObjectDescription.create(QualifiedName.create(from), proxyPackage, Collections.singletonMap("nsURI", "true"));
			}
		}));
		for (int i = allGrammars.size() - 1; i >= 0; i--) {
			current = createEPackageScope(allGrammars.get(i), current);
		}
		return current;
	}

}
