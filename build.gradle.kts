plugins {
    kotlin("jvm") version "1.2.21" 
    idea
    maven
    application
}

repositories {
    jcenter() 
    mavenCentral()
    maven {  setUrl("https://dl.bintray.com/kotlin/exposed")  }
}

dependencies {
    implementation(kotlin("stdlib", "1.2.21")) 
    testImplementation("junit:junit:4.12") 
    compile("khttp:khttp:0.1.0")
    compile("com.google.code.gson:gson:2.8.0")
    compile("org.jetbrains.exposed:exposed:0.9.1")
    compile("org.postgresql:postgresql:42.2.1")
    compile("com.natpryce:konfig:version=1.6.2.1")
}

application {
    mainClassName = "org.osrsxp.toolkit.ToolKit"
}
