/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.quickfix;

import static com.google.common.collect.Sets.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendExecutable;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.buildpath.XtendLibClasspathAdder;
import org.eclipse.xtend.ide.codebuilder.InsertionOffsets;
import org.eclipse.xtend.ide.codebuilder.MemberFromSuperImplementor;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.StopWatch;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable;
import org.eclipse.xtext.xbase.ui.document.DocumentSourceAppender.Factory.OptionalParameters;
import org.eclipse.xtext.xbase.ui.quickfix.XbaseQuickfixProvider;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
/**
 * @author Jan Koehnlein - Quickfixes for inconsistent indentation
 * @author Sebastian Zarnekow - Quickfixes for misspelled types and constructors
 * @author Holger Schill - Quickfixes for missing methods / fields / localVars
 */
@Singleton
public class XtendQuickfixProvider extends XbaseQuickfixProvider {

	private static final Logger logger = Logger.getLogger(XtendQuickfixProvider.class);
	
	@Inject private IXtendJvmAssociations associations;
	
	@Inject	private ReplacingAppendable.Factory appendableFactory;
	
	@Inject private XtendGrammarAccess grammarAccess;
	
	@Inject private InsertionOffsets insertionOffsets;

	@Inject private MemberFromSuperImplementor superMemberImplementor;
	
	@Inject	private XtendLibClasspathAdder xtendLibAdder;
	
	@Inject private IJavaProjectProvider projectProvider;

	@Inject private CreateXtendTypeQuickfixes createTypeQuickfixes;

	@Inject private CreateMemberQuickfixes createMemberQuickfixes;
	
	@Inject private OverrideHelper overrideHelper;
	
	@Inject private IBatchTypeResolver batchTypeResolver;
	
	private static final Set<String> LINKING_ISSUE_CODES = newHashSet(
			Diagnostic.LINKING_DIAGNOSTIC,
			IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC,
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
	protected EReference getUnresolvedEReference(Issue issue, EObject target) {
		EReference reference = super.getUnresolvedEReference(issue, target);
		if(reference == null){
			if(issue.getCode().equals(IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC)){
				return TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE;
			}
		}
		return reference;
	}

	@Override
	protected void createLinkingIssueQuickfixes(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor, 
			IXtextDocument xtextDocument, XtextResource resource, 
			EObject referenceOwner, EReference unresolvedReference) throws Exception {
		javaTypeQuickfixes.addQuickfixes(issue, issueResolutionAcceptor, xtextDocument, resource, referenceOwner, unresolvedReference);
		createTypeQuickfixes.addQuickfixes(issue, issueResolutionAcceptor, xtextDocument, resource, referenceOwner, unresolvedReference);
		createMemberQuickfixes.addQuickfixes(issue, issueResolutionAcceptor, xtextDocument, resource, referenceOwner, unresolvedReference);
	}

	@Fix(IssueCodes.INCONSISTENT_INDENTATION)
	public void fixIndentation(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Correct indentation", "Correctly indents this line in this rich string",
				"fix_indent.gif", new IModification() {
					@Override
					public void apply(IModificationContext context) throws Exception {
						context.getXtextDocument().replace(issue.getOffset(), issue.getLength(), issue.getData()[0]);
					}
				});
	}
	
