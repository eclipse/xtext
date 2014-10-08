package org.xpect.examples.setupcomponents;

import java.util.List;

import org.junit.runner.RunWith;
import org.xpect.XpectImport;
import org.xpect.examples.setupcomponents.CustomSetupTest.CustomSetupComponent;
import org.xpect.examples.setupcomponents.CustomSetupTest.CustomSetupRoot;
import org.xpect.expectation.IStringExpectation;
import org.xpect.expectation.StringExpectation;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectRunner;
import org.xpect.setup.ISetupInitializer;
import org.xpect.setup.XpectSetupComponent;
import org.xpect.setup.XpectSetupRoot;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * Import classes via @XpectImport; The imported classes can import further
 * classes and/or have an annotation that defines their "role". Here, we see the
 * roles @XpectSetupRoot and @XpectSetupComponent.
 */
@RunWith(XpectRunner.class)
@XpectImport({ CustomSetupRoot.class, CustomSetupComponent.class })
public class CustomSetupTest {

	/**
	 * A class annotated with @XpectSetupRoot should have add(Foo) methods. All
	 * types that are a valid parameter for such an add()-method and which are
	 * annotated with @XpectSetupComponent are valid syntactic root components
	 * in the XPECT_SETUP section.
	 */
	@XpectSetupRoot
	public static class CustomSetupRoot {
		private List<CustomSetupComponent> children = Lists.newArrayList();

		public void add(CustomSetupComponent child) {
			children.add(child);
		}
	}

	/**
	 * XpectSetupComponents can be used (referenced) in the XPECT_SETUP section.
	 * They can have constructor parameters, add(Foo)-methods and
	 * set(Foo)-methods.
	 */
	@XpectSetupComponent
	public static class CustomSetupComponent {
		private final String foo;
		private final String bar;
		private String baz;

		public CustomSetupComponent(String foo, String bar) {
			this.foo = foo;
			this.bar = bar;
		}

		public void setBaz(String baz) {
			this.baz = baz;
		}

		@Override
		public String toString() {
			return Objects.toStringHelper(this).add("foo", foo).add("bar", bar).add("baz", baz).toString();
		}
	}

	/**
	 * The ISetupInitializer can initialize an instance of a class annotated
	 * with @XpectSetupRoot with all the values defined in the XPECT_SETUP
	 * section.
	 */
	@Xpect
	public void mysetup(@StringExpectation IStringExpectation expectation, ISetupInitializer<CustomSetupRoot> init) {
		CustomSetupRoot root = new CustomSetupRoot();
		init.initialize(root);
		String actual = Joiner.on(", ").join(root.children);
		expectation.assertEquals(actual);
	}

}
