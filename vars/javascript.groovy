def call(Map config=[:], Closure body) {
    node {
        git url: "https://github.com/rxa80330/jenkins-shared-libraries.git"
        stage("Install") {
            bat "npm install"
        }
        stage("Test") {
            bat "npm test"
        }
        stage("Deploy") {
            if (config.deploy) {
                bat "npm publish"
            }
        }
        body()
    }
}
