/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.quickfix;

import static org.eclipse.xtext.util.Strings.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.TypeNameRequestor;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jdt.internal.core.NameLookup;
import org.eclipse.jdt.internal.core.NameLookup.Answer;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtend.core.formatting.MemberFromSuperImplementor;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.linking.XtendLinkingDiagnosticMessageProvider;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendImport;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.ide.buildpath.XtendLibClasspathAdder;
import org.eclipse.xtend.ide.contentassist.ReplacingAppendable;
import org.eclipse.xtend.ide.edit.OrganizeImportsHandler;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.common.types.util.VisibilityService;
import org.eclipse.xtext.common.types.xtext.ui.JdtTypeRelevance;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions;
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
import org.eclipse.xtext.ui.editor.model.edit.SemanticModificationWrapper;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.editor.quickfix.ReplaceModification;
import org.eclipse.xtext.util.StopWatch;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Quickfixes for inconsistent indentation
 * @author Sebastian Zarnekow - Quickfixes for misspelled types and constructors
 * @author Holger Schill - Quickfixes for missing methods / fields / localVars
 */
public class XtendQuickfixProvider extends DefaultQuickfixProvider {

	private static final Logger logger = Logger.getLogger(XtendQuickfixProvider.class);
	@Inject
	private IJavaProjectProvider projectProvider;
	@Inject
	private MemberFromSuperImplementor superMemberImplementor;
	@Inject
	private XtendGrammarAccess grammarAccess;
	@Inject
	private OrganizeImportsHandler organizeImportsHandler;
	@Inject
	private ReplacingAppendable.Factory appendableFactory;
	@Inject
	private XtendTypeReferenceSerializer typeRefSerializer;
	@Inject
	private TypeReferences typeRefs;
	@Inject
	private XtendLibClasspathAdder xtendLibAdder;
	@Inject
	private IXtendJvmAssociations associations;
	@Inject 
	private VisibilityService visibilityService;
	@Inject
	private Provider<IssueResolutionAcceptor> issueResolutionAcceptorProvider;
	@Inject
	private ITypeProvider typeProvider;
	@Inject
	private JdtVariableCompletions jdtVariableCompletions;
	@Inject
	private Primitives primitives;
	@Inject
	private CommonTypeComputationServices computationServices;
	@Inject
	private JdtTypeRelevance jdtTypeRelevance;

	@Override
	public boolean hasResolutionFor(String issueCode) {
		if(XtendLinkingDiagnosticMessageProvider.FEATURECALL_LINKING_DIAGNOSTIC.equals(issueCode))
			return true;
		return super.hasResolutionFor(issueCode);
	}

	@Override
	public List<IssueResolution> getResolutions(Issue issue) {
		StopWatch stopWatch = new StopWatch(logger);
		try {
			if(XtendLinkingDiagnosticMessageProvider.FEATURECALL_LINKING_DIAGNOSTIC.equals(issue.getCode())){
				final IssueResolutionAcceptor issueResolutionAcceptor = issueResolutionAcceptorProvider.get();
				createXtendLinkingIssueResolutions(issue, issueResolutionAcceptor);
				return issueResolutionAcceptor.getIssueResolutions();
			}else
				return super.getResolutions(issue);
		} finally {
			stopWatch.resetAndLog("#getResolutions");
		}
	}
	
