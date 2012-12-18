
package org.eclipse.xtext.xbase.ui.quickfix;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.NullProgressMonitor;
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
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;
import org.eclipse.jdt.internal.core.search.BasicSearchEngine;
import org.eclipse.jdt.internal.core.search.IRestrictedAccessTypeRequestor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.common.types.util.VisibilityService;
import org.eclipse.xtext.common.types.xtext.ui.JdtTypeRelevance;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.editor.quickfix.ReplaceModification;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.imports.IImportsConfiguration;
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable;
import org.eclipse.xtext.xbase.ui.imports.OrganizeImportsHandler;
import org.eclipse.xtext.xbase.ui.labeling.XbaseImages;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

public class XbaseQuickfixProvider extends DefaultQuickfixProvider {

	@Inject
	private OrganizeImportsHandler organizeImportsHandler;

	@Inject
	private IJavaProjectProvider projectProvider;

	@Inject
	private TypeReferences typeRefs;
	
	@Inject
	private VisibilityService visibilityService;
	
	@Inject
	private JdtTypeRelevance jdtTypeRelevance;
	
	@Inject
	private ReplacingAppendable.Factory appendableFactory;
	
	@Inject
	private IImportsConfiguration importsConfiguration;
	
	@Inject
	private XbaseImages images;
	
	@Fix(IssueCodes.IMPORT_DUPLICATE)
	public void fixDuplicateImport(final Issue issue, IssueResolutionAcceptor acceptor) {
		organizeImports(issue, acceptor);
	}

	@Fix(IssueCodes.IMPORT_UNUSED)
	public void fixUnusedImport(final Issue issue, IssueResolutionAcceptor acceptor) {
		organizeImports(issue, acceptor);
	}

