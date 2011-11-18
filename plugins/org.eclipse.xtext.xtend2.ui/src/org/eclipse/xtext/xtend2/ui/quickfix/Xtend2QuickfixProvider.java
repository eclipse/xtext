/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.quickfix;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.TypeNameRequestor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
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
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xtend2.formatting.OverrideFunction;
import org.eclipse.xtext.xtend2.services.Xtend2GrammarAccess;
import org.eclipse.xtext.xtend2.ui.contentassist.ReplacingAppendable;
import org.eclipse.xtext.xtend2.ui.edit.OrganizeImportsHandler;
import org.eclipse.xtext.xtend2.validation.IssueCodes;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendImport;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Quickfixes for inconsistent indentation
 * @author Sebastian Zarnekow - Quickfixes for misspelled types and constructors
 */
public class Xtend2QuickfixProvider extends DefaultQuickfixProvider {

	@Inject
	private IJavaProjectProvider projectProvider;

	@Inject
	private OverrideFunction overrideFunction;

	@Inject
	private Xtend2GrammarAccess grammarAccess;

	@Inject
	private TypeReferences typeReferences;

	@Inject
	private OrganizeImportsHandler organizeImportsHandler;

	@Inject
	private ReplacingAppendable.Factory appendableFactory;

	@Inject
	private TypeReferenceSerializer typeRefSerializer;

	@Inject
	private TypeReferences typeRefs;

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
						IJavaSearchScope javaSearchScope = getJavaSearchScope(target);
						createImportProposals(issue, issueString, javaSearchScope, issueResolutionAcceptor);
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
			XtendFile xtendFile = EcoreUtil2.getContainerOfType(model, XtendFile.class);
			Set<String> visiblePackages = Sets.newHashSet("java.lang");
			visiblePackages.add("");
			if (xtendFile.getPackage() != null) {
				visiblePackages.add(xtendFile.getPackage());
			}
			Set<String> importedTypes = Sets.newHashSet();
			final Set<String> seen = Sets.newHashSet();
			for (XtendImport importedNamespace : xtendFile.getImports()) {
				if (importedNamespace.getImportedNamespace() != null) {
					String importedAsString = importedNamespace.getImportedNamespace();
					if (importedNamespace.isWildcard()) {
						importedAsString = importedAsString.substring(0, importedAsString.length() - 2);
						if (!importedNamespace.isStatic()) {
							visiblePackages.add(importedAsString);
						} else {
							importedTypes.add(importedAsString);
						}
					} else {
						importedTypes.add(importedAsString);
					}
				}
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

	protected void createImportProposals(final Issue issue, String typeSimpleName, IJavaSearchScope searchScope,
			final IssueResolutionAcceptor acceptor) throws JavaModelException {
		SearchEngine searchEngine = new SearchEngine();
		searchEngine.searchAllTypeNames(null, SearchPattern.R_EXACT_MATCH, typeSimpleName.toCharArray(),
				SearchPattern.R_EXACT_MATCH, IJavaSearchConstants.TYPE, searchScope, new TypeNameRequestor() {
					@Override
					public void acceptType(int modifiers, char[] packageName, char[] simpleTypeName,
							char[][] enclosingTypeNames, String path) {
						final String qualifiedTypeName = getQualifiedTypeName(packageName, enclosingTypeNames,
								simpleTypeName);
						String label = "Import '" + new String(simpleTypeName) + "' (" + new String(packageName) + ")";
						acceptor.accept(issue, label, label, "fix_indent.gif", new ISemanticModification() {
							public void apply(EObject element, IModificationContext context) throws Exception {
								ReplacingAppendable appendable = appendableFactory.get(context.getXtextDocument(),
										element, 0, 0);
								appendable.append(typeReferences.findDeclaredType(qualifiedTypeName, element));
								appendable.insertNewImports();
							}
						});
					}
				}, IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());
	}

	@Fix(IssueCodes.INCONSISTENT_INDENTATION)
	public void fixIndentation(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Correct indentation", "Correctly indents this line in this rich string",
				"fix_indent.gif", new IModification() {
					public void apply(IModificationContext context) throws Exception {
						context.getXtextDocument().replace(issue.getOffset(), issue.getLength(), issue.getData()[0]);
					}
				});
	}

