/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.hover;

import java.net.URL;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jdt.internal.ui.infoviews.JavadocView;
import org.eclipse.jdt.internal.ui.text.java.hover.JavadocBrowserInformationControlInput;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.internal.text.html.BrowserInformationControl;
import org.eclipse.jface.internal.text.html.BrowserInformationControlInput;
import org.eclipse.jface.internal.text.html.HTMLPrinter;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IInputChangedListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.common.types.xtext.ui.JdtHoverProvider.JavadocHoverWrapper;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.hover.html.IXtextBrowserInformationControl;
import org.eclipse.xtext.ui.editor.hover.html.OpenBrowserUtil;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;
import org.eclipse.xtext.ui.editor.hover.html.XtextElementLinks;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.ui.hover.XbaseDeclarativeHoverSignatureProvider;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
public class XtendHoverProvider extends XbaseHoverProvider {

	@Inject
	private IXtendJvmAssociations associations;
	@Inject
	private ILabelProvider labelProvider;
	@Inject
	private XtendHoverConfiguration xtendHoverConfiguration;
	@Inject
	private IJavaElementFinder javaElementFinder;
	@Inject
	private IURIEditorOpener uriEditorOpener;
	@Inject
	private XtendHoverSerializer xtendHoverSerializer;
	@Inject
	private XtendHoverDocumentationProvider documentationProvider;
	@Inject
	private XtextElementLinks elementLinks;

	private IInformationControlCreator hoverControlCreator;
	private IInformationControlCreator presenterControlCreator;
	private JavadocHoverWrapper javadocHover = new JavadocHoverWrapper();


	@Override
	protected String getDocumentation(EObject o) {
		return documentationProvider.getDocumentation(o);
	}

	@Override
	protected XtextBrowserInformationControlInput getHoverInfo(EObject element, IRegion hoverRegion,
			XtextBrowserInformationControlInput previous) {
		EObject objectToView = getObjectToView(element);
		Pair<String, String> prefixAndSuffixPair = xtendHoverSerializer.computePreAndSuffix(element);
		String unsugaredExpression = xtendHoverSerializer.computeUnsugaredExpression(element);
		
		if (objectToView instanceof JvmIdentifiableElement) {
			Set<EObject> sourceElements = associations.getSourceElements(objectToView);
			if(sourceElements.isEmpty()){
				IJavaElement javaElement = javaElementFinder.findElementFor((JvmIdentifiableElement) objectToView);
				if (javaElement != null) {
					javadocHover.setJavaElement(javaElement);
					JavadocBrowserInformationControlInput hoverInfo2 = (JavadocBrowserInformationControlInput) javadocHover
							.getHoverInfo2(null, hoverRegion);
					return new XtendInformationControlInput(previous, objectToView, javaElement, hoverInfo2.getHtml(),
							labelProvider, prefixAndSuffixPair.getFirst(), unsugaredExpression,
							prefixAndSuffixPair.getSecond());
				}
			}
		}
		String html = getHoverInfoAsHtml(objectToView);
		if (html != null) {
			StringBuffer buffer = new StringBuffer(html);
			HTMLPrinter.insertPageProlog(buffer, 0, getStyleSheet());
			HTMLPrinter.addPageEpilog(buffer);
			html = buffer.toString();
			return new XtendInformationControlInput(previous, objectToView, html, labelProvider,
					prefixAndSuffixPair.getFirst(), unsugaredExpression, prefixAndSuffixPair.getSecond());
		}

		return null;
	}

	@Override
	public IInformationControlCreator getInformationPresenterControlCreator() {
		if (presenterControlCreator == null)
			presenterControlCreator = new XtendPresenterControlCreator();
		return presenterControlCreator;
	}

	@Override
	public IInformationControlCreator getHoverControlCreator() {
		if (hoverControlCreator == null)
			hoverControlCreator = new XtendHoverControlCreator(getInformationPresenterControlCreator());
		return hoverControlCreator;
	}

	/**
	 * @since 2.3
	 */
	public final class XtendPresenterControlCreator extends PresenterControlCreator {

