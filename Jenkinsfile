pipeline {
  agent {
    kubernetes {
      inheritFrom 'centos-8'
    }
  }
  
  environment {
    npm_config_cache=".npm"
    NPM_CONFIG_USERCONFIG=".config"
    NO_UPDATE_NOTIFIER="true"
    GRADLE_USER_HOME = "$WORKSPACE/.gradle" // workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=564559
  }

  parameters {
    // see https://wiki.eclipse.org/Jenkins#JDK
    choice(name: 'JDK_VERSION', description: 'Which JDK should be used?', choices: [
       'temurin-jdk11-latest', 'temurin-jdk17-latest'
    ])
  }

  options {
    buildDiscarder(logRotator(numToKeepStr:'5'))
    disableConcurrentBuilds()
    timeout(time: 90, unit: 'MINUTES')
  }

  tools {
     maven "apache-maven-3.8.6"
     jdk "${params.JDK_VERSION}"
  }

  // Build stages
  stages {
    stage('Initialize') {
      steps {
        checkout scm
        
        script {
          currentBuild.displayName = String.format("#%s(JDK%s)", BUILD_NUMBER, javaVersion())
        }
      }
    }

    stage('Gradle Build') {
      steps {
        sh './1-gradle-build.sh'
      }
    }
  }

  post {
    always {
      junit testResults: '**/build/test-results/test/*.xml'
    }
    success {
      archiveArtifacts artifacts: 'build/maven-repository/**, org.eclipse.xtext.web.example.jetty/build/libs/test-files.zip'
    }
    cleanup {
      script {
        def curResult = currentBuild.currentResult
        def lastResult = 'NEW'
        if (currentBuild.previousBuild != null) {
          lastResult = currentBuild.previousBuild.result
        }

        if (curResult != 'SUCCESS' || lastResult != 'SUCCESS') {
          def color = ''
          switch (curResult) {
            case 'SUCCESS':
              color = '#00FF00'
              break
            case 'UNSTABLE':
              color = '#FFFF00'
              break
            case 'FAILURE':
              color = '#FF0000'
              break
            default: // e.g. ABORTED
              color = '#666666'
          }

          slackSend (
            message: "${lastResult} => ${curResult}: <${env.BUILD_URL}|${env.JOB_NAME}#${env.BUILD_NUMBER}>",
            botUser: true,
            channel: 'xtext-builds',
            color: "${color}"
          )
        }
      }
    }
  }
}

/** return the Java version as Integer (8, 11, ...) */
def javaVersion() {
  return Integer.parseInt(params.JDK_VERSION.replaceAll(".*-jdk(\\d+).*", "\$1"))
}

