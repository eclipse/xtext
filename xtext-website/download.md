---
layout: download
title: Download
---

Installation Instructions
=========================

Eclipse Xtext is implemented in Java, so you must have a [Java Runtime Environment](http://www.oracle.com/technetwork/java/index.html) installed in order to proceed.

There are two easy ways to get Xtext up and running. A pre-configured Eclipse distribution is available which has already all the necessary plug-ins installed. Alternatively, you can install Xtext into your existing Eclipse by means of the Eclipse update mechanism.

Install Pre-Configured Eclipse With Xtext
-----------------------------------------

 * Download the distribution from above that matches your OS.
 * Unzip the archive into the directory of your choice.

   **Windows Users should choose a directory close to the root since the zip contains a deeply nested folder structure. The maximum path length on windows may not exceed 256 characters.**
 * Launch Eclipse and select the workspace location. A workspace location is the directory for your user data and project files.

Install Xtext From Update Site
------------------------------

If you have an Eclipse running :

 * Choose **Help -&gt; Install New Software...** from the menu bar and **Add...**. 

   Insert one of the update site URLs from above. This site aggregates all the necessary and optional components and dependencies of Xtext.
 * Select the **Xtext SDK** from the category **Xtext** and complete the wizard by clicking the **Next** button until you can click **Finish**.
 * After a quick download and a restart of Eclipse, Xtext is ready to use.

Note: Xtext relies on the Antlr generator library. Unfortunately, we cannot provide this library on the official Eclipse release update sites. Instead, Xtext will try to download it on demand. To avoid this, you can manually install the feature *Xtext Antlr* from the itemis update site [http://download.itemis.com/updates/](http://download.itemis.com/updates/). The general installation procedures are not affected by this issue.



