package org.eclipse.xtext.example.css.runtime;

/**
 * We consider controls to implement this interface synthetically to allow
 * borders by means of styles. 
 * Other use cases are gradient backgrounds or margins.
 * @author Sebastian Zarnekow
 */
public interface StyleAware {

	int getBorderWidth();

	/**
	 * Borderwidth in pixels.
	 */
	void setBorderWidth(int borderWidth);
	
	String getBorderStyle();
	
	/**
	 * Valid values are 'dashed', 'dotted' and 'solid' (default).
	 */
	void setBorderStyle(String borderWidth);

	BackgroundGradient getBackgroundGradient();
	
	void setBackgroundGradient(BackgroundGradient gradient);
}
