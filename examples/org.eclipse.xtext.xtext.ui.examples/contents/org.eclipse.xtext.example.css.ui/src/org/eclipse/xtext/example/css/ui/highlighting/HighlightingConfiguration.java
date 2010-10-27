package org.eclipse.xtext.example.css.ui.highlighting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class HighlightingConfiguration extends DefaultHighlightingConfiguration {

	public static final String CLASS_SELECTOR = "xcss.class.selector";
	public static final String ID_SELECTOR = "xcss.id.selector";
	public static final String ATTRIBUTE_ID = "xcss.attribute.id";
	public static final String RGB_LITERAL = "xcss.rgb.literal";
	
	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(CLASS_SELECTOR, "Type selector", darkblueTextStyle());
		acceptor.acceptDefaultHighlighting(ATTRIBUTE_ID, "Attribute", lightblueTextStyle());
		acceptor.acceptDefaultHighlighting(ID_SELECTOR, "Id selector", lightgrayTextStyle());
		acceptor.acceptDefaultHighlighting(RGB_LITERAL, "RGB literal", darkgreenTextStyle());
	}

	public TextStyle darkblueTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 0, 128));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
	
	public TextStyle darkgreenTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 128, 0));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
	
	public TextStyle lightgrayTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(96, 96, 96));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
	
	public TextStyle lightblueTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 0, 255));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
}
