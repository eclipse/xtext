/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import static org.eclipse.xtext.xbase.ui.hover.HoverLinkHelper.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TextElement;
import org.eclipse.jdt.ui.JavaElementLabels;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.EclipseSourceFolderProvider;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider;
import org.eclipse.xtext.ui.editor.hover.html.XtextElementLinks;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class XbaseHoverDocumentationProvider implements IEObjectHoverDocumentationProvider {
	
	protected static final String BLOCK_TAG_START = "<dl>"; //$NON-NLS-1$
	protected static final String BLOCK_TAG_END = "</dl>"; //$NON-NLS-1$
	protected static final String BlOCK_TAG_ENTRY_START = "<dd>"; //$NON-NLS-1$
	protected static final String BlOCK_TAG_ENTRY_END = "</dd>"; //$NON-NLS-1$
	protected static final String PARAM_NAME_START = "<b>"; //$NON-NLS-1$
	protected static final String PARAM_NAME_END = "</b> "; //$NON-NLS-1$
	
	@Inject
	protected IScopeProvider scopeProvider;
	@Inject
	protected IQualifiedNameConverter qualifiedNameConverter;
	@Inject
	protected IWorkspace workspace;
	@Inject
	protected IJvmModelAssociations associations;
	@Inject
	protected IEObjectDocumentationProvider documentationProvider;
	@Inject
	protected JvmAnnotationReferencePrinter annotationValuePrinter;
	@Inject
	private XbaseDeclarativeHoverSignatureProvider hoverSignatureProvider;
	@Inject
	IGeneratorConfigProvider generatorConfigProvider;
	@Inject
	private IWhitespaceInformationProvider whitespaceInformationProvider;
	@Inject
	private JvmTypeExtensions typeExtensions;
	@Inject
	private EclipseSourceFolderProvider sourceFolderProvider;

	protected String rawJavaDoc = "";
	protected EObject context = null;
	
	protected StringBuffer buffer;
	protected int fLiteralContent;

	@Override
	public String getDocumentation(EObject object) {
		return computeDocumentation(object) + getDerivedOrOriginalDeclarationInformation(object);
	}

	public String computeDocumentation(EObject object) {
		buffer = new StringBuffer();
		context = object;
		fLiteralContent = 0;
		List<String> parameterNames = initParameterNames();
		Map<String, URI> exceptionNamesToURI = initExceptionNamesToURI();
		addAnnotations(object);
		getDocumentationWithPrefix(object);
		Javadoc javadoc = getJavaDoc();
		if (javadoc == null)
			return buffer.toString();
		TagElement deprecatedTag = null;
		TagElement start = null;
		List<TagElement> parameters = new ArrayList<TagElement>();
		TagElement returnTag = null;
		List<TagElement> exceptions = new ArrayList<TagElement>();
		List<TagElement> versions = new ArrayList<TagElement>();
		List<TagElement> authors = new ArrayList<TagElement>();
		List<TagElement> sees = new ArrayList<TagElement>();
		List<TagElement> since = new ArrayList<TagElement>();
		List<TagElement> rest = new ArrayList<TagElement>();
		@SuppressWarnings("unchecked")
		List<TagElement> tags = javadoc.tags();
		for (Iterator<TagElement> iter = tags.iterator(); iter.hasNext();) {
			TagElement tag = iter.next();
			String tagName = tag.getTagName();
			if (tagName == null) {
				start = tag;
			} else if (TagElement.TAG_PARAM.equals(tagName)) {
				parameters.add(tag);
				@SuppressWarnings("unchecked")
				List<? extends ASTNode> fragments = tag.fragments();
				if (fragments.size() > 0) {
					Object first = fragments.get(0);
					if (first instanceof SimpleName) {
						String name = ((SimpleName) first).getIdentifier();
						int paramIndex = parameterNames.indexOf(name);
						if (paramIndex != -1) {
							parameterNames.set(paramIndex, null);
						}
					}
				}
			} else if (TagElement.TAG_RETURN.equals(tagName)) {
				if (returnTag == null)
					returnTag = tag; // the Javadoc tool only shows the first return tag
			} else if (TagElement.TAG_EXCEPTION.equals(tagName) || TagElement.TAG_THROWS.equals(tagName)) {
				exceptions.add(tag);
				@SuppressWarnings("unchecked")
				List<? extends ASTNode> fragments = tag.fragments();
				if (fragments.size() > 0) {
					Object first = fragments.get(0);
					if (first instanceof Name) {
						@SuppressWarnings("restriction")
						String name = org.eclipse.jdt.internal.corext.dom.ASTNodes.getSimpleNameIdentifier((Name) first);
						if (exceptionNamesToURI.containsKey(name)) {
							exceptionNamesToURI.put(name, null);
						}
					}
				}
			} else if (TagElement.TAG_SINCE.equals(tagName)) {
				since.add(tag);
			} else if (TagElement.TAG_VERSION.equals(tagName)) {
				versions.add(tag);
			} else if (TagElement.TAG_AUTHOR.equals(tagName)) {
				authors.add(tag);
			} else if (TagElement.TAG_SEE.equals(tagName)) {
				sees.add(tag);
			} else if (TagElement.TAG_DEPRECATED.equals(tagName)) {
				if (deprecatedTag == null)
					deprecatedTag = tag; // the Javadoc tool only shows the first deprecated tag
			} else {
				rest.add(tag);
			}
		}

		boolean hasParameters = parameters.size() > 0;
		boolean hasReturnTag = returnTag != null;
		boolean hasExceptions = exceptions.size() > 0;
		if (deprecatedTag != null)
			handleDeprecatedTag(deprecatedTag);
		if (start != null) {
			@SuppressWarnings("unchecked")
			List<ASTNode> fragments = start.fragments();
			handleContentElements(fragments);
		}

		if (hasParameters || hasReturnTag || hasExceptions || versions.size() > 0 || authors.size() > 0
				|| since.size() > 0 || sees.size() > 0 || rest.size() > 0 || (buffer.length() > 0)
				&& (parameterNames.size() > 0 || exceptionNamesToURI.size() > 0)) {
			handleSuperMethodReferences(object);
			buffer.append(BLOCK_TAG_START);
			handleParameters(object, parameters, parameterNames);
			handleReturnTag(returnTag);
			handleExceptionTags(exceptions, exceptionNamesToURI);
			handleBlockTags("Since:", since);
			handleBlockTags("Version:", versions);
			handleBlockTags("Author:", authors);
			handleBlockTags("See Also:", sees);
			handleBlockTags(rest);
			buffer.append(BLOCK_TAG_END);
		} else if (buffer.length() > 0) {
			handleSuperMethodReferences(object);
		}
		String result = buffer.toString();
		buffer = null;
		rawJavaDoc = null;
		context = null;
		return result;
	}

	public String getDerivedOrOriginalDeclarationInformation(EObject object) {
		String derivedInformation = getDerivedElementInformation(object);
		if (derivedInformation != null && derivedInformation.length() > 0)
			return getDerivedElementInformation(object);
		return getOriginalDeclarationInformation(object);
	}

	protected List<String> initParameterNames() {
		List<String> result = Lists.newArrayList();
		if (context instanceof JvmExecutable) {
			for (JvmFormalParameter param : ((JvmExecutable) context).getParameters()) {
				result.add(param.getName());
			}
		}
		return result;
	}

	protected Map<String, URI> initExceptionNamesToURI() {
		Map<String, URI> result = Maps.newHashMap();
		if (context instanceof JvmExecutable) {
			for (JvmTypeReference exception : ((JvmExecutable) context).getExceptions()) {
				result.put(exception.getSimpleName(), EcoreUtil.getURI(exception.getType()));
			}
		}
		return result;
	}

	protected void addAnnotations(EObject object) {
		List<JvmAnnotationReference> annotations = Lists.newArrayList();
		if(object instanceof JvmAnnotationTarget) {
			annotations.addAll(((JvmAnnotationTarget) object).getAnnotations());
		} else {
			Set<EObject> jvmElements = associations.getJvmElements(object);
			if (jvmElements.size() > 0) {
				EObject associatedElement = Lists.newArrayList(jvmElements).get(0);
				if (associatedElement instanceof JvmAnnotationTarget) {
					annotations.addAll(((JvmAnnotationTarget) associatedElement).getAnnotations());
				}
			}
		}
		for (JvmAnnotationReference annotationReference : annotations) {
			if (!typeExtensions.isSynthetic(annotationReference)) {
				buffer.append(annotationValuePrinter.toHtmlString(annotationReference));
				buffer.append("<br>");
			}
		}

	}

	protected void getDocumentationWithPrefix(EObject object) {
		String startTag = "/**";
		String endTag = "*/";
		ILineSeparatorInformation lineSeparatorInformation = whitespaceInformationProvider
				.getLineSeparatorInformation(EcoreUtil.getURI(object));
		String lineBreak = lineSeparatorInformation.getLineSeparator();
		String documentation = resolveDocumentation(object);
		if (documentation != null && documentation.length() > 0) {
			BufferedReader reader = new BufferedReader(new StringReader(documentation));
			StringBuilder builder = new StringBuilder(startTag + lineBreak);
			try {
				String line = "";
				while ((line = reader.readLine()) != null) {
					if (line.length() > 0)
						builder.append(line + lineBreak);
				}
				builder.append(endTag);
			} catch (IOException e) {

			}
			rawJavaDoc = builder.toString();
		}
	}

	protected String resolveDocumentation(EObject object) {
		String documentation = documentationProvider.getDocumentation(object);
		if (documentation != null) {
			return documentation;
		}
		DocumentationAdapter adapter = getDocumentationAdapter(object);
		if (adapter != null) {
			documentation = adapter.getDocumentation();
		}
		if (documentation != null) {
			return documentation;
		}
		EObject primarySourceElement = associations.getPrimarySourceElement(object);
		if (primarySourceElement == null) {
			return null;
		}
		return documentationProvider.getDocumentation(primarySourceElement);
	}

	protected DocumentationAdapter getDocumentationAdapter(EObject object) {
		return (DocumentationAdapter) EcoreUtil.getAdapter(object.eAdapters(), DocumentationAdapter.class);
	}

	protected void handleSuperMethodReferences(EObject context) {
		// Not handled for Xbase
	}

	protected String createMethodInTypeLinks(JvmOperation overridden) {
		String methodLink = createSimpleMemberLink(overridden);
		String typeLink = createSimpleMemberLink(overridden.getDeclaringType());
		String methodInType = MessageFormat.format("{0} in {1}", new Object[] { methodLink, typeLink });
		return methodInType;
	}

	protected String createSimpleMemberLink(EObject type) {
		String label = "";
		if (type instanceof JvmDeclaredType)
			label = ((JvmDeclaredType) type).getSimpleName();
		else if (type instanceof JvmOperation) {
			JvmOperation operation = (JvmOperation) type;
			label = operation.getSimpleName();
			if (operation.getParameters().size() > 0) {
				label += "(...)";
			}
		}
		return createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, EcoreUtil.getURI(type), label);
	}

	protected boolean handleValueTag(TagElement node) {
		// Not handled explicit for Xbase for now
		handleText(node.toString());
		return true;
	}

	protected boolean handleInheritDoc(TagElement node) {
		if (!TagElement.TAG_INHERITDOC.equals(node.getTagName()))
			return false;
		// Not handled explicit for Xbase for now
		handleText(node.toString());
		return true;
	}

	protected boolean handleDocRoot(TagElement node) {
		if (!TagElement.TAG_DOCROOT.equals(node.getTagName()))
			return false;
		URI uri = EcoreUtil.getURI(context);
		if (uri.isPlatformResource()) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
			IPath fullPath = file.getFullPath();
			IProject project = file.getProject();
			if (project.exists() && project.isOpen()) {
				for (IContainer f : sourceFolderProvider.getSourceFolders(project)) {
					if (f.getFullPath().isPrefixOf(fullPath)) {
						IPath location = f.getLocation();
						if (location != null) {
							buffer.append(location.toFile().toURI().toASCIIString());
							return true;
						}
					}
				}
			}
		}
		return true;
	}

	protected void handleLink(List<?> fragments) {
		if (fragments == null || fragments.isEmpty()) {
			return;
		}
		URI elementURI = null;
		String firstFragment = fragments.get(0).toString();
		int hashIndex = firstFragment.indexOf("#");
		if (hashIndex != -1) {
			JvmDeclaredType resolvedDeclarator = getResolvedDeclarator(firstFragment.substring(0, hashIndex));
			if (resolvedDeclarator != null && !resolvedDeclarator.eIsProxy()) {
				String signature = firstFragment.substring(hashIndex + 1);
				int indexOfOpenBracket = signature.indexOf("(");
				int indexOfClosingBracket = signature.indexOf(")");
				String simpleNameOfFeature = indexOfOpenBracket != -1 ? signature.substring(0, indexOfOpenBracket)
						: signature;
				Iterable<JvmConstructor> constructorCandidates = new ArrayList<JvmConstructor>();
				if (resolvedDeclarator.getSimpleName().equals(simpleNameOfFeature)) {
					constructorCandidates = resolvedDeclarator.getDeclaredConstructors();
				}
				Iterable<JvmFeature> possibleCandidates = Iterables.concat(
					resolvedDeclarator.findAllFeaturesByName(simpleNameOfFeature),
					constructorCandidates
				);
				List<String> parameterNames = null;
				if (indexOfOpenBracket != -1 && indexOfClosingBracket != -1) {
					parameterNames = Strings.split(signature.substring(indexOfOpenBracket + 1, indexOfClosingBracket),
							",");
				}
				Iterator<JvmFeature> featureIterator = possibleCandidates.iterator();
				while (elementURI == null && featureIterator.hasNext()) {
					JvmFeature feature = featureIterator.next();
					boolean valid = false;
					if (feature instanceof JvmField) {
						valid = true;
					} else if (feature instanceof JvmExecutable) {
						JvmExecutable executable = (JvmExecutable) feature;
						EList<JvmFormalParameter> parameters = executable.getParameters();
						if (parameterNames == null) {
							valid = true;
						} else if (parameters.size() == parameterNames.size()) {
							valid = true;
							for (int i = 0; (i < parameterNames.size() && valid); i++) {
								URI parameterTypeURI = EcoreUtil.getURI(parameters.get(i).getParameterType().getType());
								IEObjectDescription expectedParameter = scopeProvider.getScope(context,
										new HoverReference(TypesPackage.Literals.JVM_TYPE)).getSingleElement(
										qualifiedNameConverter.toQualifiedName(parameterNames.get(i)));
								if (expectedParameter == null
										|| !expectedParameter.getEObjectURI().equals(parameterTypeURI)) {
									valid = false;
								}
							}
						}
					}
					if (valid)
						elementURI = EcoreUtil.getURI(feature);
				}
			}
		} else {
			IScope scope = scopeProvider.getScope(context, new HoverReference(TypesPackage.Literals.JVM_TYPE));
			IEObjectDescription singleElement = scope.getSingleElement(qualifiedNameConverter
					.toQualifiedName(firstFragment));
			if (singleElement != null)
				elementURI = singleElement.getEObjectURI();
		}
		String label = "";
		if (fragments.size() > 1) {
			for (int i = 1; i < fragments.size(); i++) {
				String portentialLabel = fragments.get(i).toString();
				if (portentialLabel.trim().length() > 0)
					label += portentialLabel;
			}
		}
		if (label.length() == 0)
			label = firstFragment;
		if (elementURI == null)
			buffer.append(label);
		else {
			buffer.append(createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, elementURI, label));
		}
	}

	protected JvmDeclaredType getResolvedDeclarator(String name) {
		JvmDeclaredType jvmDeclaredType = null;
		if (Strings.isEmpty(name) || name.trim().length() == 0) {
			jvmDeclaredType = getDeclaringType(context);
		} else {
			HoverReference reference = new HoverReference(TypesPackage.Literals.JVM_TYPE);
			IScope scope = scopeProvider.getScope(context, reference);
			IEObjectDescription declarator = scope.getSingleElement(qualifiedNameConverter.toQualifiedName(name));
			if (declarator != null
					&& EcoreUtil2.isAssignableFrom(TypesPackage.eINSTANCE.getJvmGenericType(), declarator.getEClass())) {
				jvmDeclaredType = (JvmDeclaredType) context.eResource().getResourceSet()
						.getEObject(declarator.getEObjectURI(), true);
			}
		}
		return jvmDeclaredType;
	}

	protected JvmDeclaredType getDeclaringType(EObject eObject) {
		if (eObject instanceof JvmDeclaredType) {
			return (JvmDeclaredType) eObject;
		}
		if (eObject instanceof JvmMember) {
			return ((JvmMember) eObject).getDeclaringType();
		}
		return null;
	}

	protected void handleBlockTags(List<TagElement> tags) {
		for (Iterator<TagElement> iter = tags.iterator(); iter.hasNext();) {
			TagElement tag = iter.next();
			handleBlockTagTitle(tag.getTagName());
			buffer.append(BlOCK_TAG_ENTRY_START);
			@SuppressWarnings("unchecked")
			List<ASTNode> fragments = tag.fragments();
			handleContentElements(fragments);
			buffer.append(BlOCK_TAG_ENTRY_END);
		}
	}

	protected void handleBlockTags(String title, List<TagElement> tags) {
		if (tags.isEmpty())
			return;
		handleBlockTagTitle(title);
		for (Iterator<TagElement> iter = tags.iterator(); iter.hasNext();) {
			TagElement tag = iter.next();
			buffer.append(BlOCK_TAG_ENTRY_START);
			if (TagElement.TAG_SEE.equals(tag.getTagName())) {
				handleSeeTag(tag);
			} else {
				@SuppressWarnings("unchecked")
				List<ASTNode> fragments = tag.fragments();
				handleContentElements(fragments);
			}
			buffer.append(BlOCK_TAG_ENTRY_END);
		}
	}

	protected void handleSeeTag(TagElement tag) {
		handleLink(tag.fragments());
	}

	protected void handleExceptionTags(List<TagElement> tags, Map<String, URI> exceptionNamesToURI) {
		if (tags.size() == 0 && containsOnlyNull(exceptionNamesToURI.values()))
			return;
		handleBlockTagTitle("Throws:");
		for (Iterator<TagElement> iter = tags.iterator(); iter.hasNext();) {
			TagElement tag = iter.next();
			buffer.append(BlOCK_TAG_ENTRY_START);
			handleThrowsTag(tag);
			buffer.append(BlOCK_TAG_ENTRY_END);
		}
		for (int i = 0; i < exceptionNamesToURI.size(); i++) {
			String name = Lists.newArrayList(exceptionNamesToURI.keySet()).get(i);
			if (name != null && exceptionNamesToURI.get(name) != null) {
				buffer.append(BlOCK_TAG_ENTRY_START);
				buffer.append(createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, exceptionNamesToURI.get(name),
						name));
				buffer.append(BlOCK_TAG_ENTRY_END);
			}
		}
	}

	private boolean containsOnlyNull(Collection<?> list) {
		for (Iterator<?> iter = list.iterator(); iter.hasNext();) {
			if (iter.next() != null)
				return false;
		}
		return true;
	}

	protected void handleThrowsTag(TagElement tag) {
		@SuppressWarnings("unchecked")
		List<? extends ASTNode> fragments = tag.fragments();
		int size = fragments.size();
		if (size > 0) {
			handleLink(fragments.subList(0, 1));
			if (size > 1) {
				buffer.append(JavaElementLabels.CONCAT_STRING);
				handleContentElements(fragments.subList(1, size));
			}
		}
	}

	protected void handleDeprecatedTag(TagElement tag) {
		buffer.append("<p><b>"); //$NON-NLS-1$
		//TODO: Messages out of properties like in JDT?
		buffer.append("Deprecated.");
		buffer.append("</b> <i>"); //$NON-NLS-1$
		@SuppressWarnings("unchecked")
		List<ASTNode> fragments = tag.fragments();
		handleContentElements(fragments);
		buffer.append("</i></p>"); //$NON-NLS-1$
	}

	protected void handleContentElements(List<? extends ASTNode> nodes) {
		handleContentElements(nodes, false);
	}

	protected void handleContentElements(List<? extends ASTNode> nodes, boolean skipLeadingWhitespace) {
		ASTNode previousNode = null;
		for (Iterator<? extends ASTNode> iter = nodes.iterator(); iter.hasNext();) {
			ASTNode child = iter.next();
			if (previousNode != null) {
				int previousEnd = previousNode.getStartPosition() + previousNode.getLength();
				int childStart = child.getStartPosition();
				if (previousEnd > childStart) {
					// should never happen, see https://bugs.eclipse.org/bugs/show_bug.cgi?id=304826
				} else if (previousEnd != childStart) {
					// Need to preserve whitespace before a node that's not
					// directly following the previous node (e.g. on a new line)
					// due to https://bugs.eclipse.org/bugs/show_bug.cgi?id=206518 :
					String textWithStars = rawJavaDoc.substring(previousEnd, childStart);
					String text = removeDocLineIntros(textWithStars);
					buffer.append(text);
				}
			}
			previousNode = child;
			if (child instanceof TextElement) {
				String text = ((TextElement) child).getText();
				if (skipLeadingWhitespace) {
					text = text.replaceFirst("^\\s+", ""); //$NON-NLS-1$ //$NON-NLS-2$
				}
				handleText(text);
			} else if (child instanceof TagElement) {
				handleInlineTagElement((TagElement) child);
			} else {
				// This is unexpected. Fail gracefully by just copying the source.
				int start = child.getStartPosition();
				String text = rawJavaDoc.substring(start, start + child.getLength());
				buffer.append(removeDocLineIntros(text));
			}
		}
	}

	protected void handleInlineTagElement(TagElement node) {
		String name = node.getTagName();
		if (TagElement.TAG_VALUE.equals(name) && handleValueTag(node))
			return;
		boolean isLink = TagElement.TAG_LINK.equals(name);
		boolean isLinkplain = TagElement.TAG_LINKPLAIN.equals(name);
		boolean isCode = TagElement.TAG_CODE.equals(name);
		boolean isLiteral = TagElement.TAG_LITERAL.equals(name);
		if (isLiteral || isCode)
			fLiteralContent++;
		if (isLink || isCode)
			buffer.append("<code>"); //$NON-NLS-1$
		if (isLink || isLinkplain)
			handleLink(node.fragments());
		else if (isCode || isLiteral) {
			@SuppressWarnings("unchecked")
			List<ASTNode> fragments = node.fragments();
			handleContentElements(fragments, true);
		} else if (handleInheritDoc(node)) {
			// handled
		} else if (handleDocRoot(node)) {
			// handled
		} else {
			//print uninterpreted source {@tagname ...} for unknown tags
			int start = node.getStartPosition();
			String text = rawJavaDoc.substring(start, start + node.getLength());
			buffer.append(removeDocLineIntros(text));
		}
		if (isLink || isCode)
			buffer.append("</code>"); //$NON-NLS-1$
		if (isLiteral || isCode)
			fLiteralContent--;

	}

	protected void handleText(String text) {
		if (fLiteralContent == 0) {
			buffer.append(text);
		} else {
			appendEscaped(buffer, text);
		}
	}

	protected void appendEscaped(StringBuffer buf, String text) {
		int nextToCopy = 0;
		int length = text.length();
		for (int i = 0; i < length; i++) {
			char ch = text.charAt(i);
			String rep = null;
			switch (ch) {
				case '&':
					rep = "&amp;"; //$NON-NLS-1$
					break;
				case '"':
					rep = "&quot;"; //$NON-NLS-1$
					break;
				case '<':
					rep = "&lt;"; //$NON-NLS-1$
					break;
				case '>':
					rep = "&gt;"; //$NON-NLS-1$
					break;
			}
			if (rep != null) {
				if (nextToCopy < i)
					buf.append(text.substring(nextToCopy, i));
				buf.append(rep);
				nextToCopy = i + 1;
			}
		}
		if (nextToCopy < length)
			buf.append(text.substring(nextToCopy));
	}

	protected String removeDocLineIntros(String textWithStars) {
		String lineBreakGroup = "(\\r\\n?|\\n)"; //$NON-NLS-1$
		String noBreakSpace = "[^\r\n&&\\s]"; //$NON-NLS-1$
		return textWithStars.replaceAll(lineBreakGroup + noBreakSpace + "*\\*" /*+ noBreakSpace + '?'*/, "$1"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	protected void handleParameters(EObject object, List<TagElement> parameters, List<String> parameterNames) {
		if (parameters.size() == 0 && containsOnlyNull(parameterNames))
			return;
		handleBlockTagTitle("Parameters:");
		for (Iterator<TagElement> iter = parameters.iterator(); iter.hasNext();) {
			TagElement tag = iter.next();
			buffer.append(BlOCK_TAG_ENTRY_START);
			handleParamTag(tag);
			buffer.append(BlOCK_TAG_ENTRY_END);
		}

		for (int i = 0; i < parameterNames.size(); i++) {
			String name = parameterNames.get(i);
			if (name != null) {
				buffer.append(BlOCK_TAG_ENTRY_START);
				buffer.append(PARAM_NAME_START);
				buffer.append(name);
				buffer.append(PARAM_NAME_END);
				buffer.append(BlOCK_TAG_ENTRY_END);
			}
		}
	}

	protected void handleParamTag(TagElement tag) {
		@SuppressWarnings("unchecked")
		List<? extends ASTNode> fragments = tag.fragments();
		int i = 0;
		int size = fragments.size();
		if (size > 0) {
			Object first = fragments.get(0);
			buffer.append(PARAM_NAME_START);
			if (first instanceof SimpleName) {
				String name = ((SimpleName) first).getIdentifier();
				buffer.append(name);
				i++;
			} else if (first instanceof TextElement) {
				String firstText = ((TextElement) first).getText();
				if ("<".equals(firstText)) { //$NON-NLS-1$
					buffer.append("&lt;"); //$NON-NLS-1$
					i++;
					if (size > 1) {
						Object second = fragments.get(1);
						if (second instanceof SimpleName) {
							String name = ((SimpleName) second).getIdentifier();
							buffer.append(name);
							i++;
							if (size > 2) {
								Object third = fragments.get(2);
								String thirdText = ((TextElement) third).getText();
								if (">".equals(thirdText)) { //$NON-NLS-1$
									buffer.append("&gt;"); //$NON-NLS-1$
									i++;
								}
							}
						}
					}
				}
			}
			buffer.append(PARAM_NAME_END);
			handleContentElements(fragments.subList(i, fragments.size()));
		}
	}

	protected void handleReturnTag(TagElement tag) {
		if (tag == null)
			return;
		handleBlockTagTitle("Returns:");
		buffer.append(BlOCK_TAG_ENTRY_START);
		@SuppressWarnings("unchecked")
		List<ASTNode> fragments = tag.fragments();
		handleContentElements(fragments);
		buffer.append(BlOCK_TAG_ENTRY_END);
	}

	protected void handleBlockTagTitle(String title) {
		buffer.append("<dt>"); //$NON-NLS-1$
		buffer.append(title);
		buffer.append("</dt>"); //$NON-NLS-1$
	}

	@SuppressWarnings("unchecked")
	public Javadoc getJavaDoc() {
		if (context == null || context.eResource() == null || context.eResource().getResourceSet() == null)
			return null;
		Object classpathURIContext = ((XtextResourceSet) context.eResource().getResourceSet()).getClasspathURIContext();
		if (classpathURIContext instanceof IJavaProject) {
			IJavaProject javaProject = (IJavaProject) classpathURIContext;
			@SuppressWarnings("all")
			ASTParser parser = ASTParser.newParser(AST.JLS3);
			parser.setProject(javaProject);
			Map<String, String> options = javaProject.getOptions(true);
			options.put(JavaCore.COMPILER_DOC_COMMENT_SUPPORT, JavaCore.ENABLED); // workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=212207
			parser.setCompilerOptions(options);
			String source = rawJavaDoc + "class C{}"; //$NON-NLS-1$
			parser.setSource(source.toCharArray());
			CompilationUnit root = (CompilationUnit) parser.createAST(null);
			if (root == null)
				return null;
			List<AbstractTypeDeclaration> types = root.types();
			if (types.size() != 1)
				return null;
			AbstractTypeDeclaration type = types.get(0);
			return type.getJavadoc();
		}
		return null;
	}

	protected String getDerivedElementInformation(EObject o) {
		StringBuffer buf = new StringBuffer();
		List<EObject> jvmElements = getFilteredDerivedElements(o, TypesPackage.Literals.JVM_MEMBER);
		if (jvmElements.size() > 0) {
			buf.append("<dt>Derived element:</dt>");

			for (EObject jvmElement : jvmElements) {
				buf.append("<dd>");
				buf.append(computeLinkToElement(jvmElement));
				buf.append("</dd>");
			}
		}
		return buf.toString();
	}

	protected String getOriginalDeclarationInformation(EObject o) {
		StringBuffer buf = new StringBuffer();
		List<EObject> sourceElements = getFilteredSourceElements(o, null);
		if (sourceElements.size() > 0) {
			buf.append("<dt>Original declaration:</dt>");
			for (EObject sourceElement : sourceElements) {
				buf.append("<dd>");
				buf.append(computeLinkToElement(sourceElement));
				buf.append("</dd>");
			}
		}
		return buf.toString();
	}

	protected List<EObject> getFilteredDerivedElements(EObject o, final EClass type) {
		List<EObject> jvmElements = Lists.newArrayList(Iterables.filter(associations.getJvmElements(o),
				new Predicate<EObject>() {
					@Override
					public boolean apply(EObject input) {
						if (input instanceof JvmConstructor && ((JvmConstructor) input).getParameters().size() == 0)
							return false;
						if (type == null)
							return true;
						return EcoreUtil2.isAssignableFrom(type, input.eClass());
					}
				}));
		return jvmElements;
	}

	protected List<EObject> getFilteredSourceElements(EObject o, final EClass type) {
		List<EObject> sourceElements = Lists.newArrayList(Iterables.filter(associations.getSourceElements(o),
				new Predicate<EObject>() {
					@Override
					public boolean apply(EObject input) {
						if (type == null)
							return true;
						return EcoreUtil2.isAssignableFrom(type, input.eClass());
					}
				}));
		return sourceElements;
	}

	private String computeLinkToElement(EObject jvmElement) {
		String imageURL = hoverSignatureProvider.getImageTag(jvmElement);
		String signature = hoverSignatureProvider.getDerivedOrSourceSignature(jvmElement);
		String linkWithLabel = createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME, EcoreUtil.getURI(jvmElement), signature);
		if (imageURL == null)
			return linkWithLabel;
		else
			return imageURL + linkWithLabel;
	}

}
