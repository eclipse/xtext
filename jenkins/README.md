Automatic Jenkins configuration
===============================

This maintains our Jenkins jobs using a small set of templates.

After you make your changes, run ```./gradlew dumpJenkinsItems```. You can then see the resulting job.xml files in the build directory.
To compare them with the current server state run ```./gradlew dumpRemoteJenkinsItems``` to get the configuration from server.

Once you are satisfied with your change, run ```./gradlew updateJenkinsItems```