/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.quickfix;

import static org.eclipse.xtext.util.Strings.*;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.TypeNameRequestor;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.xtext.ui.JdtTypeRelevance;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.ISimilarityMatcher;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.editor.quickfix.ReplaceModification;
import org.eclipse.xtext.util.Arrays;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.annotations.validation.LinkingDiagnosticTypeAwareMessageProducer;
import org.eclipse.xtext.xbase.imports.IImportsConfiguration;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.ContextualVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable;
import org.eclipse.xtext.xbase.ui.document.DocumentRewriter;
import org.eclipse.xtext.xbase.ui.document.DocumentRewriter.Section;
import org.eclipse.xtext.xbase.ui.imports.ReplaceConverter;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Quickfixes for misspelled or not yet imported Java types.
 *  
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JavaTypeQuickfixes implements ILinkingIssueQuickfixProvider {
	
	@Inject
	private IScopeProvider scopeProvider;
	
	@Inject
	private IImportsConfiguration importsConfiguration;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private ISimilarityMatcher similarityMatcher;
	
	@Inject
	private IJavaProjectProvider projectProvider;

	@Inject
	private CommonTypeComputationServices services;

	@Inject
	private JdtTypeRelevance jdtTypeRelevance;
	
	@Inject
	private ReplacingAppendable.Factory appendableFactory;
	
	@Inject
	private TypeNameGuesser typeNameGuesser;
	
	@Inject
	private DocumentRewriter.Factory rewriterFactory;

	@Inject 
	private ReplaceConverter replaceConverter;

	@Override
	public void addQuickfixes(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor,
			IXtextDocument xtextDocument, XtextResource resource, 
			EObject referenceOwner, EReference unresolvedReference)
			throws Exception {
		String issueString = xtextDocument.get(issue.getOffset(), issue.getLength());
		IScope scope = scopeProvider.getScope(referenceOwner, unresolvedReference);
		boolean useJavaSearch = isUseJavaSearch(unresolvedReference, issue);
		if (useJavaSearch) {
			JvmDeclaredType jvmType = importsConfiguration.getContextJvmDeclaredType(referenceOwner);
			IJavaSearchScope javaSearchScope = getJavaSearchScope(referenceOwner);
			boolean proposeImports = true;
			if(isConstructorReference(unresolvedReference))
				proposeImports = !createConstructorProposals(jvmType, issue, issueString, javaSearchScope, issueResolutionAcceptor);
			if(proposeImports)
				createImportProposals(jvmType, issue, issueString, javaSearchScope, issueResolutionAcceptor);
			scope = getImportedTypesScope(referenceOwner, issueString, scope, javaSearchScope);
		}
		List<IEObjectDescription> discardedDescriptions = Lists.newArrayList();
		Set<String> proposedSolutions = Sets.newHashSet();
		int addedDescriptions = 0;
		int checkedDescriptions = 0;
		for (IEObjectDescription referableElement : scope.getAllElements()) {
			String solution = qualifiedNameConverter.toString(referableElement.getName());
			if(!equal(issueString, solution) && proposedSolutions.add(solution)) {
				if (useJavaSearch || similarityMatcher.isSimilar(issueString, solution)) {
					addedDescriptions++;
					createResolution(issue, issueResolutionAcceptor, issueString, referableElement);
					proposedSolutions.add(solution);
				} else {
					discardedDescriptions.add(referableElement);
				}
			}
			checkedDescriptions++;
			if (checkedDescriptions > 100)
				break;
		}
		if (discardedDescriptions.size() + addedDescriptions <= 5) {
			for (IEObjectDescription referableElement : discardedDescriptions) {
				createResolution(issue, issueResolutionAcceptor, issueString, referableElement);
			}
		}
	}

	protected boolean isUseJavaSearch(EReference unresolvedReference, Issue issue) {
		if (isConstructorReference(unresolvedReference))
			return true;
		if (isTypeReference(unresolvedReference))
			return true;
		if (Arrays.contains(issue.getData(), LinkingDiagnosticTypeAwareMessageProducer.TYPE_LITERAL)) {
			return true;
		}
		return false;
	}

	protected boolean isTypeReference(EReference unresolvedReference) {
		return TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(unresolvedReference.getEReferenceType());
	}

	protected boolean isConstructorReference(EReference unresolvedReference) {
		return TypesPackage.Literals.JVM_CONSTRUCTOR.isSuperTypeOf(unresolvedReference.getEReferenceType());
	}

	protected void createResolution(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor, String issueString, IEObjectDescription solution) {
		String replacement = qualifiedNameConverter.toString(solution.getName());
		String replaceLabel = "Change to '" + replacement + "'";
		issueResolutionAcceptor.accept(issue, replaceLabel, replaceLabel,
				null, new ReplaceModification(issue, replacement));
	}

	protected IJavaSearchScope getJavaSearchScope(EObject model) {
		if (model == null || model.eResource() == null || model.eResource().getResourceSet() == null) {
			return null;
		} else {
			IJavaProject javaProject = projectProvider.getJavaProject(model.eResource().getResourceSet());
			IJavaSearchScope searchScope = SearchEngine.createJavaSearchScope(new IJavaElement[] { javaProject });
			return searchScope;
		}
	}

	protected IScope getImportedTypesScope(EObject model, final String misspelled, final IScope actualScope,
			IJavaSearchScope scope) {
		if (scope == null) {
			return IScope.NULLSCOPE;
		}
		try {
			final Set<String> visiblePackages = importsConfiguration.getImplicitlyImportedPackages((XtextResource) model.eResource());
			final Set<String> importedTypes = Sets.newHashSet();
			final Set<String> seen = Sets.newHashSet();
			XImportSection importSection = importsConfiguration.getImportSection((XtextResource) model.eResource());
			if(importSection != null) {
				parseImportSection(importSection, new IAcceptor<String>() {
					@Override
					public void accept(String t) {
						visiblePackages.add(t);
					}
				}, new IAcceptor<String>() {
					@Override
					public void accept(String t) {
						importedTypes.add(t);
					}
				});
			}
			SearchEngine searchEngine = new SearchEngine();
			final List<IEObjectDescription> validProposals = Lists.newArrayList();
			for (String importedType : importedTypes) {
				if (validProposals.size() <= 5 && seen.add(importedType)) {
					int dot = importedType.lastIndexOf('.');
					if (dot != -1) {
						importedType = importedType.substring(dot + 1);
					}
					if (isSimilarTypeName(misspelled, importedType)) {
						QualifiedName qualifiedName = qualifiedNameConverter.toQualifiedName(importedType);
						for (IEObjectDescription element : actualScope.getElements(qualifiedName)) {
							validProposals.add(new AliasedEObjectDescription(qualifiedName, element));
							break;
						}
					}
				}
			}
			try {
				for (String visiblePackage : visiblePackages) {
					if (validProposals.size() <= 5) {
						searchEngine.searchAllTypeNames(visiblePackage.toCharArray(), SearchPattern.R_EXACT_MATCH, null,
								SearchPattern.R_EXACT_MATCH, IJavaSearchConstants.TYPE, scope, new TypeNameRequestor() {
									@Override
									public void acceptType(int modifiers, char[] packageName, char[] simpleTypeName,
											char[][] enclosingTypeNames, String path) {
										StringBuilder typeNameBuilder = new StringBuilder(simpleTypeName.length);
										for (char[] enclosingType : enclosingTypeNames) {
											typeNameBuilder.append(enclosingType);
											typeNameBuilder.append('.');
										}
										typeNameBuilder.append(simpleTypeName);
										String typeName = typeNameBuilder.toString();
										if (isSimilarTypeName(misspelled, typeName)) {
											String fqNameAsString = getQualifiedTypeName(packageName, enclosingTypeNames,
													simpleTypeName);
											if (seen.add(fqNameAsString)) {
												QualifiedName qualifiedName = qualifiedNameConverter.toQualifiedName(
														typeName);
												for (IEObjectDescription element : actualScope.getElements(qualifiedName)) {
													validProposals
															.add(new AliasedEObjectDescription(qualifiedName, element));
													break;
												}
											}
										}
									}
		
								}, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor() {
									@Override
									public boolean isCanceled() {
										return validProposals.size() > 5;
									}
								});
					}
				}
			} catch(OperationCanceledException exc) {
				// enough proposals
			}
			return new SimpleScope(validProposals);
		} catch (JavaModelException jme) {
			return IScope.NULLSCOPE;
		}
	}

	protected void parseImportSection(XImportSection importSection, IAcceptor<String> visiblePackages,
			IAcceptor<String> importedTypes) {
		for (XImportDeclaration importDeclaration : importSection.getImportDeclarations()) {
			if (!importDeclaration.isStatic()) {
				if (importDeclaration.getImportedNamespace() != null) {
					String importedAsString = importDeclaration.getImportedNamespace();
					if (importDeclaration.isWildcard()) {
						importedAsString = importedAsString.substring(0, importedAsString.length() - 2);
						visiblePackages.accept(importedAsString);
					} else {
						importedTypes.accept(importedAsString);
					}
				} else {
					importedTypes.accept(importDeclaration.getImportedTypeName());
				}
			}
		}
	}

	protected boolean isSimilarTypeName(String s0, String s1) {
		double levenshteinDistance = StringUtils.getLevenshteinDistance(s0, s1);
		return levenshteinDistance <= 3;
	}

	protected String getQualifiedTypeName(char[] packageName, char[][] enclosingTypeNames, char[] simpleTypeName) {
		StringBuilder fqName = new StringBuilder(packageName.length + simpleTypeName.length + 1);
		if (packageName.length != 0) {
			fqName.append(packageName);
			fqName.append('.');
		}
		for (char[] enclosingType : enclosingTypeNames) {
			fqName.append(enclosingType);
			fqName.append('$');
		}
		fqName.append(simpleTypeName);
		String fqNameAsString = fqName.toString();
		return fqNameAsString;
	}

	@SuppressWarnings("restriction")
	protected void createImportProposals(final JvmDeclaredType contextType, final Issue issue, String typeName, IJavaSearchScope searchScope,
			final IssueResolutionAcceptor acceptor) throws JavaModelException {
		if(contextType != null) {
			final IVisibilityHelper visibilityHelper = getVisibilityHelper(contextType);
			final Pair<String, String> packageAndType = typeNameGuesser.guessPackageAndTypeName(contextType, typeName);
			final String wantedPackageName = packageAndType.getFirst();
			org.eclipse.jdt.internal.core.search.BasicSearchEngine searchEngine = new org.eclipse.jdt.internal.core.search.BasicSearchEngine();
			final char[] wantedPackageChars = (isEmpty(wantedPackageName)) ? null : wantedPackageName.toCharArray();
			final String wantedTypeName = packageAndType.getSecond();
			searchEngine.searchAllTypeNames(wantedPackageChars, SearchPattern.R_EXACT_MATCH, wantedTypeName.toCharArray(),
					SearchPattern.R_EXACT_MATCH, IJavaSearchConstants.TYPE, searchScope, new org.eclipse.jdt.internal.core.search.IRestrictedAccessTypeRequestor() {
						
						@Override
						public void acceptType(int modifiers, char[] packageName, char[] simpleTypeName, char[][] enclosingTypeNames,
								String path, org.eclipse.jdt.internal.compiler.env.AccessRestriction access) {
							final String qualifiedTypeName = getQualifiedTypeName(packageName, enclosingTypeNames,
									simpleTypeName);
							if(access == null || (access.getProblemId() != IProblem.ForbiddenReference && !access.ignoreIfBetter())){
								JvmType importType = services.getTypeReferences().findDeclaredType(qualifiedTypeName, contextType);
								if(importType instanceof JvmDeclaredType
										&& visibilityHelper.isVisible((JvmDeclaredType)importType)) {
									StringBuilder label = new StringBuilder("Import '");
									label.append(simpleTypeName);
									label.append("' (");
									label.append(packageName);
									if(enclosingTypeNames.length > 0) {
										for(char[] enclosingTypeName: enclosingTypeNames) {
											label.append(".");
											label.append(enclosingTypeName);
										}
									}
									label.append(")");
									acceptor.accept(issue, label.toString(), label.toString(), "impc_obj.gif", new ISemanticModification() {
										@Override
										public void apply(EObject element, IModificationContext context) throws Exception {
											ReplacingAppendable appendable = appendableFactory.create(context.getXtextDocument(),
													(XtextResource) element.eResource(), 0, 0);
											appendable.append(services.getTypeReferences().findDeclaredType(qualifiedTypeName, element));
											appendable.insertNewImports();
										}
									}, jdtTypeRelevance.getRelevance(qualifiedTypeName, wantedTypeName) + 100);
								}
							}
						}
					}, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());
		}
	}

	protected ContextualVisibilityHelper getVisibilityHelper(final JvmDeclaredType contextType) {
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, contextType);
		final ParameterizedTypeReference contextTypeRef =  owner.newParameterizedTypeReference(contextType);
		final ContextualVisibilityHelper visibilityHelper = new ContextualVisibilityHelper(contextTypeRef);
		return visibilityHelper;
	}
	
	@SuppressWarnings("restriction")
	protected boolean createConstructorProposals(final JvmDeclaredType contextType, final Issue issue, String typeName,
			IJavaSearchScope searchScope, final IssueResolutionAcceptor acceptor) throws JavaModelException {
		final boolean[] result = new boolean[] { false };
		if(contextType != null) {
			final IVisibilityHelper visibilityHelper = getVisibilityHelper(contextType);
			final Pair<String, String> packageAndType = typeNameGuesser.guessPackageAndTypeName(contextType, typeName);
			final String wantedPackageName = packageAndType.getFirst();
			final String wantedTypeName = packageAndType.getSecond();
			if (typeName.endsWith(wantedTypeName)) {
				return false;
			}
			org.eclipse.jdt.internal.core.search.BasicSearchEngine searchEngine = new org.eclipse.jdt.internal.core.search.BasicSearchEngine();
			final char[] wantedPackageChars = (isEmpty(wantedPackageName)) ? null : wantedPackageName.toCharArray();
			searchEngine.searchAllTypeNames(wantedPackageChars, SearchPattern.R_EXACT_MATCH, wantedTypeName.toCharArray(),
					SearchPattern.R_EXACT_MATCH, IJavaSearchConstants.TYPE, searchScope, new org.eclipse.jdt.internal.core.search.IRestrictedAccessTypeRequestor() {
						
						@Override
						public void acceptType(int modifiers, char[] packageName, char[] simpleTypeName, char[][] enclosingTypeNames,
								String path, org.eclipse.jdt.internal.compiler.env.AccessRestriction access) {
							final String qualifiedTypeName = getQualifiedTypeName(packageName, enclosingTypeNames,
									simpleTypeName);
							if(access == null || (access.getProblemId() != IProblem.ForbiddenReference && !access.ignoreIfBetter())){
								JvmType importType = services.getTypeReferences().findDeclaredType(qualifiedTypeName, contextType);
								if(importType instanceof JvmDeclaredType
										&& visibilityHelper.isVisible((JvmDeclaredType)importType)) {
									result[0] = true;
									StringBuilder label = new StringBuilder("Change to constructor call 'new ");
									label.append(simpleTypeName);
									label.append("()'");
									if(!equal(wantedPackageName, new String(packageName))) {
										label.append(" (");
										label.append(packageName);
										if(enclosingTypeNames.length > 0) {
											for(char[] enclosingTypeName: enclosingTypeNames) {
												label.append(".");
												label.append(enclosingTypeName);
											}
										}
										label.append(")");
									}
									acceptor.accept(issue, label.toString(), label.toString(), "impc_obj.gif", new ISemanticModification() {
										@Override
										public void apply(EObject element, IModificationContext context) throws Exception {
											IXtextDocument document = context.getXtextDocument();
											DocumentRewriter rewriter = rewriterFactory.create(document,
													(XtextResource) element.eResource());
											final int typeEndOffset = document.get().indexOf(wantedTypeName, 
													issue.getOffset() + wantedPackageName.length()) + wantedTypeName.length();
											final Section section = rewriter.newSection(issue.getOffset(), typeEndOffset - issue.getOffset());
											section.append(services.getTypeReferences().findDeclaredType(qualifiedTypeName, element));
											section.append("()");
											final TextEdit textEdit = replaceConverter.convertToTextEdit(rewriter.getChanges());
											textEdit.apply(document);
										}
									}, jdtTypeRelevance.getRelevance(qualifiedTypeName, wantedTypeName) + 100);
								}
							}
						}
					}, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());
		}
		return result[0];
	}
}
