plugins {
    kotlin("jvm") version "1.2.21" 
    idea
}

repositories {
    jcenter() 
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib", "1.2.21")) 
    testImplementation("junit:junit:4.12") 
    compile("khttp:khttp:0.1.0")
    compile("com.google.code.gson:gson:2.8.0")
}

