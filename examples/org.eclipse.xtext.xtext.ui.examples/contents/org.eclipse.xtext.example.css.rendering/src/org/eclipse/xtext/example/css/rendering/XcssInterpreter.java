package org.eclipse.xtext.example.css.rendering;

import java.lang.reflect.Field;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.eclipse.xtext.example.css.runtime.BackgroundGradient;
import org.eclipse.xtext.example.css.runtime.StyleAware;
import org.eclipse.xtext.example.css.xcss.ColorConstant;
import org.eclipse.xtext.example.css.xcss.ColorLiteral;
import org.eclipse.xtext.example.css.xcss.Gradient;
import org.eclipse.xtext.example.css.xcss.IdSelector;
import org.eclipse.xtext.example.css.xcss.Percent;
import org.eclipse.xtext.example.css.xcss.RGB;
import org.eclipse.xtext.example.css.xcss.Selector;
import org.eclipse.xtext.example.css.xcss.StyleRule;
import org.eclipse.xtext.example.css.xcss.StyleSheet;
import org.eclipse.xtext.example.css.xcss.TypeSelector;
import org.eclipse.xtext.example.css.xcss.WildcardSelector;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.impl.EvaluationException;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;

import com.google.inject.Provider;

public class XcssInterpreter extends XbaseInterpreter  {

	private Display display;
	
	public XcssInterpreter() {
		super();
	}
	
	public XcssInterpreter(Provider<IEvaluationContext> contextProvider, JavaReflectAccess javaReflectAccess, ClassLoader loader) {
		super(contextProvider, javaReflectAccess, loader);
	}
	
	public void setDisplay(Display display) {
		this.display = display;
	}
	
	public IEvaluationResult evaluate(StyleSheet styleSheet, Widget widget) {
		IEvaluationContext context = createContext();
		context.newValue(XbaseScopeProvider.THIS, widget);
		return evaluate(styleSheet, context);
	}
	
	public Object _evaluateStyleSheet(StyleSheet styleSheet, IEvaluationContext context) {
		for(StyleRule rule: styleSheet.getRules()) {
			internalEvaluate(rule, context);
		}
		return null;
	}
	
	public Object _evaluateStyleRule(StyleRule rule, IEvaluationContext context) {
		for(Selector selector: rule.getSelectors()) {
			Object selectorResult = internalEvaluate(selector, context);
			if (Boolean.FALSE.equals(selectorResult)) {
				return null;
			}
		}
		for(XExpression setting: rule.getSettings()) {
			internalEvaluate(setting, context);
		}
		return null;
	}
	
	public Object _evaluateTypeSelector(TypeSelector typeSelector, IEvaluationContext context) {
		Object widget = context.getValue(XbaseScopeProvider.THIS);
		Class<?> expectedType = null;
		try {
			expectedType = getClassFinder().forName(typeSelector.getType().getCanonicalName());
		} catch(ClassNotFoundException cnfe) {
			throw new EvaluationException(cnfe);
		}
		if (!expectedType.isInstance(widget)) {
			return Boolean.FALSE;
		}
		if (typeSelector.getFilter() != null && typeSelector.getFilter() != null) {
			Object filterResult = internalEvaluate(typeSelector.getFilter(), context);
			return Boolean.TRUE.equals(filterResult);
		}
		return Boolean.TRUE;
	}
	
	public Object _evaluateIdSelector(IdSelector idSelector, IEvaluationContext context) {
		Object widget = context.getValue(XbaseScopeProvider.THIS);
		if (widget instanceof Widget) {
			Object idData = ((Widget) widget).getData("org.eclipse.e4.ui.css.id");
			if (idData == null || !idSelector.getId().equals(idData))
				return Boolean.FALSE;
		}
		if (idSelector.getFilter() != null && idSelector.getFilter() != null) {
			Object filterResult = internalEvaluate(idSelector.getFilter(), context);
			return Boolean.TRUE.equals(filterResult);
		}
		return Boolean.TRUE;
	}
	
	public Object _evaluateTypeSelector(WildcardSelector wildcard, IEvaluationContext context) {
		if (wildcard.getFilter() != null && wildcard.getFilter() != null) {
			Object filterResult = evaluate(wildcard.getFilter(), context);
			return Boolean.TRUE.equals(filterResult);
		}
		return Boolean.TRUE;
	}
	
	public Object _evaluateColorConstant(ColorConstant colorConstant, IEvaluationContext context) {
		JvmIdentifyableElement constant = colorConstant.getConstant();
		if (constant instanceof JvmField) {
			Field field = getJavaReflectAccess().getField((JvmField) constant);
			if (field != null) {
				int colorConstantValue;
				try {
					field.setAccessible(true);
					colorConstantValue = (Integer) field.get(null);
				} catch (Exception e) {
					throw new IllegalStateException("Could not access static field: " + constant.getCanonicalName(), e);
				}
				Color color = display.getSystemColor(colorConstantValue);
				return color;
			}
		}
		return null;
	}
	
	public Object _evaluateRGB(RGB color, IEvaluationContext context) {
		org.eclipse.swt.graphics.RGB rgb = null;
		if (color.isHex()) {
			int value = color.getValue();
			rgb = RGBHelper.create(value);
		} else {
			rgb = new org.eclipse.swt.graphics.RGB(color.getRed(), color.getGreen(), color.getBlue());
		}
		return new Color(display, rgb);
	}
	
	public Object _evaluateGradient(Gradient gradient, IEvaluationContext context) {
		BackgroundGradient bgGradient = new BackgroundGradient();
		for(ColorLiteral color: gradient.getColors()) {
			Object colorResult = evaluate(color, context);
			bgGradient.addColor(colorResult);
		}
		for(Percent percent: gradient.getPercents()) {
			bgGradient.addPercent(percent.getValue());
		}
		return bgGradient;
	}
	
	@Override
	protected Object assignValueByOperation(JvmOperation operation, Object receiver, Object value) {
		if (StyleAware.class.getCanonicalName().equals(operation.getDeclaringType().getCanonicalName())) {
			if (receiver instanceof Control) {
				StyleAware borderAware = StyleAwareImpl.getBorderAware((Control) receiver);
				receiver = borderAware;
				if (receiver != null)
					return super.assignValueByOperation(operation, receiver, value);
			}
			return null;
		} else {
			return super.assignValueByOperation(operation, receiver, value);
		}
//		List<Object> argumentValues = Lists.newArrayList(value);
//		IEvaluationResult result = invokeOperation(operation, receiver, argumentValues);
//		return result;
	}
	
}
