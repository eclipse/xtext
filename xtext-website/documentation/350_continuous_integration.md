---
layout: documentation
title: Continuous Integration (with Maven)
part: Reference Documentation
upsite:
  eclipse: http://download.eclipse.org/
  xtext: http://download.eclipse.org/modeling/tmf/xtext/updates/
  emf: http://download.eclipse.org/modeling/emf/emf/updates/
  mwe: http://download.eclipse.org/modeling/emft/mwe/updates/
  xpand: http://download.eclipse.org/modeling/m2t/xpand/updates/
---

# {{page.title}} {#continuous-integration}

There are two aspects to consider when it comes to continuous integration. Firstly you may want to have a continuous build of your language that runs all tests and creates an Eclipse update site and other needed artifacts, and secondly you may want to have your language and its corresponding code generator integrated in your application builds. We will discuss both cases in this section along with a set of example projects, which you can clone, inspect or download from [github.com/xtext/maven-xtext-example](https://github.com/xtext/maven-xtext-example).

To follow this section you need a basic understanding of how Maven works. Please read a tutorial on Maven if you don't know anything about it. 

## An overview of the example projects

If you have a look at the example, you'll find seven different projects of which six are for the various aspects of the language and its build. First we have the language's runtime project, UI project and test project. In addition we need a feature project, an update site project and a project where we put the parent pom. The seventh project is called `example-project` and is really a small application project that uses the built language and triggers the code generator through a dedicated maven plug-in. Let's first have a look at how to build the language.

## Building an Xtext language with Maven and Tycho {#tycho-build}

Although the runtime aspects of an Xtext language is not dependent on Eclipse or its OSGi container, an Xtext language is developed in the form of OSGi bundles. For this kind of builds most people rely on [Tycho](http://eclipse.org/tycho/), which is an OSGi/P2 adapter plug-in for Maven builds. Tycho obtains much information from the OSGi bundle's manifest. Additionally needed information is configured through the pom.xml file which sits at the root of each project.

### The parent project (my.mavenized.herolanguage.parent)

All of the projects are aggregated in a parent pom in the root directory. If you import the projects into eclipse the imported project is called `my.mavenized.herolanguage.parent`. Information defined in the parent pom is automatically inherited by the aggregated child projects, so you don't need to reconfigure the same information over and over again. Here we have configured two additional plug-ins:

*   The Xtend compiler plug-in will generate the Java source code for any Xtend files during the 'generate-sources' phase     
    
    ```xml
    <pluginManagement>
      <plugins>
        <!-- xtend-maven-plugin is in pluginManagement instead of in plugins
           so that it doesn't run before the exec-maven-plugin's *.mwe2 gen;
           this way we can list it after. 
          -->
          
        <plugin>
          <groupId>org.eclipse.xtend</groupId>
          <artifactId>xtend-maven-plugin</artifactId>
          <version>${xtext.version}</version>
          <executions>
            <execution>
              <goals>
                <goal>compile</goal>
                <goal>xtend-install-debug-info</goal>
                <goal>testCompile</goal>
                <goal>xtend-test-install-debug-info</goal>
              </goals>
            </execution>
          </executions>
          <configuration>
            <outputDirectory>xtend-gen</outputDirectory>
          </configuration>
        </plugin>
      </plugins>
    </pluginManagement>
    ```

*   The Tycho plug-in will pick up and use Eclipse plug-in specific configuration data from the projects in order to build Eclipse conformant OSGi bundles, features and an update site.     
    
    ```xml
    <plugins>
      <plugin>
        <groupId>org.eclipse.tycho</groupId>
        <artifactId>tycho-maven-plugin</artifactId>
        <version>${tycho-version}</version>
        <extensions>true</extensions>
      </plugin>
    </plugins>
    ```

To build the entire project you have to run your maven build with this pom file.

### The update site project (my.mavenized.herolanguage.updatesite)

The project `my.mavenized.herolanguage.updatesite` denotes the updatesite project and only contains a pom.xml and a file called category.xml. The latter includes information about which features are contained in the update site. As you can see, the `category.xml` file points to the single feature, which is defined in the project `my.mavenized.herolanguage.sdk`.

### The feature project (my.mavenized.herolanguage.sdk)

This is another project made up on configuration data solely. It contains the `feature.xml` file which points to the Eclipse plug-ins (bundles) included in this feature.

### The core language project (my.mavenized.herolanguage)

The `pom.xml` for the language project contains information about how Maven should run the Xtext's code generator. The first plug-in invokes the MWE2 file through a standard Java process:

```xml
<plugin>
  <groupId>org.codehaus.mojo</groupId>
  <artifactId>exec-maven-plugin</artifactId>
  <version>1.4.0</version>
  <executions>
    <execution>
      <id>mwe2Launcher</id>
      <phase>generate-sources</phase>
      <goals>
        <goal>java</goal>
      </goals>
    </execution>
  </executions>
  <configuration>
    <mainClass>org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher</mainClass>
    <arguments>
      <argument>/${project.basedir}/src/my/mavenized/GenerateHeroLanguage.mwe2</argument>
      <argument>-p</argument>
      <argument>rootPath=/${project.basedir}/..</argument>
    </arguments>
    <classpathScope>compile</classpathScope>
    <includePluginDependencies>true</includePluginDependencies>
    <cleanupDaemonThreads>false</cleanupDaemonThreads><!-- see https://bugs.eclipse.org/bugs/show_bug.cgi?id=475098#c3 -->
  </configuration>
  <dependencies>
    <dependency>
      <groupId>org.eclipse.emf</groupId>
      <artifactId>org.eclipse.emf.mwe2.launch</artifactId>
      <version>2.10.0</version>
    </dependency>
    <dependency>
      <groupId>org.eclipse.xtext</groupId>
      <artifactId>org.eclipse.xtext.common.types</artifactId>
      <version>${xtext.version}</version>
    </dependency>
    <dependency>
      <groupId>org.eclipse.xtext</groupId>
      <artifactId>org.eclipse.xtext.xtext.generator</artifactId>
      <version>${xtext.version}</version>
    </dependency>
    <dependency>
      <groupId>org.eclipse.xtext</groupId>
      <artifactId>org.eclipse.xtext.xbase</artifactId>
      <version>${xtext.version}</version>
    </dependency>
    <dependency>
      <groupId>org.eclipse.xtext</groupId>
      <artifactId>xtext-antlr-generator</artifactId>
      <version>[2.1.1, 3)</version>
    </dependency>
  </dependencies>
</plugin>
```

The second used plug-in cleans the directories containing generated resources during the clean phase: 

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-clean-plugin</artifactId>
  <version>3.1.0</version>
  <configuration>
    <filesets>
		<fileset>
			<directory>${basedir}/../my.mavenized.herolanguage/src-gen/</directory>
			<includes>
				<include>**/*</include>
			</includes>
		</fileset>
		<fileset>
			<directory>${basedir}/../my.mavenized.herolanguage.tests/src-gen/</directory>
			<includes>
				<include>**/*</include>
			</includes>
		</fileset>
		<fileset>
			<directory>${basedir}/../my.mavenized.herolanguage.ide/src-gen/</directory>
			<includes>
				<include>**/*</include>
			</includes>
		</fileset>
		<fileset>
			<directory>${basedir}/../my.mavenized.herolanguage.ui/src-gen/</directory>
			<includes>
				<include>**/*</include>
			</includes>
		</fileset>
		<fileset>
			<directory>${basedir}/../my.mavenized.herolanguage.ui.tests/src-gen/</directory>
			<includes>
				<include>**/*</include>
			</includes>
		</fileset>
		<fileset>
			<directory>${basedir}/model/generated/</directory>
		</fileset>
    </filesets>
  </configuration>
</plugin>
```

### The ui language project (my.mavenized.herolanguage.ui)

Here all code that is specific to eclipse is located. All the additions that you place for the UI of the language, all editors, wizards and preferences, are to be placed inside this project. Regarding the maven build the `pom.xml` is not very special.

### The tests language project (my.mavenized.herolanguage.tests)

To separate the testing code from the application you should place all your unit tests into this project. The `pom.xml` includes the `tycho-surefire-plugin` for the testing but nothing special apart.


## Integration in Standard Maven Builds {#standalone-build}

Now that we can build our language we need to be able to integrate our language compiler in the integration build of application projects. For this purpose a dedicated maven-plugin is available in Maven central. We now refer to the project `example-project`, which is a standard Java-project that shouldn't contain any Eclipse plug-in specific information, nor should it be built with Tycho. Let's have a look at the pom.xml and therein the Xtext plug-in.

```xml
<plugin>
	<groupId>org.eclipse.xtext</groupId>
	<artifactId>xtext-maven-plugin</artifactId>
	<version>${xtext-version}</version>
	<executions>
		<execution>
			<goals>
				<goal>generate</goal>
			</goals>
		</execution>
	</executions>
	<configuration>
		<languages>
			<language>
				<setup>my.mavenized.HeroLanguageStandaloneSetup</setup>
				<outputConfigurations>
					<outputConfiguration>
						<outputDirectory>src/main/generated-sources/xtend/</outputDirectory>
					</outputConfiguration>
				</outputConfigurations>
			</language>
		</languages>
	</configuration>
	<dependencies>
		<dependency>
			<groupId>my.mavenized.herolanguage</groupId>
			<artifactId>my.mavenized.herolanguage</artifactId>
			<version>1.0.0-SNAPSHOT</version>
		</dependency>
	</dependencies>
</plugin>
```

You may add multiple languages in the languages section. A language will use the default outputConfiguration, but you can override the different properties just as you can do within Eclipse preferences. 

## Maven Tycho Hints

Tycho allows you to resolve project dependencies against existing p2 repositories. There are two ways to define target p2 repositories in a Tycho build. The first way is to define the repository URLs directly in the `pom.xml` using maven `<repositories>` section. The p2 repositories need to be marked with layout=p2.
The second way is to use eclipse [target platform files](https://wiki.eclipse.org/Tycho/Target_Platform#Target_files). This approach is much faster, because the target platform resolution is performed only once, while the repository look-ups have to be done for every module. Using the target platform will drastically reduce the build time, especially in bigger projects with a lot of modules.

To further speed up the p2 dependency resolution step, use the concrete build repository instead of a project's repository or the huge [eclipse common]({{page.upsite.eclipse}}releases/photon/) composite repository. In the table below you can find p2 repository URLs for Xtext releases and their dependencies. Versions in parentheses represent the minimal required versions.

| Xtext         | EMF           | MWE2/MWE    | Xpand       | Eclipse     | All included in |
| ------------- | ------------- | ----------- | ----------- | ----------- | ----------- |
| [2.17.0]({{page.upsite.xtext}}releases/2.17.0/)           | [2.17.0]({{page.upsite.eclipse}}modeling/emf/emf/builds/release/2.17) (2.12.0)     | [2.10.0]({{page.upsite.mwe}}releases/2.10.0/) (2.9.1) | [2.2.0]({{page.upsite.xpand}}releases/R201605260315) (1.4)  | [4.11.0]({{page.upsite.eclipse}}releases/2019-03) (4.7.3) | [2019-03]({{page.upsite.eclipse}}releases/2019-03)|
| [2.16.0]({{page.upsite.xtext}}releases/2.16.0/)           | [2.16.0]({{page.upsite.eclipse}}modeling/emf/emf/builds/release/2.16) (2.12.0)     | [2.9.0]({{page.upsite.mwe}}releases/2.9.0/) (2.7.1) | [2.2.0]({{page.upsite.xpand}}releases/R201605260315) (1.4)  | [4.10.0]({{page.upsite.eclipse}}releases/2018-12/201812191000) (4.7.3) | [2018-12]({{page.upsite.eclipse}}releases/2018-12/201812191000)|
| [2.15.0]({{page.upsite.xtext}}releases/2.15.0/)           | [2.15.0]({{page.upsite.eclipse}}modeling/emf/emf/builds/release/2.15) (2.12.0)     | [2.9.0]({{page.upsite.mwe}}releases/2.9.0/) (2.7.1) | [2.2.0]({{page.upsite.xpand}}releases/R201605260315) (1.4)  | [4.9.0]({{page.upsite.eclipse}}releases/2018-09/201809191002) (4.7.3) | [2018-09]({{page.upsite.eclipse}}releases/2018-09/201809191002)|
| [2.14.0]({{page.upsite.xtext}}releases/2.14.0/)           | [2.14.0]({{page.upsite.eclipse}}modeling/emf/emf/builds/release/2.14) (2.12.0)     | [2.9.0]({{page.upsite.mwe}}releases/2.9.0/) (2.7.1) | [2.2.0]({{page.upsite.xpand}}releases/R201605260315) (1.4)  | [4.8.0]({{page.upsite.eclipse}}releases/photon/201806271001) (4.7.3) | [Photon]({{page.upsite.eclipse}}releases/photon/201806271001)|
| [2.13.0]({{page.upsite.xtext}}releases/2.13.0/)           | [2.13.0]({{page.upsite.eclipse}}modeling/emf/emf/builds/release/2.13) (2.12.0)     | [2.9.0]({{page.upsite.mwe}}releases/2.9.0/) (2.7.1) | [2.2.0]({{page.upsite.xpand}}releases/R201605260315) (1.4)  | [4.7.3]({{page.upsite.eclipse}}releases/oxygen/201804111000) (3.6) | [Oxygen]({{page.upsite.eclipse}}releases/oxygen/201804111000)|
| [2.12.0]({{page.upsite.xtext}}releases/2.12.0/)           | [2.13.0]({{page.upsite.eclipse}}modeling/emf/emf/builds/release/2.13) (2.12.0)     | [2.9.0]({{page.upsite.mwe}}releases/2.9.0/) (2.7.1) | [2.2.0]({{page.upsite.xpand}}releases/R201605260315) (1.4)  | [4.7.3]({{page.upsite.eclipse}}releases/oxygen/201804111000) (3.6) | [Oxygen]({{page.upsite.eclipse}}releases/oxygen/201804111000)|
| [2.11.0]({{page.upsite.xtext}}releases/2.11.0/)           | [2.12.0]({{page.upsite.eclipse}}releases/neon/201606221000) (2.12.0)     | [2.9.0]({{page.upsite.mwe}}releases/2.9.0/) (2.7.1) | [2.2.0]({{page.upsite.xpand}}releases/R201605260315) (1.4)  | [4.6.0]({{page.upsite.eclipse}}eclipse/updates/4.6/R-4.6-201606061100) (3.6) | [Neon*]({{page.upsite.eclipse}}releases/neon/201606221000)|
| [2.10.0]({{page.upsite.xtext}}releases/2.10.0/)           | [2.12.0]({{page.upsite.eclipse}}releases/neon/201606221000) (2.12.0)     | [2.9.0]({{page.upsite.mwe}}releases/2.9.0/) (2.7.1) | [2.2.0]({{page.upsite.xpand}}releases/R201605260315) (1.4)  | [4.6.0]({{page.upsite.eclipse}}eclipse/updates/4.6/R-4.6-201606061100) (3.6) | [Neon]({{page.upsite.eclipse}}releases/neon/201606221000)|
| [2.9.1]({{page.upsite.xtext}}releases/2.9.1/) 					| [2.11.1]({{page.upsite.emf}}2.11.x/core/) (2.10.2)  	 | [2.8.3]({{page.upsite.mwe}}releases/2.8.3/) (2.7.1) | [2.1.0]({{page.upsite.xpand}}releases/R201505260349) (1.4)  | [4.5.2]({{page.upsite.eclipse}}eclipse/updates/4.5-M-builds/) (3.6) | [Mars SR2*]({{page.upsite.eclipse}}releases/mars/)|
| [2.8.4]({{page.upsite.xtext}}releases/2.8.4/) 					| [2.11.1]({{page.upsite.emf}}2.11.x/core/) (2.10.2)  	 | [2.8.1]({{page.upsite.mwe}}releases/2.8.1/) (2.7.1) | [2.1.0]({{page.upsite.xpand}}releases/R201505260349) (1.4)  | [4.5.1]({{page.upsite.eclipse}}eclipse/updates/4.5/R-4.5-201506032000/) (3.6) | [Mars SR1]({{page.upsite.eclipse}}releases/mars/)|
| [2.8.3]({{page.upsite.xtext}}releases/2.8.3/), [2.8.2]({{page.upsite.xtext}}releases/2.8.2/), [2.8.1]({{page.upsite.xtext}}releases/2.8.1/) | [2.11.0]({{page.upsite.emf}}2.11/core/R201506010402/) (2.10.2)  	 | [2.8.0]({{page.upsite.mwe}}releases/2.8.0/) (2.7.1) | [2.1.0]({{page.upsite.xpand}}releases/R201505260349) (1.4)  | [4.5.0]({{page.upsite.eclipse}}eclipse/updates/4.5/R-4.5-201506032000/) (3.6) | [Mars R]({{page.upsite.eclipse}}releases/mars/201506241002/)|
| [2.7.3]({{page.upsite.xtext}}releases/maintenance/R201411190455/) | [2.10.2]({{page.upsite.emf}}2.10.x/core/S201501230452/) (2.10) | [2.7.0]({{page.upsite.mwe}}releases/R201409021051/mwe2lang/) [1.3.4]({{page.upsite.mwe}}releases/R201409021027/mwe) (2.7.0/1.2)  | [2.0.0]({{page.upsite.xpand}}releases/R201406030414) (1.4) | [4.4.2]({{page.upsite.eclipse}}eclipse/updates/4.4/R-4.4.2-201502041700) (3.6) |[Luna SR2]({{page.upsite.eclipse}}releases/luna/201502271000/)|

The following is an example target platform definition for Xtext 2.17.0 and Eclipse 4.11 alias 2019-03.

```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<?pde version="3.8"?>
<target name="org.xtext.myxtextlanguage.target" sequenceNumber="1">
<locations>
  <location includeAllPlatforms="false" includeConfigurePhase="false" includeMode="planner" includeSource="false" type="InstallableUnit">
    <unit id="org.eclipse.xtext.sdk.feature.group" version="0.0.0"/>
    <repository location="http://download.eclipse.org/modeling/tmf/xtext/updates/releases/2.17.0/"/>
  </location>
  <location includeAllPlatforms="false" includeConfigurePhase="false" includeMode="planner" includeSource="false" type="InstallableUnit">
    <unit id="org.eclipse.jdt.feature.group" version="0.0.0"/>
    <unit id="org.eclipse.platform.feature.group" version="0.0.0"/>
    <unit id="org.eclipse.pde.feature.group" version="0.0.0"/>
    <unit id="org.eclipse.draw2d.feature.group" version="0.0.0"/>
    <unit id="org.eclipse.emf.sdk.feature.group" version="0.0.0"/>
    <unit id="org.eclipse.xpand" version="0.0.0"/>
    <unit id="org.eclipse.xtend" version="0.0.0"/>
    <unit id="org.eclipse.xtend.typesystem.emf" version="0.0.0"/>
    <unit id="org.eclipse.emf.mwe2.launcher.feature.group" version="0.0.0"/>
    <repository location="http://download.eclipse.org/releases/2019-03/"/>
  </location>
</locations>
</target>
```