	/**
	 * @since 2.3
	 */
	protected void createXtendLinkingIssueResolutions(final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor) {
		final IModificationContext modificationContext = getModificationContextFactory().createModificationContext(issue);
		IXtextDocument xtextDocument = modificationContext.getXtextDocument();
		if(issue.getData() != null && xtextDocument != null){
			final String elementName = issue.getData()[0];
			if(elementName != null)
				xtextDocument.modify(new IUnitOfWork.Void<XtextResource>(){
					@Override
					public void process(XtextResource state) throws Exception {
						EObject eObject = state.getEObject(issue.getUriToProblem().fragment());
						// For now we do not provide quickfixes for super as target
						if(eObject instanceof XMemberFeatureCall){
							XExpression target = ((XMemberFeatureCall) eObject).getMemberCallTarget();
							if(target != null && isExpressionWithName(target, XbaseScopeProvider.SUPER))
								return;
						}
						if(eObject instanceof XAbstractFeatureCall){
							XAbstractFeatureCall call = (XAbstractFeatureCall) eObject;
							StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable(new ImportManager(true));
							computeTypeArguments(call, call.getTypeArguments(), appendable);
							JvmTypeReference expectedFieldType =  null;
							boolean isExtension = false;
							List<XExpression> arguments = computeArguments(call, isExtension);							
							if(call instanceof XMemberFeatureCall) {
								XExpression memberCallTarget = ((XMemberFeatureCall) call).getMemberCallTarget();
								isExtension = memberCallTarget != null && !isExpressionWithName(memberCallTarget, XbaseScopeProvider.THIS);
							} else if(call instanceof XAssignment){
								if(isExpressionWithName(call.getExplicitArguments().get(0), XbaseScopeProvider.IT))
									isExtension = true;
							}
								
							if(call instanceof XAssignment){
								XExpression xExpression = arguments.get(0);
								expectedFieldType = typeProvider.getType(xExpression);
							}
							JvmTypeReference expectedType = typeProvider.getExpectedType(call);
							TypeParameterByConstraintSubstitutor substitutor = new TypeParameterByConstraintSubstitutor(Collections.<JvmTypeParameter, JvmTypeReference>emptyMap(), computationServices);
							JvmTypeReference resolvedExpectedType= substitutor.substitute(expectedType);
							if(resolvedExpectedType != null && resolvedExpectedType.getType() != null){
								typeRefSerializer.serialize(resolvedExpectedType, call, appendable);
								appendable.append(" ");
							}
							if(expectedFieldType == null)
								expectedFieldType = resolvedExpectedType;
							boolean isSetter = false;
							if(call instanceof XAssignment){
								isSetter = true;
								appendable.append("set" + StringExtensions.toFirstUpper(elementName));
							} else
								appendable.append(elementName);
							computeArgumentString(call, false, appendable, isExtension);
							createNewXtendFunction(isSetter?"set" + StringExtensions.toFirstUpper(elementName): elementName, appendable.toString(), isExtension, resolvedExpectedType, issue, issueResolutionAcceptor, modificationContext);
							if (!isExtension && (arguments.size() == 0 || call instanceof XAssignment)){
								createNewXtendField(elementName, expectedFieldType, call, issue, issueResolutionAcceptor, modificationContext);
								if(!(call instanceof XAssignment))
									createNewLocalVariable(elementName, resolvedExpectedType, issue, issueResolutionAcceptor, modificationContext);
							}
						}
					}

					
				});
		}
	}
	