	protected void organizeImports(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Organize Imports.",
				"Organizes the whole import section. Removes wildcard imports as well as duplicates and unused ones.",
				getOrganizeImportsImage(), new IModification() {
					public void apply(IModificationContext context) throws Exception {
						organizeImportsHandler.doOrganizeImports(context.getXtextDocument());
					}
				});
	}

	protected String getOrganizeImportsImage() {
		return "impc_obj.gif";
	}

	/**
	 * Filter quickfixes for types and constructors.
	 */
	@Override
	public void createLinkingIssueResolutions(final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor) {
		final IModificationContext modificationContext = getModificationContextFactory().createModificationContext(
				issue);
		final IXtextDocument xtextDocument = modificationContext.getXtextDocument();
		if (xtextDocument != null) {
			xtextDocument.readOnly(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource state) throws Exception {
					EObject target = state.getEObject(issue.getUriToProblem().fragment());
					EReference reference = getUnresolvedEReference(issue, target);
					if (reference == null)
						return;

					String issueString = xtextDocument.get(issue.getOffset(), issue.getLength());
					IScope scope = getScopeProvider().getScope(target, reference);
					boolean useJavaSearch = false;
					if (TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(reference.getEReferenceType()))
						useJavaSearch = true;
					if (TypesPackage.Literals.JVM_CONSTRUCTOR.isSuperTypeOf(reference.getEReferenceType()))
						useJavaSearch = true;
					if (useJavaSearch) {
						JvmDeclaredType jvmType = importsConfiguration.getContextJvmDeclaredType(target);
						IJavaSearchScope javaSearchScope = getJavaSearchScope(target);
						createImportProposals(jvmType, issue, issueString, javaSearchScope, issueResolutionAcceptor);
						scope = getImportedTypesScope(target, issueString, scope, javaSearchScope);
					}
					List<IEObjectDescription> discardedDescriptions = Lists.newArrayList();
					Set<String> qualifiedNames = Sets.newHashSet();
					int addedDescriptions = 0;
					int checkedDescriptions = 0;
					for (IEObjectDescription referableElement : queryScope(scope)) {
						String referableElementQualifiedName = getQualifiedNameConverter().toString(
								referableElement.getQualifiedName());
						if (useJavaSearch
								|| getSimilarityMatcher().isSimilar(issueString,
										getQualifiedNameConverter().toString(referableElement.getName()))) {
							addedDescriptions++;
							createResolution(issueString, referableElement);
							qualifiedNames.add(referableElementQualifiedName);
						} else {
							if (qualifiedNames.add(referableElementQualifiedName))
								discardedDescriptions.add(referableElement);
						}
						checkedDescriptions++;
						if (checkedDescriptions > 100)
							break;
					}
					if (discardedDescriptions.size() + addedDescriptions <= 5) {
						for (IEObjectDescription referableElement : discardedDescriptions) {
							createResolution(issueString, referableElement);
						}
					}
				}

				public void createResolution(String issueString, IEObjectDescription solution) {
					String replacement = getQualifiedNameConverter().toString(solution.getName());
					String replaceLabel = fixCrossReferenceLabel(issueString, replacement);
					issueResolutionAcceptor.accept(issue, replaceLabel, replaceLabel,
							fixCrossReferenceImage(issueString, replacement), new ReplaceModification(issue,
									replacement));
				}

			});
		}
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
					public void accept(String t) {
						visiblePackages.add(t);
					}
				}, new IAcceptor<String>() {
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
						QualifiedName qualifiedName = getQualifiedNameConverter().toQualifiedName(importedType);
						for (IEObjectDescription element : actualScope.getElements(qualifiedName)) {
							validProposals.add(new AliasedEObjectDescription(qualifiedName, element));
							break;
						}
					}
				}
			}
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
										typeNameBuilder.append('$');
									}
									typeNameBuilder.append(simpleTypeName);
									String typeName = typeNameBuilder.toString();
									if (isSimilarTypeName(misspelled, typeName)) {
										String fqNameAsString = getQualifiedTypeName(packageName, enclosingTypeNames,
												simpleTypeName);
										if (seen.add(fqNameAsString)) {
											QualifiedName qualifiedName = getQualifiedNameConverter().toQualifiedName(
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
			return new SimpleScope(validProposals);
		} catch (JavaModelException jme) {
			return IScope.NULLSCOPE;
		}
	}

	protected void parseImportSection(XImportSection importSection, IAcceptor<String> visiblePackages,
			IAcceptor<String> importedTypes) {
		for (XImportDeclaration importDeclaration : importSection.getImportDeclarations()) {
			if (!(importDeclaration.isStatic() || importDeclaration.isExtension())) {
				String importedAsString = importDeclaration.getImportedTypeName();
				if(importedAsString != null)
					importedTypes.accept(importedAsString);
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

	protected void createImportProposals(final JvmDeclaredType contextType, final Issue issue, final String typeSimpleName, IJavaSearchScope searchScope,
			final IssueResolutionAcceptor acceptor) throws JavaModelException {
		if(contextType != null){
			BasicSearchEngine searchEngine = new BasicSearchEngine();
			searchEngine.searchAllTypeNames(null, SearchPattern.R_EXACT_MATCH, typeSimpleName.toCharArray(),
					SearchPattern.R_EXACT_MATCH, IJavaSearchConstants.TYPE, searchScope, new IRestrictedAccessTypeRequestor() {
						
						public void acceptType(int modifiers, char[] packageName, char[] simpleTypeName, char[][] enclosingTypeNames,
								String path, AccessRestriction access) {
							final String qualifiedTypeName = getQualifiedTypeName(packageName, enclosingTypeNames,
									simpleTypeName);
							if(access == null || (access.getProblemId() != IProblem.ForbiddenReference && !access.ignoreIfBetter())){
								JvmType importType = typeRefs.findDeclaredType(qualifiedTypeName, contextType);
								if(importType instanceof JvmDeclaredType
										&& visibilityService.isVisible((JvmDeclaredType)importType, contextType)) {
									StringBuilder label = new StringBuilder("Import '");
									label.append(new String(simpleTypeName));
									label.append("' (");
									label.append(new String(packageName));
									if(enclosingTypeNames != null && enclosingTypeNames.length > 0) {
										boolean isFirst = true;
										for(char[] enclosingTypeName: enclosingTypeNames) {
											if(isFirst) 
												label.append(".");
											else 
												label.append("$");
											isFirst = false;
											label.append(new String(enclosingTypeName));
										}
									}
									label.append(")");
									acceptor.accept(issue, label.toString(), label.toString(), getOrganizeImportsImage(), new ISemanticModification() {
										@SuppressWarnings("null")
										public void apply(EObject element, IModificationContext context) throws Exception {
											ReplacingAppendable appendable = appendableFactory.get(context.getXtextDocument(),
													element, 0, 0);
											appendable.append(typeRefs.findDeclaredType(qualifiedTypeName, element));
											appendable.insertNewImports();
										}
									}, jdtTypeRelevance.getRelevance(qualifiedTypeName, typeSimpleName) + 100);
								}
							}
						}
					}, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());
		}
	}

}
