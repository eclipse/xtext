/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionFinder;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Exceptions;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.PolymorphicDispatcher.ErrorHandler;

import com.google.common.annotations.Beta;

/**
 * <p>
 * This is an abstract base class for language-specific formatters, intended to be extended with a java class.
 * </p>
 * <p>
 * It is working very much like {@link AbstractFormatter2} but does support additional methods to simplify java
 * formatter code.
 * </p>
 * <p>
 * the "_format" or "format" methods are called by reflection. The name is important as well as there are exactly two arguments
 * whereas the first one is of the element type you like to format and the second one of type
 * {@link IFormattableDocument}. The methods should be protected.
 * </p>
 * <p>
 * Example code for a java formatter:
 * 
 * <pre>
 * import static org.xtext.example.mydsl.myDsl.MyDslPackage.Literals.*;
 * 
 * public class MyDslFormatter2 extends AbstractJavaFormatter {
 * 	protected void _format(Model model, IFormattableDocument doc) {
 * 		for (Parent parent : model.getParents())
 * 			doc.format(parent);
 * 	}
 * 
 * 	protected void _format(Parent parent, IFormattableDocument doc) {
 * 		doc.prepend(regionFor(parent).keyword("parent"), this::noSpace);
 * 		doc.append(regionFor(parent).keyword("parent"), this::oneSpace);
 * 		doc.append(regionFor(parent).feature(PARENT__NAME), this::oneSpace);
 * 		doc.prepend(regionFor(parent).keyword("{"), this::oneSpace);
 * 		doc.append(regionFor(parent).keyword("{"), this::newLine);
 * 		doc.interior(regionFor(parent).keyword("{"), regionFor(parent).keyword("}"), this::indent);
 * 		doc.append(regionFor(parent).keyword("}"), it -&gt; it.setNewLines(1, 1, 2));
 * 		for (Child child : parent.getChildren())
 * 			doc.format(child);
 * 	}
 * 
 * 	protected void _format(Child child, IFormattableDocument doc) {
 * 		doc.append(regionFor(child).keyword("child"), this::oneSpace);
 * 		doc.append(regionFor(child).feature(CHILD__NAME), this::newLine);
 * 	}
 * }
 * </pre>
 * </p>
 * <p>
 * This is suitable for the following grammar:
 * 
 * <pre>
 * grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
 * 
 * generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"
 * 
 * Model: parents+=Parent*;
 * Parent: 'parent' name=ID '!' ('{' children+=Child* '}')?;
 * Child: 'child' name=ID;
 * </pre>
 * </p>
 * 
 * @author Arne Deutsch
 * @since 2.24
 */
@Beta
public abstract class AbstractJavaFormatter extends AbstractFormatter2 {

	private PolymorphicDispatcher<Void> dispatcher = createPolymorhicDispatcher();

	// Error handler dispatches to default method in case of a missing method in concrete formatter
	public class EObjectErrorHandler implements ErrorHandler<Void> {
		@Override
		public Void handle(Object[] params, Throwable e) {
			if (e instanceof NoSuchMethodException) {
				if (params.length == 2 && params[0] instanceof EObject && params[1] instanceof IFormattableDocument) {
					_format((EObject) params[0], (IFormattableDocument) params[1]);
					return null;
				}
			}
			return Exceptions.throwUncheckedException(e);
		}
	}

	// reflective method that calls "_format" methods found in the implementing class.
	@Override
	public void format(Object child, IFormattableDocument document) {
		formatUsingPolymorphicDispatcher(child, document);
	}