	/**
	 * @since 2.3
	 */
	@SuppressWarnings("null")
	protected void createNewLocalVariable(final String elementName, JvmTypeReference expectedType,
			Issue issue, IssueResolutionAcceptor issueResolutionAcceptor, IModificationContext modificationContext) {
		final StringBuilderBasedAppendable localVarDescriptionBuilder = new StringBuilderBasedAppendable();
		localVarDescriptionBuilder.append("...").newLine();
		final String defaultValueLiteral = getDefaultValueLiteral(expectedType);
		localVarDescriptionBuilder.append("val ").append(elementName).append(" = ").append(defaultValueLiteral);
		localVarDescriptionBuilder.newLine().append("...");
		issueResolutionAcceptor.accept(
				issue, 
				defaultValueLiteral, 
				elementName, 
				defaultValueLiteral, 
				new SemanticModificationWrapper(issue.getUriToProblem(), new ISemanticModification() {
					public void apply(final EObject element, final IModificationContext context) throws Exception {
						if (element != null) {
							XtendMember xtendMember = EcoreUtil2.getContainerOfType(element, XtendMember.class);
							if (xtendMember != null) {
								int offset = getFirstOffsetOfKeyword(xtendMember, "{");
								IXtextDocument xtextDocument = context.getXtextDocument();
								if (offset != -1 && xtextDocument != null) {
									final ReplacingAppendable appendable = appendableFactory.get(xtextDocument,
											element, offset, 0, 1, false);
									appendable.newLine().append("val ").append(elementName).append(" = ")
											.append(defaultValueLiteral);
									appendable.commitChanges();
								}
							}
						}
					}
				}));
	}

	
	/**
	 * @since 2.3
	 */
	protected void createNewXtendFunction(@NonNull final String elementName, final @NonNull String callText,final  boolean isExtension, final JvmTypeReference expectedType, final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor, IModificationContext modificationContext){
		StringBuilderBasedAppendable methodDescriptionBuilder = new StringBuilderBasedAppendable();
		StringBuilderBasedAppendable methodLabelBuilder = new StringBuilderBasedAppendable();
		methodDescriptionBuilder.append("...").newLine().append("def ");
		methodLabelBuilder.append("create "); 
		if(isExtension)
			methodLabelBuilder.append("extension ");
		methodLabelBuilder.append("method ");
		methodLabelBuilder.append(elementName);
		methodDescriptionBuilder.append(callText).append(" {}").newLine().append("...");
		IssueResolution issueResolutionMethodInType = new IssueResolution(methodLabelBuilder.toString(), methodDescriptionBuilder.toString(), "fix_public_function.png", modificationContext,  new SemanticModificationWrapper(issue.getUriToProblem(),new ISemanticModification(){
			public void apply(final EObject element, final IModificationContext context) throws Exception {
				if(element != null){
					XAbstractFeatureCall call = (XAbstractFeatureCall) element;
					XtendClass xtendClazz = EcoreUtil2.getContainerOfType(element, XtendClass.class);
					IXtextDocument xtextDocument = context.getXtextDocument();
					doCreateNewFunctionInClazz(call, xtendClazz, expectedType, xtextDocument, callText);
				}
			}
		}));
		issueResolutionAcceptor.getIssueResolutions().add(issueResolutionMethodInType);
	}
	
	/**
	 * @since 2.3
	 */
	protected void doCreateNewFunctionInClazz(@NonNull XAbstractFeatureCall call, XtendClass xtendClazz,@Nullable JvmTypeReference expectedType, IXtextDocument xtextDocument,
			@NonNull String callText) throws BadLocationException {
		XtendFunction function = EcoreUtil2.getContainerOfType(call, XtendFunction.class);
		int offset = superMemberImplementor.getFunctionInsertOffset(xtendClazz);
		if(function != null){
			ICompositeNode node = NodeModelUtils.getNode(function);
			if(node != null)
				offset = node.getTotalEndOffset();
		}
		final ReplacingAppendable appendable = appendableFactory.get(xtextDocument, call, offset, 0, 1, false);
		appendable.newLine().increaseIndentation().append("def ");
		appendable.append(callText);
		appendable.append(" { }").decreaseIndentation().decreaseIndentation().newLine();
		appendable.commitChanges();
	}

	/**
	 * @since 2.3
	 */
	@SuppressWarnings("null")
	protected void createNewXtendField(final String elementName, final JvmTypeReference expectedType, XAbstractFeatureCall call, final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor, IModificationContext modificationContext){
		StringBuilderBasedAppendable fieldDescriptionBuilder = new StringBuilderBasedAppendable(new ImportManager(true));
		final JvmTypeReference type = (expectedType == null || expectedType.getType() == null)?typeRefs.createTypeRef(typeRefs.findDeclaredType(Object.class, call)):expectedType;
		fieldDescriptionBuilder.append("...").newLine();
		typeRefSerializer.serialize(type, call, fieldDescriptionBuilder);
		fieldDescriptionBuilder.append(" ").append(elementName).newLine().append("...");
		IssueResolution issueResolutionField = new IssueResolution("create field " + elementName, fieldDescriptionBuilder.toString(), "fix_private_field.png", modificationContext, new SemanticModificationWrapper(issue.getUriToProblem(), new ISemanticModification() {

			public void apply(EObject element, IModificationContext context) throws Exception {
				XAbstractFeatureCall call = (XAbstractFeatureCall) element;
				XtendClass xtendClazz = EcoreUtil2.getContainerOfType(element, XtendClass.class);
				IXtextDocument xtextDocument = context.getXtextDocument();
				int openingBraceOffset = getFirstOffsetOfKeyword(xtendClazz, "{");
				if(openingBraceOffset != -1 && xtextDocument != null && call != null)
					doCreateNewFieldInClazz(elementName, call, type, xtextDocument, openingBraceOffset);
			}
			
		}));
		issueResolutionAcceptor.getIssueResolutions().add(issueResolutionField);
	}
	
