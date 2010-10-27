package org.eclipse.xtext.example.css.rendering;

import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xtext.example.css.runtime.BackgroundGradient;
import org.eclipse.xtext.example.css.runtime.StyleAware;

import com.google.common.base.Function;
import com.google.common.collect.MapMaker;

public class StyleAwareImpl implements StyleAware, PaintListener {

	private static Map<Control, StyleAware> allInstances = new MapMaker().weakKeys().makeComputingMap(new Function<Control, StyleAware>() {
		public StyleAware apply(Control from) {
			return new StyleAwareImpl(from);
		}
	});
	
	public static StyleAware getBorderAware(Control control) {
		if (control.getParent() == null)
			return null;
		return allInstances.get(control);
	}
	
	public static void discard(Widget widget) {
		if (allInstances.containsKey(widget)) {
			StyleAwareImpl existing = (StyleAwareImpl) getBorderAware((Control)widget);
			allInstances.remove(widget);
			existing.discard();
		}
	}
	
	private int borderWidth;
	private String borderStyle;
	private Control control;
	private GradientBackgroundListener gradientBackgroundListener;

	public StyleAwareImpl(Control control) {
		this.control = control;
		control.getParent().addPaintListener(this);
	}
	
	public int getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(int borderWidth) {
		this.borderWidth = borderWidth;
		Composite parent = control.getParent();
		if (parent.getData("CSS_SUPPORTS_BORDERS") != null) {
			if (parent.getLayout() instanceof FillLayout) {
				FillLayout layout = (FillLayout) parent.getLayout();
				layout.marginHeight = borderWidth;
				layout.marginWidth = borderWidth;
			}
		}
	}

	public String getBorderStyle() {
		return borderStyle;
	}

	public void setBorderStyle(String borderStyle) {
		this.borderStyle = borderStyle;
	}
	
	/**
	 * Heavily adapted from org.eclipse.e4.ui.css.swt.helpers.CSSSWTHelpers.createBorderPaintListener(CSSEngine, Control)
	 */
	public void paintControl(PaintEvent e) {
		int width = getBorderWidth();
		GC gc = e.gc;
		
		Color color = control.getForeground();
		if (color != null)
			gc.setForeground(color);
		Rectangle rect = control.getBounds();
		if (width == 0) {
			Rectangle rect1 = new Rectangle(rect.x - width, rect.y
					- width, rect.width + 2 * width, rect.height + 2
					* width);
			gc.fillRectangle(rect1);
		} else {
			int lineStyle = getLineStyle();
			// Top Line
			gc.setLineStyle(lineStyle);
			gc.setLineWidth(width);
			gc.drawLine(rect.x, rect.y - 1, rect.width + 2 * width,
					rect.y - 1);
			// Bottom Line
			gc.setLineStyle(lineStyle);
			gc.setLineWidth(width);
			gc.drawLine(rect.x, rect.y + rect.height + 1, rect.width
					+ 2 * width, rect.y + rect.height + 1);
			// Left Line
			gc.setLineStyle(lineStyle);
			gc.setLineWidth(width);
			gc.drawLine(rect.x - 1, rect.y - 1, rect.x - 1, rect.y
					+ rect.height + 1);
			// Right Line
			gc.setLineStyle(lineStyle);
			gc.setLineWidth(width);
			gc.drawLine(rect.width + 2 * width, rect.y - 1, rect.width
					+ 2 * width, rect.y + rect.height + 1);
		}
	}
	
	public int getLineStyle() {
		if (borderStyle == null)
			return SWT.LINE_SOLID;
		// one hidden dotted dashed solid double groove ridge inset outset
		if ("dashed".equals(borderStyle)) {
			return SWT.LINE_DASH;
		}
		if ("dotted".equals(borderStyle)) {
			return SWT.LINE_DOT;
		}
		return SWT.LINE_SOLID;
	}
	
	public void discard() {
		setBorderWidth(0);
		control.getParent().removePaintListener(this);
		if (gradientBackgroundListener != null) {
			gradientBackgroundListener.setGradient(null);
		}
	}
	
	public void setBackgroundGradient(BackgroundGradient gradient) {
		if (gradientBackgroundListener == null) {
			gradientBackgroundListener = new GradientBackgroundListener(control);
		}
		gradientBackgroundListener.setGradient(gradient);
	}
	
	public BackgroundGradient getBackgroundGradient() {
		if (gradientBackgroundListener == null)
			return null;
		return gradientBackgroundListener.getGradient();
	}
	
}
