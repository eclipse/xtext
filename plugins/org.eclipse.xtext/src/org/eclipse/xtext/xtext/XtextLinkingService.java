/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextLinkingService extends DefaultLinkingService {

	private static final Logger log = Logger.getLogger(XtextLinkingService.class);

	@Inject
	private IValueConverterService valueConverterService;
	
	@Inject
	private IGlobalScopeProvider scopeProvider;
	
	@Inject
	private ResourceDescriptionsProvider descriptionsProvider;
	
	private String fileExtension = "xtext";

	@Inject
	public void setFileExtension(@Named(Constants.FILE_EXTENSIONS) String fileExtension) {
		this.fileExtension = fileExtension.split(",")[0];
	}
	
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
		if (ref == XtextPackage.eINSTANCE.getGrammar_UsedGrammars())
			return getUsedGrammar((Grammar) context, node);
		if (ref == XtextPackage.eINSTANCE.getTypeRef_Metamodel())
			return getLinkedMetaModel((TypeRef)context, ref, (ILeafNode) node);
		if (ref == XtextPackage.eINSTANCE.getAbstractMetamodelDeclaration_EPackage() && context instanceof GeneratedMetamodel)
			return createPackage((GeneratedMetamodel) context, (ILeafNode) node);
		if (ref == XtextPackage.eINSTANCE.getAbstractMetamodelDeclaration_EPackage() && context instanceof ReferencedMetamodel)
			return getPackage((ReferencedMetamodel)context, (ILeafNode) node);
		return super.getLinkedObjects(context, ref, node);
	}

	private List<EObject> getUsedGrammar(Grammar grammar, INode node) {
		try {
			String grammarName = (String) valueConverterService.toValue("", "GrammarID", node);
			if (grammarName != null) {
				final ResourceSet resourceSet = grammar.eResource().getResourceSet();
				for(Resource resource: resourceSet.getResources()) {
					if (!resource.getContents().isEmpty()) {
						EObject content = resource.getContents().get(0);
						if (content instanceof Grammar) {
							Grammar otherGrammar = (Grammar) content;
							if (grammarName.equals(otherGrammar.getName()))
								return Collections.<EObject>singletonList(otherGrammar);
						}
					}
				}
				URI classpathURI = URI.createURI(
						ClasspathUriUtil.CLASSPATH_SCHEME + ":/" + grammarName.replace('.', '/') + "." + fileExtension);
				URI normalizedURI = resourceSet.getURIConverter().normalize(classpathURI);
				final Resource resource = resourceSet.getResource(normalizedURI, true);
				final Grammar usedGrammar = (Grammar) resource.getContents().get(0);
				if (grammarName.equals(usedGrammar.getName()))
					return Collections.<EObject>singletonList(usedGrammar);
			}
			return Collections.emptyList();
		}
		catch (ClasspathUriResolutionException e) {
			log.debug("Cannot load used grammar." , e);
			return Collections.emptyList();
		} catch (ValueConverterException e) {
			log.debug("Cannot load used grammar." , e);
			return Collections.emptyList();
		}
	}

	private List<EObject> getPackage(ReferencedMetamodel context, ILeafNode text) {
		String nsUri = getMetamodelNsURI(text);
		if (nsUri == null)
			return Collections.emptyList();
		Grammar grammar = GrammarUtil.getGrammar(context);
		Set<Grammar> visitedGrammars = new HashSet<Grammar>();
		for (Grammar usedGrammar: grammar.getUsedGrammars()) {
			List<EObject> result = getPackage(nsUri, usedGrammar, visitedGrammars);
			if (result != null)
				return result;
		}
		QualifiedName packageNsURI = QualifiedName.create(nsUri);
		EPackage pack = findPackageInScope(context, packageNsURI);
		if (pack == null) {
			pack = findPackageInAllDescriptions(context, packageNsURI);
			if (pack == null) {
				pack = loadEPackage(nsUri, context.eResource().getResourceSet());
			}
		}
		if (pack != null)
			return Collections.<EObject>singletonList(pack);
		return Collections.emptyList();
	}
	
	private EPackage findPackageInScope(EObject context, QualifiedName packageNsURI) {
		IScope scopedPackages = scopeProvider.getScope(context.eResource(), XtextPackage.Literals.ABSTRACT_METAMODEL_DECLARATION__EPACKAGE, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return isNsUriIndexEntry(input);
			}
		});
		IEObjectDescription description = scopedPackages.getSingleElement(packageNsURI);
		if (description != null) {
			return getResolvedEPackage(description, context);
		}
		return null;
	}
	
	private EPackage getResolvedEPackage(IEObjectDescription description, EObject context) {
		EObject resolved = EcoreUtil.resolve(description.getEObjectOrProxy(), context);
		if (resolved != null && !resolved.eIsProxy() && resolved instanceof EPackage)
			return (EPackage) resolved;
		return null;
	}
	
	private EPackage findPackageInAllDescriptions(EObject context, QualifiedName packageNsURI) {
		IResourceDescriptions descriptions = descriptionsProvider.getResourceDescriptions(context.eResource());
		if (descriptions != null) {
			Iterable<IEObjectDescription> exported = descriptions.getExportedObjects(EcorePackage.Literals.EPACKAGE, packageNsURI, false);
			for(IEObjectDescription candidate: exported) {
				if (isNsUriIndexEntry(candidate)) {
					EPackage result = getResolvedEPackage(candidate, context);
					if (result != null)
						return result;
				}
			}
		}
		return null;
	}

	private boolean isNsUriIndexEntry(IEObjectDescription candidate) {
		return Boolean.TRUE.toString().equalsIgnoreCase(candidate.getUserData("nsURI"));
	}

	private List<EObject> getPackage(String nsUri, Grammar grammar, Set<Grammar> visitedGrammars) {
		if (!visitedGrammars.add(grammar))
			return null;
		for(AbstractMetamodelDeclaration declaration: grammar.getMetamodelDeclarations()) {
			EPackage pack = declaration.getEPackage();
			if (pack != null && nsUri.equals(pack.getNsURI()))
				return Collections.<EObject>singletonList(pack);
		}
		for (Grammar usedGrammar: grammar.getUsedGrammars()) {
			List<EObject> result = getPackage(nsUri, usedGrammar, visitedGrammars);
			if (result != null)
				return result;
		}
		return null;
	}

	private String getMetamodelNsURI(ILeafNode text) {
		try {
			return (String) valueConverterService.toValue(text.getText(), getLinkingHelper().getRuleNameFrom(text
					.getGrammarElement()), text);
		} catch (ValueConverterException e) {
			log.debug("Exception on leaf '" + text.getText() + "'", e);
			return null;
		}
	}

	private EPackage loadEPackage(String resourceOrNsURI, ResourceSet resourceSet) {
		if (resourceSet.getPackageRegistry().containsKey(resourceOrNsURI))
			return resourceSet.getPackageRegistry().getEPackage(resourceOrNsURI);
		URI uri = URI.createURI(resourceOrNsURI);
		try {
			if ("http".equalsIgnoreCase(uri.scheme()))
				return null;
			if (uri.fragment() == null) {
				Resource resource = resourceSet.getResource(uri, true);
				if (resource.getContents().isEmpty())
					return null;
				EPackage result = (EPackage) resource.getContents().get(0);
				return result;
			}
			EPackage result = (EPackage) resourceSet.getEObject(uri, true);
			return result;
		} catch(RuntimeException ex) {
			if (uri.isPlatformResource()) {
				String platformString = uri.toPlatformString(true);
				URI platformPluginURI = URI.createPlatformPluginURI(platformString, true);
				return loadEPackage(platformPluginURI.toString(), resourceSet);
			}
			log.trace("Cannot load package with URI '" + resourceOrNsURI + "'", ex);
			return null;
		}
	}

	private List<EObject> createPackage(GeneratedMetamodel generatedMetamodel, ILeafNode text) {
		final String nsURI = getMetamodelNsURI(text);
		final URI uri = URI.createURI(nsURI);
		if (uri == null || isReferencedByUsedGrammar(generatedMetamodel, nsURI))
			return Collections.emptyList();
		final EPackage generatedEPackage = EcoreFactory.eINSTANCE.createEPackage();
		generatedEPackage.setName(generatedMetamodel.getName());
		generatedEPackage.setNsPrefix(generatedMetamodel.getName());
		generatedEPackage.setNsURI(nsURI);
		final Resource generatedPackageResource = new EcoreResourceFactoryImpl().createResource(uri);
		generatedMetamodel.eResource().getResourceSet().getResources().add(generatedPackageResource);
		generatedPackageResource.getContents().add(generatedEPackage);
		return Collections.<EObject>singletonList(generatedEPackage);
	}

	private boolean isReferencedByUsedGrammar(GeneratedMetamodel generatedMetamodel, String nsURI) {
		final Grammar grammar = GrammarUtil.getGrammar(generatedMetamodel);
		if (grammar != null) {
			final Set<Grammar> visitedGrammars = Sets.newHashSet(grammar);
			for (Grammar usedGrammar: grammar.getUsedGrammars()) {
				if (isReferencedByUsedGrammar(usedGrammar, nsURI, visitedGrammars))
					return true;
			}
		}
		return false;
	}

	private boolean isReferencedByUsedGrammar(Grammar grammar, String nsURI, Set<Grammar> visitedGrammars) {
		if (!visitedGrammars.add(grammar)) 
			return false;
		for(AbstractMetamodelDeclaration decl: grammar.getMetamodelDeclarations()) {
			EPackage pack = decl.getEPackage();
			if (pack != null && nsURI.equals(pack.getNsURI())) {
				return true;
			}
		}
		for (Grammar usedGrammar: grammar.getUsedGrammars()) {
			if (isReferencedByUsedGrammar(usedGrammar, nsURI, visitedGrammars))
				return true;
		}
		return false;
	}

	private List<EObject> getLinkedMetaModel(TypeRef context, EReference ref, ILeafNode text) throws IllegalNodeException {
		final ICompositeNode parentNode = text.getParent();
		BidiIterator<INode> iterator = parentNode.getChildren().iterator();
		while(iterator.hasPrevious()) {
			INode child = iterator.previous();
			if (child instanceof ILeafNode) {
				ILeafNode leaf = (ILeafNode) child;
				if (text == leaf)
					return super.getLinkedObjects(context, ref, text);
				if (!(leaf.getGrammarElement() instanceof Keyword) && !leaf.isHidden()) {
					IScope scope = getScope(context, ref);
					return XtextMetamodelReferenceHelper.findBestMetamodelForType(
							context, text.getText(), leaf.getText(), scope);
				}
			}
		}
		return Collections.emptyList();
	}

}