	/**
	 * @since 2.3
	 */
	protected void doCreateNewFieldInClazz(@NonNull final String elementName,@NonNull XAbstractFeatureCall call, @NonNull JvmTypeReference expectedType,
			@NonNull IXtextDocument xtextDocument, int openingBraceOffset) throws BadLocationException {
		final ReplacingAppendable appendable = appendableFactory.get(xtextDocument, call, openingBraceOffset, 0, 1, false);
		appendable.newLine();
		typeRefSerializer.serialize(expectedType, call, appendable);
		appendable.append(" ").append(elementName);
		appendable.commitChanges();
	}
	
	/**
	 * @since 2.3
	 */
	protected int getFirstOffsetOfKeyword(EObject object, String keyword) {
		int offset = -1;
		if(object != null) {
			ICompositeNode node = NodeModelUtils.getNode(object);
			if(node != null){
				for (ILeafNode leafNode : node.getLeafNodes()) {
					if (leafNode.getGrammarElement() instanceof Keyword
							&& equal(keyword, ((Keyword) leafNode.getGrammarElement()).getValue())) {
						return leafNode.getOffset() + 1;
					}
				}
			}
		}
		return offset;
	}
	
	/**
	 * @since 2.3
	 */
	protected String getDefaultValueLiteral(JvmTypeReference type){
		if (primitives.isPrimitive(type)) {
			Primitive primitiveKind = primitives.primitiveKind((JvmPrimitiveType) type.getType());
			if (primitiveKind == Primitive.Boolean) 
				return "false";
			else 
				return "0 as " + type.getSimpleName();
		}
		return "null";
	}
	
	/**
	 * @since 2.3
	 */
	@SuppressWarnings("null")
	protected void computeArgumentString(XAbstractFeatureCall call, boolean paramNames, final IAppendable appendable, boolean isExtension) {
		Iterator<XExpression> iterator = computeArguments(call, isExtension).iterator();
		final Set<String> notallowed = Sets.newHashSet();
		appendable.append("(");
		while(iterator.hasNext()){
			XExpression expression = iterator.next();	
			JvmTypeReference typeRef = typeProvider.getType(expression);
			if(typeRef != null){
				typeRefSerializer.serialize(typeRef, call, appendable);
				appendable.append(" ");
				VariableNameAcceptor acceptor = new VariableNameAcceptor(notallowed);
				jdtVariableCompletions.getVariableProposals(typeRef.getIdentifier(), call, JdtVariableCompletions.VariableType.PARAMETER, notallowed, acceptor);
				appendable.append(acceptor.getVariableName());
			}
			if(iterator.hasNext())
				appendable.append(", ");
		}
		appendable.append(")");
	}

	private List<XExpression> computeArguments(XAbstractFeatureCall call, boolean isExtension) {
		List<XExpression> arguments = Lists.newArrayList(call.getExplicitArguments());
		if(call instanceof XMemberFeatureCall && !isExtension)
			arguments.remove(((XMemberFeatureCall) call).getMemberCallTarget());
		else if(call instanceof XAssignment){
			XExpression firstArgument = arguments.get(0);
			if(isExpressionWithName(firstArgument, XbaseScopeProvider.THIS))
				arguments.remove(firstArgument);
			
		}
		return arguments;
	}
	
	private boolean isExpressionWithName(XExpression expression, QualifiedName fqn) {
		ICompositeNode node = NodeModelUtils.getNode(expression);
		if(node != null){
			String string = node.getText().trim();
			if(string.equals(fqn.toString()))
					return true;
		}
		return false;
	}

	private final class VariableNameAcceptor implements JdtVariableCompletions.CompletionDataAcceptor {
		private final Set<String> notallowed;
		Set<String> variableNames = Sets.newHashSet();

		private VariableNameAcceptor(Set<String> notallowed) {
			this.notallowed = notallowed;
		}

