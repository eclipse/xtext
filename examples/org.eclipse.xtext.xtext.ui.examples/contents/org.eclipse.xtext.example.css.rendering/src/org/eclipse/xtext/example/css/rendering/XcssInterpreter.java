package org.eclipse.xtext.example.css.rendering;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.eclipse.xtext.example.css.runtime.StyleAware;
import org.eclipse.xtext.example.css.xcss.ColorConstant;
import org.eclipse.xtext.example.css.xcss.IdSelector;
import org.eclipse.xtext.example.css.xcss.RGB;
import org.eclipse.xtext.example.css.xcss.Selector;
import org.eclipse.xtext.example.css.xcss.StyleRule;
import org.eclipse.xtext.example.css.xcss.StyleSheet;
import org.eclipse.xtext.example.css.xcss.TypeSelector;
import org.eclipse.xtext.example.css.xcss.WildcardSelector;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;

import com.google.inject.Provider;

public class XcssInterpreter extends XbaseInterpreter  {

	private static final Logger logger = Logger.getLogger(XcssInterpreter.class);

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
	
	public IEvaluationResult _evaluateStyleSheet(StyleSheet styleSheet, IEvaluationContext context) {
		for(StyleRule rule: styleSheet.getRules()) {
			IEvaluationResult ruleResult = evaluate(rule, context);
			if (ruleResult.getException() != null) {
				logger.error(ruleResult.getException().getMessage(), ruleResult.getException());
			}
		}
		return DefaultEvaluationResult.NULL;
	}
	
	public IEvaluationResult _evaluateStyleRule(StyleRule rule, IEvaluationContext context) {
		for(Selector selector: rule.getSelectors()) {
			IEvaluationResult selectorResult = evaluate(selector, context);
			if (selectorResult.getException() != null)
				return selectorResult;
			if (Boolean.FALSE.equals(selectorResult.getResult())) {
				return DefaultEvaluationResult.NULL;
			}
		}
		for(XExpression setting: rule.getSettings()) {
			IEvaluationResult settingResult = evaluate(setting, context);
			if (settingResult.getException() != null)
				return settingResult;
		}
		return DefaultEvaluationResult.NULL;
	}
	
	public IEvaluationResult _evaluateTypeSelector(TypeSelector typeSelector, IEvaluationContext context) {
		Object widget = context.getValue(XbaseScopeProvider.THIS);
		Class<?> expectedType = null;
		try {
			expectedType = getClassFinder().forName(typeSelector.getType().getCanonicalName());
		} catch(ClassNotFoundException cnfe) {
			return new DefaultEvaluationResult(null, cnfe);
		}
		if (!expectedType.isInstance(widget)) {
			return new DefaultEvaluationResult(Boolean.FALSE, null);
		}
		if (typeSelector.getFilter() != null && typeSelector.getFilter() != null) {
			IEvaluationResult filterResult = evaluate(typeSelector.getFilter(), context);
			if (filterResult.getException() != null)
				return filterResult;
			return new DefaultEvaluationResult(Boolean.TRUE.equals(filterResult.getResult()), null);
		}
		return new DefaultEvaluationResult(Boolean.TRUE, null);
	}
	
	public IEvaluationResult _evaluateIdSelector(IdSelector idSelector, IEvaluationContext context) {
		Object widget = context.getValue(XbaseScopeProvider.THIS);
		if (widget instanceof Widget) {
			Object idData = ((Widget) widget).getData("org.eclipse.e4.ui.css.id");
			if (idData == null || !idSelector.getId().equals(idData))
				return new DefaultEvaluationResult(Boolean.FALSE, null);
		}
		if (idSelector.getFilter() != null && idSelector.getFilter() != null) {
			IEvaluationResult filterResult = evaluate(idSelector.getFilter(), context);
			if (filterResult.getException() != null)
				return filterResult;
			return new DefaultEvaluationResult(Boolean.TRUE.equals(filterResult.getResult()), null);
		}
		return new DefaultEvaluationResult(Boolean.TRUE, null);
	}
	
	public IEvaluationResult _evaluateTypeSelector(WildcardSelector wildcard, IEvaluationContext context) {
		if (wildcard.getFilter() != null && wildcard.getFilter() != null) {
			IEvaluationResult filterResult = evaluate(wildcard.getFilter(), context);
			if (filterResult.getException() != null)
				return filterResult;
			return new DefaultEvaluationResult(Boolean.TRUE.equals(filterResult.getResult()), null);
		}
		return new DefaultEvaluationResult(Boolean.TRUE, null);
	}
	
	public IEvaluationResult _evaluateColorConstant(ColorConstant colorConstant, IEvaluationContext context) {
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
				return new DefaultEvaluationResult(color, null);
			}
		}
		return DefaultEvaluationResult.NULL;
	}
	
	public IEvaluationResult _evaluateRGB(RGB color, IEvaluationContext context) {
		org.eclipse.swt.graphics.RGB rgb = null;
		if (color.isHex()) {
			int value = color.getValue();
			rgb = RGBHelper.create(value);
		} else {
			rgb = new org.eclipse.swt.graphics.RGB(color.getRed(), color.getGreen(), color.getBlue());
		}
		return new DefaultEvaluationResult(new Color(display, rgb), null);
	}
	
	protected IEvaluationResult assignValueByOperation(JvmOperation operation, Object receiver, Object value) {
		if (StyleAware.class.getCanonicalName().equals(operation.getDeclaringType().getCanonicalName())) {
			if (receiver instanceof Control) {
				StyleAware borderAware = StyleAwareImpl.getBorderAware((Control) receiver);
				receiver = borderAware;
				if (receiver != null)
					return super.assignValueByOperation(operation, receiver, value);
			}
			return DefaultEvaluationResult.NULL;
		} else {
			return super.assignValueByOperation(operation, receiver, value);
		}
//		List<Object> argumentValues = Lists.newArrayList(value);
//		IEvaluationResult result = invokeOperation(operation, receiver, argumentValues);
//		return result;
	}
	
}
