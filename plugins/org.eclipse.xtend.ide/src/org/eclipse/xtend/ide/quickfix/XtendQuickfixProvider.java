/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.quickfix;

import static com.google.common.collect.Sets.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.ide.buildpath.XtendLibClasspathAdder;
import org.eclipse.xtend.ide.codebuilder.InsertionOffsets;
import org.eclipse.xtend.ide.codebuilder.MemberFromSuperImplementor;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.util.StopWatch;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.output.XtypeTypeReferenceSerializer;
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable;
import org.eclipse.xtext.xbase.ui.quickfix.XbaseQuickfixProvider;

import com.google.inject.Inject;
/**
 * @author Jan Koehnlein - Quickfixes for inconsistent indentation
 * @author Sebastian Zarnekow - Quickfixes for misspelled types and constructors
 * @author Holger Schill - Quickfixes for missing methods / fields / localVars
 */
public class XtendQuickfixProvider extends XbaseQuickfixProvider {

	private static final Logger logger = Logger.getLogger(XtendQuickfixProvider.class);
	
	@Inject	private ReplacingAppendable.Factory appendableFactory;
	
	@Inject	private XtypeTypeReferenceSerializer typeRefSerializer;
	
	@Inject	private TypeReferences typeRefs;
	
	@Inject private XtendGrammarAccess grammarAccess;
	
	@Inject private InsertionOffsets insertionOffsets;

	@Inject private MemberFromSuperImplementor superMemberImplementor;
	
	@Inject	private XtendLibClasspathAdder xtendLibAdder;
	
	@Inject private IJavaProjectProvider projectProvider;

	@Inject private CreateXtendTypeQuickfixes createTypeQuickfixes;

	@Inject private CreateMemberQuickfixes createMemberQuickfixes;
	
	private static final Set<String> LINKING_ISSUE_CODES = newHashSet(
			IssueCodes.FEATURECALL_LINKING_DIAGNOSTIC, 
			Diagnostic.LINKING_DIAGNOSTIC,
			org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_ARGUMENT_TYPES,
			org.eclipse.xtext.xbase.validation.IssueCodes.INVALID_NUMBER_OF_ARGUMENTS);
	
	@Override
	public boolean hasResolutionFor(String issueCode) {
		return LINKING_ISSUE_CODES.contains(issueCode) || super.hasResolutionFor(issueCode);
	}

	@Override
	public List<IssueResolution> getResolutions(Issue issue) {
		StopWatch stopWatch = new StopWatch(logger);
		try {
			if(LINKING_ISSUE_CODES.contains(issue.getCode())){
				List<IssueResolution> result = new ArrayList<IssueResolution>();
				result.addAll(getResolutionsForLinkingIssue(issue));
				return result;
			} else
				return super.getResolutions(issue);
		} finally {
			stopWatch.resetAndLog("#getResolutions");
		}
	}
	
	@Override
	protected void createLinkingIssueQuickfixes(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor, 
			IXtextDocument xtextDocument, XtextResource resource, 
			EObject referenceOwner, EReference unresolvedReference) throws Exception {
		super.createLinkingIssueQuickfixes(issue, issueResolutionAcceptor, xtextDocument, resource, referenceOwner, unresolvedReference);
		createTypeQuickfixes.addQuickfixes(issue, issueResolutionAcceptor, xtextDocument, resource, referenceOwner, unresolvedReference);
		createMemberQuickfixes.addQuickfixes(issue, issueResolutionAcceptor, xtextDocument, resource, referenceOwner, unresolvedReference);
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
		if (node != null) {
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
	}

	@Fix(IssueCodes.MISSING_CONSTRUCTOR)
	public void addConstuctorFromSuper(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData() != null) {
			for(int i=0; i<issue.getData().length; i+=2) {
				final URI constructorURI = URI.createURI(issue.getData()[i]);
				String javaSignature = issue.getData()[i+1];
				String xtendSignature = "new" + javaSignature.substring(javaSignature.indexOf('('));
				acceptor.accept(issue, "Add constructor " + xtendSignature, "Add constructor " + xtendSignature, "fix_indent.gif",
					new ISemanticModification() {
						public void apply(EObject element, IModificationContext context) throws Exception {
							XtendClass clazz = (XtendClass) element;
							ReplacingAppendable appendable = appendableFactory.get(context.getXtextDocument(), clazz,
									insertionOffsets.getNewConstructorInsertOffset(null, clazz), 0);
							EObject constructor = clazz.eResource().getResourceSet().getEObject(constructorURI, true);
							appendable.increaseIndentation().newLine();
							if (constructor instanceof JvmConstructor) {
								superMemberImplementor.appendConstructorFromSuper(clazz, (JvmConstructor) constructor,
										appendable);
							}
							appendable.decreaseIndentation().newLine();
							appendable.commitChanges();
						}
					});
			}
		}
	}
	