	@Fix(IssueCodes.MISSING_OVERRIDE)
	public void fixMissingOverride(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Change 'def' to 'override'", "Marks this function as 'override'", "fix_indent.gif",
				new ISemanticModification() {
					@Override
					public void apply(EObject element, IModificationContext context) throws Exception {
						replaceKeyword(grammarAccess.getMethodModifierAccess().findKeywords("def").get(0), "override", element,
								context.getXtextDocument());
					}
				});
	}

	@Fix(IssueCodes.OBSOLETE_OVERRIDE)
	public void fixObsoleteOverride(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Change 'override' to 'def'", "Removes 'override' from this function", "fix_indent.gif",
				new ISemanticModification() {
					@Override
					public void apply(EObject element, IModificationContext context) throws Exception {
						replaceKeyword(grammarAccess.getMethodModifierAccess().findKeywords("override").get(0), "def", element,
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
					ITextRegion leafRegion = leafNode.getTextRegion();
					String actualReplacement = replacement;
					if (!Character.isWhitespace(document.getChar(leafRegion.getOffset() - 1))) {
						actualReplacement = " " + replacement;
					}
					document.replace(leafRegion.getOffset(), leafRegion.getLength(), actualReplacement);
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
						@Override
						public void apply(EObject element, IModificationContext context) throws Exception {
							XtendClass clazz = (XtendClass) element;
							JvmGenericType inferredType = associations.getInferredType(clazz);
							ResolvedFeatures features = overrideHelper.getResolvedFeatures(inferredType);
							ReplacingAppendable appendable = appendableFactory.create(context.getXtextDocument(), (XtextResource) clazz.eResource(),
									insertionOffsets.getNewConstructorInsertOffset(null, clazz), 0, new OptionalParameters() {{ 
										ensureEmptyLinesAround = true;
										baseIndentationLevel = 1;	
									}});
							EObject constructor = clazz.eResource().getResourceSet().getEObject(constructorURI, true);
							if (constructor instanceof JvmConstructor) {
								superMemberImplementor.appendConstructorFromSuper(
										clazz,
										new ResolvedConstructor((JvmConstructor) constructor, features.getType()),
										appendable);
							}
							appendable.commitChanges();
						}
					});
			}
		}
	}
	
	@Fix(IssueCodes.CLASS_MUST_BE_ABSTRACT)
	public void implementAbstractMethods(final Issue issue, IssueResolutionAcceptor acceptor) {
		doOverrideMethods(issue, acceptor, "Add unimplemented methods");
		acceptor.accept(issue, "Make class abstract", "Make class abstract", "fix_indent.gif",
				new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				internalDoAddAbstractKeyword(element, context);
			}
		});
	}

	@Fix(IssueCodes.ANONYMOUS_CLASS_MISSING_MEMBERS)
	public void implementAbstractMethodsInAnonymousClass(final Issue issue, IssueResolutionAcceptor acceptor) {
		doOverrideMethods(issue, acceptor, "Add unimplemented methods");
	}
	
	@Fix(IssueCodes.CONFLICTING_DEFAULT_METHODS)
	public void overrideDefaultMethod(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData() != null) {
			for (String data : issue.getData()) {
				int separatorIndex = data.indexOf('|');
				if (separatorIndex > 0) {
					String interfaceName = data.substring(0, separatorIndex);
					String uri = data.substring(separatorIndex + 1);
					doOverrideMethods(issue, acceptor, "Override conflicting method of type " + interfaceName,
							new String[] {uri});
				}
			}
		}
	}
	
	protected void doOverrideMethods(final Issue issue, IssueResolutionAcceptor acceptor, String label) {
		if (issue.getData() != null && issue.getData().length > 0) {
			doOverrideMethods(issue, acceptor, label, issue.getData());
		}
	}
	
	protected void doOverrideMethods(final Issue issue, IssueResolutionAcceptor acceptor, String label, final String[] operationUris) {
		acceptor.accept(issue, label, label, "fix_indent.gif",
				new ISemanticModification() {
					@Override
					public void apply(EObject element, IModificationContext context) throws Exception {
						XtendTypeDeclaration clazz = (XtendTypeDeclaration) element;
						JvmGenericType inferredType = (JvmGenericType) associations.getInferredType(clazz);
						ResolvedFeatures resolvedOperations = overrideHelper.getResolvedFeatures(inferredType);
						IXtextDocument document = context.getXtextDocument();
						final int offset = insertionOffsets.getNewMethodInsertOffset(null, clazz);
						int currentIndentation = appendableFactory.getIndentationLevelAtOffset(offset, document, (XtextResource) clazz.eResource());
						final int indentationToUse = clazz.getMembers().isEmpty() ? currentIndentation + 1 : currentIndentation;
						ReplacingAppendable appendable = appendableFactory.create(document, (XtextResource) clazz.eResource(),
								offset, 0, new OptionalParameters() {{ 
									ensureEmptyLinesAround = true;
									baseIndentationLevel = indentationToUse;	
								}});
						boolean isFirst = true;
						for (String operationUriAsString : operationUris) {
							URI operationURI = URI.createURI(operationUriAsString);
							EObject overridden = clazz.eResource().getResourceSet().getEObject(operationURI, true);
							if (overridden instanceof JvmOperation) {
								if(!isFirst) 
									appendable.newLine().newLine();
								isFirst = false;
								
								superMemberImplementor.appendOverrideFunction(clazz, resolvedOperations.getResolvedOperation((JvmOperation) overridden),
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
						@Override
						public void apply(EObject element, IModificationContext context) throws Exception {
							String[] issueData = issue.getData(); 
							XtendExecutable xtendExecutable = EcoreUtil2.getContainerOfType(element, XtendExecutable.class);
							XtextResource xtextResource = (XtextResource) xtendExecutable.eResource();
							List<JvmType> exceptions = getExceptions(issueData, xtextResource);
							if (exceptions.size() > 0) {
								int insertPosition;
								if (xtendExecutable.getExpression() == null) {
									ICompositeNode functionNode = NodeModelUtils.findActualNodeFor(xtendExecutable);
									if (functionNode == null)
										throw new IllegalStateException("functionNode may not be null");
									insertPosition = functionNode.getEndOffset();
								} else {
									ICompositeNode expressionNode = NodeModelUtils.findActualNodeFor(xtendExecutable.getExpression());
									if (expressionNode == null)
										throw new IllegalStateException("expressionNode may not be null");
									insertPosition = expressionNode.getOffset();
								}
								ReplacingAppendable appendable = appendableFactory.create(context.getXtextDocument(),
										(XtextResource) xtendExecutable.eResource(), insertPosition, 0);
								if (xtendExecutable.getExpression() == null) 
									appendable.append(" ");
								EList<JvmTypeReference> thrownExceptions = xtendExecutable.getExceptions();
								if (thrownExceptions.isEmpty())
									appendable.append("throws ");
								else
									appendable.append(", ");
								for(int i = 0; i < exceptions.size(); i++) {
									appendable.append(exceptions.get(i));
									if (i != exceptions.size() - 1) {
										appendable.append(", ");
									}
								}
								if (xtendExecutable.getExpression() != null) 
									appendable.append(" ");
								appendable.commitChanges();
							}
						}
					});
	}

	/**
	 * @param all but the last element in the issue data is considered to be a URI to an exception type.
	 */
	protected List<JvmType> getExceptions(String[] issueData, XtextResource resource) {
		List<JvmType> exceptions = Lists.newArrayList();
		for(int i = 0; i < issueData.length - 1; i++) {
			URI exceptionURI = URI.createURI(issueData[i]);
			EObject exception = resource.getResourceSet().getEObject(exceptionURI, true);
			if (exception instanceof JvmType) {
				exceptions.add((JvmType) exception);
			}
		}
		return exceptions;
	}
	
	@Fix(org.eclipse.xtext.xbase.validation.IssueCodes.UNHANDLED_EXCEPTION)
	public void surroundWithTryCatch(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData() == null || issue.getData().length <= 1) {
			return;
		}
		IModificationContext modificationContext = getModificationContextFactory().createModificationContext(issue);
		IXtextDocument xtextDocument = modificationContext.getXtextDocument();
		if (xtextDocument == null) {
			return;
		}
		if (isJvmConstructorCall(xtextDocument, issue)) {
			return;
		}
		acceptor.accept(issue, "Surround with try/catch block", "Surround with try/catch block", "fix_indent.gif",
				new ISemanticModification() {
					@Override
					public void apply(EObject element, IModificationContext context) throws Exception {
						String[] issueData = issue.getData();
						URI childURI = URI.createURI(issueData[issueData.length - 1]);
						XtextResource xtextResource = (XtextResource) element.eResource();
						List<JvmType> exceptions = getExceptions(issueData, xtextResource);
						if (exceptions.size() > 0) {
							EObject childThrowingException = xtextResource.getResourceSet().getEObject(childURI, true);
							XExpression toBeSurrounded = findContainerExpressionInBlockExpression(childThrowingException);
							IXtextDocument xtextDocument = context.getXtextDocument();
							if (toBeSurrounded != null) {
								ICompositeNode toBeSurroundedNode = NodeModelUtils.findActualNodeFor(toBeSurrounded);
								if (toBeSurroundedNode == null)
									throw new IllegalStateException("toBeSurroundedNode may not be null");
								ITextRegion toBeSurroundedRegion = toBeSurroundedNode.getTextRegion();
								ReplacingAppendable appendable = appendableFactory.create(
										context.getXtextDocument(),
										(XtextResource) childThrowingException.eResource(), 
										toBeSurroundedRegion.getOffset(),
										toBeSurroundedRegion.getLength());
								appendable
										.append("try {")
										.increaseIndentation()
											.newLine()
											.append(xtextDocument.get(toBeSurroundedRegion.getOffset(),
													toBeSurroundedRegion.getLength()))
										.decreaseIndentation()
										.newLine();
								for(JvmType exceptionType: exceptions) {
									appendable
										.append("} catch (")
										.append(exceptionType).append(" exc) {").increaseIndentation()
											.newLine()
											.append("throw new RuntimeException(\"auto-generated try/catch\", exc)").decreaseIndentation()
										.newLine();
								}
								appendable.append("}");
								appendable.commitChanges();
							}
						}
					}
				});
	}

	private Boolean isJvmConstructorCall(IXtextDocument xtextDocument, final Issue issue) {
		return xtextDocument.readOnly(new IUnitOfWork<Boolean, XtextResource>() {

			@Override
			public Boolean exec(XtextResource xtextResource) throws Exception {
				String[] issueData = issue.getData();
				URI childURI = URI.createURI(issueData[issueData.length - 1]);
				EObject childThrowingException = xtextResource.getResourceSet().getEObject(childURI, true);
				if (!(childThrowingException instanceof XFeatureCall)) {
					return false;
				}
				XFeatureCall featureCall = (XFeatureCall) childThrowingException;
				return featureCall.getFeature() instanceof JvmConstructor;
			}
			
		});
	}
	
	@Fix(IssueCodes.WRONG_PACKAGE)
	public void fixPackageName(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData() != null && issue.getData().length == 1) {
			final String expectedPackage = issue.getData()[0];
			acceptor.accept(issue, "Change package declaration to '" + expectedPackage + "'", "Change package declaration to '" + expectedPackage + "'", "package_obj.gif",
					new ISemanticModification() {
						@Override
						public void apply(EObject element, IModificationContext context) throws Exception {
							XtendFile file = (XtendFile) element;
							String newPackageName = isEmpty(expectedPackage) ? null : expectedPackage;
							String oldPackageName = file.getPackage();
							for(EObject obj: file.eResource().getContents()) {
								if (obj instanceof JvmDeclaredType) {
									JvmDeclaredType type = (JvmDeclaredType) obj;
									String typePackage = type.getPackageName();
									if (Objects.equal(typePackage, oldPackageName) || typePackage != null && typePackage.startsWith(oldPackageName + ".")) {
										type.internalSetIdentifier(null);
										type.setPackageName(newPackageName);
									}
								}
							}
							file.setPackage(newPackageName);
						}
			});
		}
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
			@Override
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
					@Override
					public void apply(EObject element, IModificationContext context) throws Exception {
						internalDoAddAbstractKeyword(element, context);
					}
				});
	}
	
	@Fix(IssueCodes.API_TYPE_INFERENCE)
	public void specifyTypeExplicitly(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Infer type", "Infer type", null, new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				EStructuralFeature featureAfterType = null;
				JvmIdentifiableElement jvmElement = null;
				if (element instanceof XtendFunction) {
					XtendFunction function = (XtendFunction) element;
					if (function.getCreateExtensionInfo() == null) {
						featureAfterType = XtendPackage.Literals.XTEND_FUNCTION__NAME;
					} else {
						featureAfterType = XtendPackage.Literals.XTEND_FUNCTION__CREATE_EXTENSION_INFO;
					}
					jvmElement = associations.getDirectlyInferredOperation((XtendFunction) element);
				} else if (element instanceof XtendField) {
					featureAfterType = XtendPackage.Literals.XTEND_FIELD__NAME;
					jvmElement = associations.getJvmField((XtendField) element);
				}
				
				if (jvmElement != null) {
					LightweightTypeReference type = batchTypeResolver.resolveTypes(element).getActualType(jvmElement);
					INode node = Iterables.getFirst(NodeModelUtils.findNodesForFeature(element, featureAfterType), null);
					
					if (node == null) {
						throw new IllegalStateException("Could not determine node for " + element);
					}
					if (type == null) {
						throw new IllegalStateException("Could not determine type for " + element);
					}
					ReplacingAppendable appendable = appendableFactory.create(context.getXtextDocument(),
							(XtextResource) element.eResource(), node.getOffset(), 0);
					appendable.append(type);
					appendable.append(" ");
					appendable.commitChanges();
				}
			}
		});
	}
	

	@Fix(IssueCodes.IMPLICIT_RETURN) 
	public void fixImplicitReturn(final Issue issue, IssueResolutionAcceptor acceptor){
		acceptor.accept(issue, "Add \"return\" keyword", "Add \"return\" keyword", null, new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				ICompositeNode node = NodeModelUtils.findActualNodeFor(element);
				ReplacingAppendable appendable = appendableFactory.create(context.getXtextDocument(), (XtextResource) element.eResource(), node.getOffset(), 0);
				appendable.append("return ");
				appendable.commitChanges();
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
			ReplacingAppendable appendable = appendableFactory.create(document, (XtextResource) clazz.eResource(),
					offset, 0);
			appendable.append("abstract ");
			appendable.commitChanges();
		}
	}

}
