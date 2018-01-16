/*******************************************************************************
 * Copyright (c) 2010, 2018 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.quickfix;

import static org.eclipse.xtext.xtext.XtextConfigurableIssueCodes.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xtext.RuleWithoutInstantiationInspector;
import org.eclipse.xtext.xtext.XtextLinkingDiagnosticMessageProvider;

import com.google.common.base.CaseFormat;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow - Quickfixes for bogus EPackage imports
 */
public class XtextGrammarQuickfixProvider extends DefaultQuickfixProvider {
	
	private static final String GRAMMAR_LANG_DOC = "https://www.eclipse.org/Xtext/documentation/301_grammarlanguage.html";

	private String NULL_QUICKFIX_IMAGE = null;
	
//	see https://bugs.eclipse.org/bugs/show_bug.cgi?id=324566
//	
//	@Fix(XtextValidator.INVALID_METAMODEL_ALIAS)
//	public void fixInvalidMetaModelAlias(final Issue issue, IssueResolutionAcceptor acceptor) {
//		final String alias = issue.getData()[0];
//		acceptor.accept(issue, "Remove '" + alias + "' alias", "Remove '" + alias + "' alias", NULL_QUICKFIX_IMAGE,
//				new ISemanticModification() {
//					public void apply(final EObject element, IModificationContext context) {
//						ReferencedMetamodel referencedMetamodel = (ReferencedMetamodel) element;
//						referencedMetamodel.setAlias(null);
//					}
//				});
//		createLinkingIssueResolutions(issue, acceptor);
//	}
	
	@Inject
	private IValueConverterService valueConverterService;
	
	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;
	
	@Inject(optional=true)
	private IWorkbench workbench;
	
	@Inject
	private ILineSeparatorInformation separatorInfo;
	
	@Fix(XtextLinkingDiagnosticMessageProvider.UNRESOLVED_RULE)
	public void fixUnresolvedRule(final Issue issue, IssueResolutionAcceptor acceptor) {
		final String ruleName = issue.getData()[0];
		acceptor.accept(issue, "Create rule '" + ruleName + "'", "Create rule '" + ruleName + "'", NULL_QUICKFIX_IMAGE,
				new ISemanticModification() {
					@Override
					public void apply(final EObject element, IModificationContext context) throws BadLocationException {
						AbstractRule abstractRule = EcoreUtil2.getContainerOfType(element, ParserRule.class);
						ICompositeNode node = NodeModelUtils.getNode(abstractRule);
						int offset = node.getEndOffset();
						StringBuilder builder = new StringBuilder("\n\n");
						if (abstractRule instanceof TerminalRule)
							builder.append("terminal ");
						String newRule = builder.append(ruleName).append(":\n\t\n;").toString();
						context.getXtextDocument().replace(offset, 0, newRule);
					}
				});
		createLinkingIssueResolutions(issue, acceptor);
	}

	@Fix(INVALID_METAMODEL_NAME)
	public void fixInvalidMetaModelName(final Issue issue, IssueResolutionAcceptor acceptor) {
		final String metaModelName = issue.getData()[0];
		acceptor.accept(issue, "Fix metamodel name '" + metaModelName + "'", "Fix metamodel name '" + metaModelName
				+ "'", NULL_QUICKFIX_IMAGE, new IModification() {
			@Override
			public void apply(IModificationContext context) throws Exception {
				context.getXtextDocument().replace(issue.getOffset(), issue.getLength(), Strings.toFirstLower(metaModelName));
			}
		});
	}

	@Fix(EMPTY_ENUM_LITERAL)
	public void fixEmptyEnumLiteral(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.acceptMulti(issue, "Fix empty enum literal", "Fix empty enum literal", NULL_QUICKFIX_IMAGE,
				(EObject element) -> {
					EnumLiteralDeclaration enumLiteralDeclaration = (EnumLiteralDeclaration) element;
					Keyword keyword = XtextFactory.eINSTANCE.createKeyword();
					keyword.setValue(enumLiteralDeclaration.getEnumLiteral().getName().toLowerCase());
					enumLiteralDeclaration.setLiteral(keyword);
				});
	}

