package org.xpect.setup;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.inject.Binder;
import com.google.inject.Module;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface XtextInjectorSetup {
	public class NullModule implements Module {
		@Override
		public void configure(Binder binder) {
		}
	}

	Class<? extends Module> pluginTestModule() default NullModule.class;

	Class<? extends Module> standaloneTestModule() default NullModule.class;

	Class<? extends Module> workbenchModule() default NullModule.class;
}
