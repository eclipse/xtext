/*******************************************************************************
 * Copyright (c) 2011, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IInputChangedListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.common.types.xtext.ui.JdtHoverProvider.JavadocHoverWrapper;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider;
import org.eclipse.xtext.ui.editor.hover.html.IXtextBrowserInformationControl;
import org.eclipse.xtext.ui.editor.hover.html.OpenBrowserUtil;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
@SuppressWarnings("restriction")
public class XbaseHoverProvider extends DefaultEObjectHoverProvider {

	@Inject
	protected XbaseDeclarativeHoverSignatureProvider hoverSignatureProvider;
	@Inject
	protected IJvmModelAssociations associations;
	@Inject
	protected IJavaElementFinder javaElementFinder;
	@Inject
	protected TypeURIHelper typeURIHelper;
	@Inject
	protected IURIEditorOpener uriEditorOpener;
	@Inject
	protected XbaseElementLinks elementLinks;
	@Inject
	protected XbaseHoverConfiguration xbaseHoverConfiguration;
	@Inject
	protected ILabelProvider labelProvider;
	@Inject 
	protected IGlobalServiceProvider serviceProvider;

	protected JavadocHoverWrapper javadocHover = new JavadocHoverWrapper();
	protected IInformationControlCreator hoverControlCreator;
	protected IInformationControlCreator presenterControlCreator;
	
	protected static final String LEADING_PADDING = "<div style='position: relative; left: 20;'>";
	protected static final String TRAILING_PADDING = "</div>";

	@Override
	protected XtextBrowserInformationControlInput getHoverInfo(EObject element, IRegion hoverRegion,
			XtextBrowserInformationControlInput previous) {
		//TODO remove this check when the typesystem works without a java project
		if (isValidationDisabled(element))
			return null;
		EObject objectToView = getObjectToView(element);
		if(objectToView == null || objectToView.eIsProxy())
			return null;
		String html = getHoverInfoAsHtml(element, objectToView, hoverRegion);
		if (html != null) {
			StringBuilder builder = new StringBuilder(html);
			ColorRegistry registry = JFaceResources.getColorRegistry();
			RGB fgRGB = registry.getRGB("org.eclipse.ui.workbench.HOVER_FOREGROUND"); //$NON-NLS-1$
			RGB bgRGB = registry.getRGB("org.eclipse.ui.workbench.HOVER_BACKGROUND"); //$NON-NLS-1$
			if (fgRGB != null && bgRGB != null) {
				HTMLPrinter.insertPageProlog(builder, 0, fgRGB, bgRGB, getStyleSheet());
			} else {
				HTMLPrinter.insertPageProlog(builder, 0, getStyleSheet());
			}
			HTMLPrinter.addPageEpilog(builder);
			html = builder.toString();
			IJavaElement javaElement = null;
			if (objectToView != element && objectToView instanceof JvmIdentifiableElement) {
				javaElement = javaElementFinder.findElementFor((JvmIdentifiableElement) objectToView);
			}
			return new XbaseInformationControlInput(previous, objectToView, javaElement, html, labelProvider);
		}
		return null;
	}
	
	private boolean isValidationDisabled(EObject objectToView) {
		Resource resource = objectToView.eResource();
		if (resource instanceof XtextResource)
			return ((XtextResource)resource).isValidationDisabled();
		// If this is not done links to native java types can be navigated in the hover
		if(resource instanceof TypeResource)
			return false;
		return true; 
	}

	/**
	 * @since 2.3
	 */
	protected String getHoverInfoAsHtml(EObject astElement, EObject objectToView, IRegion hoverRegion) {
		if(!hasHover(objectToView))
			return null;
		StringBuffer buffer = new StringBuffer();
		String oldSignature = getFirstLine(objectToView);
		if(oldSignature != null)
			buffer.append(oldSignature);
		else
			buffer.append(computeSignature(astElement, objectToView));
		String documentation = getDocumentation(objectToView);
		if (documentation != null && documentation.length() > 0) {
			buffer.append("<p>");
			buffer.append(documentation);
			buffer.append("</p>");
		}
		return buffer.toString();
	}
	/**
	 * Just to be conform to API of DefaultEObjectHoverProvider
	 * Clients may have overwritten this method to compute their signature
	 * @deprecated use {@link org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider#computeSignature(EObject, EObject)}}
	 */
	@Deprecated
	@Override
	protected String getFirstLine(EObject o) {
		return null;
	}

	/**
	 * @since 2.3
	 */
	protected EObject getObjectToView(EObject object) {
		if (object instanceof XAbstractFeatureCall) {
			return ((XAbstractFeatureCall) object).getFeature();
		} else if (object instanceof XConstructorCall)
			return ((XConstructorCall) object).getConstructor();
		return object;
	}

	/**
	 * @since 2.3
	 */
	@Override
	protected String getDocumentation(EObject o) {
		IEObjectHoverDocumentationProvider documentationProvider = serviceProvider.findService(o, IEObjectHoverDocumentationProvider.class);
		if(documentationProvider != null)
			return documentationProvider.getDocumentation(o);
		return "";
	}

	/**
	 * @since 2.3
	 */
	protected String computeSignature(EObject astElement, EObject referencedElement) {
		String imageTag =  hoverSignatureProvider.getImageTag(referencedElement);
		String signature = hoverSignatureProvider.getSignature(astElement);
		if(signature != null) {
			if (imageTag != null) {
				return "<div style='position: absolute; left: 0; top: 0;'>" + imageTag + "</div>" + LEADING_PADDING +"<b>"+ HTMLPrinter.convertToHTMLContent(signature) + "</b>" + TRAILING_PADDING;
			} else {
				return "<b>"+ HTMLPrinter.convertToHTMLContent(signature) + "</b>" + TRAILING_PADDING;
			}
		}
		return "";
	}

	@Override
	protected boolean hasHover(EObject o) {
		if (o instanceof XSwitchExpression)
			return false;
		return o instanceof JvmIdentifiableElement || super.hasHover(o);
	}

	/**
	 * @since 2.3
	 */
	@Override
	protected void addLinkListener(final IXtextBrowserInformationControl control) {
		control.addLocationListener(elementLinks.createLocationListener(new XbaseElementLinks.IXbaseLinkHandler() {

			@Override
			public void handleXtextdocViewLink(URI linkTarget) {
			}

			@Override
			public void handleInlineXtextdocLink(URI linkTarget) {
				XtextBrowserInformationControlInput hoverInfo = getHoverInfo(getTarget(linkTarget), null,
						(XtextBrowserInformationControlInput) control.getInput());
				if (control.hasDelayedInputChangeListener())
					control.notifyDelayedInputChange(hoverInfo);
				else
					control.setInput(hoverInfo);
			}

			@Override
			public void handleDeclarationLink(URI linkTarget) {
				control.notifyDelayedInputChange(null);
				control.dispose();
				if (linkTarget.scheme().equals(URIHelperConstants.PROTOCOL)) {
					BrowserInformationControlInput uncastedInput = control.getInput();
					if (uncastedInput != null) {
						XtextBrowserInformationControlInput input = (XtextBrowserInformationControlInput) uncastedInput;
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

			@Override
			public boolean handleExternalLink(URL url, Display display) {
				control.notifyDelayedInputChange(null);
				control.dispose(); //FIXME: should have protocol to hide, rather than dispose
				// open external links in real browser:
				OpenBrowserUtil.openExternal(url, display);
				return true;
			}

			@Override
			public void handleTextSet() {
			}

			EObject getTarget(URI uri) {
				ResourceSet rs = ((XtextBrowserInformationControlInput) control.getInput()).getElement().eResource()
						.getResourceSet();
				return rs.getEObject(uri, true);
			}

			@Override
			public void handleInlineJavadocLink(IJavaElement target) {
				String html = getHtmlFromIJavaElement(target);
				XtextBrowserInformationControlInput hoverInfo = new XbaseInformationControlInput((XtextBrowserInformationControlInput) control.getInput(), null, target, html, labelProvider);
				if (control.hasDelayedInputChangeListener())
					control.notifyDelayedInputChange(hoverInfo);
				else
					control.setInput(hoverInfo);
			}
		}));
	}
	
	protected String getHtmlFromIJavaElement(IJavaElement javaElement) {
		javadocHover.setJavaElement(javaElement);
		JavadocBrowserInformationControlInput hoverInfo2 = (JavadocBrowserInformationControlInput) javadocHover
				.getHoverInfo2(null, null);
		String html = hoverInfo2.getHtml();
		return html;
	}

	/**
	 * @since 2.3
	 */
	@Override
	public IInformationControlCreator getInformationPresenterControlCreator() {
		if (presenterControlCreator == null)
			presenterControlCreator = new XbasePresenterControlCreator();
		return presenterControlCreator;
	}

	@Override
	public IInformationControlCreator getHoverControlCreator() {
		if (hoverControlCreator == null)
			hoverControlCreator = new XbaseHoverControlCreator(getInformationPresenterControlCreator());
		return hoverControlCreator;
	}

	/**
	 * @since 2.3
	 */
	public class XbasePresenterControlCreator extends PresenterControlCreator {

		@Override
		public IInformationControl doCreateInformationControl(Shell parent) {
			if (XbaseInformationControl.isAvailable(parent)) {
				ToolBarManager tbm = new ToolBarManager(SWT.FLAT);
				String font = "org.eclipse.jdt.ui.javadocfont";
				IXtextBrowserInformationControl control = new XbaseInformationControl(parent, font, tbm,
						xbaseHoverConfiguration);
				control.setDisposeTimeout(getDisposeHoverTimeout());
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
				@Override
				public void inputChanged(Object newInput) {
					backAction.update();
					forwardAction.update();
					if (newInput != null && newInput instanceof XbaseInformationControlInput) {
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
	public class XbaseHoverControlCreator extends HoverControlCreator {

		protected final IInformationControlCreator fInformationPresenterControlCreator;

		public XbaseHoverControlCreator(IInformationControlCreator informationPresenterControlCreator) {
			super(informationPresenterControlCreator);
			fInformationPresenterControlCreator = informationPresenterControlCreator;
		}

		@Override
		public IInformationControl doCreateInformationControl(Shell parent) {
			String tooltipAffordanceString = EditorsUI.getTooltipAffordanceString();
			if (BrowserInformationControl.isAvailable(parent)) {
				String font = "org.eclipse.jdt.ui.javadocfont";
				IXtextBrowserInformationControl iControl = new XbaseInformationControl(parent, font,
						tooltipAffordanceString, xbaseHoverConfiguration) {
					@Override
					public IInformationControlCreator getInformationPresenterControlCreator() {
						return fInformationPresenterControlCreator;
					}
				};
				addLinkListener(iControl);
				iControl.setDisposeTimeout(getDisposeHoverTimeout());
				return iControl;
			} else {
				return new DefaultInformationControl(parent, tooltipAffordanceString);
			}
		}

	}

	/**
	 * @since 2.3
	 */
	protected class ShowInJavadocViewAction extends Action {
		private final IXtextBrowserInformationControl fInfoControl;

		public ShowInJavadocViewAction(IXtextBrowserInformationControl infoControl) {
			fInfoControl = infoControl;
			setText(XtextUIMessages.XtextBrowserInformationControlInput_ShowInJavaDocView);
			setImageDescriptor(JavaPluginImages.DESC_OBJS_JAVADOCTAG);
		}

		@Override
		public void run() {
			XtextBrowserInformationControlInput infoInput = (XtextBrowserInformationControlInput) fInfoControl
					.getInput();
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

	protected class OpenDeclarationAction extends Action {
		private final IXtextBrowserInformationControl fInfoControl;

		public OpenDeclarationAction(IXtextBrowserInformationControl infoControl) {
			fInfoControl = infoControl;
			setText(XtextUIMessages.XtextBrowserInformationControlInput_OpenDeclaration);
			JavaPluginImages.setLocalImageDescriptors(this, "goto_input.gif"); //$NON-NLS-1$ 
		}

		@Override
		public void run() {
			if (fInfoControl.getInput() instanceof XtextBrowserInformationControlInput) {
				XtextBrowserInformationControlInput infoInput = (XtextBrowserInformationControlInput) fInfoControl
						.getInput();
				fInfoControl.notifyDelayedInputChange(null);
				fInfoControl.dispose();
				// IJavaElement
				if (infoInput.getInputElement() != null && infoInput.getInputElement() instanceof IJavaElement) {
					try {
						JavaUI.openInEditor((IJavaElement) infoInput.getInputElement());
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
}
