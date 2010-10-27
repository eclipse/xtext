package org.eclipse.xtext.example.css.rendering;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.xtext.example.css.runtime.BackgroundGradient;

/**
 * Heavily adapter from org.eclipse.e4.ui.css.swt.properties.GradientBackgroundListener. 
 * @author Sebastian Zarnekow
 */
public class GradientBackgroundListener implements Listener {
	private BackgroundGradient gradient;
	private final Control control;
	Image gradientImage;
	
	public GradientBackgroundListener(Control control) {
		this.control = control;
		control.addListener(SWT.Resize, this);
		control.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				if (gradientImage != null && !gradientImage.isDisposed())
					gradientImage.dispose();
				gradientImage = null;
				if (gradient != null) {
					for(Object o: gradient.getColors()) {
						Color c = (Color) o;
						c.dispose();
					}	
				}
			}
		});
	}
	
	public void setGradient(BackgroundGradient gradient) {
		if (this.gradient != null) {
			for(Object o: this.gradient.getColors()) {
				Color c = (Color) o;
				c.dispose();
			}	
		}
		this.gradient = gradient;
		handleEvent(null);
	}
	
	public BackgroundGradient getGradient() {
		return gradient;
	}

	public void handleEvent(Event event) {
		Point size = control.getSize();
		if (size.x <= 0 || size.y <= 0) {
			return;
		}
		
		Image oldImage = control.getBackgroundImage();
		
		/*
		 * Draw the new background.
		 */
		if( gradient != null && (oldImage == null || oldImage.isDisposed() || oldImage.getBounds().height != size.y || event == null )) {
			int x = 2;
			int y = size.y;
			gradientImage = new Image(control.getDisplay(), x, y);
			GC gc = new GC(gradientImage);
			List<Object> colors = gradient.getColors();
			fillGradient(gc, new Rectangle(0, 0, x, y), colors,
					gradient.getPercents(), true);
			gc.dispose();
		} else {
			// Avoid destroying the image
			oldImage = null;
			gradientImage = null;
		}
		
		if( gradientImage != null ) {
			/*
			 * Set the new background.
			 */
			control.setBackgroundImage(gradientImage);			
		}
	}

	/*
	 * Fills a gradient rectangle in the specified gc with the specified colors
	 * and percentages.
	 * 
	 * @param gc @param rect @param gradientColors @param gradientPercents
	 * 
	 * @param gradientVertical
	 */
	private static void fillGradient(GC gc, Rectangle rect,
			List<Object> gradientColors, List<Integer> gradientPercents,
			boolean gradientVertical) {
		Color background = (Color) gradientColors.get(gradientColors.size() - 1);
		if (gradientColors.size() == 1) {
			if (gradientColors.get(0) != null) {
				gc.setBackground((Color) gradientColors.get(0));
			}
			gc.fillRectangle(rect.x, rect.y, rect.width, rect.height);
		} else {
			Color lastColor = (Color) gradientColors.get(0);
			int pos = (gradientVertical) ? rect.y : rect.x;
			int loopCount = Math.min(gradientColors.size() - 1,	gradientPercents.size());
			for (int i = 0; i < loopCount; ++i) {
				gc.setForeground(lastColor);
				lastColor = (Color) gradientColors.get(i + 1);
				if (lastColor == null) {
					lastColor = background;
				}
				gc.setBackground(lastColor);
				int grpercent = gradientPercents.get(i).intValue();
				if (gradientVertical) {
					final int gradientHeight = (grpercent * rect.height / 100)
							- (pos - rect.y);
					gc.fillGradientRectangle(rect.x, pos, rect.width,
							gradientHeight, true);
					pos += gradientHeight;
				} else {
					final int gradientWidth = (grpercent * rect.width / 100)
							- (pos - rect.x);
					gc.fillGradientRectangle(pos, rect.y, gradientWidth,
							rect.height, false);
					pos += gradientWidth;
				}
			}
			if (gradientVertical && pos < rect.height) {
				gc.setBackground(background);
				gc.fillRectangle(rect.x, pos, rect.width, rect.height - pos);
			}
			if (!gradientVertical && pos < rect.width) {
				gc.setBackground(background);
				gc.fillRectangle(pos, rect.y, rect.width - pos, rect.height);
			}
		}
	}

}
