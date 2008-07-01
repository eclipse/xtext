package org.eclipse.xtext.ui.editor.hover;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.AbstractInformationControl;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IInformationControlExtension2;
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
import org.eclipse.xtext.ui.internal.CoreLog;
import org.eclipse.xtext.ui.service.IHoverInfo;
import org.eclipse.xtext.ui.service.IHoverInfo.IContentContainer;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
final class XtextInformationControl extends AbstractInformationControl implements IInformationControlExtension2,
		IContentContainer {

	private static final int MIN_WIDTH = 180;
	private static final int MIN_HEIGHT = 50;
	private StyledText st = null;
	private boolean enableScrollbars;
	private IHoverInfo hoverInfo;
	private String placeholder = "\uFFFC";

	// Image disposition handled by LabelProvider
	private Map<Integer, Image> images = new HashMap<Integer, Image>();

	/**
	 * @param parentShell
	 * @param statusFieldText
	 * @param hoverInfo
	 */
	public XtextInformationControl(Shell parentShell, String statusFieldText, IHoverInfo hoverInfo) {
		super(parentShell, statusFieldText);
		this.hoverInfo = hoverInfo;
		enableScrollbars = false;
		create();
	}

	/**
	 * @param parent
	 * @param toolBarManager
	 * @param hoverInfo
	 */
	public XtextInformationControl(Shell parent, ToolBarManager toolBarManager, IHoverInfo hoverInfo) {
		super(parent, toolBarManager);
		this.hoverInfo = hoverInfo;
		enableScrollbars = true;
		create();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.AbstractInformationControl#createContent(org.eclipse
	 * .swt.widgets.Composite)
	 */
	@Override
	protected void createContent(Composite parent) {
		st = new StyledText(parent, SWT.MULTI | SWT.READ_ONLY
				| (enableScrollbars ? SWT.V_SCROLL | SWT.H_SCROLL : SWT.NONE));
		st.setForeground(parent.getForeground());
		st.setBackground(parent.getBackground());
		st.setFont(JFaceResources.getDialogFont());
		st.addPaintObjectListener(new PaintObjectListener() {
			public void paintObject(PaintObjectEvent event) {
				GC gc = event.gc;
				StyleRange style = event.style;
				int start = style.start;
				Image im = images.get(start);
				if (im != null) {
					int x = event.x + 2;
					int y = event.y + 2 + event.ascent - style.metrics.ascent;
					gc.drawImage(im, x, y);
				}
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.AbstractInformationControl#computeSizeHint()
	 */
	@Override
	public Point computeSizeHint() {
		int widthInChar = 0;
		for (int i = 0; i < st.getLineCount(); i++) {
			int length = st.getLine(i).length();
			if (length > widthInChar)
				widthInChar = length;
		}
		Point computedSizeConstraints = super.computeSizeConstraints(widthInChar, st.getLineCount() + 1);
		computedSizeConstraints.x = Math.max(computedSizeConstraints.x, MIN_WIDTH);
		computedSizeConstraints.y = Math.max(computedSizeConstraints.y, MIN_HEIGHT);
		return computedSizeConstraints;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.IInformationControlExtension#hasContents()
	 */
	public boolean hasContents() {
		return st.getCharCount() > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.IInformationControlExtension2#setInput(java.lang
	 * .Object)
	 */
	public void setInput(Object input) {
		if (input instanceof EObject) {
			EObject eObject = (EObject) input;
			this.hoverInfo.createContents(eObject, this);
			// add some actions
			if (getToolBarManager() != null) {
				for (IAction action : this.hoverInfo.getHoverActions(eObject)) {
					getToolBarManager().add(action);
				}
				getToolBarManager().update(true);
			}
		}
		else {
			super.setInformation(input.toString());
		}

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
				return new XtextInformationControl(parent, new ToolBarManager(), hoverInfo);
			}
		};
	}

	public void addImage(Image image, int offset) {
		if (offset >= 0) {
			images.put(offset, image);
			st.replaceTextRange(offset, 0, placeholder);
			StyleRange style = new StyleRange();
			style.start = offset;
			style.length = placeholder.length();
			Rectangle rect = image.getBounds();
			style.metrics = new GlyphMetrics(rect.height + 4, 0, rect.width + 4);
			st.setStyleRange(style);
		}
		else {
			CoreLog.logError(new IllegalArgumentException("Illegal image offset " + offset + ", content length is "
					+ st.getCharCount() + ". Offset must be higher than -1 and lower than content length."));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.service.IHoverInfo.IContentContainer#appendImage
	 * (org.eclipse.swt.graphics.Image)
	 */
	public void appendImage(Image image) {
		addImage(image, st.getCharCount());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.service.IHoverInfo.IContentContainer#appendText
	 * (org.eclipse.jface.viewers.StyledString)
	 */
	public void appendText(StyledString text) {
		int charCount = st.getCharCount();
		st.append(text.getString());
		for (StyleRange sr : text.getStyleRanges()) {
			sr.start += charCount;
			st.setStyleRange(sr);
		}
	}
}