	@Fix(INVALID_ACTION_USAGE)
	public void fixInvalidActionUsage(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Fix invalid action usage", "Fix invalid action usage", NULL_QUICKFIX_IMAGE,
				new IModification() {
					@Override
					public void apply(IModificationContext context) throws BadLocationException {
						context.getXtextDocument().replace(issue.getOffset(), issue.getLength(), "");
					}
				});
	}
	
	@Fix(INVALID_PACKAGE_REFERENCE_INHERITED)
	public void fixImportedPackageFromSuperGrammar(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData().length == 1)
			acceptor.accept(issue, 
					"Change to '" + issue.getData()[0] + "'", 
					"Fix the bogus package import\n" +
					"import '" + issue.getData()[0] + "'", NULL_QUICKFIX_IMAGE,
					new IModification() {
						@Override
						public void apply(IModificationContext context) throws BadLocationException {
							String replaceString = valueConverterService.toString(issue.getData()[0], "STRING");
							IXtextDocument document = context.getXtextDocument();
							String delimiter = document.get(issue.getOffset(), 1);
							if (!replaceString.startsWith(delimiter)) {
								replaceString = delimiter + replaceString.substring(1, replaceString.length() - 1) + delimiter; 
							}
							document.replace(issue.getOffset(), issue.getLength(), replaceString);
						}
					});
	}
	
	@Fix(INVALID_PACKAGE_REFERENCE_EXTERNAL)
	public void fixExternalImportedPackage(final Issue issue, IssueResolutionAcceptor acceptor) {
		if (issue.getData().length == 1)
			acceptor.accept(issue, 
					"Update the imported package '" + issue.getData()[0] + "'", 
					"Fix the bogus package import\n" +
					"import '" + issue.getData()[0] + "'", NULL_QUICKFIX_IMAGE,
					new IModification() {
						@Override
						public void apply(IModificationContext context) throws BadLocationException {
							String replaceString = valueConverterService.toString(issue.getData()[0], "STRING");
							IXtextDocument document = context.getXtextDocument();
							final List<String> importedPackages = document.priorityReadOnly(new IUnitOfWork<List<String>, XtextResource>() {

								@Override
								public List<String> exec(XtextResource state) throws Exception {
									IResourceDescriptions descriptions = resourceDescriptionsProvider.getResourceDescriptions(state);
									ResourceSet resourceSet = state.getResourceSet();
									final Map<URI, URI> uriMap = Maps.newHashMap();
									EPackage ePackage = loadPackageFromIndex(descriptions, resourceSet, uriMap, issue.getData()[0]);
									if (ePackage != null) {
										final Map<String, EPackage> packagePerNsURI = Maps.newHashMap();
										packagePerNsURI.put(ePackage.getNsURI(), ePackage);
										final Set<URI> updatedReferences = fixReferencesInPackages(ePackage, packagePerNsURI, uriMap, descriptions, resourceSet);
										if (updatedReferences.isEmpty())
											return null;
										Iterator<EPackage> iterator = packagePerNsURI.values().iterator();
										while(iterator.hasNext()) {
											EPackage pack = iterator.next();
											Resource resource = pack.eResource();
											if (!resource.getURI().isPlatformResource()) {
												iterator.remove();
											}
										}
										final List<String> result = Lists.newArrayList();
										new WorkspaceModifyOperation( /* workspace lock */ ) {
											
											@Override
											protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
													InterruptedException {
												try {
													for(EPackage pack: packagePerNsURI.values()) {
														Resource resource = pack.eResource();
														resource.save(Collections.singletonMap(
																XMLResource.OPTION_URI_HANDLER, 
																new URIHandlerImpl.PlatformSchemeAware() {
																	@Override
																	public URI deresolve(URI uri) {
																		// replace archive uris with platform:/plugin
																		if (!uri.isArchive() || !updatedReferences.contains(uri)) {
																			return super.deresolve(uri);
																		}
																		URI withoutFragment = uri.trimFragment();
																		if (uriMap.containsKey(withoutFragment)) {
																			withoutFragment = uriMap.get(withoutFragment);
																		}
																		return super.deresolve(withoutFragment.appendFragment(uri.fragment()));
																	}
																}));
														result.add(resource.getURI().toString());
													}
												} catch(IOException ioe) {
													throw new InvocationTargetException(ioe);
												}
											}
										}.run(new NullProgressMonitor());
										
										for(int i = resourceSet.getResources().size() - 1; i >= 0; i-- ) {
											Resource resource = resourceSet.getResources().get(i);
											if (!resource.getContents().isEmpty() && resource.getContents().get(0) instanceof GenModel) {
												resourceSet.getResources().remove(i);
											}
										}
										return result;
									}
									return null;
								}
								
								private Set<URI> fixReferencesInPackages(EPackage ePackage, Map<String, EPackage> packagePerNsURI, Map<URI, URI> uriMap, IResourceDescriptions descriptions, ResourceSet resourceSet) {
									Set<URI> result = Sets.newHashSet();
									Map<EObject, Collection<Setting>> allReferences = EcoreUtil.CrossReferencer.find(Collections.singletonList(ePackage));
									for(final Setting setting: Iterables.concat(allReferences.values())) {
										if (setting.getEStructuralFeature().isChangeable()) {
											final Object referenced = setting.get(true);
											List<Object> references = null;
											if (referenced instanceof EObject) {
												references = new AbstractList<Object>() {
													@Override
													public Object set(int index, Object element) {
														setting.set(element);
														return referenced;
													}
													@Override
													public Object get(int index) {
														return referenced;
													}

													@Override
													public int size() {
														return 1;
													}
												};
											} else {
												@SuppressWarnings("unchecked")
												List<Object> casted = (List<Object>) referenced;
												references = casted;
											}
											for(int i = 0; i < references.size(); i++) {
												if (references.get(i) instanceof EObject) {
													EObject referencedEObject = (EObject) references.get(i);
													EPackage transitive = EcoreUtil2.getContainerOfType(referencedEObject, EPackage.class);
													if (isRegisteredPackage(transitive)) {
														if (referencedEObject instanceof EDataType)
															continue;
														if (referencedEObject == EcorePackage.Literals.EOBJECT)
															continue;
														EPackage fromWorkspace = packagePerNsURI.get(transitive.getNsURI());
														if (fromWorkspace == null && !packagePerNsURI.containsKey(transitive.getNsURI())) {
															fromWorkspace = loadPackageFromIndex(descriptions, resourceSet, uriMap, transitive.getNsURI());
															packagePerNsURI.put(transitive.getNsURI(), fromWorkspace);
														}
														if (fromWorkspace != null) {
															String fragment = transitive.eResource().getURIFragment(referencedEObject);
															EObject replacement = fromWorkspace.eResource().getEObject(fragment);
															if (replacement != null) {
																result.add(EcoreUtil.getURI(replacement));
																references.set(i, replacement);
															}
														}
													}
												}
											}
										}
									}
									return result;
								}
								
								private boolean isRegisteredPackage(EPackage ePackage) {
									return ePackage != null && (ePackage.eResource() == null || ePackage.getNsURI().equals(ePackage.eResource().getURI().toString()));
								}

								private EPackage loadPackageFromIndex(
										IResourceDescriptions descriptions,
										ResourceSet resourceSet,
										Map<URI, URI> uriMap, 
										String nsURI) {
									Iterable<IEObjectDescription> fixUs = descriptions.getExportedObjects(
											EcorePackage.Literals.EPACKAGE, 
											QualifiedName.create(nsURI), 
											false);
									for(IEObjectDescription description: fixUs) {
										if (description.getEObjectURI().isPlatformResource()) {
											EObject result = resourceSet.getEObject(description.getEObjectURI(), true);
											if (result instanceof EPackage) {
												return (EPackage) result;
											}
										}
									}
									URI genModelURI = EcorePlugin.getEPackageNsURIToGenModelLocationMap(false).get(nsURI);
									if (genModelURI != null) {
										Resource genmodelResource = resourceSet.getResource(genModelURI, true);
										GenModel genModel = (GenModel) genmodelResource.getContents().get(0);
										for(GenPackage genPackage: genModel.getGenPackages()) {
											Object object = genPackage.eGet(GenModelPackage.Literals.GEN_PACKAGE__ECORE_PACKAGE, false);
											if (object instanceof EObject) {
												EObject proxy = (EObject) object;
												URI proxyURI = EcoreUtil.getURI(proxy);
												URI resolvedProxyURI = proxyURI.resolve(genModelURI);
												if (nsURI.equals(genPackage.getEcorePackage().getNsURI())) {
													EPackage result = genPackage.getEcorePackage();
													uriMap.put(result.eResource().getURI(), resolvedProxyURI.trimFragment());
													return result;
												}
											}
										}
									}
									return null;
								}
								
							});
							String delimiter = document.get(issue.getOffset(), 1);
							if (!replaceString.startsWith(delimiter)) {
								replaceString = delimiter + replaceString.substring(1, replaceString.length() - 1) + delimiter; 
							}
							document.replace(issue.getOffset(), issue.getLength(), replaceString);
							if (importedPackages != null && !importedPackages.isEmpty()) {
								final Shell shell = workbench.getActiveWorkbenchWindow().getShell();
								shell.getDisplay().asyncExec(new Runnable() {
									@Override
									public void run() {
										String title = "Please update the Ecore2XtextDslProjectContributor that generates the language.";
										String message = "Please make sure that the Ecore2XtextDslProjectContributor that generates the language is up-to date.\n" +
												"Especially important is the registration of the referenced packages.\n" +
												"Please refer to the reference documentation for details.";
										
										MessageDialog dialog = new MessageDialog(shell, title, null, message,
												MessageDialog.INFORMATION, 
												new String[] { "Open Documentation", "Close" }, 1);
										if (dialog.open() == 0) {
											try {
												workbench.getBrowserSupport().getExternalBrowser().openURL(new URL(GRAMMAR_LANG_DOC));
											} catch (Exception e) {
												// ignore
											}
										}
									}});
								
							}
						}
					});
	}

	@Fix(INVALID_TERMINALRULE_NAME)
	public void fixTerminalRuleName(final Issue issue, IssueResolutionAcceptor acceptor){
		if(issue.getData().length == 1){
			final String upperCase = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE,issue.getData()[0]).toString();
			acceptor.accept(issue, "Change name to " + upperCase , "Change name to " + upperCase, "upcase.png", new IModification() {

				@Override
				public void apply(IModificationContext context) throws Exception {
					final IXtextDocument xtextDocument = context.getXtextDocument();
					xtextDocument.replace(issue.getOffset(), issue.getLength(), upperCase);
					xtextDocument.modify(new IUnitOfWork.Void<XtextResource>() {
						@Override
						public void process(XtextResource state) throws Exception {
							final EObject terminalRule = state.getEObject(issue.getUriToProblem().fragment());
							Iterable<RuleCall> candidates = Iterables.filter(Iterables.filter(Lists.newArrayList(state.getAllContents()),RuleCall.class), new Predicate<RuleCall>() {
								@Override
								public boolean apply(RuleCall ruleCall) {
									return ruleCall.getRule() == terminalRule;
								}
							});
							for(RuleCall ruleCall: candidates){
								List<INode> nodes = NodeModelUtils.findNodesForFeature(ruleCall, XtextPackage.eINSTANCE.getRuleCall_Rule());
								for(INode node : nodes){
									ITextRegion textRegion = node.getTextRegion();
									xtextDocument.replace(textRegion.getOffset(), textRegion.getLength(), upperCase);
								}
							}
						}
					});
				}
			});
		}
	}
	
	@Fix(EXPLICIT_OVERRIDE_MISSING)
	public void addOverrideTag(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add missing @Override annotation", "Inserts the missing @Override annotation.", null, new IModification() {
			
			@Override
			public void apply(IModificationContext context) throws Exception {
				final URI uri= issue.getUriToProblem();
				final IXtextDocument document = context.getXtextDocument(uri);
				
				if (document == null) {
					return;
				}
				
				final Integer offset = document.readOnly(new IUnitOfWork<Integer, XtextResource>() {
					
					@Override
					public Integer exec(XtextResource state) throws Exception {
						final EObject eObject = state.getEObject(uri.fragment());
						if (eObject == null) {
							return null;
						} else {
							return NodeModelUtils.findActualNodeFor(eObject).getOffset();
						}
					}
				});
				
				if (offset != null) {
					document.replace(offset.intValue(), 0, "@Override " + separatorInfo.getLineSeparator());
				}
			}
		});
	}

	@Fix(RuleWithoutInstantiationInspector.ISSUE_CODE)
	public void addAction(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add actions to ensure object creation", "Inserts the missing actions to ensure object creation.", null,
				new ISemanticModification() {
					@Override
					public void apply(EObject element, IModificationContext context) throws Exception {
						ParserRule rule = (ParserRule) element;
						MultiTextEdit textEdit = new MultiTextEdit();
						applyToNode(rule.getAlternatives(), "{" + calculateActionName(rule) + "} ", textEdit);
						textEdit.apply(context.getXtextDocument());
					}

					// algorithm to calculate the name of the action to call, including possible alias
					private String calculateActionName(ParserRule rule) {
						String actionName = rule.getName(); // rule name is default
						TypeRef type = rule.getType();
						EClassifier classifier = type.getClassifier();
						if (classifier != null) { // if there is a classifier use that instead
							AbstractMetamodelDeclaration metamodel = type.getMetamodel();
							String alias = metamodel.getAlias(); // include alias:: if an alias for the grammar is used
							actionName = (alias == null ? "" : (alias + "::")) + classifier.getName();
						}
						return actionName;
					}

					// recursive algorithm to add action to each alternative rule that is not yet instantiated
					private void applyToNode(AbstractElement node, String actionText, MultiTextEdit textEdit) throws BadLocationException {
						// reuse logic that generates the warning to analyze if we have to introduce an action
						Boolean isInstantiated = new RuleWithoutInstantiationInspector(null).doSwitch(node);
						if (isInstantiated == null || isInstantiated) {
							// rule is already instantiated completely, nothing to do
							return;
						}
						if (node instanceof Alternatives) {
							// there are multiple alternatives, some not instantiated, we have to handle each one separately
							Alternatives alternatives = (Alternatives) node;
							for (AbstractElement alternativeChild : alternatives.getElements()) {
								applyToNode(alternativeChild, actionText, textEdit);
							}
						} else {
							// rule without instantiation, add instantiation
							int offset = NodeModelUtils.findActualNodeFor(node).getOffset();
							textEdit.addChild(new InsertEdit(offset, actionText));
						}
					}
				});
	}

}