	@Fix(IssueCodes.IMPORT_DUPLICATE)
	public void fixDuplicateImport(final Issue issue, IssueResolutionAcceptor acceptor) {
		organizeImports(issue, acceptor);
	}

	@Fix(IssueCodes.IMPORT_WILDCARD_DEPRECATED)
	public void fixDuplicateWildcardUse(final Issue issue, IssueResolutionAcceptor acceptor) {
		organizeImports(issue, acceptor);
	}

	@Fix(IssueCodes.IMPORT_UNUSED)
	public void fixUnusedImport(final Issue issue, IssueResolutionAcceptor acceptor) {
		organizeImports(issue, acceptor);
	}

	protected void organizeImports(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Organize Imports.",
				"Organizes the whole import section. Removes wildcard imports as well as duplicates and unused ones.",
				"fix_indent.gif", new IModification() {
					public void apply(IModificationContext context) throws Exception {
						organizeImportsHandler.doOrganizeImports(context.getXtextDocument());
					}
				});
	}

	@Fix(IssueCodes.MISSING_OVERRIDE)
	public void fixMissingOverride(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Change 'def' to 'override'", "Marks this function as 'override'", "fix_indent.gif",
				new ISemanticModification() {
					public void apply(EObject element, IModificationContext context) throws Exception {
						replaceKeyword(grammarAccess.getMemberAccess().findKeywords("def").get(0), "override", element,
								context.getXtextDocument());
					}
				});
	}

	@Fix(IssueCodes.OBSOLETE_OVERRIDE)
	public void fixObsoleteOverride(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Change 'override' to 'def'", "Removes 'override' from this function", "fix_indent.gif",
				new ISemanticModification() {
					public void apply(EObject element, IModificationContext context) throws Exception {
						replaceKeyword(grammarAccess.getMemberAccess().findKeywords("override").get(0), "def", element,
								context.getXtextDocument());
					}
				});
	}

	protected void replaceKeyword(Keyword keyword, String replacement, EObject container, IXtextDocument document)
			throws BadLocationException {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(container);
		for (ILeafNode leafNode : node.getLeafNodes()) {
			if (leafNode.getGrammarElement() == keyword) {
				String actualReplacement = replacement;
				if (!Character.isWhitespace(document.getChar(leafNode.getOffset() - 1))) {
					actualReplacement = " " + replacement;
				}
				document.replace(leafNode.getOffset(), leafNode.getLength(), actualReplacement);
			}
		}
	}

	@Fix(IssueCodes.CLASS_MUST_BE_ABSTRACT)
	public void implementAbstractMethods(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData() != null && issue.getData().length > 0)
			acceptor.accept(issue, "Implement abstract methods", "Implement abstract methods", "fix_indent.gif",
					new ISemanticModification() {
						public void apply(EObject element, IModificationContext context) throws Exception {
							XtendClass clazz = (XtendClass) element;
							ReplacingAppendable appendable = appendableFactory.get(context.getXtextDocument(), clazz,
									overrideFunction.getFunctionInsertOffset(clazz), 0);
							for (String operationUriAsString : issue.getData()) {
								URI operationURI = URI.createURI(operationUriAsString);
								EObject overridden = clazz.eResource().getResourceSet().getEObject(operationURI, true);
								if (overridden instanceof JvmOperation) {
									overrideFunction.appendOverrideFunction(clazz, (JvmOperation) overridden,
											appendable);
								}
							}
							appendable.commitChanges();
						}
					});
	}

	@Fix(org.eclipse.xtext.xbase.validation.IssueCodes.UNHANDLED_EXCEPTION)
	public void addThrowsDeclaration(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData() != null && issue.getData().length > 0)
			acceptor.accept(issue, "Add throws declaration", "Add throws declaration", "fix_indent.gif",
					new ISemanticModification() {
						public void apply(EObject element, IModificationContext context) throws Exception {
							URI exceptionURI = URI.createURI(issue.getData()[0]);
							XtendFunction xtendFunction = EcoreUtil2.getContainerOfType(element, XtendFunction.class);
							XtextResource xtextResource = (XtextResource) xtendFunction.eResource();
							EObject exception = xtextResource.getResourceSet().getEObject(exceptionURI, true);
							if (exception instanceof JvmType) {
								JvmType exceptionType = (JvmType) exception;
								int insertPosition;
								if (xtendFunction.getExpression() == null) {
									ICompositeNode functionNode = NodeModelUtils.findActualNodeFor(xtendFunction);
									insertPosition = functionNode.getOffset() + functionNode.getLength();
								} else {
									insertPosition = NodeModelUtils.findActualNodeFor(xtendFunction.getExpression())
											.getOffset();
								}
								ReplacingAppendable appendable = appendableFactory.get(context.getXtextDocument(),
										xtendFunction, insertPosition, 0);
								if (xtendFunction.getExpression() == null) 
									appendable.append(" ");
								EList<JvmTypeReference> thrownExceptions = xtendFunction.getExceptions();
								if (thrownExceptions.isEmpty())
									appendable.append("throws ");
								else
									appendable.append(", ");
								typeRefSerializer.serialize(typeRefs.createTypeRef(exceptionType), xtendFunction,
										appendable);
								if (xtendFunction.getExpression() != null) 
									appendable.append(" ");
								appendable.commitChanges();
							}
						}
					});
	}

	@Fix(org.eclipse.xtext.xbase.validation.IssueCodes.UNHANDLED_EXCEPTION)
	public void surroundWithTryCatch(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData() != null && issue.getData().length > 1)
			acceptor.accept(issue, "Surround with try/catch block", "Surround with try/catch block", "fix_indent.gif",
					new ISemanticModification() {
						public void apply(EObject element, IModificationContext context) throws Exception {
							URI exceptionURI = URI.createURI(issue.getData()[0]);
							URI childURI = URI.createURI(issue.getData()[1]);
							XtextResource xtextResource = (XtextResource) element.eResource();
							EObject exception = xtextResource.getResourceSet().getEObject(exceptionURI, true);
							if (exception instanceof JvmType) {
								JvmType exceptionType = (JvmType) exception;
								EObject childThrowingException = xtextResource.getResourceSet().getEObject(childURI,
										true);
								XExpression toBeSurrounded = findContainerExpressionInBlockExpression(childThrowingException);
								IXtextDocument xtextDocument = context.getXtextDocument();
								if (toBeSurrounded != null) {
									ICompositeNode toBeSurroundedNode = NodeModelUtils
											.findActualNodeFor(toBeSurrounded);
									ReplacingAppendable appendable = appendableFactory.get(context.getXtextDocument(),
											childThrowingException, toBeSurroundedNode.getOffset(),
											toBeSurroundedNode.getLength());
									appendable
											.append("try {")
											.increaseIndentation()
											.append("\n")
											.append(xtextDocument.get(toBeSurroundedNode.getOffset(),
													toBeSurroundedNode.getLength())).decreaseIndentation()
											.append("\n} catch (");
									typeRefSerializer.serialize(typeRefs.createTypeRef(exceptionType),
											childThrowingException, appendable);
									appendable.append(" ");
									String exceptionVar = appendable.declareVariable(exceptionType, "exc");
									appendable.append(exceptionVar).append(") {").increaseIndentation()
											.append("\nthrow new RuntimeException(\"auto-generated try/catch\")")
											.decreaseIndentation().append("\n}").closeScope();
									appendable.commitChanges();
								}
							}
						}
					});
	}

	protected XExpression findContainerExpressionInBlockExpression(EObject expr) {
		if (expr == null)
			return null;
		EObject container = expr.eContainer();
		if (container instanceof XBlockExpression)
			return (XExpression) expr;
		else
			return findContainerExpressionInBlockExpression(container);
	}

}
