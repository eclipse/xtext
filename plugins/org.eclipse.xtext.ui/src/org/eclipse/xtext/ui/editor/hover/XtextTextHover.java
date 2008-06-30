/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.AbstractInformationControl;
import org.eclipse.jface.text.DefaultTextHover;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IInformationControlExtension2;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHoverExtension;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.Geometry;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.PaintObjectEvent;
import org.eclipse.swt.custom.PaintObjectListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.editor.model.IEditorModelProvider;
import org.eclipse.xtext.ui.editor.utils.EditorModelUtil;
import org.eclipse.xtext.ui.service.ILabelProvider;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextTextHover extends DefaultTextHover implements ITextHoverExtension, ITextHoverExtension2 {
	/**
	 * 
	 */
	private IEditorModelProvider editorModelProvider;
	private final ILabelProvider labelProvider;
	protected ToolBarManager toolBarManager;

	/**
	 * @param sourceViewer
	 * @param editorModelProvider
	 */
	public XtextTextHover(ISourceViewer sourceViewer, IEditorModelProvider editorModelProvider,
			ILabelProvider labelProvider) {
		super(sourceViewer);
		this.editorModelProvider = editorModelProvider;
		this.labelProvider = labelProvider;
		// TODO add some actions
		toolBarManager = new ToolBarManager();
		Action action = new Action("Coole Action") {
			@Override
			public void run() {
				System.out.println("XtextTextHover.run(): Coole action macht gerade was ganz cooles!");
			}
		};
		action.setEnabled(true);
		action.setImageDescriptor(ImageDescriptor.createFromImage(PlatformUI.getWorkbench().getSharedImages().getImage(
				ISharedImages.IMG_OBJ_FILE)));
		Action action2 = new Action("Das ist ein Drucker") {
		};
		action2.setEnabled(true);
		action2.setImageDescriptor(ImageDescriptor.createFromImage(PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_ETOOL_PRINT_EDIT)));
		toolBarManager.add(action);
		toolBarManager.add(action2);
	}

	/**
	 * @author Dennis Hübner - Initial contribution and API
	 * 
	 */
	private final class XtextInformationControl extends AbstractInformationControl implements
			IInformationControlExtension2 {
		private StyledText st = null;
		private boolean enableScrollbars;
		private Image icon;// TODO icon disposition

		private XtextInformationControl(Shell parentShell, String statusFieldText) {
			super(parentShell, statusFieldText);
			enableScrollbars = false;
			create();
		}

		public XtextInformationControl(Shell parent, ToolBarManager toolBarManager) {
			super(parent, toolBarManager);
			enableScrollbars = true;
			create();
		}

		@Override
		protected void createContent(Composite parent) {
			st = new StyledText(parent, SWT.WRAP | SWT.MULTI | SWT.READ_ONLY
					| (enableScrollbars ? SWT.V_SCROLL | SWT.H_SCROLL : SWT.NONE));
			st.setForeground(parent.getForeground());
			st.setBackground(parent.getBackground());
			st.setFont(JFaceResources.getDialogFont());
			st.addPaintObjectListener(new PaintObjectListener() {
				public void paintObject(PaintObjectEvent event) {
					GC gc = event.gc;
					StyleRange style = event.style;
					int start = style.start;
					if (start == 0 && icon != null) {
						Image image = icon;
						int x = event.x + 2;
						int y = event.y + 2 + event.ascent - style.metrics.ascent;
						gc.drawImage(image, x, y);
					}
				}
			});

		}

		@Override
		public Point computeSizeHint() {
			int widthHint = 0;
			Point constraints = getSizeConstraints();
			if (constraints != null && st.getWordWrap())
				widthHint = constraints.x;
			return getShell().computeSize(widthHint, SWT.DEFAULT, true);
		}

		@Override
		public Rectangle computeTrim() {
			return Geometry.add(super.computeTrim(), st.computeTrim(0, 0, 0, 0));
		}

		public boolean hasContents() {
			return st.getCharCount() > 0;
		}

		public void setInput(Object input) {
			if (input instanceof EObject) {
				EObject eObject = (EObject) input;
				StyledString ss = new StyledString("  ");
				ss.append(labelProvider.getLabel(eObject));
				st.setText(ss.getString() + "\n" + "\t\t\t" + getAdditionalInfo(eObject));
				icon = labelProvider.getIcon(eObject);
				st.setStyleRanges(ss.getStyleRanges());
				addImage();
			}
			else {
				super.setInformation(input.toString());
			}

		}

		private void addImage() {
			StyleRange style = new StyleRange();
			style.start = 0;
			style.length = 1;
			Rectangle rect = icon.getBounds();
			style.metrics = new GlyphMetrics(rect.height + 4, 0, rect.width + 4);
			st.setStyleRange(style);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.text.AbstractInformationControl#
		 * getInformationPresenterControlCreator()
		 */
		public IInformationControlCreator getInformationPresenterControlCreator() {
			return new IInformationControlCreator() {
				/*
				 * @see org.eclipse.jface.text.IInformationControlCreator#
				 * createInformationControl(org.eclipse.swt.widgets.Shell)
				 */
				public IInformationControl createInformationControl(Shell parent) {
					return new XtextInformationControl(parent, toolBarManager);
				}
			};
		}
	}

	/*
	 * @see org.eclipse.jface.text.ITextHoverExtension#getHoverControlCreator()
	 */
	public IInformationControlCreator getHoverControlCreator() {
		return new IInformationControlCreator() {
			public IInformationControl createInformationControl(Shell parent) {
				return new XtextInformationControl(parent, EditorsUI.getTooltipAffordanceString());
			}
		};
	}

	@Override
	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		return new Region(offset, 0);
	}

	public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
		AbstractNode an = EditorModelUtil.findLeafNodeAtOffset(this.editorModelProvider.getModel()
				.getParseTreeRootNode(), hoverRegion.getOffset());
		return an;
	}

	/*
	 * TODO following is just fake stuff, replace with something like
	 * IHoverService.additionalInfo(EObject eo)
	 */

	private String getAdditionalInfo(EObject eObject) {
		StringBuilder sb = new StringBuilder();
		if (eObject instanceof LeafNode) {
			LeafNode leaf = (LeafNode) eObject;
			if (!leaf.isHidden()) {
				grammarEleToString(leaf.getGrammarElement(), sb);
				sb.append(" ");
				handleFeatured(leaf, sb);
				sb.append(leaf.getText());
				handleCoordinaten(leaf, sb);
				handleParent(leaf.getParent(), sb);
			}
		}
		return sb.toString();

	}

	private void handleCoordinaten(AbstractNode abstractNode, StringBuilder sb) {
		sb.append(" [" + abstractNode.offset() + "," + abstractNode.length() + "]");
	}

	private void handleParent(CompositeNode parent, StringBuilder sb) {
		sb.append("\n" + "\t\t\t" + "Parent: ");
		grammarEleToString(parent.getGrammarElement(), sb);
		handleCoordinaten(parent, sb);
	}

	private void grammarEleToString(EObject grammarElement, StringBuilder sb) {
		if (grammarElement instanceof RuleCall)
			sb.append("Rule call '" + ((RuleCall) grammarElement).getName() + "'");
		if (grammarElement instanceof ParserRule)
			sb.append("Parser rule '" + ((ParserRule) grammarElement).getName() + "'");
		if (grammarElement instanceof Keyword)
			sb.append("Keyword '" + ((Keyword) grammarElement).getValue() + "'");

	}

	private void handleFeatured(LeafNode leaf, StringBuilder sb) {
		if (leaf.getFeature() != null) {
			sb.append(" - ");
			grammarEleToString(leaf.getParent().getGrammarElement(), sb);
			sb.append(".");
			sb.append(leaf.getFeature());
			sb.append("\n" + "\t\t\t");
		}
	}

}