		@Override
		public IInformationControl doCreateInformationControl(Shell parent) {
			if (XtendInformationControl.isAvailable(parent)) {
				ToolBarManager tbm = new ToolBarManager(SWT.FLAT);
				String font = "org.eclipse.jdt.ui.javadocfont";
				IXtextBrowserInformationControl control = new XtendInformationControl(parent, font, tbm,
						xtendHoverConfiguration);
				configureControl(control, tbm, font);
				return control;
			} else {
				return new DefaultInformationControl(parent, true);
			}
		}

		@Override
		protected void configureControl(final IXtextBrowserInformationControl control, ToolBarManager tbm, String font) {
			final BackAction backAction = new BackAction(control);
			backAction.setEnabled(false);
			tbm.add(backAction);
			final ForwardAction forwardAction = new ForwardAction(control);
			tbm.add(forwardAction);
			forwardAction.setEnabled(false);
			final ShowInJavadocViewAction showInJavadocViewAction = new ShowInJavadocViewAction(control);
			tbm.add(showInJavadocViewAction);
			showInJavadocViewAction.setEnabled(false);
			final OpenDeclarationAction openDeclarationAction = new OpenDeclarationAction(control);
			tbm.add(openDeclarationAction);
			IInputChangedListener inputChangeListener = new IInputChangedListener() {
				public void inputChanged(Object newInput) {
					backAction.update();
					forwardAction.update();
					if (newInput != null && newInput instanceof XtendInformationControlInput) {
						openDeclarationAction.setEnabled(true);
						if (((XtextBrowserInformationControlInput) newInput).getInputElement() != null) {
							showInJavadocViewAction.setEnabled(true);
						}
					}
				}
			};
			control.addInputChangeListener(inputChangeListener);
			tbm.update(true);
			addLinkListener(control);
		}
	}

	/**
	 * @since 2.3
	 */
	public final class XtendHoverControlCreator extends HoverControlCreator {

		private final IInformationControlCreator fInformationPresenterControlCreator;

		public XtendHoverControlCreator(IInformationControlCreator informationPresenterControlCreator) {
			super(informationPresenterControlCreator);
			fInformationPresenterControlCreator = informationPresenterControlCreator;
		}

		@Override
		public IInformationControl doCreateInformationControl(Shell parent) {
			String tooltipAffordanceString = EditorsUI.getTooltipAffordanceString();
			if (BrowserInformationControl.isAvailable(parent)) {
				String font = "org.eclipse.jdt.ui.javadocfont";
				IXtextBrowserInformationControl iControl = new XtendInformationControl(parent, font,
						tooltipAffordanceString, xtendHoverConfiguration) {
					@Override
					public IInformationControlCreator getInformationPresenterControlCreator() {
						return fInformationPresenterControlCreator;
					}
				};
				addLinkListener(iControl);
				return iControl;
			} else {
				return new DefaultInformationControl(parent, tooltipAffordanceString);
			}
		}

	}

	private EObject getObjectToView(EObject object) {
		if (object instanceof XAbstractFeatureCall) {
			return ((XAbstractFeatureCall) object).getFeature();
		}
		return object;
	}

	@Override
	protected boolean hasHover(EObject o) {
		return super.hasHover(o) || o instanceof XtendParameter || o instanceof XAbstractFeatureCall;
	}

	private static final class ShowInJavadocViewAction extends Action {
		private final IXtextBrowserInformationControl fInfoControl;

		public ShowInJavadocViewAction(IXtextBrowserInformationControl infoControl) {
			fInfoControl = infoControl;
			setText(XtextUIMessages.XtextBrowserInformationControlInput_ShowInJavaDocView);
			setImageDescriptor(JavaPluginImages.DESC_OBJS_JAVADOCTAG);
		}

		@Override
		public void run() {
			XtendInformationControlInput infoInput = (XtendInformationControlInput) fInfoControl.getInput();
			fInfoControl.notifyDelayedInputChange(null);
			fInfoControl.dispose();
			try {
				JavadocView view = (JavadocView) JavaPlugin.getActivePage().showView(JavaUI.ID_JAVADOC_VIEW);
				view.setInput(infoInput);
			} catch (PartInitException e) {
				JavaPlugin.log(e);
			}
		}
	}

