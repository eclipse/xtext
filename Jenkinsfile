pipeline {
  agent {
    kubernetes {
      label 'centos-7'
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
       'adoptopenjdk-hotspot-jdk8-latest', 'adoptopenjdk-hotspot-jdk11-latest', 'adoptopenjdk-hotspot-latest'
    ])
  }

  options {
    buildDiscarder(logRotator(numToKeepStr:'5'))
    disableConcurrentBuilds()
    timeout(time: 90, unit: 'MINUTES')
  }

  tools {
     maven "apache-maven-latest"
     jdk "${params.JDK_VERSION}"
  }

  // Build stages
  stages {
    stage('Checkout') {
      steps {
        checkout scm
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