	@Fix(IssueCodes.CLASS_MUST_BE_ABSTRACT)
	public void implementAbstractMethods(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData() != null && issue.getData().length > 0) {
			acceptor.accept(issue, "Add unimplemented methods", "Add unimplemented methods", "fix_indent.gif",
					new ISemanticModification() {
						public void apply(EObject element, IModificationContext context) throws Exception {
							XtendClass clazz = (XtendClass) element;
							IXtextDocument document = context.getXtextDocument();
							ReplacingAppendable appendable = appendableFactory.get(document, clazz,
									insertionOffsets.getNewMethodInsertOffset(null, clazz), 0);
							appendable.increaseIndentation();
							for (String operationUriAsString : issue.getData()) {
								URI operationURI = URI.createURI(operationUriAsString);
								EObject overridden = clazz.eResource().getResourceSet().getEObject(operationURI, true);
								if (overridden instanceof JvmOperation) {
									appendable.newLine();
									superMemberImplementor.appendOverrideFunction(clazz, (JvmOperation) overridden,
											appendable);
									appendable.newLine();
								}
							}
							appendable.decreaseIndentation();
							appendable.newLine();
							appendable.commitChanges();
						}
					});
		}
		acceptor.accept(issue, "Make class abstract", "Make class abstract", "fix_indent.gif",
				new ISemanticModification() {
			public void apply(EObject element, IModificationContext context) throws Exception {
				internalDoAddAbstractKeyword(element, context);
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
									if (functionNode == null)
										throw new IllegalStateException("functionNode may not be null");
									insertPosition = functionNode.getOffset() + functionNode.getLength();
								} else {
									ICompositeNode expressionNode = NodeModelUtils.findActualNodeFor(xtendFunction.getExpression());
									if (expressionNode == null)
										throw new IllegalStateException("expressionNode may not be null");
									insertPosition = expressionNode.getOffset();
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
									ICompositeNode toBeSurroundedNode = NodeModelUtils.findActualNodeFor(toBeSurrounded);
									if (toBeSurroundedNode == null)
										throw new IllegalStateException("toBeSurroundedNode may not be null");
									ReplacingAppendable appendable = appendableFactory.get(
											context.getXtextDocument(),
											childThrowingException, 
											toBeSurroundedNode.getOffset(),
											toBeSurroundedNode.getLength());
									appendable
											.append("try {")
											.increaseIndentation()
												.newLine()
												.append(xtextDocument.get(toBeSurroundedNode.getOffset(),
														toBeSurroundedNode.getLength()))
											.decreaseIndentation()
											.newLine()
											.append("} catch (");
									typeRefSerializer.serialize(typeRefs.createTypeRef(exceptionType),
											childThrowingException, appendable);
									appendable.append(" ");
									String exceptionVar = appendable.declareVariable(exceptionType, "exc");
									appendable.append(exceptionVar)
											.append(") {")
											.increaseIndentation()
												.newLine()
												.append("throw new RuntimeException(\"auto-generated try/catch\")")
											.decreaseIndentation()
											.newLine()
											.append("}").closeScope();
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
	
	@Fix(IssueCodes.XBASE_LIB_NOT_ON_CLASSPATH)
	public void putXtendOnClasspath(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add Xtend libs to classpath", "Add Xtend libs to classpath", "fix_indent.gif", new ISemanticModification() {
			public void apply(EObject element, IModificationContext context) throws Exception {
				ResourceSet resourceSet = element.eResource().getResourceSet();
				IJavaProject javaProject = projectProvider.getJavaProject(resourceSet);
				xtendLibAdder.addLibsToClasspath(javaProject, new NullProgressMonitor());
			}
		});
	}
	
	@Fix(IssueCodes.MISSING_ABSTRACT)
	public void makeClassAbstract(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Make class abstract", "Make class abstract", "fix_indent.gif",
				new ISemanticModification() {
					public void apply(EObject element, IModificationContext context) throws Exception {
						internalDoAddAbstractKeyword(element, context);
					}
				});
	}
	
	protected void internalDoAddAbstractKeyword(EObject element, IModificationContext context)
			throws BadLocationException {
		if (element instanceof XtendFunction) {
			element = element.eContainer();
		}
		if (element instanceof XtendClass) {
			XtendClass clazz = (XtendClass) element;
			IXtextDocument document = context.getXtextDocument();
			ICompositeNode clazzNode = NodeModelUtils.findActualNodeFor(clazz);
			if (clazzNode == null)
				throw new IllegalStateException("Cannot determine node for clazz " + clazz.getName());
			int offset = -1;
			for (ILeafNode leafNode : clazzNode.getLeafNodes()) {
				if (leafNode.getText().equals("class")) {
					offset = leafNode.getOffset();
				}
			}
			ReplacingAppendable appendable = appendableFactory.get(document, clazz,
					offset, 0);
			appendable.append("abstract ");
			appendable.commitChanges();
		}
	}
	

}