	/**
	 * You can call this method in a Java subclass of an Xtend polymorphic dispatcher based subclass of this class to
	 * use the reflective behaviour again.
	 * 
	 * since 2.28
	 */
	protected void formatUsingPolymorphicDispatcher(Object child, IFormattableDocument document) {
		if (child instanceof XtextResource) {
			_format((XtextResource) child, document);
			return;
		} else if (child == null) {
			_format((Void) null, document);
			return;
		}
		try {
			dispatcher.invoke(child, document);
		} catch (SecurityException | IllegalArgumentException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Override if you like to specify formatting methods in different way then default (using annotations or similar).
	 */
	protected PolymorphicDispatcher<Void> createPolymorhicDispatcher() {
		return new PolymorphicDispatcher<Void>(Collections.singletonList(this),
				m -> ("format".equals(m.getName()) && m.getParameterCount() == 2
						&& m.getParameterTypes()[0] != Object.class // do not polymorphic dispatch on the api method itself
						&& m.getParameterTypes()[1] == IFormattableDocument.class)
					|| ("_format".equals(m.getName()) && m.getParameterCount() == 2
						&& m.getParameterTypes()[1] == IFormattableDocument.class),
				new EObjectErrorHandler());
	}

	// implementations that forward the methods of ITextRegionExtensions to simplify formatter code.

	protected ISemanticRegionsFinder allRegionsFor(EObject semanticElement) {
		return textRegionExtensions.allRegionsFor(semanticElement);
	}

	protected Iterable<ISemanticRegion> allSemanticRegions(EObject semanticElement) {
		return textRegionExtensions.allSemanticRegions(semanticElement);
	}

	protected EObject grammarElement(EObject semanticElement) {
		return textRegionExtensions.grammarElement(semanticElement);
	}

	protected ISemanticRegionFinder immediatelyFollowing(EObject semanticElement) {
		return textRegionExtensions.immediatelyFollowing(semanticElement);
	}

	protected ISemanticRegionFinder immediatelyPreceding(EObject semanticElement) {
		return textRegionExtensions.immediatelyPreceding(semanticElement);
	}

	protected boolean isMultiline(EObject semanticElement) {
		return textRegionExtensions.isMultiline(semanticElement);
	}

	protected IHiddenRegion nextHiddenRegion(EObject semanticElement) {
		return textRegionExtensions.nextHiddenRegion(semanticElement);
	}

	protected IHiddenRegion previousHiddenRegion(EObject semanticElement) {
		return textRegionExtensions.previousHiddenRegion(semanticElement);
	}

	protected ISemanticRegionsFinder regionFor(EObject semanticElement) {
		return textRegionExtensions.regionFor(semanticElement);
	}

	protected IEObjectRegion regionForEObject(EObject semanticElement) {
		return textRegionExtensions.regionForEObject(semanticElement);
	}

	protected Iterable<ISemanticRegion> semanticRegions(EObject semanticElement) {
		return textRegionExtensions.semanticRegions(semanticElement);
	}

	// implementations that delegate the methods of IHiddenRegionFormatter to allow e.g. 'this::noSpace' instead of 'it -> it.noSpace()'.

	/**
	 * Configure autowrap.
	 * @since 2.25
	 */
	protected void autowrap(IHiddenRegionFormatter hrf) {
		hrf.autowrap();
	}

	/**
	 * Suppresses auto wrap in this hidden region.
	 * @since 2.25
	 */
	protected void noAutowrap(IHiddenRegionFormatter hrf) {
		hrf.noAutowrap();
	}

	/**
	 * When merging, treat this configuration with a high priority.
	 * 
	 * @see #lowPriority(IHiddenRegionFormatter)
	 * @since 2.25
	 */
	protected void highPriority(IHiddenRegionFormatter hrf) {
		hrf.highPriority();
	}

	/**
	 * When merging, treat this configuration with a low priority.
	 * 
	 * @see #highPriority(IHiddenRegionFormatter)
	 * @since 2.25
	 */
	protected void lowPriority(IHiddenRegionFormatter hrf) {
		hrf.lowPriority();
	}

	/**
	 * Resets the indentation level to zero.
	 * @since 2.25
	 */
	protected void noIndentation(IHiddenRegionFormatter hrf) {
		hrf.noIndentation();
	}

	/**
	 * @since 2.25
	 */
	protected void indent(IHiddenRegionFormatter hrf) {
		hrf.indent();
	}

	/**
	 * Forces a line break in this hidden region.
	 * @since 2.25
	 */
	protected void newLine(IHiddenRegionFormatter hrf) {
		hrf.newLine();
	}

	/**
	 * Format this hidden region with using no space (zero characters).
	 * @since 2.25
	 */
	protected void noSpace(IHiddenRegionFormatter hrf) {
		hrf.noSpace();
	}

	/**
	 * One space is added at this hidden region.
	 * @since 2.25
	 */
	protected void oneSpace(IHiddenRegionFormatter hrf) {
		hrf.oneSpace();
	}

}