		public void accept(String replaceText, StyledString label, Image img) {
			variableNames.add(replaceText);
			notallowed.add(replaceText);
		}

		public String getVariableName(){
			ArrayList<String> candidates = Lists.newArrayList(variableNames);
			Collections.sort(candidates, new Comparator<String>(){
				public int compare(String left, String right) {
					if (left.length() < right.length()) {
				        return -1;
				      } else if (left.length() > right.length()) {
				        return 1;
				      } else {
				        return 0;
				      }
				}
			});
			if(candidates.size() > 0)
				return candidates.get(0);
			return "";
		}
	}
	/**
	 * @since 2.3
	 */
	@SuppressWarnings("null")
	protected void computeTypeArguments(XExpression expression, List<JvmTypeReference> typeArguments, final IAppendable appendable) {
		if(typeArguments.size() > 0){
			appendable.append("<");
			Iterator<JvmTypeReference> iterator = typeArguments.iterator();
			while(iterator.hasNext()){
				JvmTypeReference next = iterator.next();
				typeRefSerializer.serialize(next, expression, appendable);
				if(iterator.hasNext())
					appendable.append(", ");
			}
			appendable.append(">").append(" ");
		}
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
						XtendClass xtendClass = EcoreUtil2.getContainerOfType(target, XtendClass.class);
						JvmDeclaredType jvmType = xtendClass != null ? associations.getInferredType(xtendClass) : null;
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

	protected void createImportProposals(final JvmDeclaredType contextType, final Issue issue, final String typeSimpleName, IJavaSearchScope searchScope,
			final IssueResolutionAcceptor acceptor) throws JavaModelException {
		if(contextType != null){
			IJavaProject javaProject = projectProvider.getJavaProject(contextType.eResource().getResourceSet());
			final NameLookup nameLookup = ((JavaProject) javaProject).newNameLookup(new ICompilationUnit[0]);
			SearchEngine searchEngine = new SearchEngine();
			searchEngine.searchAllTypeNames(null, SearchPattern.R_EXACT_MATCH, typeSimpleName.toCharArray(),
					SearchPattern.R_EXACT_MATCH, IJavaSearchConstants.TYPE, searchScope, new TypeNameRequestor() {
						@Override
						public void acceptType(int modifiers, char[] packageName, char[] simpleTypeName,
								char[][] enclosingTypeNames, String path) {
							final String qualifiedTypeName = getQualifiedTypeName(packageName, enclosingTypeNames,
									simpleTypeName);
							Answer answer = nameLookup.findType(qualifiedTypeName, false, NameLookup.ACCEPT_ALL, true);
							if(answer != null && !answer.ignoreIfBetter()){
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
									acceptor.accept(issue, label.toString(), label.toString(), "fix_indent.gif", new ISemanticModification() {
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
				final String signature = issue.getData()[i+1];
				acceptor.accept(issue, "Add constructor " + signature, "Add constructor " + signature, "fix_indent.gif",
					new ISemanticModification() {
						public void apply(EObject element, IModificationContext context) throws Exception {
							XtendClass clazz = (XtendClass) element;
							ReplacingAppendable appendable = appendableFactory.get(context.getXtextDocument(), clazz,
									superMemberImplementor.getConstructorInsertOffset(clazz), 0);
							EObject constructor = clazz.eResource().getResourceSet().getEObject(constructorURI, true);
							if (constructor instanceof JvmConstructor) {
								superMemberImplementor.appendConstructorFromSuper(clazz, (JvmConstructor) constructor,
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
		if (issue.getData() != null && issue.getData().length > 0) {
			acceptor.accept(issue, "Add unimplemented methods", "Add unimplemented methods", "fix_indent.gif",
					new ISemanticModification() {
						public void apply(EObject element, IModificationContext context) throws Exception {
							XtendClass clazz = (XtendClass) element;
							IXtextDocument document = context.getXtextDocument();
							ReplacingAppendable appendable = appendableFactory.get(document, clazz,
									superMemberImplementor.getFunctionInsertOffset(clazz), 0);
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
						@SuppressWarnings("null")
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
						@SuppressWarnings("null")
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
