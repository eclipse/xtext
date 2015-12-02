---
layout: download
title: Download
---
<div>
	<div class="container">
		<div class="row">
			<div class="span12">
				<h2>Download Options</h2>
				<p>
		Xtend can be used in Eclipse, IntelliJ IDEA and Android Studio. You can use your favorite IDE's plug-in mechanism to add Xtend, using one of the URLs below.
				</p>
				<p>
				{% for post in site.categories.releasenotes limit:1 %}
					<strong><a href="releasenotes.html">{{ post.title }}</a></strong>
				{% endfor %}
				</p>
			</div>
		</div>
		<div class="row">
			<div class="span6">
				<h2>Eclipse Users</h2>
				<h3>Download Eclipse</h3>
				<p>itemis offers tested and ready to use Eclipse distributions on <a href="https://itemis.com">itemis.com</a>.</p>
				<p><a href="http://cta-redirect.hubspot.com/cta/redirect/761475/5f19e385-5578-4a5b-96b2-81413c6e6d20" target="_blank" class="has-popover btn btn-success btn-large pull_right">Get Eclipse from itemis.com</a>
			      <script charset="utf-8" src="https://js.hscta.net/cta/current.js"></script>
			      <script type="text/javascript">
			          hbspt.cta.load(761475, '5f19e385-5578-4a5b-96b2-81413c6e6d20');
			      </script>
			    </p>
				<h3>Eclipse Updatesites</h3>
				<p> To install the Xtend plug-in into a running Eclipse.</p>
				<p><a href="http://download.eclipse.org/modeling/tmf/xtext/updates/composite/releases/" class="has-popover btn btn-primary btn-medium">Releases (right click &amp; copy)</a></p>
				<p><a href="http://download.eclipse.org/modeling/tmf/xtext/updates/composite/milestones/" class="has-popover btn btn-primary btn-medium">Milestones (right click &amp; copy)</a></p>
				<p><a href="http://download.eclipse.org/modeling/tmf/xtext/updates/composite/latest/" class="has-popover btn btn-primary btn-medium">Nightly Builds (right click &amp; copy)</a></p>
				<h3>Installation Instructions</h3>
				<ul>
					<li>Choose <e>Help -&gt; Install New Software...</e> from the menu bar and <e>Add...</e>.</li>
					<li>Insert one of the update site URLs below. This site aggregates all the necessary and optional components and dependencies of Xtend.</li>
					<li>Select the <e>Xtend IDE</e> from the category <e>Xtend</e> and complete the wizard by clicking the <e>Next</e> button until you can click <e>Finish</e>.</li>
					<li>After a quick download and a restart of Eclipse, Xtend is ready to use.</li>
				</ul>
			</div>
			<div class="span6">
				<h2>IntelliJ IDEA 15 / Android Studio 2.0 Users</h2>
				<h3>Download IDEA</h3>
				<p>You can download the Community Edition at jetbrains.com.</p>
				<p>
					<a href="http://www.jetbrains.com/idea/download/index.html" target="_blank" class="has-popover btn btn-success btn-large pull_left">Get IDEA from jetbrains.com</a>
			    </p>
				<h3>Plug-In Repositories</h3>
				<p>Choose one of the following repository URLs for IDEA :</p>
				<p><a href="http://download.eclipse.org/modeling/tmf/xtext/idea/2.9.0/updatePlugins.xml" class="has-popover btn btn-primary btn-medium">Releases (right click &amp; copy)</a></p>
				<!--p><a href="http://download.eclipse.org/modeling/tmf/xtext/updates/composite/milestones/" class="has-popover btn btn-primary btn-medium">Milestones (right click &amp; copy)</a></p-->
				<p><a href="https://hudson.eclipse.org/xtext/job/xtext-intellij/lastSuccessfulBuild/artifact/git-repo/intellij/build/ideaRepository/updatePlugins.xml" class="has-popover btn btn-primary btn-medium">Nightly Builds (right click &amp; copy)</a>
				</p>
				<h3>Installation Instructions</h3>
				<ul>
				 <li>Choose <e>Preferences</e> from the menu bar. </li>
				 <li>Chosse the <e>plugin</e> section and add one of the URLs as a new repository.</li>
				 <li>Install <e>org.eclipse.xtext</e> and <e>org.eclipse.xtend</e>.</li>
				 <li>Follow the instructions given by IDEA.</li>
				</ul>
			</div>
		</div>
	</div>
</div>

### Maven Plugin {#maven-support}

You can create a readily configured project with the following command.

```
mvn archetype:generate -DarchetypeGroupId=org.eclipse.xtend -DarchetypeArtifactId=xtend-archetype
```

If you already have a project, you need to add the Xtend library:

```xml
<dependency>
  <groupId>org.eclipse.xtend</groupId>
  <artifactId>org.eclipse.xtend.lib</artifactId>
  <version>2.9.0</version>
</dependency>
```

and the Xtend compiler plugin:

```xml
<plugin>
  <groupId>org.eclipse.xtend</groupId>
  <artifactId>xtend-maven-plugin</artifactId>
  <version>2.9.0</version>
  <executions>
    <execution>
      <goals>
        <goal>compile</goal>
        <goal>testCompile</goal>
      </goals>
      <configuration>
        <outputDirectory>${project.build.directory}/xtend-gen/main</outputDirectory>
        <testOutputDirectory>${project.build.directory}/xtend-gen/test</testOutputDirectory>
      </configuration>
    </execution>
  </executions>
</plugin>
```

### Gradle Plugin {#maven-support}

Here is a minimal Gradle build script using Xtend:

```groovy
plugins {
  id "org.xtend.xtend" version "0.4.10"
}

repositories.jcenter()

dependencies {
  compile 'org.eclipse.xtend:org.eclipse.xtend.lib:2.9.0'
}
```

For more information, visit the [plugin's page on GitHub](https://github.com/xtext/xtend-gradle-plugin)

### Have Fun!

You can now use your IDE's "New Xtend Class" wizard to start your journey.

[Click here for documentation and examples.](documentation/101_gettingstarted.html)