	private final class OpenDeclarationAction extends Action {
		private final IXtextBrowserInformationControl fInfoControl;

		public OpenDeclarationAction(IXtextBrowserInformationControl infoControl) {
			fInfoControl = infoControl;
			setText(XtextUIMessages.XtextBrowserInformationControlInput_OpenDeclaration);
			JavaPluginImages.setLocalImageDescriptors(this, "goto_input.gif"); //$NON-NLS-1$ 
		}

		@Override
		public void run() {
			if (fInfoControl.getInput() instanceof XtendInformationControlInput) {
				XtendInformationControlInput infoInput = (XtendInformationControlInput) fInfoControl.getInput();
				fInfoControl.notifyDelayedInputChange(null);
				fInfoControl.dispose();
				// IJavaElement
				if (infoInput.getInputElement() != null) {
					try {
						JavaUI.openInEditor(infoInput.getInputElement());
					} catch (PartInitException e) {
						JavaPlugin.log(e);
					} catch (JavaModelException e) {
						JavaPlugin.log(e);
					}

				} else {
					// EObject
					if (uriEditorOpener != null)
						uriEditorOpener.open(createURI(infoInput.getElement()), true);
				}
			}
		}
	}

	/**
	 * @since 2.3
	 */
	@Override
	protected void addLinkListener(final IXtextBrowserInformationControl control) {
		control.addLocationListener(elementLinks.createLocationListener(new XtextElementLinks.ILinkHandler() {

			public void handleXtextdocViewLink(URI linkTarget) {
				// TODO: enable when XtextDoc view available
				//				control.notifyDelayedInputChange(null);
				//				control.setVisible(false);
				//				control.dispose(); //FIXME: should have protocol to hide, rather than dispose
				//				try {
				//					JavadocView view= (JavadocView) JavaPlugin.getActivePage().showView(JavaUI.ID_JAVADOC_VIEW);
				//					view.setInput(linkTarget);
				//				} catch (PartInitException e) {
				//					JavaPlugin.log(e);
				//				}
			}

			public void handleInlineXtextdocLink(URI linkTarget) {
				XtextBrowserInformationControlInput hoverInfo = getHoverInfo(getTarget(linkTarget), null,
						(XtextBrowserInformationControlInput) control.getInput());
				if (control.hasDelayedInputChangeListener())
					control.notifyDelayedInputChange(hoverInfo);
				else
					control.setInput(hoverInfo);
			}

			public void handleDeclarationLink(URI linkTarget) {
				control.notifyDelayedInputChange(null);
				control.dispose();
				if (linkTarget.scheme().equals(URIHelperConstants.PROTOCOL)) {
					BrowserInformationControlInput uncastedInput = control.getInput();
					if (uncastedInput != null) {
						XtendInformationControlInput input = (XtendInformationControlInput) uncastedInput;
						EObject element = input.getElement();
						if (element != null) {
							EObject jvmObject = element.eResource().getResourceSet().getEObject(linkTarget, true);
							if (jvmObject != null) {
								IJavaElement javaElement = javaElementFinder
										.findElementFor((JvmIdentifiableElement) jvmObject);
								try {
									JavaUI.openInEditor(javaElement);
								} catch (PartInitException e) {
									//TODO: Handle Exception
								} catch (JavaModelException e) {
									//TODO: Handle Exception
								}
							}
						}
					}
				}
				if (uriEditorOpener != null)
					uriEditorOpener.open(linkTarget, true);
			}

			public boolean handleExternalLink(URL url, Display display) {
				control.notifyDelayedInputChange(null);
				control.dispose(); //FIXME: should have protocol to hide, rather than dispose

				// open external links in real browser:
				OpenBrowserUtil.openExternal(url, display);
				return true;
			}

			public void handleTextSet() {
			}

			EObject getTarget(URI uri) {
				ResourceSet rs = ((XtextBrowserInformationControlInput) control.getInput()).getElement().eResource()
						.getResourceSet();
				return rs.getEObject(uri, true);
			}
		}));
	}
}
