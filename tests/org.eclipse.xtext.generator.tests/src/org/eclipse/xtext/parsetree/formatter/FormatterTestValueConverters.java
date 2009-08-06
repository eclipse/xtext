package org.eclipse.xtext.parsetree.formatter;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;

public class FormatterTestValueConverters extends
		DefaultTerminalConverters {

	@ValueConverter(rule = "FQN")
	public IValueConverter<String> FQN() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, AbstractNode node) {
				StringBuffer b = new StringBuffer();
				Iterator<EObject> i = node.eAllContents();
				while (i.hasNext()) {
					EObject o = i.next();
					if (o instanceof LeafNode) {
						LeafNode l = (LeafNode) o;
						if (!l.isHidden())
							b.append(l.getText());
					}
				}
				return b.toString();
			}

			@Override
			protected String internalToString(String value) {
				return value;
			}
		};
	}

}
